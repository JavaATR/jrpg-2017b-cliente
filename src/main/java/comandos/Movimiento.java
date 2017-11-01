package comandos;

import mensajeria.PaqueteDeMovimientos;

/**
 * Clase que administra el comando de movimiento del personaje. <br>
 */
public class Movimiento extends ComandosEscucha {
    /**
     * Ejecuta el movimiento del personaje. <br>
     */
    @Override
    public final void ejecutar() {
        PaqueteDeMovimientos pdm = (PaqueteDeMovimientos) gson
                .fromJson(cadenaLeida, PaqueteDeMovimientos.class);
        juego.setUbicacionPersonajes(pdm.getPersonajes());
    }
}
