package comandos;

import juego.Juego;
import mensajeria.Comando;

/**
 * Clase que administra el escucha de comandos. <br>
 */
public abstract class ComandosEscucha extends Comando {
	/**
	 * Juego. <br>
	 */
	protected Juego juego;

	/**
	 * Establece el juego. <br>
	 * @param game
	 *            Juego. <br>
	 */
	public final void setJuego(final Juego game) {
		this.juego = game;
	}
}
