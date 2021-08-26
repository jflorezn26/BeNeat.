package habitos;

import java.util.*;
 
/** EN CASO DE ERRORES COMUNICARSE CON JOSHUA */
/**
 * IMPORTANTE CUANDO SE HABLE DEL NUMERO DEL MES SIEMPRE DEBE SER UNA VARIABLE O
 * DATO DE TIPO (int) CUANDO SE HABLE DEL NUMERO DEL DIA SIEMPRE DEBE SER UNA
 * VARIABLE O DATO DE TIPO (int) CUANDO SE HABLE DE HABITO DEBE SER UNA VARIABLE
 * O DATO DE TIPO (String) SI NO SE CUMPLE LO ANTERIOR GENERA ERRORES IMPORTANTE
 * PARA AGREGAR UN HABITO DE DEBE HACER CON EL SIGUIENTE FORMATO: SE LE DEBE
 * INFORMAR AL USUARIO QUE EL HABITO QUE INGRESE CORRESPONE A UN DIA EJEMPLO
 * leer_2_horas SIGNIFICA LEER 2 HORAS AL DIA HABITO + ESPACIO+ CANTIDAD EN
 * NUMEROS ENTEROS + ESPACIO + FORMATO DEL TIEMPO
 * 
 * EJEMPLO: leer 2 horas SI SE DESEA SER MAS ESPECIFICO CON EL HABITO SE PEUDE
 * HACER DE LA SIGUIENTE FORMA leer-articulos-cientificos 2 horas SE DEBE
 * AGREGAR GUIONES SI SE QUIERE ESCRIBIR MAS ESPECIFICO EL HABITO NUNCA
 * ESPACIOS, LOS ESPACIOS SON PARA SEPARAR EL NUMERO Y EL FORMATO DE TIEMPO SI
 * EL USUARIO NO INGRESA EL HABITO COMO SE MOSTRO ANTES SE DEBE PEDIR QUE
 * INTRODUZCA BIEN EL HABITO LOS HABITOS EN LA MATRIZ QUE TIENE TODOS LOS DIAS
 * DEL AÑO SE GUARDAN DE LA SIGUIENTE FORMA DIA + ESPACIO + HABITO+ GUION
 * BAJO(_)+ NUMERO+GUION BAJO(_)+FORMATO DEL TIEMPO EJEMPLO 10
 * leer-articulos-cientificos_2_horas o tambien 10 leer_2_horas POR ENDE CUANDO
 * SE IMPRIMA LOS HABITOS QUE EXISTEN SE MOSTRARA CON GUIONES BAJOS_ PERO SE LE
 * DEBE DECIR AL USUARIO QUE INGRESE LOS HABITOS CON ESPACIOS SI NO LO HACE
 * GENERARA ERRORES IMPORTANTE SIEMPRE QUE SE PIDA INGRESAR UN HABITO EL USUARIO
 * LO DEBE HACER CON ESPACIO COMO SE INDICO ANTERIORMENTE
 **/

public class App {
	public static String direccion = new String();
	static Scanner scan = new Scanner(System.in);
	static Calendario cal = new Calendario();
	
	
	public static void main(String[] args) {
	
		cal.leercsv();
		/**
		 * ESTE ES EL METODO QUE LEER Y PASA LA INFORMACION QUE ESTA EN LOS ARCHIVOS A
		 * LAS RESPECTIVAS MATRICES Y ARREGLOS DEBE COLOCAR LA DIRECCION EN DONDE ESTA
		 * EL ARCHIVO CON EL NOMBRE IMPORTANTE ESTAR EN FORMATO CSV
		 */
		
		
		
        scan.close();
		
		/**
		 * ESTOS DOS METODOS SIEMPRE DEBEN IR AL FINAL DE LA APLICACION ESTOS SON LOS
		 * METODOS QUE PASAN LA INFORMACION QUE ACTUALIZAMOS ANTES Y LA ESCRIBEN EN EL
		 * ARCHIVO
		 */
		cal.separarceldas();
		cal.Export();
		
	}
	
	public static void agregarHabitos() {
		System.out.println("Ingrese el d�a y el mes (n�mero) que en el que desea agregar un h�bito");
		int nump = scan.nextInt(), me = scan.nextInt();
		System.out.println("Ingrese el h�bito.");
		System.out.println("IMPORTANTE para ingresar un habito nuevo lo debe hacer con el siguiente formato \n ejemplo: caminar 60 minutos (se entiende que cada habito es diario) \n como puede ver debe ingresar la accion a realizar + espacio+ numero de la cantidad+ espacio+ condicion \nSi desea agregar mas informacion al habito lo pued hacer con guiones ejemplo: leer-articulos-cientificos 3 horas \n como puede ver se agrego guiones pero se conservo los espacios");
		scan.nextLine();
		String yt = scan.nextLine();
		cal.agregarhabi(nump, me, yt);
		System.out.println("�Desea repetir el h�bito semanalmente? S para S�/N para No.");
	    String v = scan.nextLine();
	    switch (v.toUpperCase()) {
	    
	    case "S":
	    	System.out.println("Digite el n�mero de semanss por durante las que quiere repetir el h�bit");
	    	int x = scan.nextInt();
	    	cal.repetirHabitos(nump, me, yt, x);
	    	System.out.println("H�bito a�adido");
	    	break;
	    case "N":
	    	System.out.println("H�bito a�adido");
	    	break;
	    default:
	    	System.out.println("Ha digitado un car�cter err�neo. Por defecto,\nsu h�bito se ha a�adido sin repeticiones.");
	    
	    	/**
			 * EL METODO agregarhabi AGREGA A UNA MATRIZ QUE TIENE 12 FILAS QUE CORRESPONDEN
			 * A LOS 12 MESES DE AÑO Y TIENE 31 COLUMNAS CORRESPONDIENTES A LOS DIAS DEL
			 * AÑO EL METODO agregarhabi RECIBE TRES ARGUMENTO LOS DOS PRIMERO SON TIPO int
			 * LOS CUALES CORRESPONDEN A EL (nump)DIA Y EL MES(me) EN EL CUAL SE DESEA
			 * AGREGAR EL HABITO Y EL TERCERO CORRESPONE AL HABITO (yt) EN EL FORMATO QUE SE
			 * ESPECIFICO ARRIBA FALTA EL METODO QUE SEGUN COMO QUIERA EL USUARIO AGREGUE
			 * LOS HABITOS CADA 7 DIAS, TODOS LOS DIAS O COMO LO ESPECIFIQUE EL USUARIO PARA
			 * HACER DICHO METODO SE DEBE AYUDAR DEL METODO agregarhabi() PARA QUE EL HABITO
			 * SE GUARDE EN LSO RESPECTIVOS DIAS
			 * 
			 */
	    	
	    	/**
			 * EL METODO almacen AGREGA LOS HABITOS (tq) EN UN ARREGLO EL CUAL PASA A UN
			 * ARCHIVO ES CUAL ES LA BASE DE DATOS DE LOS HABITOS EXISTENTES SOLO SE DEBE
			 * LLAMAR UNA VEZ POR CADA HABITO QUE SE DESEA AGREGAR.
			 */
			//cal.almacen(tq);
	    	
	    	/**
			 * lOS ANTERIORES METODOS AGREGAN NUEVOS HABITOS EN LAS MATRIZ QUE TIENE TODOS
			 * LOS DIAS DEL AÑO Y EL ARREGLO QUE CONTIENE LOS HABITOS EXISTENTES
			 * 
			 */
	    }	
		
		
	}
	
	public static void menu() {
		
		agregarHabitos();//M�todo para agregar h�bitos
		verGuiaNutricional();
		verAgendaDia();//M�todo para ver los h�bitos de un d�a espec�fico
		verAgendaMes();//M�todo para ver agenda de un mes espec�fico
		eliminarEventoEspecifico();//M�todo para eliminar un h�bito en un d�a espec�fico
		eliminarHabito();//M�todo para eliminar un h�bito completamente
		
	}
	
	public static void verGuiaNutricional() {
		
		System.out.println("¿DESEA VER LA GUIA DE INFORMACION NUTRICIONAL Y ACTIVIDAD FISICA");
		System.out.println("Ingrese 1) si desea ver la informacion nutricional 2)si desea ver la informacion de actividad fisica");
		int nnac = scan.nextInt();
		if(nnac<=2 && nnac>=1){
			if(nnac ==1){
				cal.importarnutricion();
				cal.imprinutri();
			}else{
				cal.importaractividadfisica();
				cal.impriactifis();
			}
		}else{
			System.out.println("El numero ingresado no es valido");
		}
		
	}

	public static void añadirProgreso() {
		
		System.out.println("¿DESEA AGREGAR PROGRESO EN UN HABITO?");
		System.out.println("Ingrese el numero del mes en el cual desea agregar un progreso");
		int nmesap = scan.nextInt();
		System.out.println("Ingrese el numero del dia en el cual desea agregar un progreso");
		int ndiaap=scan.nextInt();
		cal.mostraragendadia(nmesap,ndiaap);
		System.out.println("Ingrese el habito que desea agregar un progreso");
		System.out.println("IMPORTANTE ingrese el habito con el formato presentado anteriormente \nUsted observara los habitos de este forma leer_2_horas_(Vigente) \nrecuerde que aunque vea los habitos con un guion_ y (Vigente) no debe ingresar el (Vigente)\n Ingrese el habito con espacios en los lugares en donde hay un guion bajo_");
		String habpro = scan.nextLine();
		cal.imprimirpre(habpro);
		int nrta = scan.nextInt();
		cal.progress(nmesap, ndiaap, habpro, nrta);
		/**
		 * PARA REGISTRAR EL PROGRESO DE UN HABITO PRIMERO SE DEBE MOSTRAR LOS HABITOS
		 * DEL DIA QUE SE QUIERE AGREGAR UN PROGRESO SE DEBE PEDIR EL MES DIA Y HABITO
		 * QUE SE QUIERA AGREGAR UN PROGRESO LA FUNCION imprimirpre() RECIBE UN
		 * ARGUMENTO String QUE ES EL HABITO AL QUE SE LE QUIERE AGREGAR PROGESO LO QUE
		 * IMPRIME ES UNA PREGUNTA DEPENDIENDO CADA HABITO EJEMPLO SI EL USUARIO
		 * INTRODUJO leer-articulos-cientificos 2 horas LA FUNCION imprimirpre()
		 * IMPRIMER LA PREGUNTA ASI "¿Que cantidad de "+pre[2]+"(s) ha cumplido?"
		 * pre[2] en este casi es horas entonces seria "¿Que cantidad de horas(s) ha
		 * cumplido?" DESPUES DE ESTA PREGUNTA EL USUARIO DEBE INTRODUCIR EN UNA
		 * VARIABLE TIPO int EL NUMERO EN ESTE CASO DE HORAS QUE HA LEIDO EL METODO
		 * progress() RECIBE 4 ARGUMENTOS PRIMERO ES EL MES EL SEGUNDO EL DIA (TIPO int)
		 * EL TERCERO ES EL HABITO Y EL CUARTO ES EL NUMERO EN ESTE EJEMPLO DE HORAS
		 * ESTE METODO EN LA MATRIZ DE LOS DIAS DEL AÑO CAMBIA EN EL DIA SE HABITO EL
		 * (Vigente) POR (Finalizado)
		 * 
		 */
       
         
	}

	public static void eliminarHabito() {
		
		System.out.println("¿DESEA ELIMINAR UN HABITO POR COMPLETO?");
		cal.mostrarhabs();
		System.out.println("¿Que habito desea eliminar por completo?");
		System.out.println("IMPORTANTE ingrese el habito con el formato presentado anteriormente \nUsted observara los habitos de este forma leer_2_horas_(Vigente) \nrecuerde que aunque vea los habitos con un guion_ y (Vigente) no debe ingresar el (Vigente)\n Ingrese el habito con espacios en los lugares en donde hay un guion bajo_");
String habelper = scan.nextLine();
cal.eliminarhab(habelper);
		/**
		 * PARA ELIMINAR UN HABITO POR COMPLETO ES DECIR QUE ELIMINA EL HABITO DE TODOS
		 * LOS DIAS QUE ESTE REGISTRADO EN EL CALENDARIO SE LLAMA SIEMPRE PRIMERO AL
		 * METODO mostrarhabs() ESTE METODO TIENE TODOS LOS METODOS QUE SE HAN
		 * REGISTRADO DESPUES DE QUE EL USUARIO VE QUE HABITOS HAY DEBE INGRESAR CUAL
		 * DESEA ELIMINAR CON EL FORMATO EXPLICADO ANTERIORMENTE EL METODO eliminarhab()
		 * RECIBE UN ARGUMENTO TIPO String QUE ES EL HABITO Y LO ELIMINA DEL CALENDARIO
		 * EJEMPLO DE COMO IMPRIME EL METODO mostrarhabs() habitos existentes:
		 * leer-articulos-cientificos_2_horas cantar_1_hora jugar-football_3_horas COMO
		 * SE VE AQUI NO APARECE (Vigente) NI (Finalizado) YA QUE EL METODO SACA LA
		 * INFORMACION DE UN ARREGLO DISTINTO A LA MATRIZ QUE TIENE TODOS LO DIAS DEL
		 * AÑO Y AQUI NO SE NECESITA SABER QUE HABITOSESTAN VIGENTES O FINALIZADOS SI
		 * EL USUARIO QUIERE ELIMINAR UN HABITO DE TODOS LOS DIAS QUE EL ESPECIFICO
		 * ANTERIORMENTE SE DEBE HACER ASI leer-articulos-cientificos 2 horas COMO SE VA
		 * SE OMITEN LOS GUIONES BAJOS Y SE PONEN SON ESPACIOS
		 */
		
		
	}

	public static void verAgendaDia() {
		
		System.out.println("¿DESEA VER LOS HABITOS DE UN DIA?");
		
		System.out.println("Ingrese el numero del mes que desea ver");
		int mesve = scan.nextInt();

		System.out.println("Ingrese el numero del dia que desea ver");
		int diave = scan.nextInt();
cal.mostraragendadia(mesve, diave);
		
	}

	public static void verAgendaMes() {
		
		System.out.println("¿DESEA VER LOS HABITOS DEL MES?");
		/**
		 * HACER EL METODO. IMPORTANTE PARA HACER EL METODO QUE MUESTRE TODOS LOS
		 * HABITOS DEL MES SE DEBE USAR LA MATRIZ DE LA CLASE Calendario LLAMADA
		 * matrizago TODOS LOS DIAS DE ESTA MATRIZ ESTA DELA SIGUIENTE FORMA EJEMPLO
		 * matrizago[2][12] 2 corrsponde al mes pero recordar que las matrices inician
		 * desdes 0 ejemplo 2 corresponde a marzo y 12 corresponde al dia 11 entonces
		 * matrizago[2][12] es el 11 de marzo y supongamos que en ese dia estan estos
		 * habitos ejemplo matrizago[2][12]= 11 leer-articulos-cientificos_2_horas
		 * jugar-football_3_horas cantar_1_horas y asi es como se la informacion en la
		 * matriz
		 */
		
		
	}

	public static void eliminarEventoEspecifico() {
		
		System.out.println("¿DESEA ELIMINAR UN HABITO EN UN DIA ESPECIFICO ?");
		System.out.println("Ingrese el numero del mes que desea eliminar un habito");
		int nmeseles = scan.nextInt();
		System.out.println("Ingrese el numero del dia que desea eliminar un habito");
		int ndiaeles = scan.nextInt();
		cal.mostraragendadia(nmeseles, ndiaeles);
		System.out.println("Ingrese el habito del dia que desea eliminar");
		System.out.println("IMPORTANTE ingrese el habito con el formato presentado anteriormente \nUsted observara los habitos de este forma leer_2_horas_(Vigente) \nrecuerde que aunque vea los habitos con un guion_ y (Vigente) no debe ingresar el (Vigente)\n Ingrese el habito con espacios en los lugares en donde hay un guion bajo_");
		String habeles = scan.nextLine();
		cal.eliminareventoespe(nmeseles, ndiaeles, habeles);
		/**
		 * IMPORTANTE ANTES DE ELIMINAR UN HABITO EN UN DIA ESPECIFICO PRIMERO SIEMPRE
		 * SE VA LLAMAR AL METODO mostraragendadia() RECIBE DOS ARGUMENTOS EL PRIMERO
		 * (mot) CORRESPONDE AL MES EN NUMERO ENTERO Y (dai) CORRESPONDE AL DIA CON ESTO
		 * EL METODO MOSTRARA TODOS LOS HABITOS QUE ESTAN EN ESE DIA DEL MES PARA QUE LA
		 * PERSONA SEPA QUE HABITO DESEA ELIMINAR SOLO ESE DIA EL METODO
		 * eliminareventoespe() RECIBE 3 ARGUMENTOS (k) CORRESPONDE AL MES EN NUMERO
		 * ENTERO (jk) CORRESPONDE AL DIA Y (kp) CORRESPONDE AL HABITO ESTE METODO
		 * ELIMINA EL HABITO QUE INTRODUJO EL USUARIO PERO SOLO LO ELIMINA EN ESE DIA
		 * DEL MES NO LO ELIMINA DE TODOS LOS DIAS DEL CALENDARIO EJEMPLO DE COMO VA A
		 * IMPRIMIR LOS HABITOS EL METODO mostraragendadia() habitos para el dia (dai)
		 * del mes (mot) son: leer-articulos-cientificos_2 _horas_(Vigente)
		 * cantar_1_hora_(Vigente) jugar-football_3_horas_(Finalizado) LOS (Vigente) Y
		 * (Finalizado) LO AGREGA EL PROGRAMA HE INDICAN QUE HABITOS SE HAN CUMPLIDO ESE
		 * DIA EL USUARIO CUANDO DIGITE EL HABITO A ELIMINAR NO DEBE INGRESAR (Vigente)
		 * O (Finalizado) ESTO LO HACE LA APLICACION GENERARIA ERRORES SI POR EJEMPLO EL
		 * USUARIO DESEA ELIMINAR EL HABITO cantar_1_hora lo debe escribir por teclado
		 * de la siguiente manera cantar 1 hora SI NO LO INTRODUCE CON ESPACIOS Y CON EL
		 * NUMERO Y EL FORMATO DEL TIEMPO SE PRODUCIRA UN ERROR ADEMAS EL NUMERO DE MES
		 * Y DIA DEBEN SER int O GENERARA ERROR
		 * 
		 */
		
		
		
	}

	public static void verAgendaA�o(){
		
		
	}



}







