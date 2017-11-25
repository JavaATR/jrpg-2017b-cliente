package mensajeria;

import java.io.Serializable;
import java.util.Map;

/**
 * Clase PaqueteDePersonajes.
 */
public class PaqueteDePersonajes extends Paquete
        implements Serializable, Cloneable {

    /** Atributo personajes. */
    private Map<Integer, PaquetePersonaje> personajes;

    /**
     * Constructor paquete de personajes.
     */
    public PaqueteDePersonajes() {

    }

    /**
     * Constructor parametrizado paquete de personajes. <br>
     *
     * @param characters
     *            Map para asignar personajes. <br>
     */
    public PaqueteDePersonajes(Map<Integer, PaquetePersonaje> characters) {
        this.personajes = characters;
    }

    /**
     * Obtiene personajes.
     *
     * @return personajes
     */
    public final Map<Integer, PaquetePersonaje> getPersonajes() {
        return personajes;
    }

    /*
     * (non-Javadoc)
     * @see mensajeria.Paquete#clone()
     */
    @Override
    public final Object clone() {
        Object obj = null;
        obj = super.clone();
        return obj;
    }
}
