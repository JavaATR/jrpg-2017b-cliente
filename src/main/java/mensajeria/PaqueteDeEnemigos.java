package mensajeria;

import java.io.Serializable;
import java.util.Map;

/**
 * Clase PaqueteDeEnemigos.
 */
public class PaqueteDeEnemigos extends Paquete
        implements Serializable, Cloneable {

    /** Atributo enemigos. */
    private Map<Integer, PaqueteEnemigo> enemigos;

    /**
     * Constructor por defecto paquete de enemigos.
     */
    public PaqueteDeEnemigos() {

    }

    /**
     * Constructor parametrizado paquete de enemigos. <br>
     *
     * @param enemies
     *            Map para asignar enemigos. <br>
     */
    public PaqueteDeEnemigos(final Map<Integer, PaqueteEnemigo> enemies) {
        this.enemigos = enemies;
    }

    /**
     * Obtiene enemigos.
     *
     * @return enemigos
     */
    public final Map<Integer, PaqueteEnemigo> getEnemigos() {
        return enemigos;
    }

    /*
     * (non-Javadoc)
     * @see mensajeria.Paquete#clone()
     */
    @Override
    public Object clone() {
        Object obj = null;
        obj = super.clone();
        return obj;
    }
}
