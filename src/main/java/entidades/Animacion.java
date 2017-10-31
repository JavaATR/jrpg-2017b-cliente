package entidades;

import java.awt.image.BufferedImage;

/**
 * La clase Animacion tiene como función controlar las animaciones.
 */
public class Animacion {

	/** Atributo velocidad. */
	private int velocidad;
	/** Atributo indice. */
	private int indice;
	/** Atributos ultimo tiempo y timer. */
	private long ultimoTiempo, timer;
	/** Atributo frames. */
	private BufferedImage[] frames;

	/**
	 * Constructor de la clase
	 *
	 * @param velocity
	 *            velocidad con la cual se actualiza
	 * @param marcos
	 *            imagen de frame
	 */
	public Animacion(final int velocity, final BufferedImage[] marcos) {
		this.velocidad = velocity;
		this.frames = marcos;
		indice = 0;
		timer = 0;
		ultimoTiempo = System.currentTimeMillis();
	}

	/**
	 * Actualiza los frames
	 */
	public void actualizar() {
		timer += System.currentTimeMillis() - ultimoTiempo;
		ultimoTiempo = System.currentTimeMillis();

		if (timer > velocidad) {
			indice++;
			timer = 0;
			if (indice >= frames.length) {
				indice = 0;
			}
		}
	}

	/**
	 * Resetea el indice
	 */
	public void reset() {
		indice = 0;
	}

	/**
	 * Pide el frame actual
	 *
	 * @return devuelve el valor del frame en un indice
	 */
	public BufferedImage getFrameActual() {
		return frames[indice];
	}

	/**
	 * Pide el frame
	 *
	 * @return devuelve el indice del frame
	 */
	public int getFrame() {
		return indice;
	}
}
