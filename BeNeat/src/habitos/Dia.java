package habitos;

import java.util.Calendar;
/*Esta clase se crea con el objetivo de poder trabajar cada fecha por aparte.
 * Para cada día se podrán crear (por el momento) 10 objetos (hábitos) en el calendario.
 * Para ver los datos de cada día se creó la clase Fechas.
 * Hay que modificar el código que tenemos para permitir que los hábitos
 * se puedan crear periódicamente en lugar un día a la vez.
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
	



