package mensajeria;

import java.io.Serializable;

/**
 * Clase PaqueteEnemigo.
 */
public class PaqueteEnemigo extends Paquete implements Serializable, Cloneable {

    /** Constante ESTADO. */
    private static final int ESTADO = 1;

    /** Constante INTELIGENCIA. */
    private static final int INTELIGENCIA = 50;

    /** Constante DESTREZA. */
    private static final int DESTREZA = 50;

    /** Constante FUERZA. */
    private static final int FUERZA = 50;

    /** Constante ENERGIA_TOPE. */
    private static final int ENERGIA_TOPE = 50;

    /** Constante SALUD_TOPE. */
    private static final int SALUD_TOPE = 100;

    /** Atributo id. */
    private int id;

    /** The nombre. */
    private String nombre;

    /** Atributo salud tope. */
    private int saludTope;

    /** Atributo energia tope. */
    private int energiaTope;

    /** Atributo fuerza. */
    private int fuerza;

    /** Atributo destreza. */
    private int destreza;

    /** Atributo inteligencia. */
    private int inteligencia;

    /** Atributo estado. */
    private int estado;

    /**
     * Constructor new paquete enemigo. <br>
     *
     * @param idNumber
     *            Valor para asignar id. <br>
     */
    public PaqueteEnemigo(final int idNumber) {
        this.id = idNumber;
        nombre = "El Bryan";
        saludTope = SALUD_TOPE;
        energiaTope = ENERGIA_TOPE;
        fuerza = FUERZA;
        destreza = DESTREZA;
        inteligencia = INTELIGENCIA;
        estado = ESTADO;
    }

    /**
     * Obtiene estado.
     *
     * @return estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * Asignar estado. <br>
     *
     * @param status
     *            Valor para asignar estado. <br>
     */
    public void setEstado(final int status) {
        this.estado = status;
    }

    /**
     * Obtiene nombre.
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asignar nombre. <br>
     *
     * @param name
     *            Valor para asignar nombre. <br>
     */
    public void setNombre(final String name) {
        this.nombre = name;
    }

    /**
     * Obtiene salud tope.
     *
     * @return salud tope
     */
    public int getSaludTope() {
        return saludTope;
    }

    /**
     * Asignar salud tope. <br>
     *
     * @param topeSalud
     *            Valor para asignar salud tope. <br>
     */
    public void setSaludTope(final int topeSalud) {
        this.saludTope = topeSalud;
    }

    /**
     * Obtiene energia tope.
     *
     * @return energia tope
     */
    public int getEnergiaTope() {
        return energiaTope;
    }

    /**
     * Asignar energia tope. <br>
     *
     * @param topeEnergia
     *            Valor para asignar energia tope. <br>
     */
    public void setEnergiaTope(final int topeEnergia) {
        this.energiaTope = topeEnergia;
    }

    /**
     * Obtiene fuerza.
     *
     * @return fuerza
     */
    public int getFuerza() {
        return fuerza;
    }

    /**
     * Asignar fuerza. <br>
     *
     * @param strength
     *            Valor para asignar fuerza. <br>
     */
    public void setFuerza(final int strength) {
        this.fuerza = strength;
    }

    /**
     * Obtiene destreza.
     *
     * @return destreza
     */
    public int getDestreza() {
        return destreza;
    }

    /**
     * Asignar destreza. <br>
     *
     * @param skill
     *            Valor para asignar destreza. <br>
     */
    public void setDestreza(final int skill) {
        this.destreza = skill;
    }

    /**
     * Obtiene inteligencia.
     *
     * @return inteligencia
     */
    public int getInteligencia() {
        return inteligencia;
    }

    /**
     * Asignar inteligencia. <br>
     *
     * @param intelligence
     *            Valor para asignar inteligencia. <br>
     */
    public void setInteligencia(final int intelligence) {
        this.inteligencia = intelligence;
    }

    /**
     * Obtiene id.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /*
     * (non-Javadoc)
     *
     * @see mensajeria.Paquete#clone()
     */
    @Override
    public Object clone() {
        Object obj = null;
        obj = super.clone();
        return obj;
    }
}
