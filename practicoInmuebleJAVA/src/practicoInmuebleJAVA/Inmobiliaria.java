package practicoInmuebleJAVA;

import java.util.ArrayList;
import java.util.Scanner;

public class Inmobiliaria {
	
	private ArrayList<Inmueble> inmuebles;
	private ArrayList<Agente> agentes;
	
	public void addInmueble(Inmueble inmueble) { this.inmuebles.add(inmueble); }
	
	public void addAgente(Agente agente) { this.agentes.add(agente); }
	
	public String filtro1() {
		
		Scanner entrada = new Scanner(System.in);
		String tipoProp = null;
		
		ArrayList<String> numeros = new ArrayList<String>();
		String[] nros = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		
		for (String o: nros) {
			numeros.add(o);
		}
		
		System.out.println("A - Tipo de propiedad:\n");   
		System.out.println ( "1 - ESTUDIO");
		System.out.println ( "2 - LOFT");
		System.out.println ( "3 - DEPARTAMENTO");
		System.out.println ( "4 - PISO");
		System.out.println ( "5 - DUPLEX");
		System.out.println ( "6 - TRIPLEX");
		System.out.println ( "7 - CHALET");
		System.out.println ( "8 - CASA");
		System.out.println ( "9 - LOCAL");
		System.out.println ( "10 - COCHERA");
		System.out.println ( "11 - OFICINA");
		System.out.println ( "12 - EDIFICIO");
			
		String valor = entrada.nextLine();
			
		if (numeros.contains(valor)) {
			switch (valor) {
			case "1":
				tipoProp = "ESTUDIO"; break;
			case "2":
				tipoProp = "LOFT"; break;
			case "3":
				tipoProp = "DEPARTAMENTO"; break;
			case "4":
				tipoProp = "PISO"; break;
			case "5":
				tipoProp = "DUPLEX"; break;
			case "6":
				tipoProp = "TRIPLEX"; break;
			case "7":
				tipoProp = "CHALET"; break;
			case "8":
				tipoProp = "CASA"; break;
			case "9":
				tipoProp = "LOCAL"; break;
			case "10":
				tipoProp = "COCHERA"; break;
			case "11":
				tipoProp = "OFICINA"; break;
			case "12":
				tipoProp = "EDIFICIO"; break;
			}
		}else {
			System.out.println("Se ingreso un erroneo, elija el nuemro correspondiente"); 
			tipoProp = filtro1();
		}
		return tipoProp;
	}
	
	public String filtro2() {
		
		Scanner entrada = new Scanner(System.in);
		String estado = null;
		
		ArrayList<String> numeros = new ArrayList<String>();
		String[] nros = {"1", "2", "3", "4"};
		
		for (String o: nros) {
			numeros.add(o);
		}
		
		System.out.println("B - Estado:\n");   
		System.out.println ( "1 - HABITADO POR PROPIETARIO");
		System.out.println ( "2 - HABITADO POR INQUILINO");
		System.out.println ( "3 - DESHABITADO");
		System.out.println ( "4 - EN CONSTRUCCION");
			String valor = entrada.nextLine();
			
		if (numeros.contains(valor)) {
			switch (valor) {
			case "1":
				estado = "HABITADO_PROPIETARIO"; break;
			case "2":
				estado = "HABITADO_INQUILINO"; break;
			case "3":
				estado = "DESHABITADO"; break;
			case "4":
				estado = "EN_CONTRUCCION"; break;
			}
		}else {
			System.out.println("Se ingreso un numero erroneo, elija por favor el correspondiente"); 
			estado = filtro2();
		}
		return estado;
	}
	
	public String filtro3() {
		
		Scanner entrada = new Scanner(System.in);
		String luminosidad = null;
		
		ArrayList<String> numeros = new ArrayList<String>();
		String[] nros = {"1", "2", "3"};
		
		for (String o: nros) {
			numeros.add(o);
		}
		
		System.out.println("C - Luminosidad:\n");   
		System.out.println ( "1 - ALTA");
		System.out.println ( "2 - MEDIA");
		System.out.println ( "3 - BAJA");
			String valor = entrada.nextLine();
			
		if (numeros.contains(valor)) {
			switch (valor) {
			case "1":
				luminosidad = "ALTA"; break;
			case "2":
				luminosidad = "MEDIA"; break;
			case "3":
				luminosidad = "BAJA"; break;
			}
		}else {
			System.out.println("Se ingreso un numero erroneo, elija por favor el correspondiente"); 
			luminosidad = filtro3();
		}
		return luminosidad;
	}
	
public String filtro4() {
		
		Scanner entrada = new Scanner(System.in);
		String vigilancia = null;
		
		ArrayList<String> numeros = new ArrayList<String>();
		String[] nros = {"1", "2", "3", "4"};
		
		for (String o: nros) {
			numeros.add(o);
		}
		
		System.out.println("D - Vigilancia:\n");   
		System.out.println ( "1 - 24 HS");
		System.out.println ( "2 - DIURNO");
		System.out.println ( "3 - NOCTURNO");
		System.out.println ( "4 - SIN VIGILANCIA");
			String valor = entrada.nextLine();
			
		if (numeros.contains(valor)) {
			switch (valor) {
			case "1":
				vigilancia = "VEINTICUATRO_HS"; break;
			case "2":
				vigilancia = "DIURNO"; break;
			case "3":
				vigilancia = "NOCTURNO"; break;				
			case "4":
				vigilancia = "NO_TIENE"; break;			
			}	
		}else {
			System.out.println("Se ingreso un numero erroneo, elija por favor el correspondiente"); 
			vigilancia = filtro4();
		}
		return vigilancia;
	}
	
public String filtro5() {
	
	Scanner entrada = new Scanner(System.in);
	String estConserva = null;
	
	ArrayList<String> numeros = new ArrayList<String>();
	String[] nros = {"1", "2", "3", "4"};
	
	for (String o: nros) {
		numeros.add(o);
	}
	
	System.out.println("D - Estdo de conservación:\n");   
	System.out.println ( "1 - A ESTRENAR");
	System.out.println ( "2 - A RECICLAR");
	System.out.println ( "3 - IMPECABLE");
	System.out.println ( "4 - MUY BUENO");
	System.out.println ( "5 - BUENO");
		String valor = entrada.nextLine();
		
	if (numeros.contains(valor)) {
		switch (valor) {
		case "1":
			estConserva = "A_ESTRENAR"; break;
		case "2":
			estConserva = "A_RECICLAR"; break;
		case "3":
			estConserva = "IMPECABLE"; break;				
		case "4":
			estConserva = "MUY_BUENO"; break;				
		case "5":
			estConserva = "BUENO"; break;
		}
	}else {
		System.out.println("Se ingreso un numero erroneo, elija por favor el correspondiente"); 
		estConserva = filtro5();
	}
	return estConserva;
}
	/* --> revisar con profe
	public ArrayList<Inmueble> buscarInmueble(Filtro filtro){
		
		ArrayList<Inmueble> resultados = new ArrayList<>();
		
		for (Inmueble inmueble : this.inmuebles) {
			
			if ( filtro.coincide(inmueble) ){ 
				resultados.add(inmueble);
			}
		}
		
	}	
*/
}

