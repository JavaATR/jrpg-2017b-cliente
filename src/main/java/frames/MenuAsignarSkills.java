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
		puntosInteligenciaInicial = cliente.getPaquetePersonaje().getInteligencia();
		puntosAsignarInicial = cliente.getPaquetePersonaje().getPuntosAsignar();
		puntosFuerza = puntosFuerzaInicial;
		puntosDestreza = puntosDestrezaInicial;
		puntosInteligencia = puntosInteligenciaInicial;
		puntosAsignar = puntosAsignarInicial;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		setIconImage(Toolkit.getDefaultToolkit().getImage("recursos//1up.png"));
		setTitle("Asignar");
		setBounds(100, 100, 298, 294);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setLocationRelativeTo(null);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				Pantalla.menuAsignar = null;
				dispose();
			}
		});
		contentPane.setLayout(null);

		final JLabel labelFuerza = new JLabel("");
		labelFuerza.setForeground(Color.WHITE);
		labelFuerza.setHorizontalAlignment(SwingConstants.CENTER);
		labelFuerza.setBounds(50, 101, 56, 16);
		labelFuerza.setText(String.valueOf(puntosFuerzaInicial));
		contentPane.add(labelFuerza);

		final JLabel labelDestreza = new JLabel("");
		labelDestreza.setForeground(Color.WHITE);
		labelDestreza.setHorizontalAlignment(SwingConstants.CENTER);
		labelDestreza.setBounds(50, 159, 56, 16);
		labelDestreza.setText(String.valueOf(puntosDestrezaInicial));
		contentPane.add(labelDestreza);

		final JLabel labelInteligencia = new JLabel("");
		labelInteligencia.setForeground(Color.WHITE);
		labelInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
		labelInteligencia.setBounds(50, 217, 56, 16);
		labelInteligencia.setText(String.valueOf(puntosInteligenciaInicial));
		contentPane.add(labelInteligencia);

		final JLabel labelPuntos = new JLabel("");
		labelPuntos.setForeground(Color.WHITE);
		labelPuntos.setHorizontalAlignment(SwingConstants.CENTER);
		labelPuntos.setBounds(39, 41, 83, 26);
		labelPuntos.setText(String.valueOf(puntosAsignarInicial));
		contentPane.add(labelPuntos);

		final JLabel lblCantidadDePuntos = new JLabel("Cantidad de Puntos a Asignar");
		lblCantidadDePuntos.setForeground(Color.WHITE);
		lblCantidadDePuntos.setBounds(12, 13, 177, 29);
		contentPane.add(lblCantidadDePuntos);

		final JLabel lblInteligencia = new JLabel("Inteligencia");
		lblInteligencia.setForeground(Color.WHITE);
		lblInteligencia.setHorizontalAlignment(SwingConstants.CENTER);
		lblInteligencia.setBounds(39, 188, 83, 16);
		contentPane.add(lblInteligencia);

		JLabel lblDestreza = new JLabel("Destreza");
		lblDestreza.setForeground(Color.WHITE);
		lblDestreza.setHorizontalAlignment(SwingConstants.CENTER);
		lblDestreza.setBounds(50, 130, 56, 16);
		contentPane.add(lblDestreza);

		final JLabel lblFuerza = new JLabel("Fuerza");
		lblFuerza.setForeground(Color.WHITE);
		lblFuerza.setHorizontalAlignment(SwingConstants.CENTER);
		lblFuerza.setBounds(50, 72, 56, 16);
		contentPane.add(lblFuerza);

		final JButton buttonConfirmar = new JButton("Confirmar");
		ImageIcon icono_confirm = new ImageIcon("recursos//botonConfirmar.png");
		buttonConfirmar.setIcon(icono_confirm);
		buttonConfirmar.setEnabled(false);
		buttonConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				puntosAsignarInicial = puntosAsignar;
				int bonusF = puntosFuerza - puntosFuerzaInicial;
				int bonusD = puntosDestreza - puntosDestrezaInicial;
				int bonusI = puntosInteligencia - puntosInteligenciaInicial;
				int bonusS = puntosAsignar - puntosAsignarInicial;
				cliente.getPaquetePersonaje().useBonus(0, 0, bonusF, bonusD, bonusI, bonusS);
				cliente.getPaquetePersonaje().removerBonus();
				cliente.getPaquetePersonaje().setComando(Comando.ACTUALIZARPERSONAJELV);
				try {
					cliente.getSalida().writeObject(gson.toJson(cliente.getPaquetePersonaje()));
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error al actualizar stats");

				}
				JOptionPane.showMessageDialog(null, "Se han actualizado tus atributos.");
				dispose();
			}
		});
		buttonConfirmar.setBounds(176, 112, 97, 25);
		contentPane.add(buttonConfirmar);

		final JButton buttonCancelar = new JButton("Cancelar");
		ImageIcon icono_c = new ImageIcon("recursos//botonCancelar.png");
		buttonCancelar.setIcon(icono_c);
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pantalla.menuAsignar = null;
				dispose();
			}
		});
		
		final JButton btnReasignarPuntos = new JButton("Reiniciar");
		ImageIcon icono_reiniciar = new ImageIcon("recursos//botonReiniciar.png");
		btnReasignarPuntos.setIcon(icono_reiniciar);
		btnReasignarPuntos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(btnReasignarPuntos,
						"Esta seguro que quiere reasignar los puntos?") == 0) {

					puntosFuerza = cliente.getPaquetePersonaje().getFuerzaInicial(); // Aca adentro valido que casta es y cuanto le devuelvo
					puntosDestreza = cliente.getPaquetePersonaje().getDestrezaInicial();
					puntosInteligencia = cliente.getPaquetePersonaje().getInteligenciaInicial();

					puntosAsignar = 3 * (cliente.getPaquetePersonaje().getNivel());

					labelFuerza.setText(Integer.toString(puntosFuerza));
					labelDestreza.setText(Integer.toString(puntosDestreza));
					labelInteligencia.setText(Integer.toString(puntosInteligencia));

					labelPuntos.setText(Integer.toString(puntosAsignar));
				}
			}
		});
				btnReasignarPuntos.setBounds(176, 148, 97, 27);
				contentPane.add(btnReasignarPuntos);
		buttonCancelar.setBounds(176, 184, 97, 25);
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

		ImageIcon icono_1 = new ImageIcon("recursos//botonMenoss.png");
		buttonRestarFuerza.setIcon(icono_1);
		buttonRestarFuerza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (puntosFuerza > puntosFuerzaInicial) {
					puntosFuerza--;
					if (puntosAsignar == 0) {
						if (puntosInteligencia != 200) {
							buttonSumarInteligencia.setEnabled(true);
						}
						if (puntosDestreza != 200) {
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
		buttonRestarFuerza.setBounds(12, 92, 34, 25);
		contentPane.add(buttonRestarFuerza);

		buttonRestarDestreza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (puntosDestreza > puntosDestrezaInicial) {
					puntosDestreza--;
					if (puntosAsignar == 0) {
						if (puntosInteligencia != 200) {
							buttonSumarInteligencia.setEnabled(true);
						}
						if (puntosFuerza != 200) {
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
		buttonRestarDestreza.setIcon(icono_1);
		buttonRestarDestreza.setBounds(12, 159, 34, 25);
		contentPane.add(buttonRestarDestreza);

		buttonRestarInteligencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (puntosInteligencia > puntosInteligenciaInicial) {
					puntosInteligencia--;
					if (puntosAsignar == 0) {
						if (puntosFuerza != 200) {
							buttonSumarFuerza.setEnabled(true);
						}
						if (puntosDestreza != 200) {
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
					labelInteligencia.setText(String.valueOf(puntosInteligencia));
					if (puntosInteligencia == puntosInteligenciaInicial) {
						buttonRestarInteligencia.setEnabled(false);
						buttonSumarInteligencia.setEnabled(true);
					} else if (puntosInteligencia >= puntosInteligenciaInicial) {
						buttonSumarInteligencia.setEnabled(true);
					}
				}
			}
		});
		buttonRestarInteligencia.setIcon(icono_1);
		buttonRestarInteligencia.setBounds(12, 217, 34, 25);
		contentPane.add(buttonRestarInteligencia);

		buttonSumarFuerza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (puntosAsignar != 0 && !labelFuerza.getText().equals("200")) {
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
		ImageIcon icono_2 = new ImageIcon("recursos//botonMass.png");
		buttonSumarFuerza.setIcon(icono_2);
		buttonSumarFuerza.setBounds(118, 92, 34, 25);
		contentPane.add(buttonSumarFuerza);

		buttonSumarDestreza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (puntosAsignar != 0 && !labelDestreza.getText().equals("200")) {
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
					if (puntosAsignar == 0 || labelDestreza.getText().equals("200")) {
						buttonSumarDestreza.setEnabled(false);
					}
				}
			}
		});
		buttonSumarDestreza.setIcon(icono_2);
		buttonSumarDestreza.setBounds(118, 159, 34, 25);
		contentPane.add(buttonSumarDestreza);

		buttonSumarInteligencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (puntosAsignar != 0 && !labelInteligencia.getText().equals("200")) {
					puntosInteligencia++;
					puntosAsignar--;
					buttonConfirmar.setEnabled(true);
					labelPuntos.setText(String.valueOf(puntosAsignar));
					labelInteligencia.setText(String.valueOf(puntosInteligencia));
					buttonRestarInteligencia.setEnabled(true);
					if (puntosAsignar == 0) {
						buttonSumarFuerza.setEnabled(false);
						buttonSumarDestreza.setEnabled(false);
						buttonSumarInteligencia.setEnabled(false);
					}
					if (puntosAsignar == 0 || labelInteligencia.getText().equals("200")) {
						buttonSumarInteligencia.setEnabled(false);
					}
				}
			}
		});
		buttonSumarInteligencia.setIcon(icono_2);
		buttonSumarInteligencia.setBounds(118, 217, 34, 25);
		contentPane.add(buttonSumarInteligencia);
		
				final JLabel imageLabel = new JLabel(new ImageIcon("recursos//background.jpg"));
				imageLabel.setBounds(0, 0, 298, 294);
				imageLabel.setVisible(true);
				contentPane.add(imageLabel);
	}
}