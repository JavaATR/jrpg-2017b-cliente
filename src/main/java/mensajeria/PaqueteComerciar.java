package mensajeria;

import java.io.Serializable;
import java.util.ArrayList;

import dominio.Item;

/**
 * Clase PaqueteComerciar.
 */
public class PaqueteComerciar extends Paquete
        implements Serializable, Cloneable {

    /** Atributo id. */
    private int id;

    /** Atributo id enemigo. */
    private int idEnemigo;

    /** Atributo listo. */
    private int listo = 0;

    /** Atributo items A dar. */
    private ArrayList<Item> itemsADar = new ArrayList<Item>();

    /** Atributo items A obtener. */
    private ArrayList<Item> itemsAObtener = new ArrayList<Item>();

    /** Atributo solicitud de comercio. */
    private boolean solicitudDeComercio;

    /**
     * Constructor paquete comerciar.
     */
    public PaqueteComerciar() {
        setComando(Comando.COMERCIO);
        solicitudDeComercio = true;
    }

    /**
     * Checks solicitud de comercio.
     *
     * @return true o false.
     */
    public final boolean isSolicitudDeComercio() {
        return solicitudDeComercio;
    }

    /**
     * Asignar solicitud de comercio. <br>
     *
     * @param comercioSolicitud
     *            Boolean para asignar solicitud de comercio <br>
     */
    public final void setSolicitudDeComercio(final boolean comercioSolicitud) {
        this.solicitudDeComercio = comercioSolicitud;
    }

    /**
     * Obtener items A dar.
     *
     * @return items A dar
     */
    public final ArrayList<Item> getItemsADar() {
        return itemsADar;
    }

    /**
     * Asignar items A dar. <br>
     *
     * @param itemsToGive
     *            List para asignar items A dar. <br>
     */
    public final void setItemsADar(final ArrayList<Item> itemsToGive) {
        this.itemsADar = itemsToGive;
    }

    /**
     * Obtener id.
     *
     * @return id
     */
    public final int getId() {
        return id;
    }

    /**
     * Asignar id. <br>
     *
     * @param idValue
     *            Valor para asignar id. <br>
     */
    public final void setId(final int idValue) {
        this.id = idValue;
    }

    /**
     * Obtener id enemigo.
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
    public final void setIdEnemigo(final int idEnemy) {
        this.idEnemigo = idEnemy;
    }

    /**
     * Obtener listo.
     *
     * @return the listo
     */
    public final int getListo() {
        return listo;
    }

    /**
     * Aumentar listo.
     */
    public final void aumentarListo() {
        this.listo++;
    }

    /**
     * Disminuir listo.
     */
    public final void disminuirListo() {
        this.listo--;
    }

    /**
     * Obtener items A obtener.
     *
     * @return the items A obtener
     */
    public final ArrayList<Item> getItemsAObtener() {
        return itemsAObtener;
    }

    /**
     * Asignar items A obtener. <br>
     *
     * @param itemsToObtain
     *            List con el valor de los items A obtener. <br>
     */
    public final void setItemsAObtener(final ArrayList<Item> itemsToObtain) {
        this.itemsAObtener = itemsToObtain;
    }
}
