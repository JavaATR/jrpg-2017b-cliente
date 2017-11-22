package mensajeria;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import dominio.Item;
import dominio.Mochila;
import estados.Estado;

/**
 * Clase PaquetePersonaje.
 */
@SuppressWarnings("serial")
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
    private int experiencia = 0;

    /** Atributo puntos asignar. */
    private int puntosAsignar = 3;
    
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
	 * Id de la mochila del personaje. <br>
	 */
	private int idMochila = -1;
	/**
	 * Id de la alianza del personaje. <br>
	 */
	private int idAlianza = -1;
	/**
	 * Mochila del personaje. <br>
	 */
	private Mochila mochila = new Mochila();
    
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
    public int getEstado() {
        return estado;
    }

    /**
     * Establece el estado. <br>
     *
     * @param status
     *            Valor para asignar de estado. <br>
     */
    public void setEstado(final int status) {
        this.estado = status;
    }

    /**
     * Obtiene mapa.
     *
     * @return the mapa
     */
    public int getMapa() {
        return idMapa;
    }

    /**
     * Establece el mapa. <br>
     *
     * @param map
     *            Valor para asignar mapa. <br>
     */
    public void setMapa(final int map) {
        idMapa = map;
    }

    /**
     * Obtiene nivel.
     *
     * @return nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Establece el nivel. <br>
     *
     * @param level
     *            Valor para asignar nivel. <br>
     */
    public void setNivel(final int level) {
        this.nivel = level;
    }

    /**
     * Obtiene experiencia.
     *
     * @return experiencia
     */
    public int getExperiencia() {
        return experiencia;
    }

    /**
     * Establece la experiencia. <br>
     *
     * @param experience
     *            Valor para asignar experiencia. <br>
     */
    public void setExperiencia(final int experience) {
        this.experiencia = experience;
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
     * Establece el id. <br>
     *
     * @param idNumber
     *            Valor para asignar id. <br>
     */
    public void setId(final int idNumber) {
        this.id = idNumber;
    }

    /**
     * Obtiene casta.
     *
     * @return the casta
     */
    public String getCasta() {
        return casta;
    }

    /**
     * Establece la casta. <br>
     *
     * @param castaValue
     *            Valor para asignar casta. <br>
     */
    public void setCasta(final String castaValue) {
        this.casta = castaValue;
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
     * Establece el nombre. <br>
     *
     * @param name
     *            Valor para asignar nombre. <br>
     */
    public void setNombre(final String name) {
        this.nombre = name;
    }

    /**
     * Obtiene raza.
     *
     * @return raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * Establece la raza. <br>
     *
     * @param race
     *            Valor para asignar raza. <br>
     */
    public void setRaza(final String race) {
        this.raza = race;
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
     * Establece la salud tope. <br>
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
     * Establece energia tope. <br>
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
     * Establece la fuerza. <br>
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
     * Establece destreza. <br>
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
     * Establece inteligencia. <br>
     *
     * @param intelligence
     *            Valor para asignar inteligencia. <br>
     */
    public void setInteligencia(final int intelligence) {
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
        this.mochila.ordenarMochila(this.items);
    }

    /**
     * Remover item. <br>
     *
     * @param item
     *            Valor para remover item. <br>
     */
    public final void removerItem(final Item item) {
        items.remove(item);
        this.mochila.ordenarMochila(this.items);
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
    public void setItems(final ArrayList<Item> itemsList) {
        this.items = itemsList;
    }

    /**
     * Obtiene item ID. <br>
     *
     * @param index
     *            Valor con índice para obtener item id.
     * @return the item ID
     */
    public int getItemID(final int index) {
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
	public final void anadirItem(final int idItem, final String name, final int bonusSalud, final int bonusEnergia,
			final int bonusAtaque, final int bonusDefensa, final int bonusMagia, final String foto,
			final String fotoEquipado) {
		try {
			items.add(new Item(idItem, name, bonusSalud, bonusEnergia, bonusAtaque, bonusDefensa, bonusMagia, foto,
					fotoEquipado));
			useBonus(bonusSalud, bonusEnergia, bonusAtaque, bonusDefensa, bonusMagia, 0);
			this.mochila.ordenarMochila(this.items);
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
    public int getCantItems() {
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
            items.add(new Item(idItem, null, 0, 0, 0, 0, 0, null, null));
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
        this.mochila.ordenarMochila(this.items);

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
			useBonus(items.get(i).getBonusSalud(), items.get(i).getBonusEnergia(), items.get(i).getBonusFuerza(),
					items.get(i).getBonusDestreza(), items.get(i).getBonusInteligencia(), 0);
		}
    }

    /**
     * Quita todos items del inventario. <br>
     */
    public final void eliminarItems() {
        items.removeAll(items);
        this.mochila.ordenarMochila(this.items);
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
        this.mochila.ordenarMochila(this.items);
    }

    /**
     * Devuelve los puntos para asignar de skill. <br>
     *
     * @return Puntos para asignar de skill. <br>
     */
    public int getPuntosAsignar() {
        return this.puntosAsignar;
    }

    /**
     * Establece los puntos para asignar de skill. <br>
     *
     * @param cantPuntosAsignar
     *            Puntos para asignar de skill. <br>
     */
    public void setPuntosAsignar(final int cantPuntosAsignar) {
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
    public int getFuerzaInicial() {
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
    public int getDestrezaInicial() {
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
    public int getInteligenciaInicial() {
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

	/**
	 * Devuelve el id de la mochila del personaje. <br>
	 * @return Id de la mochila. <br>
	 */
	public int getIdMochila() {
		return idMochila;
	}

	/**
	 * Establece el id de la mochila del personaje. <br>
	 * @param idMochila
	 *            Id de la mochila. <br>
	 */
	public void setIdMochila(int idMochila) {
		this.idMochila = idMochila;
	}

	/**
	 * Devuelve el id de la alianza del personaje. <br>
	 * @return Id de la alianza. <br>
	 */
	public int getIdAlianza() {
		return idAlianza;
	}

	/**
	 * Establece el id de la alianza del personaje. <br>
	 * @param idAlianza
	 *            Id de la alianza. <br>
	 */
	public void setIdAlianza(int idAlianza) {
		this.idAlianza = idAlianza;
	}

	/**
	 * Devuelve la mochila del personaje. <br> 
	 * @return Mochila del personaje. <br>
	 */
	public Mochila getMochila() {
		return mochila;
	}

	/**
	 * Establece la mochila del personaje. <br> 
	 * @param mochila
	 *            Mochila con items. <br>
	 */
	public void setMochila(Mochila mochila) {
		this.mochila = mochila;
	}
}
