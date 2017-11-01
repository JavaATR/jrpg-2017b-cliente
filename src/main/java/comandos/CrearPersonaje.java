package comandos;

import javax.swing.JOptionPane;

import mensajeria.PaquetePersonaje;

/**
 * Clase que administra el comando de creación de personajes. <br>
 */
public class CrearPersonaje extends ComandosCliente {
    /**
     * Ejecuta la creación de personajes. <br>
     */
    @Override
    public final void ejecutar() {
        JOptionPane.showMessageDialog(null, "Registro exitoso.");
        cliente.setPaquetePersonaje((PaquetePersonaje) gson
                .fromJson(cadenaLeida, PaquetePersonaje.class));
        cliente.getPaqueteUsuario().setInicioSesion(true);
    }
}
