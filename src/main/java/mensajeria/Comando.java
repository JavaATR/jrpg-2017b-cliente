package mensajeria;

import com.google.gson.Gson;

/**
 * Clase Comando.
 */
public abstract class Comando {
	/** Nombre del paquete donde se encuentran las clases con las responsabilidades. */
	public static final String NOMBREPAQUETE = "comandos";

	/** Constante CLASSNAMES. */
	public static final String[] CLASSNAMES = {"Conexion", "CrearPersonaje",
			"Desconectar", "InicioSesion", "MostrarMapas", "Movimiento",
			"Registro", "Salir", "Batalla", "Atacar", "FinalizarBatalla",
			"ActualizarPersonaje", "ActualizarPersonajeLvl",
			"ActualizarInventario", "Comercio", "ActualizarComercio", "Trueque",
			"ActualizarTrueque", "Talk", "ActualizarEnemigos",
			"UbicacionEnemigos" };

	/** Constante CLASSNAMESBIS. */
	public static final String[] CLASSNAMESBIS = {"Conexion", "CrearPersonaje",
			"Desconectar", "InicioSesionSet", "MostrarMapas", "Movimiento",
			"RegistroSet", "SalirSet", "Batalla", "Atacar", "FinalizarBatalla",
			"ActualizarPersonaje", "ActualizarPersonajeLvl",
			"ActualizarInventario", "Comercio", "ActualizarComercio", "Trueque",
			"ActualizarTrueque", "Talk", "ActualizarEnemigos",
			"UbicacionEnemigos" };

	/** Constante CONEXION. */
	public static final int CONEXION = 0;

	/** Constante CREACIONPJ. */
	public static final int CREACIONPJ = 1;

	/** Constante DESCONECTAR. */
	public static final int DESCONECTAR = 2;

	/** Constante INICIOSESION. */
	public static final int INICIOSESION = 3;

	/** Constante MOSTRARMAPAS. */
	public static final int MOSTRARMAPAS = 4;

	/** Constante MOVIMIENTO. */
	public static final int MOVIMIENTO = 5;

	/** Constante REGISTRO. */
	public static final int REGISTRO = 6;

	/** Constante SALIR. */
	public static final int SALIR = 7;

	/** Constante BATALLA. */
	public static final int BATALLA = 8;

	/** Constante ATACAR. */
	public static final int ATACAR = 9;

	/** Constante FINALIZARBATALLA. */
	public static final int FINALIZARBATALLA = 10;

	/** Constante ACTUALIZARPERSONAJE. */
	public static final int ACTUALIZARPERSONAJE = 11;

	/** Constante ACTUALIZARPERSONAJELV. */
	public static final int ACTUALIZARPERSONAJELV = 12;

	/** Constante ACTUALIZARINVENTARIO. */
	public static final int ACTUALIZARINVENTARIO = 13;

	/** Constante COMERCIO. */
	public static final int COMERCIO = 14;

	/** Constante ACTUALIZARCOMERCIO. */
	public static final int ACTUALIZARCOMERCIO = 15;

	/** Constante TRUEQUE. */
	public static final int TRUEQUE = 16;

	/** Constante ACTUALIZARTRUEQUE. */
	public static final int ACTUALIZARTRUEQUE = 17;

	/** Constante TALK. */
	public static final int TALK = 18;

	/** Constante CONEXIONENEMIGOS. */
	public static final int CONEXIONENEMIGOS = 19;

	/** Constante UBICACIONENEMIGOS. */
	public static final int UBICACIONENEMIGOS = 20;

	/** The gson. */
	protected final Gson gson = new Gson();

	/** Atributo cadena leida. */
	protected String cadenaLeida;

	/**
	 * Asignar cadena. <br>
	 *
	 * @param readString
	 * 		String para asignar cadena leída. <br>
	 */
	public void setCadena(String readString) {
		this.cadenaLeida = readString;
	}

	/**
	 * Ejecutar.
	 */
	public abstract void ejecutar();
}
