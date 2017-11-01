package mensajeria;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Clase PaqueteAtacar.
 */
public class PaqueteAtacar extends Paquete implements Serializable, Cloneable {

    /** Atributo id. */
    private int id;

    /** Atributo id enemigo. */
    private int idEnemigo;

    /** Atributo nueva salud personaje. */
    private int nuevaSaludPersonaje;

    /** Atributo nueva energia personaje. */
    private int nuevaEnergiaPersonaje;

    /** Atributo nueva salud enemigo. */
    private int nuevaSaludEnemigo;

    /** Atributo nueva energia enemigo. */
    private int nuevaEnergiaEnemigo;

    /** Atributo map personaje. */
    private HashMap<String, Number> mapPersonaje = new HashMap<String, Number>();

    /** Atributo map enemigo. */
    private HashMap<String, Number> mapEnemigo = new HashMap<String, Number>();

    /**
     * Constructor paquete atacar. <br>
     *
     * @param idNumber
     *            Valor id.
     * @param idNumberEnemigo
     *            Valor id enemigo.
     * @param newSalud
     *            Valor nueva salud del personaje.
     * @param newEnergia
     *            Valor nueva energia del personaje.
     * @param newSaludEnemigo
     *            Valor nueva salud del enemigo.
     * @param newEnergiaEnemigo
     *            Valor nueva energía del enemigo.
     * @param newDefensa
     *            Valor nueva defensa del personaje.
     * @param nuevaDefensaEnemigo
     *            Valor nueva defensa del enemmigo.
     * @param probEvitarDano
     *            Valor prob evitar daño.
     * @param probEvitarDanoEnemgio
     *            Valor prob evitar daño del enemigo. <br>
     */
    public PaqueteAtacar(final int idNumber, final int idNumberEnemigo,
            final int newSalud, final int newEnergia, final int newSaludEnemigo,
            final int newEnergiaEnemigo, final int newDefensa,
            final int nuevaDefensaEnemigo, final double probEvitarDano,
            final double probEvitarDanoEnemgio) {
        setComando(Comando.ATACAR);
        this.id = idNumber;
        this.idEnemigo = idNumberEnemigo;
        this.nuevaSaludPersonaje = newSalud;
        this.nuevaEnergiaPersonaje = newEnergia;
        this.nuevaSaludEnemigo = newSaludEnemigo;
        this.nuevaEnergiaEnemigo = newEnergiaEnemigo;
        mapPersonaje.put("salud", newSalud);
        mapPersonaje.put("energia", newEnergia);
        mapPersonaje.put("defensa", newDefensa);
        mapPersonaje.put("probEvitarDanio", probEvitarDano);
        mapEnemigo.put("salud", newSaludEnemigo);
        mapEnemigo.put("energia", newEnergiaEnemigo);
        mapEnemigo.put("defensa", nuevaDefensaEnemigo);
        mapEnemigo.put("probEvitarDanio", probEvitarDanoEnemgio);
    }

    /**
     * Obtiene id.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Asigna id.
     *
     * @param idNumber
     *            Valor de id.
     */
    public void setId(final int idNumber) {
        this.id = idNumber;
    }

    /**
     * Obtiene id enemigo.
     *
     * @return id enemigo
     */
    public int getIdEnemigo() {
        return idEnemigo;
    }

    /**
     * Asigna id enemigo. <br>
     *
     * @param idNumberEnemigo
     *            Valor con id del enemigo. <br>
     */
    public void setIdEnemigo(final int idNumberEnemigo) {
        this.idEnemigo = idNumberEnemigo;
    }

    /**
     * Obtiene nueva salud personaje.
     *
     * @return nueva salud personaje
     */
    public int getNuevaSaludPersonaje() {
        return nuevaSaludPersonaje;
    }

    /**
     * Asigna nueva salud personaje. <br>
     *
     * @param newSaludPersonaje
     *            Valor con nueva salud del personaje. <br>
     */
    public void setNuevaSaludPersonaje(final int newSaludPersonaje) {
        this.nuevaSaludPersonaje = newSaludPersonaje;
    }

    /**
     * Obtiene nueva energia personaje.
     *
     * @return nueva energia personaje
     */
    public int getNuevaEnergiaPersonaje() {
        return nuevaEnergiaPersonaje;
    }

    /**
     * Asigna nueva energia personaje. <br>
     *
     * @param newEnergiaPersonaje
     *            Valor con nueva energia del personaje. <br>
     */
    public void setNuevaEnergiaPersonaje(final int newEnergiaPersonaje) {
        this.nuevaEnergiaPersonaje = newEnergiaPersonaje;
    }

    /**
     * Obtiene nueva salud enemigo.
     *
     * @return nueva salud enemigo
     */
    public int getNuevaSaludEnemigo() {
        return nuevaSaludEnemigo;
    }

    /**
     * Asigna nueva salud enemigo. <br>
     *
     * @param newSaludEnemigo
     *            Valor con nueva salud del enemigo. <br>
     */
    public void setNuevaSaludEnemigo(final int newSaludEnemigo) {
        this.nuevaSaludEnemigo = newSaludEnemigo;
    }

    /**
     * Obtiene nueva energia enemigo.
     *
     * @return nueva energia enemigo
     */
    public int getNuevaEnergiaEnemigo() {
        return nuevaEnergiaEnemigo;
    }

    /**
     * Asigna nueva energia enemigo. <br>
     *
     * @param newEnergiaEnemigo
     *            Valor con nueva energia del enemigo. <br>
     */
    public void setNuevaEnergiaEnemigo(final int newEnergiaEnemigo) {
        this.nuevaEnergiaEnemigo = newEnergiaEnemigo;
    }

    /**
     * Obtiene map personaje.
     *
     * @return map personaje
     */
    public HashMap<String, Number> getMapPersonaje() {
        return mapPersonaje;
    }

    /**
     * Obtiene map enemigo.
     *
     * @return map enemigo
     */
    public HashMap<String, Number> getMapEnemigo() {
        return mapEnemigo;
    }

}
