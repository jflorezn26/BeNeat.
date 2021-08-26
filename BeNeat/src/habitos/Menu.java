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
			System.out.println("1. ¿Crear y agregar nuevos hábitos?");
			System.out.println("2. Eliminar hábitos");
			System.out.println("3. Seguimiento");
			System.out.println("4. Información nutricional y actividad física");
			System.out.println("5. Ver agenda del día");
			System.out.println("6. Ver agenda del mes");
			System.out.println("7. Salir de la aplicación");
			System.out.println("¿Que desea hacer el dia de hoy? Escriba un numero");

			
				try {
				opcion = sc.nextInt();

				switch (opcion) {

				case 1:
					agregarHabitos();
					
					break;
				case 2:
					System.out.println(
							"Desea eliminar un hábito por completo o un hábito en un día específico?\n1. Eliminar hábito completo.\n2. Eliminar hábito en un día específico");
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
							System.out.println("Ha digitado una opción inexistente.");
						}
					} catch (Exception e) {
						System.out.println("Ha digitado un valor inválido");
					}
					
					break;
				case 3:
					añadirProgreso();
					
					break;
				case 4:
					verGuiaNutricional();
					
					break;
				case 7:
					System.out.println("Finalizando sesión...");
					salir = true;
					
					break;
				case 6:
					verAgendaMes();
					
					break;
				case 5:
					verAgendaDia();
					break;
				default:
					System.out.println("Escriba el numero de la opción deseada");
					break;
				}
				}catch (Exception e) {
					System.out.println("Ha digitado un valor inválido");
				}
			
			
		}
		sc.close();
		scan.close();
		cal.separarceldas();
		cal.Export();
	}
}
