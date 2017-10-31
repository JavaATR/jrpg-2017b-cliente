package mundo;

/**
 * Clase Nodo.
 */
public class Nodo {

	/** Constante. */
	private static final int NODO_VALUE = 8;
	/**
	 * Posición X. <br>
	 */
	private int x;
	/**
	 * Posición Y. <br>
	 */
	private int y;
	/**
	 * Indice. <br>
	 */
	private int indice;
	/**
	 * Cantidad de adyacentes. <br>
	 */
	private int cantidadDeAdyacentes;
	/**
	 * Nodos adyacenetes. <br>
	 */
	private Nodo[] nodosAdyacentes;

	/**
	 * Crea un nodo con su posición. <br>
	 *
	 * @param index
	 *            Indice. <br>
	 * @param xValue
	 *            Posición X. <br>
	 * @param yValue
	 *            Posición Y. <br>
	 */
	public Nodo(final int index, final int xValue, final int yValue) {
		this.x = xValue;
		this.y = yValue;
		this.indice = index;
		this.cantidadDeAdyacentes = 0;
		this.nodosAdyacentes = new Nodo[NODO_VALUE];
	}

	/**
	 * Devuelve la posición X. <br>
	 *
	 * @return Posición X. <br>
	 */
	public int obtenerX() {
		return this.x;
	}

	/**
	 * Devuelve la posición Y. <br>
	 *
	 * @return Posición Y. <br>
	 */
	public int obtenerY() {
		return this.y;
	}

	/**
	 * Devuelve el Indice. <br>
	 *
	 * @return Indice. <br>
	 */
	public int obtenerIndice() {
		return this.indice;
	}

	/**
	 * Devuelve los nodos adyacentes. <br>
	 *
	 * @return Nodos adyacentes. <br>
	 */
	public Nodo[] obtenerNodosAdyacentes() {
		return this.nodosAdyacentes;
	}

	/**
	 * Agrega un nodo adyacente. <br>
	 *
	 * @param nodo
	 *            Nodo. <br>
	 */
	public void agregarAdyacente(final Nodo nodo) {
		this.nodosAdyacentes[this.cantidadDeAdyacentes++] = nodo;
	}

	/**
	 * Obtiene la cantidad de nodos adyacentes. <br>
	 *
	 * @return Cantidad de nodos adyacentes. <br>
	 */
	public int obtenerCantidadDeAdyacentes() {
		return this.cantidadDeAdyacentes;
	}
}
