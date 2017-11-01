package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dominio.Personaje;
import juego.Pantalla;
import mensajeria.PaquetePersonaje;
import recursos.Recursos;

/**
 * Clase MenuInfoPersonaje.
 */
public class MenuInfoPersonaje {

    /** Constante NUM_128. */
    private static final int NUM_128 = 128;

    /** Constante OFFSET_Y_70. */
    private static final int OFFSET_Y_70 = 70;

    /** Constante OFFSET_Y_15. */
    private static final int OFFSET_Y_15 = 15;

    /** Constante OFFSET_X_30. */
    private static final int OFFSET_X_30 = 30;

    /** Constante OFFSET_X_150. */
    private static final int OFFSET_X_150 = 150;

    /** Constante SEIS. */
    private static final int SEIS = 6;

    /** Constante OFFSET_Y_325. */
    private static final int OFFSET_Y_325 = 325;

    /** Constante OFFSET_Y_270. */
    private static final int OFFSET_Y_270 = 270;

    /** Constante OFFSET_Y_240. */
    private static final int OFFSET_Y_240 = 240;

    /** Constante OFFSET_Y_200. */
    private static final int OFFSET_Y_200 = 200;

    /** Constante OFFSET_Y_320. */
    private static final int OFFSET_Y_320 = 320;

    /** Constante OFFSET_X_100. */
    private static final int OFFSET_X_100 = 100;

    /** Constante OFFSET_Y_290. */
    private static final int OFFSET_Y_290 = 290;

    /** Constante OFFSET_Y_260. */
    private static final int OFFSET_Y_260 = 260;

    /** Constante LABEL_OFFSET_X. */
    private static final int LABEL_OFFSET_X = 30;

    /** Constante INDEX_5. */
    private static final int INDEX_5 = 5;

    /** Constante INDEX_4. */
    private static final int INDEX_4 = 4;

    /** Constante INDEX_3. */
    private static final int INDEX_3 = 3;

    /** Constante FONT_SIZE_20. */
    private static final int FONT_SIZE_20 = 20;

    /** Constante FONT_SIZE_62. */
    private static final int FONT_SIZE_62 = 62;

    /** Constante FONT_SIZE_18. */
    private static final int FONT_SIZE_18 = 18;

    /** Constante FONT_SIZE_MENU_GANAR. */
    private static final int FONT_SIZE_MENU_GANAR = 14;

    /** Constante FONT_SIZE_MENU_PERDER. */
    private static final int FONT_SIZE_MENU_PERDER = 14;

    /** Constante FONT_SIZE. */
    private static final int FONT_SIZE = 20;

    /** Constante ANCHO_PERSONAJE. */
    private static final int ANCHO_PERSONAJE = 128;

    /** Constante MENU. */
    private static final BufferedImage MENU = Recursos.getMenuEnemigo();

    /** Constante MENU_BATALLAR. */
    public static final int MENU_BATALLAR = 0;

    /** Constante MENU_INFORMACION. */
    public static final int MENU_INFORMACION = 1;

    /** Constante MENU_SUBIR_NIVEL. */
    public static final int MENU_SUBIR_NIVEL = 2;

    /** Constante MENU_GANAR_BATALLA. */
    public static final int MENU_GANAR_BATALLA = 3;

    /** Constante MENU_PERDER_BATALLA. */
    public static final int MENU_PERDER_BATALLA = 4;

    /** Constante MENU_GANAR_ITEM. */
    public static final int MENU_GANAR_ITEM = 5;

    /** Constante MENU_COMERCIAR. */
    public static final int MENU_COMERCIAR = 6;

    /** Constante LEYENDA_BOTON. */
    private static final String[] LEYENDA_BOTON = {"Batallar", "Volver",
            "Aceptar", "Aceptar", "Aceptar", "Aceptar", "Comerciar"};

    /** Constante BTN_OFFSET. */
    public static final int[] BTN_OFFSET = {50, 380, 200, 25};
    /** Constante MENU_PERDER. */
    public static final int[] MENU_PERDER = {250, 270, 290, 310};
    /** Constante MENU_GANAR. */
    public static final int[] MENU_GANAR = {200, 230, 270, 290, 310, 330};
    /** Constante CLCK_CERRAR. */
    public static final int[] CLCK_CERRAR = {24, 4, 12, 36};
    /** Constante CLCK_BOTON. */
    public static final int[] CLCK_BOTON = {50, 250, 380, 405};

    /** Atributo x. */
    private int x;

    /** Atributo y. */
    private int y;

    /** Atributo personaje. */
    private PaquetePersonaje personaje;

    /**
     * Constructor menu info personaje. <br>
     *
     * @param xValue
     *            valor x.
     * @param yValue
     *            valor y.
     * @param character
     *            the character
     */
    public MenuInfoPersonaje(final int xValue, final int yValue,
            final PaquetePersonaje character) {
        this.x = xValue;
        this.y = yValue;
        this.personaje = character;
    }

    /**
     * Graficar. <br>
     *
     * @param g
     *            Valor g.
     * @param tipoMenu
     *            Valor tipo de menu.<br>
     */
    public void graficar(final Graphics g, final int tipoMenu) {

        // dibujo el menu
        g.drawImage(MENU, x, y, null);

        // dibujo el personaje
        g.drawImage(Recursos.personaje.get(personaje.getRaza()).get(SEIS)[0],
                x + MENU.getWidth() / 2 - ANCHO_PERSONAJE / 2, y + OFFSET_Y_70,
                NUM_128, NUM_128, null);

        // muestro el nombre
        g.setColor(Color.WHITE);
        g.setFont(new Font("Book Antiqua", 1, FONT_SIZE_20));
        Pantalla.centerString(g,
                new Rectangle(x, y + OFFSET_Y_15, MENU.getWidth(), 0),
                personaje.getNombre());

        // Grafico la leyenda segun el tipo de menu
        switch (tipoMenu) {
        case MENU_BATALLAR:
            graficarMenuInformacion(g);
            break;
        case MENU_INFORMACION:
            graficarMenuInformacion(g);
            break;
        case MENU_SUBIR_NIVEL:
            graficarMenuSubirNivel(g);
            break;
        case MENU_GANAR_BATALLA:
            graficarMenuGanarBatalla(g);
            break;
        case MENU_PERDER_BATALLA:
            graficarMenuPerderBatalla(g);
            break;
        case MENU_GANAR_ITEM:
            graficarMenuItem(g);
            break;
        case MENU_COMERCIAR:
            graficarMenuComerciar(g);
            break;
        }

        // muestro los botones
        g.setFont(new Font("Book Antiqua", 1, FONT_SIZE));
        g.drawImage(Recursos.getBotonMenu(), x + BTN_OFFSET[0],
                y + BTN_OFFSET[1], BTN_OFFSET[2], BTN_OFFSET[INDEX_3], null);
        g.setColor(Color.WHITE);
        Pantalla.centerString(g,
                new Rectangle(x + BTN_OFFSET[0], y + BTN_OFFSET[1],
                        BTN_OFFSET[2], BTN_OFFSET[INDEX_3]),
                LEYENDA_BOTON[tipoMenu]);
    }

    /**
     * Graficar menu perder batalla. <br>
     *
     * @param g
     *            Valor g. <br>
     */
    private void graficarMenuPerderBatalla(final Graphics g) {

        // Informo que perdio la batalla
        g.setColor(Color.BLACK);
        Pantalla.centerString(g,
                new Rectangle(x, y + MENU_PERDER[0], MENU.getWidth(), 0),
                "¡Has sido derrotado!");

        g.setFont(new Font("Book Antiqua", 0, FONT_SIZE_MENU_PERDER));
        Pantalla.centerString(g,
                new Rectangle(x, y + MENU_PERDER[1], MENU.getWidth(), 0),
                "¡No te rindas! Sigue luchando");
        Pantalla.centerString(g,
                new Rectangle(x, y + MENU_PERDER[2], MENU.getWidth(), 0),
                "contra los demás personajes");
        Pantalla.centerString(g,
                new Rectangle(x, y + MENU_PERDER[INDEX_3], MENU.getWidth(), 0),
                "para aumentar tu nivel y");
        Pantalla.centerString(g,
                new Rectangle(x, y + MENU_PERDER[INDEX_4], MENU.getWidth(), 0),
                "mejorar tus atributos.");
    }

    /**
     * Graficar menu ganar batalla. <br>
     *
     * @param g
     *            Valor g. <br>
     */
    private void graficarMenuGanarBatalla(final Graphics g) {

        // Informo que gano la batalla
        g.setColor(Color.BLACK);
        Pantalla.centerString(g,
                new Rectangle(x, y + MENU_GANAR[0], MENU.getWidth(), 0),
                "¡Has derrotado");
        Pantalla.centerString(g,
                new Rectangle(x, y + MENU_GANAR[1], MENU.getWidth(), 0),
                "a tu enemigo!");

        g.setFont(new Font("Book Antiqua", 0, FONT_SIZE_MENU_GANAR));
        Pantalla.centerString(g,
                new Rectangle(x, y + MENU_GANAR[2], MENU.getWidth(), 0),
                "¡Felicitaciones! Has derrotado");
        Pantalla.centerString(g,
                new Rectangle(x, y + MENU_GANAR[INDEX_3], MENU.getWidth(), 0),
                "a tu oponente, sigue así");
        Pantalla.centerString(g,
                new Rectangle(x, y + MENU_GANAR[INDEX_4], MENU.getWidth(), 0),
                "para lograr subir de nivel");
        Pantalla.centerString(g,
                new Rectangle(x, y + MENU_GANAR[INDEX_5], MENU.getWidth(), 0),
                "y mejorar tus atributos.");

    }

    /**
     * Graficar menu subir de nivel. <br>
     *
     * @param g
     *            Valor g. <br>
     */
    private void graficarMenuSubirNivel(final Graphics g) {

        // Informo que subio de nivel
        g.setColor(Color.BLACK);
        Pantalla.centerString(g,
                new Rectangle(x, y + OFFSET_Y_200, MENU.getWidth(), 0),
                "¡Has subido de nivel!");

        g.setFont(new Font("Book Antiqua", 0, FONT_SIZE_18));
        Pantalla.centerString(g,
                new Rectangle(x, y + OFFSET_Y_240, MENU.getWidth(), 0),
                "¡Felicitaciones!");
        Pantalla.centerString(g,
                new Rectangle(x, y + OFFSET_Y_270, MENU.getWidth(), 0),
                "Nuevo Nivel");
        g.setFont(new Font("Book Antiqua", 1, FONT_SIZE_62));
        Pantalla.centerString(g,
                new Rectangle(x, y + OFFSET_Y_325, MENU.getWidth(), 0),
                String.valueOf(personaje.getNivel()));

    }

    /**
     * Graficar menu información. <br>
     *
     * @param g
     *            Valor g. <br>
     */
    public void graficarMenuInformacion(final Graphics g) {

        // muestro los nombres de los atributos
        g.setColor(Color.BLACK);
        Pantalla.centerString(g,
                new Rectangle(x, y + OFFSET_Y_200, MENU.getWidth(), 0),
                personaje.getRaza());
        g.drawString("Casta: ", x + LABEL_OFFSET_X, y + OFFSET_Y_260);
        g.drawString("Nivel: ", x + LABEL_OFFSET_X, y + OFFSET_Y_290);
        g.drawString("Experiencia: ", x + LABEL_OFFSET_X, y + OFFSET_Y_320);

        // muestro los atributos
        g.setFont(new Font("Book Antiqua", 0, FONT_SIZE_20));
        g.drawString(personaje.getCasta(), x + OFFSET_X_100, y + OFFSET_Y_260);
        g.drawString(personaje.getNivel() + " ", x + OFFSET_X_100,
                y + OFFSET_Y_290);
        g.drawString(personaje.getExperiencia() + " / "
                + Personaje.getTablaDeNiveles()[personaje.getNivel() + 1],
                x + OFFSET_X_150, y + OFFSET_Y_320);

    }

    /**
     * Graficar menu item. <br>
     *
     * @param g
     *            Valor g. <br>
     */
    private void graficarMenuItem(final Graphics g) {

        // Informo que subio de nivel
        g.setColor(Color.BLACK);
        Pantalla.centerString(g,
                new Rectangle(x, y + OFFSET_Y_200, MENU.getWidth(), 0),
                "¡Aca iria algo!");

        g.setFont(new Font("Book Antiqua", 0, FONT_SIZE_18));
        Pantalla.centerString(g,
                new Rectangle(x, y + OFFSET_Y_240, MENU.getWidth(), 0),
                "¡Aca otra cosa!");
        Pantalla.centerString(g,
                new Rectangle(x, y + OFFSET_Y_270, MENU.getWidth(), 0),
                "Nuevo Nivel");
        g.setFont(new Font("Book Antiqua", 1, FONT_SIZE_62));
        Pantalla.centerString(g,
                new Rectangle(x, y + OFFSET_Y_325, MENU.getWidth(), 0),
                String.valueOf(personaje.getNivel()));

    }

    /**
     * Graficar menu comerciar. <br>
     *
     * @param g
     *            Valor g. <br>
     */
    private final void graficarMenuComerciar(final Graphics g) {

        // muestro los nombres de los atributos
        g.setColor(Color.BLACK);
        Pantalla.centerString(g,
                new Rectangle(x, y + OFFSET_Y_200, MENU.getWidth(), 0),
                personaje.getRaza());
        g.drawString("Casta: ", x + OFFSET_X_30, y + OFFSET_Y_260);
        g.drawString("Nivel: ", x + OFFSET_X_30, y + OFFSET_Y_290);
        g.drawString("Experiencia: ", x + OFFSET_X_30, y + OFFSET_Y_320);

        // muestro los atributos
        g.setFont(new Font("Book Antiqua", 0, FONT_SIZE_20));
        g.drawString(personaje.getCasta(), x + OFFSET_X_100, y + OFFSET_Y_260);
        g.drawString(personaje.getNivel() + " ", x + OFFSET_X_100,
                y + OFFSET_Y_290);
        g.drawString(personaje.getExperiencia() + " / "
                + Personaje.getTablaDeNiveles()[personaje.getNivel() + 1],
                x + OFFSET_X_150, y + OFFSET_Y_320);

    }

    /**
     * Click en boton. <br>
     *
     * @param mouseX
     *            Valor x del mouse.
     * @param mouseY
     *            Valor y del mouse.
     * @return true, if successful <br>
     */
    public final boolean clickEnBoton(final int mouseX, final int mouseY) {
        return (mouseX >= x + CLCK_BOTON[0] && mouseX <= x + CLCK_BOTON[1]
                && mouseY >= y + CLCK_BOTON[2]
                && mouseY <= y + CLCK_BOTON[INDEX_3]);
    }

    /**
     * Click en cerrar. <br>
     *
     * @param mouseX
     *            Valor x del mouse.
     * @param mouseY
     *            Valor y del mouse.
     * @return true, if successful <br>
     */
    public final boolean clickEnCerrar(final int mouseX, final int mouseY) {
        return (mouseX >= x + MENU.getWidth() - CLCK_CERRAR[0]
                && mouseX <= x + MENU.getWidth() + CLCK_CERRAR[1]
                && mouseY >= y + CLCK_CERRAR[2]
                && mouseY <= y + CLCK_CERRAR[INDEX_3]);
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
        return (mouseX >= x && mouseX <= x + MENU.getWidth() && mouseY >= y
                && mouseY <= y + MENU.getHeight());
    }
}
