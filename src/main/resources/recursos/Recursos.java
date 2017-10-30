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
	private static BufferedImage cesped;
	/**
	 * Sprite de rocas. <br>
	 */
	private static BufferedImage roca;
	/**
	 * Sprite del fondo. <br>
	 */
	private static BufferedImage background;
	/**
	 * Sprite del marco. <br>
	 */
	private static BufferedImage marco;
	/**
	 * Sprite del botón del menú. <br>
	 */
	private static BufferedImage botonMenu;
	/**
	 * Sprite del menú del enemigo. <br>
	 */
	private static BufferedImage menuEnemigo;
	/**
	 * Sprite de árboles verdes. <br>
	 */
	private static BufferedImage greenTree;
	/**
	 * Sprite de piso nevado. <br>
	 */
	private static BufferedImage nievePiso1;
	/**
	 * Sprite de bloques de hielo. <br>
	 */
	private static BufferedImage iceBlock;
	// Fin Entorno
	// Batalla
	/**
	 * Sprite de la barra de hechizos. <br>
	 */
	private static BufferedImage barraSpells;
	/**
	 * Sprite del estado del personaje. <br>
	 */
	private static BufferedImage estadoPersonaje;
	/**
	 * Sprite de la barra de salud del personaje. <br>
	 */
	private static BufferedImage barraSalud;
	/**
	 * Sprite de la barra de energía. <br>
	 */
	private static BufferedImage barraEnergia;
	/**
	 * Sprite de la barra de experiencia. <br>
	 */
	private static BufferedImage barraExperiencia;
	/**
	 * Sprite del menú de batalla. <br>
	 */
	private static BufferedImage menuBatalla;
	/**
	 * Sprite del menú de batalla deshabilitado. <br>
	 */
	private static BufferedImage menuBatallaDeshabilitado;
	/**
	 * Sprite de un item nulo. <br>
	 */
	private static BufferedImage noItem;
	/**
	 * Sprite del inventario. <br>
	 */
	private static BufferedImage mochila;
	/**
	 * Sprite del menú. <br>
	 */
	private static BufferedImage menu;
	/**
	 * Sprite del chat. <br>
	 */
	private static BufferedImage chat;
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
		setNoItem(ImageIO.read(new File("recursos//noItem.png")));
		setMochila(ImageIO.read(new File("recursos//mochila.png")));
		setMenu(ImageIO.read(new File("recursos//menu.png")));
		setChat(ImageIO.read(new File("recursos//chat.png")));
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
		setCesped(CargadorImagen.cargarImagen("/Cesped.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		setRoca(CargadorImagen.cargarImagen("/rock.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		setBackground(CargadorImagen.cargarImagen("/background.jpg"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		setMarco(CargadorImagen.cargarImagen("/marco.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		setBotonMenu(CargadorImagen.cargarImagen("/botonMenu.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		setMenuEnemigo(CargadorImagen.cargarImagen("/MenuEnemigo.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		trees = new SpriteSheet(CargadorImagen.cargarImagen("/trees.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		setGreenTree(trees.getTile(0, 0, CUARENTAYDOS, CINCUENTA));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		setNievePiso1(CargadorImagen.cargarImagen("/nieve piso.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		setIceBlock(CargadorImagen.cargarImagen("/nieve cubo.png"));
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
		setBarraSpells(CargadorImagen.cargarImagen("/BarraSpells.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		setEstadoPersonaje(CargadorImagen.cargarImagen("/EstadoPersonaje.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		setBarraSalud(CargadorImagen.cargarImagen("/BarraDeSalud.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		setBarraEnergia(CargadorImagen.cargarImagen("/BarraDeEnergia.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		setBarraExperiencia(CargadorImagen.cargarImagen("/BarraDeExperiencia.png"));
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
		setMenuBatalla(CargadorImagen.cargarImagen("/MenuBatalla.png"));
		actualizarBarraDeCarga(++elementosCargados, menuCarga);
		setMenuBatallaDeshabilitado(CargadorImagen.cargarImagen("/MenuBatallaDeshabilitado.png"));
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

	/**
	 * Devuelve el sprite de la mochila. <br>
	 * @return Sprite de la mochila. <br>
	 */
	public static BufferedImage getMochila() {
		return mochila;
	}

	/**
	 * Establece el sprite de la mochila. <br>
	 * @param mochila
	 *            Sprite de la mochila. <br>
	 */
	public static void setMochila(final BufferedImage mochila) {
		Recursos.mochila = mochila;
	}

	/**
	 * Devuelve el sprite del menú. <br>
	 * @return Sprite del menú. <br>
	 */
	public static BufferedImage getMenu() {
		return menu;
	}

	/**
	 * Establece el sprite del menú. <br>
	 * @param menu
	 *            Sprite del menú. <br>
	 */
	public static void setMenu(final BufferedImage menu) {
		Recursos.menu = menu;
	}

	/**
	 * Devuelve el sprite del cesped. <br>
	 * @return Sprite del cesped. <br>
	 */
	public static BufferedImage getCesped() {
		return cesped;
	}

	/**
	 * Establece el sprite del cesped. <br>
	 * @param cesped
	 *            Sprite del cesped. <br>
	 */
	public static void setCesped(final BufferedImage cesped) {
		Recursos.cesped = cesped;
	}

	/**
	 * Devuelve el sprite de la roca. <br>
	 * @return Sprite de la roca. <br>
	 */
	public static BufferedImage getRoca() {
		return roca;
	}

	/**
	 * Establece el sprite de la roca. <br>
	 * @param roca
	 *            Sprite de la roca. <br>
	 */
	public static void setRoca(final BufferedImage roca) {
		Recursos.roca = roca;
	}

	/**
	 * Devuelve el sprite del background. <br>
	 * @return Sprite del background. <br>
	 */
	public static BufferedImage getBackground() {
		return background;
	}

	/**
	 * Establece el sprite del background. <br>
	 * @param background
	 *            Sprite del background. <br>
	 */
	public static void setBackground(final BufferedImage background) {
		Recursos.background = background;
	}

	/**
	 * Devuelve el sprite del marco. <br>
	 * @return Sprite del marco. <br>
	 */
	public static BufferedImage getMarco() {
		return marco;
	}

	/**
	 * Establece el sprite del marco. <br>
	 * @param marco
	 *            Sprite del marco. <br>
	 */
	public static void setMarco(final BufferedImage marco) {
		Recursos.marco = marco;
	}

	/**
	 * Devuelve el sprite del boton menu. <br>
	 * @return Sprite del boton menu. <br>
	 */
	public static BufferedImage getBotonMenu() {
		return botonMenu;
	}

	/**
	 * Establece el sprite del boton menu. <br>
	 * @param botonMenu
	 *            Sprite del boton menu. <br>
	 */
	public static void setBotonMenu(final BufferedImage botonMenu) {
		Recursos.botonMenu = botonMenu;
	}

	/**
	 * Devuelve el sprite del menú enemigo. <br>
	 * @return Sprite del menú enemigo. <br>
	 */
	public static BufferedImage getMenuEnemigo() {
		return menuEnemigo;
	}

	/**
	 * Establece el sprite del menú enemigo. <br>
	 * @param menuEnemigo
	 *            Sprite del menú enemigo. <br>
	 */
	public static void setMenuEnemigo(final BufferedImage menuEnemigo) {
		Recursos.menuEnemigo = menuEnemigo;
	}

	/**
	 * Devuelve el sprite del green tree. <br>
	 * @return Sprite del green tree. <br>
	 */
	public static BufferedImage getGreenTree() {
		return greenTree;
	}

	/**
	 * Establece el sprite del green tree. <br>
	 * @param greenTree
	 *            Sprite del green tree. <br>
	 */
	public static void setGreenTree(final BufferedImage greenTree) {
		Recursos.greenTree = greenTree;
	}

	/**
	 * Devuelve el sprite del piso de nieve. <br>
	 * @return Sprite del piso de nieve. <br>
	 */
	public static BufferedImage getNievePiso1() {
		return nievePiso1;
	}

	/**
	 * Establece el sprite del piso de nieve. <br>
	 * @param nievePiso1
	 *            Sprite del piso de nieve. <br>
	 */
	public static void setNievePiso1(final BufferedImage nievePiso1) {
		Recursos.nievePiso1 = nievePiso1;
	}

	/**
	 * Devuelve el sprite del bloque de hielo. <br>
	 * @return Sprite del bloque de hielo. <br>
	 */
	public static BufferedImage getIceBlock() {
		return iceBlock;
	}

	/**
	 * Establece el sprite del bloque de hielo. <br>
	 * @param iceBlock
	 *            Sprite del bloque de hielo. <br>
	 */
	public static void setIceBlock(final BufferedImage iceBlock) {
		Recursos.iceBlock = iceBlock;
	}

	/**
	 * Devuelve el sprite de la barra de hechizos. <br>
	 * @return Sprite de la barra de hechizos. <br>
	 */
	public static BufferedImage getBarraSpells() {
		return barraSpells;
	}

	/**
	 * Establece el sprite de la barra de hechizos. <br>
	 * @param barraSpells
	 *            Sprite de la barra de hechizos. <br>
	 */
	public static void setBarraSpells(final BufferedImage barraSpells) {
		Recursos.barraSpells = barraSpells;
	}

	/**
	 * Devuelve el sprite del estado del personaje. <br>
	 * @return Sprite del estado del personaje. <br>
	 */
	public static BufferedImage getEstadoPersonaje() {
		return estadoPersonaje;
	}

	/**
	 * Establece el estado del personaje. <br>
	 * @param estadoPersonaje
	 *            Sprite del estado del personaje. <br>
	 */
	public static void setEstadoPersonaje(final BufferedImage estadoPersonaje) {
		Recursos.estadoPersonaje = estadoPersonaje;
	}

	/**
	 * Devuelve el sprite de la barra de salud. <br>
	 * @return Sprite de la barra de salud. <br>
	 */
	public static BufferedImage getBarraSalud() {
		return barraSalud;
	}

	/**
	 * Establece el sprite de la barra de salud. <br>
	 * @param barraSalud
	 *            Sprite de la barra de salud. <br>
	 */
	public static void setBarraSalud(final BufferedImage barraSalud) {
		Recursos.barraSalud = barraSalud;
	}

	/**
	 * Devuelve el sprite de la barra de energía. <br>
	 * @return Sprite de la barra de energía. <br>
	 */
	public static BufferedImage getBarraEnergia() {
		return barraEnergia;
	}

	/**
	 * Establece el sprite de la barra de energía. <br>
	 * @param barraEnergia
	 *            Sprite de la barra de energía. <br>
	 */
	public static void setBarraEnergia(final BufferedImage barraEnergia) {
		Recursos.barraEnergia = barraEnergia;
	}

	/**
	 * Devuelve el sprite de la barra de experiencia. <br>
	 * @return Sprite de la barra de experiencia. <br>
	 */
	public static BufferedImage getBarraExperiencia() {
		return barraExperiencia;
	}

	/**
	 * Establece el sprite de la barra de experiencia. <br>
	 * @param barraExperiencia
	 *            Sprite de la barra de experiencia. <br>
	 */
	public static void setBarraExperiencia(final BufferedImage barraExperiencia) {
		Recursos.barraExperiencia = barraExperiencia;
	}

	/**
	 * Devuelve el sprite del menú de batalla. <br>
	 * @return Sprite del menú de batalla. <br>
	 */
	public static BufferedImage getMenuBatalla() {
		return menuBatalla;
	}

	/**
	 * Establece el sprite del menú de batalla. <br>
	 * @param menuBatalla
	 *            Sprite del menú de batalla. <br>
	 */
	public static void setMenuBatalla(final BufferedImage menuBatalla) {
		Recursos.menuBatalla = menuBatalla;
	}

	/**
	 * Devuelve el sprite del menú de batalla deshabilitado. <br>
	 * @return Sprite del menú de batalla deshabilitado. <br>
	 */
	public static BufferedImage getMenuBatallaDeshabilitado() {
		return menuBatallaDeshabilitado;
	}

	/**
	 * Establece el sprite del menú de batalla deshabilitado. <br>
	 * @param menuBatallaDeshabilitado
	 *            Sprite del menú de batalla deshabilitado. <br>
	 */
	public static void setMenuBatallaDeshabilitado(final BufferedImage menuBatallaDeshabilitado) {
		Recursos.menuBatallaDeshabilitado = menuBatallaDeshabilitado;
	}

	/**
	 * Devuelve el sprite del item nulo. <br>
	 * @return Sprite del item nulo. <br>
	 */
	public static BufferedImage getNoItem() {
		return noItem;
	}

	/**
	 * Establece el sprite del item nulo. <br>
	 * @param noItem
	 *            Sprite del item nulo. <br>
	 */
	public static void setNoItem(final BufferedImage noItem) {
		Recursos.noItem = noItem;
	}

	/**
	 * Devuelve el sprite del chat. <br>
	 * @return Sprite del chat. <br>
	 */
	public static BufferedImage getChat() {
		return chat;
	}

	/**
	 * Establece el sprite del chat. <br>
	 * @param chat
	 *            Sprite del chat. <br>
	 */
	public static void setChat(final BufferedImage chat) {
		Recursos.chat = chat;
	}
}
