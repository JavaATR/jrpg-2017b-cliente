package estados;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
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
import juego.Pantalla;
import mensajeria.Comando;
import mensajeria.PaqueteAtacar;
import mensajeria.PaqueteBatalla;
import mensajeria.PaqueteEnemigo;
import mensajeria.PaqueteFinalizarBatalla;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;

public class EstadoBatalla extends Estado {

	private Mundo mundo;
	private Personaje personaje;
	private Personaje enemigo;
	private NonPlayableCharacter enemigoNPC;
	private int[] posMouse;
	private PaquetePersonaje paquetePersonaje;
	private PaquetePersonaje paqueteEnemigo;
	private PaqueteEnemigo paqueteEnemigoNPC;
	private PaqueteAtacar paqueteAtacar;
	private PaqueteFinalizarBatalla paqueteFinalizarBatalla;
	private boolean miTurno;
	private int esEnemigoNPC = 0;

	private boolean haySpellSeleccionada;
	private boolean seRealizoAccion;

	private Gson gson = new Gson();

	private BufferedImage miniaturaPersonaje;
	private BufferedImage miniaturaEnemigo;

	private MenuBatalla menuBatalla;

	public EstadoBatalla(Juego juego, PaqueteBatalla paqueteBatalla) {
		super(juego);
		mundo = new Mundo(juego, "recursos/mundoBatalla.txt", "recursos/mundoBatallaCapaDos.txt");
		miTurno = paqueteBatalla.isMiTurno();

		paquetePersonaje = juego.getPersonajesConectados().get(paqueteBatalla.getId());
		
		if (paqueteBatalla.getIdEnemigo() < 0) {
			esEnemigoNPC = 1;
			int key;
			PaqueteEnemigo actual;
			
			Iterator<Integer> it = juego.getEnemigosConectados().keySet().iterator();
			
			while (it.hasNext()) {
				key = it.next();
				actual = juego.getEnemigosConectados().get(key);
				
				if (paqueteBatalla.getIdEnemigo() == actual.getId()) {
					paqueteEnemigoNPC = juego.getEnemigosConectados().get(key);
					
					break;
				}
			}
		}
		else {
			paqueteEnemigo = juego.getPersonajesConectados().get(paqueteBatalla.getIdEnemigo());
		}

		crearPersonajes(esEnemigoNPC);

		menuBatalla = new MenuBatalla(miTurno, personaje);

		miniaturaPersonaje = Recursos.personaje.get(personaje.getNombreRaza()).get(5)[0];
		
		if (paqueteBatalla.getIdEnemigo() < 0)
			miniaturaEnemigo = Recursos.personaje.get("El Bryan").get(6)[0];
		else
			miniaturaEnemigo = Recursos.personaje.get(enemigo.getNombreRaza()).get(5)[0];

		paqueteFinalizarBatalla = new PaqueteFinalizarBatalla();
		paqueteFinalizarBatalla.setId(personaje.getIdPersonaje());
		paqueteFinalizarBatalla.setIdEnemigo(paqueteBatalla.getIdEnemigo());

		// por defecto batalla perdida
		juego.getEstadoJuego().setHaySolicitud(true, juego.getPersonaje(), MenuInfoPersonaje.menuPerderBatalla);

		// limpio la accion del mouse
		juego.getHandlerMouse().setNuevoClick(false);
	}

	@Override
	public void actualizar() {
		juego.getCamara().setxOffset(-350);
		juego.getCamara().setyOffset(150);

		seRealizoAccion = false;
		haySpellSeleccionada = false;

		if (miTurno) {
			if (juego.getHandlerMouse().getNuevoClick()) {
				posMouse = juego.getHandlerMouse().getPosMouse();

				if (menuBatalla.clickEnMenu(posMouse[0], posMouse[1])) {

					if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == 1) {
						if(personaje.puedeAtacar()){
							seRealizoAccion = true;
							
							if (enemigoNPC != null)
								personaje.habilidadRaza1(enemigoNPC);
							else
								personaje.habilidadRaza1(enemigo);
						}
						haySpellSeleccionada = true;
					}

					if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == 2) {
						if(personaje.puedeAtacar()){
							seRealizoAccion = true;
							
							if (enemigoNPC != null)
								personaje.habilidadRaza2(enemigoNPC);
							else
								personaje.habilidadRaza2(enemigo);
						}
						haySpellSeleccionada = true;
					}

					if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == 3) {
						if(personaje.puedeAtacar()){
							seRealizoAccion = true;
							
							if (enemigoNPC != null)
								personaje.habilidadCasta1(enemigoNPC);
							else
								personaje.habilidadCasta1(enemigo);
						}
						haySpellSeleccionada = true;
					}

					if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == 4) {
						if(personaje.puedeAtacar()){
							seRealizoAccion = true;
							
							if (enemigoNPC != null)
								personaje.habilidadCasta2(enemigoNPC);
							else
								personaje.habilidadCasta2(enemigo);
						}
						haySpellSeleccionada = true;
					}

					if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == 5) {
						if(personaje.puedeAtacar()){
							seRealizoAccion = true;
							
							if (enemigoNPC != null)
								personaje.habilidadCasta3(enemigoNPC);
							else
								personaje.habilidadCasta3(enemigo);
						}
						haySpellSeleccionada = true;
					}

					if (menuBatalla.getBotonClickeado(posMouse[0], posMouse[1]) == 6) {
						seRealizoAccion = true;
						personaje.serEnergizado(10);
						haySpellSeleccionada = true;
					}
				}

				if (haySpellSeleccionada && seRealizoAccion) {
					int nivelEnemigo;
					Boolean enemigoEstaVivo;
					
					if (enemigoNPC != null) {
						nivelEnemigo = enemigoNPC.getNivel();
						enemigoEstaVivo = enemigoNPC.estaVivo();
					}
					else {
						nivelEnemigo = enemigo.getNivel();
						enemigoEstaVivo = enemigo.estaVivo();
					}
					
					if (enemigoEstaVivo == false) {
						juego.getEstadoJuego().setHaySolicitud(true, juego.getPersonaje(), MenuInfoPersonaje.menuGanarBatalla);
						if(personaje.ganarExperiencia(nivelEnemigo * 40)){
							juego.getPersonaje().setNivel(personaje.getNivel());
							juego.getEstadoJuego().setHaySolicitud(true, juego.getPersonaje(), MenuInfoPersonaje.menuSubirNivel);
						}
						paqueteFinalizarBatalla.setGanadorBatalla(juego.getPersonaje().getId());
						finalizarBatalla();
						Estado.setEstado(juego.getEstadoJuego());
					} else {
						if (enemigoNPC != null) {
							paqueteAtacar = new PaqueteAtacar(paquetePersonaje.getId(), paqueteEnemigoNPC.getId(), personaje.getSalud(), personaje.getEnergia(), enemigoNPC.getSalud(), 100, personaje.getDefensa(), enemigoNPC.getDefensa(), 0, 0);
							enemigoNPC.setSalud(enemigoNPC.getSalud() - personaje.calcularPuntosDeAtaque()) ;
						}
						else
							paqueteAtacar = new PaqueteAtacar(paquetePersonaje.getId(), paqueteEnemigo.getId(), personaje.getSalud(), personaje.getEnergia(), enemigo.getSalud(), enemigo.getEnergia(), personaje.getDefensa(), enemigo.getDefensa(), personaje.getCasta().getProbabilidadEvitarDaño(), enemigo.getCasta().getProbabilidadEvitarDaño());
						
						enviarAtaque(paqueteAtacar);
						miTurno = false;
						menuBatalla.setHabilitado(false);
					}
				} else if(haySpellSeleccionada && !seRealizoAccion){
					JOptionPane.showMessageDialog(null, "No posees la energía suficiente para realizar esta habilidad.");
				}

				juego.getHandlerMouse().setNuevoClick(false);
			}
		}
		// Si no es mi turno y estoy en batalla contra un NPC, El Bryan nos ataca
		else if (enemigoNPC != null) {
			paqueteAtacar = new PaqueteAtacar(paqueteEnemigoNPC.getId(), paquetePersonaje.getId(), enemigoNPC.getSalud(), enemigoNPC.getEnergia(), personaje.getSalud() - 10, personaje.getEnergia(), enemigoNPC.getDefensa(), personaje.getDefensa(), 0, 0);
			enviarAtaque(paqueteAtacar);
			enemigoNPC.setEnergia(enemigoNPC.getEnergia() - 10);
			
			miTurno = true;
			menuBatalla.setHabilitado(true);
		}
	}

	@Override
	public void graficar(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, juego.getAncho(), juego.getAlto());
		mundo.graficar(g);

		g.drawImage(Recursos.personaje.get(paquetePersonaje.getRaza()).get(3)[0], 0, 175, 256, 256, null);
		
		if (enemigoNPC != null)
			g.drawImage(Recursos.personaje.get("El Bryan").get(7)[0], 550, 75, 256, 256, null);
		else
			g.drawImage(Recursos.personaje.get(paqueteEnemigo.getRaza()).get(7)[0], 550, 75, 256, 256, null);

		mundo.graficarObstaculos(g);
		menuBatalla.graficar(g);

		g.setColor(Color.GREEN);

		EstadoDePersonaje.dibujarEstadoDePersonaje(g, 25, 5, personaje, miniaturaPersonaje);
		
		if (enemigoNPC != null)
			EstadoDePersonaje.dibujarEstadoDeEnemigo(g, 550, 5, enemigoNPC, miniaturaEnemigo);
		else
			EstadoDePersonaje.dibujarEstadoDePersonaje(g, 550, 5, enemigo, miniaturaEnemigo);
	}

	private void crearPersonajes(int esEnemigoNPC) {
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
			casta = (Casta) Class.forName("dominio" + "." + paquetePersonaje.getCasta()).newInstance();
			personaje = (Personaje) Class.forName("dominio" + "." + paquetePersonaje.getRaza()).getConstructor(String.class, Integer.TYPE, 
					Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Casta.class, Integer.TYPE, Integer.TYPE, Integer.TYPE).
					newInstance(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
							experiencia, nivel, id);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			JOptionPane.showMessageDialog(null, "Error al crear la batalla");
		}
		
		if (esEnemigoNPC == 1) {
			enemigoNPC = new NonPlayableCharacter("El Bryan", 3, 3);
		}
		else {
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
			} else if (paqueteEnemigo.getCasta().equals("Hechicero")) {
				casta = new Hechicero();
			} else if (paqueteEnemigo.getCasta().equals("Asesino")) {
				casta = new Asesino();
			}
	
			if (paqueteEnemigo.getRaza().equals("Humano")) {
				enemigo = new Humano(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
						experiencia, nivel, id);
			} else if (paqueteEnemigo.getRaza().equals("Orco")) {
				enemigo = new Orco(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
						experiencia, nivel, id);
			} else if (paqueteEnemigo.getRaza().equals("Elfo")) {
				enemigo = new Elfo(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
						experiencia, nivel, id);
			}
		}
	}

	public void enviarAtaque(PaqueteAtacar paqueteAtacar) {
		try {
			juego.getCliente().getSalida().writeObject(gson.toJson(paqueteAtacar));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fallo la conexion con el servidor.");
		}
	}

	private void finalizarBatalla() {
		try {
			juego.getCliente().getSalida().writeObject(gson.toJson(paqueteFinalizarBatalla));

			paquetePersonaje.setSaludTope(personaje.getSaludTope());
			paquetePersonaje.setEnergiaTope(personaje.getEnergiaTope());
			paquetePersonaje.setNivel(personaje.getNivel());
			paquetePersonaje.setExperiencia(personaje.getExperiencia());
			paquetePersonaje.setDestreza(personaje.getDestreza());
			paquetePersonaje.setFuerza(personaje.getFuerza());
			paquetePersonaje.setInteligencia(personaje.getInteligencia());
			paquetePersonaje.removerBonus();

			paqueteEnemigo.setSaludTope(enemigo.getSaludTope());
			paqueteEnemigo.setEnergiaTope(enemigo.getEnergiaTope());
			paqueteEnemigo.setNivel(enemigo.getNivel());
			paqueteEnemigo.setExperiencia(enemigo.getExperiencia());
			paqueteEnemigo.setDestreza(enemigo.getDestreza());
			paqueteEnemigo.setFuerza(enemigo.getFuerza());
			paqueteEnemigo.setInteligencia(enemigo.getInteligencia());
			paqueteEnemigo.removerBonus();

			paquetePersonaje.setComando(Comando.ACTUALIZARPERSONAJE);
			paqueteEnemigo.setComando(Comando.ACTUALIZARPERSONAJE);

			juego.getCliente().getSalida().writeObject(gson.toJson(paquetePersonaje));
			juego.getCliente().getSalida().writeObject(gson.toJson(paqueteEnemigo));
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Fallo la conexión con el servidor");
		}
	}

	public PaquetePersonaje getPaquetePersonaje() {
		return paquetePersonaje;
	}

	public PaquetePersonaje getPaqueteEnemigo() {
		return paqueteEnemigo;
	}

	public void setMiTurno(boolean b) {
		miTurno = b;
		menuBatalla.setHabilitado(b);
		juego.getHandlerMouse().setNuevoClick(false);
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public Personaje getEnemigo() {
		return enemigo;
	}
	
	public NonPlayableCharacter getEnemigoNPC() {
		return enemigoNPC;
	}
	
	@Override
	public boolean esEstadoDeJuego() {
		return false;
	}
}