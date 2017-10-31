package estados;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import dominio.Asesino;
import dominio.Casta;
import dominio.Elfo;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.NonPlayableCharacter;
import dominio.Orco;
import dominio.Personaje;
import interfaz.EstadoDePersonaje;
import interfaz.MenuBatalla;
import interfaz.MenuInfoPersonaje;
import juego.Juego;
import mensajeria.Comando;
import mensajeria.PaqueteAtacar;
import mensajeria.PaqueteBatalla;
import mensajeria.PaqueteEnemigo;
import mensajeria.PaqueteFinalizarBatalla;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;

/**
 * Clase que administra el estado de batalla. <br>
 */
public class EstadoBatalla extends Estado {
	private static final int Y_OFFSET = 150;
	private static final int X_OFFSET = -350;
	/**
	 * Mundo del juego. <br>
	 */
	private Mundo mundo;
	/**
	 * Personaje. <br>
	 */
	private Personaje personaje;
	/**
	 * Enemigo. <br>
	 */
	private Personaje enemigo;
	/**
	 * NPC. <br>
	 */
	private NonPlayableCharacter enemigoNPC;
	/**
	 * Posición del mouse. <br>
	 */
	private int[] posMouse;
	/**
	 * Personaje del cliente. <br>
	 */
	private PaquetePersonaje paquetePersonaje;
	/**
	 * Personaje enemigo de otro cliente. <br>
	 */
	private PaquetePersonaje paqueteEnemigo;
	/**
	 * NPC del juego. <br>
	 */
	private PaqueteEnemigo paqueteEnemigoNPC;
	/**
	 * Comandos de ataque. <br>
	 */
	private PaqueteAtacar paqueteAtacar;
	/**
	 * Comandos de finalizar batalla. <br>
	 */
	private PaqueteFinalizarBatalla paqueteFinalizarBatalla;
	/**
	 * Indicador de turno. <br>
	 */
	private boolean miTurno;
	/**
	 * NPC algo. <br>
	 */
	private int esEnemigoNPC = 0;
	/**
	 * Indicador de spell seleccionado. <br>
	 */
	private boolean haySpellSeleccionada;
	/**
	 * Indicador de acción realizada. <br>
	 */
	private boolean seRealizoAccion;
	/**
	 * Gson. <br>
	 */
	private Gson gson = new Gson();
	/**
	 * Miniatura del personaje. <br>
	 */
	private BufferedImage miniaturaPersonaje;
	/**
	 * Miniatura del enemigo. <br>
	 */
	private BufferedImage miniaturaEnemigo;
	/**
	 * Menú de batalla. <br>
	 */
	private MenuBatalla menuBatalla;
	/**
	 * Posición del personje. <br>
	 */
	private static final int POSICION_PERSONAJE = 25;
	/**
	 * Posición del enemigo. <br>
	 */
	private static final int POSICION_ENEMIGO = 550;
	/**
	 * Cinco
	 */
	private static final int CINCO = 5;
	/**
	 * Diez. <br>
	 */
	private static final int DIEZ = 10;
	/**
	 * Cien. <br>
	 */
	private static final int CIEN = 100;
	/**
	 * Doscientos cincuenta y seis. <br>
	 */
	private static final int DOSCINCUENTAYSEIS = 256;

	/**
	 * Crea un estado de batalla. <br>
	 *
	 * @param juego
	 *            Juego del cliente. <br>
	 * @param paqueteBatalla
	 *            Paquete de batalla del cliente. <br>
	 */
	public EstadoBatalla(final Juego juego,
			final PaqueteBatalla paqueteBatalla) {
		super(juego);
		mundo = new Mundo(juego, "recursos/mundoBatalla.txt",
				"recursos/mundoBatallaCapaDos.txt");
		miTurno = paqueteBatalla.isMiTurno();
		paquetePersonaje = juego.getPersonajesConectados()
				.get(paqueteBatalla.getId());
		if (paqueteBatalla.getIdEnemigo() < 0) {
			esEnemigoNPC = 1;
			int key;
			PaqueteEnemigo actual;
			Iterator<Integer> it = juego.getEnemigosConectados().keySet()
					.iterator();
			while (it.hasNext()) {
				key = it.next();
				actual = juego.getEnemigosConectados().get(key);
				if (paqueteBatalla.getIdEnemigo() == actual.getId()) {
					paqueteEnemigoNPC = juego.getEnemigosConectados().get(key);
					break;
				}
			}
		} else {
			paqueteEnemigo = juego.getPersonajesConectados()
					.get(paqueteBatalla.getIdEnemigo());
		}
		crearPersonajes(esEnemigoNPC);
		menuBatalla = new MenuBatalla(miTurno, personaje);
		miniaturaPersonaje = Recursos.personaje.get(personaje.getNombreRaza())
				.get(CINCO)[0];
		if (paqueteBatalla.getIdEnemigo() < 0) {
			miniaturaEnemigo = Recursos.personaje.get("El Bryan").get(6)[0];
		} else {
			miniaturaEnemigo = Recursos.personaje.get(enemigo.getNombreRaza())
					.get(CINCO)[0];
		}
		paqueteFinalizarBatalla = new PaqueteFinalizarBatalla();
		paqueteFinalizarBatalla.setId(personaje.getIdPersonaje());
		paqueteFinalizarBatalla.setIdEnemigo(paqueteBatalla.getIdEnemigo());
		// por defecto batalla perdida
		juego.getEstadoJuego().setHaySolicitud(true, juego.getPersonaje(),
				MenuInfoPersonaje.MENU_PERDER_BATALLA);
		// limpio la accion del mouse
		juego.getHandlerMouse().setNuevoClick(false);
	}

	/**
	 * Actualiza el estado de batalla. <br>
	 */
	@Override
	public final void actualizar() {
		juego.getCamara().setxOffset(X_OFFSET);
		juego.getCamara().setyOffset(Y_OFFSET);
		seRealizoAccion = false;
		haySpellSeleccionada = false;
		if (miTurno) {
			if (juego.getHandlerMouse().getNuevoClick()) {
				posMouse = juego.getHandlerMouse().getPosMouse();
				if (menuBatalla.clickEnMenu(posMouse[0], posMouse[1])) {
					if (menuBatalla.getBotonClickeado(posMouse[0],
							posMouse[1]) == 1) {
						if (personaje.puedeAtacar()) {
							seRealizoAccion = true;
							if (enemigoNPC != null) {
								personaje.habilidadRaza1(enemigoNPC);
							} else {
								personaje.habilidadRaza1(enemigo);
							}
						}
						haySpellSeleccionada = true;
					}
					if (menuBatalla.getBotonClickeado(posMouse[0],
							posMouse[1]) == 2) {
						if (personaje.puedeAtacar()) {
							seRealizoAccion = true;
							if (enemigoNPC != null) {
								personaje.habilidadRaza2(enemigoNPC);
							} else {
								personaje.habilidadRaza2(enemigo);
							}
						}
						haySpellSeleccionada = true;
					}
					if (menuBatalla.getBotonClickeado(posMouse[0],
							posMouse[1]) == 3) {
						if (personaje.puedeAtacar()) {
							seRealizoAccion = true;
							if (enemigoNPC != null) {
								personaje.habilidadCasta1(enemigoNPC);
							} else {
								personaje.habilidadCasta1(enemigo);
							}
						}
						haySpellSeleccionada = true;
					}
					if (menuBatalla.getBotonClickeado(posMouse[0],
							posMouse[1]) == 4) {
						if (personaje.puedeAtacar()) {
							seRealizoAccion = true;
							if (enemigoNPC != null) {
								personaje.habilidadCasta2(enemigoNPC);
							} else {
								personaje.habilidadCasta2(enemigo);
							}
						}
						haySpellSeleccionada = true;
					}
					if (menuBatalla.getBotonClickeado(posMouse[0],
							posMouse[1]) == CINCO) {
						if (personaje.puedeAtacar()) {
							seRealizoAccion = true;
							if (enemigoNPC != null) {
								personaje.habilidadCasta3(enemigoNPC);
							} else {
								personaje.habilidadCasta3(enemigo);
							}
						}
						haySpellSeleccionada = true;
					}
					if (menuBatalla.getBotonClickeado(posMouse[0],
							posMouse[1]) == 6) {
						seRealizoAccion = true;
						personaje.serEnergizado(DIEZ);
						haySpellSeleccionada = true;
					}
				}
				if (haySpellSeleccionada && seRealizoAccion) {
					int nivelEnemigo;
					Boolean enemigoEstaVivo;
					if (enemigoNPC != null) {
						nivelEnemigo = enemigoNPC.getNivel();
						enemigoEstaVivo = enemigoNPC.estaVivo();
					} else {
						nivelEnemigo = enemigo.getNivel();
						enemigoEstaVivo = enemigo.estaVivo();
					}
					if (enemigoEstaVivo == false) {
						juego.getEstadoJuego().setHaySolicitud(true,
								juego.getPersonaje(),
								MenuInfoPersonaje.MENU_GANAR_BATALLA);
						if (personaje.ganarExperiencia(nivelEnemigo * 40)) {
							juego.getPersonaje().setNivel(personaje.getNivel());
							juego.getEstadoJuego().setHaySolicitud(true,
									juego.getPersonaje(),
									MenuInfoPersonaje.MENU_SUBIR_NIVEL);
						}
						paqueteFinalizarBatalla.setGanadorBatalla(
								juego.getPersonaje().getId());
						finalizarBatalla();
						Estado.setEstado(juego.getEstadoJuego());
					} else {
						if (enemigoNPC != null) {
							paqueteAtacar = new PaqueteAtacar(
									paquetePersonaje.getId(),
									paqueteEnemigoNPC.getId(),
									personaje.getSalud(),
									personaje.getEnergia(),
									enemigoNPC.getSalud(), CIEN,
									personaje.getDefensa(),
									enemigoNPC.getDefensa(), 0, 0);
							// enemigoNPC.setSalud(enemigoNPC.getSalud() -
							// personaje.calcularPuntosDeAtaque()) ;
						} else {
							paqueteAtacar = new PaqueteAtacar(
									paquetePersonaje.getId(),
									paqueteEnemigo.getId(),
									personaje.getSalud(),
									personaje.getEnergia(), enemigo.getSalud(),
									enemigo.getEnergia(),
									personaje.getDefensa(),
									enemigo.getDefensa(),
									personaje.getCasta()
											.getProbabilidadEvitarDano(),
									enemigo.getCasta()
											.getProbabilidadEvitarDano());

							enviarAtaque(paqueteAtacar);
							miTurno = false;
							menuBatalla.setHabilitado(false);
						}
					}
				} else {
					if (haySpellSeleccionada && !seRealizoAccion) {
						JOptionPane.showMessageDialog(null,
								"No posees la energía suficiente para realizar esta habilidad.");
					}
				}
				juego.getHandlerMouse().setNuevoClick(false);
			}
		}
		// Si no es mi turno y estoy en batalla contra un NPC, El Bryan nos
		// ataca
		else {
			if (enemigoNPC != null) {
				paqueteAtacar = new PaqueteAtacar(paqueteEnemigoNPC.getId(),
						paquetePersonaje.getId(), enemigoNPC.getSalud(),
						enemigoNPC.getEnergia(), personaje.getSalud() - DIEZ,
						personaje.getEnergia(), enemigoNPC.getDefensa(),
						personaje.getDefensa(), 0, 0);
				enviarAtaque(paqueteAtacar);
				enemigoNPC.setEnergia(enemigoNPC.getEnergia() - DIEZ);
				miTurno = true;
				menuBatalla.setHabilitado(true);
			}
		}
	}

	/**
	 * Grafica la batalla. <br>
	 */
	@Override
	public final void graficar(final Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, juego.getAncho(), juego.getAlto());
		mundo.graficar(g);
		g.drawImage(
				Recursos.personaje.get(paquetePersonaje.getRaza()).get(3)[0], 0,
				175, DOSCINCUENTAYSEIS, DOSCINCUENTAYSEIS, null);
		if (enemigoNPC != null) {
			g.drawImage(Recursos.personaje.get("El Bryan").get(7)[0], 550, 75,
					DOSCINCUENTAYSEIS, DOSCINCUENTAYSEIS, null);
		} else {
			g.drawImage(
					Recursos.personaje.get(paqueteEnemigo.getRaza()).get(7)[0],
					550, 75, DOSCINCUENTAYSEIS, DOSCINCUENTAYSEIS, null);
		}
		mundo.graficarObstaculos(g);
		menuBatalla.graficar(g);
		g.setColor(Color.GREEN);
		EstadoDePersonaje.dibujarEstadoDePersonaje(g, POSICION_PERSONAJE, CINCO,
				personaje, miniaturaPersonaje);
		if (enemigoNPC != null) {
			EstadoDePersonaje.dibujarEstadoDeEnemigo(g, POSICION_ENEMIGO, CINCO,
					enemigoNPC, miniaturaEnemigo);
		} else {
			EstadoDePersonaje.dibujarEstadoDePersonaje(g, POSICION_ENEMIGO,
					CINCO, enemigo, miniaturaEnemigo);
		}
	}

	/**
	 * Crea los personajes de la batalla. <br>
	 *
	 * @param esEnemigoNPC
	 *            Enemigo NPC. <br>
	 */
	private final void crearPersonajes(final int esEnemigoNPC) {
		String nombre = paquetePersonaje.getNombre();
		int salud = paquetePersonaje.getSaludTope();
		int energia = paquetePersonaje.getEnergiaTope();
		int fuerza = paquetePersonaje.getFuerza();
		int destreza = paquetePersonaje.getDestreza();
		int inteligencia = paquetePersonaje.getInteligencia();
		int experiencia = paquetePersonaje.getExperiencia();
		int nivel = paquetePersonaje.getNivel();
		int id = paquetePersonaje.getId();
		Casta casta = null;
		try {
			casta = (Casta) Class
					.forName("dominio" + "." + paquetePersonaje.getCasta())
					.newInstance();
			personaje = (Personaje) Class
					.forName("dominio" + "." + paquetePersonaje.getRaza())
					.getConstructor(String.class, Integer.TYPE, Integer.TYPE,
							Integer.TYPE, Integer.TYPE, Integer.TYPE,
							Casta.class, Integer.TYPE, Integer.TYPE,
							Integer.TYPE)
					.newInstance(nombre, salud, energia, fuerza, destreza,
							inteligencia, casta, experiencia, nivel, id);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			JOptionPane.showMessageDialog(null, "Error al crear la batalla");
		}
		if (esEnemigoNPC == 1) {
			enemigoNPC = new NonPlayableCharacter("El Bryan", 3, 3);
		} else {
			nombre = paqueteEnemigo.getNombre();
			salud = paqueteEnemigo.getSaludTope();
			energia = paqueteEnemigo.getEnergiaTope();
			fuerza = paqueteEnemigo.getFuerza();
			destreza = paqueteEnemigo.getDestreza();
			inteligencia = paqueteEnemigo.getInteligencia();
			experiencia = paqueteEnemigo.getExperiencia();
			nivel = paqueteEnemigo.getNivel();
			id = paqueteEnemigo.getId();
			casta = null;
			if (paqueteEnemigo.getCasta().equals("Guerrero")) {
				casta = new Guerrero();
			} else {
				if (paqueteEnemigo.getCasta().equals("Hechicero")) {
					casta = new Hechicero();
				} else {
					if (paqueteEnemigo.getCasta().equals("Asesino")) {
						casta = new Asesino();
					}
				}
			}
			if (paqueteEnemigo.getRaza().equals("Humano")) {
				enemigo = new Humano(nombre, salud, energia, fuerza, destreza,
						inteligencia, casta, experiencia, nivel, id);
			} else {
				if (paqueteEnemigo.getRaza().equals("Orco")) {
					enemigo = new Orco(nombre, salud, energia, fuerza, destreza,
							inteligencia, casta, experiencia, nivel, id);
				} else {
					if (paqueteEnemigo.getRaza().equals("Elfo")) {
						enemigo = new Elfo(nombre, salud, energia, fuerza,
								destreza, inteligencia, casta, experiencia,
								nivel, id);
					}
				}
			}
		}
	}

	/**
	 * Envía el ataque al otro cliente. <br>
	 *
	 * @param paqueteAtacar
	 *            Comandos de ataque del cliente. <br>
	 */
	public final void enviarAtaque(final PaqueteAtacar paqueteAtacar) {
		try {
			juego.getCliente().getSalida()
					.writeObject(gson.toJson(paqueteAtacar));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Fallo la conexion con el servidor.");
		}
	}

	/**
	 * Finaliza la batalla. <br>
	 */
	private final void finalizarBatalla() {
		try {
			juego.getCliente().getSalida()
					.writeObject(gson.toJson(paqueteFinalizarBatalla));
			paquetePersonaje.setSaludTope(personaje.getSaludTope());
			paquetePersonaje.setEnergiaTope(personaje.getEnergiaTope());
			paquetePersonaje.setNivel(personaje.getNivel());
			paquetePersonaje.setExperiencia(personaje.getExperiencia());
			paquetePersonaje.setDestreza(personaje.getDestreza());
			paquetePersonaje.setFuerza(personaje.getFuerza());
			paquetePersonaje.setInteligencia(personaje.getInteligencia());
			paquetePersonaje.removerBonus();
			paquetePersonaje.setComando(Comando.ACTUALIZARPERSONAJE);
			if (paqueteEnemigoNPC != null) {
				paqueteEnemigoNPC.setSaludTope(CIEN);
				paqueteEnemigoNPC.setEnergiaTope(50);

				// paqueteEnemigoNPC.setComando(Comando.ACTUALIZARPERSONAJE);
				// juego.getCliente().getSalida().writeObject(gson.toJson(paqueteEnemigoNPC));
			} else {
				paqueteEnemigo.setSaludTope(enemigo.getSaludTope());
				paqueteEnemigo.setEnergiaTope(enemigo.getEnergiaTope());
				paqueteEnemigo.setNivel(enemigo.getNivel());
				paqueteEnemigo.setExperiencia(enemigo.getExperiencia());
				paqueteEnemigo.setDestreza(enemigo.getDestreza());
				paqueteEnemigo.setFuerza(enemigo.getFuerza());
				paqueteEnemigo.setInteligencia(enemigo.getInteligencia());
				paqueteEnemigo.removerBonus();
				paqueteEnemigo.setComando(Comando.ACTUALIZARPERSONAJE);
				juego.getCliente().getSalida()
						.writeObject(gson.toJson(paqueteEnemigo));
			}
			juego.getCliente().getSalida()
					.writeObject(gson.toJson(paquetePersonaje));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Fallo la conexión con el servidor");
		}
	}

	/**
	 * Devuelve el personaje del cliente. <br>
	 *
	 * @return Personaje del cliente. <br>
	 */
	public final PaquetePersonaje getPaquetePersonaje() {
		return paquetePersonaje;
	}

	/**
	 * Devuelve al personaje enemigo de otro cliente. <br>
	 *
	 * @return Personaje enemigo. <br>
	 */
	public final PaquetePersonaje getPaqueteEnemigo() {
		return paqueteEnemigo;
	}

	/**
	 * Establece el turno del personaje. <br>
	 *
	 * @param b
	 *            Indicador del turno. <br>
	 */
	public final void setMiTurno(final boolean b) {
		miTurno = b;
		menuBatalla.setHabilitado(b);
		juego.getHandlerMouse().setNuevoClick(false);
	}

	/**
	 * Devuelve al personaje. <br>
	 *
	 * @return Personaje. <br>
	 */
	public final Personaje getPersonaje() {
		return personaje;
	}

	/**
	 * Devuelve al enemigo. <br>
	 *
	 * @return Enemigo. <br>
	 */
	public final Personaje getEnemigo() {
		return enemigo;
	}

	/**
	 * Devuelve al NPC. <br>
	 *
	 * @return NPC. <br>
	 */
	public final NonPlayableCharacter getEnemigoNPC() {
		return enemigoNPC;
	}

	/**
	 * Devuelve si es estado de juego normal. <br>
	 */
	@Override
	public final boolean esEstadoDeJuego() {
		return false;
	}
}
