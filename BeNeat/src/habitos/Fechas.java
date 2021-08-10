package habitos;

import java.util.Calendar;
import java.util.GregorianCalendar;
/* En esta clase se encuentra el código que configura el calendario
 * Tan pronto se realicen todos los ajustes, se creará el método para que sea ejecutada 
 * desde la clase principal (App)
 */
public class Fechas {

	static Dia año [][] =  new Dia[12][31];
	Fechas() {
		for (int i = 0; i< año.length  ;i++) {
		
		for (int j = 0; j <año[i].length; j++) {
		
		año[i][j] = new Dia ();
		if (i==0||i==2||i==4||i==6||i==7||i==9||i==11) {
		año[i][j].fecha = new GregorianCalendar (2020,i,j+1); 
		}
		if(i==1) {
		if (j<28)
			año[i][j].fecha = new GregorianCalendar (2020,i,j+1);
		else
			año[i][j].fecha = null;
		}
		if (i==3||i==5||i==8||i==10) {
		if (j<30)
			año[i][j].fecha = new GregorianCalendar (2020,i,j+1);
		else
			año[i][j].fecha = null;
		}
		
	}
 }
}
	public static void main(String[] args) {
		final Fechas agenda = new Fechas();
    	agenda.imprimirFechas();
	}
	
 void imprimirFechas() {
		for (int i = 0; i< año.length  ;i++) {
			switch( i) {
			case 0:
				System.out.println("Enero"); break;
			case 1:
				System.out.println("Febrero");
				break;
			case 2 : 
				System.out.println("Marzo");break;
			case 3:
				System.out.println ("Abril");
				break;
			case 4:
				System.out.println("Mayo");break;
			case 5:
				System.out.println ("Junio");
				break;
			case 6:
				System.out.println("Julio"); break;
			case 7:
				System.out.println("Agosto"); break;
			case 8:
				System.out.println ("Septiembre");
				break;
			case 9:
				System.out.println("Octubre"); break;
			case 10:
				System.out.println ("Noviembre");
				break;
			case 11:
				System.out.println("Diciembre");break;}
			
		for (int j = 0; j <año[i].length; j++) {
			if(año[i][j].fecha != null) {
				System.out.println();
				System.out.println(año[i][j].fecha.get(Calendar.DATE));	
				if (año[i][j].contador==-1)
					System.out.println("Nada programado para este día :)");
				
				System.out.println();
			}
			}
			
		}
		
		
	}
		
}
	















