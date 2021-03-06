package comandos;

import mensajeria.PaquetePersonaje;

/**
 * Clase que administra la actualización del inventario. <br>
 */
public class ActualizarInventario extends ComandosEscucha {
    /**
     * Ejecuta la actualización del inventario. <br>
     */
    @Override
    public final void ejecutar() {
        PaquetePersonaje paquetePersonaje = (PaquetePersonaje) gson
                .fromJson(cadenaLeida, PaquetePersonaje.class);
        juego.getPersonajesConectados().remove(paquetePersonaje.getId());
        juego.getPersonajesConectados().put(paquetePersonaje.getId(),
                paquetePersonaje);
        if (juego.getPersonaje().getId() == paquetePersonaje.getId()) {
            juego.actualizarPersonaje();
            juego.getEstadoJuego().actualizarPersonaje();
            juego.getCliente().actualizarItems(paquetePersonaje);
            juego.getCliente().actualizarPersonaje(juego
                    .getPersonajesConectados().get(paquetePersonaje.getId()));
        }
    }
}
