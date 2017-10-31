package recursos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Clase que administra la carga de imágenes. <br>
 */
public class CargadorImagen {
	/**
	 * Carga las imágenes del juego. <br>
	 *
	 * @param path
	 *            Path del recurso. <br>
	 * @return Recurso. <br>
	 */
	public static BufferedImage cargarImagen(final String path) {
		try {
			return ImageIO.read(CargadorImagen.class.getResource(path));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,
					"Error al cargar el archivo " + path);
		}
		return null;
	}
}
