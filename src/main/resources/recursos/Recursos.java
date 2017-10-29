package recursos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.imageio.ImageIO;

import frames.MenuCarga;
import frames.MenuMapas;
import mundo.Tile;

/**
 * Clase que administra los distintos recursos del juego. <br>
 */
public class Recursos {
	/**
	 * Cantidad de elementos. <br>
	 */
	private static final int ELEMENTOS = 65;
	/**
	 * Ancho de barra. <br>
	 */
	private static final int ANCHOBARRA = 345;
	/**
	 * Ancho del frame a obtener. <br>
	 */
	private static final int ANCHO = 256;
	/**
	 * Alto del frame a obtener. <br>
	 */
	private static final int ALTO = 256;
	// Inicio Personajes
	/**
	 * Hash de imagenes para los personajes (humano, ogro, elfo, el Bryan). <br>
	 */
	public static Map<String, LinkedList<BufferedImage[]>> personaje = new HashMap<>();
	/**
	 * Sprite del humano. <br>
	 */
	private static SpriteSheet spriteHumano;
	/**
	 * Distintas posiciones del humano. <br>
	 */
	public static LinkedList<BufferedImage[]> humano = new LinkedList<>();
	/**
	 * Vista del humano a la izquierda. <br>
	 */
	private static BufferedImage[] humanoIzq;
	/**
	 * Vista del humano a la izquierda/arriba. <br>
	 */
	private static BufferedImage[] humanoArribaIzq;
	/**
	 * Vista del humano a arriba. <br>
	 */
	private static BufferedImage[] humanoArriba;
	/**
	 * Vista del humano a la derecha/arriba. <br>
	 */
	private static BufferedImage[] humanoArribaDer;
	/**
	 * Vista del humano a la derecha. <br>
	 */
	private static BufferedImage[] humanoDer;
	/**
	 * Vista del humano a la derecha/abajo. <br>
	 */
	private static BufferedImage[] humanoAbajoDer;
	/**
	 * Vista del humano a abajo. <br>
	 */
	private static BufferedImage[] humanoAbajo;
	/**
	 * Vista del humano a la izquierda/abajo. <br>
	 */
	private static BufferedImage[] humanoAbajoIzq;
	/**
	 * Sprite del orco. <br>
	 */
	private static SpriteSheet spriteOgro;
	/**
	 * Distintas posiciones del humano. <br>
	 */
	public static LinkedList<BufferedImage[]> orco = new LinkedList<>();
	/**
	 * Vista del orco a la izquierda. <br>
	 */
	private static BufferedImage[] orcoIzq;
	/**
	 * Vista del orco a la izquierda/arriba. <br>
	 */
	private static BufferedImage[] orcoArribaIzq;
	/**
	 * Vista del orco a arriba. <br>
	 */
	private static BufferedImage[] orcoArriba;
	/**
	 * Vista del orco a la derecha/arriba. <br>
	 */
	private static BufferedImage[] orcoArribaDer;
	/**
	 * Vista del orco a la derecha. <br>
	 */
	private static BufferedImage[] orcoDer;
	/**
	 * Vista del orco a la derecha/abajo. <br>
	 */
	private static BufferedImage[] orcoAbajoDer;
	/**
	 * Vista del orco a abajo. <br>
	 */
	private static BufferedImage[] orcoAbajo;
	/**
	 * Vista del orco a la izquierda/abajo. <br>
	 */
	private static BufferedImage[] orcoAbajoIzq;
	/**
	 * Sprite del elfo. <br>
	 */
	private static SpriteSheet spriteElfo;
	/**
	 * Distintas posiciones del humano. <br>
	 */
	public static LinkedList<BufferedImage[]> elfo = new LinkedList<>();
	/**
	 * Vista del elfo a la izquierda. <br>
	 */
	private static BufferedImage[] elfoIzq;
	/**
	 * Vista del elfo a la izquierda/arriba. <br>
	 */
	private static BufferedImage[] elfoArribaIzq;
	/**
	 * Vista del elfo a arriba. <br>
	 */
	private static BufferedImage[] elfoArriba;
	/**
	 * Vista del elfo a la derecha/arriba. <br>
	 */
	private static BufferedImage[] elfoArribaDer;
	/**
	 * Vista del elfo a la derecha. <br>
	 */
	private static BufferedImage[] elfoDer;
	/**
	 * Vista del elfo a la derecha/abajo. <br>
	 */
	private static BufferedImage[] elfoAbajoDer;
	/**
	 * Vista del elfo a abajo. <br>
	 */
	private static BufferedImage[] elfoAbajo;
	/**
	 * Vista del elfo a la izquierda/abajo. <br>
	 */
	private static BufferedImage[] elfoAbajoIzq;
	// Fin Personajes
	// Inicio Enemigos
	/**
	 * Sprite del bryan. <br>
	 */
	private static SpriteSheet spriteElBryan;
	/**
	 * Distintas posiciones del bryan. <br>
	 */
	public static LinkedList<BufferedImage[]> elBryan = new LinkedList<>();
	/**
	 * Vista del bryan a la izquierda. <br>
	 */
	private static BufferedImage[] elBryanIzq;
	/**
	 * Vista del bryan a la izquierda/arriba. <br>
	 */
	private static BufferedImage[] elBryanArribaIzq;
	/**
	 * Vista del bryan a arriba. <br>
	 */
	private static BufferedImage[] elBryanArriba;
	/**
	 * Vista del bryan a la derecha/arriba. <br>
	 */
	private static BufferedImage[] elBryanArribaDer;
	/**
	 * Vista del bryan a la derecha. <br>
	 */
	private static BufferedImage[] elBryanDer;
	/**
	 * Vista del bryan a la derecha/abajo. <br>
	 */
	private static BufferedImage[] elBryanAbajoDer;
	/**
	 * Vista del bryan a abajo. <br>
	 */
	private static BufferedImage[] elBryanAbajo;
	/**
	 * Vista del bryan a la izquierda/abajo. <br>
	 */
	private static BufferedImage[] elBryanAbajoIzq;
	// Fin Enemigos
	// Entorno
	/**
	 * Sprite de árboles. <br>
	 */
	private static SpriteSheet trees;
	/**
	 * Sprite de cesped. <br>
	 */
	public static BufferedImage cesped;
	/**
	 * Sprite de rocas. <br>
	 */
	public static BufferedImage roca;
	/**
	 * Sprite del fondo. <br>
	 */
	public static BufferedImage background;
	/**
	 * Sprite del marco. <br>
	 */
	public static BufferedImage marco;
	/**
	 * Sprite del botón del menú. <br>
	 */
	public static BufferedImage botonMenu;
	/**
	 * Sprite del menú del enemigo. <br>
	 */
	public static BufferedImage menuEnemigo;
	/**
	 * Sprite de árboles verdes. <br>
	 */
	public static BufferedImage greenTree;
	/**
	 * Sprite de piso nevado. <br>
	 */
	public static BufferedImage nievePiso1;
	/**
	 * Sprite de bloques de hielo. <br>
	 */
	public static BufferedImage iceBlock;
	// Fin Entorno
	// Batalla
	/**
	 * Sprite de la barra de hechizos. <br>
	 */
	public static BufferedImage barraSpells;
	/**
	 * Sprite del estado del personaje. <br>
	 */
	public static BufferedImage estadoPersonaje;
	/**
	 * Sprite de la barra de salud del personaje. <br>
	 */
	public static BufferedImage barraSalud;
	/**
	 * Sprite de la barra de energía. <br>
	 */
	public static BufferedImage barraEnergia;
	/**
	 * Sprite de la barra de experiencia. <br>
	 */
	public static BufferedImage barraExperiencia;
	/**
	 * Sprite del menú de batalla. <br>
	 */
	public static BufferedImage menuBatalla;
	/**
	 * Sprite del menú de batalla deshabilitado. <br>
	 */
	public static BufferedImage menuBatallaDeshabilitado;
	/**
	 * Sprite de un item nulo. <br>
	 */
	public static BufferedImage noItem;
	/**
	 * Sprite del inventario. <br>
	 */
	public static BufferedImage mochila;
	/**
	 * Sprite del menú. <br>
	 */
	public static BufferedImage menu;
	/**
	 * Sprite del chat. <br>
	 */
	public static BufferedImage chat;
	/**
	 * Sprite de las habilidades. <br>
	 */
	public static Map<String, BufferedImage> habilidades = new HashMap<>();
	// Fin Batalla
	/**
	 * Tres misterioso. <br>
	 */
	private static final int TRES = 3;
	/**
	 * Cuatro misterioso. <br>
	 */
	private static final int CUATRO = 4;
	/**
	 * Cinco misterioso. <br>
	 */
	private static final int CINCO = 5;
	/**
	 * Seis misterioso. <br>
	 */
	private static final int SEIS = 6;
	/**
	 * Siete misterioso. <br>
	 */
	private static final int SIETE = 7;
	/**
	 * Ocho misterioso. <br>
	 */
	private static final int OCHO = 8;
	/**
	 * Diez misterioso. <br>
	 */
	private static final int DIEZ = 10;
	/**
	 * Cuarenta y dos misterioso. <br>
	 */
	private static final int CUARENTAYDOS = 42;
	/**
	 * Cincuenta misterioso. <br>
	 */
	private static final int CINCUENTA = 50;
	/**
	 * Sesenta y cuatro misterioso. <br>
	 */
	private static final int SESENTAYCUATRO = 64;
	/**
	 * Ochenta y uno misterioso. <br>
	 */
	private static final int OCHENTAYUNO = 81;
	/**
	 * Carga todos los recursos del juego.
	 * <p>
	 * <i><u>Nota</u>: Carga todos los recursos al empezar el juego. </i><br>
	 * @param menuCarga
	 *            Menú de carga. <br>
	 * @throws NumberFormatException
	 *             Cantidad de objetos existentes diferente. <br>
	 * @throws IOException
	 *             Path de archivo incorrecto. <br>
	 */
	public static void cargar(final MenuCarga menuCarga) throws NumberFormatException, IOException {
		int elementosCargados = 0;
		// Items
		noItem = ImageIO.read(new File("recursos//noItem.png"));
		mochila = ImageIO.read(new File("recursos//mochila.png"));
		menu = ImageIO.read(new File("recursos//menu.png"));
		chat = ImageIO.read(new File("recursos//chat.png"));
		// Inicio humano
		spriteHumano = new SpriteSheet(CargadorImagen.cargarImagen("/Humano.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		humanoIzq = new BufferedImage[CUATRO];
		humanoArribaIzq = new BufferedImage[CUATRO];
		humanoArriba = new BufferedImage[CUATRO];
		humanoArribaDer = new BufferedImage[CUATRO];
		humanoDer = new BufferedImage[CUATRO];
		humanoAbajoDer = new BufferedImage[CUATRO];
		humanoAbajo = new BufferedImage[CUATRO];
		humanoAbajoIzq = new BufferedImage[CUATRO];
		for (int i = 0; i < CUATRO; i++) {
			humanoIzq[i] = spriteHumano.getTile(ANCHO * i, 0, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			humanoArribaIzq[i] = spriteHumano.getTile(ANCHO * i, ALTO, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			humanoArriba[i] = spriteHumano.getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			humanoArribaDer[i] = spriteHumano.getTile(ANCHO * i, ALTO * TRES, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			humanoDer[i] = spriteHumano.getTile(ANCHO * i, ALTO * CUATRO, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			humanoAbajoDer[i] = spriteHumano.getTile(ANCHO * i, ALTO * CINCO, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			humanoAbajo[i] = spriteHumano.getTile(ANCHO * i, ALTO * SEIS, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			humanoAbajoIzq[i] = spriteHumano.getTile(ANCHO * i, ALTO * SIETE, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		humano.add(humanoIzq);
		humano.add(humanoArribaIzq);
		humano.add(humanoArriba);
		humano.add(humanoArribaDer);
		humano.add(humanoDer);
		humano.add(humanoAbajoDer);
		humano.add(humanoAbajo);
		humano.add(humanoAbajoIzq);
		// Fin humano
		// Inicio Ogro
		spriteOgro = new SpriteSheet(CargadorImagen.cargarImagen("/Ogro.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		orcoIzq = new BufferedImage[CUATRO];
		orcoArribaIzq = new BufferedImage[CUATRO];
		orcoArriba = new BufferedImage[CUATRO];
		orcoArribaDer = new BufferedImage[CUATRO];
		orcoDer = new BufferedImage[CUATRO];
		orcoAbajoDer = new BufferedImage[CUATRO];
		orcoAbajo = new BufferedImage[CUATRO];
		orcoAbajoIzq = new BufferedImage[CUATRO];
		for (int i = 0; i < CUATRO; i++) {
			orcoIzq[i] = spriteOgro.getTile(ANCHO * i, 0, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			orcoArribaIzq[i] = spriteOgro.getTile(ANCHO * i, ALTO, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			orcoArriba[i] = spriteOgro.getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			orcoArribaDer[i] = spriteOgro.getTile(ANCHO * i, ALTO * TRES, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			orcoDer[i] = spriteOgro.getTile(ANCHO * i, ALTO * CUATRO, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			orcoAbajoDer[i] = spriteOgro.getTile(ANCHO * i, ALTO * CINCO, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			orcoAbajo[i] = spriteOgro.getTile(ANCHO * i, ALTO * SEIS, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			orcoAbajoIzq[i] = spriteOgro.getTile(ANCHO * i, ALTO * SIETE, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		orco.add(orcoIzq);
		orco.add(orcoArribaIzq);
		orco.add(orcoArriba);
		orco.add(orcoArribaDer);
		orco.add(orcoDer);
		orco.add(orcoAbajoDer);
		orco.add(orcoAbajo);
		orco.add(orcoAbajoIzq);
		// Fin Ogro
		// Inicio Elfo
		spriteElfo = new SpriteSheet(CargadorImagen.cargarImagen("/elfo2.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		elfoIzq = new BufferedImage[CUATRO];
		elfoArribaIzq = new BufferedImage[CUATRO];
		elfoArriba = new BufferedImage[CUATRO];
		elfoArribaDer = new BufferedImage[CUATRO];
		elfoDer = new BufferedImage[CUATRO];
		elfoAbajoDer = new BufferedImage[CUATRO];
		elfoAbajo = new BufferedImage[CUATRO];
		elfoAbajoIzq = new BufferedImage[CUATRO];
		for (int i = 0; i < CUATRO; i++) {
			elfoIzq[i] = spriteElfo.getTile(ANCHO * i, 0, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			elfoArribaIzq[i] = spriteElfo.getTile(ANCHO * i, ALTO, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			elfoArriba[i] = spriteElfo.getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			elfoArribaDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * TRES, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			elfoDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * CUATRO, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			elfoAbajoDer[i] = spriteElfo.getTile(ANCHO * i, ALTO * CINCO, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			elfoAbajo[i] = spriteElfo.getTile(ANCHO * i, ALTO * SEIS, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			elfoAbajoIzq[i] = spriteElfo.getTile(ANCHO * i, ALTO * SIETE, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		elfo.add(elfoIzq);
		elfo.add(elfoArribaIzq);
		elfo.add(elfoArriba);
		elfo.add(elfoArribaDer);
		elfo.add(elfoDer);
		elfo.add(elfoAbajoDer);
		elfo.add(elfoAbajo);
		elfo.add(elfoAbajoIzq);
		// Fin Elfo
		// Inicio ElBryan
		spriteElBryan = new SpriteSheet(CargadorImagen.cargarImagen("/ElBryan.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		elBryanIzq = new BufferedImage[CUATRO];
		elBryanArribaIzq = new BufferedImage[CUATRO];
		elBryanArriba = new BufferedImage[CUATRO];
		elBryanArribaDer = new BufferedImage[CUATRO];
		elBryanDer = new BufferedImage[CUATRO];
		elBryanAbajoDer = new BufferedImage[CUATRO];
		elBryanAbajo = new BufferedImage[CUATRO];
		elBryanAbajoIzq = new BufferedImage[CUATRO];
		for (int i = 0; i < CUATRO; i++) {
			elBryanIzq[i] = spriteElBryan.getTile(ANCHO * i, 0, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			elBryanArribaIzq[i] = spriteElBryan.getTile(ANCHO * i, ALTO, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			elBryanArriba[i] = spriteElBryan.getTile(ANCHO * i, ALTO * 2, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			elBryanArribaDer[i] = spriteElBryan.getTile(ANCHO * i, ALTO * TRES, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			elBryanDer[i] = spriteElBryan.getTile(ANCHO * i, ALTO * CUATRO, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			elBryanAbajoDer[i] = spriteElBryan.getTile(ANCHO * i, ALTO * CINCO, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);

		for (int i = 0; i < CUATRO; i++) {
			elBryanAbajo[i] = spriteElBryan.getTile(ANCHO * i, ALTO * SEIS, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		for (int i = 0; i < CUATRO; i++) {
			elBryanAbajoIzq[i] = spriteElBryan.getTile(ANCHO * i, ALTO * SIETE, ANCHO, ALTO);
		}
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		elBryan.add(elBryanIzq);
		elBryan.add(elBryanArribaIzq);
		elBryan.add(elBryanArriba);
		elBryan.add(elBryanArribaDer);
		elBryan.add(elBryanDer);
		elBryan.add(elBryanAbajoDer);
		elBryan.add(elBryanAbajo);
		elBryan.add(elBryanAbajoIzq);
		// Fin ElBryan
		// Agrego los pj al hash
		personaje.put("Humano", humano);
		personaje.put("Orco", orco);
		personaje.put("Elfo", elfo);
		personaje.put("El Bryan", elBryan);
		// Inicio Entorno
		cesped = CargadorImagen.cargarImagen("/Cesped.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		roca = CargadorImagen.cargarImagen("/rock.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		background = CargadorImagen.cargarImagen("/background.jpg");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		marco = CargadorImagen.cargarImagen("/marco.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		botonMenu = CargadorImagen.cargarImagen("/botonMenu.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		menuEnemigo = CargadorImagen.cargarImagen("/MenuEnemigo.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		trees = new SpriteSheet(CargadorImagen.cargarImagen("/trees.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		greenTree = trees.getTile(0, 0, CUARENTAYDOS, CINCUENTA);
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		nievePiso1 = CargadorImagen.cargarImagen("/nieve piso.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		iceBlock = CargadorImagen.cargarImagen("/nieve cubo.png");
		// Mapa
		if (MenuMapas.numberMap == 1) {
			SpriteSheet mapaAubenor = new SpriteSheet(CargadorImagen.cargarImagen("/Aubenor.png"));
			Tile.aubenor = new Tile[OCHENTAYUNO];
			boolean[][] solidezAubenor = {{true, true, false, true, false, true, true, true, true, true},
					{true, true, true, true, true, true, true, true, true, true},
					{true, true, true, true, true, true, true, true, true, true},
					{true, false, false, false, false, false, false, false, true, true},
					{false, false, false, false, false, false, false, false, true, true},
					{false, true, true, true, true, true, true, true, true, true},
					{true, true, true, true, true, true, true, true, true, true},
					{true, true, true, true, true, true, true, true, true, true}};
			for (int y = 0; y < OCHO; y++) {
				for (int x = 0; x < DIEZ; x++) {
					Tile.aubenor[y * DIEZ + x + 1] = new Tile(mapaAubenor.getTile(x * SESENTAYCUATRO, y * SESENTAYCUATRO, SESENTAYCUATRO, SESENTAYCUATRO), y * DIEZ + x + 1,
							solidezAubenor[y][x], SESENTAYCUATRO, SESENTAYCUATRO);
				}
			}
		} else {
			SpriteSheet mapaAris = new SpriteSheet(CargadorImagen.cargarImagen("/Aris.png"));
			Tile.aris = new Tile[OCHENTAYUNO];
			boolean[][] solidezAris = {{true, false, false, false, false, false, false, true, true, true},
					{false, false, false, false, false, false, false, false, true, true},
					{false, false, false, false, true, true, true, true, true, true},
					{true, true, true, true, true, true, true, true, true, true},
					{true, true, true, true, true, true, true, true, true, true},
					{false, true, true, true, true, true, true, true, true, true},
					{true, true, true, true, true, true, true, true, true, true},
					{true, true, true, true, true, true, true, true, true, true}};
			for (int y = 0; y < OCHO; y++) {
				for (int x = 0; x < DIEZ; x++) {
					Tile.aris[y * DIEZ + x + 1] = new Tile(mapaAris.getTile(x * SESENTAYCUATRO, y * SESENTAYCUATRO, SESENTAYCUATRO, SESENTAYCUATRO), y * DIEZ + x + 1,
							solidezAris[y][x], SESENTAYCUATRO, SESENTAYCUATRO);
				}
			}
		}
		// Fin Entorno
		// Inicio Batalla
		barraSpells = CargadorImagen.cargarImagen("/BarraSpells.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		estadoPersonaje = CargadorImagen.cargarImagen("/EstadoPersonaje.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		barraSalud = CargadorImagen.cargarImagen("/BarraDeSalud.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		barraEnergia = CargadorImagen.cargarImagen("/BarraDeEnergia.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		barraExperiencia = CargadorImagen.cargarImagen("/BarraDeExperiencia.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		habilidades.put("Golpe Level", CargadorImagen.cargarImagen("/Golpe Level.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		habilidades.put("Ataque Bosque", CargadorImagen.cargarImagen("/Ataque Bosque.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		habilidades.put("Golpe Defensa", CargadorImagen.cargarImagen("/Golpe Defensa.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		habilidades.put("Mordisco de Vida", CargadorImagen.cargarImagen("/Mordisco de Vida.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		habilidades.put("Incentivar", CargadorImagen.cargarImagen("/Incentivar.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		habilidades.put("Golpe Fatal", CargadorImagen.cargarImagen("/Golpe Fatal.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		habilidades.put("Ataque Doble", CargadorImagen.cargarImagen("/Ataque Doble.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		habilidades.put("Aumentar Defensa", CargadorImagen.cargarImagen("/Aumentar Defensa.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		habilidades.put("Ignorar Defensa", CargadorImagen.cargarImagen("/Ignorar Defensa.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		habilidades.put("Bola de Fuego", CargadorImagen.cargarImagen("/Bola de Fuego.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		habilidades.put("Curar Aliado", CargadorImagen.cargarImagen("/Curar Aliado.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		habilidades.put("Robar Energia y Salud", CargadorImagen.cargarImagen("/Robar Energia y Salud.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		habilidades.put("Golpe Critico", CargadorImagen.cargarImagen("/Golpe Critico.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		habilidades.put("Aumentar Evasion", CargadorImagen.cargarImagen("/Aumentar Evasion.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		habilidades.put("Robar", CargadorImagen.cargarImagen("/Robar.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		habilidades.put("Ser Energizado", CargadorImagen.cargarImagen("/Ser Energizado.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		menuBatalla = CargadorImagen.cargarImagen("/MenuBatalla.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		menuBatallaDeshabilitado = CargadorImagen.cargarImagen("/MenuBatallaDeshabilitado.png");
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		// Fin Batalla
	}

	/**
	 * Actualiza la barra de carga. <br>
	 * @param elementosCargados
	 *            Elementos cargados. <br>
	 * @param menuCarga
	 *            Menú de carga. <br>
	 */
	private static void actualizarBarraDeCarga(final int elementosCargados, final MenuCarga menuCarga) {
		menuCarga.setBarraCargando(elementosCargados * ANCHOBARRA / ELEMENTOS);
	}
}
