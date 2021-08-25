package habitos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * IMPORTANTE NO EDITAR NINGUN METODO SIN HABLAR PRIMERO CON EL DESARROLLADOR
 * JOSHUA
 */

public class Calendario {
	/**
	 * LOS ATRIBUTOS DEFINIDOS CORRESPONDEN A LOS BufferedReader QUE SON LA CLASE
	 * QUE NOS PERMITE PASAR LA INFORMACION DE UN ARCHIVO A UN MATRIZ PARA QUE
	 * PODAMOS TRABAJAR EN ELLA linea Y lin QUE CORRESPONDEN TAMBIEN PARA LEER LA
	 * INFORMACION DEL ARCHIVO partes UN ARREGLO TEMPORAL EN DONDE SE PASA LA
	 * INFORMACION DE CADA LINEA DEL ARCHIVO Y SE PASA LUEGO A UNA FILA DE MATRIZ DE
	 * LOS DIAS DEL AÑO parth ARREGLO EN DONDE QUDA LA INFORMACION FINAL QUE SE VA
	 * PASAR AL ARCHIVO DE LA BASE DE DATOS DE LOS HABITOS matrizago CORRESPONDE A
	 * LA MATRIZ EN DONDE SE PASA LA INFORMACION DE TODOS LOS DIAS DEL AÃ‘O EN ESTA
	 * MATRIZ SE GUARDAN TODOS LOS CAMBIOS QUE SE VAN A HACER PARA DESPUES PASARLOS
	 * O SUBIRLOS AL ARCHIVO Y matrizexport ES LA MATRIZ FINAL LA CUAL SE LLAMA
	 * SOLAMENTE AL FINAL PARA SUBIR TODA LA INFIORMACION AL ARCHIVO. LA EDICION DE
	 * ESTOS ATRIBUTOS OCASIONARA FALLOS EN EL PROGRAMA
	 */
	
	private BufferedReader lector; 
	private BufferedReader lectura;
	private String linea;
	private String partes[] = null;
	private String habi;
	private String parth[] = null;
	private String lin;
	private String[][] matrizago = new String[12][31];
	private String[][] matrizexport = new String[12][31];
	Fechas agenda = new Fechas();

	public void leercsv() {
		/**
		 * PRIMERO COMENZAMOS CON LOS DOS METODO QUE SE ENCARGAN DE LEER O PASAR LA
		 * INFORMACION DE UN ARCHIVO A LA APLICACION EL PRIMERO leercsv() EL METODO
		 * COMIENZA CON UN MANEJO DE EXCEPCIONES EL CUAL COMIENZA CON LA VARIBLE lector
		 * EN DONDE COLOCAMOS LA DIRECCION DEL ARCHIVO QUE SE VA A LEER, LA VARIABLE int
		 * j NOS VA SERVIR PARA PASAR LA INFORMACION DE CADA LINEA DEL ARCHIVO A LA
		 * CORRESPONDIENTE FILA EN LA MATRIZ matrizago EL CICLO WHILE PRECISAMENTE ES EL
		 * CICLO QUE MIENTRAS LO QUE LEA LA VARIABLE LECTOR NO SEA NULO PASE LA
		 * INFORMACION A LA RESPECTIVA MATRIZ, SI EL NULO SIGNIFICA QUE YA TERMINO EL
		 * TRASPASO DE LA INFORMACION. partes ESTE ARREGLO NOS SIRVE PARA ROMPER LA
		 * CADENA String EN TODOS LOS ; QUE TENGA LA LINEA QUE LEYO ANTERIORMENTE
		 * RECORDAR QUE UN ARCHIVO CSV ESTA SEPARADO POR UN ; CADA ; SIGNIFICA UNA NUEVA
		 * CASILLA EN EL ARCHIVO EXCEL.
		 */
		leerhab();
		File f1 = new File("Archivos\\Mesagosto1.csv");
		if (!f1.exists()) {
			try {

				f1.createNewFile();
				String[][] a = agenda.fechasATexto();

				separarceldas();
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("Archivos\\Mesagosto1.csv"));) {

					for (int l = 0; l < a.length; l++) {
						for (int kj = 0; kj < a[l].length; kj++) {

							bw.write(a[l][kj] + ";");

						}
						bw.newLine();
					}
					bw.flush();
				} catch (IOException e) {
					System.out.println("Hay un error en: " + e);
				}
				try {
					lector = new BufferedReader(new FileReader("Archivos\\Mesagosto1.csv"));
					int j = 0;
					while ((linea = lector.readLine()) != null) {
						partes = linea.split(";");
						llenarma(j);
						j++;
					}
					System.out.println();
					lector.close();
					linea = null;
				} catch (IOException e) {
					System.out.println("Hay un error en: " + e);
				}
			} catch (IOException e) {
				System.out.println(":)");
			}
		} else {
			try {
				lector = new BufferedReader(new FileReader("Archivos\\Mesagosto1.csv"));
				int j = 0;
				while ((linea = lector.readLine()) != null) {
					partes = linea.split(";");
					llenarma(j);
					j++;
				}
				System.out.println();
				lector.close();
				linea = null;
			} catch (IOException e) {
				System.out.println("Hay un error en: " + e);
			}
		}
	}

	public void leerhab() {

		/*
		 * EL METODO leerhab() HACE LO MISMO QUE EL METODO leercsv()CON LA DIFERENCIA
		 * QUE leerhab() LEE EL ARCHIVO CORRESPONDIENTE A LOS HABITOS QUE EXISTEN ADEMAS
		 * QUE ESTE ARCHIVO SOLO TIENE UNA FILA POR ENDE LA INFORMACION QUE LEE LA
		 * VARIABLE DE BufferedRead SE GUARDA EN UNA VARIABLE TIPO String EN LA CUAL SE
		 * VA PODER EDITAR LA INFORMACION DE ESTA
		 * 
		 * 
		 */
		File f2 = new File("Archivos");

		if (!f2.exists())
			f2.mkdir();

		File f3 = new File("Archivos\\Habitos.csv");
		if (f3.exists()) {
			try {

				lectura = new BufferedReader(new FileReader("Archivos\\Habitos.csv"));
				while ((lin = lectura.readLine()) != null) {
					habi = lin;
				}
				lectura.close();
				lin = null;
			} catch (IOException e) {
				System.out.println("Hay un error en: " + e);
			}
		} else {
			try {
				f3.createNewFile();
				String a = "habitos existentes";
				try (BufferedWriter bw = new BufferedWriter(new FileWriter("Archivos\\Habitos.csv"));) {

					bw.write(a);
					bw.flush();

				} catch (IOException e) {
					System.out.println("Hay un error en: " + e);
				}
			} catch (IOException e1) {

				System.out.println("Ha ocurrido un error.");

			}
			try {

				lectura = new BufferedReader(new FileReader("Archivos\\Habitos.csv"));
				while ((lin = lectura.readLine()) != null) {
					habi = lin;
				}
				lectura.close();
				lin = null;
			} catch (IOException e) {
				System.out.println("Hay un error en: " + e);
			}

		}
	}

	public void llenarma(int g) {
		/**
		 * EL METODO llenarma() PRECISAMENTE ES EL METODO QUE PASA LA INFORMACION DE
		 * CADA FILA QUE SE GUARDO TEMPORALMENTE EN EL ARREGLO partes Y LO PASA A UNA /*
		 * FILA DE LA MATRIZ matrizago EN DONDE SE VA A TRABAJAR RECIBE UNA ARGUMENTO
		 * TIPO int QUE INDICA A QUE FILA DE LA MATRIZ DEBE AGREGAR LA INFORMACION, ESTE
		 * METODO SE LLAMA EN EL METODO leercsv() NO SE DEBE EDITAR O PUEDE GENERAR
		 * MULTIPLES ERRORES
		 */
		for (int v = 0; v < partes.length; v++) {
			matrizago[g][v] = partes[v];
		}
	}

	public void agregarhabi(int nump, int me, String yt) {
		/**
		 * EL METODO agregarhabi() ES EL METODO QUE AGREGA LOS HABITOS A LA MATRIZ
		 * matrizago IMPORTANTE ESTE METODO AGREGA EL HABITO EN UN SOLO DIA TENER EN
		 * CUENTA A LA HORA DE HACER EL METODO QUE AGREGUE LOS HABITOS EN LA CANTIDAD DE
		 * TIEMPO QUE QUIERA EL USUARIO LO PRIMERO QUE SE HACE ES COMO EL USUARIO
		 * INGRESA EL HABITO CON ESPACIOS EJEMPLO : leer 2 horas EL PROGRAMA DEBE
		 * CAMBIAR ESOS ESPACIOS POR GUINES BAJOS QUE ES FORMATO CON EL CUAL SE VA A
		 * GUARDAR LA LINEA 95 ES LA QUE SE ENCARGA DE ESO ENLA SIGUIENTE 96 LINEA SE VA
		 * UN IF ESTE SE USA SOLO PARA FINES DE COMO SE ALMACENA EL HABITO EN CADA
		 * CASILLA YA QUE EL FORMATO EN EL QUE SE GUARDA ES EJEMPLO: matrizago[3][15]=
		 * ABRIL 14 = 14 leer_2_horas_(Vigente) COMO SE VE LO QUE SEPARA EL NUMERO DEL
		 * DIA AL HABITO ES UN ESPACIO Y EL IF SE USA PARA QUE SOLO QUEDE UN ESPACIO
		 * ENTRE EL NUMERO DEL DIA Y EL HABITO, SIN ESTE PUEDE QUE ALA HORA DE ELIMINAR
		 * UN HABITO EN ESE DIA Y LUEGO SE AGREGUE OTRO QUEDE CON DOBLE ESPACIO LO CUAL
		 * PUEDE OCASIONAR ERRORES
		 * 
		 */
		String newyt = yt.replace(" ", "_");
		if (matrizago[me - 1][nump - 1].length() != 3) {
			matrizago[me - 1][nump - 1] += " ";
			matrizago[me - 1][nump - 1] += newyt.concat("_(Vigente)");
		} else {
			matrizago[me - 1][nump - 1] += newyt.concat("_(Vigente)");
		}
	}

	public void almacen(String tq) {
		/**
		 * EL METODO ALMACEN ES EL METODO QUE AGREGA LOS HABITOS. INICIA IGUALMENTE
		 * CAMBIANDO LOS ESPACIOS CON LOS CON LOS QUE SE INGRESO EL HABITO LOS CAMBIA
		 * POR GUIONES BAJOS QUE ES EL FORMATO DE ALMACENAMIENTO EN LOS ARREGLOS,
		 * MATRICES Y ARCHIVOS EN ESTE METODO HAY UN IF EL CUAL SE ENCARGA DE QUE NO
		 * HAYA ERRORES A LA HORA DE ALMACENAR HABITOS YA QUE EN ESTE ES FUNDAMENTAL LOS
		 * ; YA QUE SON LA FORMA EN LA CUAL SE ALMACENA EN DIFERENTES CASILLAS
		 * IMPORTANTE SOLO DE DEBE INGRESAR UNA VEZ POR CADA HABITO EJEMPLO SI EL
		 * USUARIO QUIERE ESTE HABITO leer_2_horas TODOS LOS DIAS DEL MES NO DEBEMOS
		 * AGREGAR EN LA BASE DE DATOS EL HABITO 30 VECES YA QUE ES EL MISMO HABITO CON
		 * LA CARACTERISTICA QUE SE VA A REPETIR POR 30 DIAS
		 */
		String newtq = tq.replace(" ", "_");
		if (habi.equals("habitos existentes")) {
			habi += ";";
			habi += newtq;
		} else {
			habi += newtq;
			habi += ";";
		}
	}

	public void sephab() {
		
		/*
		 * LOS SIGUIENTES METODOS sephab() Y separarceldas() SON LOS PENULTIMOS METODOS
		 * QUE SE LLAMAN YA QUE ESTOS METODOS SE ENCARGAN DE PASAR LAS INFORMACION DE
		 * LOS ARREGLOS Y MATRICES AL ARCHIVO Y PARA ESTO DEBEMOS PREPARAR LA
		 * INFORMACION, AGREGAMOS EN CADA CASILLA DE LOS ARREGLOS O MATRICES UN ; EL
		 * CUAL NOS SEPARA CADA CASILLA DEL ARREGLO EN CADA CASILLA DEL ARCHIVO NO SE
		 * DEBEN EDITAR POR NINGUNA RAZON YA QUE EL MINIMO CAMBIO PUEDE HACER QUE EL
		 * PROGRAMA PRESENTE MULTIPLES FALLOS CUANDO SE VUELVA A EJECUTAR
		 * 
		 */
		
		parth = habi.split(";");
		for (int pe = 0; pe < parth.length; pe++) {
			parth[pe] += ";";
		}
	}

	public void separarceldas() {
		
		/*
		 * LOS SIGUIENTES METODOS sephab() Y separarceldas() SON LOS PENULTIMOS METODOS
		 * QUE SE LLAMAN YA QUE ESTOS METODOS SE ENCARGAN DE PASAR LAS INFORMACION DE
		 * LOS ARREGLOS Y MATRICES AL ARCHIVO Y PARA ESTO DEBEMOS PREPARAR LA
		 * INFORMACION, AGREGAMOS EN CADA CASILLA DE LOS ARREGLOS O MATRICES UN ; EL
		 * CUAL NOS SEPARA CADA CASILLA DEL ARREGLO EN CADA CASILLA DEL ARCHIVO NO SE
		 * DEBEN EDITAR POR NINGUNA RAZON YA QUE EL MINIMO CAMBIO PUEDE HACER QUE EL
		 * PROGRAMA PRESENTE MULTIPLES FALLOS CUANDO SE VUELVA A EJECUTAR
		 * 
		 */
		
		for (int qa = 0; qa < matrizago.length; qa++) {
			for (int fr = 0; fr < matrizago[qa].length; fr++) {
				matrizexport[qa][fr] = matrizago[qa][fr];
				matrizexport[qa][fr] += ";";
			}

		}
	}

	public void mostrarhabs() {
		
		/**
		 * EL SIGUIENTE METODO ES mostrarhabs() EL CUAL SE ENCARGA DE MOSTRAR LOS
		 * HABITOS QUE EXISTEN EN LA BASE DE DATOS DE LOS HABITOS TRABAJA DE FORMA
		 * SIMPLE ROMPE LA VARIABLE String POR CADA ; Y LO ALAMCENA EN UN ARREGLO LUEGO
		 * IMPRIMIMOS CADA ELEMENTO DEL ARREGLO ESTE METODO ES FUNDAMENTAL PARA CUANDO
		 * EL USUARIO QUIERA ELIMINAR POR COMPLETO UN HABITO
		 */
		
		String temp[] = habi.split(";");
		for (int n = 0; n < temp.length; n++) {
			System.out.print(temp[n] + "\n");
		}
	}

	public void eliminarhab(String eh) {
		
		/**
		 * EL METODO eliminarhab() SE ENCARGA DE ELIMINAR EL HABITO QUE EL USUARIO
		 * QUIEREA DEL CALENDARIO EJEMPLO: SI USUARIO QUIERE QUE EL HABITO leer_2_horas
		 * SE REPITA TODOS LOS DIAS MES PERO LUEGO QUIERE ELIMINAR POR COMPLETO ESTE
		 * HABITO ESTE METODO ELIMINA ESTE HABITO EN TODOS LOS 30 DIAS DEL MES LO
		 * PRIMERO QUE HACE ES PASAR EL HABITO QUE INGRESA EL USUARIO AL FORMATO DE
		 * ALAMCENAMIENTO EN POCAS PALABRAS CAMBIA LOS ESPACIOS POR GUINES BAJOS LUEGO
		 * AGREGA (Vigente) Y (Finalizado) YA QUE UN HABITO PUEDE TENER ESTAS DOS
		 * CARACTERISTICAS Y EL METODO ELIMINA DE ESTA FORMA EJEMPLO SI LA CASILLA
		 * matrizago[5][14] = 13 leer_2_horas_(Vigente) caminar_1_hora(Finalizado) SI EL
		 * USUARIO QUIERE ELIMINAR EL HABITO caminar_1_hora_(Finalizado) EL METODO
		 * REMPLAZA DE LA CASILLA DEL DIA ESTE HABITO Y LO CAMBIA POR UN ESPACIO HAY 4
		 * CICLOS FOR LOS CUALES BUSCAN EN TODA LA MATRIZ DE LOS DIAS DE AÃ‘O EL HABITO
		 * QUE SE DESEA ELIMINAR LOS DOS PRIMEROS BUSCAN EL HABITO MAS (Vigente) PERO
		 * COMO NO TODOS LOS HABITOS SON VIGENTES ENTONCES LOS OTROS DOS CICLOS FOR
		 * BUSCAN EL HABITO MAS (Finalizado) AL FIANL TAMBIEN ELIMINAMOS DICHO HABITO DE
		 * LA BASE DE DATOS DE LOS HABITOS EXISTENTES
		 */

		
		String neweh = eh.replace(" ", "_");
		String camb = " " + neweh + "_(Vigente)";
		String com = neweh + "_(Vigente)";
		String cambal = " " + neweh + "_(Finalizado)";
		String comal = neweh + "_(Finalizado)";
		for (int za = 0; za < matrizago.length; za++) {
			for (int ce = 0; ce < matrizago[za].length; ce++) {
				String artem[] = matrizago[za][ce].split(" ");
				for (int lh = 1; lh < artem.length; lh++) {
					if (artem[lh].equals(com)) {
						String newma = matrizago[za][ce].replace(camb, " ");
						matrizago[za][ce] = null;
						matrizago[za][ce] = newma;
						newma = null;
					}
				}
			}
		}
		for (int zas = 0; zas < matrizago.length; zas++) {
			for (int ces = 0; ces < matrizago[zas].length; ces++) {
				String artem1[] = matrizago[zas][ces].split(" ");
				for (int lhs = 1; lhs < artem1.length; lhs++) {
					if (artem1[lhs].equals(comal)) {
						String newma = matrizago[zas][ces].replace(cambal, " ");
						matrizago[zas][ces] = null;
						matrizago[zas][ces] = newma;
						newma = null;
					}
				}
			}
		}
		String cambh = ";" + neweh;

		String newhabo = habi.replace(cambh, ";");
		String nhaboi = newhabo.replace(";;", ";");
		newhabo = null;
		newhabo = nhaboi;
		habi = null;
		habi = newhabo;
		newhabo = null;

	}

	public void eliminareventoespe(int k, int jk, String kp) {
		
		/**
		 * EL METODO eliminareventoespe() ELIMINA HABITOS DE UN DIA ESPECIFICO ES MAS
		 * SENCILLO QUE EL METODO QUE ELIMINA HABITOS POR COMPLETO YA QUE EN ESTE EL
		 * USUARIO NOS DA EL DIA Y EL MES DEL HABITO QUE DESEA ELIMINAR POR LO CUAL
		 * TENEMOS LA FILA Y LA COUMNA DE HABITO QUE SE DESEA ELIMINAR DE RESTO ES IGUAL
		 * AL ANTERIOR METODO
		 */
		
		String newkp = kp.replace(" ", "_");
		String wq = " " + newkp + "_(Vigente)";
		String wqe = " " + newkp + "_(Finalizado)";

		String elies = matrizago[k - 1][jk - 1].replace(wq, " ");

		matrizago[k - 1][jk - 1] = null;
		matrizago[k - 1][jk - 1] = elies;
		elies = null;
		String elie = matrizago[k - 1][jk - 1].replace(wqe, " ");

		matrizago[k - 1][jk - 1] = null;
		matrizago[k - 1][jk - 1] = elie;
		elie = null;
	}

	public void mostraragendadia(int mot, int dai) {
		
		/**
		 * EL METODO mostraragendadia() MUESTRA TODOS LO HABITOS QUE HAY EN UN DIA
		 * ESPECIFICADO POR EL USUARIO RECIBE EL MES Y EL DIA POR LO CUAL SE CONOCE LA
		 * FILA Y COLUMNA QUE SE QUIERE Y LUEGO ROMPE LA CADENA String DE LA CASILLA DE
		 * LA MATRIZ E IMPRIMER TODOS LO HABITOS QUE ALLI EXISTEN
		 */
		
		System.out.println("Los habitos para el dia " + dai + " del mes " + mot + " son: ");
		if (matrizago[mot - 1][dai - 1].length() < 4) {
			System.out.println("no hay nada programado para el dia " + dai + " del mes " + mot);
		} else {
			String sepdi[] = matrizago[mot - 1][dai - 1].split(" ");
			for (int y = 1; y < sepdi.length; y++) {
				System.out.println(sepdi[y] + "\n");
			}
		}

	}

	public void subirhab() {
		
		/**
		 * lOS METODOS subirhab() Y Export() SON LOS METODOS QUE EXPORTAN LA INFORMACION
		 * QUE SE EDITO ANTERIORMENTE SON LOS ULTIMOS METODOS QUE SE LLAMAN Y ANTES DE
		 * ESTOS SE DEBEN HABER LLAMADO LOS METODO separarceldas() Y sephab() LA
		 * VARIABLE BufferedWriter ES LA CLASE QUE NOS AYUDA A ESCRIBIR TODA LA
		 * INFORMACION ESTE PIDE LA DIRECCION DEL ARCHIVO EN DONDE SE VA A GUARDAR LA
		 * INFROMACION ESTA VARIABLE BufferedWriter ESCRIBE EN SU TOTALIDAD TODA LA
		 * INFORMACION QUE HAYA HASTA QUE VEA UN ; LO CUAL LO SEPARA Y COMIENZA EN UNA
		 * NUEVA CELDA DE EXCEL EN EL METODO Export() LLAMAMOS A LOS METODO sephab() Y
		 * subirhab() LOS CUALES ARREGLAN LA INFORMACION PARA DEJARLA LISTA Y LA OTRA
		 * SUBE LA INFORMACION YA LISTA AL ARCHIVO DE LA BASE DE DATOS DE LOS HABITOS
		 */
		
		try (BufferedWriter wr = new BufferedWriter(new FileWriter("Archivos\\Habitos.csv"));) {
			for (int xc = 0; xc < parth.length; xc++) {
				wr.write(parth[xc]);
			}
			wr.flush();
		} catch (IOException e) {
			System.out.println("Hay un error en: " + e);
		}
	}

	public void Export() {
		
		/**
		 * lOS METODOS subirhab() Y Export() SON LOS METODOS QUE EXPORTAN LA INFORMACION
		 * QUE SE EDITO ANTERIORMENTE SON LOS ULTIMOS METODOS QUE SE LLAMAN Y ANTES DE
		 * ESTOS SE DEBEN HABER LLAMADO LOS METODO separarceldas() Y sephab() LA
		 * VARIABLE BufferedWriter ES LA CLASE QUE NOS AYUDA A ESCRIBIR TODA LA
		 * INFORMACION ESTE PIDE LA DIRECCION DEL ARCHIVO EN DONDE SE VA A GUARDAR LA
		 * INFROMACION ESTA VARIABLE BufferedWriter ESCRIBE EN SU TOTALIDAD TODA LA
		 * INFORMACION QUE HAYA HASTA QUE VEA UN ; LO CUAL LO SEPARA Y COMIENZA EN UNA
		 * NUEVA CELDA DE EXCEL EN EL METODO Export() LLAMAMOS A LOS METODO sephab() Y
		 * subirhab() LOS CUALES ARREGLAN LA INFORMACION PARA DEJARLA LISTA Y LA OTRA
		 * SUBE LA INFORMACION YA LISTA AL ARCHIVO DE LA BASE DE DATOS DE LOS HABITOS
		 */
		
		sephab();
		subirhab();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("Archivos\\Mesagosto1.csv"));) {

			for (int l = 0; l < matrizexport.length; l++) {
				for (int kj = 0; kj < matrizexport[l].length; kj++) {

					bw.write(matrizexport[l][kj]);

				}
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
			System.out.println("Hay un error en: " + e);
		}
	}

	public String imprimirpre(String ha) {

		/**
		 * TENEMODS EL METODO imprimirpre() QUE RETORNA UNA PREGUNTA QUE ES ESPECIFICA
		 * PARA CADA HABITO Y ESTA PREGUNTA ES PARA QUE EL USUARIO ESCRIBA CON CUANTO A
		 * CUMPLIDO DEL HABITO PROPUESTO ESTE METODO RETORNA ELA PREGUNTA DE LA
		 * SIGUIENTE FORMA EJEMPLO EL USUARIO INGRESO ESTE HABITO caminar 2 horas EL
		 * METODO ROMPE POR CADA ESPACIO Y ALMACENA ESTO EN UN ARREGLO DE LA SIGUIENTE
		 * FORMA array[0]= "caminar" array[1]= "2" y array[2]= "horas" entonces se tomas
		 * el array[2] Y SE MUESTRA LA PREGUNTA ASI Â¿Que cantidad de horas(s) ha
		 * cumplido?
		 * 
		 * 
		 */
		
		String pre[] = ha.split(" ");
		String prefin = "¿Que cantidad de " + pre[2] + "(s) ha cumplido?";
		return prefin;
	}

	public void progress(int mo, int da, String hto, int rta) {
		/**
		 * EL METODO progress() EL EL METODO QUE NOS ACTUALIZA LA INFORMACION SI EL
		 * USUARIO CUMPLIO CON EL HABITO PROPUESTO PRIMERO CAMBIA EL HABITO QUE INGRESO
		 * EL USUARIO, CAMBIA LOS ESPACIOS POR GUIONES BAJOS LUEGO ROMPE LA CADENA
		 * String QUE TIENE EL HABITO Y ROMPE POR CADA GUION BAJO QUE ENCUENTRE Y LO
		 * ALMACENA EN UN ARREGLO LUEGO COMO LOS HABITOS DEBEN TENER UN FORMATO
		 * ESPECIFICO EN LA SEGUNDA CASILLA DEL ARREGLO SIEMPRE ESTARA EL NUMERO QUE ES
		 * EL CONDICIONAL DEL HABITO Y CON ESTE NUMERO COMPARAMOS CON LA RESPUESTA QUE
		 * DIO EL USUARIO EJEMPLO EL USUARIO INGRESO ESTE HABITO caminar 2 horas EL
		 * METODO CAMBIA CADA ESPACIO POR GUIONES BAJOS ASI caminar_2_horas_(Vigente) y
		 * ROMPE LA CADENA String POR CADA GUION BAJO Y LO AGREGA EN UN ARREGLO array
		 * [0]="camiar" array[1]= "2" array[2]="horas" array[3]="(Vigente)" EL METODO
		 * TOMA LA POSICION 1 DE ESTE ARREGLO QUE ES EL NUMERO Y LO COMVIERTE A UN int
		 * PARA COMPARAR CON LA RESPUESTA QUE DE EL USUARIO Y ASI SABER SI CUMPLIO CON
		 * EL HABITO O NO.
		 */
		
		String hatos = hto.replace(" ", "_");
		String pref[] = hto.split(" ");
		String anti = hatos + "_(Vigente)";
		String nuev = hatos + "_(Finalizado)";
		if ((Integer.parseInt(pref[1]) == rta) || (Integer.parseInt(pref[1]) < rta)) {
			System.out.println("Felicidades ha cumpido en su  totalidad con el habito propuesto: " + hto);
			String macorrec = matrizago[mo - 1][da - 1].replace(anti, nuev);

			matrizago[mo - 1][da - 1] = null;
			matrizago[mo - 1][da - 1] = macorrec;
			macorrec = null;
		} else {
			System.out.println("No ha cumplido en su totalidad el habito propuesto: " + hto);

		}

	}

	
	public void repetirHabitos(int nump, int me, String yt, int a) {
/*
 * Este método es el que se utiliza para clonar los hábitos
 * a lo largo de varias semanas si el usuario así lo quiere.
 * Agrega copias de los hábitos una semana adelante de la fecha
 * ingresada (7 días después).
 * Requiere del método setnuevodia() cuando los hábitos se realizan a 
 * lo largo de varios meses.
 */
		for (int b = a - 1; b != 0; b--) {
			try {
				agregarhabi(nump + 7, me, yt);
				nump += 7;
			} catch (ArrayIndexOutOfBoundsException ea) {
				try {
					int d = nump + 7;
					nump = setnuevodia(d, me);
					me++;
					agregarhabi(nump, me, yt);

				} catch (Exception n) {

					System.out.println("Ha ocurrido un error al agregar el hábito en repetición");
				}
			} catch (Exception e) {
				System.out.println("error");

			}

		}
	}

	public int setnuevodia(int a, int b) {
		
		/*
		 * Este método es necesario para el funcionamiento del método repetirHabitos(). 
		 * Es usado en caso de que el hábito se realice a lor largo de varios meses.
		 * Este método nos garantiza que los hábitos puedan ser duplicados en una fila
		 * de la matriz matrizago diferente a la inicial, evitando así excepciones 
		 * producidas por sobrepasar el límite de posiciones en la matriz mencionada.
		 */
		
		int c = 0;
		int d = (matrizago[b].length)-1;
		while (c == 0) {
			try {
			String[] array = matrizago[b - 1][d].split(" "); 
				c = Integer.parseInt(array[0]);
			} catch (Exception e) {
				d--;
			}
		}

		a -= c;
		return a;

	}
}
