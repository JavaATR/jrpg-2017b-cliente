package comandos;

import java.io.IOException;

import javax.swing.JOptionPane;

import mensajeria.Comando;
import mensajeria.Paquete;

/**
 * Clase que administra el comando de desconexión del cliente. <br>
 */
public class Salir extends ComandosCliente {
    /**
     * Ejecuta la desconexión del servidor. <br>
     */
    @Override
    public final void ejecutar() {
        try {
            cliente.getPaqueteUsuario().setInicioSesion(false);
            cliente.getSalida().writeObject(gson
                    .toJson(new Paquete(Comando.DESCONECTAR), Paquete.class));
            cliente.getSocket().close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al salir");
        }
    }
}
