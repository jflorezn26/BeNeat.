package habitos;

import java.util.Calendar;
/*Esta clase se crea con el objetivo de poder trabajar cada fecha por aparte.
 * Para cada d�a se podr�n crear (por el momento) 10 objetos (h�bitos) en el calendario.
 * Para ver los datos de cada d�a se cre� la clase Fechas.
 * Hay que modificar el c�digo que tenemos para permitir que los h�bitos
 * se puedan crear peri�dicamente en lugar un d�a a la vez.
 */
public class Dia {

	int contador = -1;
	Calendar fecha;
	Habitos [] agenda = new Habitos[10];	
	
	Dia(){		
		for (int i =0; i<agenda.length;i++)
			agenda[i] =  new Habitos();
	}
	
	void nuevoHabito() {
		
	}
	
	public String toString() {
		
	return null;
	}
	
}
	



