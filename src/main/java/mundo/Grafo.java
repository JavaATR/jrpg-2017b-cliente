package mundo;

/**
 * Clase que administra los grafos. <br>
 */
public class Grafo {
    /**
     * Cantidad de nodos del gráfo. <br>
     */
    private int cantidadDeNodos;
    /**
     * Cantidad de nodos total. <br>
     */
    private int cantidadDeNodosTotal;
    /**
     * Nodos del grafo. <br>
     */
    private Nodo[] nodos;

    /**
     * Crea un gráfo. <br>
     *
     * @param cantidadDeNodosTotal
     *            Cantidad total de nodos. <br>
     */
    public Grafo(final int cantidadDeNodosTotal) {
        this.cantidadDeNodos = 0;
        this.nodos = new Nodo[cantidadDeNodosTotal];
        this.cantidadDeNodosTotal = cantidadDeNodosTotal;
    }

    /**
     * Agrega un nodo al gráfo. <br>
     *
     * @param nodo
     *            Nuevo nodo. <br>
     */
    public final void agregarNodo(final Nodo nodo) {
        this.nodos[cantidadDeNodos++] = nodo;
    }

    /**
     * Agrega un nodo adyacente a otro nodo. <br>
     *
     * @param nodoUno
     *            Nodo. <br>
     * @param nodoDos
     *            Nodo adyacente. <br>
     */
    public final void agregarAdyacentes(final Nodo nodoUno, final Nodo nodoDos) {
        nodoUno.agregarAdyacente(nodoDos);
    }

    /**
     * Devuelve los nodos del gráfo. <br>
     *
     * @return Nodos. <br>
     */
    public final Nodo[] obtenerNodos() {
        return this.nodos;
    }

    /**
     * Devuelve la cantidad de nodos del gráfo. <br>
     *
     * @return Cantidad de nodos del gráfo. <br>
     */
    public final int obtenerCantidadDeNodos() {
        return this.cantidadDeNodos;
    }

    /**
     * Devuelve la cantidad total de nodos del gráfo. <br>
     *
     * @return Cantidad total de nodos. <br>
     */
    public final int obtenerCantidadDeNodosTotal() {
        return this.cantidadDeNodosTotal;
    }
}
