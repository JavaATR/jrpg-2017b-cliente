package comandos;

import cliente.Cliente;
import mensajeria.Comando;

/**
 * Clase que administra los comandos del cliente. <br>
 */
public abstract class ComandosCliente extends Comando {
	/**
	 * Cliente. <br>
	 */
	protected Cliente cliente;

	/**
	 * Establece el cliente. <br>
	 * @param cliente
	 *            Cliente. <br>
	 */
	public final void setCliente(final Cliente cliente) {
		this.cliente = cliente;
	}
}
