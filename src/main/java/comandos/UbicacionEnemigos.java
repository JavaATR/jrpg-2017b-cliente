package comandos;

import mensajeria.PaqueteDeUbicacionEnemigos;

/**
 * Clase que administra el comando de ubicación de enemigos. <br>
 */
public class UbicacionEnemigos extends ComandosEscucha {
    /**
     * Ejecuta la ubicación de los enemigos. <br>
     */
    @Override
    public final void ejecutar() {
        PaqueteDeUbicacionEnemigos pdm = (PaqueteDeUbicacionEnemigos) gson
                .fromJson(cadenaLeida, PaqueteDeUbicacionEnemigos.class);
        juego.setUbicacionEnemigos(pdm.getEnemigos());
    }
}
