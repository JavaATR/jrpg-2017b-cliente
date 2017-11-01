package comandos;

import mensajeria.PaqueteDeEnemigos;

/**
 * Clase que administra el comando de actualización de enemigos. <br>
 */
public class ActualizarEnemigos extends ComandosEscucha {
    /**
     * Ejecuta la actualización de los enemigos. <br>
     */
    @Override
    public final void ejecutar() {
        PaqueteDeEnemigos pde = (PaqueteDeEnemigos) gson.fromJson(cadenaLeida,
                PaqueteDeEnemigos.class);
        juego.setEnemigosConectados(pde.getEnemigos());
    }
}
