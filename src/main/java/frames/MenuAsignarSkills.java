package frames;

import java.awt.Color;
import java.awt.Toolkit;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import cliente.Cliente;
import juego.Pantalla;
import mensajeria.Comando;

/**
 * Clase que administra el menú para asignar skills al personaje. <br>
 */
public class MenuAsignarSkills extends JFrame {
    /** Constante HEIGHT_BOUND. */
    private static final int HEIGHT_BOUND = 3;

    /** Constante PUNTOS_FUERZA. */
    private static final int PUNTOS_FUERZA = 200;

    /** Constante PUNTOS_INTELIGENCIA. */
    private static final int PUNTOS_INTELIGENCIA = 200;

    /** Constante PUNTOS_DESTREZA. */
    private static final int PUNTOS_DESTREZA = 200;

    /** Constante EMPTY_BORDER. */
    private static final int EMPTY_BORDER = 5;

    /** Constante X1. */
    private static final int X1 = 50;

    /** Constante HEIGHT. */
    private static final int HEIGHT = 16;

    /** Constante WIDTH. */
    private static final int WIDTH = 56;

    /** Constante BOUNDS1. */
    private static final int[] BOUNDS1 = {100, 100, 450, 300};

    /** Constante BOUNDS2. */
    private static final int[] BOUNDS2 = {100, 100, 298, 294};

    /** Constante LABEL_PUNTOS. */
    private static final int[] LABEL_PUNTOS = {39, 41, 83, 26};

    /** Constante LABEL_INTELIGENCIA. */
    private static final int[] LABEL_INTELIGENCIA = {X1, 217, WIDTH, HEIGHT};

    /** Constante LABEL_FUERZA. */
    private static final int[] LABEL_FUERZA = {X1, 101, WIDTH, HEIGHT};

    /** Constante LABEL_DESTREZA. */
    private static final int[] LABEL_DESTREZA = {X1, 159, WIDTH, HEIGHT};

    /** Constante LBL_INTELIGENCIA. */
    private static final int[] LBL_INTELIGENCIA = {39, 188, 83, HEIGHT};

    /** Constante LBL_FUERZA. */
    private static final int[] LBL_FUERZA = {X1, 72, WIDTH, HEIGHT};

    /** Constante LBL_DESTREZA. */
    private static final int[] LBL_DESTREZA = {X1, 130, WIDTH, HEIGHT};

    /** Constante LABEL_CANT_PUNTOS. */
    private static final int[] LABEL_CANT_PUNTOS = {12, 13, 177, 29};

    /** Constante BTN_CONFIRMAR. */
    private static final int[] BTN_CONFIRMAR = {176, 112, 97, 25};

    /** Constante BTN_CANCELAR. */
    private static final int[] BTN_CANCELAR = {176, 184, 97, 25};

    /** Constante BTN_REASIGNAR_PUNTOS. */
    private static final int[] BTN_REASIGNAR_PUNTOS = {176, 148, 97, 27};

    /** Constante BTN_SUMAR_INTELIGENCIA. */
    private static final int[] BTN_SUMAR_INTELIGENCIA = {118, 217, 34, 25};

    /** Constante BTN_SUMAR_DESTREZA. */
    private static final int[] BTN_SUMAR_DESTREZA = {118, 159, 34, 25};

    /** Constante BTN_SUMAR_FUERZA. */
    private static final int[] BTN_SUMAR_FUERZA = {118, 92, 34, 25};

    /** Constante BTN_RESTAR_INTELIGENCIA. */
    private static final int[] BTN_RESTAR_INTELIGENCIA = {12, 217, 34, 25};

    /** Constante BTN_RESTAR_DESTREZA. */
    private static final int[] BTN_RESTAR_DESTREZA = {12, 159, 34, 25};

    /** Constante BTN_RESTAR_FUERZA. */
    private static final int[] BTN_RESTAR_FUERZA = {12, 92, 34, 25};

    /** Constante IMAGE_LABEL. */
    private static final int[] IMAGE_LABEL = {0, 0, 298, 294};
    /**
     * Dato irrelevante para que no moleste. <br>
     */
    private static final long serialVersionUID = 1L;
    /**
     * Pantalla principal. <br>
     */
    private JPanel contentPane;
    /**
     * Puntos de fuerza que posee el personaje. <br>
     */
    private int puntosFuerzaInicial;
    /**
     * Puntos de destreza que posee el personaje. <br>
     */
    private int puntosDestrezaInicial;
    /**
     * Puntos de inteligencia que posee el personaje. <br>
     */
    private int puntosInteligenciaInicial;
    /**
     * Puntos disponibles para asignar que posee el personaje. <br>
     */
    private int puntosAsignarInicial;
    /**
     * Puntos disponibles para asignar. <br>
     */
    private int puntosAsignar;
    /**
     * Nuevos puntos de fuerza. <br>
     */
    private int puntosFuerza;
    /**
     * Nuevos puntos de destreza. <br>
     */
    private int puntosDestreza;
    /**
     * Nuevos puntos de inteligencia. <br>
     */
    private int puntosInteligencia;
    /**
     * Gson. <br>
     */
    private final Gson gson = new Gson();

    /**
     * Muestra la pantalla para asignar los skills al personaje.
     * <p>
     * El personaje puede asignar puntos que tenga disponible como puede
     * resetear y reasignar los puntos nuevamente. <br>
     *
     * @param cliente
     *            Cliente que lo invoca. <br>
     */
    public MenuAsignarSkills(final Cliente cliente) {
        puntosFuerzaInicial = cliente.getPaquetePersonaje().getFuerza();
        puntosDestrezaInicial = cliente.getPaquetePersonaje().getDestreza();
        puntosInteligenciaInicial = cliente.getPaquetePersonaje()
                .getInteligencia();
        puntosAsignarInicial = cliente.getPaquetePersonaje().getPuntosAsignar();
        puntosFuerza = puntosFuerzaInicial;
        puntosDestreza = puntosDestrezaInicial;
        puntosInteligencia = puntosInteligenciaInicial;
        puntosAsignar = puntosAsignarInicial;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(BOUNDS1[0], BOUNDS1[1], BOUNDS1[2], BOUNDS1[HEIGHT_BOUND]);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(EMPTY_BORDER, EMPTY_BORDER,
                EMPTY_BORDER, EMPTY_BORDER));
        setContentPane(contentPane);

        setIconImage(Toolkit.getDefaultToolkit().getImage("recursos//1up.png"));
        setTitle("Asignar");
        setBounds(BOUNDS2[0], BOUNDS2[1], BOUNDS2[2], BOUNDS2[HEIGHT_BOUND]);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setLocationRelativeTo(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent arg0) {
                Pantalla.menuAsignar = null;
                dispose();
            }
        });
        contentPane.setLayout(null);

        final JLabel labelFuerza = new JLabel("");
        labelFuerza.setForeground(Color.WHITE);
        labelFuerza.setHorizontalAlignment(SwingConstants.CENTER);
        labelFuerza.setBounds(LABEL_FUERZA[0], LABEL_FUERZA[1], LABEL_FUERZA[2],
                LABEL_FUERZA[HEIGHT_BOUND]);
        labelFuerza.setText(String.valueOf(puntosFuerzaInicial));
        contentPane.add(labelFuerza);

        final JLabel labelDestreza = new JLabel("");
        labelDestreza.setForeground(Color.WHITE);
        labelDestreza.setHorizontalAlignment(SwingConstants.CENTER);
        labelDestreza.setBounds(LABEL_DESTREZA[0], LABEL_DESTREZA[1],
                LABEL_DESTREZA[2], LABEL_DESTREZA[HEIGHT_BOUND]);
        labelDestreza.setText(String.valueOf(puntosDestrezaInicial));
        contentPane.add(labelDestreza);

        final JLabel labelInteligencia = new JLabel("");
        labelInteligencia.setForeground(Color.WHITE);
        labelInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
        labelInteligencia.setBounds(LABEL_INTELIGENCIA[0],
                LABEL_INTELIGENCIA[1], LABEL_INTELIGENCIA[2],
                LABEL_INTELIGENCIA[HEIGHT_BOUND]);
        labelInteligencia.setText(String.valueOf(puntosInteligenciaInicial));
        contentPane.add(labelInteligencia);

        final JLabel labelPuntos = new JLabel("");
        labelPuntos.setForeground(Color.WHITE);
        labelPuntos.setHorizontalAlignment(SwingConstants.CENTER);
        labelPuntos.setBounds(LABEL_PUNTOS[0], LABEL_PUNTOS[1], LABEL_PUNTOS[2],
                LABEL_PUNTOS[HEIGHT_BOUND]);
        labelPuntos.setText(String.valueOf(puntosAsignarInicial));
        contentPane.add(labelPuntos);

        final JLabel lblCantidadDePuntos = new JLabel(
                "Cantidad de Puntos a Asignar");
        lblCantidadDePuntos.setForeground(Color.WHITE);
        lblCantidadDePuntos.setBounds(LABEL_CANT_PUNTOS[0],
                LABEL_CANT_PUNTOS[1], LABEL_CANT_PUNTOS[2],
                LABEL_CANT_PUNTOS[HEIGHT_BOUND]);
        contentPane.add(lblCantidadDePuntos);

        final JLabel lblInteligencia = new JLabel("Inteligencia");
        lblInteligencia.setForeground(Color.WHITE);
        lblInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
        lblInteligencia.setBounds(LBL_INTELIGENCIA[0], LBL_INTELIGENCIA[1],
                LBL_INTELIGENCIA[2], LBL_INTELIGENCIA[HEIGHT_BOUND]);
        contentPane.add(lblInteligencia);

        JLabel lblDestreza = new JLabel("Destreza");
        lblDestreza.setForeground(Color.WHITE);
        lblDestreza.setHorizontalAlignment(SwingConstants.CENTER);
        lblDestreza.setBounds(LBL_DESTREZA[0], LBL_DESTREZA[1], LBL_DESTREZA[2],
                LBL_DESTREZA[HEIGHT_BOUND]);
        contentPane.add(lblDestreza);

        final JLabel lblFuerza = new JLabel("Fuerza");
        lblFuerza.setForeground(Color.WHITE);
        lblFuerza.setHorizontalAlignment(SwingConstants.CENTER);
        lblFuerza.setBounds(LBL_FUERZA[0], LBL_FUERZA[1], LBL_FUERZA[2],
                LBL_FUERZA[HEIGHT_BOUND]);
        contentPane.add(lblFuerza);

        final JButton buttonConfirmar = new JButton("Confirmar");
        ImageIcon iconoConfirm = new ImageIcon("recursos//botonConfirmar.png");
        buttonConfirmar.setIcon(iconoConfirm);
        buttonConfirmar.setEnabled(false);
        buttonConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                int bonusF = puntosFuerza - puntosFuerzaInicial;
                int bonusD = puntosDestreza - puntosDestrezaInicial;
                int bonusI = puntosInteligencia - puntosInteligenciaInicial;
                int bonusS = puntosAsignarInicial - puntosAsignar;

                cliente.getPaquetePersonaje().useBonus(0, 0, bonusF, bonusD,
                        bonusI, bonusS);
                cliente.getPaquetePersonaje().removerBonus();
                cliente.getPaquetePersonaje()
                        .setComando(Comando.ACTUALIZARPERSONAJELV);
                try {
                    cliente.getSalida().writeObject(
                            gson.toJson(cliente.getPaquetePersonaje()));
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null,
                            "Error al actualizar stats");

                }
                JOptionPane.showMessageDialog(null,
                        "Se han actualizado tus atributos.");
                dispose();
            }
        });
        buttonConfirmar.setBounds(BTN_CONFIRMAR[0], BTN_CONFIRMAR[1],
                BTN_CONFIRMAR[2], BTN_CONFIRMAR[HEIGHT_BOUND]);
        contentPane.add(buttonConfirmar);

        final JButton buttonCancelar = new JButton("Cancelar");
        ImageIcon iconoC = new ImageIcon("recursos//botonCancelar.png");
        buttonCancelar.setIcon(iconoC);
        buttonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                Pantalla.menuAsignar = null;
                dispose();
            }
        });

        final JButton btnReasignarPuntos = new JButton("Reiniciar");
        ImageIcon iconoReiniciar = new ImageIcon(
                "recursos//botonReiniciar.png");
        btnReasignarPuntos.setIcon(iconoReiniciar);
        btnReasignarPuntos.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                if (JOptionPane.showConfirmDialog(btnReasignarPuntos,
                        "Esta seguro que quiere reasignar los puntos?") == 0) {

                    cliente.getPaquetePersonaje().reiniciarStats();

                    cliente.getPaquetePersonaje().ponerBonus();

                    labelFuerza.setText(Integer.toString(
                            cliente.getPaquetePersonaje().getFuerza()));
                    labelDestreza.setText(Integer.toString(
                            cliente.getPaquetePersonaje().getDestreza()));
                    labelInteligencia.setText(Integer.toString(
                            cliente.getPaquetePersonaje().getInteligencia()));

                    labelPuntos.setText(Integer.toString(
                            cliente.getPaquetePersonaje().getPuntosAsignar()));
                }
            }
        });
        btnReasignarPuntos.setBounds(BTN_REASIGNAR_PUNTOS[0],
                BTN_REASIGNAR_PUNTOS[1], BTN_REASIGNAR_PUNTOS[2],
                BTN_REASIGNAR_PUNTOS[HEIGHT_BOUND]);
        contentPane.add(btnReasignarPuntos);
        buttonCancelar.setBounds(BTN_CANCELAR[0], BTN_CANCELAR[1],
                BTN_CANCELAR[2], BTN_CANCELAR[HEIGHT_BOUND]);
        contentPane.add(buttonCancelar);

        final JButton buttonRestarFuerza = new JButton("");
        final JButton buttonRestarDestreza = new JButton("");
        final JButton buttonRestarInteligencia = new JButton("");
        final JButton buttonSumarFuerza = new JButton("");
        final JButton buttonSumarDestreza = new JButton("");
        final JButton buttonSumarInteligencia = new JButton("");
        buttonRestarFuerza.setEnabled(false);
        buttonRestarDestreza.setEnabled(false);
        buttonRestarInteligencia.setEnabled(false);

        ImageIcon icono1 = new ImageIcon("recursos//botonMenoss.png");
        buttonRestarFuerza.setIcon(icono1);
        buttonRestarFuerza.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                if (puntosFuerza > puntosFuerzaInicial) {
                    puntosFuerza--;
                    if (puntosAsignar == 0) {
                        if (puntosInteligencia != PUNTOS_INTELIGENCIA) {
                            buttonSumarInteligencia.setEnabled(true);
                        }
                        if (puntosDestreza != PUNTOS_DESTREZA) {
                            buttonSumarDestreza.setEnabled(true);
                        }
                    } else {
                        buttonSumarFuerza.setEnabled(true);
                        buttonSumarDestreza.setEnabled(true);
                        buttonSumarInteligencia.setEnabled(true);
                    }
                    puntosAsignar++;
                    if (puntosAsignar == puntosAsignarInicial) {
                        buttonConfirmar.setEnabled(false);
                    }
                    labelPuntos.setText(String.valueOf(puntosAsignar));
                    labelFuerza.setText(String.valueOf(puntosFuerza));
                    if (puntosFuerza == puntosFuerzaInicial) {
                        buttonRestarFuerza.setEnabled(false);
                        buttonSumarFuerza.setEnabled(true);
                    } else if (puntosFuerza >= puntosFuerzaInicial) {
                        buttonSumarFuerza.setEnabled(true);
                    }
                }
            }
        });
        buttonRestarFuerza.setBounds(BTN_RESTAR_FUERZA[0], BTN_RESTAR_FUERZA[1],
                BTN_RESTAR_FUERZA[2], BTN_RESTAR_FUERZA[HEIGHT_BOUND]);
        contentPane.add(buttonRestarFuerza);

        buttonRestarDestreza.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                if (puntosDestreza > puntosDestrezaInicial) {
                    puntosDestreza--;
                    if (puntosAsignar == 0) {
                        if (puntosInteligencia != PUNTOS_INTELIGENCIA) {
                            buttonSumarInteligencia.setEnabled(true);
                        }
                        if (puntosFuerza != PUNTOS_FUERZA) {
                            buttonSumarFuerza.setEnabled(true);
                        }
                    } else {
                        buttonSumarFuerza.setEnabled(true);
                        buttonSumarDestreza.setEnabled(true);
                        buttonSumarInteligencia.setEnabled(true);
                    }
                    puntosAsignar++;
                    if (puntosAsignar == puntosAsignarInicial) {
                        buttonConfirmar.setEnabled(false);
                    }
                    labelPuntos.setText(String.valueOf(puntosAsignar));
                    labelDestreza.setText(String.valueOf(puntosDestreza));
                    if (puntosDestreza == puntosDestrezaInicial) {
                        buttonRestarDestreza.setEnabled(false);
                        buttonSumarDestreza.setEnabled(true);
                    } else if (puntosDestreza >= puntosDestrezaInicial) {
                        buttonSumarDestreza.setEnabled(true);
                    }
                }
            }
        });
        buttonRestarDestreza.setIcon(icono1);
        buttonRestarDestreza.setBounds(BTN_RESTAR_DESTREZA[0],
                BTN_RESTAR_DESTREZA[1], BTN_RESTAR_DESTREZA[2],
                BTN_RESTAR_DESTREZA[HEIGHT_BOUND]);
        contentPane.add(buttonRestarDestreza);

        buttonRestarInteligencia.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                if (puntosInteligencia > puntosInteligenciaInicial) {
                    puntosInteligencia--;
                    if (puntosAsignar == 0) {
                        if (puntosFuerza != PUNTOS_FUERZA) {
                            buttonSumarFuerza.setEnabled(true);
                        }
                        if (puntosDestreza != PUNTOS_DESTREZA) {
                            buttonSumarDestreza.setEnabled(true);
                        }
                    } else {
                        buttonSumarFuerza.setEnabled(true);
                        buttonSumarDestreza.setEnabled(true);
                        buttonSumarInteligencia.setEnabled(true);
                    }
                    puntosAsignar++;
                    if (puntosAsignar == puntosAsignarInicial) {
                        buttonConfirmar.setEnabled(false);
                    }
                    labelPuntos.setText(String.valueOf(puntosAsignar));
                    labelInteligencia
                            .setText(String.valueOf(puntosInteligencia));
                    if (puntosInteligencia == puntosInteligenciaInicial) {
                        buttonRestarInteligencia.setEnabled(false);
                        buttonSumarInteligencia.setEnabled(true);
                    } else if (puntosInteligencia >= puntosInteligenciaInicial) {
                        buttonSumarInteligencia.setEnabled(true);
                    }
                }
            }
        });
        buttonRestarInteligencia.setIcon(icono1);
        buttonRestarInteligencia.setBounds(BTN_RESTAR_INTELIGENCIA[0],
                BTN_RESTAR_INTELIGENCIA[1], BTN_RESTAR_INTELIGENCIA[2],
                BTN_RESTAR_INTELIGENCIA[HEIGHT_BOUND]);
        contentPane.add(buttonRestarInteligencia);

        buttonSumarFuerza.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                if (puntosAsignar != 0
                        && !labelFuerza.getText().equals("200")) {
                    puntosFuerza++;
                    puntosAsignar--;
                    buttonConfirmar.setEnabled(true);
                    labelPuntos.setText(String.valueOf(puntosAsignar));
                    labelFuerza.setText(String.valueOf(puntosFuerza));
                    buttonRestarFuerza.setEnabled(true);
                    if (puntosAsignar == 0) {
                        buttonSumarFuerza.setEnabled(false);
                        buttonSumarDestreza.setEnabled(false);
                        buttonSumarInteligencia.setEnabled(false);
                    }
                }
                if (puntosAsignar == 0 || labelFuerza.getText().equals("200")) {
                    buttonSumarFuerza.setEnabled(false);
                }
            }
        });
        ImageIcon icono2 = new ImageIcon("recursos//botonMass.png");
        buttonSumarFuerza.setIcon(icono2);
        buttonSumarFuerza.setBounds(BTN_SUMAR_FUERZA[0], BTN_SUMAR_FUERZA[1],
                BTN_SUMAR_FUERZA[2], BTN_SUMAR_FUERZA[HEIGHT_BOUND]);
        contentPane.add(buttonSumarFuerza);

        buttonSumarDestreza.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                if (puntosAsignar != 0
                        && !labelDestreza.getText().equals("200")) {
                    puntosDestreza++;
                    puntosAsignar--;
                    buttonConfirmar.setEnabled(true);
                    labelPuntos.setText(String.valueOf(puntosAsignar));
                    labelDestreza.setText(String.valueOf(puntosDestreza));
                    buttonRestarDestreza.setEnabled(true);
                    if (puntosAsignar == 0) {
                        buttonSumarFuerza.setEnabled(false);
                        buttonSumarDestreza.setEnabled(false);
                        buttonSumarInteligencia.setEnabled(false);
                    }
                    if (puntosAsignar == 0
                            || labelDestreza.getText().equals("200")) {
                        buttonSumarDestreza.setEnabled(false);
                    }
                }
            }
        });
        buttonSumarDestreza.setIcon(icono2);
        buttonSumarDestreza.setBounds(BTN_SUMAR_DESTREZA[0],
                BTN_SUMAR_DESTREZA[1], BTN_SUMAR_DESTREZA[2],
                BTN_SUMAR_DESTREZA[HEIGHT_BOUND]);
        contentPane.add(buttonSumarDestreza);

        buttonSumarInteligencia.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                if (puntosAsignar != 0
                        && !labelInteligencia.getText().equals("200")) {
                    puntosInteligencia++;
                    puntosAsignar--;
                    buttonConfirmar.setEnabled(true);
                    labelPuntos.setText(String.valueOf(puntosAsignar));
                    labelInteligencia
                            .setText(String.valueOf(puntosInteligencia));
                    buttonRestarInteligencia.setEnabled(true);
                    if (puntosAsignar == 0) {
                        buttonSumarFuerza.setEnabled(false);
                        buttonSumarDestreza.setEnabled(false);
                        buttonSumarInteligencia.setEnabled(false);
                    }
                    if (puntosAsignar == 0
                            || labelInteligencia.getText().equals("200")) {
                        buttonSumarInteligencia.setEnabled(false);
                    }
                }
            }
        });
        buttonSumarInteligencia.setIcon(icono2);
        buttonSumarInteligencia.setBounds(BTN_SUMAR_INTELIGENCIA[0],
                BTN_SUMAR_INTELIGENCIA[1], BTN_SUMAR_INTELIGENCIA[2],
                BTN_SUMAR_INTELIGENCIA[HEIGHT_BOUND]);
        contentPane.add(buttonSumarInteligencia);

        final JLabel imageLabel = new JLabel(
                new ImageIcon("recursos//background.jpg"));
        imageLabel.setBounds(IMAGE_LABEL[0], IMAGE_LABEL[1], IMAGE_LABEL[2],
                IMAGE_LABEL[HEIGHT_BOUND]);
        imageLabel.setVisible(true);
        contentPane.add(imageLabel);
    }
}
