package recursos;

import java.awt.image.BufferedImage;

/**
 * Clase que administra los sprites. <br>
 */
public class SpriteSheet {
    /**
     * Sprite. <br>
     */
    private BufferedImage sprite;

    /**
     * Crea un sprite. <br>
     *
     * @param spriteSheet
     *            Imágen del sprite. <br>
     */
    public SpriteSheet(final BufferedImage spriteSheet) {
        this.sprite = spriteSheet;
    }

    /**
     * Devuelve el tile del sprite. <br>
     *
     * @param x
     *            Posición X del sprite. <br>
     * @param y
     *            Posición Y del sprite. <br>
     * @param ancho
     *            Ancho del sprite. <br>
     * @param alto
     *            Alto del sprite. <br>
     * @return Tile del sprite. <br>
     */
    public final BufferedImage getTile(final int x, final int y,
            final int ancho, final int alto) {
        return sprite.getSubimage(x, y, ancho, alto);
    }
}
