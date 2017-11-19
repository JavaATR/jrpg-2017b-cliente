package mensajeria;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import dominio.Item;
import estados.Estado;

/**
 * Clase PaquetePersonaje.
 */
public class PaquetePersonaje extends Paquete
        implements Serializable, Cloneable {

    /** Atributo id. */
    private int id;

    /** Atributo id mapa. */
    private int idMapa;

    /** Atributo estado. */
    private int estado;

    /** Atributo casta. */
    private String casta;

    /** Atributo nombre. */
    private String nombre;

    /** Atributo raza. */
    private String raza;

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

    /** Atributo nivel. */
    private int nivel = 1;

    /** Atributo experiencia. */
    private int experiencia;

    /** Atributo puntos asignar. */
    private int puntosAsignar;
    
    /** Atributo trucos activados. */
    List<Integer> trucosActivados = new ArrayList<Integer>();

    /** Atributo items. */
    private ArrayList<Item> items = new ArrayList<Item>();
    /**
     * Fuerza inicial de las castas. <br>
     */
    private final int[] fuerzaIncial = {15, 10, 10};
    /**
     * Destreza inicial de las castas. <br>
     */
    private final int[] destrezaIncial = {10, 10, 15};
    /**
     * Inteligencia inicial de las castas. <br>
     */
    private final int[] inteligenciaInicial = {10, 15, 10};
    /**
     * Vida inicial de los personajes (Humano / Elfo / Orco). <br>
     */
    private final int[] saludIncial = {55, 50, 60};
    /**
     * Energia inicial de los personajes (Humano / Elfo / Orco). <br>
     */
    private final int[] energiaInicial = {55, 60, 50};

    /**
     * Constructor.
     *
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public PaquetePersonaje() throws IOException {
        estado = Estado.estadoOffline;
    }

    /**
     * Obtiene estado.
     *
     * @return estado
     */
    public final int getEstado() {
        return estado;
    }

    /**
     * Establece el estado. <br>
     *
     * @param status
     *            Valor para asignar de estado. <br>
     */
    public final void setEstado(final int status) {
        this.estado = status;
    }

    /**
     * Obtiene mapa.
     *
     * @return the mapa
     */
    public final int getMapa() {
        return idMapa;
    }

    /**
     * Establece el mapa. <br>
     *
     * @param map
     *            Valor para asignar mapa. <br>
     */
    public final void setMapa(final int map) {
        idMapa = map;
    }

    /**
     * Obtiene nivel.
     *
     * @return nivel
     */
    public final int getNivel() {
        return nivel;
    }

    /**
     * Establece el nivel. <br>
     *
     * @param level
     *            Valor para asignar nivel. <br>
     */
    public final void setNivel(final int level) {
        this.nivel = level;
    }

    /**
     * Obtiene experiencia.
     *
     * @return experiencia
     */
    public final int getExperiencia() {
        return experiencia;
    }

    /**
     * Establece la experiencia. <br>
     *
     * @param experience
     *            Valor para asignar experiencia. <br>
     */
    public final void setExperiencia(final int experience) {
        this.experiencia = experience;
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
     * Establece el id. <br>
     *
     * @param idNumber
     *            Valor para asignar id. <br>
     */
    public final void setId(final int idNumber) {
        this.id = idNumber;
    }

    /**
     * Obtiene casta.
     *
     * @return the casta
     */
    public final String getCasta() {
        return casta;
    }

    /**
     * Establece la casta. <br>
     *
     * @param castaValue
     *            Valor para asignar casta. <br>
     */
    public final void setCasta(final String castaValue) {
        this.casta = castaValue;
    }

    /**
     * Obtiene nombre.
     *
     * @return nombre
     */
    public final String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre. <br>
     *
     * @param name
     *            Valor para asignar nombre. <br>
     */
    public final void setNombre(final String name) {
        this.nombre = name;
    }

    /**
     * Obtiene raza.
     *
     * @return raza
     */
    public final String getRaza() {
        return raza;
    }

    /**
     * Establece la raza. <br>
     *
     * @param race
     *            Valor para asignar raza. <br>
     */
    public final void setRaza(final String race) {
        this.raza = race;
    }

    /**
     * Obtiene salud tope.
     *
     * @return salud tope
     */
    public final int getSaludTope() {
        return saludTope;
    }

    /**
     * Establece la salud tope. <br>
     *
     * @param topeSalud
     *            Valor para asignar salud tope. <br>
     */
    public final void setSaludTope(final int topeSalud) {
        this.saludTope = topeSalud;
    }

    /**
     * Obtiene energia tope.
     *
     * @return energia tope
     */
    public final int getEnergiaTope() {
        return energiaTope;
    }

    /**
     * Establece energia tope. <br>
     *
     * @param topeEnergia
     *            Valor para asignar energia tope. <br>
     */
    public final void setEnergiaTope(final int topeEnergia) {
        this.energiaTope = topeEnergia;
    }

    /**
     * Obtiene fuerza.
     *
     * @return fuerza
     */
    public final int getFuerza() {
        return fuerza;
    }

    /**
     * Establece la fuerza. <br>
     *
     * @param strength
     *            Valor para asignar fuerza. <br>
     */
    public final void setFuerza(final int strength) {
        this.fuerza = strength;
    }

    /**
     * Obtiene destreza.
     *
     * @return destreza
     */
    public final int getDestreza() {
        return destreza;
    }

    /**
     * Establece destreza. <br>
     *
     * @param skill
     *            Valor para asignar destreza. <br>
     */
    public final void setDestreza(final int skill) {
        this.destreza = skill;
    }

    /**
     * Obtiene inteligencia.
     *
     * @return inteligencia
     */
    public final int getInteligencia() {
        return inteligencia;
    }

    /**
     * Establece inteligencia. <br>
     *
     * @param intelligence
     *            Valor para asignar inteligencia. <br>
     */
    public final void setInteligencia(final int intelligence) {
        this.inteligencia = intelligence;
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

    /**
     * Anadir item. <br>
     *
     * @param i
     *            Valor para asignar item. <br>
     */
    public final void anadirItem(final Item i) {
        items.add(i);
    }

    /**
     * Remover item. <br>
     *
     * @param i
     *            Valor para remover item. <br>
     */
    public final void removerItem(final Item i) {
        items.remove(i);
    }

    /**
     * Obtiene items.
     *
     * @return items
     */
    public final ArrayList<Item> getItems() {
        return new ArrayList<Item>(items);
    }

    /**
     * Sets items. <br>
     *
     * @param itemsList
     *            Array list de items. <br>
     */
    public final void setItems(final ArrayList<Item> itemsList) {
        this.items = itemsList;
    }

    /**
     * Obtiene item ID. <br>
     *
     * @param index
     *            Valor con índice para obtener item id.
     * @return the item ID
     */
    public final int getItemID(final int index) {
        return items.get(index).getIdItem();
    }

    /**
     * Añadir item. <br>
     *
     * @param idItem
     *            Valor para asignar id del item.
     * @param name
     *            Valor para asignar nombre.
     * @param wearLocation
     *            Valor para asignar wearLocation.
     * @param bonusSalud
     *            Valor para asignar bonus salud.
     * @param bonusEnergia
     *            Valor para asignar bonus energia.
     * @param bonusAtaque
     *            Valor para asignar bonus ataque.
     * @param bonusDefensa
     *            Valor para asignar bonus defensa.
     * @param bonusMagia
     *            Valor para asignar bonus magia.
     * @param foto
     *            String para asignar foto.
     * @param fotoEquipado
     *            String para asignar foto equipado. <br>
     */
    public final void anadirItem(final int idItem, final String name,
            final int wearLocation, final int bonusSalud,
            final int bonusEnergia, final int bonusAtaque,
            final int bonusDefensa, final int bonusMagia, final String foto,
            final String fotoEquipado) {
        try {
            items.add(new Item(idItem, name, wearLocation, bonusSalud,
                    bonusEnergia, bonusAtaque, bonusDefensa, bonusMagia, foto,
                    fotoEquipado));
            useBonus(bonusSalud, bonusEnergia, bonusAtaque, bonusDefensa,
                    bonusMagia, 0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Falló al añadir item");

        }
    }

    /**
     * Remover bonus.
     */
    public final void removerBonus() {
        // Intente usar un iterator y por alguna razón no andaba..
        int i = 0;
        while (i < items.size()) {
            sacarBonus(items.get(i).getBonusSalud(),
                    items.get(i).getBonusEnergia(),
                    items.get(i).getBonusFuerza(),
                    items.get(i).getBonusDestreza(),
                    items.get(i).getBonusInteligencia());
            i++;
        }
    }

    /**
     * Sacar bonus. <br>
     *
     * @param bonusSalud
     *            Valor para sacar bonus salud.
     * @param bonusEnergia
     *            Valor para sacar bonus energia.
     * @param bonusAtaque
     *            Valor para sacar bonus ataque.
     * @param bonusDefensa
     *            Valor para sacar bonus defensa.
     * @param bonusMagia
     *            Valor para sacar bonus magia. <br>
     */
    public final void sacarBonus(final int bonusSalud, final int bonusEnergia,
            final int bonusAtaque, final int bonusDefensa,
            final int bonusMagia) {
        saludTope -= bonusSalud;
        energiaTope -= bonusEnergia;
        fuerza -= bonusAtaque;
        destreza -= bonusDefensa;
        inteligencia -= bonusMagia;
    }

    /**
     * Poner bonus.
     */
    public final void ponerBonus() {
        // Intente usar un iterator y por alguna razón no andaba..
        int i = 0;
        while (i < items.size()) {
            useBonus(items.get(i).getBonusSalud(),
                    items.get(i).getBonusEnergia(),
                    items.get(i).getBonusFuerza(),
                    items.get(i).getBonusDestreza(),
                    items.get(i).getBonusInteligencia(), 0);
            i++;
        }
    }

    /**
     * Aplica nuevos stats al personaje. <br>
     *
     * @param bonusSalud
     *            Puntos de salud a agregar. <br>
     * @param bonusEnergia
     *            Puntos de energía a agregar. <br>
     * @param bonusAtaque
     *            Puntos de ataque a agregar. <br>
     * @param bonusDefensa
     *            Puntos de defensa a agregar. <br>
     * @param bonusMagia
     *            Puntos de magia a agregar. <br>
     * @param puntosAAsignar
     *            Puntos de skill a agregar. <br>
     */
    public final void useBonus(final int bonusSalud, final int bonusEnergia,
            final int bonusAtaque, final int bonusDefensa, final int bonusMagia,
            final int puntosAAsignar) {
        saludTope += bonusSalud;
        energiaTope += bonusEnergia;
        fuerza += bonusAtaque;
        destreza += bonusDefensa;
        inteligencia += bonusMagia;
    }

    /**
     * Obtiene cant items.
     *
     * @return cant items
     */
    public final int getCantItems() {
        return items.size();
    }

    /**
     * Añadir item. <br>
     *
     * @param idItem
     *            Valor para añadir item. <br>
     */
    public final void anadirItem(final int idItem) {
        try {
            items.add(new Item(idItem, null, 0, 0, 0, 0, 0, 0, null, null));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Falló al añadir item");
        }

    }

    /**
     * Obtiene iterator.
     *
     * @return iterator
     */
    public final Iterator<Item> getIterator() {
        return items.iterator();
    }

    /**
     * Remover ultimo item.
     */
    public final void removerUltimoItem() {
        items.remove(items.size() - 1);

    }

    /**
     * Nuevo item.
     *
     * @return true, if successful
     */
    public final boolean nuevoItem() {
        return items.get(items.size() - 1).getNombre() == null;
    }

    /**
     * Poner bonus. <br>
     *
     * @param cantItems
     *            Valor para asignar bonus. <br>
     */
    public final void ponerBonus(final int cantItems) {
        int i = 0;
        while (i < cantItems) {
            useBonus(items.get(i).getBonusSalud(),
                    items.get(i).getBonusEnergia(),
                    items.get(i).getBonusFuerza(),
                    items.get(i).getBonusDestreza(),
                    items.get(i).getBonusInteligencia(), 0);
            i++;
        }
    }

    /**
     * Sacar ultimo item.
     */
    public final void sacarUltimoItem() {
        int i = items.size() - 1;
        if (i >= 0) {
            sacarBonus(items.get(i).getBonusSalud(),
                    items.get(i).getBonusEnergia(),
                    items.get(i).getBonusFuerza(),
                    items.get(i).getBonusDestreza(),
                    items.get(i).getBonusInteligencia());
        }
    }

    /**
     * Inserta el último item. <br>
     */
    public final void ponerUltimoItem() {
        int i = items.size() - 1;
        if (i >= 0) {
            useBonus(items.get(i).getBonusSalud(),
                    items.get(i).getBonusEnergia(),
                    items.get(i).getBonusFuerza(),
                    items.get(i).getBonusDestreza(),
                    items.get(i).getBonusInteligencia(), 0);
        }
    }

    /**
     * Quita todos items del inventario. <br>
     */
    public final void eliminarItems() {
        items.removeAll(items);
    }

    /**
     * Actualizar trueque. <br>
     *
     * @param itemsList
     *            Lista de items para actualizar trueque. <br>
     */
    public final void actualizarTrueque(final ArrayList<Item> itemsList) {
        this.items.removeAll(this.items);
        for (Item item : itemsList) {
            this.items.add(item);
        }
    }

    /**
     * Devuelve los puntos para asignar de skill. <br>
     *
     * @return Puntos para asignar de skill. <br>
     */
    public final int getPuntosAsignar() {
        return this.puntosAsignar;
    }

    /**
     * Establece los puntos para asignar de skill. <br>
     *
     * @param cantPuntosAsignar
     *            Puntos para asignar de skill. <br>
     */
    public final void setPuntosAsignar(final int cantPuntosAsignar) {
        this.puntosAsignar = cantPuntosAsignar;
    }
    
    /**
     * Devuelve los trucos activos del personaje. <br>
     *
     * @return Una lista de los ids de los trucos activos del personaje. <br>
     */
    public final List<Integer> getTrucosActivados() {
        return this.trucosActivados;
    }

    /**
     * Establece los trucos activos del personaje. <br>
     *
     * @param idTruco
     *            Id del truco a activarse. <br>
     */
    public final void setTrucoActivado(final int idTruco) {
    	if (this.trucosActivados.indexOf(idTruco) != -1) // Si el truco ya está activado, lo desactivo
    		this.trucosActivados.remove(Integer.valueOf(idTruco));
    	else
    		this.trucosActivados.add(idTruco);
    }

    /**
     * Devuelve la fuerza inicial de la casta. <br>
     *
     * @return Fuerza inicial de la casta. <br>
     */
    public final int getFuerzaInicial() {
        if (this.casta.equals("Guerrero")) {
            return this.fuerzaIncial[0];
        }
        if (this.casta.equals("Hechicero")) {
            return this.fuerzaIncial[1];
        }
        return this.fuerzaIncial[2];
    }

    /**
     * Devuelve la destreza inicial de la casta. <br>
     *
     * @return Destreza inicial de la casta. <br>
     */
    public final int getDestrezaInicial() {
        if (this.casta.equals("Guerrero")) {
            return this.destrezaIncial[0];
        }
        if (this.casta.equals("Hechicero")) {
            return this.destrezaIncial[1];
        }
        return this.destrezaIncial[2];
    }

    /**
     * Devuelve la inteligencia inicial de la casta. <br>
     *
     * @return Inteligencia inicial de la casta. <br>
     */
    public final int getInteligenciaInicial() {
        if (this.casta.equals("Guerrero")) {
            return this.inteligenciaInicial[0];
        }
        if (this.casta.equals("Hechicero")) {
            return this.inteligenciaInicial[1];
        }
        return this.inteligenciaInicial[2];
    }

    /**
     * Setea todos los stats como si el personaje no hubiera agregado puntos de
     * nivel. <br>
     */
    public void reiniciarStats() {

        // En los proximos 3 if, segun la casta, se setean los stats base
        if (this.casta.equals("Guerrero")) {
            this.setFuerza(fuerzaIncial[0]);
            this.setDestreza(destrezaIncial[0]);
            this.setInteligencia(inteligenciaInicial[0]);
        }
        if (this.casta.equals("Hechicero")) {
            this.setFuerza(fuerzaIncial[1]);
            this.setDestreza(destrezaIncial[1]);
            this.setInteligencia(inteligenciaInicial[1]);
        }
        if (this.casta.equals("Asesino")) {
            this.setFuerza(fuerzaIncial[2]);
            this.setDestreza(destrezaIncial[2]);
            this.setInteligencia(inteligenciaInicial[2]);
        }

        // En los proximos 3 if, segun la raza, se setea la Salud y Energia base
        if (this.raza.equals("Humano")) {
            this.setSaludTope(saludIncial[0]);
            this.setEnergiaTope(energiaInicial[0]);
        }
        if (this.raza.equals("Elfo")) {
            this.setSaludTope(saludIncial[1]);
            this.setEnergiaTope(energiaInicial[1]);
        }
        if (this.raza.equals("Orco")) {
            this.setSaludTope(saludIncial[2]);
            this.setEnergiaTope(energiaInicial[2]);
        }

        // Setea los puntos para agregar segun el nivel del personaje
        this.setPuntosAsignar(3 * (this.getNivel()));
    }

    /**
     * Sube el nivel del personaje. <br>
     */
    public final void subirDeNivel() {
        this.nivel++;
    }
}
