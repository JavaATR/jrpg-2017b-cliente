package cliente;

import java.io.ObjectInputStream;
import java.util.HashMap;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import comandos.ComandosEscucha;
import juego.Juego;
import mensajeria.Comando;
import mensajeria.Paquete;
import mensajeria.PaqueteEnemigo;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;

/**
 * La clase EscuchaMensajes tiene como función esuchar los mensajes que se
 * enviaran al servidor. <br>
 */
public class EscuchaMensajes extends Thread {
    /**
     * Juego del cliente. <br>
     */
    private Juego juego;
    /**
     * Cliente. <br>
     */
    private Cliente cliente;
    /**
     * Entada. <br>
     */
    private ObjectInputStream entrada;
    /**
     * Gson. <br>
     */
    private final Gson gson = new Gson();

    /**
     * Constructor de EsuchaMensaje. <br>
     *
     * @param game
     *            juego del que se escucha el mensaje. <br>
     */
    public EscuchaMensajes(final Juego game) {
        this.juego = game;
        cliente = game.getCliente();
        entrada = cliente.getEntrada();
    }

    /**
     * Corre el escucha de mensajes. <br>
     */
    @Override
    public final void run() {
        try {
            Paquete paquete;
            ComandosEscucha comand;
            juego.setPersonajesConectados(
                    new HashMap<Integer, PaquetePersonaje>());
            juego.setUbicacionPersonajes(
                    new HashMap<Integer, PaqueteMovimiento>());
            juego.setEnemigosConectados(new HashMap<Integer, PaqueteEnemigo>());
            juego.setUbicacionEnemigos(
                    new HashMap<Integer, PaqueteMovimiento>());
            while (true) {
                String objetoLeido = (String) entrada.readObject();
                paquete = gson.fromJson(objetoLeido, Paquete.class);
                comand = (ComandosEscucha) paquete
                        .getObjeto(Comando.NOMBREPAQUETE);
                comand.setJuego(juego);
                comand.setCadena(objetoLeido);
                comand.ejecutar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Fallo la conexión con el servidor.");
        }
    }
}
