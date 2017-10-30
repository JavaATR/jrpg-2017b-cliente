package frames;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import mensajeria.Comando;

import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Clase que administra el menú de los mapas. <br>
 */
@SuppressWarnings("serial")
public class MenuMapas extends JFrame {
	/**
	 * Número del mapa. <br>
	 */
	public static int numberMap = 0;
	/**
	 * Content pane. <br>
	 */
	private JPanel contentPane;
	/**
	 * Empty BorderPante del ContentPane. <br>
	 */
	private static final int CONTENT_PANE_BORDER = 5;
	/**
	 * Bounds X principal. <br>
	 */
	private static final int PRINCIPAL_X = 100;
	/**
	 * Bounds Y principal. <br>
	 */
	private static final int PRINCIPAL_Y = 100;
	/**
	 * Bounds Width principal. <br>
	 */
	private static final int PRINCIPAL_WIDTH = 450;
	/**
	 * Bounds Height principal. <br>
	 */
	private static final int PRINCIPAL_HEIGHT = 300;
	/**
	 * Bounds X del JPane. <br>
	 */
	private static final int JPANE_X = 0;
	/**
	 * Bounds Y del JPane. <br>
	 */
	private static final int JPANE_Y = 0;
	/**
	 * Bounds Width del JPane. <br>
	 */
	private static final int JPANE_WIDTH = 444;
	/**
	 * Bounds Height del JPane. <br>
	 */
	private static final int JPANE_HEIGHT = 271;
	/**
	 * Bounds X de Aris. <br>
	 */
	private static final int ARIS_X = 204;
	/**
	 * Bounds Y de Aris. <br>
	 */
	private static final int ARIS_Y = 129;
	/**
	 * Bounds Width de Aris. <br>
	 */
	private static final int ARIS_WIDTH = 32;
	/**
	 * Bounds Height de Aris. <br>
	 */
	private static final int ARIS_HEIGHT = 23;
	/**
	 * Font de Aris. <br>
	 */
	private static final int ARIS_FONT = 15;
	/**
	 * Bounds X de Aubenor. <br>
	 */
	private static final int AUBENOR_X = 191;
	/**
	 * Bounds Y de Aubenor. <br>
	 */
	private static final int AUBENOR_Y = 72;
	/**
	 * Bounds Width de Aubenor. <br>
	 */
	private static final int AUBENOR_WIDTH = 66;
	/**
	 * Bounds Height de Aubenor. <br>
	 */
	private static final int AUBENOR_HEIGHT = 23;
	/**
	 * Font de Aubenor. <br>
	 */
	private static final int AUBENOR_FONT = 15;
	/**
	 * Bounds X de Eodrim. <br>
	 */
	private static final int EODRIM_X = 198;
	/**
	 * Bounds Y de Eodrim. <br>
	 */
	private static final int EODRIM_Y = 192;
	/**
	 * Bounds Width de Eodrim. <br>
	 */
	private static final int EODRIM_WIDTH = 53;
	/**
	 * Bounds Height de Eodrim. <br>
	 */
	private static final int EODRIM_HEIGHT = 23;
	/**
	 * Font de Eodrim. <br>
	 */
	private static final int EODRIM_FONT = 15;
	/**
	 * Bounds X del botón de Eodrim. <br>
	 */
	private static final int BOTON_EODRIM_X = 148;
	/**
	 * Bounds Y del botón de Eodrim. <br>
	 */
	private static final int BOTON_EODRIM_Y = 192;
	/**
	 * Bounds Width del botón de Eodrim. <br>
	 */
	private static final int BOTON_EODRIM_WIDTH = 143;
	/**
	 * Bounds Height del botón de Eodrim. <br>
	 */
	private static final int BOTON_EODRIM_HEIGHT = 23;
	/**
	 * Id del mapa Eodrim. <br>
	 */
	private static final int EODRIM = 3;
	/**
	 * Bounds X del botón de Aris. <br>
	 */
	private static final int BOTON_ARIS_X = 148;
	/**
	 * Bounds Y del botón de Aris. <br>
	 */
	private static final int BOTON_ARIS_Y = 130;
	/**
	 * Bounds Width del botón de Aris. <br>
	 */
	private static final int BOTON_ARIS_WIDTH = 143;
	/**
	 * Bounds Height del botón de Aris. <br>
	 */
	private static final int BOTON_ARIS_HEIGHT = 23;
	/**
	 * Id del mapa Aris. <br>
	 */
	private static final int ARIS = 2;
	/**
	 * Bounds X del botón de Aubenor. <br>
	 */
	private static final int BOTON_AUBENOR_X = 148;
	/**
	 * Bounds Y del botón de Aubenor. <br>
	 */
	private static final int BOTON_AUBENOR_Y = 72;
	/**
	 * Bounds Width del botón de Aubenor. <br>
	 */
	private static final int BOTON_AUBENOR_WIDTH = 143;
	/**
	 * Bounds Height del botón de Aubenor. <br>
	 */
	private static final int BOTON_AUBENOR_HEIGHT = 23;
	/**
	 * Id del mapa Aubenor. <br>
	 */
	private static final int AUBENOR = 1;
	/**
	 * Bounds X del background. <br>
	 */
	private static final int BACKGROUND_X = 0;
	/**
	 * Bounds Y del background. <br>
	 */
	private static final int BACKGROUND_Y = 0;
	/**
	 * Bounds Width del background. <br>
	 */
	private static final int BACKGROUND_WIDTH = 444;
	/**
	 * Bounds Height del background. <br>
	 */
	private static final int BACKGROUND_HEIGHT = 271;

	/**
	 * Crea un menú de mapas. <br>
	 * @param cliente
	 *            Cliente que invoca el menú. <br>
	 */
	public MenuMapas(final Cliente cliente) {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					synchronized (cliente) {
						cliente.getPaquetePersonaje().setMapa(1);
						numberMap = 1;
						cliente.notify();
					}
					dispose();
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/main/java/frames/IconoWome.png"));
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon(MenuJugar.class.getResource("/cursor.png")).getImage(), new Point(0, 0),
				"custom cursor"));
		setTitle("Elegir Mapa");
		setBounds(PRINCIPAL_X, PRINCIPAL_Y, PRINCIPAL_WIDTH, PRINCIPAL_HEIGHT);
		// En caso de cerrar
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				synchronized (cliente) {
					cliente.setAccion(Comando.SALIR);
					cliente.notify();
				}
				dispose();
			}
		});
		// Panel
		setTitle("WOME - Elegir Mapa");
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		setBounds(PRINCIPAL_X, PRINCIPAL_Y, PRINCIPAL_WIDTH, PRINCIPAL_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(
				new EmptyBorder(CONTENT_PANE_BORDER, CONTENT_PANE_BORDER, CONTENT_PANE_BORDER, CONTENT_PANE_BORDER));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(JPANE_X, JPANE_Y, JPANE_WIDTH, JPANE_HEIGHT);
		contentPane.add(layeredPane);
		// Mapa Aris
		JLabel lblAris = new JLabel("Aris");
		lblAris.setBounds(ARIS_X, ARIS_Y, ARIS_WIDTH, ARIS_HEIGHT);
		layeredPane.add(lblAris, new Integer(2));
		lblAris.setForeground(Color.WHITE);
		lblAris.setFont(new Font("Tahoma", Font.PLAIN, ARIS_FONT));
		// Mapa Aubenor
		JLabel lblAubenor = new JLabel("Aubenor");
		lblAubenor.setBounds(AUBENOR_X, AUBENOR_Y, AUBENOR_WIDTH, AUBENOR_HEIGHT);
		layeredPane.add(lblAubenor, new Integer(2));
		lblAubenor.setForeground(Color.WHITE);
		lblAubenor.setFont(new Font("Tahoma", Font.PLAIN, AUBENOR_FONT));
		// Mapa Eodrim
		JLabel lblEodrim = new JLabel("Eodrim");
		lblEodrim.setBounds(EODRIM_X, EODRIM_Y, EODRIM_WIDTH, EODRIM_HEIGHT);
		layeredPane.add(lblEodrim, new Integer(2));
		lblEodrim.setForeground(Color.WHITE);
		lblEodrim.setFont(new Font("Tahoma", Font.PLAIN, EODRIM_FONT));
		JButton btnAubenor = new JButton("");
		btnAubenor.setBounds(BOTON_AUBENOR_X, BOTON_AUBENOR_Y, BOTON_AUBENOR_WIDTH, BOTON_AUBENOR_HEIGHT);
		layeredPane.add(btnAubenor, new Integer(1));
		btnAubenor.setFocusable(false);
		btnAubenor.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/BotonMenu.png")));
		JButton btnEodrim = new JButton("");
		btnEodrim.setBounds(BOTON_EODRIM_X, BOTON_EODRIM_Y, BOTON_EODRIM_WIDTH, BOTON_EODRIM_HEIGHT);
		layeredPane.add(btnEodrim, new Integer(1));
		btnEodrim.setFocusable(false);
		btnEodrim.setEnabled(false);
		btnEodrim.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/BotonMenu.png")));
		btnEodrim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				synchronized (cliente) {
					cliente.getPaquetePersonaje().setMapa(EODRIM);
					cliente.notify();
				}
				dispose();
			}
		});
		btnEodrim.setEnabled(false);
		JButton btnAris = new JButton("");
		btnAris.setBounds(BOTON_ARIS_X, BOTON_ARIS_Y, BOTON_ARIS_WIDTH, BOTON_ARIS_HEIGHT);
		layeredPane.add(btnAris, new Integer(1));
		btnAris.setFocusable(false);
		btnAris.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/BotonMenu.png")));
		btnAris.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				synchronized (cliente) {
					cliente.getPaquetePersonaje().setMapa(ARIS);
					numberMap = 2;
					cliente.notify();
				}
				dispose();
			}
		});
		btnAris.setEnabled(true);
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(BACKGROUND_X, BACKGROUND_Y, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
		layeredPane.add(lblBackground, new Integer(0));
		lblBackground.setIcon(new ImageIcon(MenuMapas.class.getResource("/frames/menuBackground.jpg")));
		btnAubenor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				synchronized (cliente) {
					cliente.getPaquetePersonaje().setMapa(AUBENOR);
					numberMap = 1;
					cliente.notify();
				}
				dispose();
			}
		});
	}
}
