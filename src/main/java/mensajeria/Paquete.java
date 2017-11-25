package mensajeria;

import java.io.Serializable;

import javax.swing.JOptionPane;

/**
 * Clase Paquete.
 */
public class Paquete implements Serializable, Cloneable {

    /** Atributo msj exito. */
    public static String msjExito = "1";

    /** Atributo msj fracaso. */
    public static String msjFracaso = "0";

    /** Atributo mensaje. */
    private String mensaje;

    /** Atributo ip. */
    private String ip;

    /** Atributo comando. */
    private int comando;

    /**
     * Constructor new paquete.
     */
    public Paquete() {

    }

    /**
     * Constructor parametrizado paquete. <br>
     *
     * @param msj
     *            Valor para asignar mensaje.
     * @param nick
     *            Valor para asignar nick.
     * @param ipNumber
     *            Valor para asignar ip.
     * @param command
     *            Valor para asignar comando. <br>
     */
    public Paquete(final String msj, final String nick, final String ipNumber,
            final int command) {
        this.mensaje = msj;
        this.ip = ipNumber;
        this.comando = command;
    }

    /**
     * Constructor parametrizado paquete. <br>
     *
     * @param msj
     *            Valor para asignar mensaje.
     * @param command
     *            Valor para asignar comando. <br>
     */
    public Paquete(final String msj, final int command) {
        this.mensaje = msj;
        this.comando = command;
    }

    /**
     * Constructor parametrizado paquete. <br>
     *
     * @param command
     *            Valor para asignar comando. <br>
     */
    public Paquete(final int command) {
        this.comando = command;
    }

    /**
     * Asignar mensaje. <br>
     *
     * @param msj
     *            Valor para asignar mensaje. <br>
     */
    public void setMensaje(final String msj) {
        this.mensaje = msj;
    }

    /**
     * Asignar ip. <br>
     *
     * @param ipNumber
     *            Valor para asignar ip. <br>
     */
    public final void setIp(final String ipNumber) {
        this.ip = ipNumber;
    }

    /**
     * Asignar comando. <br>
     *
     * @param command
     *            Valor para asignar comando. <br>
     */
    public final void setComando(final int command) {
        this.comando = command;
    }

    /**
     * Obtener mensaje.
     *
     * @return mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Obtener ip.
     *
     * @return ip
     */
    public final String getIp() {
        return ip;
    }

    /**
     * Obtener comando.
     *
     * @return comando
     */
    public final int getComando() {
        return comando;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException ex) {
            JOptionPane.showMessageDialog(null, "Error al clonar");

        }
        return obj;
    }

    /**
     * Obtener objeto.
     *
     * @param nombrePaquete
     *            String con el nombre del paquete.
     * @return the objeto
     */
    public final Comando getObjeto(final String nombrePaquete) {
        try {
            Comando c;
            c = (Comando) Class
                    .forName(nombrePaquete + "." + Comando.CLASSNAMES[comando])
                    .newInstance();
            return c;
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException e) {
            return null;
        }

    }

    /**
     * Obtener objeto set.
     *
     * @param nombrePaquete
     *            String con el nombre del paquete.
     * @param accion
     *            Entero con el valor de la acción.
     * @return objeto set
     */
    public final static Comando getObjetoSet(final String nombrePaquete,
            final int accion) {
        try {
            Comando c;
            c = (Comando) Class
                    .forName(
                            nombrePaquete + "." + Comando.CLASSNAMESBIS[accion])
                    .newInstance();
            return c;
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException e) {
            return null;
        }

    }

}
