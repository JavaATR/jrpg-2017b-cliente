package mensajeria;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
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
	 * 		Valor para asignar id de personaje.
	 * @param user
	 * 		Valor para asignar nombre de usuario.
	 * @param pw
	 * 		Valor para asignar password. <br>
	 */
	public PaqueteUsuario(int pj, String user, String pw) {
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
	 * @param idPj
	 * 		Valor para asignar id de personaje. <br>
	 */
	public void setIdPj(int idPj) {
		this.idPj = idPj;
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
	 * 		Valor para asignar nombre de usuario. <br>
	 */
	public void setUsername(String user) {
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
	 * 		Valor para asignar password. <br>
	 */
	public void setPassword(String pass) {
		this.password = pass;
	}

	public boolean isInicioSesion() {
		return inicioSesion;
	}

	/**
	 * Sets inicio sesion. <br>
	 *
	 * @param initSesion
	 * 		Valor para setear inicio de sesión. <br>
	 */
	public void setInicioSesion(boolean initSesion) {
		this.inicioSesion = initSesion;
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
