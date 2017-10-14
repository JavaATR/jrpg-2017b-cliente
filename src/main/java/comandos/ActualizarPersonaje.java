package comandos;

import mensajeria.PaquetePersonaje;

/**
 * Clase que administra la actualización del personaje a nivel stats. <br>
 */
public class ActualizarPersonaje extends ComandosEscucha {
	/**
	 * Ejecuta la actualización del personaje. <br>
	 */
	@Override
	public void ejecutar() {
		PaquetePersonaje paquetePersonaje = (PaquetePersonaje) gson.fromJson(cadenaLeida, PaquetePersonaje.class);

		juego.getPersonajesConectados().remove(paquetePersonaje.getId());
		juego.getPersonajesConectados().put(paquetePersonaje.getId(), paquetePersonaje);

		if (juego.getPersonaje().getId() == paquetePersonaje.getId()) {
			juego.actualizarPersonaje();
			juego.getEstadoJuego().actualizarPersonaje();
			juego.getCliente().actualizarItems(paquetePersonaje);
			juego.getCliente().actualizarPersonaje(juego.getPersonajesConectados().get(paquetePersonaje.getId()));
		}
	}
}