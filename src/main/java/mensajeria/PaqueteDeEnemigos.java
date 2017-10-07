package mensajeria;

import java.io.Serializable;
import java.util.Map;

public class PaqueteDeEnemigos extends Paquete implements Serializable, Cloneable {

	private Map<Integer, PaqueteEnemigo> enemigos;

	public PaqueteDeEnemigos(){

	}

	public PaqueteDeEnemigos(Map<Integer, PaqueteEnemigo> enemigos){
		this.enemigos = enemigos;
	}

	public Map<Integer, PaqueteEnemigo> getEnemigos(){
		return enemigos;
	}

	@Override
	public Object clone() {
		Object obj = null;
		obj = super.clone();
		return obj;
	}
}