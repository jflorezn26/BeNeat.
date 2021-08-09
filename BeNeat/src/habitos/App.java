package habitos;

public class App {
    public static void main(String[] args) {
    	Menu me = new Menu();
    	
    	Calendario cal = new Calendario(); // instanciar la clase con los metodos
    	cal.leercsv("C:\\Users\\Carolina\\Documents\\Mesagosto1.csv"); // llamamos el metodo para leer o importar el archivo csv, y colocamos la direccion del archivo
    	cal.imprima();                 //llamamos el metodo para imprimir la matriz a la cual pasamos del archivo (METODO OPCIONAL ERA SOLO PARA SABER SI ESTABA SALIENDO BIEN TODOS LOS PASOS)
    me.saludo();
    me.MenuB();
    	cal.separarceldas();  // llamamos el metodo para pasar las info de matrizAgo a la matrizexport que su informacion se va a exportar a demas se le adiciona el ";" para que los elementos esten en cada casilla
    	cal.imprima(); // llamamos metodo para imprimir la matriz (METODO DE PRUEBA SE PUEDE OMITIR)
    	cal.Export();// llamamos el metodo para exportar o escribir en el archivola informacion de la matriz
    
}
}