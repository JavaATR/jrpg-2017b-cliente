package mensajeria;

import java.io.Serializable;

/**
 * Clase PaqueteFinalizarBatalla.
 */
public class PaqueteFinalizarBatalla extends Paquete
        implements Serializable, Cloneable {

    /** Atributo id. */
    private int id;

    /** Atributo id enemigo. */
    private int idEnemigo;

    /** Atributo ganador batalla. */
    private int ganadorBatalla;

    /**
     * Constructor paquete finalizar batalla.
     */
    public PaqueteFinalizarBatalla() {
        setComando(Comando.FINALIZARBATALLA);
    }

    /**
     * Obtiene id.
     *
     * @return id
     */
    public final int getId() {
        return id;
    }

    /**
     * Asigna id. <br>
     *
     * @param idNumber
     *            Valor para asignar id. <br>
     */
    public final void setId(final int idNumber) {
        this.id = idNumber;
    }

    /**
     * Obtiene id enemigo.
     *
     * @return id enemigo
     */
    public final int getIdEnemigo() {
        return idEnemigo;
    }

    /**
     * Asigna id enemigo. <br>
     *
     * @param idEnemy
     *            Valor para asignar idEnemigo. <br>
     */
    public final void setIdEnemigo(final int idEnemy) {
        this.idEnemigo = idEnemy;
    }

    /**
     * Obtiene ganador batalla.
     *
     * @return ganador batalla.
     */
    public final int getGanadorBatalla() {
        return ganadorBatalla;
    }

    /**
     * Asigna ganador batalla.
     *
     * @param winnerBatalla
     *            Valor para asignar ganador batalla
     */
    public final void setGanadorBatalla(final int winnerBatalla) {
        this.ganadorBatalla = winnerBatalla;
    }
}
