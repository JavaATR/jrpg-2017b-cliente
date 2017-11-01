package comandos;

import java.util.Map;

import javax.swing.DefaultListModel;

import chat.VentanaContactos;
import mensajeria.PaqueteDePersonajes;
import mensajeria.PaquetePersonaje;

/**
 * Clase que administra el comando de conexión de clientes. <br>
 */
public class Conexion extends ComandosEscucha {
	/**
	 * Ejecuta la conexión de clientes. <br>
	 */
	@Override
	public final void ejecutar() {
		PaqueteDePersonajes pdp = (PaqueteDePersonajes) gson.fromJson(cadenaLeida, PaqueteDePersonajes.class);
		juego.setPersonajesConectados(pdp.getPersonajes());
		actualizarLista(pdp);
	}

	/**
	 * Actualiza la lista de personajes conectados. <br>
	 * @param pdp
	 *            Personajes en el juego. <br>
	 */
	private void actualizarLista(final PaqueteDePersonajes pdp) {
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		VentanaContactos.getList().removeAll();
		for (Map.Entry<Integer, PaquetePersonaje> personaje : pdp.getPersonajes().entrySet()) {
			modelo.addElement(personaje.getValue().getNombre());
		}
		modelo.removeElement(juego.getPersonaje().getNombre());
		VentanaContactos.getList().setModel(modelo);
	}
}
