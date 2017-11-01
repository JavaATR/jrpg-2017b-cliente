package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Clase que administra el menú de inicio. <br>
 */
@SuppressWarnings("serial")
public class MenuInicio extends JFrame {
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
     * Empty BorderPante del ContentPane. <br>
     */
    private static final int CONTENT_PANE_BORDER = 5;
    /**
     * Bounds X del logo. <br>
     */
    private static final int LOGO_X = 109;
    /**
     * Bounds Y del logo. <br>
     */
    private static final int LOGO_Y = 39;
    /**
     * Bounds Width del logo. <br>
     */
    private static final int LOGO_WIDTH = 216;
    /**
     * Bounds Height del logo. <br>
     */
    private static final int LOGO_HEIGHT = 90;
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
     * Bounds X de jugar. <br>
     */
    private static final int JUGAR_X = 205;
    /**
     * Bounds Y de jugar. <br>
     */
    private static final int JUGAR_Y = 162;
    /**
     * Bounds Width de jugar. <br>
     */
    private static final int JUGAR_WIDTH = 82;
    /**
     * Bounds Height de jugar. <br>
     */
    private static final int JUGAR_HEIGHT = 23;
    /**
     * Font de jugar. <br>
     */
    private static final int JUGAR_FONT = 15;
    /**
     * Bounds X de salir. <br>
     */
    private static final int SALIR_X = 210;
    /**
     * Bounds Y de salir. <br>
     */
    private static final int SALIR_Y = 202;
    /**
     * Bounds Width de salir. <br>
     */
    private static final int SALIR_WIDTH = 91;
    /**
     * Bounds Height de salir. <br>
     */
    private static final int SALIR_HEIGHT = 23;
    /**
     * Font de salir. <br>
     */
    private static final int SALIR_FONT = 15;
    /**
     * Bounds X del botón jugar. <br>
     */
    private static final int BOTON_JUGAR_X = 127;
    /**
     * Bounds Y del botón jugar. <br>
     */
    private static final int BOTON_JUGAR_Y = 162;
    /**
     * Bounds Width del botón jugar. <br>
     */
    private static final int BOTON_JUGAR_WIDTH = 191;
    /**
     * Bounds Height del botón jugar. <br>
     */
    private static final int BOTON_JUGAR_HEIGHT = 23;
    /**
     * Bounds X del botón salir. <br>
     */
    private static final int BOTON_SALIR_X = 127;
    /**
     * Bounds Y del botón salir. <br>
     */
    private static final int BOTON_SALIR_Y = 202;
    /**
     * Bounds Width del botón salir. <br>
     */
    private static final int BOTON_SALIR_WIDTH = 191;
    /**
     * Bounds Height del botón salir. <br>
     */
    private static final int BOTON_SALIR_HEIGHT = 23;
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
     * Crea el menú de inicio. <br>
     */
    public MenuInicio() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Cliente cliente = new Cliente();
                    cliente.start();
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
        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(
                new ImageIcon(MenuCarga.class.getResource("/frames/WOME.png")));
        lblLogo.setBounds(LOGO_X, LOGO_Y, LOGO_WIDTH, LOGO_HEIGHT);
        contentPane.add(lblLogo);
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(JPANE_X, JPANE_Y, JPANE_WIDTH, JPANE_HEIGHT);
        contentPane.add(layeredPane);
        // Boton Jugar
        JLabel lblRegistrarse = new JLabel("Jugar");
        lblRegistrarse.setBounds(JUGAR_X, JUGAR_Y, JUGAR_WIDTH, JUGAR_HEIGHT);
        layeredPane.add(lblRegistrarse, new Integer(2));
        lblRegistrarse.setForeground(Color.WHITE);
        lblRegistrarse.setEnabled(true);
        lblRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, JUGAR_FONT));
        lblRegistrarse.setBackground(Color.WHITE);
        // Boton Salir
        JLabel lblIniciarSesion = new JLabel("Salir");
        lblIniciarSesion.setBounds(SALIR_X, SALIR_Y, SALIR_WIDTH, SALIR_HEIGHT);
        layeredPane.add(lblIniciarSesion, new Integer(2));
        lblIniciarSesion.setForeground(Color.WHITE);
        lblIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, SALIR_FONT));
        JButton btnRegistrar = new JButton("Jugar");
        btnRegistrar.setBounds(BOTON_JUGAR_X, BOTON_JUGAR_Y, BOTON_JUGAR_WIDTH,
                BOTON_JUGAR_HEIGHT);
        layeredPane.add(btnRegistrar, new Integer(1));
        btnRegistrar.setFocusable(false);
        btnRegistrar.setIcon(new ImageIcon(
                MenuJugar.class.getResource("/frames/BotonMenu.png")));
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                Cliente cliente = new Cliente();
                cliente.start();
                dispose();
            }
        });
        JButton btnIniciarSesion = new JButton("Salir");
        btnIniciarSesion.setBounds(BOTON_SALIR_X, BOTON_SALIR_Y,
                BOTON_SALIR_WIDTH, BOTON_SALIR_HEIGHT);
        layeredPane.add(btnIniciarSesion, new Integer(1));
        btnIniciarSesion.setFocusable(false);
        btnIniciarSesion.setIcon(new ImageIcon(
                MenuJugar.class.getResource("/frames/BotonMenu.png")));
        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
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

    /**
     * Vuelve visible el menú de inicio. <br>
     *
     * @param args
     *            Argumentos. <br>
     */
    public static void main(final String[] args) {
        new MenuInicio().setVisible(true);
    }
}
