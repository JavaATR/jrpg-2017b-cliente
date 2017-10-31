package estados;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import entidades.Entidad;
import interfaz.EstadoDePersonaje;
import interfaz.MenuInfoEnemigo;
import interfaz.MenuInfoPersonaje;
import juego.Juego;
import juego.Pantalla;
import mensajeria.Comando;
import mensajeria.PaqueteEnemigo;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;
import mundo.Mundo;
import recursos.Recursos;

/**
 * Clase que maneja el estado del juego. <br>
 */
public class EstadoJuego extends Estado {
	/**
	 * Personaje visual. <br>
	 */
	private Entidad entidadPersonaje;
	/**
	 * Personaje del cliente. <br>
	 */
	private PaquetePersonaje paquetePersonaje;
	/**
	 * Enemigo. <br>
	 */
	private PaqueteEnemigo paqueteEnemigo;
	/**
	 * Mundo actual. <br>
	 */
	private Mundo mundo;
	/**
	 * Ubicaciones de los personajes en el mundo. <br>
	 */
	private Map<Integer, PaqueteMovimiento> ubicacionPersonajes;
	/**
	 * Personajes conectados. <br>
	 */
	private Map<Integer, PaquetePersonaje> personajesConectados;
	/**
	 * Ubicación de los enemigos en el mundo. <br>
	 */
	private Map<Integer, PaqueteMovimiento> ubicacionEnemigos;
	/**
	 * Enemigos conectados. <br>
	 */
	private Map<Integer, PaqueteEnemigo> enemigosConectados;
	/**
	 * Indicador de si hay solicitud. <br>
	 */
	private boolean haySolicitud;
	/**
	 * Indicador de si hay solicitud del enemigo. <br>
	 */
	private boolean haySolicitudEnemigo;
	/**
	 * Tipo de solicitud. <br>
	 */
	private int tipoSolicitud;
	/**
	 * Gson. <br>
	 */
	private final Gson gson = new Gson();
	/**
	 * Imagen del personaje. <br>
	 */
	private BufferedImage miniaturaPersonaje;
	/**
	 * Menú del enemigo. <br>
	 */
	private MenuInfoPersonaje menuEnemigo;
	/**
	 * Menú del enemigo NPC. <br>
	 */
	private MenuInfoEnemigo menuEnemigoNPC;
	/**
	 * Tamaño del font. <br>
	 */
	private static final int FONT = 15;
	/**
	 * Mundo de Aubenor. <br>
	 */
	private static final int AUBENOR = 1;
	/**
	 * Mundo de Aris. <br>
	 */
	private static final int ARIS = 2;
	/**
	 * Mundo de Eodrim. <br>
	 */
	private static final int EODRIM = 3;
	/**
	 * Bounds X de la mochila. <br>
	 */
	private static final int MOCHILA_X = 738;
	/**
	 * Bounds Y de la mochila. <br>
	 */
	private static final int MOCHILA_Y = 545;
	/**
	 * Bounds Width de la mochila. <br>
	 */
	private static final int MOCHILA_WIDTH = 59;
	/**
	 * Bounds Height de la mochila. <br>
	 */
	private static final int MOCHILA_HEIGHT = 52;
	/**
	 * Bounds X del menú. <br>
	 */
	private static final int MENU_X = 3;
	/**
	 * Bounds Y del menú. <br>
	 */
	private static final int MENU_Y = 562;
	/**
	 * Bounds Width del menú. <br>
	 */
	private static final int MENU_WIDTH = 102;
	/**
	 * Bounds Height del menú. <br>
	 */
	private static final int MENU_HEIGHT = 35;
	/**
	 * Bounds X del chat. <br>
	 */
	private static final int CHAT_X = 3;
	/**
	 * Bounds Y del chat. <br>
	 */
	private static final int CHAT_Y = 524;
	/**
	 * Bounds Width del chat. <br>
	 */
	private static final int CHAT_WIDTH = 102;
	/**
	 * Bounds Height del chat. <br>
	 */
	private static final int CHAT_HEIGHT = 35;
	/**
	 * Trescientos. <br>
	 */
	private static final int TRESCIENTOS = 300;
	/**
	 * Cincuenta. <br>
	 */
	private static final int CINCUENTA = 50;
	/**
	 * Sesenta y cuatro. <br>
	 */
	private static final int SESENTAYCUATRO = 64;
	/**
	 * Cientocincuenta. <br>
	 */
	private static final int CIENTOCINCUENTA = 150;
	/**
	 * Veinte. <br>
	 */
	private static final int VEINTE = 20;
	/**
	 * Diez. <br>
	 */
	private static final int DIEZ = 10;
	/**
	 * Treinta y dos. <br>
	 */
	private static final int TREINTAYDOS = 32;
	/**
	 * Cinco. <br>
	 */
	private static final int CINCO = 5;

	/**
	 * Crea el estado de juego del cliente. <br>
	 *
	 * @param juego
	 *            Juego del cliente. <br>
	 */
	public EstadoJuego(final Juego juego) {
		super(juego);
		mundo = new Mundo(juego, "recursos/" + getMundo() + ".txt",
				"recursos/" + getMundo() + ".txt");
		paquetePersonaje = juego.getPersonaje();
		entidadPersonaje = new Entidad(juego, mundo, SESENTAYCUATRO,
				SESENTAYCUATRO, juego.getPersonaje().getNombre(), 0, 0,
				Recursos.personaje.get(juego.getPersonaje().getRaza()),
				CIENTOCINCUENTA);
		miniaturaPersonaje = Recursos.personaje.get(paquetePersonaje.getRaza())
				.get(CINCO)[0];
		try {
			// Le envio al servidor que me conecte al mapa y mi posicion
			juego.getPersonaje().setComando(Comando.CONEXION);
			juego.getPersonaje().setEstado(Estado.estadoJuego);
			juego.getCliente().getSalida().writeObject(
					gson.toJson(juego.getPersonaje(), PaquetePersonaje.class));
			juego.getCliente().getSalida().writeObject(gson.toJson(
					juego.getUbicacionPersonaje(), PaqueteMovimiento.class));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Fallo la conexión con el servidor al ingresar al mundo");
		}
		// try {
		// // Le envio al servidor que me pase la información de enemigos
		// conectados
		// juego.getPersonaje().setComando(Comando.CONEXIONENEMIGOS);
		// juego.getPersonaje().setEstado(Estado.ESTADO_JUEGO);
		// juego.getCliente().getSalida().writeObject(gson.toJson(juego.getPersonaje(),
		// PaquetePersonaje.class));
		// juego.getCliente().getSalida().writeObject(gson.toJson(juego.getUbicacionPersonaje(),
		// PaqueteMovimiento.class));
		// } catch (IOException e) {
		// JOptionPane.showMessageDialog(null, "Fallo la conexión con el
		// servidor al actualizar el cliente con los enemigos");
		// }
	}

	/**
	 * Actualiza el mundo y los personajes. <br>
	 */
	@Override
	public final void actualizar() {
		mundo.actualizar();
		entidadPersonaje.actualizar();
	}

	/**
	 * Grafica el juego. <br>
	 */
	@Override
	public final void graficar(final Graphics g) {
		g.drawImage(Recursos.getBackground(), 0, 0, juego.getAncho(),
				juego.getAlto(), null);
		mundo.graficar(g);
		// entidadPersonaje.graficar(g);
		graficarPersonajes(g);
		mundo.graficarObstaculos(g);
		graficarEnemigos(g);
		entidadPersonaje.graficarNombre(g);
		g.drawImage(Recursos.getMarco(), 0, 0, juego.getAncho(),
				juego.getAlto(), null);
		EstadoDePersonaje.dibujarEstadoDePersonaje(g, CINCO, CINCO,
				paquetePersonaje, miniaturaPersonaje);
		g.drawImage(Recursos.getMochila(), MOCHILA_X, MOCHILA_Y, MOCHILA_WIDTH,
				MOCHILA_HEIGHT, null);
		g.drawImage(Recursos.getMenu(), MENU_X, MENU_Y, MENU_WIDTH, MENU_HEIGHT,
				null);
		g.drawImage(Recursos.getChat(), CHAT_X, CHAT_Y, CHAT_WIDTH, CHAT_HEIGHT,
				null);
		if (haySolicitud) {
			menuEnemigo.graficar(g, tipoSolicitud);
		}
		if (haySolicitudEnemigo) {
			menuEnemigoNPC.graficar(g, tipoSolicitud);
		}
	}

	/**
	 * Grafica a los enemigos. <br>
	 *
	 * @param g
	 *            Graficador. <br>
	 */
	private void graficarEnemigos(final Graphics g) {
		enemigosConectados = new HashMap<Integer, PaqueteEnemigo>(
				juego.getEnemigosConectados());
		ubicacionEnemigos = new HashMap<Integer, PaqueteMovimiento>(
				juego.getUbicacionEnemigos());
		Iterator<Integer> it = enemigosConectados.keySet().iterator();
		int key;
		PaqueteMovimiento actual;
		g.setColor(Color.WHITE);
		g.setFont(new Font("Book Antiqua", Font.PLAIN, FONT));
		while (it.hasNext()) {
			key = it.next();
			actual = ubicacionEnemigos.get(key);
			Pantalla.centerString(g, new Rectangle(
					(int) (actual.getPosX() - juego.getCamara().getxOffset()
							+ TREINTAYDOS),
					(int) (actual.getPosY() - juego.getCamara().getyOffset()
							- VEINTE),
					0, DIEZ), "El Bryan");
			g.drawImage(
					Recursos.elBryan.get(actual.getDireccion())[actual
							.getFrame()],
					(int) (actual.getPosX() - juego.getCamara().getxOffset()),
					(int) (actual.getPosY() - juego.getCamara().getyOffset()),
					SESENTAYCUATRO, SESENTAYCUATRO, null);
		}
	}

	/**
	 * Grafica a los personajes. <br>
	 *
	 * @param g
	 *            Graficador. <br>
	 */
	public final void graficarPersonajes(final Graphics g) {
		if (juego.getPersonajesConectados() != null) {
			personajesConectados = new HashMap<Integer, PaquetePersonaje>(
					juego.getPersonajesConectados());
			ubicacionPersonajes = new HashMap<Integer, PaqueteMovimiento>(
					juego.getUbicacionPersonajes());
			Iterator<Integer> it = personajesConectados.keySet().iterator();
			int key;
			PaqueteMovimiento actual;
			g.setColor(Color.WHITE);
			g.setFont(new Font("Book Antiqua", Font.PLAIN, FONT));
			while (it.hasNext()) {
				key = it.next();
				actual = ubicacionPersonajes.get(key);
				if (actual != null
						&& actual.getIdPersonaje() != juego.getPersonaje()
								.getId()
						&& personajesConectados.get(actual.getIdPersonaje())
								.getEstado() == Estado.estadoJuego) {
					Pantalla.centerString(g,
							new Rectangle((int) (actual.getPosX()
									- juego.getCamara().getxOffset()
									+ TREINTAYDOS),
									(int) (actual.getPosY()
											- juego.getCamara().getyOffset()
											- VEINTE),
									0, DIEZ),
							personajesConectados.get(actual.getIdPersonaje())
									.getNombre());
					g.drawImage(Recursos.personaje
							.get(personajesConectados
									.get(actual.getIdPersonaje()).getRaza())
							.get(actual.getDireccion())[actual.getFrame()],
							(int) (actual.getPosX()
									- juego.getCamara().getxOffset()),
							(int) (actual.getPosY()
									- juego.getCamara().getyOffset()),
							SESENTAYCUATRO, SESENTAYCUATRO, null);
				}
			}
		}
	}

	/**
	 * Devuelve al personaje. <br>
	 *
	 * @return Personaje. <br>
	 */
	public final Entidad getPersonaje() {
		return entidadPersonaje;
	}

	/**
	 * Devuelve el nombre del mundo. <br>
	 *
	 * @return Nombre mundo. <br>
	 */
	private String getMundo() {
		int mundo = juego.getPersonaje().getMapa();
		return (mundo == AUBENOR) ? "Aubenor"
				: (mundo == ARIS) ? "Aris"
						: (mundo == EODRIM) ? "Eodrim" : null;
	}

	/**
	 * Establece el tipo de solicitud. <br>
	 *
	 * @param b
	 *            Indicador de solicitud. <br>
	 * @param enemigo
	 *            Enemigo. <br>
	 * @param solicitudType
	 *            Tipo de solicitud. <br>
	 */
	public final void setHaySolicitud(final boolean b,
			final PaquetePersonaje enemigo, final int solicitudType) {
		haySolicitud = b;
		// menu que mostrara al enemigo
		menuEnemigo = new MenuInfoPersonaje(TRESCIENTOS, CINCUENTA, enemigo);
		this.tipoSolicitud = solicitudType;
	}

	/**
	 * Establece el tipo de solicitud del enemigo. <br>
	 *
	 * @param b
	 *            Indicador de solicitud. <br>
	 * @param enemigo
	 *            Enemigo. <br>
	 * @param tipoSolicitud
	 *            Tipo de solicitud. <br>
	 */
	public final void setHaySolicitudEnemigo(final boolean b,
			final PaqueteEnemigo enemigo, final int tipoSolicitud) {
		haySolicitudEnemigo = b;
		// menu que mostrara al enemigo
		menuEnemigoNPC = new MenuInfoEnemigo(TRESCIENTOS, CINCUENTA, enemigo);
		this.tipoSolicitud = tipoSolicitud;
	}

	/**
	 * Devuelve si hay una solicitud. <br>
	 *
	 * @return true si la hay, false de lo contrario. <br>
	 */
	public final boolean getHaySolicitud() {
		return haySolicitud;
	}

	/**
	 * Devuelve si hay una solicitud del enemigo. <br>
	 *
	 * @return true si la hay, false de lo contrario. <br>
	 */
	public final boolean getHaySolicitudEnemigo() {
		return haySolicitudEnemigo;
	}

	/**
	 * Actualiza al personaje. <br>
	 */
	public final void actualizarPersonaje() {
		paquetePersonaje = juego.getPersonaje();
	}

	/**
	 * Devuelve el menú del enemigo. <br>
	 *
	 * @return Menú enemigo. <br>
	 */
	public final MenuInfoPersonaje getMenuEnemigo() {
		return menuEnemigo;
	}

	/**
	 * Devuelve el menú del enemigo NPC. <br>
	 *
	 * @return Menú enemigo NPC. <br>
	 */
	public final MenuInfoEnemigo getMenuEnemigoNPC() {
		return menuEnemigoNPC;
	}

	/**
	 * Devuelve el tipo de solicitud. <br>
	 *
	 * @return Tipo de solicitud. <br>
	 */
	public final int getTipoSolicitud() {
		return tipoSolicitud;
	}

	/**
	 * Indica el estado de juego. <br>
	 */
	@Override
	public final boolean esEstadoDeJuego() {
		return true;
	}
}
