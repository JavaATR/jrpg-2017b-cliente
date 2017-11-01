package frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import cliente.Cliente;
import mensajeria.Comando;
import mensajeria.PaquetePersonaje;

/**
 * Clase MenuCreacionPj.
 */
public class MenuCreacionPj extends JFrame {

    /** Constante COLUMNAS. */
    private static final int COLUMNAS = 10;

    /** Constante FONT_SIZE_15. */
    private static final int FONT_SIZE_15 = 15;

    /** Constante FONT_SIZE_13. */
    private static final int FONT_SIZE_13 = 13;

    /** Constante EMPTY_BORDER. */
    private static final int EMPTY_BORDER = 5;
    /** Constante BOUNDS1. */
    private static final int[] BOUNDS1 = {100, 100, 450, 300};

    /** Constante LAYERED_PANE_BOUNDS. */
    private static final int[] LAYERED_PANE_BOUNDS = {0, 0, 444, 271};

    /** Constante NEW_LABEL_5_BOUNDS. */
    private static final int[] NEW_LABEL_5_BOUNDS = {33, 100, 46, 14};

    /** Constante FUERZA_BOUNDS. */
    private static final int[] FUERZA_BOUNDS = {110, 102, 22, 14};

    /** Constante LBL_DESTREZA_BOUNDS. */
    private static final int[] LBL_DESTREZA_BOUNDS = {33, 126, 60, 14};

    /** Constante DESTREZA_BOUNDS. */
    private static final int[] DESTREZA_BOUNDS = {110, 127, 22, 14};

    /** Constante LBL_INTEL_BOUNDS. */
    private static final int[] LBL_INTEL_BOUNDS = {33, 151, 66, 22};

    /** Constante INTEL_BOUNDS. */
    private static final int[] INTEL_BOUNDS = {110, 156, 22, 14};

    /** Constante LBL_SALUD_BOUNDS. */
    private static final int[] LBL_SALUD_BOUNDS = {33, 183, 46, 14};

    /** Constante SALUD_BOUNDS. */
    private static final int[] SALUD_BOUNDS = {110, 183, 22, 14};

    /** Constante LBL_ENERGIA_BOUNDS. */
    private static final int[] LBL_ENERGIA_BOUNDS = {33, 204, 46, 20};

    /** Constante ENERGIA_BOUNDS. */
    private static final int[] ENERGIA_BOUNDS = {110, 208, 22, 14};

    /** Constante NEW_LABEL_4_BOUNDS. */
    private static final int[] NEW_LABEL_4_BOUNDS = {207, 125, 60, 14};

    /** Constante NOMBRE_BOUNDS. */
    private static final int[] NOMBRE_BOUNDS = {277, 122, 122, 20};

    /** Constante LBL_ACEPTAR_BOUNDS. */
    private static final int[] LBL_ACEPTAR_BOUNDS = {280, 173, 50, 24};

    /** Constante BTN_ACEPTAR_BOUNDS. */
    private static final int[] BTN_ACEPTAR_BOUNDS = {230, 174, 153, 23};

    /** Constante NEW_LABEL_BOUNDS. */
    private static final int[] NEW_LABEL_BOUNDS = {33, 23, 46, 14};

    /** Constante LBL_CASTA_BOUNDS. */
    private static final int[] LBL_CASTA_BOUNDS = {161, 23, 46, 14};

    /** Constante CHECK_CASTA_BOUNDS. */
    private static final int[] CHECK_CASTA_BOUNDS = {161, 48, 76, 20};

    /** Constante CHECK_RAZA_BOUNDS. */
    private static final int[] CHECK_RAZA_BOUNDS = {32, 48, 76, 20};

    /** Constante LBL_BACK_BOUNDS. */
    private static final int[] LBL_BACK_BOUNDS = {0, 0, 444, 271};

    /** Constante HEIGHT_BOUND. */
    private static final int HEIGHT_BOUND = 3;

    /** Atributo content pane. */
    private JPanel contentPane;

    /** Atributo nombre. */
    private JTextField nombre;

    /** Atributo destreza. */
    private JLabel destreza;

    /** Atributo fuerza. */
    private JLabel fuerza;

    /** Atributo inteligencia. */
    private JLabel inteligencia;

    /** Atributo salud. */
    private JLabel salud;

    /** Atributo energia. */
    private JLabel energia;

    /** Atributo cbx casta. */
    private JComboBox<String> cbxCasta;

    /** Atributo cbx raza. */
    private JComboBox<String> cbxRaza;

    /**
     * Constructor menu creacion pj. <br>
     *
     * @param cliente
     *            cliente.
     * @param personaje
     *            personaje.
     * @param gson
     *            gson. <br>
     */
    public MenuCreacionPj(final Cliente cliente,
            final PaquetePersonaje personaje, final Gson gson) {
        setIconImage(Toolkit.getDefaultToolkit()
                .getImage("src/main/java/frames/IconoWome.png"));
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon(MenuJugar.class.getResource("/cursor.png"))
                        .getImage(),
                new Point(0, 0), "custom cursor"));

        final String[] vecSalud = {"55", "50", "60"};
        final String[] vecEnergia = {"55", "60", "50"};
        final String[] vecFuerza = {"15", "10", "10"};
        final String[] vecDestreza = {"10", "10", "15"};
        final String[] vecInteligencia = {"10", "15", "10"};

        // En caso de cerrar
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                personaje.setNombre(nombre.getText());
                if (nombre.getText().equals(""))
                    personaje.setNombre("nameless");
                personaje.setRaza((String) cbxRaza.getSelectedItem());
                personaje.setSaludTope(
                        Integer.parseInt(vecSalud[cbxRaza.getSelectedIndex()]));
                personaje.setEnergiaTope(Integer
                        .parseInt(vecEnergia[cbxRaza.getSelectedIndex()]));
                personaje.setCasta((String) cbxCasta.getSelectedItem());
                personaje.setFuerza(Integer
                        .parseInt(vecFuerza[cbxCasta.getSelectedIndex()]));
                personaje.setDestreza(Integer
                        .parseInt(vecDestreza[cbxCasta.getSelectedIndex()]));
                personaje.setInteligencia(Integer.parseInt(
                        vecInteligencia[cbxCasta.getSelectedIndex()]));
                synchronized (cliente) {
                    cliente.notify();
                }
                dispose();
            }
        });

        setTitle("WOME - Crear personaje");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBounds(BOUNDS1[0], BOUNDS1[1], BOUNDS1[2], BOUNDS1[HEIGHT_BOUND]);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(EMPTY_BORDER, EMPTY_BORDER,
                EMPTY_BORDER, EMPTY_BORDER));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(LAYERED_PANE_BOUNDS[0], LAYERED_PANE_BOUNDS[1],
                LAYERED_PANE_BOUNDS[2], LAYERED_PANE_BOUNDS[HEIGHT_BOUND]);
        contentPane.add(layeredPane);

        JLabel lblNewLabel5 = new JLabel("Fuerza");
        lblNewLabel5.setBounds(NEW_LABEL_5_BOUNDS[0], NEW_LABEL_5_BOUNDS[1],
                NEW_LABEL_5_BOUNDS[2], NEW_LABEL_5_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(lblNewLabel5, new Integer(1));
        lblNewLabel5.setForeground(Color.WHITE);
        lblNewLabel5.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_13));

        fuerza = new JLabel("15");
        fuerza.setBounds(FUERZA_BOUNDS[0], FUERZA_BOUNDS[1], FUERZA_BOUNDS[2],
                FUERZA_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(fuerza, new Integer(1));
        fuerza.setForeground(Color.GREEN);

        JLabel lblDestreza = new JLabel("Destreza");
        lblDestreza.setBounds(LBL_DESTREZA_BOUNDS[0], LBL_DESTREZA_BOUNDS[1],
                LBL_DESTREZA_BOUNDS[2], LBL_DESTREZA_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(lblDestreza, new Integer(1));
        lblDestreza.setForeground(Color.WHITE);
        lblDestreza.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_13));

        destreza = new JLabel("10");
        destreza.setBounds(DESTREZA_BOUNDS[0], DESTREZA_BOUNDS[1],
                DESTREZA_BOUNDS[2], DESTREZA_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(destreza, new Integer(1));
        destreza.setForeground(Color.GREEN);

        JLabel lblInteligencia = new JLabel("Inteligencia");
        lblInteligencia.setBounds(LBL_INTEL_BOUNDS[0], LBL_INTEL_BOUNDS[1],
                LBL_INTEL_BOUNDS[2], LBL_INTEL_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(lblInteligencia, new Integer(1));
        lblInteligencia.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_13));
        lblInteligencia.setForeground(Color.WHITE);

        inteligencia = new JLabel("10");
        inteligencia.setBounds(INTEL_BOUNDS[0], INTEL_BOUNDS[1],
                INTEL_BOUNDS[2], INTEL_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(inteligencia, new Integer(1));
        inteligencia.setForeground(Color.GREEN);

        JLabel lblSalud = new JLabel("Salud");
        lblSalud.setBounds(LBL_SALUD_BOUNDS[0], LBL_SALUD_BOUNDS[1],
                LBL_SALUD_BOUNDS[2], LBL_SALUD_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(lblSalud, new Integer(1));
        lblSalud.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_13));
        lblSalud.setForeground(Color.WHITE);

        salud = new JLabel("55");
        salud.setBounds(SALUD_BOUNDS[0], SALUD_BOUNDS[1], SALUD_BOUNDS[2],
                SALUD_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(salud, new Integer(1));
        salud.setForeground(Color.GREEN);

        JLabel lblEnergia = new JLabel("Energia");
        lblEnergia.setBounds(LBL_ENERGIA_BOUNDS[0], LBL_ENERGIA_BOUNDS[1],
                LBL_ENERGIA_BOUNDS[2], LBL_ENERGIA_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(lblEnergia, new Integer(1));
        lblEnergia.setForeground(Color.WHITE);
        lblEnergia.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_13));

        energia = new JLabel("55");
        energia.setBounds(ENERGIA_BOUNDS[0], ENERGIA_BOUNDS[1],
                ENERGIA_BOUNDS[2], ENERGIA_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(energia, new Integer(1));
        energia.setForeground(Color.GREEN);

        JLabel lblNewLabel4 = new JLabel("Nombre");
        lblNewLabel4.setBounds(NEW_LABEL_4_BOUNDS[0], NEW_LABEL_4_BOUNDS[1],
                NEW_LABEL_4_BOUNDS[2], NEW_LABEL_4_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(lblNewLabel4, new Integer(1));
        lblNewLabel4.setForeground(Color.WHITE);
        lblNewLabel4.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_15));

        nombre = new JTextField();
        nombre.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                crearPj(cliente, personaje, gson, vecSalud, vecEnergia,
                        vecFuerza, vecDestreza, vecInteligencia);
            }
        });
        nombre.setBounds(NOMBRE_BOUNDS[0], NOMBRE_BOUNDS[1], NOMBRE_BOUNDS[2],
                NOMBRE_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(nombre, new Integer(1));
        nombre.setColumns(COLUMNAS);

        JLabel lblAceptar = new JLabel("Aceptar");
        lblAceptar.setBounds(LBL_ACEPTAR_BOUNDS[0], LBL_ACEPTAR_BOUNDS[1],
                LBL_ACEPTAR_BOUNDS[2], LBL_ACEPTAR_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(lblAceptar, new Integer(2));
        lblAceptar.setForeground(Color.WHITE);
        lblAceptar.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_15));

        // En caso de apretar el boton aceptar
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.setBounds(BTN_ACEPTAR_BOUNDS[0], BTN_ACEPTAR_BOUNDS[1],
                BTN_ACEPTAR_BOUNDS[2], BTN_ACEPTAR_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(btnAceptar, new Integer(1));
        btnAceptar.setFocusable(false);
        btnAceptar.setIcon(new ImageIcon(
                MenuCreacionPj.class.getResource("/frames/BotonMenu.png")));

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                crearPj(cliente, personaje, gson, vecSalud, vecEnergia,
                        vecFuerza, vecDestreza, vecInteligencia);

            }

        });

        JLabel lblNewLabel = new JLabel("Raza");
        lblNewLabel.setBounds(NEW_LABEL_BOUNDS[0], NEW_LABEL_BOUNDS[1],
                NEW_LABEL_BOUNDS[2], NEW_LABEL_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(lblNewLabel, new Integer(1));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_15));

        JLabel lblCasta = new JLabel("Casta");
        lblCasta.setBounds(LBL_CASTA_BOUNDS[0], LBL_CASTA_BOUNDS[1],
                LBL_CASTA_BOUNDS[2], LBL_CASTA_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(lblCasta, new Integer(1));
        lblCasta.setForeground(Color.WHITE);
        lblCasta.setFont(new Font("Tahoma", Font.PLAIN, FONT_SIZE_15));

        cbxCasta = new JComboBox<>();
        cbxCasta.setBounds(CHECK_CASTA_BOUNDS[0], CHECK_CASTA_BOUNDS[1],
                CHECK_CASTA_BOUNDS[2], CHECK_CASTA_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(cbxCasta, new Integer(1));
        cbxCasta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                fuerza.setText(vecFuerza[cbxCasta.getSelectedIndex()]);
                destreza.setText(vecDestreza[cbxCasta.getSelectedIndex()]);
                inteligencia
                        .setText(vecInteligencia[cbxCasta.getSelectedIndex()]);
            }
        });
        cbxCasta.addItem("Guerrero");
        cbxCasta.addItem("Hechicero");
        cbxCasta.addItem("Asesino");

        cbxRaza = new JComboBox<>();
        cbxRaza.setBounds(CHECK_RAZA_BOUNDS[0], CHECK_RAZA_BOUNDS[1],
                CHECK_RAZA_BOUNDS[2], CHECK_RAZA_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(cbxRaza, new Integer(1));
        cbxRaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                salud.setText(vecSalud[cbxRaza.getSelectedIndex()]);
                energia.setText(vecEnergia[cbxRaza.getSelectedIndex()]);
            }
        });
        cbxRaza.addItem("Humano");
        cbxRaza.addItem("Elfo");
        cbxRaza.addItem("Orco");

        JLabel lblBackground = new JLabel("");
        lblBackground.setBounds(LBL_BACK_BOUNDS[0], LBL_BACK_BOUNDS[1],
                LBL_BACK_BOUNDS[2], LBL_BACK_BOUNDS[HEIGHT_BOUND]);
        layeredPane.add(lblBackground, new Integer(0));
        lblBackground.setIcon(new ImageIcon(MenuCreacionPj.class
                .getResource("/frames/menuBackground.jpg")));
    }

    /**
     * Crear pj. <br>
     *
     * @param cliente
     *            cliente.
     * @param personaje
     *            personaje.
     * @param gson
     *            gson.
     * @param vecSalud
     *            vec salud.
     * @param vecEnergia
     *            vec energia.
     * @param vecFuerza
     *            vec fuerza.
     * @param vecDestreza
     *            vec destreza.
     * @param vecInteligencia
     *            vec inteligencia. <br>
     */
    protected void crearPj(final Cliente cliente,
            final PaquetePersonaje personaje, final Gson gson,
            final String[] vecSalud, final String[] vecEnergia,
            final String[] vecFuerza, final String[] vecDestreza,
            final String[] vecInteligencia) {

        personaje.setNombre(nombre.getText());
        if (nombre.getText().equals(""))
            personaje.setNombre("nameless");
        personaje.setRaza((String) cbxRaza.getSelectedItem());
        personaje.setSaludTope(
                Integer.parseInt(vecSalud[cbxRaza.getSelectedIndex()]));
        personaje.setEnergiaTope(
                Integer.parseInt(vecEnergia[cbxRaza.getSelectedIndex()]));
        personaje.setCasta((String) cbxCasta.getSelectedItem());
        personaje.setFuerza(
                Integer.parseInt(vecFuerza[cbxCasta.getSelectedIndex()]));
        personaje.setDestreza(
                Integer.parseInt(vecDestreza[cbxCasta.getSelectedIndex()]));
        personaje.setInteligencia(
                Integer.parseInt(vecInteligencia[cbxCasta.getSelectedIndex()]));
        try {

            // Le envio los datos al servidor
            cliente.getPaquetePersonaje().setComando(Comando.CREACIONPJ);
            cliente.getSalida()
                    .writeObject(gson.toJson(cliente.getPaquetePersonaje()));
            dispose();
        } catch (JsonSyntaxException | IOException esd) {
            JOptionPane.showMessageDialog(null, "Error al crear personaje");

        }
    }

}
