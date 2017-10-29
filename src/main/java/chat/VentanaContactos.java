package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import juego.Juego;
import juego.Pantalla;
import mensajeria.PaquetePersonaje;

/**
 * Clase que administra la lista de contactos del cliente. <br>
 */
@SuppressWarnings("serial")
public class VentanaContactos extends JFrame {
	/**
	 * Panel principal. <br>
	 */
	private JPanel contentPane;
	/**
	 * Lista de usuarios visual. <br>
	 */
	private DefaultListModel<String> modelo = new DefaultListModel<String>();
	/**
	 * Lista de usuarios. <br>
	 */
	private static JList<String> list = new JList<String>();
	/**
	 * Botón del multi-chat. <br>
	 */
	private static JButton botonMc;
	/**
	 * Fondo del chat. <br>
	 */
	private JLabel background;
	/**
	 * Empty BorderPante del ContentPane. <br>
	 */
	private static final int CONTENT_PANE_BORDER = 5;
	/**
	 * Bounds X del principal. <br>
	 */
	private static final int TEXTO_X = 100;
	/**
	 * Bounds Y del principal. <br>
	 */
	private static final int TEXTO_Y = 100;
	/**
	 * Bounds Width del principal. <br>
	 */
	private static final int TEXTO_WIDTH = 327;
	/**
	 * Bounds Height del principal. <br>
	 */
	private static final int TEXTO_HEIGHT = 273;
	/**
	 * Bounds X del scrollPane. <br>
	 */
	private static final int SCROLL_PANE_X = 10;
	/**
	 * Bounds Y del scrollPane. <br>
	 */
	private static final int SCROLL_PANE_Y = 11;
	/**
	 * Bounds Width del scrollPane. <br>
	 */
	private static final int SCROLL_PANE_WIDTH = 299;
	/**
	 * Bounds Height del scrollPane. <br>
	 */
	private static final int SCROLL_PANE_HEIGHT = 188;
	/**
	 * Bounds X del botón de multi-chat. <br>
	 */
	private static final int BOTON_MC_X = 119;
	/**
	 * Bounds Y del botón de multi-chat. <br>
	 */
	private static final int BOTON_MC_Y = 208;
	/**
	 * Bounds Width del botón de multi-chat. <br>
	 */
	private static final int BOTON_MC_WIDTH = 89;
	/**
	 * Bounds Height del botón de multi-chat. <br>
	 */
	private static final int BOTON_MC_HEIGHT = 23;
	/**
	 * Bounds X del background. <br>
	 */
	private static final int BACKGROUND_X = -16;
	/**
	 * Bounds Y del background. <br>
	 */
	private static final int BACKGROUND_Y = 0;
	/**
	 * Bounds Width del background. <br>
	 */
	private static final int BACKGROUND_WIDTH = 352;
	/**
	 * Bounds Height del background. <br>
	 */
	private static final int BACKGROUND_HEIGHT = 254;

	/**
	 * Create the frame.
	 */
	public VentanaContactos(final Juego juego) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(TEXTO_X, TEXTO_Y, TEXTO_WIDTH, TEXTO_HEIGHT);
		setLocationRelativeTo(null);
		setTitle("Usuarios");
		contentPane = new JPanel();
		contentPane.setBorder(
				new EmptyBorder(CONTENT_PANE_BORDER, CONTENT_PANE_BORDER, CONTENT_PANE_BORDER, CONTENT_PANE_BORDER));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(SCROLL_PANE_X, SCROLL_PANE_Y, SCROLL_PANE_WIDTH, SCROLL_PANE_HEIGHT);
		contentPane.add(scrollPane);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent arg0) {
				Pantalla.ventContac = null;
				dispose();
			}
		});
		botonMc = new JButton("Multichat");
		botonMc.setIcon(new ImageIcon("recursos//multichatButton.png"));
		botonMc.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (modelo.size() != 0) {
					if (!juego.getChatsActivos().containsKey("Sala")) {
						MiChat chat = new MiChat(juego);
						juego.getChatsActivos().put("Sala", chat);
						chat.setTitle("Sala");
						chat.setVisible(true);
						botonMc.setEnabled(false);
					}
				}
			}
		});
		botonMc.setBounds(BOTON_MC_X, BOTON_MC_Y, BOTON_MC_WIDTH, BOTON_MC_HEIGHT);
		contentPane.add(botonMc);
		// Cargo la lista de contactos
		actualizarLista(juego);
		// Pregunto si la ventana sala esta abierta y cancelo el boton multichat
		if (juego.getChatsActivos().containsKey("Sala")) {
			botonMc.setEnabled(false);
		} else {
			botonMc.setEnabled(true);
		}
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					if (list.getSelectedValue() != null) {
						if (!juego.getChatsActivos().containsKey(list.getSelectedValue())) {
							if (juego.getCliente() != null) {
								MiChat chat = new MiChat(juego);
								juego.getChatsActivos().put(list.getSelectedValue(), chat);
								chat.setTitle(list.getSelectedValue());
								chat.setVisible(true);
							}
						}
					}
				}
			}
		});
		list.setModel(modelo);
		scrollPane.setViewportView(list);
		background = new JLabel(new ImageIcon("recursos//background.jpg"));
		background.setBounds(BACKGROUND_X, BACKGROUND_Y, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
		contentPane.add(background);
	}

	/**
	 * Actualiza la lista de contactos del cliente. <br>
	 * @param juego
	 *            Juego del cliente. <br>
	 */
	private void actualizarLista(final Juego juego) {
		if (juego.getCliente() != null) {
			synchronized (juego.getCliente()) {
				modelo.removeAllElements();
				if (juego.getPersonajesConectados() != null) {
					for (Map.Entry<Integer, PaquetePersonaje> personaje : juego.getPersonajesConectados().entrySet()) {
						modelo.addElement(personaje.getValue().getNombre());
					}
					modelo.removeElement(juego.getPersonaje().getNombre());
					list.setModel(modelo);
				}
			}
		}
	}

	/**
	 * Devuelve la lista de los contactos. <br>
	 * @return Lista de contactos. <br>
	 */
	public static JList<String> getList() {
		return list;
	}

	/**
	 * Devuelve el botón del multi-chat. <br>
	 * @return Botón de multi-chat. <br>
	 */
	public static JButton getBotonMc() {
		return botonMc;
	}
}
