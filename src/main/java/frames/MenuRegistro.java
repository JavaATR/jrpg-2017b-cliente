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
/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;*/
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cliente.Cliente;
import mensajeria.Comando;

/**
 * Clase que administra el menú de registro de usuario. <br>
 */
@SuppressWarnings("serial")
public class MenuRegistro extends JFrame {
    /**
     * Campo de usuario. <br>
     */
    private JTextField txtUsuario;
    /**
     * Campo de contraseña. <br>
     */
    private JPasswordField pwPassword;
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
    private static final int PANE_X = 0;
    /**
     * Bounds Y del JPane. <br>
     */
    private static final int PANE_Y = 0;
    /**
     * Bounds Width del JPane. <br>
     */
    private static final int PANE_WIDTH = 444;
    /**
     * Bounds Height del JPane. <br>
     */
    private static final int PANE_HEIGHT = 271;
    /**
     * Bounds X del usuario. <br>
     */
    private static final int USUARIO_X = 113;
    /**
     * Bounds Y del usuario. <br>
     */
    private static final int USUARIO_Y = 70;
    /**
     * Bounds Width del usuario. <br>
     */
    private static final int USUARIO_WIDTH = 57;
    /**
     * Bounds Height del usuario. <br>
     */
    private static final int USUARIO_HEIGHT = 19;
    /**
     * Tamaño del font de usuario. <br>
     */
    private static final int USUARIO_FONT = 15;
    /**
     * Bounds X del password. <br>
     */
    private static final int PASSWORD_X = 113;
    /**
     * Bounds Y del password. <br>
     */
    private static final int PASSWORD_Y = 121;
    /**
     * Bounds Width del password. <br>
     */
    private static final int PASSWORD_WIDTH = 65;
    /**
     * Bounds Height del password. <br>
     */
    private static final int PASSWORD_HEIGHT = 17;
    /**
     * Tamaño del font de password. <br>
     */
    private static final int PASSWORD_FONT = 15;
    /**
     * Bounds X del registrarse. <br>
     */
    private static final int REGISTRARSE_X = 186;
    /**
     * Bounds Y del registrarse. <br>
     */
    private static final int REGISTRARSE_Y = 182;
    /**
     * Bounds Width del registrarse. <br>
     */
    private static final int REGISTRARSE_WIDTH = 82;
    /**
     * Bounds Height del registrarse. <br>
     */
    private static final int REGISTRARSE_HEIGHT = 23;
    /**
     * Tamaño del font de registrarse. <br>
     */
    private static final int REGISTRARSE_FONT = 15;
    /**
     * Bounds X del botón registrarse. <br>
     */
    private static final int BOTON_REGISTRARSE_X = 143;
    /**
     * Bounds Y del botón registrarse. <br>
     */
    private static final int BOTON_REGISTRARSE_Y = 182;
    /**
     * Bounds Width del botón registrarse. <br>
     */
    private static final int BOTON_REGISTRARSE_WIDTH = 153;
    /**
     * Bounds Height del botón registrarse. <br>
     */
    private static final int BOTON_REGISTRARSE_HEIGHT = 23;
    /**
     * Bounds X del textfield de password. <br>
     */
    private static final int TXT_PASSWORD_X = 199;
    /**
     * Bounds Y del textfield de password. <br>
     */
    private static final int TXT_PASSWORD_Y = 120;
    /**
     * Bounds Width del textfield de password. <br>
     */
    private static final int TXT_PASSWORD_WIDTH = 118;
    /**
     * Bounds Height del textfield de password. <br>
     */
    private static final int TXT_PASSWORD_HEIGHT = 20;
    /**
     * Bounds X del textfield de usuario. <br>
     */
    private static final int TXT_USUARIO_X = 199;
    /**
     * Bounds Y del textfield de usuario. <br>
     */
    private static final int TXT_USUARIO_Y = 69;
    /**
     * Bounds Width del textfield de usuario. <br>
     */
    private static final int TXT_USUARIO_WIDTH = 118;
    /**
     * Bounds Height del textfield de usuario. <br>
     */
    private static final int TXT_USUARIO_HEIGHT = 20;
    /**
     * Columnas del textfield de usuario. <br>
     */
    private static final int TXT_USUARIO_COLUMNAS = 10;
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
     * Crea un menú de registro de usuario. <br>
     *
     * @param cliente
     *            Cliente que lo invoca. <br>
     */
    public MenuRegistro(final Cliente cliente) {
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
                dispose();
            }
        });
        setTitle("WOME - Registrarse");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(PRINCIPAL_X, PRINCIPAL_Y, PRINCIPAL_WIDTH, PRINCIPAL_HEIGHT);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(PANE_X, PANE_Y, PANE_WIDTH, PANE_HEIGHT);
        getContentPane().add(layeredPane);
        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(USUARIO_X, USUARIO_Y, USUARIO_WIDTH,
                USUARIO_HEIGHT);
        layeredPane.add(lblUsuario, new Integer(1));
        lblUsuario.setForeground(Color.WHITE);
        lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, USUARIO_FONT));
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(PASSWORD_X, PASSWORD_Y, PASSWORD_WIDTH,
                PASSWORD_HEIGHT);
        layeredPane.add(lblPassword, new Integer(1));
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, PASSWORD_FONT));
        JLabel lblRegistrarse = new JLabel("Registrarse");
        lblRegistrarse.setBounds(REGISTRARSE_X, REGISTRARSE_Y,
                REGISTRARSE_WIDTH, REGISTRARSE_HEIGHT);
        layeredPane.add(lblRegistrarse, new Integer(2));
        lblRegistrarse.setForeground(Color.WHITE);
        lblRegistrarse
                .setFont(new Font("Tahoma", Font.PLAIN, REGISTRARSE_FONT));
        JButton btnRegistrarse = new JButton("");
        btnRegistrarse.setBounds(BOTON_REGISTRARSE_X, BOTON_REGISTRARSE_Y,
                BOTON_REGISTRARSE_WIDTH, BOTON_REGISTRARSE_HEIGHT);
        layeredPane.add(btnRegistrarse, new Integer(1));
        btnRegistrarse.setFocusable(false);
        btnRegistrarse.setIcon(new ImageIcon(
                MenuRegistro.class.getResource("/frames/BotonMenu.png")));
        pwPassword = new JPasswordField();
        pwPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                logIn(cliente);
                dispose();
            }
        });
        pwPassword.setBounds(TXT_PASSWORD_X, TXT_PASSWORD_Y, TXT_PASSWORD_WIDTH,
                TXT_PASSWORD_HEIGHT);
        layeredPane.add(pwPassword, new Integer(1));
        txtUsuario = new JTextField();
        txtUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                logIn(cliente);
                dispose();
            }
        });
        txtUsuario.setBounds(TXT_USUARIO_X, TXT_USUARIO_Y, TXT_USUARIO_WIDTH,
                TXT_USUARIO_HEIGHT);
        layeredPane.add(txtUsuario, new Integer(1));
        txtUsuario.setColumns(TXT_USUARIO_COLUMNAS);
        JLabel labelBackground = new JLabel("");
        labelBackground.setBounds(BACKGROUND_X, BACKGROUND_Y, BACKGROUND_WIDTH,
                BACKGROUND_HEIGHT);
        layeredPane.add(labelBackground, new Integer(0));
        labelBackground.setIcon(new ImageIcon(
                MenuRegistro.class.getResource("/frames/menuBackground.jpg")));
        btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                logIn(cliente);
                dispose();
            }
        });
    }

    /**
     * Obtiene el usuario del campo <i>usuario</i>. <br>
     *
     * @return Usuario. <br>
     */
    public final JTextField gettxtUsuario() {
        return txtUsuario;
    }

    /**
     * Establece el usuario al cliente. <br>
     *
     * @param textUsuario
     *            Usuario. <br>
     */
    public final void settxtUsuario(final JTextField textUsuario) {
        this.txtUsuario = textUsuario;
    }

    /**
     * Obtiene la contraseña del campo <i>contraseña</i>. <br>
     *
     * @return Contraseña. <br>
     */
    public final JPasswordField getPasswordField() {
        return pwPassword;
    }

    /**
     * Establece la contraseña al usuario del cliente. <br>
     *
     * @param password
     *            Contraseña. <br>
     */
    public final void setPasswordField(final JPasswordField password) {
        this.pwPassword = password;
    }

    /**
     * Loguea a un cliente. <br>
     *
     * @param cliente
     *            Cliente que se logea. <br>
     */
    private void logIn(final Cliente cliente) {
        synchronized (cliente) {
            cliente.getPaqueteUsuario().setUsername(txtUsuario.getText());
            cliente.getPaqueteUsuario()
                    .setPassword(String.valueOf(pwPassword.getPassword()));
            cliente.setAccion(Comando.REGISTRO);
            cliente.notify();
        }
    }
}
