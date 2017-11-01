package frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import cliente.Cliente;
import inventario.Inventario;
import juego.Pantalla;
import mensajeria.Comando;

/**
 * Clase que administra el menú del inventario. <br>
 */
@SuppressWarnings("serial")
public class MenuInventario extends JFrame {
    /**
     * Botón de cancelar. <br>
     */
    private JButton cancelar = new JButton("Exit");
    /**
     * Bounds X principal. <br>
     */
    private static final int PRINCIPAL_X = 600;
    /**
     * Bounds Y principal. <br>
     */
    private static final int PRINCIPAL_Y = 600;
    /**
     * Bounds Width principal. <br>
     */
    private static final int PRINCIPAL_WIDTH = 600;
    /**
     * Bounds Height principal. <br>
     */
    private static final int PRINCIPAL_HEIGHT = 600;
    /**
     * Bounds X del location. <br>
     */
    private static final int LOCATION_X = 900;
    /**
     * Bounds Y del location. <br>
     */
    private static final int LOCATION_Y = 140;

    /**
     * Crea el menú del inventario. <br>
     *
     * @param cliente
     *            Cliente que invoca el menú. <br>
     */
    public MenuInventario(final Cliente cliente) {
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    Gson gson = new Gson();
                    cliente.getPaquetePersonaje()
                            .setComando(Comando.ACTUALIZARINVENTARIO);
                    cliente.getSalida().writeObject(
                            gson.toJson(cliente.getPaquetePersonaje()));
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null,
                            "Error al actualizar inventario");
                }
                Pantalla.menuInventario = null;
                dispose();
            }
        });
        this.setTitle("Inventario");
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            this.setLayout(new BorderLayout());
            this.add(new Inventario(cliente.getPaquetePersonaje()));
            this.add(cancelar, BorderLayout.AFTER_LAST_LINE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Falló al iniciar el inventario");

        }
        this.setBounds(PRINCIPAL_X, PRINCIPAL_Y, PRINCIPAL_WIDTH,
                PRINCIPAL_HEIGHT);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setLocation(LOCATION_X, LOCATION_Y);
        this.setResizable(false);
        this.setVisible(true);
    }
}
