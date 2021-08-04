package habitos;
import java.util.Scanner;

public class Hola {
	public static void main(String[] args) {
		Categoria cat = new Categoria();
		Scanner scan = new Scanner (System.in);
		cat.nombre= scan.next();
		cat.color= "rojo";
		scan.close();
		System.out.println(cat.nombre);
		System.out.println(cat.color);
		
		Categoria cat1 = new Categoria();
		cat1.descripcion= "sdfkhljfañls0 :D";
		cat1.color = "azul";
		
		System.out.println(cat1.color);		

	}

}
