package org.edu.unal.pc.clases;

public class App {
    public static void main(String[] args) {
    	Calendario cal = new Calendario(); // instanciar la clase con los metodos
    	cal.leercsv("C:\\Users\\Carolina\\Documents\\Mesagosto1.csv"); // llamamos el metodo para leer o importar el archivo csv, y colocamos la direccion del archivo
    	cal.imprima();                 //llamamos el metodo para imprimir la matriz a la cual pasamos del archivo (METODO OPCIONAL ERA SOLO PARA SABER SI ESTABA SALIENDO BIEN TODOS LOS PASOS)
    	String habito = "Montar bicicleta"; // colocamos el habito en String
    	String dia = "13";    // colocamos el numero del dia en String
    	cal.agregarhabi(dia, habito); // llamamos el metodo para agragar el habito y en el primer argumento colocamos el dia y en el segundo el habito
    	cal.separarceldas();  // llamamos el metodo para pasar las info de matrizAgo a la matrizexport que su informacion se va a exportar a demas se le adiciona el ";" para que los elementos esten en cada casilla
    	cal.imprima(); // llamamos metodo para imprimir la matriz (METODO DE PRUEBA SE PUEDE OMITIR)
    	cal.Export();// llamamos el metodo para exportar o escribir en el archivola informacion de la matriz
    
}
}