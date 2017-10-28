package juego;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import com.google.gson.Gson;

import chat.VentanaContactos;
import cliente.Cliente;
import estados.Estado;
import frames.MenuAsignarSkills;
import frames.MenuEscape;
import frames.MenuInventario;
import frames.MenuJugar;
import frames.MenuStats;
import mensajeria.Comando;
import mensajeria.Paquete;

/**
 * Clase que administra la pantalla. <br>
 */
public class Pantalla {
	/**
	 * Pantalla. <br>
	 */
	private JFrame pantalla;
	/**
	 * Canvas en el que dibuja. <br>
	 */
	private Canvas canvas;
	/**
	 * Menú del inventario. <br>
	 */
	public static MenuInventario menuInventario;
	/**
	 * Menú de asignar skills. <br>
	 */
	public static MenuAsignarSkills menuAsignar;
	/**
	 * Menú de stats. <br>
	 */
	public static MenuStats menuStats;
	/**
	 * Menú de escape. <br>
	 */
	public static MenuEscape menuEscp;
	/**
	 * Ventada de contactos del chat. <br>
	 */
	public static VentanaContactos ventContac;
	/**
	 * Gson Pantalla. <br>
	 */
	private final Gson gson = new Gson();

	/**
	 * Construye la pantalla del juego. <br>
	 * Se encarga de mostrar desde el mundo hasta el inventario. <br>
	 * @param nombre
	 *            Nombre del juego. <br>
	 * @param ancho
	 *            Ancho de pantalla. <br>
	 * @param alto
	 *            Alto de pantalla. <br>
	 * @param cliente
	 *            Usuario. <br>
	 */
	public Pantalla(final String nombre, final int ancho, final int alto, final Cliente cliente) {
		pantalla = new JFrame(nombre);
		pantalla.setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/frames/IconoWome.png"));
		pantalla.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(), new Point(0, 0),
				"custom cursor"));
		pantalla.setSize(ancho, alto);
		pantalla.setResizable(false);
		pantalla.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		pantalla.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent evt) {
				try {
					Paquete p = new Paquete();
					p.setComando(Comando.DESCONECTAR);
					p.setIp(cliente.getMiIp());
					cliente.getSalida().writeObject(gson.toJson(p));
					cliente.getEntrada().close();
					cliente.getSalida().close();
					cliente.getSocket().close();
					System.exit(0);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Fallo al intentar cerrar la aplicación.");
					System.exit(1);
				}
			}
		});
		pantalla.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(final KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_I) {
					if (Estado.getEstado().esEstadoDeJuego()) {
						if (menuInventario == null) {
							menuInventario = new MenuInventario(cliente);
							menuInventario.setVisible(true);
						}
					}
				} else {
					if (e.getKeyCode() == KeyEvent.VK_A) {
						if (Estado.getEstado().esEstadoDeJuego()) {
							if (menuAsignar == null) {
								menuAsignar = new MenuAsignarSkills(cliente);
								menuAsignar.setVisible(true);
							}
							menuAsignar = null;
						}
					} else {
						if (e.getKeyCode() == KeyEvent.VK_S) {
							if (Estado.getEstado().esEstadoDeJuego()) {
								if (menuStats == null) {
									menuStats = new MenuStats(cliente);
									menuStats.setVisible(true);
								}
							}
						} else {
							if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
								if (Estado.getEstado().esEstadoDeJuego()) {
									if (menuEscp == null) {
										menuEscp = new MenuEscape(cliente);
										menuEscp.setVisible(true);
									}
								}
							} else {
								if (e.getKeyCode() == KeyEvent.VK_C) {
									// if(Estado.getEstado().esEstadoDeJuego())
									// {
									if (ventContac == null) {
										ventContac = new VentanaContactos(cliente.getJuego());
										ventContac.setVisible(true);
									}
									// }
								}
							}
						}
					}
				}
			}
		});
		pantalla.setLocationRelativeTo(null);
		pantalla.setVisible(false);
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(ancho, alto));
		canvas.setMaximumSize(new Dimension(ancho, alto));
		canvas.setMinimumSize(new Dimension(ancho, alto));
		canvas.setFocusable(false);
		pantalla.add(canvas);
		pantalla.pack();
	}

	/**
	 * Devuelve el canvas. <br>
	 * @return Canvas. <br>
	 */
	public Canvas getCanvas() {
		return canvas;
	}

	/**
	 * Muestra la pantalla. <br>
	 * @return Pantalla. <br>
	 */
	public JFrame getFrame() {
		return pantalla;
	}

	/**
	 * Hace la pantalla visible. <br>
	 */
	public void mostrar() {
		pantalla.setVisible(true);
	}

	/**
	 * Centraliza la pantalla con el movimiento del jugador. <br>
	 * @param g
	 *            Grafico. <br>
	 * @param area
	 *            Rectangulo. <br>
	 * @param string
	 *            String. <br>
	 */
	public static void centerString(final Graphics g, final Rectangle area, final String string) {
		FontRenderContext frc = new FontRenderContext(null, true, true);
		Rectangle2D r2D = g.getFont().getStringBounds(string, frc);
		int rWidth = (int) Math.round(r2D.getWidth());
		int rHeight = (int) Math.round(r2D.getHeight());
		int rX = (int) Math.round(r2D.getX());
		int rY = (int) Math.round(r2D.getY());
		int a = (area.width / 2) - (rWidth / 2) - rX;
		int b = (area.height / 2) - (rHeight / 2) - rY;
		g.drawString(string, area.x + a, area.y + b);
	}
}
