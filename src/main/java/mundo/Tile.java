package mundo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Clase que dibuja los tiles. <br>
 */
public class Tile {
	/**
	 * Tiles. <br>
	 */
	public static Tile[] tiles = new Tile[256];
	/**
	 * Tiles del mapa aubenor. <br>
	 */
	public static Tile[] aubenor;
	/**
	 * Tiles del mapa aris. <br>
	 */
	public static Tile[] aris;
	/**
	 * Base del piso de aris. <br>
	 */
	public static int arisBase = 3;
	/**
	 * Base del piso de aubenor. <br>
	 */
	public static int aubenorBase = 3;
	/**
	 * Ancho del tile. <br>
	 */
	public static final int ANCHO = 64;
	/**
	 * Alto del tile. <br>
	 */
	public static final int ALTO = 32;
	/**
	 * Imágen del tile. <br>
	 */
	protected BufferedImage textura;
	/**
	 * ID del tile. <br>
	 */
	protected final int id;
	/**
	 * Indicador de si es un tile sólido. <br>
	 */
	private boolean esSolido;
	/**
	 * Ancho del tile. <br>
	 */
	protected int ancho;
	/**
	 * Alto del tile. <br>
	 */
	protected int alto;

	/**
	 * Crea un tile con sus condiciones. <br>
	 * @param textura
	 *            Imágen del tile. <br>
	 * @param id
	 *            ID del tile. <br>
	 * @param esSolido
	 *            Indicador tile sólido. <br>
	 */
	public Tile(final BufferedImage textura, final int id, final boolean esSolido) {
		this.textura = textura;
		this.id = id;
		tiles[id] = this;
		this.esSolido = esSolido;
	}

	/**
	 * Crea un tile con sus condiciones, alto y ancho. <br>
	 * @param textura
	 *            Imágen del tile. <br>
	 * @param id
	 *            ID del tile. <br>
	 * @param esSolido
	 *            Indicador tile sólido. <br>
	 * @param ancho
	 *            Ancho de tile. <br>
	 * @param alto
	 *            Alto de tile. <br>
	 */
	public Tile(final BufferedImage textura, final int id, final boolean esSolido, final int ancho, final int alto) {
		this.textura = textura;
		this.id = id;
		tiles[id] = this;
		this.ancho = ancho;
		this.alto = alto;
		this.esSolido = esSolido;
	}

	/**
	 * Actualiza el tile. <br>
	 */
	public void actualizar() {

	}

	/**
	 * Gradica el tile. <br> 
	 * @param g
	 *            Graficador. <br>
	 * @param x
	 *            Posición X. <br>
	 * @param y
	 *            Posición Y. <br>
	 */
	public void graficar(final Graphics g, final int x, final int y) {
		g.drawImage(this.textura, x, y, ANCHO, ALTO, null);
	}

	/**
	 * Grafica el tile. <br>
	 * @param g
	 *            Graficador. <br>
	 * @param x
	 *            Posición X. <br>
	 * @param y
	 *            Posición Y. <br>
	 * @param width
	 *            Ancho del tile. <br>
	 * @param height
	 *            Alto del tile. <br>
	 */
	public void graficar(final Graphics g, final int x, final int y, final int width, final int height) {
		g.drawImage(this.textura, x, y, width, height, null);
	}

	/**
	 * Establece la solidez de un tile. <br>
	 * @param solidez
	 *            Solidez. <br>
	 */
	public void setSolido(final boolean solidez) {
		this.esSolido = solidez;
	}

	/**
	 * Devuelve si el tile es sólido. <br>
	 * @return true si es sólido, false de lo contrario. <br>
	 */
	public boolean esSolido() {
		return this.esSolido;
	}

	/**
	 * Devuelve el ID del tile. <br>
	 * @return ID del tile. <br>
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Devuelve el ancho del tile. <br>
	 * @return Ancho del tile. <br>
	 */
	public int getAncho() {
		return this.ancho;
	}

	/**
	 * Devuelve el alto del tile. <br> 
	 * @return Alto del tile. <br>
	 */
	public int getAlto() {
		return this.alto;
	}
}
