package inventario;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dominio.Item;
import mensajeria.PaquetePersonaje;
import recursos.Recursos;

/**
 * Clase que administra las celdas del inventario. <br>
 */
@SuppressWarnings("serial")
public class Celda extends JPanel {
    /**
     * Imágen del item. <br>
     */
    private BufferedImage item;
    /**
     * Personaje que poseé el item. <br>
     */
    private PaquetePersonaje paquetePersonaje;
    /**
     * Label del item. <br>
     */
    private JLabel label;
    /**
     * Item. <br>
     */
    private Item it;
    /**
     * Width del item. <br>
     */
    private static final int ITEM_WIDTH = 49;
    /**
     * Height del item. <br>
     */
    private static final int ITEM_HEIGHT = 49;
    /**
     * Width preferencial. <br>
     */
    private static final int PREFERRED_WIDTH = 60;
    /**
     * Height preferencial. <br>
     */
    private static final int PREFERRED_HEIGHT = 60;

    /**
     * Crea una celda para un item. <br>
     *
     * @param item
     *            Item. <br>
     * @param pckgPersonaje
     *            Personaje que posee el item. <br>
     * @throws IOException
     *             El path de la imágen del archivo es errónea. <br>
     */
    public Celda(final Item item, final PaquetePersonaje pckgPersonaje)
            throws IOException {
        this.item = item.getImagenItem();
        it = item;
        this.paquetePersonaje = pckgPersonaje;
        label = new JLabel(new ImageIcon(this.item.getScaledInstance(ITEM_WIDTH,
                ITEM_HEIGHT, Image.SCALE_DEFAULT)));
        actionListenersYLabel(item);
    }

    /**
     * Crea una celda de item vacía. <br>
     */
    public Celda() {
        label = new JLabel(new ImageIcon(Recursos.getNoItem().getScaledInstance(
                ITEM_WIDTH, ITEM_HEIGHT, Image.SCALE_DEFAULT)));
        add(label);
    }

    /**
     * Muestra los modificadores de stats del item. <br>
     *
     * @param it
     *            Item del inventario. <br>
     */
    private void actionListenersYLabel(final Item it) {
        StringBuilder s = new StringBuilder();
        s.append("<html>" + it.getNombre() + "<br>");
        if (it.getBonusSalud() != 0) {
            s.append("+" + it.getBonusSalud() + " Salud " + "<br>");
        }
        if (it.getBonusEnergia() != 0) {
            s.append("+" + it.getBonusEnergia() + " Energia " + "<br>");
        }
        if (it.getBonusFuerza() != 0) {
            s.append("+" + it.getBonusFuerza() + " Fuerza " + "<br>");
        }
        if (it.getBonusDestreza() != 0) {
            s.append("+" + it.getBonusDestreza() + " Destreza " + "<br>");
        }
        if (it.getBonusInteligencia() != 0) {
            s.append("+" + it.getBonusInteligencia() + " Inteligencia");
        }
        s.append("</html>");
        label.setToolTipText(s.toString());
        label.addMouseListener(mouseListener);
        addMouseListener(mouseListener);
        add(label);
        this.validate();
        this.repaint();
    }

    /**
     * Resetea el label del item. <br>
     */
    protected final void resetLabel() {
        label.setIcon(new ImageIcon(Recursos.getNoItem().getScaledInstance(
                ITEM_WIDTH, ITEM_HEIGHT, Image.SCALE_DEFAULT)));
        label.setToolTipText(null);
        paquetePersonaje.removerItem(it);
        label.removeMouseListener(mouseListener);
        removeMouseListener(mouseListener);
    }

    /**
     * Establece las dimensiones preferenciales. <br>
     */
    @Override
    public final Dimension getPreferredSize() {
        return new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT);
    }

    /**
     * Devuelve el label del item. <br>
     *
     * @return Label del item. <br>
     */
    public final JLabel getLabel() {
        return label;
    }

    /**
     * Escucha del mouse sobre la celda. <br>
     */
    private MouseListener mouseListener = new MouseAdapter() {
        public void mouseClicked(final MouseEvent e) {
            Object[] options = {"Tirar", "Cancelar"};
            if (e.getClickCount() == 2) {
                int answer = JOptionPane.showOptionDialog(getParent(),
                        "¿Qué desea hacer?", "Item: " + it.getNombre(),
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
                // Tirar
                if (answer == 0) {
                    paquetePersonaje.sacarBonus(it.getBonusSalud(),
                            it.getBonusEnergia(), it.getBonusFuerza(),
                            it.getBonusDestreza(), it.getBonusInteligencia());
                    resetLabel();
                }
            }
        }
    };
}
