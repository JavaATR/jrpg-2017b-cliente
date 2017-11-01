package comandos;

import mensajeria.PaqueteAtacar;

/**
 * Clase que administra el comando de ataque. <br>
 */
public class Atacar extends ComandosEscucha {
    /**
     * Ejecuta el ataque. <br>
     */
    @Override
    public final void ejecutar() {
        PaqueteAtacar paqueteAtacar = (PaqueteAtacar) gson.fromJson(cadenaLeida,
                PaqueteAtacar.class);
        if (paqueteAtacar.getId() > 0) {
            juego.getEstadoBatalla().getEnemigo()
                    .actualizarAtributos(paqueteAtacar.getMapPersonaje());
        }
        juego.getEstadoBatalla().getPersonaje()
                .actualizarAtributos(paqueteAtacar.getMapEnemigo());
        juego.getEstadoBatalla().setMiTurno(true);
    }
}
