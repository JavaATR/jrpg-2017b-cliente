package entidades;

import java.awt.image.BufferedImage;

/**
 * La clase Animacion tiene como función controlar las animaciones.
 */
public class Animacion {

    /** Atributo velocidad. */
    private int velocidad;
    /** Atributo indice. */
    private int indice;
    /** Atributos ultimo tiempo y timer. */
    private long ultimoTiempo, timer;
    /** Atributo frames. */
    private BufferedImage[] frames;

    /**
     * Constructor de la clase. <br>
     *
     * @param velocity
     *            velocidad con la cual se actualiza. <br>
     * @param marcos
     *            imagen de frame. <br>
     */
    public Animacion(final int velocity, final BufferedImage[] marcos) {
        this.velocidad = velocity;
        this.frames = marcos;
        indice = 0;
        timer = 0;
        ultimoTiempo = System.currentTimeMillis();
    }

    /**
     * Actualiza los frames. <br>
     */
    public final void actualizar() {
        timer += System.currentTimeMillis() - ultimoTiempo;
        ultimoTiempo = System.currentTimeMillis();

        if (timer > velocidad) {
            indice++;
            timer = 0;
            if (indice >= frames.length) {
                indice = 0;
            }
        }
    }

    /**
     * Resetea el indice. <br>
     */
    public final void reset() {
        indice = 0;
    }

    /**
     * Pide el frame actual. <br>
     *
     * @return devuelve el valor del frame en un indice. <br>
     */
    public final BufferedImage getFrameActual() {
        return frames[indice];
    }

    /**
     * Pide el frame. <br>
     *
     * @return devuelve el indice del frame. <br>
     */
    public final int getFrame() {
        return indice;
    }
}
