package comandos;

import mensajeria.PaqueteDeEnemigos;

public class ActualizarEnemigos extends ComandosEscucha {

	
	@Override
	public void ejecutar() {
		PaqueteDeEnemigos pde = (PaqueteDeEnemigos) gson.fromJson(cadenaLeida, PaqueteDeEnemigos.class);
		juego.setEnemigosConectados(pde.getEnemigos());
	}
}
