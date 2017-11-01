package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import mensajeria.Comando;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLayeredPane;

/**
 * Clase que administra el menú de jugar. <br>
 */
@SuppressWarnings("serial")
public class MenuJugar extends JFrame {
    /**
     * Content pane. <br>
     */
    private JPanel contentPane;
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
     * Empty BorderPante del ContentPane. <br>
     */
    private static final int CONTENT_PANE_BORDER = 5;
    /**
     * Bounds X de registrarse. <br>
     */
    private static final int REGISTRARSE_X = 181;
    /**
     * Bounds Y de registrarse. <br>
     */
    private static final int REGISTRARSE_Y = 162;
    /**
     * Bounds Width de registrarse. <br>
     */
    private static final int REGISTRARSE_WIDTH = 82;
    /**
     * Bounds Height de registrarse. <br>
     */
    private static final int REGISTRARSE_HEIGHT = 23;
    /**
     * Font de registrarse. <br>
     */
    private static final int REGISTRARSE_FONT = 15;
    /**
     * Bounds X de iniciar sesión. <br>
     */
    private static final int SESION_X = 175;
    /**
     * Bounds Y de iniciar sesión. <br>
     */
    private static final int SESION_Y = 91;
    /**
     * Bounds Width de iniciar sesión. <br>
     */
    private static final int SESION_WIDTH = 91;
    /**
     * Bounds Height de iniciar sesión. <br>
     */
    private static final int SESION_HEIGHT = 23;
    /**
     * Font de iniciar sesión. <br>
     */
    private static final int SESION_FONT = 15;
    /**
     * Bounds X de botón de iniciar sesión. <br>
     */
    private static final int BOTON_SESION_X = 121;
    /**
     * Bounds Y de botón de iniciar sesión. <br>
     */
    private static final int BOTON_SESION_Y = 92;
    /**
     * Bounds Width de botón de iniciar sesión. <br>
     */
    private static final int BOTON_SESION_WIDTH = 191;
    /**
     * Bounds Height de botón de iniciar sesión. <br>
     */
    private static final int BOTON_SESION_HEIGHT = 23;
    /**
     * Bounds X del botón de registrarse. <br>
     */
    private static final int BOTON_REGISTRARSE_X = 121;
    /**
     * Bounds Y del botón de registrarse. <br>
     */
    private static final int BOTON_REGISTRARSE_Y = 162;
    /**
     * Bounds Width del botón de registrarse. <br>
     */
    private static final int BOTON_REGISTRARSE_WIDTH = 191;
    /**
     * Bounds Height del botón de registrarse. <br>
     */
    private static final int BOTON_REGISTRARSE_HEIGHT = 23;
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
     * Crea un menú de jugar. <br>
     *
     * @param cliente
     *            Cliente que lo invoca. <br>
     */
    public MenuJugar(final Cliente cliente) {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    MenuInicioSesion menuInicioSesion = new MenuInicioSesion(
                            cliente);
                    menuInicioSesion.setVisible(true);
                    dispose();
                }
            }
        });
        setIconImage(Toolkit.getDefaultToolkit()
                .getImage("src/main/java/frames/IconoWome.png"));
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon(MenuJugar.class.getResource("/cursor.png"))
                        .getImage(),
                new Point(0, 0), "custom cursor"));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // En caso de cerrar la ventana
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
        // Propiedades de la ventana
        setTitle("WOME - World Of the Middle Earth");
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
        // Boton Registrarse
        JLabel lblRegistrarse = new JLabel("Registrarse");
        lblRegistrarse.setBounds(REGISTRARSE_X, REGISTRARSE_Y,
                REGISTRARSE_WIDTH, REGISTRARSE_HEIGHT);
        layeredPane.add(lblRegistrarse, new Integer(2));
        lblRegistrarse.setForeground(Color.WHITE);
        lblRegistrarse.setEnabled(true);
        lblRegistrarse
                .setFont(new Font("Tahoma", Font.PLAIN, REGISTRARSE_FONT));
        lblRegistrarse.setBackground(Color.WHITE);
        // Boton Iniciar sesion
        JLabel lblIniciarSesion = new JLabel("Iniciar Sesion");
        lblIniciarSesion.setBounds(SESION_X, SESION_Y, SESION_WIDTH,
                SESION_HEIGHT);
        layeredPane.add(lblIniciarSesion, new Integer(2));
        lblIniciarSesion.setForeground(Color.WHITE);
        lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, SESION_FONT));
        JButton btnRegistrar = new JButton("Registrarse");
        btnRegistrar.setBounds(BOTON_REGISTRARSE_X, BOTON_REGISTRARSE_Y,
                BOTON_REGISTRARSE_WIDTH, BOTON_REGISTRARSE_HEIGHT);
        layeredPane.add(btnRegistrar, new Integer(1));
        btnRegistrar.setFocusable(false);
        btnRegistrar.setIcon(new ImageIcon(
                MenuJugar.class.getResource("/frames/BotonMenu.png")));
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                MenuRegistro menuRegistro = new MenuRegistro(cliente);
                menuRegistro.setVisible(true);
                dispose();
            }
        });
        JButton btnIniciarSesion = new JButton("Iniciar Sesion");
        btnIniciarSesion.setBounds(BOTON_SESION_X, BOTON_SESION_Y,
                BOTON_SESION_WIDTH, BOTON_SESION_HEIGHT);
        layeredPane.add(btnIniciarSesion, new Integer(1));
        btnIniciarSesion.setFocusable(false);
        btnIniciarSesion.setIcon(new ImageIcon(
                MenuJugar.class.getResource("/frames/BotonMenu.png")));
        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                MenuInicioSesion menuInicioSesion = new MenuInicioSesion(
                        cliente);
                menuInicioSesion.setVisible(true);
                dispose();
            }
        });
        JLabel lblBackground = new JLabel("");
        lblBackground.setBounds(BACKGROUND_X, BACKGROUND_Y, BACKGROUND_WIDTH,
                BACKGROUND_HEIGHT);
        lblBackground.setIcon(new ImageIcon(
                MenuJugar.class.getResource("/frames/menuBackground.jpg")));
        layeredPane.add(lblBackground, new Integer(0));
    }
}
