package habitos;

import java.util.Scanner;

public class Menu extends App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean salir = false;
		int opcion;
		cal.leercsv();
		while (!salir) {

			System.out.println("\nBienvenido a BeNeat");
			System.out.println("1. �Crear y agregar nuevos h�bitos?");
			System.out.println("2. Eliminar h�bitos");
			System.out.println("3. Seguimiento");
			System.out.println("4. Informaci�n nutricional y actividad f�sica");
			System.out.println("5. Ver agenda del d�a");
			System.out.println("6. Ver agenda del mes");
			System.out.println("7. Salir de la aplicaci�n");
			System.out.println("�Que desea hacer el dia de hoy? Escriba un numero");

			
				try {
				opcion = sc.nextInt();

				switch (opcion) {

				case 1:
					agregarHabitos();
					
					break;
				case 2:
					System.out.println(
							"Desea eliminar un h�bito por completo o un h�bito en un d�a espec�fico?\n1. Eliminar h�bito completo.\n2. Eliminar h�bito en un d�a espec�fico");
					try {
						int a = sc.nextInt();

						switch (a) {
						case 1:
							eliminarHabito();
							break;
						case 2:
							eliminarEventoEspecifico();
							break;
						default:
							System.out.println("Ha digitado una opci�n inexistente.");
						}
					} catch (Exception e) {
						System.out.println("Ha digitado un valor inv�lido");
					}
					
					break;
				case 3:
					a�adirProgreso();
					
					break;
				case 4:
					verGuiaNutricional();
					
					break;
				case 7:
					System.out.println("Finalizando sesi�n...");
					salir = true;
					
					break;
				case 6:
					verAgendaMes();
					
					break;
				case 5:
					verAgendaDia();
					break;
				default:
					System.out.println("Escriba el numero de la opci�n deseada");
					break;
				}
				}catch (Exception e) {
					System.out.println("Ha digitado un valor inv�lido");
				}
			
			
		}
		sc.close();
		scan.close();
		cal.separarceldas();
		cal.Export();
	}
}
