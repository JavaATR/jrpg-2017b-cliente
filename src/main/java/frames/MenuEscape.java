package frames;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import cliente.Cliente;
import estados.Estado;
import juego.Pantalla;
import mensajeria.Comando;
import mensajeria.Paquete;

/**
 * Clase MenuEscape.
 */
public class MenuEscape extends JFrame {

    /** Constante HEIGHT_BOUND. */
    private static final int HEIGHT_BOUND = 3;

    /** Constante FONDO_HEIGHT. */
    private static final int FONDO_HEIGHT = 350;

    /** Constante FONDO_WIDTH. */
    private static final int FONDO_WIDTH = 200;

    /** Constante EMPTY_BORDER. */
    private static final int EMPTY_BORDER = 5;
    /** Constante BOUNDS1. */
    private static final int[] BOUNDS1 = {100, 100, 180, 270};

    /** Constante STATS_BOUNDS. */
    private static final int[] STATS_BOUNDS = {29, 13, 125, 25};

    /** Constante SKILLS_BOUNDS. */
    private static final int[] SKILLS_BOUNDS = {29, 66, 125, 25};

    /** Constante INVENT_BOUNDS. */
    private static final int[] INVENT_BOUNDS = {29, 121, 125, 25};

    /** Constante DESCONECT_BOUNDS. */
    private static final int[] DESCONECT_BOUNDS = {29, 175, 125, 25};

    /** Constante VOLVER_BOUNDS. */
    private static final int[] VOLVER_BOUNDS = {29, 227, 125, 25};

    /** Constante BACKGROUND_BOUNDS. */
    private static final int[] BACKGROUND_BOUNDS = {0, 0, 186, 273};

    /** Atributo content pane. */
    private JPanel contentPane;

    /** Atributo gson. */
    private final Gson gson = new Gson();

    /**
     * Create the frame. <br>
     *
     * @param cliente
     *            Valor del cliente. <br>
     */
    public MenuEscape(final Cliente cliente) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setBounds(BOUNDS1[0], BOUNDS1[1], BOUNDS1[2],
                BOUNDS1[HEIGHT_BOUND]);
        this.setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(EMPTY_BORDER, EMPTY_BORDER,
                EMPTY_BORDER, EMPTY_BORDER));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton verStats = new JButton("Estadísticas");
        verStats.setIcon(new ImageIcon("recursos//stats.png"));
        verStats.setToolTipText("Presiona S para ver estadísticas");
        verStats.setBounds(STATS_BOUNDS[0], STATS_BOUNDS[1], STATS_BOUNDS[2],
                STATS_BOUNDS[HEIGHT_BOUND]);
        verStats.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                dispose();
                Pantalla.menuEscp = null;
                if (Pantalla.menuStats == null) {
                    Pantalla.menuStats = new MenuStats(cliente);
                    Pantalla.menuStats.setVisible(true);
                }
            }
        });
        contentPane.add(verStats);

        JButton asignarSkills = new JButton("Asignar Skills");
        asignarSkills.setIcon(new ImageIcon("recursos//asignar skills.png"));
        asignarSkills.setToolTipText("Presiona A para asignar skills");
        asignarSkills.setBounds(SKILLS_BOUNDS[0], SKILLS_BOUNDS[1],
                SKILLS_BOUNDS[2], SKILLS_BOUNDS[HEIGHT_BOUND]);
        asignarSkills.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                dispose();
                Pantalla.menuEscp = null;
                if (Pantalla.menuAsignar == null) {
                    Pantalla.menuAsignar = new MenuAsignarSkills(cliente);
                    Pantalla.menuAsignar.setVisible(true);
                }
                Pantalla.menuAsignar = null;
            }
        });
        contentPane.add(asignarSkills);

        JButton inventario = new JButton("Inventario");
        inventario.setIcon(new ImageIcon("recursos//inventario.png"));
        inventario.setToolTipText("Presiona I para abrir inventario");
        inventario.setBounds(INVENT_BOUNDS[0], INVENT_BOUNDS[1],
                INVENT_BOUNDS[2], INVENT_BOUNDS[HEIGHT_BOUND]);
        inventario.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                dispose();
                Pantalla.menuEscp = null;
                if (Estado.getEstado().esEstadoDeJuego()) {
                    if (Pantalla.menuInventario == null) {
                        Pantalla.menuInventario = new MenuInventario(cliente);
                        Pantalla.menuInventario.setVisible(true);
                    }
                }
            }
        });
        contentPane.add(inventario);

        JButton desconectarse = new JButton("Desconectarse");
        desconectarse.setBounds(DESCONECT_BOUNDS[0], DESCONECT_BOUNDS[1],
                DESCONECT_BOUNDS[2], DESCONECT_BOUNDS[HEIGHT_BOUND]);
        desconectarse.setIcon(new ImageIcon("recursos//desconectarse.png"));
        desconectarse.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try {
                    Paquete p = new Paquete();
                    p.setComando(Comando.DESCONECTAR);
                    p.setIp(cliente.getMiIp());
                    cliente.getSalida().writeObject(gson.toJson(p));
                    cliente.getEntrada().close();
                    cliente.getSalida().close();
                    cliente.getSocket().close();
                    System.exit(0);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Error al desconectar");

                }
            }
        });
        contentPane.add(desconectarse);

        JButton volver = new JButton("Volver");
        volver.setIcon(new ImageIcon("recursos//volver.png"));
        volver.setBounds(VOLVER_BOUNDS[0], VOLVER_BOUNDS[1], VOLVER_BOUNDS[2],
                VOLVER_BOUNDS[HEIGHT_BOUND]);
        volver.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                Pantalla.menuEscp = null;
                dispose();
            }
        });
        contentPane.add(volver);

        BufferedImage imagenFondo = null;
        try {
            imagenFondo = ImageIO.read(new File("recursos//fondo2.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el fondo");

        }
        JLabel background = new JLabel(
                new ImageIcon(imagenFondo.getScaledInstance(FONDO_WIDTH,
                        FONDO_HEIGHT, Image.SCALE_DEFAULT)));
        background.setBounds(BACKGROUND_BOUNDS[0], BACKGROUND_BOUNDS[1],
                BACKGROUND_BOUNDS[2], BACKGROUND_BOUNDS[HEIGHT_BOUND]);
        contentPane.add(background);
    }
}
