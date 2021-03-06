package comandos;

import javax.swing.JOptionPane;

import dominio.Item;
import mensajeria.PaqueteComerciar;

/**
 * Clase que administra el comando de actualización del comercio. <br>
 */
public class ActualizarComercio extends ComandosEscucha {
    /**
     * Tamaño de cuenta. <br>
     */
    private static final int CUENTA_SIZE = 9;

    /**
     * Ejecuta la actualización del comercio. <br>
     */
    @Override
    public final void ejecutar() {
        int sizeMisItems = juego.getCliente().getM1().getSizeItems();
        int sizeADar = juego.getCliente().getM1().getDar().size();
        int sizeAObtener;
        int cuentaSize;
        PaqueteComerciar paqueteComerciar;
        paqueteComerciar = gson.fromJson(cadenaLeida, PaqueteComerciar.class);
        sizeAObtener = paqueteComerciar.getItemsADar().size();
        cuentaSize = sizeMisItems - sizeADar + sizeAObtener;
        if (sizeADar != 0) {
            if (cuentaSize <= CUENTA_SIZE) {
                juego.getCliente().getM1().getChckbxListo().setEnabled(true);
                juego.getCliente().getM1().getLeyenda().setVisible(false);
            } else if (cuentaSize > CUENTA_SIZE) {
                juego.getCliente().getM1().getChckbxListo().setEnabled(false);
                juego.getCliente().getM1().getLeyenda().setVisible(true);
            }
        }
        if (sizeAObtener == 0) {
            juego.getCliente().getM1().getChckbxListo().setEnabled(false);
            juego.getCliente().getM1().getLeyenda().setVisible(true);
        }
        if (juego.getCliente().getPaqueteComercio()
                .getListo() == paqueteComerciar.getListo()) {
            // actualizar la lista
            juego.getCliente().getM1().getObtener().removeAllElements();
            for (Item item : paqueteComerciar.getItemsADar()) {
                juego.getCliente().getM1().getObtener()
                        .addElement(item.getNombre());
            }
            juego.getCliente().getPaqueteComercio()
                    .setItemsAObtener(paqueteComerciar.getItemsADar());
        } else {
            // se modifico el listo
            // me fijo si puso listo o lo saco
            if (juego.getCliente().getPaqueteComercio()
                    .getListo() < paqueteComerciar.getListo()) {
                juego.getCliente().getPaqueteComercio().aumentarListo();
            } else {
                juego.getCliente().getPaqueteComercio().disminuirListo();
            }
            // modifico la cant de listos en el jframe y tambien el lbl
            juego.getCliente().getM1()
                    .setCantListos(paqueteComerciar.getListo());
            juego.getCliente().getM1().getCantListo().setText(
                    String.valueOf(juego.getCliente().getM1().getCantListos())
                            + "/2");
            if (juego.getCliente().getM1().getCantListos() == 2) {
                JOptionPane.showMessageDialog(juego.getCliente().getM1(),
                        "Se ha realizado con exito el comercio");
                juego.getCliente().getM1().dispose();
            }
        }
    }
}
