package mensajeria;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import dominio.Item;
import estados.Estado;

public class PaquetePersonaje extends Paquete implements Serializable, Cloneable {

	private int id;
	private int idMapa;
	private int estado;
	private String casta;
	private String nombre;
	private String raza;
	private int saludTope;
	private int energiaTope;
	private int fuerza;
	private int destreza;
	private int inteligencia;
	private int nivel = 1;
	private int experiencia;
	private int puntosAsignar;
	private ArrayList<Item> items = new ArrayList<Item>();
	/**
	 * Fuerza inicial de las castas. <br>
	 */
	private final int fuerzaIncial[] = { 15, 10, 10 };
	/**
	 * Destreza inicial de las castas. <br>
	 */
	private final int destrezaIncial[] = { 10, 10, 15 };
	/**
	 * Inteligencia inicial de las castas. <br>
	 */
	private final int inteligenciaInicial[] = { 10, 15, 10 };

	public PaquetePersonaje() throws IOException {
		estado = Estado.estadoOffline;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getMapa() {
		return idMapa;
	}

	public void setMapa(int mapa) {
		idMapa = mapa;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCasta() {
		return casta;
	}

	public void setCasta(String casta) {
		this.casta = casta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getSaludTope() {
		return saludTope;
	}

	public void setSaludTope(int saludTope) {
		this.saludTope = saludTope;
	}

	public int getEnergiaTope() {
		return energiaTope;
	}

	public void setEnergiaTope(int energiaTope) {
		this.energiaTope = energiaTope;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(int destreza) {
		this.destreza = destreza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}

	public final void anadirItem(Item i) {
		items.add(i);
	}

	public final void removerItem(Item i) {
		items.remove(i);
	}

	public ArrayList<Item> getItems() {
		return new ArrayList<Item>(items);
	}

	public final void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public final int getItemID(int index) {
		return items.get(index).getIdItem();
	}

	public final void anadirItem(int idItem, String nombre, int wearLocation, int bonusSalud, int bonusEnergia,
			int bonusAtaque, int bonusDefensa, int bonusMagia, String foto, String fotoEquipado) {
		try {
			items.add(new Item(idItem, nombre, wearLocation, bonusSalud, bonusEnergia, bonusAtaque, bonusDefensa,
					bonusMagia, foto, fotoEquipado));
			useBonus(bonusSalud, bonusEnergia, bonusAtaque, bonusDefensa, bonusMagia, 0);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Falló al añadir item");

		}
	}

	public final void removerBonus() {
		// Intente usar un iterator y por alguna razón no andaba..
		int i = 0;
		while (i < items.size()) {
			sacarBonus(items.get(i).getBonusSalud(), items.get(i).getBonusEnergia(), items.get(i).getBonusFuerza(),
					items.get(i).getBonusDestreza(), items.get(i).getBonusInteligencia());
			i++;
		}
	}

	public final void sacarBonus(int bonusSalud, int bonusEnergia, int bonusAtaque, int bonusDefensa, int bonusMagia) {
		saludTope -= bonusSalud;
		energiaTope -= bonusEnergia;
		fuerza -= bonusAtaque;
		destreza -= bonusDefensa;
		inteligencia -= bonusMagia;
	}

	public final void ponerBonus() {
		// Intente usar un iterator y por alguna razón no andaba..
		int i = 0;
		while (i < items.size()) {
			useBonus(items.get(i).getBonusSalud(), items.get(i).getBonusEnergia(), items.get(i).getBonusFuerza(),
					items.get(i).getBonusDestreza(), items.get(i).getBonusInteligencia(), 0);
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
	 * @param puntosAsignar
	 *            Puntos de skill a agregar. <br>
	 */
	public void useBonus(final int bonusSalud, final int bonusEnergia, final int bonusAtaque, final int bonusDefensa,
			final int bonusMagia, final int puntosAsignar) {
		saludTope += bonusSalud;
		energiaTope += bonusEnergia;
		fuerza += bonusAtaque;
		destreza += bonusDefensa;
		inteligencia += bonusMagia;
	}

	public int getCantItems() {
		return items.size();
	}

	public void anadirItem(int idItem) {
		try {
			items.add(new Item(idItem, null, 0, 0, 0, 0, 0, 0, null, null));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Falló al añadir item");
		}

	}

	public Iterator<Item> getIterator() {
		return items.iterator();
	}

	public void removerUltimoItem() {
		items.remove(items.size() - 1);

	}

	public boolean nuevoItem() {
		return items.get(items.size() - 1).getNombre() == null;
	}

	public void ponerBonus(int cantItems) {
		int i = 0;
		while (i < cantItems) {
			useBonus(items.get(i).getBonusSalud(), items.get(i).getBonusEnergia(), items.get(i).getBonusFuerza(),
					items.get(i).getBonusDestreza(), items.get(i).getBonusInteligencia(), 0);
			i++;
		}
	}

	public void sacarUltimoItem() {
		int i = items.size() - 1;
		if (i >= 0) {
			sacarBonus(items.get(i).getBonusSalud(), items.get(i).getBonusEnergia(), items.get(i).getBonusFuerza(),
					items.get(i).getBonusDestreza(), items.get(i).getBonusInteligencia());
		}
	}

	/**
	 * Inserta el último item. <br>
	 */
	public void ponerUltimoItem() {
		int i = items.size() - 1;
		if (i >= 0) {
			useBonus(items.get(i).getBonusSalud(), items.get(i).getBonusEnergia(), items.get(i).getBonusFuerza(),
					items.get(i).getBonusDestreza(), items.get(i).getBonusInteligencia(), 0);
		}
	}

	/**
	 * Quita todos items del inventario. <br>
	 */
	public void eliminarItems() {
		items.removeAll(items);
	}

	public void actualizarTrueque(ArrayList<Item> items) {
		this.items.removeAll(this.items);
		for (Item item : items) {
			this.items.add(item);
		}
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
	 * @param puntosAsignar
	 *            Puntos para asignar de skill. <br>
	 */
	public void setPuntosAsignar(final int puntosAsignar) {
		this.puntosAsignar = puntosAsignar;
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
	 * Sube el nivel del personaje. <br>
	 */
	public void subirDeNivel() {
		this.nivel++;
	}
}