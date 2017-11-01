package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import dominio.Personaje;
import juego.Pantalla;
import recursos.Recursos;

/**
 * ClasE MenuBatalla.
 */
public class MenuBatalla {

    /** Constante NUM_394. */
    private static final int NUM_394 = 394;

    /** Constante NUM_221. */
    private static final int NUM_221 = 221;

    /** Constante NUM_146. */
    private static final int NUM_146 = 146;

    /** Constante NUM_72. */
    private static final int NUM_72 = 72;

    /** Constante NUM_48. */
    private static final int NUM_48 = 48;

    /** Constante NUM_5. */
    private static final int NUM_5 = 5;

    /** Constante NUM_4. */
    private static final int NUM_4 = 4;

    /** Constante NUM_TRES. */
    private static final int NUM_TRES = 3;

    /** Constante FONT_SIZE_14. */
    private static final int FONT_SIZE_14 = 14;

    /** Constante Y2. */
    private static final int Y2 = 168;

    /** Constante Y1. */
    private static final int Y1 = 94;

    /** Constante LEYENDA_3. */
    private static final int LEYENDA_3 = 442;

    /** Constante LEYENDA_CASTA_X. */
    private static final int LEYENDA_CASTA_X = 268;

    /** Constante LEYENDA_RAZA_X. */
    private static final int LEYENDA_RAZA_X = 95;

    /** Constante RECTANGLE_HEIGHT. */
    private static final int RECTANGLE_HEIGHT = 20;

    /** Constante X. */
    private static final int X = 100;

    /** Constante Y. */
    private static final int Y = 380;

    /** Constante ANCHO_BOTON. */
    private static final int ANCHO_BOTON = 40;

    /** Constante BOTONES. */
    private static final int[][] BOTONES = {{X + NUM_48, Y + NUM_72},
            {X + NUM_48, Y + NUM_146}, {X + NUM_221, Y + NUM_72},
            {X + NUM_221, Y + NUM_146}, {X + NUM_394, Y + NUM_72},
            {X + NUM_394, Y + NUM_146}};

    /** Atributo habilitado. */
    private boolean habilitado;

    /** Atributo personaje. */
    private Personaje personaje;

    /**
     * Instantiates a new menu batalla.
     *
     * @param habilit
     *            the habilitado
     * @param character
     *            the personaje
     */
    public MenuBatalla(final boolean habilit, final Personaje character) {
        this.habilitado = habilit;
        this.personaje = character;
    }

    /**
     * Graficar. <br>
     *
     * @param g
     *            Valor g.<br>
     */
    public void graficar(final Graphics g) {

        if (habilitado) {
            g.drawImage(Recursos.getMenuBatalla(), X, Y, null);
        } else {
            g.drawImage(Recursos.getMenuBatallaDeshabilitado(), X, Y, null);
        }

        // Dibujo los botones
        g.drawImage(Recursos.habilidades.get(personaje.getHabilidadesRaza()[0]),
                BOTONES[0][0], BOTONES[0][1], ANCHO_BOTON, ANCHO_BOTON, null);
        g.drawImage(Recursos.habilidades.get(personaje.getHabilidadesRaza()[1]),
                BOTONES[1][0], BOTONES[1][1], ANCHO_BOTON, ANCHO_BOTON, null);
        g.drawImage(
                Recursos.habilidades.get(personaje.getHabilidadesCasta()[0]),
                BOTONES[2][0], BOTONES[2][1], ANCHO_BOTON, ANCHO_BOTON, null);
        g.drawImage(
                Recursos.habilidades.get(personaje.getHabilidadesCasta()[1]),
                BOTONES[NUM_TRES][0], BOTONES[NUM_TRES][1], ANCHO_BOTON,
                ANCHO_BOTON, null);
        g.drawImage(
                Recursos.habilidades.get(personaje.getHabilidadesCasta()[2]),
                BOTONES[NUM_4][0], BOTONES[NUM_4][1], ANCHO_BOTON, ANCHO_BOTON,
                null);
        g.drawImage(Recursos.habilidades.get("Ser Energizado"),
                BOTONES[NUM_5][0], BOTONES[NUM_5][1], ANCHO_BOTON, ANCHO_BOTON,
                null);

        // Dibujo las leyendas
        g.setFont(new Font("Book Antiqua", 1, FONT_SIZE_14));
        g.drawString(personaje.getHabilidadesRaza()[0], X + LEYENDA_RAZA_X,
                Y + Y1);
        g.drawString(personaje.getHabilidadesRaza()[1], X + LEYENDA_RAZA_X,
                Y + Y2);
        g.drawString(personaje.getHabilidadesCasta()[0], X + LEYENDA_CASTA_X,
                Y + Y1);
        g.drawString(personaje.getHabilidadesCasta()[1], X + LEYENDA_CASTA_X,
                Y + Y2);
        g.drawString(personaje.getHabilidadesCasta()[2], X + LEYENDA_3, Y + Y1);
        g.drawString("Ser energizado", X + LEYENDA_3, Y + Y2);

        // Dibujo el turno de quien es
        g.setColor(Color.WHITE);
        if (habilitado) {
            Pantalla.centerString(g, new Rectangle(X, Y + NUM_5,
                    Recursos.getMenuBatalla().getWidth(), RECTANGLE_HEIGHT),
                    "Mi Turno");
        } else {
            Pantalla.centerString(g, new Rectangle(X, Y + NUM_5,
                    Recursos.getMenuBatalla().getWidth(), RECTANGLE_HEIGHT),
                    "Turno Rival");
        }

    }

    /**
     * Obtiene el boton clickeado. <br>
     *
     * @param mouseX
     *            Valor x del mouse.
     * @param mouseY
     *            Valor y del mouse.
     * @return the boton clickeado. <br>
     */
    public final int getBotonClickeado(final int mouseX, final int mouseY) {
        if (!habilitado) {
            return 0;
        }

        for (int i = 0; i < BOTONES.length; i++) {
            if (mouseX >= BOTONES[i][0] && mouseX <= BOTONES[i][0] + ANCHO_BOTON
                    && mouseY >= BOTONES[i][1]
                    && mouseY <= BOTONES[i][1] + ANCHO_BOTON) {
                return i + 1;
            }

        }
        return 0;
    }

    /**
     * Click en menu. <br>
     *
     * @param mouseX
     *            Valor x del mouse.
     * @param mouseY
     *            Valor y del mouse.
     * @return true, if successful <br>
     */
    public final boolean clickEnMenu(final int mouseX, final int mouseY) {
        if (mouseX >= X && mouseX <= X + Recursos.getMenuBatalla().getWidth()
                && mouseY >= Y
                && mouseY <= Y + Recursos.getMenuBatalla().getHeight()) {
            return habilitado;
        }

        return false;
    }

    /**
     * Sets habilitado. <br>
     *
     * @param b
     *            Boolean habilitado. <br>
     */
    public final void setHabilitado(final boolean b) {
        habilitado = b;
    }
}
