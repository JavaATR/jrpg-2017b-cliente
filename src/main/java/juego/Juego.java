package juego;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import chat.MiChat;
import cliente.Cliente;
import cliente.EscuchaMensajes;
import dominio.Personaje;
import estados.Estado;
import estados.EstadoBatalla;
import estados.EstadoJuego;
import mensajeria.PaqueteEnemigo;
import mensajeria.PaqueteMovimiento;
import mensajeria.PaquetePersonaje;

/**
 * Clase que administra el juego a nivel interfaz visual. <br>
 */
public class Juego implements Runnable {

    /** Constante DIR. */
    private static final int DIR = 6;
    /** Constante NUM_BUFFERS. */
    private static final int NUM_BUFFERS = 3;
    /** Constante FONT_SIZE. */
    private static final int FONT_SIZE = 15;
    /** Constante FPS. */
    private static final int FPS = 60;
    /** Constante TIEMPO_POR_ACTUALIZACION. */
    private static final int TIEMPO_POR_ACTUALIZACION = 1000000000;
    /** Constante TIMER. */
    private static final int TIMER = 1000000000;
    /**
     * Pantalla del usuario. <br>
     */
    private Pantalla pantalla;
    /**
     * Nombre del juego. <br>
     */
    private final String nombre;
    /**
     * Ancho de pantalla. <br>
     */
    private final int ancho;
    /**
     * Alto de pantalla. <br>
     */
    private final int alto;
    /**
     * Hilo del usuario. <br>
     */
    private Thread hilo;
    /**
     * Indicador de juego activo. <br>
     */
    private boolean corriendo;
    /**
     * Estrategia para graficar mediante buffers (Primero se "grafica" en el/los
     * buffer/s y finalmente en el canvas).<br>
     */
    private BufferStrategy bs;
    /**
     * Graficador. <br>
     */
    private Graphics g;
    /**
     * Estado del jugador general. <br>
     */
    private Estado estadoJuego;
    /**
     * Estado del jugador en batalla. <br>
     */
    private Estado estadoBatalla;
    /**
     * Sensor de mouse. <br>
     */
    private HandlerMouse handlerMouse;
    /**
     * Posición de la camara del jugador. <br>
     */
    private Camara camara;
    /**
     * Cliente del usuario. <br>
     */
    private Cliente cliente;
    /**
     * Receptor de mensajes del usuario. <br>
     */
    private EscuchaMensajes escuchaMensajes;
    /**
     * Personaje del usuario. <br>
     */
    private PaquetePersonaje paquetePersonaje;
    /**
     * Controlador de posición del personaje. <br>
     */
    private PaqueteMovimiento ubicacionPersonaje;
    /**
     * Controlador de posición de los enemigos. <br>
     */
    private PaqueteMovimiento ubicacionEnemigo;
    /**
     * Personajes conectados en el juego. <br>
     */
    private Map<Integer, PaquetePersonaje> personajesConectados;
    /**
     * Enemigos conectados en el juego. <br>
     */
    private Map<Integer, PaqueteEnemigo> enemigosConectados;
    /**
     * Ubicación de los personajes en el juego. <br>
     */
    private Map<Integer, PaqueteMovimiento> ubicacionPersonajes;
    /**
     * Ubicación de los enemigos en el juego. <br>
     */
    private Map<Integer, PaqueteMovimiento> ubicacionEnemigos;
    /**
     * Controlador de los chats activos. <br>
     */
    private Map<String, MiChat> chatsActivos = new HashMap<>();
    /**
     * Cargador de recursos del juego. <br>
     */
    private CargarRecursos cargarRecursos;

    /**
     * Crea un juego para el usuario. <br>
     *
     * @param name
     *            Nombre del juego. <br>
     * @param width
     *            Ancho de pantalla. <br>
     * @param height
     *            Alto de pantalla. <br>
     * @param client
     *            Usuario. <br>
     * @param pp
     *            Personaje del usuario. <br>
     */
    public Juego(final String name, final int width, final int height,
            final Cliente client, final PaquetePersonaje pp) {
        this.nombre = name;
        this.alto = height;
        this.ancho = width;
        this.cliente = client;
        this.paquetePersonaje = pp;
        // Inicializo la ubicacion del personaje
        ubicacionPersonaje = new PaqueteMovimiento();
        ubicacionPersonaje.setIdPersonaje(paquetePersonaje.getId());
        ubicacionPersonaje.setFrame(0);
        ubicacionPersonaje.setDireccion(DIR);
        // Creo el escucha de mensajes
        escuchaMensajes = new EscuchaMensajes(this);
        escuchaMensajes.start();
        handlerMouse = new HandlerMouse();
        iniciar();
        cargarRecursos = new CargarRecursos(client);
        cargarRecursos.start();
    }

    /**
     * Carga lo necesario para inicial el juego. <br>
     */
    public final void iniciar() {
        pantalla = new Pantalla(nombre, ancho, alto, cliente);
        pantalla.getCanvas().addMouseListener(handlerMouse);
        camara = new Camara(this, 0, 0);
        Personaje.cargarTablaNivel();
    }

    /**
     * Actualiza los objetos y sus posiciones. <br>
     */
    private void actualizar() {
        if (Estado.getEstado() != null) {
            Estado.getEstado().actualizar();
        }
    }

    /**
     * Grafica los objetos y sus posiciones. <br>
     */
    private void graficar() {
        bs = pantalla.getCanvas().getBufferStrategy();
        if (bs == null) { // Seteo una estrategia para el canvas en caso de que
                          // no tenga una
            pantalla.getCanvas().createBufferStrategy(NUM_BUFFERS);
            return;
        }
        g = bs.getDrawGraphics(); // Permite graficar el buffer mediante g
        g.clearRect(0, 0, ancho, alto); // Limpiamos la pantalla
        // Graficado de imagenes
        g.setFont(new Font("Book Antiqua", 1, FONT_SIZE));
        if (Estado.getEstado() != null) {
            Estado.getEstado().graficar(g);
        }
        // Fin de graficado de imagenes
        bs.show(); // Hace visible el próximo buffer disponible
        g.dispose();
    }

    /**
     * Hilo principal del juego. <br>
     */
    @Override
    public final void run() {
        int fps = FPS; // Cantidad de actualizaciones por segundo que se desean
        double tiempoPorActualizacion = TIEMPO_POR_ACTUALIZACION / fps; // Cantidad
                                                                        // de
        // nanosegundos en
        // FPS deseados
        double delta = 0;
        long ahora;
        long ultimoTiempo = System.nanoTime();
        long timer = 0; // Timer para mostrar fps cada un segundo
        int actualizaciones = 0; // Cantidad de actualizaciones que se realizan
                                 // realmente
        while (corriendo) {
            ahora = System.nanoTime();
            delta += (ahora - ultimoTiempo) / tiempoPorActualizacion; // Calculo
                                                                      // para
                                                                      // determinar
                                                                      // cuando
                                                                      // realizar
                                                                      // la
                                                                      // actualizacion
                                                                      // y el
                                                                      // graficado
            timer += ahora - ultimoTiempo; // Sumo el tiempo transcurrido hasta
                                           // que se acumule 1 segundo y
                                           // mostrar los FPS
            ultimoTiempo = ahora; // Para las proximas corridas del bucle
            if (delta >= 1) {
                actualizar();
                graficar();
                actualizaciones++;
                delta--;
            }
            if (timer >= TIMER) { // Si paso 1 segundo muestro los FPS
                pantalla.getFrame()
                        .setTitle(nombre + " | " + "FPS: " + actualizaciones);
                actualizaciones = 0;
                timer = 0;
            }
        }
        stop();
    }

    /**
     * Hilo principal del juego. <br>
     */
    public synchronized void start() { // Inicia el juego
        if (corriendo) {
            return;
        }
        estadoJuego = new EstadoJuego(this);
        Estado.setEstado(estadoJuego);
        pantalla.mostrar();
        corriendo = true;
        hilo = new Thread(this);
        hilo.start();
    }

    /**
     * Detiene el juego. <br>
     */
    public synchronized void stop() { // Detiene el juego
        if (!corriendo) {
            return;
        }
        try {
            corriendo = false;
            hilo.join();
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null,
                    "Fallo al intentar detener el juego.");
        }
    }

    /**
     * Devuelve el ancho de pantalla. <br>
     *
     * @return Ancho. <br>
     */
    public final int getAncho() {
        return ancho;
    }

    /**
     * Devuelve el alto de pantalla. <br>
     *
     * @return Alto. <br>
     */
    public final int getAlto() {
        return alto;
    }

    /**
     * Devuelve posición del mouse. <br>
     *
     * @return Mouse. <br>
     */
    public final HandlerMouse getHandlerMouse() {
        return handlerMouse;
    }

    /**
     * Devuelve la posición actual de la cámara. <br>
     *
     * @return Posición cámara. <br>
     */
    public final Camara getCamara() {
        return camara;
    }

    /**
     * Devuelve el estado del juego. <br>
     *
     * @return Estado del juego. <br>
     */
    public final EstadoJuego getEstadoJuego() {
        return (EstadoJuego) estadoJuego;
    }

    /**
     * Devuelve el estado de batalla. <br>
     *
     * @return Estado de batalla. <br>
     */
    public final EstadoBatalla getEstadoBatalla() {
        return (EstadoBatalla) estadoBatalla;
    }

    /**
     * Establece el estado de batalla del juego. <br>
     *
     * @param battleStatus
     *            Estado de batalla. <br>
     */
    public final void setEstadoBatalla(final EstadoBatalla battleStatus) {
        this.estadoBatalla = battleStatus;
    }

    /**
     * Devuelve el cliente del usuario. <br>
     *
     * @return Cliente. <br>
     */
    public final Cliente getCliente() {
        return cliente;
    }

    /**
     * Devuelve el mensaje actual del cliente. <br>
     *
     * @return Mensaje. <br>
     */
    public final EscuchaMensajes getEscuchaMensajes() {
        return escuchaMensajes;
    }

    /**
     * Devuelve al personaje del usuario. <br>
     *
     * @return Personaje. <br>
     */
    public final PaquetePersonaje getPersonaje() {
        return paquetePersonaje;
    }

    /**
     * Devuelve la ubicación del personaje. <br>
     *
     * @return Ubicación del personaje. <br>
     */
    public final PaqueteMovimiento getUbicacionPersonaje() {
        return ubicacionPersonaje;
    }

    /**
     * Devuelve la ubicación del enemigo. <br>
     *
     * @return Ubicación del enemigo. <br>
     */
    public final PaqueteMovimiento getUbicacionEnemigo() {
        return ubicacionEnemigo;
    }

    /**
     * Establece el personaje del jugador. <br>
     *
     * @param pckgPersonaje
     *            Personaje. <br>
     */
    public final void setPersonaje(final PaquetePersonaje pckgPersonaje) {
        this.paquetePersonaje = pckgPersonaje;
    }

    /**
     * Actualiza la condición actual del personaje. <br>
     */
    public final void actualizarPersonaje() {
        paquetePersonaje = (PaquetePersonaje) (personajesConectados
                .get(paquetePersonaje.getId()).clone());
    }

    /**
     * Devuelve los personajes conectados al juego. <br>
     *
     * @return Personajes conectados. <br>
     */
    public final Map<Integer, PaquetePersonaje> getPersonajesConectados() {
        return personajesConectados;
    }

    /**
     * Establece los personajes conectados. <br>
     *
     * @param map
     *            Personajes conectados. <br>
     */
    public final void setPersonajesConectados(
            final Map<Integer, PaquetePersonaje> map) {
        this.personajesConectados = map;
    }

    /**
     * Devuelve los enemigos conectados al juego. <br>
     *
     * @return Enemigos conectados. <br>
     */
    public final Map<Integer, PaqueteEnemigo> getEnemigosConectados() {
        return enemigosConectados;
    }

    /**
     * Establece los enemigos conectados. <br>
     *
     * @param map
     *            Enemigos conectados. <br>
     */
    public final void setEnemigosConectados(
            final Map<Integer, PaqueteEnemigo> map) {
        this.enemigosConectados = map;
    }

    /**
     * Devuelve la ubicación de los personajes. <br>
     *
     * @return Ubicación de los personajes. <br>
     */
    public final Map<Integer, PaqueteMovimiento> getUbicacionPersonajes() {
        return ubicacionPersonajes;
    }

    /**
     * Establece la ubicación de los personajes. <br>
     *
     * @param locationPersonajes
     *            Ubicación de los personajes. <br>
     */
    public final void setUbicacionPersonajes(
            final Map<Integer, PaqueteMovimiento> locationPersonajes) {
        this.ubicacionPersonajes = locationPersonajes;
    }

    /**
     * Devuelve la ubicación de los enemigos. <br>
     *
     * @return Ubicación de los enemigos. <br>
     */
    public final Map<Integer, PaqueteMovimiento> getUbicacionEnemigos() {
        return ubicacionEnemigos;
    }

    /**
     * Establece la ubicación de los enemigos. <br>
     *
     * @param locationEnemigos
     *            Ubicación de los enemigos. <br>
     */
    public final void setUbicacionEnemigos(
            final Map<Integer, PaqueteMovimiento> locationEnemigos) {
        this.ubicacionEnemigos = locationEnemigos;
    }

    /**
     * Devuelve los chats activos. <br>
     *
     * @return Chats activos. <br>
     */
    public final Map<String, MiChat> getChatsActivos() {
        return chatsActivos;
    }
}
