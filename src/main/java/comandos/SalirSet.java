package comandos;

import mensajeria.Comando;

/**
 * Clase que administra el comando de salida. <br>
 */
public class SalirSet extends ComandosCliente {
    /**
     * Ejecuta la salida. <br>
     */
    @Override
    public final void ejecutar() {
        cliente.getPaqueteUsuario().setIp(cliente.getMiIp());
        cliente.getPaqueteUsuario().setComando(Comando.SALIR);
    }
}
