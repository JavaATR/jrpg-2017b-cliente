package comandos;

import mensajeria.PaquetePersonaje;

/**
 * Clase que administra la actualización del personaje con respecto a su nivel.
 * <br>
 */
public class ActualizarPersonajeLvl extends ComandosEscucha {
	/**
	 *
	 */
	@Override
	public void ejecutar() {
		PaquetePersonaje paquetePersonaje = (PaquetePersonaje) gson.fromJson(cadenaLeida, PaquetePersonaje.class);

		juego.getPersonajesConectados().remove(paquetePersonaje.getId());
		juego.getPersonajesConectados().put(paquetePersonaje.getId(), paquetePersonaje);

		if (juego.getPersonaje().getId() == paquetePersonaje.getId()) {
			juego.actualizarPersonaje();
			juego.getEstadoJuego().actualizarPersonaje();
			juego.getCliente().subirDeNivel();
			juego.getCliente().actualizarPersonaje(juego.getPersonajesConectados().get(paquetePersonaje.getId()));
		}
	}
}