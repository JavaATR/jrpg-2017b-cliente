package mensajeria;

import java.io.Serializable;
import java.util.Map;

/**
 * Clase PaqueteDeUbicacionEnemigos.
 */
public class PaqueteDeUbicacionEnemigos extends Paquete
        implements Serializable, Cloneable {

    /** Atributo enemigos. */
    private Map<Integer, PaqueteMovimiento> enemigos;

    /**
     * Constructor paquete de ubicacion enemigos.
     */
    public PaqueteDeUbicacionEnemigos() {

    }

    /**
     * Constructor parametrizado new paquete de ubicacion enemigos. <br>
     *
     * @param enemies
     *            Map para asignar enemigos. <br>
     */
    public PaqueteDeUbicacionEnemigos(
            final Map<Integer, PaqueteMovimiento> enemies) {
        this.enemigos = enemies;
    }

    /**
     * Obtiene enemigos.
     *
     * @return enemigos
     */
    public final Map<Integer, PaqueteMovimiento> getEnemigos() {
        return enemigos;
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
