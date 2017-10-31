package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import com.google.gson.Gson;

import juego.Juego;
import juego.Pantalla;
import mensajeria.Comando;

/**
 * Clase que administra el chat del cliente. <br>
 */
@SuppressWarnings("serial")
public class MiChat extends JFrame {
	/**
	 * Panel del chat. <br>
	 */
	private JPanel contentPane;
	/**
	 * Area del texto del chat. <br>
	 */
	private JTextField texto;
	/**
	 * Area del chat. <br>
	 */
	private JTextArea chat;
	/**
	 * Juego del chat. <br>
	 */
	@SuppressWarnings("unused")
	private Juego juego;
	/**
	 * Gson. <br>
	 */
	private final Gson gson = new Gson();
	/**
	 * Fondo del chat. <br>
	 */
	private final JLabel background = new JLabel(new ImageIcon("recursos//background.jpg"));
	/**
	 * Caret. <br>
	 */
	private DefaultCaret caret;
	/**
	 * Empty BorderPante del ContentPane. <br>
	 */
	private static final int CONTENT_PANE_BORDER = 5;
	/**
	 * Bounds X del texto. <br>
	 */
	private static final int TEXTO_X = 10;
	/**
	 * Bounds Y del texto. <br>
	 */
	private static final int TEXTO_Y = 223;
	/**
	 * Bounds Width del texto. <br>
	 */
	private static final int TEXTO_WIDTH = 314;
	/**
	 * Bounds Height del texto. <br>
	 */
	private static final int TEXTO_HEIGHT = 27;
	/**
	 * Columnas del texto. <br>
	 */
	private static final int TEXTO_COLUMNAS = 10;
	/**
	 * Bounds X del background. <br>
	 */
	private static final int BACKGROUND_X = -20;
	/**
	 * Bounds Y del background. <br>
	 */
	private static final int BACKGROUND_Y = 0;
	/**
	 * Bounds Width del background. <br>
	 */
	private static final int BACKGROUND_WIDTH = 480;
	/**
	 * Bounds Height del background. <br>
	 */
	private static final int BACKGROUND_HEIGHT = 283;
	/**
	 * Bounds X del botón enviar. <br>
	 */
	private static final int BOTON_ENVIAR_X = 334;
	/**
	 * Bounds Y del botón enviar. <br>
	 */
	private static final int BOTON_ENVIAR_Y = 225;
	/**
	 * Bounds Width del botón enviar. <br>
	 */
	private static final int BOTON_ENVIAR_WIDTH = 81;
	/**
	 * Bounds Height del botón enviar. <br>
	 */
	private static final int BOTON_ENVIAR_HEIGHT = 23;
	/**
	 * Bounds X de la pantalla principal. <br>
	 */
	private static final int PRINICIPAL_X = 100;
	/**
	 * Bounds Y de la pantalla principal. <br>
	 */
	private static final int PRINICIPAL_Y = 100;
	/**
	 * Bounds Width de la pantalla principal. <br>
	 */
	private static final int PRINICIPAL_WIDTH = 450;
	/**
	 * Bounds Height de la pantalla principal. <br>
	 */
	private static final int PRINICIPAL_HEIGHT = 300;
	/**
	 * Bounds X de la pantalla principal. <br>
	 */
	private static final int SCROLL_PANE_X = 10;
	/**
	 * Bounds Y de la pantalla principal. <br>
	 */
	private static final int SCROLL_PANE_Y = 11;
	/**
	 * Bounds Width de la pantalla principal. <br>
	 */
	private static final int SCROLL_PANE_WIDTH = 414;
	/**
	 * Bounds Height de la pantalla principal. <br>
	 */
	private static final int SCROLL_PANE_HEIGHT = 201;

	/**
	 * Crea el frame. <br>
	 * @param juego
	 *            Juego.<br>
	 */
	public MiChat(final Juego juego) {
		this.juego = juego;
		setTitle("Mi Chat");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(PRINICIPAL_X, PRINICIPAL_Y, PRINICIPAL_WIDTH, PRINICIPAL_HEIGHT);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(
				new EmptyBorder(CONTENT_PANE_BORDER, CONTENT_PANE_BORDER, CONTENT_PANE_BORDER, CONTENT_PANE_BORDER));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(SCROLL_PANE_X, SCROLL_PANE_Y, SCROLL_PANE_WIDTH, SCROLL_PANE_HEIGHT);
		contentPane.add(scrollPane);
		chat = new JTextArea();
		chat.setEditable(false);
		scrollPane.setViewportView(chat);
		caret = (DefaultCaret) chat.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		texto = new JTextField();
		this.addWindowListener(new WindowAdapter() {
			public void windowOpened(final WindowEvent e) {
				texto.requestFocus();
			}
			@Override
			public void windowClosing(final WindowEvent e) {
				if (getTitle() == "Sala") {
					if (Pantalla.ventContac != null) {
						VentanaContactos.getBotonMc().setEnabled(true);
					}
				}
				juego.getChatsActivos().remove(getTitle());
			}
		});
		// SI TOCO ENTER
		texto.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (!texto.getText().equals("")) {
					chat.append("Me: " + texto.getText() + "\n");
					juego.getCliente().getPaqueteMensaje().setUserEmisor(juego.getPersonaje().getNombre());
					juego.getCliente().getPaqueteMensaje().setUserReceptor(getTitle());
					juego.getCliente().getPaqueteMensaje().setMensaje(texto.getText());
					// MANDO EL COMANDO PARA QUE ENVIE EL MSJ
					juego.getCliente().getPaqueteMensaje().setComando(Comando.TALK);
					// El user receptor en espacio indica que es para todos
					if (getTitle() == "Sala") {
						juego.getCliente().getPaqueteMensaje().setUserReceptor(null);
					}
					try {
						juego.getCliente().getSalida().writeObject(gson.toJson(juego.getCliente().getPaqueteMensaje()));
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error al enviar mensaje");
					}
					texto.setText("");
				}
				texto.requestFocus();
			}
		});
		// SI TOCO ENVIAR
		JButton enviar = new JButton("ENVIAR");
		enviar.setIcon(new ImageIcon("recursos//enviarButton.png"));
		enviar.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (!texto.getText().equals("")) {
					chat.append("Me: " + texto.getText() + "\n");
					juego.getCliente().getPaqueteMensaje().setUserEmisor(juego.getPersonaje().getNombre());
					juego.getCliente().getPaqueteMensaje().setUserReceptor(getTitle());
					juego.getCliente().getPaqueteMensaje().setMensaje(texto.getText());
					// MANDO EL COMANDO PARA QUE ENVIE EL MSJ
					juego.getCliente().getPaqueteMensaje().setComando(Comando.TALK);
					// El user receptor en espacio indica que es para todos
					if (getTitle() == "Sala") {
						juego.getCliente().getPaqueteMensaje().setUserReceptor(null);
					}
					try {
						juego.getCliente().getSalida().writeObject(gson.toJson(juego.getCliente().getPaqueteMensaje()));
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error al enviar mensaje");

					}
					texto.setText("");
				}
				texto.requestFocus();
			}
		});
		enviar.setBounds(BOTON_ENVIAR_X, BOTON_ENVIAR_Y, BOTON_ENVIAR_WIDTH, BOTON_ENVIAR_HEIGHT);
		contentPane.add(enviar);
		texto.setBounds(TEXTO_X, TEXTO_Y, TEXTO_WIDTH, TEXTO_HEIGHT);
		contentPane.add(texto);
		texto.setColumns(TEXTO_COLUMNAS);
		background.setBounds(BACKGROUND_X, BACKGROUND_Y, BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
		contentPane.add(background);
	}

	/**
	 * Devuelve el área del chat del cliente. <br>
	 * @return Área del chat. <br>
	 */
	public final JTextArea getChat() {
		return chat;
	}

	/**
	 * Devuelve el texto escrito. <br>
	 * @return Texto escrito. <br>
	 */
	public final JTextField getTexto() {
		return texto;
	}
}
