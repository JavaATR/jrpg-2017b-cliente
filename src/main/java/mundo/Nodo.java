package mundo;

public class Nodo {
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
	 * @param indice
	 *            Indice. <br>
	 * @param x
	 *            Posición X. <br>
	 * @param y
	 *            Posición Y. <br>
	 */
	public Nodo(final int indice, final int x, final int y) {
		this.x = x;
		this.y = y;
		this.indice = indice;
		this.cantidadDeAdyacentes = 0;
		this.nodosAdyacentes = new Nodo[8];
	}

	/**
	 * Devuelve la posición X. <br>
	 * @return Posición X. <br>
	 */
	public int obtenerX() {
		return this.x;
	}

	/**
	 * Devuelve la posición Y. <br>
	 * @return Posición Y. <br>
	 */
	public int obtenerY() {
		return this.y;
	}

	/**
	 * Devuelve el Indice. <br>
	 * @return Indice. <br>
	 */
	public int obtenerIndice() {
		return this.indice;
	}

	/**
	 * Devuelve los nodos adyacentes. <br>
	 * @return Nodos adyacentes. <br>
	 */
	public Nodo[] obtenerNodosAdyacentes() {
		return this.nodosAdyacentes;
	}

	/**
	 * Agrega un nodo adyacente. <br>
	 * @param nodo
	 *            Nodo. <br>
	 */
	public void agregarAdyacente(final Nodo nodo) {
		this.nodosAdyacentes[this.cantidadDeAdyacentes++] = nodo;
	}

	/**
	 * Obtiene la cantidad de nodos adyacentes. <br>
	 * @return Cantidad de nodos adyacentes. <br>
	 */
	public int obtenerCantidadDeAdyacentes() {
		return this.cantidadDeAdyacentes;
	}
}
