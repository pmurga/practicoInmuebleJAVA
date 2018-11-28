package practicoInmuebleJAVA.UI;

import java.util.ArrayList;
import java.util.Scanner;

import practicoInmuebleJAVA.Inmobiliaria;
import practicoInmuebleJAVA.MiExcepcion;

public class Menues {
	
	private Scanner entrada;
	private String perfil = null;
	private String valor = null;
	private String tipoProp = null;
	private String estado = null;
	private String luminosidad = null;
	private String vigilancia = null;
	private String estConserva = null;

	// Desarrollo de todos los menues del main.
	public void Menu1 () {
		
		System.out.println("BIENVENIDOS A INMOBILIARIA CAECE 2018\n");
		System.out.println("Elija su perfil:\n");
		
			entrada = new Scanner(System.in);
			
			
			ArrayList<String> numeros = new ArrayList<String>();
			String[] nros = {"1", "2", "3", "4"};
			
			for (String o: nros) {
				numeros.add(o);
			}
			
			System.out.println("PERFIL:\n");   
			System.out.println ( "1 - INMOBILIARIO");
			System.out.println ( "2 - AGENTE");
			System.out.println ( "3 - PROPIETARIO");
			System.out.println ( "4 - POSIBLE CLIENTE");
				valor = entrada.nextLine();
				
			try {	
				if (numeros.contains(valor)) {
					switch (valor) {
					case "1":
						 this.MenuInmob(); break;
					case "2":
						this.MenuAgente();; break;
					case "3":
						this.MenuProp(); break;
					case "4":
						this.MenuCliente(); break;
					}
				}else {
					throw new MiExcepcion ("Se ingreso un nro erroneo, elija el correspondiente");
					
				}
			}catch(MiExcepcion e) {
				System.out.println(e.getMessage());
				Menu1();
			}
		}
	
	// Menu para el inmobiliario.
	
	public void MenuInmob () {
		
		entrada = new Scanner(System.in);
				
		ArrayList<String> numeros = new ArrayList<String>();
		String[] nros = {"1", "2", "3", "4", "5"};
		
		for (String o: nros) {
			numeros.add(o);
		}
		
		System.out.println("INMOBILIARIO:\n");   
		System.out.println ( "1 - AGREGAR UNA PROPIEDAD");
		System.out.println ( "2 - ELIMINAR UNA PROPIEDAD");
		System.out.println ( "3 - AGREGAR UN AGENTE");
		System.out.println ( "4 - ELIMINAR UN AGENTE");
		System.out.println ( "5 - CALCULAR SALARIOS DE AGENTE");
			valor = entrada.nextLine();
			
		try {	
			if (numeros.contains(valor)) {
				switch (valor) {
				case "1":
					System.out.println ( "Metodo para agregar una propiedad..."); break;
				case "2":
					System.out.println ( "Metodo para eliminar una propiedad..."); break;
				case "3":
					System.out.println ( "Metodo para agregar un agente..."); break;
				case "4":
					System.out.println ( "Metodo para eliminar un agente..."); break;
				case "5":
					System.out.println ( "Metodo para calcular salario de agente..."); break;
				}
			}else {
				throw new MiExcepcion ("Se ingreso un nro erroneo, elija el correspondiente");
				
			}
		}catch(MiExcepcion e) {
			System.out.println(e.getMessage());
			MenuInmob();
		}
	}
	
	
	//Menu para el propietario.
	
	public void MenuProp () {
			
		entrada = new Scanner(System.in);
						
		ArrayList<String> numeros = new ArrayList<String>();
		String[] nros = {"1", "2", "3"};
			
		for (String o: nros) {
			numeros.add(o);
		}
			
		System.out.println("PROPIETARIO:\n");   
		System.out.println ( "1 - AGREGAR UNA PROPIEDAD");
		System.out.println ( "2 - ELIMINAR UNA PROPIEDAD");
		System.out.println ( "3 - CALCULAR COMISIONES");
			valor = entrada.nextLine();
				
		try {	
			if (numeros.contains(valor)) {
				switch (valor) {
				case "1":
					System.out.println ( "Metodo para agregar una propiedad..."); break;
				case "2":
					System.out.println ( "Metodo para eliminar una propiedad..."); break;
				case "3":
					System.out.println ( "Metodo para calcular comisiones..."); break;
				}
			}else {
				throw new MiExcepcion ("Se ingreso un nro erroneo, elija el correspondiente");
				
			}
		}catch(MiExcepcion e) {
			System.out.println(e.getMessage());
			MenuProp();
		}
	}
	
	//Menu para el Agente.
	
	public void MenuAgente () {
		
		entrada = new Scanner(System.in);
						
		ArrayList<String> numeros = new ArrayList<String>();
		String[] nros = {"1", "2", "3"};
			
		for (String o: nros) {
			numeros.add(o);
		}
			
		System.out.println("AGENTE:\n");   
		System.out.println ( "1 - CALCULAR SALARIO");
		System.out.println ( "2 - CALCULAR COMISION");
		System.out.println ( "3 - CALCULAR TODAS LAS COMISIONES DEL MES");
			valor = entrada.nextLine();
				
		try {	
			if (numeros.contains(valor)) {
				switch (valor) {
				case "1":
					System.out.println ( "Metodo para calcular salario..."); break;
				case "2":
					System.out.println ( "Metodo para calcular comision de una operacion..."); break;
				case "3":
					System.out.println ( "Metodo para calcular todas las comisiones del mes..."); break;
				}
			}else {
				throw new MiExcepcion ("Se ingreso un nro erroneo, elija el correspondiente");
				
			}
		}catch(MiExcepcion e) {
			System.out.println(e.getMessage());
			MenuProp();
		}
	}
	
	public void MenuCliente () {
		
		entrada = new Scanner(System.in);
		
		ArrayList<String> f = new ArrayList<String>();				
		ArrayList<String> numeros = new ArrayList<String>();
		String[] nros = {"1", "2", "3"};
			
		for (String o: nros) {
			numeros.add(o);
		}
		
		
		System.out.println("POSIBLE CLIENTE:\n");   
		System.out.println ( "1 - BUSQUEDA DE PROPIEDAD");
				valor = entrada.nextLine();
		
		System.out.println("Que tipo de propiedad esta buscando?:\n");
		System.out.println("Filtre por estas 5 principales caracteristicas:\n");
		System.out.println("Las opciones estan numeradas, por favor elija el número de la opcion que desee\n");		
		
		try {	
			if (numeros.contains(valor)) {
				switch (valor) {
				case "1":
					f = this.Filtros();
					this.MostrarProp(f);
					System.out.println ( "Menu para tipo de operacion...");
					System.out.println ( "Operacion...");
					break;
				}
			}else {
				throw new MiExcepcion ("Se ingreso un nro erroneo, elija el n�mero correspondiente");
				
			}
		}catch(MiExcepcion e) {
			System.out.println(e.getMessage());
			MenuProp();
		}
	}
	
public String filtro1() {
		
		entrada = new Scanner(System.in);
				
		ArrayList<String> numeros = new ArrayList<String>();
		String[] nros = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
		
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
		System.out.println ( "13 - TODAS");
			
		valor = entrada.nextLine();
		
		try {
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
				case "13":
					tipoProp = "VACIO"; break;
				}
			}else {
				throw new MiExcepcion ("Se ingreso un nro erroneo, elija el correspondiente");
				
			}
		}catch(MiExcepcion e) {
			System.out.println(e.getMessage());
			tipoProp = filtro1();
		}
		
		return tipoProp;
	}
	
	public String filtro2() {
		
		entrada = new Scanner(System.in);
				
		ArrayList<String> numeros = new ArrayList<String>();
		String[] nros = {"1", "2", "3", "4", "5"};
		
		for (String o: nros) {
			numeros.add(o);
		}
		
		System.out.println("B - Estado:\n");   
		System.out.println ( "1 - HABITADO POR PROPIETARIO");
		System.out.println ( "2 - HABITADO POR INQUILINO");
		System.out.println ( "3 - DESHABITADO");
		System.out.println ( "4 - EN CONSTRUCCION");
		System.out.println ( "5 - TODAS");
			valor = entrada.nextLine();
			
		try {	
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
				case "5":
					estado = "VACIO"; break;
				}
			}else {
				
				throw new MiExcepcion ("Se ingreso un nro erroneo, elija el correspondiente");
				
			}
		}catch(MiExcepcion e) {
			System.out.println(e.getMessage());
			estado = filtro2();
		}
		return estado;
	}
	
	public String filtro3() {
		
		entrada = new Scanner(System.in);
		
		ArrayList<String> numeros = new ArrayList<String>();
		String[] nros = {"1", "2", "3", "4"};
		
		for (String o: nros) {
			numeros.add(o);
		}
		
		System.out.println("C - Luminosidad:\n");   
		System.out.println ( "1 - ALTA");
		System.out.println ( "2 - MEDIA");
		System.out.println ( "3 - BAJA");
		System.out.println ( "4 - TODAS");
			valor = entrada.nextLine();
			
		try {
			if (numeros.contains(valor)) {
				switch (valor) {
				case "1":
					luminosidad = "ALTA"; break;
				case "2":
					luminosidad = "MEDIA"; break;
				case "3":
					luminosidad = "BAJA"; break;
				case "4":
					luminosidad = "VACIO"; break;
				}
			}else {
				throw new MiExcepcion ("Se ingreso un nro erroneo, elija el correspondiente");
			}
		
		}catch(MiExcepcion e) {
			System.out.println(e.getMessage());
			luminosidad = filtro3();
		}
		
		return luminosidad;
	}
	
public String filtro4() {
		
		entrada = new Scanner(System.in);
				
		ArrayList<String> numeros = new ArrayList<String>();
		String[] nros = {"1", "2", "3", "4", "5"};
		
		for (String o: nros) {
			numeros.add(o);
		}
		
		System.out.println("D - Vigilancia:\n");   
		System.out.println ( "1 - 24 HS");
		System.out.println ( "2 - DIURNO");
		System.out.println ( "3 - NOCTURNO");
		System.out.println ( "4 - SIN VIGILANCIA");
		System.out.println ( "5 - TODAS");
			valor = entrada.nextLine();
		
		try {
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
				case "5":
					vigilancia = "VACIO"; break;	
				}	
			}else {
				throw new MiExcepcion ("Se ingreso un nro erroneo, elija el correspondiente");
				
			}
		}catch(MiExcepcion e) {
			System.out.println(e.getMessage());
			vigilancia = filtro4();
		}
		
		return vigilancia;
	}
	
public String filtro5() {
	
	entrada = new Scanner(System.in);
		
	ArrayList<String> numeros = new ArrayList<String>();
	String[] nros = {"1", "2", "3", "4", "5", "6"};
	
	for (String o: nros) {
		numeros.add(o);
	}
	
	System.out.println("E - Estado de conservacion:\n");   
	System.out.println ( "1 - A ESTRENAR");
	System.out.println ( "2 - A RECICLAR");
	System.out.println ( "3 - IMPECABLE");
	System.out.println ( "4 - MUY BUENO");
	System.out.println ( "5 - BUENO");
	System.out.println ( "6 - TODAS");
		valor = entrada.nextLine();
	
	try {
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
			case "6":
				estConserva = "VACIO"; break;
			}
		}else {
			throw new MiExcepcion ("Se ingreso un nro erroneo, elija el correspondiente");
			
		}
	}catch(MiExcepcion e) {
		System.out.println(e.getMessage());
		estConserva = filtro5();
	}
	
	return estConserva;
}
	
	public ArrayList<String> Filtros () {
		
		System.out.println("Que tipo de propiedad esta buscando?:\n");
		System.out.println("Filtre por estas 5 principales caracteristicas:\n");
		System.out.println("Las opciones estan numeradas, por favor elija el numero de la opcion que desee\n");
		
		tipoProp = this.filtro1();
		estado = this.filtro2();
		luminosidad = this.filtro3();
		vigilancia = this.filtro4();
		estConserva = this.filtro5();
		
		
		ArrayList<String> filtros = new ArrayList<String>();
		String[] f = {tipoProp, estado, luminosidad, vigilancia, estConserva};
			
		for (String o: f) {
			filtros.add(o);
		}
		return filtros;
		
	}
	
	public void MostrarProp(ArrayList<String> prop) {
		
		for (String i: prop) {
			System.out.println(i);
		}
	}
}
	

