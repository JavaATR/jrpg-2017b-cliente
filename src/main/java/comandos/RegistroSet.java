package comandos;

import mensajeria.Comando;

/**
 * Clase que administra el comando de inicio de registro de personaje. <br>
 */
public class RegistroSet extends ComandosCliente {
	/**
	 * Ejecuta el inicio de registro de personaje. <br>
	 */
	@Override
	public final void ejecutar() {
		cliente.getPaqueteUsuario().setComando(Comando.REGISTRO);
	}
}
