package comandos;

import estados.Estado;
import mensajeria.PaqueteFinalizarBatalla;

/**
 * Clase que administra el comando de finalizar batalla. <br>
 */
public class FinalizarBatalla extends ComandosEscucha {
	/**
	 * Ejecuta el fin de batalla. <br>
	 */
	@Override
	public final void ejecutar() {
		PaqueteFinalizarBatalla paqueteFinalizarBatalla = (PaqueteFinalizarBatalla) gson.fromJson(cadenaLeida,
				PaqueteFinalizarBatalla.class);
		juego.getPersonaje().setEstado(Estado.estadoJuego);
		Estado.setEstado(juego.getEstadoJuego());
	}
}
