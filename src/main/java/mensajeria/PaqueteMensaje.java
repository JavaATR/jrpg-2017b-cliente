package mensajeria;

import java.io.Serializable;

/**
 * Clase PaqueteMensaje.
 */
public class PaqueteMensaje extends Paquete implements Serializable, Cloneable {

    /** Atributo user emisor. */
    private String userEmisor;

    /** Atributo user receptor. */
    private String userReceptor;

    /** Atributo msj. */
    private String msj;

    /**
     * Constructor paquete mensaje.
     */
    public PaqueteMensaje() {
    }

    /**
     * Obtiene mensaje.
     *
     * @return mensaje
     */
    public String getMensaje() {
        return msj;
    }

    /**
     * Asignar mensaje. <br>
     *
     * @param mensaje
     *            String para asignar mensaje. <br>
     */
    public void setMensaje(final String mensaje) {
        this.msj = mensaje;
    }

    /**
     * Obtiene user emisor.
     *
     * @return user emisor
     */
    public final String getUserEmisor() {
        return userEmisor;
    }

    /**
     * Asignar user emisor. <br>
     *
     * @param idEmisor
     *            Valor para asignar user emisor. <br>
     */
    public final void setUserEmisor(final String idEmisor) {
        this.userEmisor = idEmisor;
    }

    /**
     * Obtiene user receptor.
     *
     * @return user receptor
     */
    public final String getUserReceptor() {
        return userReceptor;
    }

    /**
     * Asignar user receptor. <br>
     *
     * @param idReceptor
     *            Valor para asignar user receptor. <br>
     */
    public final void setUserReceptor(final String idReceptor) {
        this.userReceptor = idReceptor;
    }

    /**
     * Object clone. <br>
     *
     * @return obj <br>
     */
    public final Object clone() {
        Object obj = null;
        obj = super.clone();
        return obj;
    }
}
