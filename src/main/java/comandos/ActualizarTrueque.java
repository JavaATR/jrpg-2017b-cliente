package comandos;

import mensajeria.PaquetePersonaje;

/**
 * Clase que administra el comando de actualización de trueque. <br>
 */
public class ActualizarTrueque extends ComandosEscucha {
	/**
	 * Ejecuta la actualización del trueque. <br>
	 */
	@Override
	public final void ejecutar() {
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
