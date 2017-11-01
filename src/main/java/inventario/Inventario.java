package inventario;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import dominio.Item;
import mensajeria.PaquetePersonaje;

/**
 * Clase que administra el inventario del personaje desde lo visual. <br>
 */
@SuppressWarnings("serial")
public class Inventario extends JPanel {
    /**
     * Cantidad de columnas del inventario. <br>
     */
    private static final int CANT_COLUMNAS = 3;
    /**
     * Cantidad de filas del inventario. <br>
     */
    private static final int CANT_FILAS = 3;
    /**
     * Items del inventario. <br>
     */
    private ArrayList<Item> items;

    /**
     * Crea el inventario del personaje. <br>
     *
     * @param paquetePersonaje
     *            Personaje. <br>
     * @throws IOException
     *             No se encuentra el recurso asociado al item. <br>
     */
    public Inventario(final PaquetePersonaje paquetePersonaje)
            throws IOException {
        setLayout(new GridBagLayout());
        items = new ArrayList<Item>(paquetePersonaje.getItems());
        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < CANT_FILAS; row++) {
            for (int col = 0; col < CANT_COLUMNAS; col++) {
                gbc.gridx = col;
                gbc.gridy = row;
                Celda cellPane;
                if (!items.isEmpty()) {
                    cellPane = new Celda(items.get(0), paquetePersonaje);
                    items.remove(0);
                } else {
                    cellPane = new Celda();
                }
                Border border = null;
                if (row < CANT_FILAS - 1) {
                    if (col < CANT_COLUMNAS - 1) {
                        border = new MatteBorder(1, 1, 0, 0, Color.DARK_GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 0, 1, Color.DARK_GRAY);
                    }
                } else {
                    if (col < CANT_COLUMNAS - 1) {
                        border = new MatteBorder(1, 1, 1, 0, Color.DARK_GRAY);
                    } else {
                        border = new MatteBorder(1, 1, 1, 1, Color.DARK_GRAY);
                    }
                }
                cellPane.setBorder(border);
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                gbc.fill = GridBagConstraints.BOTH;
                add(cellPane, gbc);
            }
        }
    }
}
