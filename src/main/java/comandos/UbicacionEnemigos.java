package comandos;

import mensajeria.PaqueteDeUbicacionEnemigos;

public class UbicacionEnemigos extends ComandosEscucha{

	@Override
	public void ejecutar() {
		PaqueteDeUbicacionEnemigos pdm = (PaqueteDeUbicacionEnemigos) gson.fromJson(cadenaLeida,PaqueteDeUbicacionEnemigos.class);
		juego.setUbicacionEnemigos(pdm.getEnemigos());		
	}
}
