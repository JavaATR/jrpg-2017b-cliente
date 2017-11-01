package juego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que "escucha" las acciones del mouse. <br>
 */
public class HandlerMouse implements MouseListener {
    /**
     * Posición del mouse. <br>
     */
    private int posMouse[];
    /**
     * Recorrido del mouse. <br>
     */
    private int posMouseRecorrido[];
    /**
     * Indicador de si hubo un nuevo recorrido. <br>
     */
    private boolean nuevoRecorrido;
    /**
     * Indicador de si hubo un click. <br>
     */
    private boolean nuevoClick;

    /**
     * Crea un escucha de mouse. <br>
     */
    public HandlerMouse() {
        posMouse = new int[2];
        posMouseRecorrido = new int[2];
    }

    /**
     * Establece el comportamiento a realizar presionado los botones del mouse.
     * <br>
     */
    @Override
    public final void mouseClicked(final MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            posMouse[0] = e.getX();
            posMouse[1] = e.getY();
            nuevoClick = true;
        } else {
            if (e.getButton() == MouseEvent.BUTTON3) {
                posMouseRecorrido[0] = e.getX();
                posMouseRecorrido[1] = e.getY();
                nuevoRecorrido = true;
            }
        }
    }

    /**
     * NULL. <br>
     */
    @Override
    public void mouseEntered(final MouseEvent arg0) {

    }

    /**
     * NULL. <br>
     */
    @Override
    public void mouseExited(final MouseEvent arg0) {

    }

    /**
     * NULL. <br>
     */
    @Override
    public void mousePressed(final MouseEvent arg0) {

    }

    /**
     * NULL. <br>
     */
    @Override
    public void mouseReleased(final MouseEvent arg0) {

    }

    /**
     * Devuelve la posición del mouse. <br>
     *
     * @return Posición del mouse. <br>
     */
    public int[] getPosMouse() {
        return posMouse;
    }

    /**
     * Devuelve el recorrido del mouse. <br>
     *
     * @return Recorrido mouse. <br>
     */
    public int[] getPosMouseRecorrido() {
        return posMouseRecorrido;
    }

    /**
     * Devuelve si hay un nuevo recorrido del mouse. <br>
     *
     * @return <b>true</b> si lo hay.<br>
     *         <b>false</b> de lo contrario. <br>
     */
    public final boolean getNuevoRecorrido() {
        return nuevoRecorrido;
    }

    /**
     * Establece si el mouse tiene un nuevo recorrido. <br>
     *
     * @param b
     *            Indicador de nuevo camino. <br>
     */
    public final void setNuevoRecorrido(final boolean b) {
        nuevoRecorrido = b;
    }

    /**
     * Devuelve si hubo un nuevo click del mouse. <br>
     *
     * @return <b>true</b> si lo hay.<br>
     *         <b>false</b> de lo contrario. <br>
     */
    public final boolean getNuevoClick() {
        return nuevoClick;
    }

    /**
     * Establece si hubo un nuevo click. <br>
     *
     * @param b
     *            Indicador de si hubo un nuevo click. <br>
     */
    public final void setNuevoClick(final boolean b) {
        nuevoClick = b;
    }
}
