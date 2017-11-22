package mundo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Clase que dibuja los tiles. <br>
 */
public class Tile {
    /** Constant TRES. */
    private static final int TRES = 3;
    /** Constant TILE_NUMBER. */
    private static final int TILE_NUMBER = 256;
    /**
     * Tiles. <br>
     */
    public static Tile[] tiles = new Tile[TILE_NUMBER];
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
    public static int arisBase = TRES;
    /**
     * Base del piso de aubenor. <br>
     */
    public static int aubenorBase = TRES;
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
     *
     * @param texture
     *            Imágen del tile. <br>
     * @param idNumber
     *            ID del tile. <br>
     * @param isSolid
     *            Indicador tile sólido. <br>
     */
    public Tile(final BufferedImage texture, final int idNumber,
            final boolean isSolid) {
        this.textura = texture;
        this.id = idNumber;
        tiles[idNumber] = this;
        this.esSolido = isSolid;
    }

    /**
     * Crea un tile con sus condiciones, alto y ancho. <br>
     *
     * @param texture
     *            Imágen del tile. <br>
     * @param idNumber
     *            ID del tile. <br>
     * @param isSolid
     *            Indicador tile sólido. <br>
     * @param width
     *            Ancho de tile. <br>
     * @param height
     *            Alto de tile. <br>
     */
    public Tile(final BufferedImage texture, final int idNumber,
            final boolean isSolid, final int width, final int height) {
        this.textura = texture;
        this.id = idNumber;
        tiles[idNumber] = this;
        this.ancho = width;
        this.alto = height;
        this.esSolido = isSolid;
    }

    /**
     * Actualiza el tile. <br>
     */
    public void actualizar() {

    }

    /**
     * Gradica el tile. <br>
     *
     * @param g
     *            Graficador. <br>
     * @param x
     *            Posición X. <br>
     * @param y
     *            Posición Y. <br>
     */
    public final void graficar(final Graphics g, final int x, final int y) {
        g.drawImage(this.textura, x, y, ANCHO, ALTO, null);
    }

    /**
     * Grafica el tile. <br>
     *
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
    public final void graficar(final Graphics g, final int x, final int y,
            final int width, final int height) {
        g.drawImage(this.textura, x, y, width, height, null);
    }

    /**
     * Establece la solidez de un tile. <br>
     *
     * @param solidez
     *            Solidez. <br>
     */
    public final void setSolido(final boolean solidez) {
        this.esSolido = solidez;
    }

    /**
     * Devuelve si el tile es sólido. <br>
     *
     * @return true si es sólido, false de lo contrario. <br>
     */
    public final boolean esSolido(boolean personajeInvisible) {
    	if (personajeInvisible)
    		return false;
    	else
    		return this.esSolido;
    }

    /**
     * Devuelve el ID del tile. <br>
     *
     * @return ID del tile. <br>
     */
    public final int getId() {
        return this.id;
    }

    /**
     * Devuelve el ancho del tile. <br>
     *
     * @return Ancho del tile. <br>
     */
    public final int getAncho() {
        return this.ancho;
    }

    /**
     * Devuelve el alto del tile. <br>
     *
     * @return Alto del tile. <br>
     */
    public final int getAlto() {
        return this.alto;
    }
}
