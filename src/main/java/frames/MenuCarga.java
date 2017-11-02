package frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import mensajeria.Comando;

import javax.swing.ImageIcon;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase que administra el menú de carga.
 */
public class MenuCarga extends JFrame {
    /** Constante ANCHO_BARRA. */
    private static final int ANCHO_BARRA = 27;

    /** Constante HEIGHT_BOUND. */
    private static final int HEIGHT_BOUND = 3;

    /** Constante EMPTY_BORDER. */
    private static final int EMPTY_BORDER = 5;

    /** Constante BOUNDS1. */
    private static final int[] BOUNDS1 = {100, 100, 450, 300};

    /** Constante BARRA_CARGANDO. */
    private static final int[] BARRA_CARGANDO = {52, 160, 0, 27};

    /** Constante LBL_BARRA_CARGA. */
    private static final int[] LBL_BARRA_CARGA = {47, 154, 355, 40};

    /** Constante LBL_LOGO. */
    private static final int[] LBL_LOGO = {109, 39, 216, 90};

    /** Constante LBL_BACKGROUND. */
    private static final int[] LBL_BACKGROUND = {0, 0, 444, 271};

    /** Atributo content pane. */
    private JPanel contentPane;

    /** Atributo barra cargando. */
    private JLabel barraCargando;

    /**
     * Instancia menu carga. <br>
     *
     * @param cliente
     *            cliente. <br>
     */
    public MenuCarga(final Cliente cliente) {
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
        setBounds(BOUNDS1[0], BOUNDS1[1], BOUNDS1[2], BOUNDS1[HEIGHT_BOUND]);
        setLocationRelativeTo(null);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(EMPTY_BORDER, EMPTY_BORDER,
                EMPTY_BORDER, EMPTY_BORDER));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        barraCargando = new JLabel("");
        barraCargando.setIcon(new ImageIcon(
                MenuCarga.class.getResource("/frames/Barra.png")));
        barraCargando.setBounds(BARRA_CARGANDO[0], BARRA_CARGANDO[1],
                BARRA_CARGANDO[2], BARRA_CARGANDO[HEIGHT_BOUND]);
        contentPane.add(barraCargando);

        JLabel lblBarraCarga = new JLabel("");
        lblBarraCarga.setIcon(new ImageIcon(
                MenuCarga.class.getResource("/frames/BarraCarga.png")));
        lblBarraCarga.setBounds(LBL_BARRA_CARGA[0], LBL_BARRA_CARGA[1],
                LBL_BARRA_CARGA[2], LBL_BARRA_CARGA[HEIGHT_BOUND]);
        contentPane.add(lblBarraCarga);

        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(
                new ImageIcon(MenuCarga.class.getResource("/frames/WOME.png")));
        lblLogo.setBounds(LBL_LOGO[0], LBL_LOGO[1], LBL_LOGO[2],
                LBL_LOGO[HEIGHT_BOUND]);
        contentPane.add(lblLogo);

        JLabel lblBackground = new JLabel("");
        lblBackground.setBounds(LBL_BACKGROUND[0], LBL_BACKGROUND[1],
                LBL_BACKGROUND[2], LBL_BACKGROUND[HEIGHT_BOUND]);
        contentPane.add(lblBackground);
        lblBackground.setIcon(new ImageIcon(
                MenuCarga.class.getResource("/frames/menuBackground.jpg")));
    }

    /**
     * Sets barra cargando. <br>
     *
     * @param ancho
     *            Valor de barra cargando <br>
     */
    public final void setBarraCargando(final int ancho) {
        barraCargando.setSize(ancho, ANCHO_BARRA);
    }
}
