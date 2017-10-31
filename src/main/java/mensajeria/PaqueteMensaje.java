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
	public void setMensaje(String mensaje) {
		this.msj = mensaje;
	}

	/**
	 * Obtiene user emisor.
	 *
	 * @return user emisor
	 */
	public String getUserEmisor() {
		return userEmisor;
	}

	/**
	 * Asignar user emisor. <br>
	 *
	 * @param idEmisor
	 *            Valor para asignar user emisor. <br>
	 */
	public void setUserEmisor(String idEmisor) {
		this.userEmisor = idEmisor;
	}

	/**
	 * Obtiene user receptor.
	 *
	 * @return user receptor
	 */
	public String getUserReceptor() {
		return userReceptor;
	}

	/**
	 * Asignar user receptor. <br>
	 *
	 * @param idReceptor
	 *            Valor para asignar user receptor. <br>
	 */
	public void setUserReceptor(String idReceptor) {
		this.userReceptor = idReceptor;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see mensajeria.Paquete#clone()
	 */
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}
}
