package juego;

import entidades.Entidad;

/**
 * Clase que administra la cámara del jugador. <br>
 */
public class Camara {
    /**
     * Juego. <br>
     */
    private Juego juego;
    /**
     * Offset Y. <br>
     */
    private float yOffset;
    /**
     * Offset X. <br>
     */
    private float xOffset;

    /**
     * Crea la cámara que se mueve con el personaje. <br>
     *
     * @param game
     *            Juego. <br>
     * @param offsetX
     *            Offset X. <br>
     * @param offsetY
     *            Offset Y. <br>
     */
    public Camara(final Juego game, final float offsetX, final float offsetY) {
        this.juego = game;
        this.xOffset = offsetX;
        this.yOffset = offsetY;
    }

    /**
     * Centra la cámara al personaje. <br>
     *
     * @param e
     *            Entidad. <br>
     */
    public final void centrar(final Entidad e) {
        xOffset = e.getX() - juego.getAncho() / 2 + e.getAncho() / 2;
        yOffset = e.getY() - juego.getAlto() / 2 + e.getAlto() / 2;
    }

    /**
     * Mueve la cámara con respecto al personaje. <br>
     *
     * @param dx
     *            Distancia X. <br>
     * @param dy
     *            Distancia Y. <br>
     */
    public final void mover(final float dx, final float dy) {
        xOffset += dx;
        yOffset += dy;
    }

    /**
     * Devuelve el offset de Y. <br>
     *
     * @return Offset Y. <br>
     */
    public final float getyOffset() {
        return yOffset;
    }

    /**
     * Establece el offset de Y. <br>
     *
     * @param yOffset
     *            Offset Y. <br>
     */
    public final void setyOffset(final float yOffset) {
        this.yOffset = yOffset;
    }

    /**
     * Devuelve el offset de X. <br>
     *
     * @return Offset X. <br>
     */
    public final float getxOffset() {
        return xOffset;
    }

    /**
     * Establece el offset de X. <br>
     *
     * @param xOffset
     *            Offset X. <br>
     */
    public final void setxOffset(final float xOffset) {
        this.xOffset = xOffset;
    }
}
