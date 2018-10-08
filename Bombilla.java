package uF4.trabajos.A2_03_10_2018._01;




public class Bombilla {
	
	// Determinaran la cantiadad de bombillas y la intensidad maxima.
	static final int CANTIDAD_BOMBILLAS = 20, MAX_INTENSIDAD = 5; 
	//int valores = (int)(Math.random() * 5);
	
	private int intensidad;
	private boolean estado, estadoFisico;  // Encendido o apagado, Si  esta quemada o no.
	
	


	
	//CONSTRUCTOR
	public Bombilla(int intensidad) {
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

	
	// Este método recibira un objeto e inicializa las 6 bombillas de 0 a 5
	static void inicializar(Object bombilla[]){
		for(int i = 0; i < CANTIDAD_BOMBILLAS; i++) {  
			bombilla[i] = new Bombilla((int)(Math.random() * 6));  // Da un valor de intensidad de 0 a 5 
		} 
	} 
	
	
	
	
	//---------------------------------------------------------------------------------
	
	
	
	
	public boolean isEstado() {
		return estado;
	}

	public boolean isEstadoFisico() {
		return estadoFisico;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void setEstadoFisico(boolean estadoFisico) {
		this.estadoFisico = estadoFisico;
	}
	
	
	public void estado() {
		
	}
	
	
	
	
	
	
	
	


}
