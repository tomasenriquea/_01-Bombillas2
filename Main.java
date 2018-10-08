package uF4.trabajos.A2_03_10_2018._01;

public class Main {
	
	public static void main(String[] args) {
		
		Bombilla bombilla[] = new Bombilla[Bombilla.CANTIDAD_BOMBILLAS];  // esto es un array de objetos Bombillas.
		int respuesta;  // Representa la opcion elejida y la intensidad de la bombilla.

	
		do {
			respuesta = Bombilla.menu();  // Llama al menu de opciones devolviendo un valor entero.
			
			switch(respuesta){
			case 1: 
				// Aqu� se inicializa las 6 bombillas de 0 a 5
				Bombilla.inicializar(bombilla);  		
				break;
				
			case 2:
				// Aqu� se verifica el estado inicializado de las bombillas.
				Bombilla.muestraEstados(bombilla);
				break;
			
			case 3:
				//Aqu� se podra aumentar o bajar la intensidad de una bombilla.
				Bombilla.modificarIntensidad(bombilla);		
				break;
			
			case 4:		
				// Mostrara lso diferentes estados de las bombillas 
				Bombilla.estadosCantidad(bombilla);
				break;
			
			case 5:
				//mostrara una lista enumerada de las bombillas quemadas.
				Bombilla.idBombillasFundidas(bombilla);
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
1 [x] Cu�ntas bombillas se han creado en total.
2 [x] Cu�ntas bombillas est�n apagadas, cu�ntas encendidas y cu�ntas se han fundido.
3 [x] �Cu�les son las bombillas que se han fundido (hay que asignar un n�mero diferente en cada bombilla). Puede suponer que como 
     mucho habr� 20 bombillas.

A parte [x] poner cuando una bomnilla se quema.





*/
