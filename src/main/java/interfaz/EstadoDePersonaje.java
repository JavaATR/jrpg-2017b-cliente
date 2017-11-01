package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dominio.NonPlayableCharacter;
import dominio.Personaje;
import mensajeria.PaquetePersonaje;
import recursos.Recursos;

/**
 * Clase EstadoDePersonaje.
 */
public class EstadoDePersonaje {
    /** Constante VALUE_EXPERIENCIA. */
    private static final int VALUE_EXPERIENCIA = 100;

    /** Constante STRING_EXPERIENCIA_OFFSET_Y. */
    private static final int STRING_EXPERIENCIA_OFFSET_Y = 70;

    /** Constante STRING_EXPERIENCIA_OFFSET_X. */
    private static final int STRING_EXPERIENCIA_OFFSET_X = 132;

    /** Constante STRING_ENERGIA_OFFSET_Y. */
    private static final int STRING_ENERGIA_OFFSET_Y = 52;

    /** Constante STRING_ENERGIA_OFFSET_X. */
    private static final int STRING_ENERGIA_OFFSET_X = 132;

    /** Constante STRING_SALUD_OFFSET_Y. */
    private static final int STRING_SALUD_OFFSET_Y = 37;

    /** Constante STRING_SALUD_OFFSET_X. */
    private static final int STRING_SALUD_OFFSET_X = 132;

    /** Constante ENERGIA_ENEMIGO. */
    private static final int ENERGIA_ENEMIGO = 100;

    /** Constante SALUD_ENEMIGO. */
    private static final int SALUD_ENEMIGO = 240;

    /** Constante NIVEL_OFFSET_Y. */
    private static final int NIVEL_OFFSET_Y = 70;

    /** Constante NIVEL_OFFSET_X. */
    private static final int NIVEL_OFFSET_X = 59;

    /** Constante BARRA_EXPERIENCIA_OFFSET_Y. */
    private static final int BARRA_EXPERIENCIA_OFFSET_Y = 65;

    /** Constante BARRA_EXPERIENCIA_OFFSET_X. */
    private static final int BARRA_EXPERIENCIA_OFFSET_X = 77;

    /** Constante BARRA_ENERGIA_OFFSET_Y. */
    private static final int BARRA_ENERGIA_OFFSET_Y = 42;

    /** Constante BARRA_ENERGIA_OFFSET_X. */
    private static final int BARRA_ENERGIA_OFFSET_X = 80;

    /** Constante BARRA_SALUD_OFFSET_Y. */
    private static final int BARRA_SALUD_OFFSET_Y = 26;

    /** Constante BARRA_SALUD_OFFSET_X. */
    private static final int BARRA_SALUD_OFFSET_X = 80;

    /** Constante MINIATURA_OFFSET_Y. */
    private static final int MINIATURA_OFFSET_Y = 9;

    /** Constante MINIATURA_OFFSET_X. */
    private static final int MINIATURA_OFFSET_X = 10;

    /** Constante FONT_SIZE_8. */
    private static final int FONT_SIZE_8 = 8;

    /** Constante FONT_SIZE_10. */
    private static final int FONT_SIZE_10 = 10;

    /** Constante ANCHOBARRA. */
    private static final int ANCHOBARRA = 122;

    /** Constante ALTOSALUD. */
    private static final int ALTOSALUD = 14;

    /** Constante ALTOENERGIA. */
    private static final int ALTOENERGIA = 14;

    /** Constante ALTOEXPERIENCIA. */
    private static final int ALTOEXPERIENCIA = 6;

    /** Constante ALTOMINIATURA. */
    private static final int ALTOMINIATURA = 64;

    /** Constante ANCHOMINIATURA. */
    private static final int ANCHOMINIATURA = 64;

    /**
     * Dibujar estado de personaje. <br>
     *
     * @param g
     *            Valor g.
     * @param x
     *            Valor x.
     * @param y
     *            Valor y.
     * @param personaje
     *            Valor personaje.
     * @param miniaturaPersonaje
     *            Imagen miniatura personaje. <br>
     */
    public static void dibujarEstadoDePersonaje(final Graphics g, final int x,
            final int y, final Personaje personaje,
            final BufferedImage miniaturaPersonaje) {
        int drawBarra = 0;

        g.drawImage(Recursos.getEstadoPersonaje(), x, y, null);

        g.drawImage(miniaturaPersonaje, x + MINIATURA_OFFSET_X,
                y + MINIATURA_OFFSET_Y, ANCHOMINIATURA, ALTOMINIATURA, null);

        if (personaje.getSalud() == personaje.getSaludTope()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getSalud() * ANCHOBARRA)
                    / personaje.getSaludTope();
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_10));
        g.drawImage(Recursos.getBarraSalud(), x + BARRA_SALUD_OFFSET_X,
                y + BARRA_SALUD_OFFSET_Y, drawBarra, ALTOSALUD, null);
        g.drawString(
                String.valueOf(personaje.getSalud()) + " / "
                        + String.valueOf(personaje.getSaludTope()),
                x + STRING_SALUD_OFFSET_X, y + STRING_SALUD_OFFSET_Y);

        if (personaje.getEnergia() == personaje.getEnergiaTope()) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getEnergia() * ANCHOBARRA)
                    / personaje.getEnergiaTope();
        }

        g.drawImage(Recursos.getBarraEnergia(), x + BARRA_ENERGIA_OFFSET_X,
                y + BARRA_ENERGIA_OFFSET_Y, drawBarra, ALTOENERGIA, null);
        g.drawString(
                String.valueOf(personaje.getEnergia()) + " / "
                        + String.valueOf(personaje.getEnergiaTope()),
                x + STRING_ENERGIA_OFFSET_X, y + STRING_ENERGIA_OFFSET_Y);

        if (personaje.getExperiencia() == Personaje
                .getTablaDeNiveles()[personaje.getNivel() + 1]) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getExperiencia() * ANCHOBARRA)
                    / Personaje.getTablaDeNiveles()[personaje.getNivel() + 1];
        }

        g.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_8));
        g.drawImage(Recursos.getBarraExperiencia(),
                x + BARRA_EXPERIENCIA_OFFSET_X, y + BARRA_EXPERIENCIA_OFFSET_Y,
                drawBarra, ALTOEXPERIENCIA, null);
        g.drawString(
                String.valueOf(personaje.getExperiencia()) + " / "
                        + String.valueOf(Personaje
                                .getTablaDeNiveles()[personaje.getNivel() + 1]),
                x + STRING_EXPERIENCIA_OFFSET_X,
                y + STRING_EXPERIENCIA_OFFSET_Y);
        g.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_10));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(personaje.getNivel()), x + NIVEL_OFFSET_X,
                y + NIVEL_OFFSET_Y);
    }

    /**
     * Dibujar estado de enemigo. <br>
     *
     * @param g
     *            Valor g.
     * @param x
     *            Valor x.
     * @param y
     *            Valor y.
     * @param enemigo
     *            Valor enemigo.
     * @param miniaturaEnemigo
     *            Imagen miniatura enemigo. <br>
     */
    public static void dibujarEstadoDeEnemigo(final Graphics g, final int x,
            final int y, final NonPlayableCharacter enemigo,
            final BufferedImage miniaturaEnemigo) {
        int drawBarra = 0;

        g.drawImage(Recursos.getEstadoPersonaje(), x, y, null);

        g.drawImage(miniaturaEnemigo, x + MINIATURA_OFFSET_X,
                y + MINIATURA_OFFSET_Y, ANCHOMINIATURA, ALTOMINIATURA, null);

        if (enemigo.getSalud() == SALUD_ENEMIGO) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (enemigo.getSalud() * ANCHOBARRA) / SALUD_ENEMIGO;
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_10));
        g.drawImage(Recursos.getBarraSalud(), x + BARRA_SALUD_OFFSET_X,
                y + BARRA_SALUD_OFFSET_Y, drawBarra, ALTOSALUD, null);
        g.drawString(
                String.valueOf(enemigo.getSalud()) + " / "
                        + String.valueOf(SALUD_ENEMIGO),
                x + STRING_SALUD_OFFSET_X, y + STRING_SALUD_OFFSET_Y);

        if (enemigo.getEnergia() == ENERGIA_ENEMIGO) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (enemigo.getEnergia() * ANCHOBARRA) / ENERGIA_ENEMIGO;
        }

        g.drawImage(Recursos.getBarraEnergia(), x + BARRA_ENERGIA_OFFSET_X,
                y + BARRA_ENERGIA_OFFSET_Y, drawBarra, ALTOENERGIA, null);
        g.drawString(
                String.valueOf(enemigo.getEnergia()) + " / "
                        + String.valueOf(ENERGIA_ENEMIGO),
                x + STRING_ENERGIA_OFFSET_X, y + STRING_ENERGIA_OFFSET_Y);

        drawBarra = (0 * ANCHOBARRA) / ENERGIA_ENEMIGO;

        g.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_8));
        g.drawImage(Recursos.getBarraExperiencia(),
                x + BARRA_EXPERIENCIA_OFFSET_X, y + BARRA_EXPERIENCIA_OFFSET_Y,
                drawBarra, ALTOEXPERIENCIA, null);
        g.drawString(
                String.valueOf(0) + " / " + String.valueOf(VALUE_EXPERIENCIA),
                x + STRING_EXPERIENCIA_OFFSET_X,
                y + STRING_EXPERIENCIA_OFFSET_Y);
        g.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_10));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(enemigo.getNivel()), x + NIVEL_OFFSET_X,
                y + NIVEL_OFFSET_Y);
    }

    /**
     * Dibujar estado de personaje. <br>
     *
     * @param g
     *            Valor g.
     * @param x
     *            Valor x.
     * @param y
     *            Valor y.
     * @param personaje
     *            Valor personaje.
     * @param miniaturaPersonaje
     *            Imagen miniatura personaje. <br>
     */
    public static void dibujarEstadoDePersonaje(final Graphics g, final int x,
            final int y, final PaquetePersonaje personaje,
            final BufferedImage miniaturaPersonaje) {
        int drawBarra = 0;

        g.drawImage(Recursos.getEstadoPersonaje(), x, y, null);

        g.drawImage(miniaturaPersonaje, x + MINIATURA_OFFSET_X,
                y + MINIATURA_OFFSET_Y, ANCHOMINIATURA, ALTOMINIATURA, null);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_10));
        g.drawImage(Recursos.getBarraSalud(), x + BARRA_SALUD_OFFSET_X,
                y + BARRA_SALUD_OFFSET_Y, ANCHOBARRA, ALTOSALUD, null);
        g.drawString(
                String.valueOf(personaje.getSaludTope()) + " / "
                        + String.valueOf(personaje.getSaludTope()),
                x + STRING_SALUD_OFFSET_X, y + STRING_SALUD_OFFSET_Y);

        g.drawImage(Recursos.getBarraEnergia(), x + BARRA_ENERGIA_OFFSET_X,
                y + BARRA_ENERGIA_OFFSET_Y, ANCHOBARRA, ALTOENERGIA, null);
        g.drawString(
                String.valueOf(personaje.getEnergiaTope()) + " / "
                        + String.valueOf(personaje.getEnergiaTope()),
                x + STRING_ENERGIA_OFFSET_X, y + STRING_ENERGIA_OFFSET_Y);

        if (personaje.getExperiencia() == Personaje
                .getTablaDeNiveles()[personaje.getNivel() + 1]) {
            drawBarra = ANCHOBARRA;
        } else {
            drawBarra = (personaje.getExperiencia() * ANCHOBARRA)
                    / Personaje.getTablaDeNiveles()[personaje.getNivel() + 1];
        }

        g.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_8));
        g.drawImage(Recursos.getBarraExperiencia(),
                x + BARRA_EXPERIENCIA_OFFSET_X, y + BARRA_EXPERIENCIA_OFFSET_Y,
                drawBarra, ALTOEXPERIENCIA, null);
        g.drawString(
                String.valueOf(personaje.getExperiencia()) + " / "
                        + String.valueOf(Personaje
                                .getTablaDeNiveles()[personaje.getNivel() + 1]),
                x + STRING_EXPERIENCIA_OFFSET_X,
                y + STRING_EXPERIENCIA_OFFSET_Y);
        g.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_10));
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(personaje.getNivel()), x + NIVEL_OFFSET_X,
                y + NIVEL_OFFSET_Y);
    }
}
