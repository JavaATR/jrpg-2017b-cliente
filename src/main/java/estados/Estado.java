package estados;

import java.awt.Graphics;

import juego.Juego;

/**
 * Clase que administra los estados del juego. <br>
 */
public abstract class Estado {
    /**
     * Estado actual del juego. <br>
     */
    private static Estado estadoActual = null;
    // Tipo de estados
    /**
     * Estado offline. <br>
     */
    public static int estadoOffline = 0;
    /**
     * Estado en juego. <br>
     */
    public static int estadoJuego = 1;
    /**
     * Estado en batalla. <br>
     */
    public static int estadoBatalla = 2;
    /**
     * Juego. <br>
     */
    protected Juego juego;

    /**
     * Crea el estado del juego. <br>
     *
     * @param game
     *            Juego. <br>
     */
    public Estado(final Juego game) {
        this.juego = game;
    }

    /**
     * Actualiza el juego. <br>
     */
    public abstract void actualizar();

    /**
     * Grafica el juego. <br>
     *
     * @param g
     *            Graficador. <br>
     */
    public abstract void graficar(final Graphics g);

    /**
     * Establece el estado del juego. <br>
     *
     * @param estado
     *            Estado del juego. <br>
     */
    public static void setEstado(final Estado estado) {
        estadoActual = estado;
    }

    /**
     * Devuelve el estado actual del juego. <br>
     *
     * @return Estado actual. <br>
     */
    public static Estado getEstado() {
        return estadoActual;
    }

    /**
     * Indica el estado en juego. <br>
     *
     * @return true si lo esta, false de lo contrario. <br>
     */
    public abstract boolean esEstadoDeJuego();
}
