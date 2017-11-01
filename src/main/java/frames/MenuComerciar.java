package frames;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import cliente.Cliente;
import dominio.Item;
import mensajeria.Comando;

/**
 * Clase MenuComerciar.
 */
public class MenuComerciar extends JFrame {
    /** Constante size. */
    private static final int SIZE = 9;
    /** Constante HEIGHT_BOUND. */
    private static final int HEIGHT_BOUND = 3;
    /** Constante EMPTY_BORDER. */
    private static final int EMPTY_BORDER = 5;
    /** Constante BOUNDS1. */
    private static final int[] BOUNDS1 = {100, 100, 610, 363};

    /** Constante BTN_CANCELAR. */
    private static final int[] BTN_CANCELAR = {276, 245, 97, 25};

    /** Constante BTN_AGREGAR. */
    private static final int[] BTN_AGREGAR = {181, 93, 51, 25};

    /** Constante BTN_SACAR. */
    private static final int[] BTN_SACAR = {181, 131, 51, 25};

    /** Constante LIST_MIS_ITEMS. */
    private static final int[] LIST_MIS_ITEMS = {12, 42, 157, 162};

    /** Constante LIST_A_DAR. */
    private static final int[] LIST_A_DAR = {244, 42, 157, 162};

    /** Constante LIST_A_OBTENER. */
    private static final int[] LIST_A_OBTENER = {428, 42, 157, 162};

    /** Constante LBL_MIS_ITEMS. */
    private static final int[] LBL_MIS_ITEMS = {12, 13, 157, 16};

    /** Constante LBL_ITEMS_A_INTERC. */
    private static final int[] LBL_ITEMS_A_INTERC = {244, 13, 157, 16};

    /** Constante LBL_ITEMS_A_OBTENER. */
    private static final int[] LBL_ITEMS_A_OBTENER = {428, 13, 157, 16};

    /** Constante LBL_SALUD. */
    private static final int[] LBL_SALUD = {12, 217, 56, 16};

    /** Constante LBL_ENERGIA. */
    private static final int[] LBL_ENERGIA = {12, 240, 56, 16};

    /** Constante LBL_FUERZA. */
    private static final int[] LBL_FUERZA = {113, 217, 56, 16};

    /** Constante LBL_DESTREZA. */
    private static final int[] LBL_DESTREZA = {113, 240, 56, 16};

    /** Constante LBL_INTELIGENCIA. */
    private static final int[] LBL_INTELIGENCIA = {12, 263, 71, 16};

    /** Constante LBL_SALUD_ENEMY. */
    private static final int[] LBL_SALUD_ENEMY = {387, 217, 56, 16};

    /** Constante LBL_ENERGIA_ENEMY. */
    private static final int[] LBL_ENERGIA_ENEMY = {387, 240, 56, 16};

    /** Constante LBL_FZA_ENEMY. */
    private static final int[] LBL_FZA_ENEMY = {497, 217, 56, 16};

    /** Constante LBL_DES_ENEMY. */
    private static final int[] LBL_DES_ENEMY = {497, 240, 56, 16};

    /** Constante LBL_INT_ENEMY. */
    private static final int[] LBL_INT_ENEMY = {387, 263, 71, 16};

    /** Constante LBL_LISTO. */
    private static final int[] LBL_LISTO = {276, 279, 56, 16};

    /** Constante BONUS_SALUD. */
    private static final int[] BONUS_SALUD = {51, 217, 56, 16};

    /** Constante BONUS_ENERGIA. */
    private static final int[] BONUS_ENERGIA = {51, 240, 56, 16};

    /** Constante BONUS_FUERZA. */
    private static final int[] BONUS_FUERZA = {176, 217, 56, 16};

    /** Constante BONUS_DES. */
    private static final int[] BONUS_DES = {176, 240, 56, 16};

    /** Constante BONUS_INT. */
    private static final int[] BONUS_INT = {51, 263, 56, 16};

    /** Constante SALUD_ENEMY. */
    private static final int[] SALUD_ENEMY = {428, 217, 56, 16};

    /** Constante ENERGY_ENEMY. */
    private static final int[] ENERGY_ENEMY = {428, 240, 56, 16};

    /** Constante FZA_ENEMY. */
    private static final int[] FZA_ENEMY = {536, 217, 56, 16};

    /** Constante DES_ENEMY. */
    private static final int[] DES_ENEMY = {536, 240, 56, 16};

    /** Constante INT_ENEMY. */
    private static final int[] INT_ENEMY = {428, 263, 56, 16};

    /** Constante LEYENDA. */
    private static final int[] LEYENDA = {12, 299, 282, 16};

    /** Constante CANT_LISTO. */
    private static final int[] CANT_LISTO = {317, 278, 56, 16};

    /** Constante CHECK_LISTO. */
    private static final int[] CHECK_LISTO = {289, 213, 71, 25};

    /** Constante BACKGROUND. */
    private static final int[] BACKGROUND = {-12, 0, 628, 336};

    /** Atributo content pane. */
    private JPanel contentPane;

    /** Atributo mis items. */
    private DefaultListModel<String> misItems = new DefaultListModel<String>();

    /** Atributo dar. */
    private DefaultListModel<String> dar = new DefaultListModel<String>();

    /** Atributo obtener. */
    private DefaultListModel<String> obtener = new DefaultListModel<String>();

    /** Atributo cant listos. */
    private int cantListos = 0;

    /** Atributo cant listo. */
    private JLabel cantListo;

    /** Atributo item 1. */
    private Item item1;

    /** Atributo count. */
    private int count = 0;

    /** Atributo gson. */
    private final Gson gson = new Gson();

    /** Atributo size items. */
    private int sizeItems;

    /** Atributo chckbx listo. */
    private JCheckBox chckbxListo;

    /** Atributo leyenda. */
    private JLabel leyenda;

    /**
     * Instancia menu comerciar. <br>
     *
     * @param cliente
     *            cliente. <br>
     */
    public MenuComerciar(final Cliente cliente) {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(BOUNDS1[0], BOUNDS1[1], BOUNDS1[2],
                BOUNDS1[HEIGHT_BOUND]);
        this.setLocationRelativeTo(null);
        this.setTitle("Comercio");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(EMPTY_BORDER, EMPTY_BORDER,
                EMPTY_BORDER, EMPTY_BORDER));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cliente.setM1(null);
                dispose();
            }
        });

        BufferedImage imagenFondo = null;
        try {
            imagenFondo = ImageIO.read(new File("recursos//background.jpg"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se pudo cargar el fondo");

        }

        final JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setIcon(new ImageIcon("recursos//volver.png"));
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                cliente.setM1(null);
                dispose();
            }
        });
        btnCancelar.setBounds(BTN_CANCELAR[0], BTN_CANCELAR[1], BTN_CANCELAR[2],
                BTN_CANCELAR[HEIGHT_BOUND]);
        contentPane.add(btnCancelar);

        final JList<String> listMisItems = new JList<String>();
        listMisItems.setBounds(LIST_MIS_ITEMS[0], LIST_MIS_ITEMS[1],
                LIST_MIS_ITEMS[2], LIST_MIS_ITEMS[HEIGHT_BOUND]);
        contentPane.add(listMisItems);

        final JList<String> listADar = new JList<String>();
        listADar.setBounds(LIST_A_DAR[0], LIST_A_DAR[1], LIST_A_DAR[2],
                LIST_A_DAR[HEIGHT_BOUND]);
        contentPane.add(listADar);

        final JList<String> listAObtener = new JList<String>();
        listAObtener.setBounds(LIST_A_OBTENER[0], LIST_A_OBTENER[1],
                LIST_A_OBTENER[2], LIST_A_OBTENER[HEIGHT_BOUND]);
        contentPane.add(listAObtener);

        final JLabel lblMisItems = new JLabel("Mis Items");
        lblMisItems.setForeground(Color.WHITE);
        lblMisItems.setHorizontalAlignment(SwingConstants.CENTER);
        lblMisItems.setBounds(LBL_MIS_ITEMS[0], LBL_MIS_ITEMS[1],
                LBL_MIS_ITEMS[2], LBL_MIS_ITEMS[HEIGHT_BOUND]);
        contentPane.add(lblMisItems);

        final JLabel lblItemsAIntercambiar = new JLabel("Items a Dar");
        lblItemsAIntercambiar.setForeground(Color.WHITE);
        lblItemsAIntercambiar.setHorizontalAlignment(SwingConstants.CENTER);
        lblItemsAIntercambiar.setBounds(LBL_ITEMS_A_INTERC[0],
                LBL_ITEMS_A_INTERC[1], LBL_ITEMS_A_INTERC[2],
                LBL_ITEMS_A_INTERC[HEIGHT_BOUND]);
        contentPane.add(lblItemsAIntercambiar);

        final JLabel lblItemsAObtener = new JLabel("Items a Obtener");
        lblItemsAObtener.setForeground(Color.WHITE);
        lblItemsAObtener.setHorizontalAlignment(SwingConstants.CENTER);
        lblItemsAObtener.setBounds(LBL_ITEMS_A_OBTENER[0],
                LBL_ITEMS_A_OBTENER[1], LBL_ITEMS_A_OBTENER[2],
                LBL_ITEMS_A_OBTENER[HEIGHT_BOUND]);
        contentPane.add(lblItemsAObtener);

        final JLabel lblSalud = new JLabel("Salud");
        lblSalud.setForeground(Color.WHITE);
        lblSalud.setBounds(LBL_SALUD[0], LBL_SALUD[1], LBL_SALUD[2],
                LBL_SALUD[HEIGHT_BOUND]);
        contentPane.add(lblSalud);

        final JLabel lblEnerga = new JLabel("Energía");
        lblEnerga.setForeground(Color.WHITE);
        lblEnerga.setBounds(LBL_ENERGIA[0], LBL_ENERGIA[1], LBL_ENERGIA[2],
                LBL_ENERGIA[HEIGHT_BOUND]);
        contentPane.add(lblEnerga);

        final JLabel lblFuerza = new JLabel("Fuerza");
        lblFuerza.setForeground(Color.WHITE);
        lblFuerza.setBounds(LBL_FUERZA[0], LBL_FUERZA[1], LBL_FUERZA[2],
                LBL_FUERZA[HEIGHT_BOUND]);
        contentPane.add(lblFuerza);

        final JLabel lblDestreza = new JLabel("Destreza");
        lblDestreza.setForeground(Color.WHITE);
        lblDestreza.setBounds(LBL_DESTREZA[0], LBL_DESTREZA[1], LBL_DESTREZA[2],
                LBL_DESTREZA[HEIGHT_BOUND]);
        contentPane.add(lblDestreza);

        final JLabel lblInteligencia = new JLabel("Inteligencia");
        lblInteligencia.setForeground(Color.WHITE);
        lblInteligencia.setBounds(LBL_INTELIGENCIA[0], LBL_INTELIGENCIA[1],
                LBL_INTELIGENCIA[2], LBL_INTELIGENCIA[HEIGHT_BOUND]);
        contentPane.add(lblInteligencia);

        final JLabel lblSaludEnemy = new JLabel("Salud");
        lblSaludEnemy.setForeground(Color.WHITE);
        lblSaludEnemy.setBounds(LBL_SALUD_ENEMY[0], LBL_SALUD_ENEMY[1],
                LBL_SALUD_ENEMY[2], LBL_SALUD_ENEMY[HEIGHT_BOUND]);
        contentPane.add(lblSaludEnemy);

        final JLabel lblEnergiaEnemy = new JLabel("Energía");
        lblEnergiaEnemy.setForeground(Color.WHITE);
        lblEnergiaEnemy.setBounds(LBL_ENERGIA_ENEMY[0], LBL_ENERGIA_ENEMY[1],
                LBL_ENERGIA_ENEMY[2], LBL_ENERGIA_ENEMY[HEIGHT_BOUND]);
        contentPane.add(lblEnergiaEnemy);

        final JLabel lblFzaEnemy = new JLabel("Fuerza");
        lblFzaEnemy.setForeground(Color.WHITE);
        lblFzaEnemy.setBounds(LBL_FZA_ENEMY[0], LBL_FZA_ENEMY[1],
                LBL_FZA_ENEMY[2], LBL_FZA_ENEMY[HEIGHT_BOUND]);
        contentPane.add(lblFzaEnemy);

        final JLabel lblDesEnemy = new JLabel("Destreza");
        lblDesEnemy.setForeground(Color.WHITE);
        lblDesEnemy.setBounds(LBL_DES_ENEMY[0], LBL_DES_ENEMY[1],
                LBL_DES_ENEMY[2], LBL_DES_ENEMY[HEIGHT_BOUND]);
        contentPane.add(lblDesEnemy);

        final JLabel lblIntEnemy = new JLabel("Inteligencia");
        lblIntEnemy.setForeground(Color.WHITE);
        lblIntEnemy.setBounds(LBL_INT_ENEMY[0], LBL_INT_ENEMY[1],
                LBL_INT_ENEMY[2], LBL_INT_ENEMY[HEIGHT_BOUND]);
        contentPane.add(lblIntEnemy);

        final JLabel lblListo = new JLabel("Listo");
        lblListo.setForeground(Color.WHITE);
        lblListo.setBounds(LBL_LISTO[0], LBL_LISTO[1], LBL_LISTO[2],
                LBL_LISTO[HEIGHT_BOUND]);
        contentPane.add(lblListo);

        final JLabel bonusSalud = new JLabel("");
        bonusSalud.setForeground(Color.WHITE);
        bonusSalud.setHorizontalAlignment(SwingConstants.RIGHT);
        bonusSalud.setBounds(BONUS_SALUD[0], BONUS_SALUD[1], BONUS_SALUD[2],
                BONUS_SALUD[HEIGHT_BOUND]);
        contentPane.add(bonusSalud);

        final JLabel bonusEnergia = new JLabel("");
        bonusEnergia.setForeground(Color.WHITE);
        bonusEnergia.setHorizontalAlignment(SwingConstants.RIGHT);
        bonusEnergia.setBounds(BONUS_ENERGIA[0], BONUS_ENERGIA[1],
                BONUS_ENERGIA[2], BONUS_ENERGIA[HEIGHT_BOUND]);
        contentPane.add(bonusEnergia);

        final JLabel bonusFuerza = new JLabel("");
        bonusFuerza.setForeground(Color.WHITE);
        bonusFuerza.setHorizontalAlignment(SwingConstants.RIGHT);
        bonusFuerza.setBounds(BONUS_FUERZA[0], BONUS_FUERZA[1], BONUS_FUERZA[2],
                BONUS_FUERZA[HEIGHT_BOUND]);
        contentPane.add(bonusFuerza);

        final JLabel bonusDes = new JLabel("");
        bonusDes.setForeground(Color.WHITE);
        bonusDes.setHorizontalAlignment(SwingConstants.RIGHT);
        bonusDes.setBounds(BONUS_DES[0], BONUS_DES[1], BONUS_DES[2],
                BONUS_DES[HEIGHT_BOUND]);
        contentPane.add(bonusDes);

        final JLabel bonusInt = new JLabel("");
        bonusInt.setForeground(Color.WHITE);
        bonusInt.setHorizontalAlignment(SwingConstants.RIGHT);
        bonusInt.setBounds(BONUS_INT[0], BONUS_INT[1], BONUS_INT[2],
                BONUS_INT[HEIGHT_BOUND]);
        contentPane.add(bonusInt);

        final JLabel saludEnemy = new JLabel("");
        saludEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
        saludEnemy.setForeground(Color.WHITE);
        saludEnemy.setBounds(SALUD_ENEMY[0], SALUD_ENEMY[1], SALUD_ENEMY[2],
                SALUD_ENEMY[HEIGHT_BOUND]);
        contentPane.add(saludEnemy);

        final JLabel energyEnemy = new JLabel("");
        energyEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
        energyEnemy.setForeground(Color.WHITE);
        energyEnemy.setBounds(ENERGY_ENEMY[0], ENERGY_ENEMY[1], ENERGY_ENEMY[2],
                ENERGY_ENEMY[HEIGHT_BOUND]);
        contentPane.add(energyEnemy);

        final JLabel fzaEnemy = new JLabel("");
        fzaEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
        fzaEnemy.setForeground(Color.WHITE);
        fzaEnemy.setBounds(FZA_ENEMY[0], FZA_ENEMY[1], FZA_ENEMY[2],
                FZA_ENEMY[HEIGHT_BOUND]);
        contentPane.add(fzaEnemy);

        final JLabel desEnemy = new JLabel("");
        desEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
        desEnemy.setForeground(Color.WHITE);
        desEnemy.setBounds(DES_ENEMY[0], DES_ENEMY[1], DES_ENEMY[2],
                DES_ENEMY[HEIGHT_BOUND]);
        contentPane.add(desEnemy);

        final JLabel intEnemy = new JLabel("");
        intEnemy.setHorizontalAlignment(SwingConstants.RIGHT);
        intEnemy.setForeground(Color.WHITE);
        intEnemy.setBounds(INT_ENEMY[0], INT_ENEMY[1], INT_ENEMY[2],
                INT_ENEMY[HEIGHT_BOUND]);
        contentPane.add(intEnemy);

        chckbxListo = new JCheckBox("Listo");
        chckbxListo.setForeground(Color.WHITE);
        chckbxListo.setBackground(Color.BLACK);
        // Arranca deshabilitada
        chckbxListo.setEnabled(false);

        leyenda = new JLabel("Recuerda que la máxima cantidad de items es 9");
        leyenda.setForeground(Color.WHITE);
        leyenda.setBounds(LEYENDA[0], LEYENDA[1], LEYENDA[2],
                LEYENDA[HEIGHT_BOUND]);
        contentPane.add(leyenda);
        leyenda.setVisible(false);

        final JButton btnAgregar = new JButton("-->");
        btnAgregar.setIcon(new ImageIcon("recursos//flechaDer.png"));
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                if (listMisItems.getSelectedValue() != null) {
                    dar.addElement(listMisItems.getSelectedValue());
                    if (obtener.size() != 0) {
                        if (sizeItems - dar.size() + obtener.size() <= SIZE) {
                            chckbxListo.setEnabled(true);
                            leyenda.setVisible(false);
                        }
                    }
                    // Pongo el primer item y pregunto si es igual al
                    // seleccionado
                    // Entonces mientras que sean distinto lo busca
                    // Cuando sea igual sale del while y lo agrega en la lista
                    item1 = cliente.getPaquetePersonaje().getItems().get(count);
                    while (!item1.getNombre()
                            .equals(listMisItems.getSelectedValue())) {
                        count++;
                        item1 = cliente.getPaquetePersonaje().getItems()
                                .get(count);
                    }
                    count = 0;
                    cliente.getPaqueteComercio().getItemsADar().add(item1);
                    misItems.removeElement(listMisItems.getSelectedValue());
                    cliente.getPaqueteComercio()
                            .setComando(Comando.ACTUALIZARCOMERCIO);
                    try {
                        cliente.getSalida().writeObject(
                                gson.toJson(cliente.getPaqueteComercio()));
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null,
                                "No se pudo actualizar comercio");
                    }
                    if (misItems.size() == 0) {
                        bonusSalud.setText("");
                        bonusEnergia.setText("");
                        bonusFuerza.setText("");
                        bonusDes.setText("");
                        bonusInt.setText("");
                    }
                }
            }
        });
        btnAgregar.setBounds(BTN_AGREGAR[0], BTN_AGREGAR[1], BTN_AGREGAR[2],
                BTN_AGREGAR[HEIGHT_BOUND]);
        contentPane.add(btnAgregar);

        final JButton btnSacar = new JButton("<--");
        btnSacar.setIcon(new ImageIcon("recursos//flechaIzq.png"));
        btnSacar.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                if (listADar.getSelectedValue() != null) {
                    misItems.addElement(listADar.getSelectedValue());
                    for (Item item : cliente.getPaquetePersonaje().getItems()) {
                        if (item.getNombre()
                                .equals(listADar.getSelectedValue())) {
                            cliente.getPaqueteComercio().getItemsADar()
                                    .remove(item);
                        }
                    }
                    dar.removeElement(listADar.getSelectedValue());
                    // Si saque el item y la lista no tiene nada deshabilito el
                    // check
                    if (dar.size() == 0) {
                        chckbxListo.setEnabled(false);
                    }
                    // Si los items en total es mayor a 9 no puedo comerciar
                    if (sizeItems - dar.size() + obtener.size() > SIZE) {
                        chckbxListo.setEnabled(false);
                        leyenda.setVisible(true);
                    }
                    cliente.getPaqueteComercio()
                            .setComando(Comando.ACTUALIZARCOMERCIO);
                    try {
                        cliente.getSalida().writeObject(
                                gson.toJson(cliente.getPaqueteComercio()));
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null,
                                "No se pudo actualizar comercio");
                    }
                    // Cuando paso un item de ofertar a no ofertado muestro el
                    // que movi
                    int i = misItems.size();
                    if (i >= 1) {
                        for (Item item : cliente.getPaquetePersonaje()
                                .getItems()) {
                            if (misItems.getElementAt(i - 1)
                                    .equals(item.getNombre())) {
                                bonusSalud.setText("+ " + item.getBonusSalud());
                                bonusEnergia
                                        .setText("+ " + item.getBonusEnergia());
                                bonusFuerza
                                        .setText("+ " + item.getBonusFuerza());
                                bonusDes.setText(
                                        "+ " + item.getBonusDestreza());
                                bonusInt.setText(
                                        "+ " + item.getBonusInteligencia());
                            }
                        }
                    }
                }
            }
        });
        btnSacar.setBounds(BTN_SACAR[0], BTN_SACAR[1], BTN_SACAR[2],
                BTN_SACAR[HEIGHT_BOUND]);
        contentPane.add(btnSacar);

        // List Listener para cargar stats del item mio clickeado
        listMisItems.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                if (arg0.getClickCount() == 1) {
                    if (listMisItems.getSelectedValue() != null) {
                        for (Item item : cliente.getPaquetePersonaje()
                                .getItems()) {
                            if (listMisItems.getSelectedValue()
                                    .equals(item.getNombre())) {
                                bonusSalud.setText("+ " + item.getBonusSalud());
                                bonusEnergia
                                        .setText("+ " + item.getBonusEnergia());
                                bonusFuerza
                                        .setText("+ " + item.getBonusFuerza());
                                bonusDes.setText(
                                        "+ " + item.getBonusDestreza());
                                bonusInt.setText(
                                        "+ " + item.getBonusInteligencia());
                            }
                        }
                    }
                }
            }
        });

        // List Listener para cargar stats del item del enemigo clickeado
        listAObtener.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent arg0) {
                if (arg0.getClickCount() == 1) {
                    if (obtener.size() != 0) {
                        // cambiar la variable del for each a la lista que va a
                        // venir del otro pj
                        for (Item item : cliente.getPaqueteComercio()
                                .getItemsAObtener()) {
                            if (listAObtener.getSelectedValue()
                                    .equals(item.getNombre())) {
                                saludEnemy.setText("+ " + item.getBonusSalud());
                                energyEnemy
                                        .setText("+ " + item.getBonusEnergia());
                                fzaEnemy.setText("+ " + item.getBonusFuerza());
                                desEnemy.setText(
                                        "+ " + item.getBonusDestreza());
                                intEnemy.setText(
                                        "+ " + item.getBonusInteligencia());
                            }
                        }
                    }
                }
            }
        });

        // CARGO MIS ITEMS
        for (Item item : cliente.getPaquetePersonaje().getItems()) {
            misItems.addElement(item.getNombre());
        }

        // Seteo la cantidad de mis items en mi mochila
        sizeItems = misItems.size();

        // Seteo de JList
        listMisItems.setModel(misItems);
        listADar.setModel(dar);
        listAObtener.setModel(obtener);

        cantListo = new JLabel("0/2");
        cantListo.setHorizontalAlignment(SwingConstants.RIGHT);
        cantListo.setForeground(Color.WHITE);
        cantListo.setBounds(CANT_LISTO[0], CANT_LISTO[1], CANT_LISTO[2],
                CANT_LISTO[HEIGHT_BOUND]);
        contentPane.add(cantListo);

        chckbxListo.addItemListener(new ItemListener() {
            public void itemStateChanged(final ItemEvent arg0) {
                if (chckbxListo.isSelected()) {
                    // Si ya la persona con la que voy a comerciar esta en LISTO
                    if (cantListos == 1) {
                        cantListos++;
                        // Primero actualizo el label de cant Listos
                        cantListo.setText(cantListos + "/2");
                        // Le envio al otro que toque listo y esta 2/2 listo
                        // para trueque
                        cliente.getPaqueteComercio().aumentarListo();
                        cliente.getPaqueteComercio()
                                .setComando(Comando.ACTUALIZARCOMERCIO);
                        try {
                            cliente.getSalida().writeObject(
                                    gson.toJson(cliente.getPaqueteComercio()));
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null,
                                    "No se pudo actualizar comercio");
                        }
                        ////////
                        // Ahora le digo que haga el trueque
                        cliente.getPaqueteComercio()
                                .setComando(Comando.TRUEQUE);
                        // Le informo al otro que vamos a hacer el trueque
                        try {
                            cliente.getSalida().writeObject(
                                    gson.toJson(cliente.getPaqueteComercio()));
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null,
                                    "No se pudo actualizar comercio");
                        }
                        JOptionPane.showMessageDialog(cliente.getM1(),
                                "Se ha realizado con exito el comercio");
                        dispose();
                    } else {
                        // Si todavía LISTO = 0, le informo al otro
                        cantListos++;
                        // Deshabilito los botones para que no pueda agregar
                        // nada
                        btnAgregar.setEnabled(false);
                        btnSacar.setEnabled(false);
                        cliente.getPaqueteComercio().aumentarListo();
                        cliente.getPaqueteComercio()
                                .setComando(Comando.ACTUALIZARCOMERCIO);
                        // Tambien le tiene que avisar el LISTO al otro jugador
                        try {
                            cliente.getSalida().writeObject(
                                    gson.toJson(cliente.getPaqueteComercio()));
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null,
                                    "No se pudo actualizar comercio");
                        }
                        cantListo.setText(cantListos + "/2");
                    }
                } else {
                    // Si habia clickeado LISTO, pero lo desclickie entonces le
                    // digo
                    // que disminuya en el otro cliente
                    if (cantListos != 2) {
                        // Si no tenia nada en la lista no tengo que disminuir
                        // la cant
                        // de listos
                        cantListos--;
                        cliente.getPaqueteComercio().disminuirListo();
                        btnAgregar.setEnabled(true);
                        btnSacar.setEnabled(true);
                        cliente.getPaqueteComercio()
                                .setComando(Comando.ACTUALIZARCOMERCIO);
                        // Tambien le tiene que avisar el NO LISTO al otro
                        // jugador
                        try {
                            cliente.getSalida().writeObject(
                                    gson.toJson(cliente.getPaqueteComercio()));
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null,
                                    "No se pudo actualizar comercio");
                        }
                        cantListo.setText(cantListos + "/2");
                    }
                }
            }
        });
        chckbxListo.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxListo.setBounds(CHECK_LISTO[0], CHECK_LISTO[1], CHECK_LISTO[2],
                CHECK_LISTO[HEIGHT_BOUND]);
        contentPane.add(chckbxListo);

        final JLabel background = new JLabel(new ImageIcon(
                imagenFondo.getScaledInstance(610, 416, Image.SCALE_DEFAULT)));
        background.setBounds(BACKGROUND[0], BACKGROUND[1], BACKGROUND[2],
                BACKGROUND[HEIGHT_BOUND]);
        contentPane.add(background);
    }

    /**
     * Obtener cant listos.
     *
     * @return cant listos
     */
    public final int getCantListos() {
        return cantListos;
    }

    /**
     * Sets cant listos. <br>
     *
     * @param cantListos
     *            cant listos <br>
     */
    public final void setCantListos(final int cantListos) {
        this.cantListos = cantListos;
    }

    /**
     * Obtener cant listo.
     *
     * @return cant listo
     */
    public final JLabel getCantListo() {
        return cantListo;
    }

    /**
     * Sets obtener. <br>
     *
     * @param obtener
     *            obtener <br>
     */
    public final void setObtener(final DefaultListModel<String> obtener) {
        this.obtener = obtener;
    }

    /**
     * Obtener obtener.
     *
     * @return obtener
     */
    public final DefaultListModel<String> getObtener() {
        return obtener;
    }

    /**
     * Obtener dar.
     *
     * @return dar
     */
    public final DefaultListModel<String> getDar() {
        return dar;
    }

    /**
     * Obtener size items.
     *
     * @return size items
     */
    public final int getSizeItems() {
        return sizeItems;
    }

    /**
     * Obtener chckbx listo.
     *
     * @return chckbx listo
     */
    public final JCheckBox getChckbxListo() {
        return chckbxListo;
    }

    /**
     * Obtener leyenda.
     *
     * @return leyenda
     */
    public final JLabel getLeyenda() {
        return leyenda;
    }
}
