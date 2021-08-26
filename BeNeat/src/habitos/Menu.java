package habitos;
public class Menu extends App{			
	public static void main(String[] args) {
		Scanner sn =new Scanner(System.in);
		boolean salir = false;
		int opcion;
		while(!salir) {
		System.out.println("Bienvenido a BeNeat");
		System.out.println("1.¿Crear y agregar nuevos hábitos?");
		System.out.println("2.Eliminar hábitos");
		System.out.println("3.seguimiento");
		System.out.println("4.información nutricional y actividad física");
		System.out.println("¿Que desea hacer el dia de hoy? Escriba un numero");
		
		opcion=sn.nextInt();
		
		switch(opcion) {
			
		case 1: agregarHabitos();
			salir=true;
			break;
		case 2: eliminarHabito();
			salir=true;
			break;
		case 3: añadirProgreso();
			salir=true;
			break;
		case 4: verGuiaNutricional();
			salir=true;
			break;
		default : System.out.println("Escriba el numero de la opcion deseada");
			break;}}
		sn.close();}}
