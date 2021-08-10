package habitos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Calendario {
	private BufferedReader lector;
	private String linea;
	private String partes[] = null;
	private String[][] matrizago = new String[7][7];
	private String[][] matrizexport = new String[7][7];
	private String [][]habitosexit = new String [1000][];

	public void leercsv(String nomarchivo) {
		try {
			lector = new BufferedReader(new FileReader(nomarchivo));// la variable lector con la libreria bufferedReader lee el archivo 
			int j = 0;                                              // la variable j es para llenar la matriz de agosto y j representa las filas de la matrizago
			while ((linea = lector.readLine()) != null) {  // este ciclo nos crea una nueva linea llamada linea que es igual a lector.readLine, lector.readLine lee toda la linea del alchivo csv
				partes = linea.split(";");                 // la funcion split separa todo el String que leyo del archivo y lo separa por cada ; convirtiendo el String leido del archivo en una arreglo llamado partes
				imprimirLinea();// este es un metodo para imprimir la informacion que extraemos o leemos del archivo csv 
				llenarma(j); // este metodo es para pasar la informacion del arreglo partes, partes por cada vez que hace el ciclo recorre una nueva fila del archivo por lo cual esta informacion se pasa a la matrizago
				j++;         // incremento j para que se cambie la fila de matrizago 
			}
			System.out.println();
			lector.close();// cerramos la variable lector para que no se use mas
			linea = null;// colocamos linea = null para indicar que se finalizo el trapaso de la informacion del archivo a la matrizAgo
			}catch(IOException e) {  // esto es en caso de que ocurra un error en los pasos anteriores
	            System.out.println("Error E/S: "+e); // nos muestra este mensaje en caso de error
		}
		
	}
	public void llenarma(int g){              //metodo para pasar la informacion del arreglo partes que tiene la informacion de archivo por linea, se pide un argumento entero el cual nos indica la fila en la cual se deposita la informacion en la marizAgo
		for(int v =0; v<partes.length;v++ ) {// ciclo for para pasar todos los elemento del arreglo partes a la fila g de la matriAgo
			matrizago[g][v]=partes[v];// aqui se pasa la informacion
			}
	}
	public void imprimirLinea() {// metodo para mostrar la informacion que extraimos del archivo
		for(int i =0;i<partes.length;i++) {
			System.out.print(partes[i]);
		}
		System.out.println("\n");
	}
	public void agregarhabi(String nump,String yt) {// este metodo es para agregar el habito que el usuario ingrese, acepta dos argumento un String que es el numero del dia en el que quiere ingresar el habito y otro es el habito num es el dia, yt es el habito
		for(int tr =0;tr<matrizago.length;tr++) { // ciclos for para buscar en todas las casillas cual tiene el dia que el usuario ingreso
			for(int ew =0; ew<matrizago[tr].length;ew++) {
				String par [] = matrizago[tr][ew].split(" ");//separamos lo que hay en la casilla para poder comparar con el dia del mes
				
				if(par[0].equals(nump)) { //al ya separar lo que habia en la casilla usamos lo que esta en la primera posiscion para ayudarnos a comparar el dia ingreso el usuario
					
					matrizago[tr][ew]+=" ";// agregamos un espacio para que no este pegado todo en la casilla
					matrizago[tr][ew]+=(yt);                   // se cambia el valor de la variable con el numero de la fila donde esta el dia
					                  // se cambia el valor de la variable con el numero de la columna donde esta el dia
				}
			}
		}
		
	}
	public void imprima() {        // metodo para imprimir la matrizago para saber que contiene esta
		for(int qe =0;qe<matrizago.length;qe++) { // ciclos for para las distintas posiciones de las filas y columnas
			for(int qr=0;qr<matrizago[qe].length;qr++) {
				System.out.print(matrizago[qe][qr]+"\t");
				                                      // imprimir el valor de la matriz
			}
			System.out.print("\n");	 // indicar que cambiamos de linea
		}	
	}
	public void separarceldas() { // metodo para pasar el valor de matrizago a otra matriz que se va a exportar en un nuevo archivo
		for(int qa =0;qa<matrizago.length;qa++) { // ciclos for para pasar por todas las filas y columnas del arreglo
			for(int fr=0;fr<matrizago[qa].length;fr++) {
				matrizexport[qa][fr]= matrizago[qa][fr].concat(";");	// pasamos le informacion de matrizago a matrizexport y a cada elemento le concatenamos un ";" para que al momento de exportar cada elemento de la matriz sea una casilla en excel
			}
		}	
	}
	public void Export() { // metodo para exportar o escribir en un archivo csv
		 try(
		            BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Users\\Carolina\\Documents\\Mesagosto1.csv"));){ // la variable bw sera la encargada de escribir con la ayuda de la libreria bufferedwriter
		            
			 for(int l =0;l<matrizexport.length;l++) {       // ciclos for para recorrer todos los elementos de la matriz
				 for(int kj =0; kj<matrizexport[l].length;kj++) {
					 bw.write(matrizexport[l][kj]);     //  la funcion de la libreria .write escribe en el archivo el elemento de la matriz 
				 }
				 bw.newLine();// la funcion newline nos dice que ya escribio una linea y pase a otra nueva
			 }
			 bw.flush(); // funcion para cerrar le escritura 
		        }catch(IOException e){ // libreria por si hay un error en el proceso de escritura
		            System.out.println("Error E/S: "+e);
		        }
	}
}
