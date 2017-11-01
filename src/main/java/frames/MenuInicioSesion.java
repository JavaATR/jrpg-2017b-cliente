package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import mensajeria.Comando;

/**
 * Clase que administra el inicio de sesión del cliente. <br>
 */
@SuppressWarnings("serial")
public class MenuInicioSesion extends JFrame {
    /**
     * Content pane. <br>
     */
    private JPanel contentPane;
    /**
     * Área del usuario. <br>
     */
    private JTextField userField;
    /**
     * Área de la contraseña. <br>
     */
    private JPasswordField passwordField;
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
     * Empty BorderPante del ContentPane. <br>
     */
    private static final int CONTENT_PANE_BORDER = 5;
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
     * Bounds X del password. <br>
     */
    private static final int PASSWORD_X = 111;
    /**
     * Bounds Y del password. <br>
     */
    private static final int PASSWORD_Y = 118;
    /**
     * Bounds Width del password. <br>
     */
    private static final int PASSWORD_WIDTH = 68;
    /**
     * Bounds Height del password. <br>
     */
    private static final int PASSWORD_HEIGHT = 21;
    /**
     * Font del password. <br>
     */
    private static final int PASSWORD_FONT = 15;
    /**
     * Bounds X del usuario. <br>
     */
    private static final int USUARIO_X = 111;
    /**
     * Bounds Y del usuario. <br>
     */
    private static final int USUARIO_Y = 66;
    /**
     * Bounds Width del usuario. <br>
     */
    private static final int USUARIO_WIDTH = 55;
    /**
     * Bounds Height del usuario. <br>
     */
    private static final int USUARIO_HEIGHT = 23;
    /**
     * Font del usuario. <br>
     */
    private static final int USUARIO_FONT = 15;
    /**
     * Bounds X del ingreso. <br>
     */
    private static final int INGRESAR_X = 193;
    /**
     * Bounds Y del ingreso. <br>
     */
    private static final int INGRESAR_Y = 183;
    /**
     * Bounds Width del ingreso. <br>
     */
    private static final int INGRESAR_WIDTH = 68;
    /**
     * Bounds Height del ingreso. <br>
     */
    private static final int INGRESAR_HEIGHT = 23;
    /**
     * Font del ingreso. <br>
     */
    private static final int INGRESAR_FONT = 15;
    /**
     * Bounds X del campo de usuario. <br>
     */
    private static final int USUARIO_TXT_X = 198;
    /**
     * Bounds Y del campo de usuario. <br>
     */
    private static final int USUARIO_TXT_Y = 69;
    /**
     * Bounds Width del campo de usuario. <br>
     */
    private static final int USUARIO_TXT_WIDTH = 118;
    /**
     * Bounds Height del campo de usuario. <br>
     */
    private static final int USUARIO_TXT_HEIGHT = 20;
    /**
     * Columnas del campo de usuario. <br>
     */
    private static final int USUARIO_TXT_COLUMNAS = 10;
    /**
     * Bounds X del campo de password. <br>
     */
    private static final int PASSWORD_TXT_X = 198;
    /**
     * Bounds Y del campo de password. <br>
     */
    private static final int PASSWORD_TXT_Y = 119;
    /**
     * Bounds Width del campo de password. <br>
     */
    private static final int PASSWORD_TXT_WIDTH = 118;
    /**
     * Bounds Height del campo de password. <br>
     */
    private static final int PASSWORD_TXT_HEIGHT = 20;
    /**
     * Bounds Height del campo de password. <br>
     */
    private static final int PASSWORD_TXT_FONT = 11;
    /**
     * Bounds X del botón de conectar. <br>
     */
    private static final int BOTON_CONECTAR_X = 141;
    /**
     * Bounds Y del botón de conectar. <br>
     */
    private static final int BOTON_CONECTAR_Y = 182;
    /**
     * Bounds Width del botón de conectar. <br>
     */
    private static final int BOTON_CONECTAR_WIDTH = 153;
    /**
     * Bounds Height del botón de conectar. <br>
     */
    private static final int BOTON_CONECTAR_HEIGHT = 23;
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
     * Crea el menú de inicio de sesión. <br>
     *
     * @param cliente
     *            Cliente que lo invoca. <br>
     */
    public MenuInicioSesion(final Cliente cliente) {
        setIconImage(Toolkit.getDefaultToolkit()
                .getImage("src/main/java/frames/IconoWome.png"));
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon(MenuJugar.class.getResource("/cursor.png"))
                        .getImage(),
                new Point(0, 0), "custom cursor"));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                synchronized (cliente) {
                    cliente.setAccion(Comando.SALIR);
                    cliente.notify();
                }
                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            }
        });
        setTitle("WOME - Iniciar Sesion");
        setBounds(PRINCIPAL_X, PRINCIPAL_Y, PRINCIPAL_WIDTH, PRINCIPAL_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(CONTENT_PANE_BORDER,
                CONTENT_PANE_BORDER, CONTENT_PANE_BORDER, CONTENT_PANE_BORDER));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(JPANE_X, JPANE_Y, JPANE_WIDTH, JPANE_HEIGHT);
        contentPane.add(layeredPane);
        JLabel lblNewLabel1 = new JLabel("Password");
        lblNewLabel1.setBounds(PASSWORD_X, PASSWORD_Y, PASSWORD_WIDTH,
                PASSWORD_HEIGHT);
        layeredPane.add(lblNewLabel1);
        lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, PASSWORD_FONT));
        lblNewLabel1.setForeground(Color.WHITE);
        JLabel lblNewLabel = new JLabel("Usuario");
        lblNewLabel.setBounds(USUARIO_X, USUARIO_Y, USUARIO_WIDTH,
                USUARIO_HEIGHT);
        layeredPane.add(lblNewLabel, new Integer(2));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, USUARIO_FONT));
        JLabel lblIngresar = new JLabel("Ingresar");
        lblIngresar.setBounds(INGRESAR_X, INGRESAR_Y, INGRESAR_WIDTH,
                INGRESAR_HEIGHT);
        layeredPane.add(lblIngresar, new Integer(2));
        lblIngresar.setForeground(Color.WHITE);
        lblIngresar.setFont(new Font("Tahoma", Font.PLAIN, INGRESAR_FONT));
        userField = new JTextField();
        userField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent arg0) {
                logIn(cliente);
            }
        });
        userField.setBounds(USUARIO_TXT_X, USUARIO_TXT_Y, USUARIO_TXT_WIDTH,
                USUARIO_TXT_HEIGHT);
        layeredPane.add(userField, new Integer(1));
        userField.setColumns(USUARIO_TXT_COLUMNAS);
        passwordField = new JPasswordField();
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                logIn(cliente);
            }
        });
        passwordField.setBounds(PASSWORD_TXT_X, PASSWORD_TXT_Y,
                PASSWORD_TXT_WIDTH, PASSWORD_TXT_HEIGHT);
        layeredPane.add(passwordField, new Integer(1));
        passwordField
                .setFont(new Font("Tahoma", Font.PLAIN, PASSWORD_TXT_FONT));
        JButton btnConectar = new JButton("");
        btnConectar.setBounds(BOTON_CONECTAR_X, BOTON_CONECTAR_Y,
                BOTON_CONECTAR_WIDTH, BOTON_CONECTAR_HEIGHT);
        layeredPane.add(btnConectar, new Integer(1));
        btnConectar.setFocusable(false);
        btnConectar.setIcon(new ImageIcon(
                MenuInicioSesion.class.getResource("/frames/BotonMenu.png")));
        btnConectar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                logIn(cliente);

            }
        });
        JLabel labelBackground = new JLabel("");
        labelBackground.setBounds(BACKGROUND_X, BACKGROUND_Y, BACKGROUND_WIDTH,
                BACKGROUND_HEIGHT);
        labelBackground.setIcon(new ImageIcon(MenuInicioSesion.class
                .getResource("/frames/menuBackground.jpg")));
        layeredPane.add(labelBackground, new Integer(0));
    }

    /**
     * Logea a un cliente. <br>
     *
     * @param cliente
     *            Cliente que se loguea. <br>
     */
    private void logIn(final Cliente cliente) {
        synchronized (cliente) {
            cliente.setAccion(Comando.INICIOSESION);
            cliente.getPaqueteUsuario().setUsername(userField.getText());
            cliente.getPaqueteUsuario()
                    .setPassword(String.valueOf(passwordField.getPassword()));
            cliente.notify();
            dispose();
        }
    }
}
