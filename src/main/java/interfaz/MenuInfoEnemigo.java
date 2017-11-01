package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import dominio.Personaje;
import juego.Pantalla;
import mensajeria.PaqueteEnemigo;
import recursos.Recursos;

// TODO: Auto-generated Javadoc
/**
 * Clase MenuInfoEnemigo.
 */
public class MenuInfoEnemigo {
    /** Constante tres. */
    private static final int TRES = 3;
    /** Constante seis. */
    private static final int SEIS = 6;

    /** Constante Y_OFFSET_200. */
    private static final int Y_OFFSET_200 = 200;

    /** Constante NUM_3. */
    private static final int NUM_3 = 3;

    /** Constante X_OFFSET_150. */
    private static final int X_OFFSET_150 = 150;

    /** Constante Y_OFFSET_320. */
    private static final int Y_OFFSET_320 = 320;

    /** Constante HEIGHT_PARAM. */
    private static final int HEIGHT_PARAM = 3;

    /** Constante NUM_15. */
    private static final int NUM_15 = 15;

    /** Constante NUM_128. */
    private static final int NUM_128 = 128;

    /** Constante NUM_70. */
    private static final int NUM_70 = 70;

    /** Constante Y_OFFSET_290. */
    private static final int Y_OFFSET_290 = 290;

    /** Constante Y_OFFSET_260. */
    private static final int Y_OFFSET_260 = 260;

    /** Constante X_OFFSET_100. */
    private static final int X_OFFSET_100 = 100;

    /** Constante X_OFFSET_30. */
    private static final int X_OFFSET_30 = 30;

    /** Constante INDEX. */
    private static final int INDEX = 6;

    /** Constante FONT_SIZE_20. */
    private static final int FONT_SIZE_20 = 20;

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

    /** Constante leyendaBoton. */
    private static final String[] LEYENDA_BOTON = {"Batallar", "Volver",
            "Aceptar", "Aceptar", "Aceptar", "Aceptar", "Comerciar"};
    /** Constante BTN_OFFSET. */
    public static final int[] BTN_OFFSET = {50, 380, 200, 25};
    /** Constante CLCK_CERRAR. */
    public static final int[] CLCK_CERRAR = {24, 4, 12, 36};
    /** Constante CLCK_BOTON. */
    public static final int[] CLCK_BOTON = {50, 250, 380, 405};

    /** Atributo x. */
    private int x;

    /** Atributo y. */
    private int y;

    /** Atributo enemigo. */
    private PaqueteEnemigo enemigo;

    /**
     * Constructor menu info enemigo. <br>
     *
     * @param xValue
     *            valor x.
     * @param yValue
     *            valor y.
     * @param enemy
     *            the enemy
     */
    public MenuInfoEnemigo(final int xValue, final int yValue,
            final PaqueteEnemigo enemy) {
        this.x = xValue;
        this.y = yValue;
        this.enemigo = enemy;
    }

    /**
     * Graficar. <br>
     *
     * @param g
     *            Valor g.
     * @param tipoMenu
     *            Valor tipo ode menu.<br>
     */
    public final void graficar(final Graphics g, final int tipoMenu) {

        // dibujo el menu
        g.drawImage(MENU, x, y, null);

        // dibujo el personaje
        g.drawImage(Recursos.elBryan.get(INDEX)[0],
                x + MENU.getWidth() / 2 - ANCHO_PERSONAJE / 2, y + NUM_70,
                NUM_128, NUM_128, null);

        // muestro el nombre
        g.setColor(Color.WHITE);
        g.setFont(new Font("Book Antiqua", 1, FONT_SIZE_20));
        Pantalla.centerString(g,
                new Rectangle(x, y + NUM_15, MENU.getWidth(), 0), "El Bryan");

        // Grafico la leyenda segun el tipo de menu
        switch (tipoMenu) {
        case MENU_BATALLAR:
            graficarMenuInformacion(g);
            break;
        }

        // muestro los botones
        g.setFont(new Font("Book Antiqua", 1, FONT_SIZE_20));
        g.drawImage(Recursos.getBotonMenu(), x + BTN_OFFSET[0],
                y + BTN_OFFSET[1], BTN_OFFSET[2], BTN_OFFSET[HEIGHT_PARAM],
                null);
        g.setColor(Color.WHITE);
        Pantalla.centerString(g,
                new Rectangle(x + BTN_OFFSET[0], y + BTN_OFFSET[1],
                        BTN_OFFSET[2], BTN_OFFSET[HEIGHT_PARAM]),
                LEYENDA_BOTON[tipoMenu]);
    }

    // private void graficarMenuPerderBatalla(Graphics g) {
    //
    // // Informo que perdio la batalla
    // g.setColor(Color.BLACK);
    // Pantalla.centerString(g, new Rectangle(x, y + 200, menu.getWidth(), 0),
    // "¡Has sido derrotado!");
    //
    // g.setFont(new Font("Book Antiqua", 0, 14));
    // Pantalla.centerString(g, new Rectangle(x, y + 250, menu.getWidth(), 0),
    // "¡No te rindas! Sigue luchando");
    // Pantalla.centerString(g, new Rectangle(x, y + 270, menu.getWidth(), 0),
    // "contra los demás personajes");
    // Pantalla.centerString(g, new Rectangle(x, y + 290, menu.getWidth(), 0),
    // "para aumentar tu nivel y");
    // Pantalla.centerString(g, new Rectangle(x, y + 310, menu.getWidth(), 0),
    // "mejorar tus atributos.");
    // }
    //
    // private void graficarMenuGanarBatalla(Graphics g) {
    //
    // // Informo que gano la batalla
    // g.setColor(Color.BLACK);
    // Pantalla.centerString(g, new Rectangle(x, y + 200, menu.getWidth(), 0),
    // "¡Has derrotado");
    // Pantalla.centerString(g, new Rectangle(x, y + 230, menu.getWidth(), 0),
    // "a tu enemigo!");
    //
    // g.setFont(new Font("Book Antiqua", 0, 14));
    // Pantalla.centerString(g, new Rectangle(x, y + 270, menu.getWidth(), 0),
    // "¡Felicitaciones! Has derrotado");
    // Pantalla.centerString(g, new Rectangle(x, y + 290, menu.getWidth(), 0),
    // "a tu oponente, sigue así");
    // Pantalla.centerString(g, new Rectangle(x, y + 310, menu.getWidth(), 0),
    // "para lograr subir de nivel");
    // Pantalla.centerString(g, new Rectangle(x, y + 330, menu.getWidth(), 0),
    // "y mejorar tus atributos.");
    //
    // }
    //
    // private void graficarMenuSubirNivel(Graphics g) {
    //
    // // Informo que subio de nivel
    // g.setColor(Color.BLACK);
    // Pantalla.centerString(g, new Rectangle(x, y + 200, menu.getWidth(), 0),
    // "¡Has subido de nivel!");
    //
    // g.setFont(new Font("Book Antiqua", 0, 18));
    // Pantalla.centerString(g, new Rectangle(x, y + 240, menu.getWidth(), 0),
    // "¡Felicitaciones!");
    // Pantalla.centerString(g, new Rectangle(x, y + 270, menu.getWidth(), 0),
    // "Nuevo Nivel");
    // g.setFont(new Font("Book Antiqua", 1, 62));
    // Pantalla.centerString(g, new Rectangle(x, y + 325, menu.getWidth(), 0),
    // String.valueOf(personaje.getNivel()));
    //
    // }
    /**
     * Graficar menu información. <br>
     *
     * @param g
     *            Valor g. <br>
     */
    //
    public final void graficarMenuInformacion(final Graphics g) {

        // muestro los nombres de los atributos
        g.setColor(Color.BLACK);
        Pantalla.centerString(g,
                new Rectangle(x, y + Y_OFFSET_200, MENU.getWidth(), 0),
                "El Bryan");
        g.drawString("Casta: ", x + X_OFFSET_30, y + Y_OFFSET_260);
        g.drawString("Nivel: ", x + X_OFFSET_30, y + Y_OFFSET_290);
        g.drawString("Experiencia: ", x + X_OFFSET_30, y + Y_OFFSET_320);

        // muestro los atributos
        g.setFont(new Font("Book Antiqua", 0, FONT_SIZE_20));
        g.drawString("Ladrón", x + X_OFFSET_100, y + Y_OFFSET_260);
        g.drawString(TRES + " ", x + X_OFFSET_100, y + Y_OFFSET_290);
        g.drawString(0 + " / " + Personaje.getTablaDeNiveles()[SEIS + 1],
                x + X_OFFSET_150, y + Y_OFFSET_320);
    }
    //
    // private void graficarMenuItem(Graphics g) {
    //
    // // Informo que subio de nivel
    // g.setColor(Color.BLACK);
    // Pantalla.centerString(g, new Rectangle(x, y + 200, menu.getWidth(), 0),
    // "¡Aca iria algo!");
    //
    // g.setFont(new Font("Book Antiqua", 0, 18));
    // Pantalla.centerString(g, new Rectangle(x, y + 240, menu.getWidth(), 0),
    // "¡Aca otra cosa!");
    // Pantalla.centerString(g, new Rectangle(x, y + 270, menu.getWidth(), 0),
    // "Nuevo Nivel");
    // g.setFont(new Font("Book Antiqua", 1, 62));
    // Pantalla.centerString(g, new Rectangle(x, y + 325, menu.getWidth(), 0),
    // String.valueOf(personaje.getNivel()));
    //
    // }
    //
    // private void graficarMenuComerciar(Graphics g){
    //
    // // muestro los nombres de los atributos
    // g.setColor(Color.BLACK);
    // Pantalla.centerString(g, new Rectangle(x, y + 200, menu.getWidth(), 0),
    // personaje.getRaza());
    // g.drawString("Casta: ", x + 30, y + 260);
    // g.drawString("Nivel: ", x + 30, y + 290);
    // g.drawString("Experiencia: ", x + 30, y + 320);
    //
    // // muestro los atributos
    // g.setFont(new Font("Book Antiqua", 0, 20));
    // g.drawString(personaje.getCasta(), x + 100, y + 260);
    // g.drawString(personaje.getNivel() + " ", x + 100, y + 290);
    // g.drawString(personaje.getExperiencia() + " / " +
    // Personaje.getTablaDeNiveles()[personaje.getNivel() + 1], x + 150, y +
    // 320);
    //
    // }

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
                && mouseY <= y + CLCK_BOTON[NUM_3]);
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
                && mouseY <= y + CLCK_CERRAR[NUM_3]);
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
