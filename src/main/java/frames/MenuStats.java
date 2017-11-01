package frames;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import cliente.Cliente;
import juego.Pantalla;
import mensajeria.PaquetePersonaje;

/**
 * Clase que administra el menú de stats del cliente. <br>
 */
@SuppressWarnings("serial")
public class MenuStats extends JFrame {
    /**
     * Content Pane. <br>
     */
    private JPanel contentPane;
    /**
     * Personaje del cliente. <br>
     */
    private PaquetePersonaje paquetePersonaje;
    /**
     * Modificador de atributos. <br>
     */
    private static final double MOD = 1.5;
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
    private static final int PRINCIPAL_WIDTH = 346;
    /**
     * Bounds Height principal. <br>
     */
    private static final int PRINCIPAL_HEIGHT = 321;
    /**
     * Bounds X del nombre. <br>
     */
    private static final int NOMBRE_X = 12;
    /**
     * Bounds Y del nombre. <br>
     */
    private static final int NOMBRE_Y = 13;
    /**
     * Bounds Width del nombre. <br>
     */
    private static final int NOMBRE_WIDTH = 56;
    /**
     * Bounds Height del nombre. <br>
     */
    private static final int NOMBRE_HEIGHT = 16;
    /**
     * Bounds X de la casta. <br>
     */
    private static final int CASTA_X = 12;
    /**
     * Bounds Y de la casta. <br>
     */
    private static final int CASTA_Y = 42;
    /**
     * Bounds Width de la casta. <br>
     */
    private static final int CASTA_WIDTH = 56;
    /**
     * Bounds Height de la casta. <br>
     */
    private static final int CASTA_HEIGHT = 16;
    /**
     * Bounds X de la raza. <br>
     */
    private static final int RAZA_X = 12;
    /**
     * Bounds Y de la raza. <br>
     */
    private static final int RAZA_Y = 71;
    /**
     * Bounds Width de la raza. <br>
     */
    private static final int RAZA_WIDTH = 56;
    /**
     * Bounds Height de la raza. <br>
     */
    private static final int RAZA_HEIGHT = 16;
    /**
     * Bounds X del nivel. <br>
     */
    private static final int NIVEL_X = 169;
    /**
     * Bounds Y del nivel. <br>
     */
    private static final int NIVEL_Y = 13;
    /**
     * Bounds Width del nivel. <br>
     */
    private static final int NIVEL_WIDTH = 56;
    /**
     * Bounds Height del nivel. <br>
     */
    private static final int NIVEL_HEIGHT = 16;
    /**
     * Bounds X de la experiencia. <br>
     */
    private static final int EXPERIENCIA_X = 169;
    /**
     * Bounds Y de la experiencia. <br>
     */
    private static final int EXPERIENCIA_Y = 42;
    /**
     * Bounds Width de la experiencia. <br>
     */
    private static final int EXPERIENCIA_WIDTH = 72;
    /**
     * Bounds Height de la experiencia. <br>
     */
    private static final int EXPERIENCIA_HEIGHT = 16;
    /**
     * Bounds X de la energía. <br>
     */
    private static final int ENERGIA_X = 169;
    /**
     * Bounds Y de la energía. <br>
     */
    private static final int ENERGIA_Y = 100;
    /**
     * Bounds Width de la energía. <br>
     */
    private static final int ENERGIA_WIDTH = 48;
    /**
     * Bounds Height de la energía. <br>
     */
    private static final int ENERGIA_HEIGHT = 16;
    /**
     * Bounds X de la salud. <br>
     */
    private static final int SALUD_X = 12;
    /**
     * Bounds Y de la salud. <br>
     */
    private static final int SALUD_Y = 100;
    /**
     * Bounds Width de la salud. <br>
     */
    private static final int SALUD_WIDTH = 56;
    /**
     * Bounds Height de la salud. <br>
     */
    private static final int SALUD_HEIGHT = 16;
    /**
     * Bounds X de la fuerza. <br>
     */
    private static final int FUERZA_X = 12;
    /**
     * Bounds Y de la fuerza. <br>
     */
    private static final int FUERZA_Y = 129;
    /**
     * Bounds Width de la fuerza. <br>
     */
    private static final int FUERZA_WIDTH = 48;
    /**
     * Bounds Height de la fuerza. <br>
     */
    private static final int FUERZA_HEIGHT = 16;
    /**
     * Bounds X de la destreza. <br>
     */
    private static final int DESTREZA_X = 12;
    /**
     * Bounds Y de la destreza. <br>
     */
    private static final int DESTREZA_Y = 158;
    /**
     * Bounds Width de la destreza. <br>
     */
    private static final int DESTREZA_WIDTH = 56;
    /**
     * Bounds Height de la destreza. <br>
     */
    private static final int DESTREZA_HEIGHT = 16;
    /**
     * Bounds X de la inteligencia. <br>
     */
    private static final int INTELIGENCIA_X = 12;
    /**
     * Bounds Y de la inteligencia. <br>
     */
    private static final int INTELIGENCIA_Y = 187;
    /**
     * Bounds Width de la inteligencia. <br>
     */
    private static final int INTELIGENCIA_WIDTH = 72;
    /**
     * Bounds Height de la inteligencia. <br>
     */
    private static final int INTELIGENCIA_HEIGHT = 16;
    /**
     * Bounds X del ataque. <br>
     */
    private static final int ATAQUE_X = 169;
    /**
     * Bounds Y del ataque. <br>
     */
    private static final int ATAQUE_Y = 129;
    /**
     * Bounds Width del ataque. <br>
     */
    private static final int ATAQUE_WIDTH = 48;
    /**
     * Bounds Height del ataque. <br>
     */
    private static final int ATAQUE_HEIGHT = 16;
    /**
     * Bounds X de la defensa. <br>
     */
    private static final int DEFENSA_X = 169;
    /**
     * Bounds Y de la defensa. <br>
     */
    private static final int DEFENSA_Y = 158;
    /**
     * Bounds Width de la defensa. <br>
     */
    private static final int DEFENSA_WIDTH = 56;
    /**
     * Bounds Height de la defensa. <br>
     */
    private static final int DEFENSA_HEIGHT = 16;
    /**
     * Bounds X de la magia. <br>
     */
    private static final int MAGIA_X = 169;
    /**
     * Bounds Y de la magia. <br>
     */
    private static final int MAGIA_Y = 187;
    /**
     * Bounds Width de la magia. <br>
     */
    private static final int MAGIA_WIDTH = 39;
    /**
     * Bounds Height de la magia. <br>
     */
    private static final int MAGIA_HEIGHT = 16;
    /**
     * Bounds X de la cantidad de items. <br>
     */
    private static final int ITEMS_X = 12;
    /**
     * Bounds Y de la cantidad de items. <br>
     */
    private static final int ITEMS_Y = 216;
    /**
     * Bounds Width de la cantidad de items. <br>
     */
    private static final int ITEMS_WIDTH = 110;
    /**
     * Bounds Height de la cantidad de items. <br>
     */
    private static final int ITEMS_HEIGHT = 16;
    /**
     * Bounds X del nombre del personaje. <br>
     */
    private static final int NOMBRE_PJ_X = 80;
    /**
     * Bounds Y del nombre del personaje. <br>
     */
    private static final int NOMBRE_PJ_Y = 13;
    /**
     * Bounds Width del nombre del personaje. <br>
     */
    private static final int NOMBRE_PJ_WIDTH = 77;
    /**
     * Bounds Height del nombre del personaje. <br>
     */
    private static final int NOMBRE_PJ_HEIGHT = 16;
    /**
     * Bounds X de la casta del personaje. <br>
     */
    private static final int CASTA_PJ_X = 80;
    /**
     * Bounds Y de la casta del personaje. <br>
     */
    private static final int CASTA_PJ_Y = 42;
    /**
     * Bounds Width de la casta del personaje. <br>
     */
    private static final int CASTA_PJ_WIDTH = 77;
    /**
     * Bounds Height de la casta del personaje. <br>
     */
    private static final int CASTA_PJ_HEIGHT = 16;
    /**
     * Bounds X de la raza del personaje. <br>
     */
    private static final int RAZA_PJ_X = 80;
    /**
     * Bounds Y de la raza del personaje. <br>
     */
    private static final int RAZA_PJ_Y = 71;
    /**
     * Bounds Width de la raza del personaje. <br>
     */
    private static final int RAZA_PJ_WIDTH = 77;
    /**
     * Bounds Height de la raza del personaje. <br>
     */
    private static final int RAZA_PJ_HEIGHT = 16;
    /**
     * Bounds X de la salud del personaje. <br>
     */
    private static final int SALUD_PJ_X = 80;
    /**
     * Bounds Y de la salud del personaje. <br>
     */
    private static final int SALUD_PJ_Y = 100;
    /**
     * Bounds Width de la salud del personaje. <br>
     */
    private static final int SALUD_PJ_WIDTH = 77;
    /**
     * Bounds Height de la salud del personaje. <br>
     */
    private static final int SALUD_PJ_HEIGHT = 16;
    /**
     * Bounds X de la fuerza del personaje. <br>
     */
    private static final int FUERZA_PJ_X = 80;
    /**
     * Bounds Y de la fuerza del personaje. <br>
     */
    private static final int FUERZA_PJ_Y = 129;
    /**
     * Bounds Width de la fuerza del personaje. <br>
     */
    private static final int FUERZA_PJ_WIDTH = 77;
    /**
     * Bounds Height de la fuerza del personaje. <br>
     */
    private static final int FUERZA_PJ_HEIGHT = 16;
    /**
     * Bounds X de la destreza del personaje. <br>
     */
    private static final int DESTREZA_PJ_X = 80;
    /**
     * Bounds Y de la destreza del personaje. <br>
     */
    private static final int DESTREZA_PJ_Y = 158;
    /**
     * Bounds Width de la destreza del personaje. <br>
     */
    private static final int DESTREZA_PJ_WIDTH = 77;
    /**
     * Bounds Height de la destreza del personaje. <br>
     */
    private static final int DESTREZA_PJ_HEIGHT = 16;
    /**
     * Bounds X de la inteligencia del personaje. <br>
     */
    private static final int INTELIGENCIA_PJ_X = 80;
    /**
     * Bounds Y de la inteligencia del personaje. <br>
     */
    private static final int INTELIGENCIA_PJ_Y = 187;
    /**
     * Bounds Width de la inteligencia del personaje. <br>
     */
    private static final int INTELIGENCIA_PJ_WIDTH = 77;
    /**
     * Bounds Height de la inteligencia del personaje. <br>
     */
    private static final int INTELIGENCIA_PJ_HEIGHT = 16;
    /**
     * Bounds X de los items del personaje. <br>
     */
    private static final int ITEMS_PJ_X = 118;
    /**
     * Bounds Y de los items del personaje. <br>
     */
    private static final int ITEMS_PJ_Y = 216;
    /**
     * Bounds Width de los items del personaje. <br>
     */
    private static final int ITEMS_PJ_WIDTH = 39;
    /**
     * Bounds Height de los items del personaje. <br>
     */
    private static final int ITEMS_PJ_HEIGHT = 16;
    /**
     * Bounds X del nivel del personaje. <br>
     */
    private static final int NIVEL_PJ_X = 251;
    /**
     * Bounds Y del nivel del personaje. <br>
     */
    private static final int NIVEL_PJ_Y = 13;
    /**
     * Bounds Width del nivel del personaje. <br>
     */
    private static final int NIVEL_PJ_WIDTH = 77;
    /**
     * Bounds Height del nivel del personaje. <br>
     */
    private static final int NIVEL_PJ_HEIGHT = 16;
    /**
     * Bounds X de la experiencia del personaje. <br>
     */
    private static final int EXPERIENCIA_PJ_X = 251;
    /**
     * Bounds Y de la experiencia del personaje. <br>
     */
    private static final int EXPERIENCIA_PJ_Y = 42;
    /**
     * Bounds Width de la experiencia del personaje. <br>
     */
    private static final int EXPERIENCIA_PJ_WIDTH = 77;
    /**
     * Bounds Height de la experiencia del personaje. <br>
     */
    private static final int EXPERIENCIA_PJ_HEIGHT = 16;
    /**
     * Bounds X de la energía del personaje. <br>
     */
    private static final int ENERGIA_PJ_X = 251;
    /**
     * Bounds Y de la energía del personaje. <br>
     */
    private static final int ENERGIA_PJ_Y = 100;
    /**
     * Bounds Width de la energía del personaje. <br>
     */
    private static final int ENERGIA_PJ_WIDTH = 77;
    /**
     * Bounds Height de la energía del personaje. <br>
     */
    private static final int ENERGIA_PJ_HEIGHT = 16;
    /**
     * Bounds X del ataque del personaje. <br>
     */
    private static final int ATAQUE_PJ_X = 251;
    /**
     * Bounds Y del ataque del personaje. <br>
     */
    private static final int ATAQUE_PJ_Y = 129;
    /**
     * Bounds Width del ataque del personaje. <br>
     */
    private static final int ATAQUE_PJ_WIDTH = 77;
    /**
     * Bounds Height del ataque del personaje. <br>
     */
    private static final int ATAQUE_PJ_HEIGHT = 16;
    /**
     * Bounds X de la defensa del personaje. <br>
     */
    private static final int DEFENSA_PJ_X = 251;
    /**
     * Bounds Y de la defensa del personaje. <br>
     */
    private static final int DEFENSA_PJ_Y = 158;
    /**
     * Bounds Width de la defensa del personaje. <br>
     */
    private static final int DEFENSA_PJ_WIDTH = 77;
    /**
     * Bounds Height de la defensa del personaje. <br>
     */
    private static final int DEFENSA_PJ_HEIGHT = 16;
    /**
     * Bounds X de la magia del personaje. <br>
     */
    private static final int MAGIA_PJ_X = 251;
    /**
     * Bounds Y de la magia del personaje. <br>
     */
    private static final int MAGIA_PJ_Y = 187;
    /**
     * Bounds Width de la magia del personaje. <br>
     */
    private static final int MAGIA_PJ_WIDTH = 77;
    /**
     * Bounds Height de la magia del personaje. <br>
     */
    private static final int MAGIA_PJ_HEIGHT = 16;
    /**
     * Bounds X del botón volver. <br>
     */
    private static final int VOLVER_X = 128;
    /**
     * Bounds Y del botón volver. <br>
     */
    private static final int VOLVER_Y = 245;
    /**
     * Bounds Width del botón volver. <br>
     */
    private static final int VOLVER_WIDTH = 97;
    /**
     * Bounds Height del botón volver. <br>
     */
    private static final int VOLVER_HEIGHT = 25;
    /**
     * Bounds Width del fondo. <br>
     */
    private static final int FONDO_WIDTH = 400;
    /**
     * Bounds Height del fondo. <br>
     */
    private static final int FONDO_HEIGHT = 350;
    /**
     * Bounds X del background. <br>
     */
    private static final int BACKGROUND_X = -12;
    /**
     * Bounds Y del background. <br>
     */
    private static final int BACKGROUND_Y = -11;
    /**
     * Bounds Width del background. <br>
     */
    private static final int BACKGROUND_WIDTH = 363;
    /**
     * Bounds Height del background. <br>
     */
    private static final int BACKGROUND_HEIGHT = 312;

    /**
     * Crea el frame. <br>
     *
     * @param cliente
     *            Cliene que lo crea. <br>
     */
    public MenuStats(final Cliente cliente) {
        paquetePersonaje = cliente.getPaquetePersonaje();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(PRINCIPAL_X, PRINCIPAL_Y, PRINCIPAL_WIDTH,
                PRINCIPAL_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("Estadísticas");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(CONTENT_PANE_BORDER,
                CONTENT_PANE_BORDER, CONTENT_PANE_BORDER, CONTENT_PANE_BORDER));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                Pantalla.menuStats = null;
                dispose();
            }
        });
        BufferedImage imagenFondo = null;
        try {
            imagenFondo = ImageIO.read(new File("recursos//background.jpg"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el fondo");
        }
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setBounds(NOMBRE_X, NOMBRE_Y, NOMBRE_WIDTH, NOMBRE_HEIGHT);
        contentPane.add(lblNombre);
        JLabel lblCasta = new JLabel("Casta");
        lblCasta.setForeground(Color.WHITE);
        lblCasta.setBounds(CASTA_X, CASTA_Y, CASTA_WIDTH, CASTA_HEIGHT);
        contentPane.add(lblCasta);
        JLabel lblRaza = new JLabel("Raza");
        lblRaza.setForeground(Color.WHITE);
        lblRaza.setBounds(RAZA_X, RAZA_Y, RAZA_WIDTH, RAZA_HEIGHT);
        contentPane.add(lblRaza);
        JLabel lblNivel = new JLabel("Nivel");
        lblNivel.setForeground(Color.WHITE);
        lblNivel.setBounds(NIVEL_X, NIVEL_Y, NIVEL_WIDTH, NIVEL_HEIGHT);
        contentPane.add(lblNivel);
        JLabel lblExperiencia = new JLabel("Experiencia");
        lblExperiencia.setForeground(Color.WHITE);
        lblExperiencia.setBounds(EXPERIENCIA_X, EXPERIENCIA_Y,
                EXPERIENCIA_WIDTH, EXPERIENCIA_HEIGHT);
        contentPane.add(lblExperiencia);
        JLabel lblEnergia = new JLabel("Energia");
        lblEnergia.setForeground(Color.WHITE);
        lblEnergia.setBounds(ENERGIA_X, ENERGIA_Y, ENERGIA_WIDTH,
                ENERGIA_HEIGHT);
        contentPane.add(lblEnergia);
        JLabel lblSalud = new JLabel("Salud");
        lblSalud.setForeground(Color.WHITE);
        lblSalud.setBounds(SALUD_X, SALUD_Y, SALUD_WIDTH, SALUD_HEIGHT);
        contentPane.add(lblSalud);
        JLabel lblFuerza = new JLabel("Fuerza");
        lblFuerza.setForeground(Color.WHITE);
        lblFuerza.setBounds(FUERZA_X, FUERZA_Y, FUERZA_WIDTH, FUERZA_HEIGHT);
        contentPane.add(lblFuerza);
        JLabel lblDestreza = new JLabel("Destreza");
        lblDestreza.setForeground(Color.WHITE);
        lblDestreza.setBounds(DESTREZA_X, DESTREZA_Y, DESTREZA_WIDTH,
                DESTREZA_HEIGHT);
        contentPane.add(lblDestreza);
        JLabel lblInteligencia = new JLabel("Inteligencia");
        lblInteligencia.setForeground(Color.WHITE);
        lblInteligencia.setBounds(INTELIGENCIA_X, INTELIGENCIA_Y,
                INTELIGENCIA_WIDTH, INTELIGENCIA_HEIGHT);
        contentPane.add(lblInteligencia);
        JLabel lblAtaque = new JLabel("Ataque");
        lblAtaque.setForeground(Color.WHITE);
        lblAtaque.setBounds(ATAQUE_X, ATAQUE_Y, ATAQUE_WIDTH, ATAQUE_HEIGHT);
        contentPane.add(lblAtaque);
        JLabel lblDefensa = new JLabel("Defensa");
        lblDefensa.setForeground(Color.WHITE);
        lblDefensa.setBounds(DEFENSA_X, DEFENSA_Y, DEFENSA_WIDTH,
                DEFENSA_HEIGHT);
        contentPane.add(lblDefensa);
        JLabel lblMagia = new JLabel("Magia");
        lblMagia.setForeground(Color.WHITE);
        lblMagia.setBounds(MAGIA_X, MAGIA_Y, MAGIA_WIDTH, MAGIA_HEIGHT);
        contentPane.add(lblMagia);
        JLabel lblCantidadDeItems = new JLabel("Cantidad de Items");
        lblCantidadDeItems.setForeground(Color.WHITE);
        lblCantidadDeItems.setBounds(ITEMS_X, ITEMS_Y, ITEMS_WIDTH,
                ITEMS_HEIGHT);
        contentPane.add(lblCantidadDeItems);
        JLabel nmbPj = new JLabel(paquetePersonaje.getNombre());
        nmbPj.setForeground(Color.WHITE);
        nmbPj.setHorizontalAlignment(SwingConstants.RIGHT);
        nmbPj.setBounds(NOMBRE_PJ_X, NOMBRE_PJ_Y, NOMBRE_PJ_WIDTH,
                NOMBRE_PJ_HEIGHT);
        contentPane.add(nmbPj);
        JLabel cstPj = new JLabel(paquetePersonaje.getCasta());
        cstPj.setForeground(Color.WHITE);
        cstPj.setHorizontalAlignment(SwingConstants.RIGHT);
        cstPj.setBounds(CASTA_PJ_X, CASTA_PJ_Y, CASTA_PJ_WIDTH,
                CASTA_PJ_HEIGHT);
        contentPane.add(cstPj);
        JLabel rzPj = new JLabel(paquetePersonaje.getRaza());
        rzPj.setForeground(Color.WHITE);
        rzPj.setHorizontalAlignment(SwingConstants.RIGHT);
        rzPj.setBounds(RAZA_PJ_X, RAZA_PJ_Y, RAZA_PJ_WIDTH, RAZA_PJ_HEIGHT);
        contentPane.add(rzPj);
        JLabel saludPj = new JLabel(
                String.valueOf(paquetePersonaje.getSaludTope()));
        saludPj.setForeground(Color.WHITE);
        saludPj.setHorizontalAlignment(SwingConstants.RIGHT);
        saludPj.setBounds(SALUD_PJ_X, SALUD_PJ_Y, SALUD_PJ_WIDTH,
                SALUD_PJ_HEIGHT);
        contentPane.add(saludPj);
        JLabel fzaPj = new JLabel(String.valueOf(paquetePersonaje.getFuerza()));
        fzaPj.setForeground(Color.WHITE);
        fzaPj.setHorizontalAlignment(SwingConstants.RIGHT);
        fzaPj.setBounds(FUERZA_PJ_X, FUERZA_PJ_Y, FUERZA_PJ_WIDTH,
                FUERZA_PJ_HEIGHT);
        contentPane.add(fzaPj);
        JLabel dstzaPj = new JLabel(
                String.valueOf(paquetePersonaje.getDestreza()));
        dstzaPj.setForeground(Color.WHITE);
        dstzaPj.setHorizontalAlignment(SwingConstants.RIGHT);
        dstzaPj.setBounds(DESTREZA_PJ_X, DESTREZA_PJ_Y, DESTREZA_PJ_WIDTH,
                DESTREZA_PJ_HEIGHT);
        contentPane.add(dstzaPj);
        JLabel intPj = new JLabel(
                String.valueOf(paquetePersonaje.getInteligencia()));
        intPj.setForeground(Color.WHITE);
        intPj.setHorizontalAlignment(SwingConstants.RIGHT);
        intPj.setBounds(INTELIGENCIA_PJ_X, INTELIGENCIA_PJ_Y,
                INTELIGENCIA_PJ_WIDTH, INTELIGENCIA_PJ_HEIGHT);
        contentPane.add(intPj);
        JLabel cantItem = new JLabel(
                String.valueOf(paquetePersonaje.getCantItems()));
        cantItem.setForeground(Color.WHITE);
        cantItem.setHorizontalAlignment(SwingConstants.RIGHT);
        cantItem.setBounds(ITEMS_PJ_X, ITEMS_PJ_Y, ITEMS_PJ_WIDTH,
                ITEMS_PJ_HEIGHT);
        contentPane.add(cantItem);
        JLabel lvPj = new JLabel(String.valueOf(paquetePersonaje.getNivel()));
        lvPj.setForeground(Color.WHITE);
        lvPj.setHorizontalAlignment(SwingConstants.RIGHT);
        lvPj.setBounds(NIVEL_PJ_X, NIVEL_PJ_Y, NIVEL_PJ_WIDTH, NIVEL_PJ_HEIGHT);
        contentPane.add(lvPj);
        JLabel xpPj = new JLabel(
                String.valueOf(paquetePersonaje.getExperiencia()));
        xpPj.setForeground(Color.WHITE);
        xpPj.setHorizontalAlignment(SwingConstants.RIGHT);
        xpPj.setBounds(EXPERIENCIA_PJ_X, EXPERIENCIA_PJ_Y, EXPERIENCIA_PJ_WIDTH,
                EXPERIENCIA_PJ_HEIGHT);
        contentPane.add(xpPj);
        JLabel energiaPj = new JLabel(
                String.valueOf(paquetePersonaje.getEnergiaTope()));
        energiaPj.setForeground(Color.WHITE);
        energiaPj.setHorizontalAlignment(SwingConstants.RIGHT);
        energiaPj.setBounds(ENERGIA_PJ_X, ENERGIA_PJ_Y, ENERGIA_PJ_WIDTH,
                ENERGIA_PJ_HEIGHT);
        contentPane.add(energiaPj);
        int ataquePj = calcularAtaque(paquetePersonaje.getFuerza());
        JLabel ataPj = new JLabel(String.valueOf(ataquePj));
        ataPj.setForeground(Color.WHITE);
        ataPj.setHorizontalAlignment(SwingConstants.RIGHT);
        ataPj.setBounds(ATAQUE_PJ_X, ATAQUE_PJ_Y, ATAQUE_PJ_WIDTH,
                ATAQUE_PJ_HEIGHT);
        contentPane.add(ataPj);
        JLabel defPj = new JLabel(
                String.valueOf(paquetePersonaje.getDestreza()));
        defPj.setForeground(Color.WHITE);
        defPj.setHorizontalAlignment(SwingConstants.RIGHT);
        defPj.setBounds(DEFENSA_PJ_X, DEFENSA_PJ_Y, DEFENSA_PJ_WIDTH,
                DEFENSA_PJ_HEIGHT);
        contentPane.add(defPj);
        int intePj = calcularMagia(paquetePersonaje.getInteligencia());
        JLabel magicPj = new JLabel(String.valueOf(intePj));
        magicPj.setForeground(Color.WHITE);
        magicPj.setHorizontalAlignment(SwingConstants.RIGHT);
        magicPj.setBounds(MAGIA_PJ_X, MAGIA_PJ_Y, MAGIA_PJ_WIDTH,
                MAGIA_PJ_HEIGHT);
        contentPane.add(magicPj);
        JButton btnVolver = new JButton("Volver");
        btnVolver.setIcon(new ImageIcon("recursos//volver.png"));
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                Pantalla.menuStats = null;
                dispose();
            }
        });
        btnVolver.setBounds(VOLVER_X, VOLVER_Y, VOLVER_WIDTH, VOLVER_HEIGHT);
        contentPane.add(btnVolver);
        JLabel background = new JLabel(
                new ImageIcon(imagenFondo.getScaledInstance(FONDO_WIDTH,
                        FONDO_HEIGHT, Image.SCALE_DEFAULT)));
        background.setBounds(BACKGROUND_X, BACKGROUND_Y, BACKGROUND_WIDTH,
                BACKGROUND_HEIGHT);
        contentPane.add(background);
    }

    /**
     * Calcula la magia del personaje a partir de su inteligencia. <br>
     *
     * @param inteligencia
     *            Inteligencia del personaje. <br>
     * @return Magia del personaje. <br>
     */
    private int calcularMagia(final int inteligencia) {
        return (int) (inteligencia * MOD);
    }

    /**
     * Calcula el ataque del personaje a partir de su fuerza. <br>
     *
     * @param fuerza
     *            Fuerza del personaje. <br>
     * @return Ataque del personaje. <br>
     */
    private int calcularAtaque(final int fuerza) {
        return (int) (fuerza * MOD);
    }
}
