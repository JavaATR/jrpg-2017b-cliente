package entidades;

/**
 * Clase Nodo de Pila
 */
public class NodoDePila {

    /** Atributo x. */
    private int x;
    /** Atributo y. */
    private int y;
    /** Atributo ptrSiguiente. */
    private NodoDePila ptrSiguiente;

    /**
     * Constructor de la clase Nodo de Pila.
     *
     * @param xValue
     *            valor de x donde esta el personaje
     * @param yValue
     *            valor de y donde esta el personaje
     */
    public NodoDePila(final int xValue, final int yValue) {
        this.x = xValue;
        this.y = yValue;
        ptrSiguiente = null;
    }

    /**
     * Pide el siguiente.
     *
     * @return devuelve un nodo de pila con el siguiente
     */
    public NodoDePila obtenerSiguiente() {
        return ptrSiguiente;
    }

    /**
     * Setea el siguiente.
     *
     * @param nodo
     *            nuevo nodo a setear
     */
    public void establecerSiguiente(NodoDePila nodo) {
        ptrSiguiente = nodo;
    }

    /**
     * Pide el valor de X.
     *
     * @return devuelve el valor de X
     */
    public int obtenerX() {
        return x;
    }

    /**
     * Pide el valor de Y.
     *
     * @return devuelve el valor de Y
     */
    public int obtenerY() {
        return y;
    }

}
