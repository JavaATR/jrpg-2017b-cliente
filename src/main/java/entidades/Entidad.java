package entidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import chat.VentanaContactos;
import estados.Estado;
import frames.MenuEscape;
import frames.MenuInventario;
import interfaz.MenuInfoPersonaje;
import juego.Juego;
import juego.Pantalla;
import mensajeria.PaqueteBatalla;
import mensajeria.PaqueteComerciar;
import mensajeria.PaqueteMovimiento;
import mundo.Grafo;
import mundo.Mundo;
import mundo.Nodo;
import recursos.Recursos;

/**
 * Clase Entidad.
 */
public class Entidad {

    /** The Constant OCHO. */
    private static final int OCHO = 8;
    /** The Constant FONT_SIZE_15. */
    private static final int FONT_SIZE_15 = 15;
    /** The Constant NUM_10. */
    private static final int NUM_10 = 10;
    /** The Constant NUM_20. */
    private static final int NUM_20 = 20;
    /** Constante _32. */
    private static final int NUM_32 = 32;
    /** Constante _1.5. */
    private static final double VAL_A_SUMAR = 1.5;

    /** Constante _29. */
    private static final int NUM_29 = 29;

    /** Constante _71. */
    private static final int NUM_71 = 71;

    /** Constante _44. */
    private static final int NUM_44 = 44;

    /** Constante _559. */
    private static final int NUM_559 = 559;

    /** Constante _524. */
    private static final int NUM_524 = 524;

    /** Constante _562. */
    private static final int NUM_562 = 562;

    /** Constante _105. */
    private static final int NUM_105 = 105;

    /** Constante _597. */
    private static final int NUM_597 = 597;

    /** Constante _545. */
    private static final int NUM_545 = 545;

    /** Constante _797. */
    private static final int NUM_797 = 797;

    /** Constante _738. */
    private static final int NUM_738 = 738;

    /** Constante SIETE. */
    private static final int SIETE = 7;

    /** Constante SEIS. */
    private static final int SEIS = 6;

    /** Constante CINCO. */
    private static final int CINCO = 5;

    /** Constante CUATRO. */
    private static final int CUATRO = 4;

    /** Constante TRES. */
    private static final int TRES = 3;

    /** Constante DIVISOR2. */
    private static final int DIVISOR2 = 64;

    /** Constante DIVISOR. */
    private static final int DIVISOR = 2;

    /** Constante MOV_HACIA. */
    private static final int MOV_HACIA = 6;

    /**
     * Juego. <br>
     */
    Juego juego;

    // Tamaño de la entidad
    /**
     * Ancho de la entidad. <br>
     */
    private int ancho;
    /**
     * Alto de la entidad. <br>
     */
    private int alto;

    // Posiciones
    /**
     * Punto X. <br>
     */
    private float x;
    /**
     * Punto Y. <br>
     */
    private float y;
    /**
     * Distancia X. <br>
     */
    private float dx;

    /**
     * Distancia Y: <br>
     * .
     */
    private float dy;
    /**
     * Inicio X. <br>
     */
    private float xInicio;
    /**
     * Inicio Y. <br>
     */
    private float yInicio;
    /**
     * X final. <br>
     */
    private float xFinal;
    /**
     * Y final. <br>
     */
    private float yFinal;
    /**
     * Offset X. <br>
     */
    private int xOffset;
    /**
     * Offset Y. <br>
     */
    private int yOffset;
    /**
     * Dibuja X. <br>
     */
    private int drawX;
    /**
     * Dibuja Y. <br>
     */
    private int drawY;
    /**
     * Posición mouse recorrido. <br>
     */
    private int[] posMouseRecorrido;
    /**
     * Posicón mouse. <br>
     */
    private int[] posMouse;
    /**
     * Tiles. <br>
     */
    private int[] tile;

    // Movimiento Actual
    /**
     * Dirección horizontal derecha. <br>
     */
    private static final int HORIZONTAL_DERECHA = 4;
    /**
     * Dirección horizontal izquierda. <br>
     */
    private static final int HORIZONTAL_IZQUIERDA = 0;
    /**
     * Dirección vertical superior. <br>
     */
    private static final int VERTICAL_SUPERIOR = 2;
    /**
     * Dirección vertical inferior. <br>
     */
    private static final int VERTICAL_INFERIOR = 6;
    /**
     * Dirección inferior izquierda. <br>
     */
    private static final int DIAGONAL_INFERIOR_IZQUIERDA = 7;
    /**
     * Dirección inferior derecha. <br>
     */
    private static final int DIAGONAL_INFERIOR_DERECHA = 5;
    /**
     * Dirección superior derecha. <br>
     */
    private static final int DIAGONAL_SUPERIOR_DERECHA = 3;
    /**
     * Dirección superior izquierda. <br>
     */
    private static final int DIAGONAL_SUPERIOR_IZQUIERDA = 1;
    /**
     * Dirección de movimiento hacia. <br>
     */
    private int movimientoHacia = MOV_HACIA;
    /**
     * Indicador de movimiento. <br>
     */
    private boolean enMovimiento;

    // Animacione
    /**
     * Animación de movimiento hacia la izquierda. <br>
     */
    private final Animacion moverIzq;
    /**
     * Animación de movimiento hacia la izquierda/arriba. <br>
     */
    private final Animacion moverArribaIzq;
    /**
     * Animación de movimiento hacia arriba. <br>
     */
    private final Animacion moverArriba;
    /**
     * Animación de movimiento hacia la derecha/arriba. <br>
     */
    private final Animacion moverArribaDer;
    /**
     * Animación de movimiento hacia la derecha. <br>
     */
    private final Animacion moverDer;
    /**
     * Animación de movimiento hacia la derecha/abajo. <br>
     */
    private final Animacion moverAbajoDer;
    /**
     * Animación de movimiento hacia abajo. <br>
     */
    private final Animacion moverAbajo;
    /**
     * Animación de movimiento hacia la izquierda/abajo. <br>
     */
    private final Animacion moverAbajoIzq;
    /**
     * Gson. <br>
     */
    private final Gson gson = new Gson();
    /**
     * Intervalo de envío. <br>
     */
    private int intervaloEnvio = 0;

    // pila de movimiento
    /**
     * Pila de tiles de movimiento. <br>
     */
    private PilaDeTiles pilaMovimiento;
    /**
     * Tile actual del personaje. <br>
     */
    private int[] tileActual;
    /**
     * Tile final del desplazamiento. <br>
     */
    private int[] tileFinal;
    /**
     * Tile de transición del personaje. <br>
     */
    private int[] tileMoverme;
    /**
     * Mundo del juego. <br>
     */
    private Mundo mundo;
    /**
     * Nombre del personaje. <br>
     */
    private String nombre;
    /**
     * Tile de los personajes conectados. <br>
     */
    private int[] tilePersonajes;
    /**
     * Tile de los personajes enemigos. <br>
     */
    private int[] tileEnemigos;
    /**
     * Id del enemigo. <br>
     */
    private int idEnemigo;

    // Ubicacion para abrir comerciar.
    /**
     * Comercio X. <br>
     */
    private float xComercio;
    /**
     * Comercio Y. <br>
     */
    private float yComercio;
    /**
     * Comercio. <br>
     */
    private float[] comercio;

    /**
     * Constructor de la clase Entidad.
     *
     * @param game
     *            juego con el que se instancia Entidad
     * @param world
     *            mundo con el que se instancia Entidad
     * @param width
     *            ancho
     * @param height
     *            alto
     * @param name
     *            nombre del personaje
     * @param spawnX
     *            tile X donde spawnea
     * @param spawnY
     *            tile Y donde spawnea
     * @param animaciones
     *            animaciones del personaje
     * @param velAnimacion
     *            velocidad de animacion del personaje
     */
    public Entidad(final Juego game, final Mundo world, final int width,
            final int height, final String name, final float spawnX,
            final float spawnY, final LinkedList<BufferedImage[]> animaciones,
            final int velAnimacion) {
        this.juego = game;
        this.ancho = width;
        this.alto = height;
        this.nombre = name;
        this.mundo = world;
        xOffset = width / DIVISOR;
        yOffset = height / DIVISOR;
        x = (int) (spawnX / DIVISOR2) * DIVISOR2;
        y = (int) (spawnY / (DIVISOR2 / DIVISOR)) * (DIVISOR2 / DIVISOR);

        moverIzq = new Animacion(velAnimacion, animaciones.get(0));
        moverArribaIzq = new Animacion(velAnimacion, animaciones.get(1));
        moverArriba = new Animacion(velAnimacion, animaciones.get(2));
        moverArribaDer = new Animacion(velAnimacion, animaciones.get(TRES));
        moverDer = new Animacion(velAnimacion, animaciones.get(CUATRO));
        moverAbajoDer = new Animacion(velAnimacion, animaciones.get(CINCO));
        moverAbajo = new Animacion(velAnimacion, animaciones.get(SEIS));
        moverAbajoIzq = new Animacion(velAnimacion, animaciones.get(SIETE));

        // Informo mi posicion actual
        game.getUbicacionPersonaje().setPosX(x);
        game.getUbicacionPersonaje().setPosY(y);
        game.getUbicacionPersonaje().setDireccion(getDireccion());
        game.getUbicacionPersonaje().setFrame(getFrame());
    }

    /**
     * Actualiza el personaje.
     */
    public final void actualizar() {

        if (enMovimiento) {
            moverIzq.actualizar();
            moverArribaIzq.actualizar();
            moverArriba.actualizar();
            moverArribaDer.actualizar();
            moverDer.actualizar();
            moverAbajoDer.actualizar();
            moverAbajo.actualizar();
            moverAbajoIzq.actualizar();
        } else {
            moverIzq.reset();
            moverArribaIzq.reset();
            moverArriba.reset();
            moverArribaDer.reset();
            moverDer.reset();
            moverAbajoDer.reset();
            moverAbajo.reset();
            moverAbajoIzq.reset();
        }

        getEntrada();
        mover();

        juego.getCamara().centrar(this);
    }

    /**
     * Devuelve la entrada.
     *
     */
    public final void getEntrada() {
        posMouseRecorrido = juego.getHandlerMouse().getPosMouseRecorrido();
        posMouse = juego.getHandlerMouse().getPosMouse();
        if (juego.getHandlerMouse().getNuevoClick() && posMouse[0] >= NUM_738
                && posMouse[0] <= NUM_797 && posMouse[1] >= NUM_545
                && posMouse[1] <= NUM_597) {
            if (Pantalla.menuInventario == null) {
                Pantalla.menuInventario = new MenuInventario(
                        juego.getCliente());
                Pantalla.menuInventario.setVisible(true);
            }
            juego.getHandlerMouse().setNuevoClick(false);
        }
        if (juego.getHandlerMouse().getNuevoClick() && posMouse[0] >= TRES
                && posMouse[0] <= NUM_105 && posMouse[1] >= NUM_562
                && posMouse[1] <= NUM_597) {
            if (Pantalla.menuEscp == null) {
                Pantalla.menuEscp = new MenuEscape(juego.getCliente());
                Pantalla.menuEscp.setVisible(true);
            }
            juego.getHandlerMouse().setNuevoClick(false);
        }
        if (juego.getHandlerMouse().getNuevoClick() && posMouse[0] >= TRES
                && posMouse[0] <= NUM_105 && posMouse[1] >= NUM_524
                && posMouse[1] <= NUM_559) {
            if (Pantalla.ventContac == null) {
                Pantalla.ventContac = new VentanaContactos(juego);
                Pantalla.ventContac.setVisible(true);
            }
            juego.getHandlerMouse().setNuevoClick(false);
        }
        // Tomo el click izquierdo
        if (juego.getHandlerMouse().getNuevoClick()) {
            if (juego.getEstadoJuego().getHaySolicitud()) {
                if (juego.getEstadoJuego().getMenuEnemigo()
                        .clickEnMenu(posMouse[0], posMouse[1])) {
                    if (juego.getEstadoJuego().getMenuEnemigo()
                            .clickEnBoton(posMouse[0], posMouse[1])) {
                        // Pregunto si menuBatallar o menuComerciar, sino no me
                        // interesa hacer esto
                        if (juego.getEstadoJuego()
                                .getTipoSolicitud() == MenuInfoPersonaje.MENU_BATALLAR
                                || juego.getEstadoJuego()
                                        .getTipoSolicitud() == MenuInfoPersonaje.MENU_COMERCIAR) {
                            // Guardo las poss con el que quiero comerciar
                            xComercio = juego.getUbicacionPersonajes()
                                    .get(idEnemigo).getPosX();
                            yComercio = juego.getUbicacionPersonajes()
                                    .get(idEnemigo).getPosY();
                            comercio = Mundo.isoA2D(xComercio, yComercio);
                        }
                        // pregunto si el menu emergente es de tipo batalla
                        if (juego.getEstadoJuego()
                                .getTipoSolicitud() == MenuInfoPersonaje.MENU_BATALLAR) {
                            // ME ASEGURO DE QUE EL ENEMIGO NO ESTÉ EN LA ZONA
                            // DE COMERCIO
                            if (!((int) comercio[0] >= NUM_44
                                    && (int) comercio[0] <= NUM_71
                                    && (int) comercio[1] >= 0
                                    && (int) comercio[1] <= NUM_29)) {
                                juego.getEstadoJuego().setHaySolicitud(false,
                                        null, MenuInfoPersonaje.MENU_BATALLAR);

                                PaqueteBatalla pBatalla = new PaqueteBatalla();

                                pBatalla.setId(juego.getPersonaje().getId());
                                pBatalla.setIdEnemigo(idEnemigo);

                                try {
                                    juego.getCliente().getSalida()
                                            .writeObject(gson.toJson(pBatalla));
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null,
                                            "Fallo la conexión "
                                                    + "con el servidor");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "El otro usuario se encuentra "
                                                + "dentro de la zona de comercio");
                            }
                        } else {
                            // PREGUNTO SI EL MENU EMERGENTE ES DE TIPO COMERCIO
                            if (juego.getEstadoJuego()
                                    .getTipoSolicitud() == MenuInfoPersonaje.MENU_COMERCIAR) {
                                if ((int) comercio[0] >= NUM_44
                                        && (int) comercio[0] <= NUM_71
                                        && (int) comercio[1] >= 0
                                        && (int) comercio[1] <= NUM_29) {
                                    if (juego.getCliente().getM1() == null) {
                                        juego.getCliente().setPaqueteComercio(
                                                new PaqueteComerciar());
                                        juego.getCliente().getPaqueteComercio()
                                                .setId(juego.getPersonaje()
                                                        .getId());
                                        juego.getCliente().getPaqueteComercio()
                                                .setIdEnemigo(idEnemigo);

                                        try {
                                            juego.getCliente().getSalida()
                                                    .writeObject(gson.toJson(
                                                            juego.getCliente()
                                                                    .getPaqueteComercio()));
                                        } catch (IOException e) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Fallo la conexión "
                                                            + "con el servidor");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null,
                                                "Ya te encuentras comerciando!");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                            "El otro usuario no se encuentra "
                                                    + "dentro de la zona de comercio");
                                }
                            }
                        }
                        juego.getEstadoJuego().setHaySolicitud(false, null,
                                MenuInfoPersonaje.MENU_BATALLAR);
                    } else if (juego.getEstadoJuego().getMenuEnemigo()
                            .clickEnCerrar(posMouse[0], posMouse[1])) {
                        juego.getEstadoJuego().setHaySolicitud(false, null,
                                MenuInfoPersonaje.MENU_BATALLAR);
                    } else if (juego.getEstadoJuego().getMenuEnemigo()
                            .clickEnCerrar(posMouse[0], posMouse[1])) {
                        juego.getEstadoJuego().setHaySolicitudEnemigo(false,
                                null, MenuInfoPersonaje.MENU_BATALLAR);
                    }
                } else {
                    juego.getEstadoJuego().setHaySolicitud(false, null,
                            MenuInfoPersonaje.MENU_BATALLAR);
                }
            } else if (juego.getEstadoJuego().getHaySolicitudEnemigo()) { // TODO:
                                                                          // Completar
                                                                          // batalla
                                                                          // con
                                                                          // Bryan
                if (juego.getEstadoJuego().getMenuEnemigoNPC()
                        .clickEnCerrar(posMouse[0], posMouse[1])) {
                    juego.getEstadoJuego().setHaySolicitudEnemigo(false, null,
                            MenuInfoPersonaje.MENU_BATALLAR);
                } else if (juego.getEstadoJuego().getMenuEnemigoNPC()
                        .clickEnMenu(posMouse[0], posMouse[1])) {
                    if (juego.getEstadoJuego().getMenuEnemigoNPC()
                            .clickEnBoton(posMouse[0], posMouse[1])) {
                        juego.getEstadoJuego().setHaySolicitudEnemigo(false,
                                null, MenuInfoPersonaje.MENU_BATALLAR);

                        PaqueteBatalla pBatalla = new PaqueteBatalla();

                        pBatalla.setId(juego.getPersonaje().getId());
                        pBatalla.setIdEnemigo(idEnemigo);

                        try {
                            juego.getCliente().getSalida()
                                    .writeObject(gson.toJson(pBatalla));
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null,
                                    "Fallo la conexión " + "con el servidor");
                        }
                    }
                }
            } else {
                // Me fijo si el click cae sobre el tile donde hay un jugador
                Iterator<Integer> it = juego.getUbicacionPersonajes().keySet()
                        .iterator();
                int key;
                int[] tileMoverme = Mundo.mouseATile(
                        posMouse[0] + juego.getCamara().getxOffset() - xOffset,
                        posMouse[1] + juego.getCamara().getyOffset() - yOffset);
                PaqueteMovimiento actual;

                while (it.hasNext()) {
                    key = it.next();
                    actual = juego.getUbicacionPersonajes().get(key);
                    tilePersonajes = Mundo.mouseATile(actual.getPosX(),
                            actual.getPosY());
                    if (actual != null
                            && actual.getIdPersonaje() != juego.getPersonaje()
                                    .getId()
                            && juego.getPersonajesConectados()
                                    .get(actual.getIdPersonaje()) != null
                            && juego.getPersonajesConectados()
                                    .get(actual.getIdPersonaje())
                                    .getEstado() == Estado.estadoJuego) {

                        if (tileMoverme[0] == tilePersonajes[0]
                                && tileMoverme[1] == tilePersonajes[1]) {
                            idEnemigo = actual.getIdPersonaje();
                            float[] xy = Mundo.isoA2D(x, y);
                            // ESTA ESTE PARA NO MOVERME HASTA EL LUGAR.
                            if (xy[0] >= NUM_44 && xy[0] <= NUM_71 && xy[1] >= 0
                                    && xy[1] <= NUM_29) {
                                // SI ESTOY DENTRO DE LA ZONA DE COMERCIO SETEO
                                // QUE SE ABRA EL MENU
                                // DE COMERCIO
                                juego.getEstadoJuego().setHaySolicitud(true,
                                        juego.getPersonajesConectados()
                                                .get(idEnemigo),
                                        MenuInfoPersonaje.MENU_COMERCIAR);
                            } else {
                                // SI ESTOY DENTRO DE LA ZONA DE BATALLA SETEO
                                // QUE SE ABRA EL MENU
                                // DE BATALLA
                                juego.getEstadoJuego().setHaySolicitud(true,
                                        juego.getPersonajesConectados()
                                                .get(idEnemigo),
                                        MenuInfoPersonaje.MENU_BATALLAR);
                            }
                            juego.getHandlerMouse().setNuevoClick(false);
                        }
                    }
                }

                // Me fijo si el click cae sobre el tile donde hay un enemigo
                clickEsSobreEnemigo(tileMoverme);
            }
        }

        // TODO: Cuando te choques con un Bryan no deberías poder atravesarlo.
        // TODO: Opcional - Cuando te choques con un Bryan, perdés
        // aleatoriamente un objeto porque te lo roba el muy chorro.
        if (juego.getHandlerMouse().getNuevoRecorrido()
                && !juego.getEstadoJuego().getHaySolicitud()) {

            tileMoverme = Mundo.mouseATile(
                    posMouseRecorrido[0] + juego.getCamara().getxOffset()
                            - xOffset,
                    posMouseRecorrido[1] + juego.getCamara().getyOffset()
                            - yOffset);

            juego.getHandlerMouse().setNuevoRecorrido(false);

            pilaMovimiento = null;

            juego.getEstadoJuego().setHaySolicitud(false, null,
                    MenuInfoPersonaje.MENU_BATALLAR);
        }

        if (!enMovimiento && tileMoverme != null) {

            enMovimiento = false;

            xInicio = x;
            yInicio = y;

            tileActual = Mundo.mouseATile(x, y);

            if (tileMoverme[0] < 0 || tileMoverme[1] < 0
                    || tileMoverme[0] >= mundo.obtenerAncho()
                    || tileMoverme[1] >= mundo.obtenerAlto()) {
                enMovimiento = false;
                juego.getHandlerMouse().setNuevoRecorrido(false);
                pilaMovimiento = null;
                tileMoverme = null;
                return;
            }

            if (tileMoverme[0] == tileActual[0]
                    && tileMoverme[1] == tileActual[1]
                    || mundo.getTile(tileMoverme[0], tileMoverme[1])
                            .esSolido()) {
                tileMoverme = null;
                enMovimiento = false;
                juego.getHandlerMouse().setNuevoRecorrido(false);
                pilaMovimiento = null;
                return;
            }

            if (pilaMovimiento == null) {
                pilaMovimiento = caminoMasCorto(tileActual[0], tileActual[1],
                        tileMoverme[0], tileMoverme[1]);
            }
            // Me muevo al primero de la pila
            NodoDePila nodoActualTile = pilaMovimiento.pop();

            if (nodoActualTile == null) {
                enMovimiento = false;
                juego.getHandlerMouse().setNuevoRecorrido(false);
                pilaMovimiento = null;
                tileMoverme = null;
                return;
            }

            tileFinal = new int[2];
            tileFinal[0] = nodoActualTile.obtenerX();
            tileFinal[1] = nodoActualTile.obtenerY();

            xFinal = Mundo.dosDaIso(tileFinal[0], tileFinal[1])[0];
            yFinal = Mundo.dosDaIso(tileFinal[0], tileFinal[1])[1];

            if (tileFinal[0] == tileActual[0] - 1
                    && tileFinal[1] == tileActual[1] - 1) {
                movimientoHacia = VERTICAL_SUPERIOR;
            }
            if (tileFinal[0] == tileActual[0] + 1
                    && tileFinal[1] == tileActual[1] + 1) {
                movimientoHacia = VERTICAL_INFERIOR;
            }
            if (tileFinal[0] == tileActual[0] - 1
                    && tileFinal[1] == tileActual[1] + 1) {
                movimientoHacia = HORIZONTAL_IZQUIERDA;
            }
            if (tileFinal[0] == tileActual[0] + 1
                    && tileFinal[1] == tileActual[1] - 1) {
                movimientoHacia = HORIZONTAL_DERECHA;
            }
            if (tileFinal[0] == tileActual[0] - 1
                    && tileFinal[1] == tileActual[1]) {
                movimientoHacia = DIAGONAL_SUPERIOR_IZQUIERDA;
            }
            if (tileFinal[0] == tileActual[0] + 1
                    && tileFinal[1] == tileActual[1]) {
                movimientoHacia = DIAGONAL_INFERIOR_DERECHA;
            }
            if (tileFinal[0] == tileActual[0]
                    && tileFinal[1] == tileActual[1] - 1) {
                movimientoHacia = DIAGONAL_SUPERIOR_DERECHA;
            }
            if (tileFinal[0] == tileActual[0]
                    && tileFinal[1] == tileActual[1] + 1) {
                movimientoHacia = DIAGONAL_INFERIOR_IZQUIERDA;
            }
            enMovimiento = true;
        }
    }

    /**
     * Click es sobre enemigo.
     *
     * @param tileMov
     *            the tile moverme
     */
    private void clickEsSobreEnemigo(int[] tileMov) {
        Iterator<Integer> it = juego.getUbicacionEnemigos().keySet().iterator();
        int key;
        PaqueteMovimiento actual;

        while (it.hasNext()) {
            key = it.next();
            actual = juego.getUbicacionEnemigos().get(key);
            tileEnemigos = Mundo.mouseATile(actual.getPosX(), actual.getPosY());
            if (actual != null) {
                if (tileMov[0] == tileEnemigos[0]
                        && tileMov[1] == tileEnemigos[1]
                        && juego.getEnemigosConectados()
                                .get(actual.getIdPersonaje() * -1 + 1)
                                .getEstado() == Estado.estadoJuego) {
                    idEnemigo = actual.getIdPersonaje();
                    float[] xy = Mundo.isoA2D(x, y);

                    juego.getEstadoJuego().setHaySolicitudEnemigo(true,
                            juego.getEnemigosConectados().get(idEnemigo),
                            MenuInfoPersonaje.MENU_BATALLAR);
                    juego.getHandlerMouse().setNuevoClick(false);
                }
            }
        }
    }

    /**
     * Mueve el personaje.
     */
    public final void mover() {

        dx = 0;
        dy = 0;

        double paso = 1;

        if (enMovimiento && !(x == xFinal && y == yFinal - NUM_32)) {
            if (movimientoHacia == VERTICAL_SUPERIOR) {
                dy -= paso;
            } else if (movimientoHacia == VERTICAL_INFERIOR) {
                dy += paso;
            } else if (movimientoHacia == HORIZONTAL_DERECHA) {
                dx += paso;
            } else if (movimientoHacia == HORIZONTAL_IZQUIERDA) {
                dx -= paso;
            } else if (movimientoHacia == DIAGONAL_INFERIOR_DERECHA) {
                dx += paso;
                dy += paso / 2;
            } else if (movimientoHacia == DIAGONAL_INFERIOR_IZQUIERDA) {
                dx -= paso;
                dy += paso / 2;
            } else if (movimientoHacia == DIAGONAL_SUPERIOR_DERECHA) {
                dx += paso;
                dy -= paso / 2;
            } else if (movimientoHacia == DIAGONAL_SUPERIOR_IZQUIERDA) {
                dx -= paso;
                dy -= paso / 2;
            }

            x += dx;
            y += dy;

            // Le envio la posicion
            if (intervaloEnvio == 2) {
                enviarPosicion();
                intervaloEnvio = 0;
            }
            intervaloEnvio++;

            if (x == xFinal && y == yFinal - NUM_32) {
                enMovimiento = false;
            }
        }
    }

    /**
     * Grafica el frame del personaje.
     *
     * @param g
     *            the g
     */
    public final void graficar(final Graphics g) {
        drawX = (int) (x - juego.getCamara().getxOffset());
        drawY = (int) (y - juego.getCamara().getyOffset());
        g.drawImage(getFrameAnimacionActual(), drawX, drawY + CUATRO, ancho,
                alto, null);
    }

    /**
     * Grafica el nombre.
     *
     * @param g
     *            the g
     */
    public final void graficarNombre(final Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Book Antiqua", Font.BOLD, FONT_SIZE_15));
        Pantalla.centerString(g, new java.awt.Rectangle(drawX + NUM_32,
                drawY - NUM_20, 0, NUM_10), nombre);
    }

    /**
     * Obtiene el frameActual del personaje.
     *
     * @return the frame animacion actual
     */
    private BufferedImage getFrameAnimacionActual() {
        // Gurdamos en un HasMap los tipos de movimiento que luego mostraremos
        HashMap<Integer, BufferedImage> tipoMovimiento = new HashMap<Integer, BufferedImage>();
        tipoMovimiento.put(HORIZONTAL_IZQUIERDA, moverIzq.getFrameActual());
        tipoMovimiento.put(HORIZONTAL_DERECHA, moverDer.getFrameActual());
        tipoMovimiento.put(VERTICAL_SUPERIOR, moverArriba.getFrameActual());
        tipoMovimiento.put(VERTICAL_INFERIOR, moverAbajo.getFrameActual());
        tipoMovimiento.put(DIAGONAL_INFERIOR_IZQUIERDA,
                moverAbajoIzq.getFrameActual());
        tipoMovimiento.put(DIAGONAL_INFERIOR_DERECHA,
                moverAbajoDer.getFrameActual());
        tipoMovimiento.put(DIAGONAL_SUPERIOR_IZQUIERDA,
                moverArribaIzq.getFrameActual());
        tipoMovimiento.put(DIAGONAL_SUPERIOR_DERECHA,
                moverArribaDer.getFrameActual());

        return tipoMovimiento.get(movimientoHacia) != null
                ? tipoMovimiento.get(movimientoHacia)
                : Recursos.orco.get(SEIS)[0];
    }

    /**
     * Pide la direccion donde va.
     *
     * @return devuelve el movimiento hacia donde va
     */
    private int getDireccion() {
        return movimientoHacia;
    }

    /**
     * Obtiene el frame donde esta el personaje.
     *
     * @return the frame
     */
    private int getFrame() {

        HashMap<Integer, Integer> tipoMovimiento = new HashMap<Integer, Integer>();
        tipoMovimiento.put(HORIZONTAL_IZQUIERDA, moverIzq.getFrame());
        tipoMovimiento.put(HORIZONTAL_DERECHA, moverDer.getFrame());
        tipoMovimiento.put(VERTICAL_SUPERIOR, moverArriba.getFrame());
        tipoMovimiento.put(VERTICAL_INFERIOR, moverAbajo.getFrame());
        tipoMovimiento.put(DIAGONAL_INFERIOR_IZQUIERDA,
                moverAbajoIzq.getFrame());
        tipoMovimiento.put(DIAGONAL_INFERIOR_DERECHA,
                moverAbajoDer.getFrame());
        tipoMovimiento.put(DIAGONAL_SUPERIOR_IZQUIERDA,
                moverArribaIzq.getFrame());
        tipoMovimiento.put(DIAGONAL_SUPERIOR_DERECHA,
                moverArribaDer.getFrame());
        return 0;
    }

    /**
     * Envia la posicion del personaje.
     */
    private void enviarPosicion() {
        juego.getUbicacionPersonaje().setPosX(x);
        juego.getUbicacionPersonaje().setPosY(y);
        juego.getUbicacionPersonaje().setDireccion(getDireccion());
        juego.getUbicacionPersonaje().setFrame(getFrame());
        try {
            juego.getCliente().getSalida().writeObject(gson.toJson(
                    juego.getUbicacionPersonaje(), PaqueteMovimiento.class));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Fallo la conexión con el servidor");
        }
    }

    /**
     * Busca el camino más corto a recorrer para llegar a una posición.
     *
     * @param xInicial
     *            ubicacion en X inicial
     * @param yInicial
     *            ubicacion en Y inicial
     * @param xFinal
     *            ubicacion en X final
     * @param yFinal
     *            ubicacion en Y final
     * @return la pila de tiles a recorrer
     */
    private PilaDeTiles caminoMasCorto(final int xInicial, final int yInicial,
            final int xFinal, final int yFinal) {
        Grafo grafoLibres = mundo.obtenerGrafoDeTilesNoSolidos();
        // Transformo las coordenadas iniciales y finales en indices
        int nodoInicial = (yInicial - grafoLibres.obtenerNodos()[0].obtenerY())
                * (int) Math.sqrt(grafoLibres.obtenerCantidadDeNodosTotal())
                + xInicial - grafoLibres.obtenerNodos()[0].obtenerX();

        int nodoFinal = (yFinal - grafoLibres.obtenerNodos()[0].obtenerY())
                * (int) Math.sqrt(grafoLibres.obtenerCantidadDeNodosTotal())
                + xFinal - grafoLibres.obtenerNodos()[0].obtenerX();

        // Hago todo
        double[] vecCostos = new double[grafoLibres
                .obtenerCantidadDeNodosTotal()];
        int[] vecPredecesores = new int[grafoLibres
                .obtenerCantidadDeNodosTotal()];
        boolean[] conjSolucion = new boolean[grafoLibres
                .obtenerCantidadDeNodosTotal()];
        int cantSolucion = 0;
        // Lleno la matriz de costos de numeros grandes
        for (int i = 0; i < grafoLibres.obtenerCantidadDeNodosTotal(); i++) {
            vecCostos[i] = Double.MAX_VALUE;
        }
        // Adyacentes al nodo inicial
        conjSolucion[nodoInicial] = true;
        cantSolucion++;
        vecCostos[nodoInicial] = 0;
        Nodo[] adyacentes = grafoLibres.obtenerNodos()[nodoInicial]
                .obtenerNodosAdyacentes();
        for (int i = 0; i < grafoLibres.obtenerNodos()[nodoInicial]
                .obtenerCantidadDeAdyacentes(); i++) {
            if (estanEnDiagonal(grafoLibres.obtenerNodos()[nodoInicial],
                    grafoLibres.obtenerNodos()[adyacentes[i]
                            .obtenerIndice()])) {
                vecCostos[adyacentes[i].obtenerIndice()] = VAL_A_SUMAR;
            } else {
                vecCostos[adyacentes[i].obtenerIndice()] = 1;
            }
            vecPredecesores[adyacentes[i].obtenerIndice()] = nodoInicial;
        }
        // Aplico Dijkstra
        while (cantSolucion < grafoLibres.obtenerCantidadDeNodosTotal()) {
            // Elijo W perteneciente al conjunto restante tal que el costo de W
            // sea minimo
            double minimo = Double.MAX_VALUE;
            int indiceMinimo = 0;
            Nodo nodoW = null;
            for (int i = 0; i < grafoLibres
                    .obtenerCantidadDeNodosTotal(); i++) {
                if (!conjSolucion[i] && vecCostos[i] < minimo) {
                    nodoW = grafoLibres.obtenerNodos()[i];
                    minimo = vecCostos[i];
                    indiceMinimo = i;
                }
            }
            // Pongo a W en el conj solucion
            conjSolucion[indiceMinimo] = true;
            cantSolucion++;
            // Por cada nodo I adyacente a W del conj restante
            // Le sumo 1 al costo de ir hasta W y luego ir hasta su adyacente
            adyacentes = grafoLibres.obtenerNodos()[indiceMinimo]
                    .obtenerNodosAdyacentes();
            for (int i = 0; i < grafoLibres.obtenerNodos()[indiceMinimo]
                    .obtenerCantidadDeAdyacentes(); i++) {
                double valorASumar = 1;
                if (estanEnDiagonal(grafoLibres.obtenerNodos()[indiceMinimo],
                        grafoLibres.obtenerNodos()[adyacentes[i]
                                .obtenerIndice()])) {
                    valorASumar = VAL_A_SUMAR;
                }
                if (vecCostos[indiceMinimo]
                        + valorASumar < vecCostos[adyacentes[i]
                                .obtenerIndice()]) {
                    vecCostos[adyacentes[i]
                            .obtenerIndice()] = vecCostos[indiceMinimo]
                                    + valorASumar;
                    vecPredecesores[adyacentes[i]
                            .obtenerIndice()] = indiceMinimo;
                }
            }
        }
        // Creo el vector de nodos hasta donde quiere llegar
        PilaDeTiles camino = new PilaDeTiles();
        while (nodoFinal != nodoInicial) {
            camino.push(new NodoDePila(
                    grafoLibres.obtenerNodos()[nodoFinal].obtenerX(),
                    grafoLibres.obtenerNodos()[nodoFinal].obtenerY()));
            nodoFinal = vecPredecesores[nodoFinal];
        }

        return camino;
    }

    /**
     * Pregunta si los personajes estan en diagonal.
     *
     * @param nodoUno
     *            personaje 1
     * @param nodoDos
     *            personaje 2
     * @return true or false
     */
    private boolean estanEnDiagonal(final Nodo nodoUno, final Nodo nodoDos) {
        return (nodoUno.obtenerX() == nodoDos.obtenerX()
                || nodoUno.obtenerY() == nodoDos.obtenerY());
    }

    /**
     * Pide el valor de X.
     *
     * @return devuelve la ubicacion en X
     */
    public final float getX() {
        return x;
    }

    /**
     * Setea el valor de X.
     *
     * @param xValue
     *            valor nuevo de la ubicacion en X
     */
    public final void setX(final float xValue) {
        this.x = xValue;
    }

    /**
     * Pide el valor de Y.
     *
     * @return devuelve la ubicacion en Y
     */
    public final float getY() {
        return y;
    }

    /**
     * Setea el valor de Y.
     *
     * @param yValue
     *            valor nuevo de la ubicacion en Y
     */
    public final void setY(final float yValue) {
        this.y = yValue;
    }

    /**
     * Pide el ancho.
     *
     * @return devuelve el ancho
     */
    public final int getAncho() {
        return ancho;
    }

    /**
     * Setea el ancho.
     *
     * @param width
     *            nuevo ancho a setear
     */
    public final void setAncho(final int width) {
        this.ancho = width;
    }

    /**
     * Pide el alto.
     *
     * @return devuelve el alto
     */
    public final int getAlto() {
        return alto;
    }

    /**
     * Setea el alto.
     *
     * @param height
     *            nuevo alto a setear
     */
    public final void setAlto(final int height) {
        this.alto = height;
    }

    /**
     * Pide el offset de X.
     *
     * @return devuelve el offset de X
     */
    public final int getxOffset() {
        return xOffset;
    }

    /**
     * Pide el offset de Y.
     *
     * @return devuelve el offset de Y
     */
    public final int getYOffset() {
        return yOffset;
    }
}
