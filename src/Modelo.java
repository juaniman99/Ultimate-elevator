//	Project By Juan Torres Gómez

public class Modelo {
	int offset = 100;	//	Este offset servir� para compensar los margenes inferiores y superiores del jlabel (esto es as� para facilitar un poco los calculos).
	int velocidad = 8;	//Velocidad del ascensor.
	int velocidadCabin = 1;	//Velocidad de la cabina en miniatura (solo por estética). Si se modifica alguna de las velocidades, se desincronizarán.
	
	public int plantaActual;	//Planta en la que se encuentra.
	public int plantaToGo;	//Planta a la que ha de ir
	public int plantaMostrando;	//Podemos decir que es la transici�n.
	
	public Modelo() {
		super();
		this.plantaActual = 0;
		this.plantaToGo = 0;
		this.plantaMostrando = 0;
	}
	
	public boolean isSubiendo() {	//True si sube; False si baja
		if(plantaActual > plantaToGo)
			return false;
		else
			return true;
	}
	
	public void addPlant(int i) {
		plantaActual+=i;
	}
	public int calcularDistancia() {	//Lo importante es que devuelva 0 cuando ya haya llegado a la planta destino.
		return plantaToGo - plantaMostrando;
	}
}
