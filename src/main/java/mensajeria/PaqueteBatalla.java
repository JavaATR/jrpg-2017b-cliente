package mensajeria;

import java.io.Serializable;

/**
 * Clase PaqueteBatalla.
 */
public class PaqueteBatalla extends Paquete implements Serializable, Cloneable {

    /** Atributo id. */
    private int id;

    /** Atributo id enemigo. */
    private int idEnemigo;

    /** Atributo mi turno. */
    private boolean miTurno;

    /**
     * Constructor paquete batalla.
     */
    public PaqueteBatalla() {
        setComando(Comando.BATALLA);
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
    public final void setId(int idNumber) {
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
     * Asignar id enemigo. <br>
     *
     * @param idEnemy
     *            Valor para asignar id enemigo. <br>
     */
    public final void setIdEnemigo(int idEnemy) {
        this.idEnemigo = idEnemy;
    }

    /**
     * Checks if is mi turno.
     *
     * @return true, if is mi turno
     */
    public final boolean isMiTurno() {
        return miTurno;
    }

    /**
     * Asignar mi turno. <br>
     *
     * @param myTurn
     *            Valor para asignar mi turno. <br>
     */
    public final void setMiTurno(boolean myTurn) {
        this.miTurno = myTurn;
    }
}
