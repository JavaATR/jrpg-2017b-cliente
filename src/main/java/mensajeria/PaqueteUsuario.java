package mensajeria;

import java.io.Serializable;

/**
 * Clase PaqueteUsuario.
 */
public class PaqueteUsuario extends Paquete implements Serializable, Cloneable {

    /** Atributo id pj. */
    private int idPj;

    /** Atributo username. */
    private String username;

    /** Atributo password. */
    private String password;

    /** Atributo inicio sesion. */
    private boolean inicioSesion;

    /**
     * Constructor por defecto.
     */
    public PaqueteUsuario() {

    }

    /**
     * Constructor paquete usuario. <br>
     *
     * @param pj
     *            Valor para asignar id de personaje.
     * @param user
     *            Valor para asignar nombre de usuario.
     * @param pw
     *            Valor para asignar password. <br>
     */
    public PaqueteUsuario(final int pj, final String user, final String pw) {
        idPj = pj;
        username = user;
        password = pw;
        inicioSesion = false;
    }

    /**
     * Obtiene id pj.
     *
     * @return id pj
     */
    public int getIdPj() {
        return idPj;
    }

    /**
     * Sets id pj. <br>
     *
     * @param idPersonaje
     *            Valor para asignar id de personaje. <br>
     */
    public void setIdPj(final int idPersonaje) {
        this.idPj = idPersonaje;
    }

    /**
     * Obtiene the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username. <br>
     *
     * @param user
     *            Valor para asignar nombre de usuario. <br>
     */
    public void setUsername(final String user) {
        this.username = user;
    }

    /**
     * Obtiene password.
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password. <br>
     *
     * @param pass
     *            Valor para asignar password. <br>
     */
    public void setPassword(final String pass) {
        this.password = pass;
    }

    /**
     * Checks inicio de sesion. <br>
     *
     * @return inicioSesion
     */
    public final boolean isInicioSesion() {
        return inicioSesion;
    }

    /**
     * Sets inicio sesion. <br>
     *
     * @param initSesion
     *            Valor para setear inicio de sesión. <br>
     */
    public final void setInicioSesion(final boolean initSesion) {
        this.inicioSesion = initSesion;
    }

    /*
     * (non-Javadoc)
     *
     * @see mensajeria.Paquete#clone()
     */
    @Override
    public final Object clone() {
        Object obj = null;
        obj = super.clone();
        return obj;
    }
}
