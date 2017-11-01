package comandos;

import mensajeria.Comando;

/**
 * Clase que administra el comando de inicio de sesión. <br>
 */
public class InicioSesionSet extends ComandosCliente {
    /**
     * Ejecuta el inicio de sesión del cliente. <br>
     */
    @Override
    public final void ejecutar() {
        cliente.getPaqueteUsuario().setComando(Comando.INICIOSESION);
    }
}
