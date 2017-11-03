package cliente;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import comandos.ComandosCliente;
import frames.MenuCarga;
import frames.MenuComerciar;
import frames.MenuJugar;
import frames.MenuMapas;
import juego.Juego;
import mensajeria.Comando;
import mensajeria.Paquete;
import mensajeria.PaqueteComerciar;
import mensajeria.PaqueteMensaje;
import mensajeria.PaquetePersonaje;
import mensajeria.PaqueteUsuario;

/**
 * La clase Cliente tiene como función ejecutar el cliente. <br>
 */
public class Cliente extends Thread {
    /**
     * Socket del cliente. <br>
     */
    private Socket cliente;
    /**
     * IP del cliente. <br>
     */
    private String miIp;
    /**
     * Entrada. <br>
     */
    private ObjectInputStream entrada;
    /**
     * Salida. <br>
     */
    private ObjectOutputStream salida;
    /**
     * Gson. <br>
     */
    private final Gson gson = new Gson();
    /**
     * Usuario del cliente. <br>
     */
    private PaqueteUsuario paqueteUsuario;
    /**
     * Personaje del cliente. <br>
     */
    private PaquetePersonaje paquetePersonaje;
    /**
     * Comercio. <br>
     */
    private PaqueteComerciar paqueteComercio;
    /**
     * Mensajería. <br>
     */
    private PaqueteMensaje paqueteMensaje = new PaqueteMensaje();
    /**
     * Acción del cliente. <br>
     */
    private int accion;
    /**
     * Menú de comerciar. <br>
     */
    private MenuComerciar m1;
    /**
     * IP del juego. <br>
     */
    private String ip;
    /**
     * Defino de donde se saca el puerto del juego. <br>
     */
    Properties prop = new Properties();
    {
        try {
            prop.load(new FileInputStream("puerto.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Puerto del cliente. <br>
     */
    private final int puerto = Integer.valueOf(prop.getProperty("puerto"));
    /**
     * Juego. <br>
     */
    private Juego wome;
    /**
     * Menú de carga. <br>
     */
    private MenuCarga menuCarga;
    /**
     * Ancho de pantalla. <br>
     */
    private static final int ANCHO = 800;
    /**
     * Largo de pantalla. <br>
     */
    private static final int LARGO = 600;

    /**
     * Constructor del Cliente. <br>
     */
    public Cliente() {
        ip = JOptionPane.showInputDialog(
                "Ingrese IP del servidor: (default localhost)");
        if (ip == null) {
            ip = "localhost";
        }
        try {
            cliente = new Socket(ip, puerto);
            miIp = cliente.getInetAddress().getHostAddress();
            entrada = new ObjectInputStream(cliente.getInputStream());
            salida = new ObjectOutputStream(cliente.getOutputStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Fallo al iniciar la aplicación. "
                            + "Revise la conexión con el servidor.");
            System.exit(1);
        }
    }

    /**
     * Crea el cliente con sus configuraciones. <br>
     *
     * @param ipNumber
     *            IP del cliente. <br>
     * @param port
     *            Puerto del cliente. <br>
     */
    public Cliente(final String ipNumber, final int port) {
        try {
            cliente = new Socket(ipNumber, port);
            miIp = cliente.getInetAddress().getHostAddress();
            entrada = new ObjectInputStream(cliente.getInputStream());
            salida = new ObjectOutputStream(cliente.getOutputStream());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Fallo al iniciar la aplicación. "
                            + "Revise la conexión con el servidor.");
            System.exit(1);
        }
    }

    /**
     * Corre el cliente. <br>
     */
    @Override
    public final void run() {
        synchronized (this) {
            try {
                ComandosCliente comand;
                // Creo el paquete que le voy a enviar al servidor
                paqueteUsuario = new PaqueteUsuario();
                MenuJugar menuJugar = null;
                while (!paqueteUsuario.isInicioSesion()) {
                    // Muestro el menú principal
                    if (menuJugar == null) {
                        menuJugar = new MenuJugar(this);
                        menuJugar.setVisible(true);
                        // Creo los paquetes que le voy a enviar al servidor
                        paqueteUsuario = new PaqueteUsuario();
                        paquetePersonaje = new PaquetePersonaje();
                        // Espero a que el usuario seleccione alguna accion
                        wait();
                        comand = (ComandosCliente) Paquete.getObjetoSet(
                                Comando.NOMBREPAQUETE, getAccion());
                        comand.setCadena(null);
                        comand.setCliente(this);
                        comand.ejecutar();
                        // Le envio el paquete al servidor
                        salida.writeObject(gson.toJson(paqueteUsuario));
                    }
                    // Recibo el paquete desde el servidor
                    String cadenaLeida = (String) entrada.readObject();
                    Paquete paquete = gson.fromJson(cadenaLeida, Paquete.class);
                    comand = (ComandosCliente) paquete
                            .getObjeto(Comando.NOMBREPAQUETE);
                    comand.setCadena(cadenaLeida);
                    comand.setCliente(this);
                    comand.ejecutar();
                }
                // Creo un paquete con el comando mostrar mapas
                paquetePersonaje.setComando(Comando.MOSTRARMAPAS);
                // Abro el menu de eleccion del mapa
                MenuMapas menuElegirMapa = new MenuMapas(this);
                menuElegirMapa.setVisible(true);
                // Espero a que el usuario elija el mapa
                wait();
                // Si clickeo en la Cruz al Seleccionar mapas
                if (paquetePersonaje.getMapa() == 0) {
                    paquetePersonaje.setComando(Comando.DESCONECTAR);
                    salida.writeObject(gson.toJson(paquetePersonaje));
                } else {
                    // Establezco el mapa en el paquete personaje
                    paquetePersonaje.setIp(miIp);
                    // Le envio el paquete con el mapa seleccionado
                    salida.writeObject(gson.toJson(paquetePersonaje));
                    // Instancio el juego y cargo los recursos
                    wome = new Juego("World Of the Middle Earth", ANCHO, LARGO,
                            this, paquetePersonaje);
                    // Muestro el menu de carga
                    menuCarga = new MenuCarga(this);
                    menuCarga.setVisible(true);
                    // Espero que se carguen todos los recursos
                    wait();
                    // Inicio el juego
                    wome.start();
                    // Finalizo el menu de carga
                    menuCarga.dispose();
                }
            } catch (IOException | InterruptedException
                    | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null,
                        "Fallo la conexión con el servidor durante el inicio de sesión.");
                System.exit(1);
            }
        }
    }

    /**
     * Devuelve el cliente. <br>
     *
     * @return Cliente. <br>
     */
    public final Socket getSocket() {
        return cliente;
    }

    /**
     * Establece el cliente. <br>
     *
     * @param client
     *            Cliente. <br>
     */
    public final void setSocket(final Socket client) {
        this.cliente = client;
    }

    /**
     * Devuelve la acción. <br>
     *
     * @return Acción. <br>
     */
    public final int getAccion() {
        return accion;
    }

    /**
     * Establece la acción. <br>
     *
     * @param action
     *            Acción. <br>
     */
    public final void setAccion(final int action) {
        this.accion = action;
    }

    /**
     * Devuelve la IP. <br>
     *
     * @return IP. <br>
     */
    public final String getMiIp() {
        return miIp;
    }

    /**
     * Establece la IP. <br>
     *
     * @param myIp
     *            IP. <br>
     */
    public final void setMiIp(final String myIp) {
        this.miIp = myIp;
    }

    /**
     * Devuelve la entrada. <br>
     *
     * @return Entrada. <br>
     */
    public final ObjectInputStream getEntrada() {
        return entrada;
    }

    /**
     * Establece la entrada. <br>
     *
     * @param entrance
     *            Entrada. <br>
     */
    public final void setEntrada(final ObjectInputStream entrance) {
        this.entrada = entrance;
    }

    /**
     * Devuelve la salida. <br>
     *
     * @return Salida. <br>
     */
    public final ObjectOutputStream getSalida() {
        return salida;
    }

    /**
     * Establece la salida. <br>
     *
     * @param exit
     *            Salida. <br>
     */
    public final void setSalida(final ObjectOutputStream exit) {
        this.salida = exit;
    }

    /**
     * Devuelve el usuario del cliente. <br>
     *
     * @return Usuario del cliente. <br>
     */
    public final PaqueteUsuario getPaqueteUsuario() {
        return paqueteUsuario;
    }

    /**
     * Devuelve el personaje del cliente. <br>
     *
     * @return Personaje del cliente. <br>
     */
    public final PaquetePersonaje getPaquetePersonaje() {
        return paquetePersonaje;
    }

    /**
     * Devuelve el juego. <br>
     *
     * @return Juego. <br>
     */
    public final Juego getJuego() {
        return wome;
    }

    /**
     * Devuelve el menú de carga. <br>
     *
     * @return Menú de carga. <br>
     */
    public final MenuCarga getMenuCarga() {
        return menuCarga;
    }

    /**
     * Actualiza los items del personaje del cliente. <br>
     *
     * @param paqueteActualizado
     *            Personaje del cliente. <br>
     */
    public final void actualizarItems(
            final PaquetePersonaje paqueteActualizado) {
        if (paquetePersonaje.getCantItems() != 0 && paquetePersonaje
                .getCantItems() != paqueteActualizado.getCantItems()) {
            paquetePersonaje.anadirItem(paqueteActualizado.getItems()
                    .get(paqueteActualizado.getItems().size() - 1));
        }
    }

    /**
     * Sube el nivel del personaje del cliente. <br>
     */
    public final void subirDeNivel() {
        this.paquetePersonaje.subirDeNivel();
    }

    /**
     * Devuelve la IP. <br>
     *
     * @return IP. <br>
     */
    public final String getIp() {
        return ip;
    }

    /**
     * Actualiza al personaje del cliente. <br>
     *
     * @param pP
     *            Personaje del cliente. <br>
     */
    public final void actualizarPersonaje(final PaquetePersonaje pP) {
        paquetePersonaje = pP;
    }

    /**
     * Devuelve el juego del cliente. <br>
     *
     * @return Juego. <br>
     */
    public final Juego getWome() {
        return wome;
    }

    /**
     * Establece el juego del cliente. <br>
     *
     * @param game
     *            Juego. <br>
     */
    public final void setWome(final Juego game) {
        this.wome = game;
    }

    /**
     * Devuelve el puerto del cliente. <br>
     *
     * @return Puerto del cliente. <br>
     */
    public final int getPuerto() {
        return puerto;
    }

    /**
     * Establece el usuario del cliente. <br>
     *
     * @param pckgUsuario
     *            Usuario del cliente. <br>
     */
    public final void setPaqueteUsuario(final PaqueteUsuario pckgUsuario) {
        this.paqueteUsuario = pckgUsuario;
    }

    /**
     * Establece el personaje del cliente. <br>
     *
     * @param pckgPersonaje
     *            Personaje del cliente. <br>
     */
    public final void setPaquetePersonaje(
            final PaquetePersonaje pckgPersonaje) {
        this.paquetePersonaje = pckgPersonaje;
    }

    /**
     * Establece la IP del cliente. <br>
     *
     * @param ipNumber
     *            IP. <br>
     */
    public final void setIp(final String ipNumber) {
        this.ip = ipNumber;
    }

    /**
     * Establece el menú de carga del cliente. <br>
     *
     * @param cargaMenu
     *            Menú de carga. <br>
     */
    public final void setMenuCarga(final MenuCarga cargaMenu) {
        this.menuCarga = cargaMenu;
    }

    /**
     * Devuelve el menú de comerciar del cliente. <br>
     *
     * @return Menú de comerciar. <br>
     */
    public final MenuComerciar getM1() {
        return m1;
    }

    /**
     * Establece el menú de comerciar. <br>
     *
     * @param menu
     *            Menú de comerciar. <br>
     */
    public final void setM1(final MenuComerciar menu) {
        this.m1 = menu;
    }

    /**
     * Devuelve el comercio del cliente. <br>
     *
     * @return Comercio. <br>
     */
    public final PaqueteComerciar getPaqueteComercio() {
        return paqueteComercio;
    }

    /**
     * Establece el comercio del cliente. <br>
     *
     * @param pckgComercio
     *            Comercio. <br>
     */
    public final void setPaqueteComercio(final PaqueteComerciar pckgComercio) {
        this.paqueteComercio = pckgComercio;
    }

    /**
     * Devuelve la mensajería del cliente. <br>
     *
     * @return Mensajería. <br>
     */
    public final PaqueteMensaje getPaqueteMensaje() {
        return paqueteMensaje;
    }

    /**
     * Establece la mensajería del cliente. <br>
     *
     * @param pckgMensaje
     *            Mensajería. <br>
     */
    public final void setPaqueteMensaje(final PaqueteMensaje pckgMensaje) {
        this.paqueteMensaje = pckgMensaje;
    }
}
