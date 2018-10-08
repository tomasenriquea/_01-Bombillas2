package uF4.trabajos.A2_03_10_2018._01;

import java.util.Scanner;

public class Bombilla {

	// Determinaran la cantiadad de bombillas y la intensidad maxima.
	static final int CANTIDAD_BOMBILLAS = 20, MAX_INTENSIDAD = 5;

	private int intensidad;
	private String estado;  // Encendido o apagado, Si esta quemada o no.

	// CONSTRUCTOR
	public Bombilla(int intensidad) {
		this.intensidad = intensidad;
	}

	// GETTERS
	public int getIntensidad() {
		return intensidad;
	}

	public String getEstado() {
		return estado;
	}

	// SETTERS
	public void setIntensidad(int intensidad) {
		final int LIMITE = 5;
		if (intensidad <= LIMITE) { // Esto controlara el maximo permitido de intensidad.
			this.intensidad = intensidad;
		}
	}

	public void setEstado(String estado) {
		this.estado = estado;
	} 
	
	
	// DETALLES DE BOMBILLAS
	public void detallesEstadoBombilla(int numero) {
		if (intensidad == 0) { 
			estado = "Apagado";
		} else if (intensidad > 0 && intensidad <= 5) {
			estado = "Encendido";
		}
		System.out.print("\nLa intensidad es de " + intensidad + " en la bombilla Nº" + (numero + 1) + ", se encuentra: "  +  estado);
	}
	

	//------------------------------------------------------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------------------------------
	
	// Esto es para mostrar el menú de opciones.
		public static int menu() {
			
			System.out.println("\n\n\n");
			System.out.println("||||||||||||||||||||||||||||||||||||||||||||||");
			System.out.println("|||||||||||||||||||BOMBILLAS||||||||||||||||||");
			System.out.println();
			System.out.println("1. Inicializar las Bombillas.\n" + 
							   "2. Verificar estado de bombillas.\n" + 
							   "3. Subir o bajar intensidad de una bombilla\n" +
							   "4. Estados de las bombillas en cantidades.\n" + 
							   "5. Verificar cuales son las bombillas fundidas.\n" +
							   "0. Salir.");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int dato;
			do {
				System.out.print("\nElija un opción: ");  // Controla que solo se ingrese una de las 4 opciones.
				dato = sc.nextInt();
			}while(dato > 5);

			return dato;
		}
	//-----------------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------------------------------------------------------------------------------------------
	
	// CASO 1: Este método recibira un objeto e inicializa las 6 bombillas de 0 a 5
	static void inicializar(Object bombilla[]) {
		for (int i = 0; i < CANTIDAD_BOMBILLAS; i++) {
			bombilla[i] = new Bombilla((int) (Math.random() * 6)); // Da un valor de intensidad de 0 a 5
		}
		System.out.println("Se han creado: " + CANTIDAD_BOMBILLAS + " Bombillas.");
		System.out.println("\nBombillas inicializadas.\n\n");
	}
	
	
	//CASO 2: Es para mostrar el estado de las bombillas
	static void muestraEstados(Object bombilla[]) {
		try {
			System.out.print("\nValores de las Bombillas:");
			for(int i = 0; i < CANTIDAD_BOMBILLAS; i++) { 	
				if(bombilla[i] != null) {  // si la bombilla esta quemada, esta no se mostrada su estado.
					((Bombilla) bombilla[i]).detallesEstadoBombilla(i);  // esto llama al metodo para mostrar los detalles, si estan apagadas o encendidas.
				}	
			}   
		}
		catch (Exception error) {
			System.err.println(" ERROR\nPrimero inicialice las bombillas.");
		}
		System.out.println("\n\n");
	}
	

	//CASO 3: Esta funcion es para modificar la intensidad de las bombillas
	static void modificarIntensidad(Object bombilla[]) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int foco, intensidad;
		do {  // Esto verifica que solo se elija una de las 6 bombillas
			System.out.print("\nElija una de las "  + CANTIDAD_BOMBILLAS + " bombillas: ");
			foco = sc.nextInt();

		}while(foco > CANTIDAD_BOMBILLAS);

		System.out.print("ingrese una intensidad: ");
		intensidad = sc.nextInt();
		
		try {
			((Bombilla) bombilla[foco - 1]).setIntensidad(intensidad); // Subiendo o bajando la intensidad de una bombilla
			if(intensidad > MAX_INTENSIDAD) {  // Con esto bloqueamos la bombilla cuando se quema.
				System.out.println("\n¡¡¡ La Bombilla "  + foco + " se ha quemado. !!!");
				bombilla[foco - 1] = null;  // La bombilla quemada es anulada para que ya no se pueda modificar.
			}
		}
		catch (Exception e) {
			System.err.println(" ERROR\nPrimero inicialice las bombillas.");
		}
	
		System.out.println("\n\n");
	}
	
	
	//CASO 4:  aqui se ven las candidades de bombillas quemadas, apagadas y encendidas.
	static void estadosCantidad(Object bombilla[]) {
		int encendidas = 0, apagadas = 0, quemadas = 0;
		
		try {
			System.out.print("\nEstados de las Bombillas:");
			for(int i = 0; i < CANTIDAD_BOMBILLAS; i++) { 				
				if(bombilla[i] == null) { 
					quemadas++;
				}
				else if((((Bombilla) bombilla[i]).getIntensidad()) == 0){  // aqui se obtiene el valor de la intensidad y se compara 
					apagadas++;
				}
				else if((((Bombilla) bombilla[i]).getIntensidad())  > 0){
					encendidas++;
				}
			}  
			System.out.println("\nBombillas quemadas: " + quemadas + 
							   "\nBombillas apagadas: " + apagadas + 
							   "\nBombillas encendidas: " + encendidas);
		}
		catch (Exception error) {
			System.err.println(" ERROR\nPrimero inicialice las bombillas.");
		}
	}


	//CASO 5: id de bombilla para saber cuales bombillas estan quemadas.
	static void idBombillasFundidas(Object bombilla[]) {
		try {
			System.out.print("\nEstados de las Bombillas:");
			for(int i = 0; i < CANTIDAD_BOMBILLAS; i++) { 				
				if(bombilla[i] == null) {
					System.out.print("\nLa Bombilla " + (i + 1) + " se encuentra quemada.");
				}
			}  
		}
		catch (Exception error) {
			System.err.println(" ERROR\nPrimero inicialice las bombillas.");
		}	
	}
	
}
