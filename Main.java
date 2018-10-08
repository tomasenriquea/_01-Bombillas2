package uF4.trabajos.A2_03_10_2018._01;

import java.util.Scanner;

public class Main {
	
	// Esto es para mostrar el men� de opciones.
	public static int menu() {
		System.out.println("\n\n\n");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("|||||||||||||||||||BOMBILLAS||||||||||||||||||");
		System.out.println();
		System.out.println("1. Inicializar las Bombillas.\n" + 
						   "2. Verificar estado de bombillas.\n" + 
						   "3. Subir o bajar intensidad de una bombilla\n" + 
						   "0. Salir.");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int dato;
		do {
			System.out.print("\nElija un opci�n: ");  // Controla que solo se ingrese una de las 4 opciones.
			dato = sc.nextInt();
		}while(dato > 3);
		
		return dato;
	}
	
		
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		int cantidadBombillas = Bombilla.CANTIDAD_BOMBILLAS;  // Es la cantidad de bombillas.
		int intesidadMaxima = Bombilla.MAX_INTENSIDAD; // Es la maxima intensidad
		
		
		Bombilla bombilla[] = new Bombilla[cantidadBombillas];  // esto es un array de objetos Bombillas.
		Scanner sc = new Scanner(System.in);  // para entrada de opciones o elegir una bombilla.
		int respuesta;  // Representa la opcion elejida.
		//int cantidadBombillas, bombillasApagadas, bombillasEncendidas, quemadadas;
		//boolean estado = false;
	
		do {
			respuesta = menu();  // Llama al menu de opciones devolviendo un valor entero.
			
			switch(respuesta){
			case 1: 
				// Aqu� se inicializa las 6 bombillas de 0 a 5
				Bombilla.inicializar(bombilla);  
				System.out.println("\nBombillas inicializadas.\n\n");		
				break;
				
			case 2:
				// Aqu� se verifica el estado inicializado de las bombillas.
				try {
					System.out.print("\nValores de las Bombillas:");
					for(int i = 0; i < cantidadBombillas; i++) { 	
						if(bombilla[i] != null) {  // si la bombilla esta quemada, esta no se mostrada su estado.
							bombilla[i].detallesBombilla();
							System.out.print(" en la Bombilla N�" + (i + 1));	
						}	
					}   
				}
				catch (Exception error) {
					System.err.println(" ERROR\nPrimero inicialice las bombillas.");
				}
				System.out.println("\n\n");
				break;
			
			case 3:
				//Aqu� se podra aumentar o bajar la intensidad de una bombilla.
				int foco;
				do {  // Esto verifica que solo se elija una de las 6 bombillas
					System.out.print("\nElija una de las "  + cantidadBombillas + " bombillas: ");
					foco = sc.nextInt();

				}while(foco > cantidadBombillas);

				System.out.print("ingrese una intensidad: ");
				int intensidad = sc.nextInt();
				
				try {
					bombilla[foco - 1].setIntensidad(intensidad); // Subiendo o bajando la intensidad de una bombilla
					if(intensidad > intesidadMaxima) {  // Con esto bloqueamos la bombilla cuando se quema.
						System.out.println("\n��� La Bombilla "  + foco + " se ha quemado. !!!");
						bombilla[foco - 1] = null;  // La bombilla quemada es anulada para que ya no se pueda modificar.
					}
				}
				catch (Exception e) {
					System.err.println(" ERROR\nPrimero inicialice las bombillas.");
				}
				
				System.out.println("\n\n");
				break;
		}
			
		}while(respuesta != 0);
		
	}
	
}


/*
A12 - Bombillas de intensidad variable
    Queremos utilizar bombillas de intensidad variable para un videojuego.
    La intensidad de la bombilla toma un valor de 0 a 5, cero si la bombilla est� apagada. 

[x] Si la intensidad sobrepasa el nivel 5 la bombilla se quema y deja de funcionar. Ya no se puede modificar la intensidad de 
   la bombilla si est� apagada. 
   

[x]1) Dise�ar una aplicaci�n Java que controle seis bombillas de manera las lleve a un estado inicial en que una bombilla est� 
     apagada y cada una de las otras tenga una intensidad diferente. Muestre este estado inicial

[x]2) suba la intensidad de cada una de las bombillas y mostrad su estado

[x]3) Baje la intensidad de cada una de las bombillas y mostrad su estado


A2.1 - Bombilla 2. Static / no static.
Modifique la clase bombilla que hicisteis en la sesi�n anterior de manera que se pueda saber (con los m�todos correspondientes):
1 [] Cu�ntas bombillas se han creado en total.
2 [] Cu�ntas bombillas est�n apagadas, cu�ntas encendidas y cu�ntas se han fundido.
3 [] �Cu�les son las bombillas que se han fundido (hay que asignar un n�mero diferente en cada bombilla). Puede suponer que como 
     mucho habr� 20 bombillas.

A parte [] poner cuando una bomnilla se quema.





*/
