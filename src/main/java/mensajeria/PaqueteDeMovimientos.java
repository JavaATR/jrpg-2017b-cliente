package mensajeria;

import java.io.Serializable;
import java.util.Map;

/**
 * Clase PaqueteDeMovimientos.
 */
public class PaqueteDeMovimientos extends Paquete
        implements Serializable, Cloneable {

    /** Atributo personajes. */
    private Map<Integer, PaqueteMovimiento> personajes;

    /**
     * Constructor por defecto paquete de movimientos.
     */
    public PaqueteDeMovimientos() {

    }

    /**
     * Constructor parametrizado paquete de movimientos. <br>
     *
     * @param characters
     *            Map para asignar personajes. <br>
     */
    public PaqueteDeMovimientos(Map<Integer, PaqueteMovimiento> characters) {
        this.personajes = characters;
    }

    /**
     * Obtiene personajes.
     *
     * @return personajes
     */
    public final Map<Integer, PaqueteMovimiento> getPersonajes() {
        return personajes;
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
