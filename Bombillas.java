package uF4.trabajos.A2_03_10_2018._01;




public class Bombillas {
	
	private int intensidad;


	
	//CONSTRUCTOR
	public Bombillas(int intensidad) {
		this.intensidad = intensidad;
	}

	//GETTERS
	public int getIntensidad() {
		return intensidad;
	}


	//SETTERS
	public void setIntensidad(int intensidad) {
		final int LIMITE = 5;
		if(intensidad <= LIMITE) { // Esto controlara el maximo permitido de intensidad.
			this.intensidad = intensidad;
		}
		
	}
	

	//DETALLES DE BOMBILLAS
	public void detallesBombilla() {
		System.out.printf("\nLa intensidad es: %d", intensidad);
	}


}
