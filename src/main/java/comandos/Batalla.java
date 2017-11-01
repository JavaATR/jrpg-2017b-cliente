package comandos;

import estados.Estado;
import estados.EstadoBatalla;
import mensajeria.PaqueteBatalla;

/**
 * Clase que administra el comando de batalla. <br>
 */
public class Batalla extends ComandosEscucha {
    /**
     * Ejecuta la batalla. <br>
     */
    @Override
    public final void ejecutar() {
        PaqueteBatalla paqueteBatalla = (PaqueteBatalla) gson
                .fromJson(cadenaLeida, PaqueteBatalla.class);
        juego.getPersonaje().setEstado(Estado.estadoBatalla);
        Estado.setEstado(null);
        juego.setEstadoBatalla(new EstadoBatalla(juego, paqueteBatalla));
        Estado.setEstado(juego.getEstadoBatalla());
    }
}
