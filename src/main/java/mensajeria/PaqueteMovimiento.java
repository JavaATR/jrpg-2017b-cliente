package mensajeria;

import java.io.Serializable;

/**
 * Clase PaqueteMovimiento.
 */
public class PaqueteMovimiento extends Paquete
        implements Serializable, Cloneable {

    /** Atributo id. */
    private int id;

    /** Atributo pos X. */
    private float posX;

    /** Atributo pos Y. */
    private float posY;

    /** Atributo direccion. */
    private int direccion;

    /** Atributo frame. */
    private int frame;

    /**
     * Constructor paquete movimiento.
     */
    public PaqueteMovimiento() {
        setComando(Comando.MOVIMIENTO);
    }

    /**
     * Constructor parametrizado. <br>
     *
     * @param idPersonaje
     *            Valor para asignar id de personaje. <br>
     */
    public PaqueteMovimiento(final int idPersonaje) {
        id = idPersonaje;
        setComando(Comando.MOVIMIENTO);
    }

    /**
     * Constructor parametrizado. <br>
     *
     * @param idPersonaje
     *            Valor para asignar id de personaje.
     * @param posicionX
     *            Valor para asignar posicion x.
     * @param posicionY
     *            Valor para asignar posicion Y. <br>
     */
    public PaqueteMovimiento(final int idPersonaje, final float posicionX,
            final float posicionY) {
        this.id = idPersonaje;
        this.posX = posicionX;
        this.posY = posicionY;
        setComando(Comando.MOVIMIENTO);
    }

    /**
     * Obtiene id personaje.
     *
     * @return id personaje
     */
    public int getIdPersonaje() {
        return id;
    }

    /**
     * Asignar id personaje. <br>
     *
     * @param idPersonaje
     *            Valor para asignar id del personaje. <br>
     */
    public void setIdPersonaje(final int idPersonaje) {
        this.id = idPersonaje;
    }

    /**
     * Obtiene pos X.
     *
     * @return pos X
     */
    public float getPosX() {
        return posX;
    }

    /**
     * Asignar posicion X. <br>
     *
     * @param posicionX
     *            Valor para asignar posicion X. <br>
     */
    public void setPosX(final float posicionX) {
        this.posX = posicionX;
    }

    /**
     * Obtiene pos Y.
     *
     * @return pos Y
     */
    public float getPosY() {
        return posY;
    }

    /**
     * Asignar posicion Y. <br>
     *
     * @param posicionY
     *            Valor para asignar posicion Y. <br>
     */
    public void setPosY(final float posicionY) {
        this.posY = posicionY;
    }

    /**
     * Obtiene direccion.
     *
     * @return direccion
     */
    public int getDireccion() {
        return direccion;
    }

    /**
     * Asignar direccion. <br>
     *
     * @param dir
     *            Valor para asignar dirección. <br>
     */
    public void setDireccion(final int dir) {
        this.direccion = dir;
    }

    /**
     * Obtiene frame.
     *
     * @return frame
     */
    public int getFrame() {
        return frame;
    }

    /**
     * Asignar frame. <br>
     *
     * @param marco
     *            Valor para asignar frame. <br>
     */
    public void setFrame(final int marco) {
        this.frame = marco;
    }

    /*
     * (non-Javadoc)
     *
     * @see mensajeria.Paquete#clone()
     */
    @Override
    public Object clone() {
        Object obj = null;
        obj = super.clone();
        return obj;
    }
}
