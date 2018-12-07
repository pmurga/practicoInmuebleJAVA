package practicoInmuebleJAVA.UI;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import practicoInmuebleJAVA.*;
import practicoInmuebleJAVA.operaciones.Alquiler;
import practicoInmuebleJAVA.operaciones.Venta;
import practicoInmuebleJAVA.Agente;
import practicoInmuebleJAVA.Inmobiliaria;
import practicoInmuebleJAVA.Inmueble;
import practicoInmuebleJAVA.Propietario;

public class Menues {
	
	private Scanner entrada;
	private String tipoProp = null;
	private String estado = null;
	private String luminosidad = null;
	private String vigilancia = null;
	private String estConserva = null;
		
	// Desarrollo de todos los menues del main.
	
	public void Menu1 (Inmobiliaria im) {
		String valor = "0";
		System.out.println("BIENVENIDOS A INMOBILIARIA CAECE 2018\n");
		System.out.println("Elija su perfil:\n");
		entrada = new Scanner(System.in);
		
		while (!valor.equals("3")){
			
			System.out.println("PERFIL:\n");   
			System.out.println ( "1 - INMOBILIARIO");
			System.out.println ( "2 - POSIBLE CLIENTE");
			System.out.println ( "3 - SALIR");
				
			valor = entrada.nextLine();
				switch (valor) {
					case "1":
						 this.MenuInmob(im); break;
					case "2":
						this.MenuCliente(im); break;
					case "3":
						break;
					default:
						System.out.println("Ud. ingreso un dato erroneo, intentelo de nuevo"); break;
					}
				//para salir
				if (valor.equals("3")) {
					System.out.println("Gracias, vuelva pronto!");
					break;
				}
		}
	}

	// Menu para el inmobiliario.
	
	public void MenuInmob (Inmobiliaria im) {
		String valor = "0";
		int valor2 = 0;
		entrada = new Scanner(System.in);
		
		while (!valor.equals("6")) {
			
			System.out.println("INMOBILIARIO:\n");   
			System.out.println ( "1 - AGREGAR UNA PROPIEDAD");
			System.out.println ( "2 - ELIMINAR UNA PROPIEDAD");
			System.out.println ( "3 - AGREGAR UN AGENTE");
			System.out.println ( "4 - ELIMINAR UN AGENTE");
			System.out.println ( "5 - CALCULAR SALARIOS DE AGENTE");
			System.out.println ( "6 - MENU ANTERIOR");
						
			valor = entrada.nextLine();
				switch (valor) {
					case "1":
						MenuAgregarInmueble(im);break;
					case "2":
						im.mostrarALLInmuebles();
						ArrayList <Inmueble> all_inmuebles = im.getInmuebles();
						delInmueble(all_inmuebles, im);
						break;
						
					case "3":
						MenuAgregarAgente(im);break;
					case "4":
						MenuEliminarAgente(im);break;
					case "5":
						menuCalcularSueldoAgente(im);break;	
					case "6":
						break;
					default:
						System.out.println("Ud. ingreso un nro erroneo, intentelo de nuevo");
				}
		}
	}
	
	private boolean esDNIValido(int dni) {
				
		//min número de DNI permitido
		return( dni >= 1 ) ;
	}
	
	public void MenuCliente (Inmobiliaria im) {
		String valor = "0";
		entrada = new Scanner(System.in);
		ArrayList<String> f = new ArrayList<String>();
		
		while (!valor.equals("2")) {
			System.out.println("\nPOSIBLE CLIENTE:\n");   
			System.out.println ( "1 - BUSQUEDA DE PROPIEDAD");
			System.out.println ( "2 - MENU ANTERIOR");
		
			valor = entrada.nextLine();
			
			switch (valor) {
				case "1":
					f = this.Filtros();
					List <Inmueble> inmuebles = im.buscarInmueble(f);
					im.mostrarInmuebles(inmuebles);
					if(inmuebles.size() > 0) {
						System.out.println("\nElija el número de inmueble sobre el cuál desea confirmar la operación o presione 0 para volver atrás:");
						String indice = entrada.nextLine();
						if(esIndiceOpValido(indice, inmuebles)) {
							try {
								
								//si el índice del inmueble ingresado es correcto y corresponde 
								//al índice de un inmueble encontrado por la búsqueda
								//opero con el mismo a través del menú para operar
								im.Operar(inmuebles.get(Integer.parseInt(indice) -1).getId());
								
							}catch (Exception e) {
								System.out.println("\nERROR - no se pudo operar con el inmueble. Intente nuevamente");
							}
						}else {
							break;
						}
					}
				case "2":
					break;
				default:
					System.out.println("Ud. ingreso un nro erroneo, intentelo de nuevo");
			}
			//para volver al menu anterior cuando se sale de bloque switch
			if (valor.equals("2")) {
				break;
			}
		}
					
	}
	
	private boolean esIndiceOpValido(String indice, List<Inmueble> inmuebles) {
		
		try {
			
			return (!indice.equals("") && Integer.parseInt(indice) >= 1 && Integer.parseInt(indice) <= inmuebles.size());
			
		}catch (NumberFormatException e){

			System.out.println(
					"ERROR - inmueble seleccionado inválido: " + e.getStackTrace() 
					);
			
			return false;
		}
	}
	
	// Filtro para eleccion de tipo de propiedad.
	
	public String filtro1() {
		String valor = "0";
		entrada = new Scanner(System.in);
		
		while (!(valor.equals("1") || valor.equals("2") || valor.equals("3") || valor.equals("4") || valor.equals("5") || valor.equals("6") || valor.equals("7") || valor.equals("8") || valor.equals("9") || valor.equals("10") || valor.equals("11") || valor.equals("12") || valor.equals("13"))) {
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
				default:
					System.out.println("Ud. ingreso un nro erroneo, intentelo de nuevo");
			}
		}
		return tipoProp;
	}
	
	public String filtro2() {
		String valor = "0";
		entrada = new Scanner(System.in);

		
		while (!(valor.equals("1") || valor.equals("2") || valor.equals("3") || valor.equals("4") || valor.equals("5"))) {
			
			System.out.println("B - Estado:\n");   
			System.out.println ( "1 - HABITADO POR PROPIETARIO");
			System.out.println ( "2 - HABITADO POR INQUILINO");
			System.out.println ( "3 - DESHABITADO");
			System.out.println ( "4 - EN CONSTRUCCION");
			System.out.println ( "5 - TODAS");
						
			valor = entrada.nextLine();
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
				default:
					System.out.println("Ud. ingreso un nro erroneo, intentelo de nuevo");
			}
		}
		return estado;
	}
	
	public String filtro3() {
		String valor = "0";
		entrada = new Scanner(System.in);
		
		while (!(valor.equals("1") || valor.equals("2") || valor.equals("3") || valor.equals("4"))) {
			
			System.out.println("C - Luminosidad:\n");   
			System.out.println ( "1 - ALTA");
			System.out.println ( "2 - MEDIA");
			System.out.println ( "3 - BAJA");
			System.out.println ( "4 - TODAS");
				
			valor = entrada.nextLine();
			switch (valor) {
				case "1":
					luminosidad = "ALTA"; break;
				case "2":
					luminosidad = "MEDIA"; break;
				case "3":
					luminosidad = "BAJA"; break;
				case "4":
					luminosidad = "VACIO"; break;
				default:
					System.out.println("Ud. ingreso un nro erroneo, intentelo de nuevo");
			}
		}
		return luminosidad;
	}
	
	public String filtro4() {
		String valor = "0";
		entrada = new Scanner(System.in);
		
		while (!(valor.equals("1") || valor.equals("2") || valor.equals("3") || valor.equals("4") || valor.equals("5"))) {
			
			System.out.println("D - Vigilancia:\n");   
			System.out.println ( "1 - 24 HS");
			System.out.println ( "2 - DIURNO");
			System.out.println ( "3 - NOCTURNO");
			System.out.println ( "4 - SIN VIGILANCIA");
			System.out.println ( "5 - TODAS");
				
			valor = entrada.nextLine();
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
				default:
					System.out.println("Ud. ingreso un nro erroneo, intentelo de nuevo");
			}
		}
		return vigilancia;
	}
	
	public String filtro5() {
		String valor = "0";
		entrada = new Scanner(System.in);
			
		while (!(valor.equals("1") || valor.equals("2") || valor.equals("3") || valor.equals("4") || valor.equals("5") || valor.equals("6")))  {
			System.out.println("E - Estado de conservacion:\n");   
			System.out.println ( "1 - A ESTRENAR");
			System.out.println ( "2 - A RECICLAR");
			System.out.println ( "3 - IMPECABLE");
			System.out.println ( "4 - MUY BUENO");
			System.out.println ( "5 - BUENO");
			System.out.println ( "6 - TODAS");
				
			valor = entrada.nextLine();
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
				default:
					System.out.println("Ud. ingreso un nro erroneo, intentelo de nuevo");
			}
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
	
	public void menuOperar (Inmueble inmueble) {		
		
		System.out.println("\n____________________________________________________");
		System.out.println("\nBienvenido! Usted se encuentra en nuestra área de operaciones.");
		boolean error = false;
		try {
			System.out.println("\nEl inmueble seleccionado es: \n" );
			inmueble.mostrarInmueble();
			if (inmueble.getOp() instanceof Venta || inmueble.getOp() instanceof Alquiler) {
				
				inmueble.getOp().CalcularMontoOperacion();
				
			}
			
		}catch (NullPointerException e){
			System.out.println("\nEl inmueble con el que desea operar es inválido");
			error = true;
		}
		if (!error) {
			System.out.println("\n");
			System.out.println("\nConfirma la operación * " + inmueble.getOPDisponible() + " * ? S/N:" );
			
			Scanner entrada = new Scanner(System.in);
			String option = entrada.nextLine();
			switch (option) {
				case "S":
						inmueble.getOp().setCompletada(true) ; 
						break;
				case "N":
						System.out.println("\nLa operación NO ha sido confirmada");
						System.out.println("\nVolviendo al menú anterior..");
						break;
				default:
					System.out.println("\nUd. ingreso una opción erronea, intentelo nuevamente");
			}
		}
	}

	// Metodo que genera un propietario en tiempo de ejecucion.
	
	public Propietario ConstruirProp () {
		
		int valor2;
		boolean repetir = true;
		Scanner entrada = new Scanner(System.in);
		Propietario propietario = new Propietario();
		
		System.out.println("Ingrese el nombre:");
		propietario.setNombre(entrada.nextLine());
		
		System.out.println("Ingrese el apellido:");
		propietario.setApellido(entrada.nextLine());
		
		do{
		   System.out.println("Ingrese el dni: ");
		   try {
			   		valor2= entrada.nextInt();
			   		repetir = false;
			   		propietario.setDni(valor2);
			   }catch(InputMismatchException e){
			       entrada.nextLine();
			       System.out.println("Error, has introducido mal el dni");
			   }
			}while(repetir);
		
		repetir = true;
		
		do{
		   System.out.println("Ingrese el telefono: ");
		   try {
			   		valor2= entrada.nextInt();
			   		repetir = false;
			   		propietario.setTelefono(valor2);
			   }catch(InputMismatchException e){
			       entrada.nextLine();
			       System.out.println("Error, has introducido mal el telefono");
			   }
			}while(repetir);
		
		repetir = true;
		
		do{
		   System.out.println("Ingrese el telefono movil: ");
		   try {
			   		valor2= entrada.nextInt();
			   		repetir = false;
			   		propietario.setTelMovil(valor2);
			   }catch(InputMismatchException e){
			       entrada.nextLine();
			       System.out.println("Error, has introducido mal el telefono movil");
			   }
			}while(repetir);
		
		   //fix para que no saltee linea
			entrada.nextLine();

		
		System.out.println("Ingrese el email: ");
		propietario.setEmail(entrada.nextLine());
		
		System.out.println("Ingrese la direccion: ");
		propietario.setDireccion(entrada.nextLine());
		
		System.out.println("Ingrese el codigo postal:");
		propietario.setCodpostal(entrada.nextLine());
		
		System.out.println("Ingrese la localidad: ");
		propietario.setLocalidad(entrada.nextLine());
		
		System.out.println("Ingrese comentarios: ");
		propietario.setComentarios(entrada.nextLine());
					
		return propietario;
	}
	
	
	// Metodo y menu para agregar un imueble en tiempo de ejecucion.
	
	public void MenuAgregarInmueble (Inmobiliaria im) {
		
		Scanner entrada = new Scanner(System.in);
		Agente ag = new Agente();
		int valor2 = 0;
		String calle = null;
		int nroCalle = 0;
		String tipoProp = null;
		
		System.out.println("Datos a ingresar: Propietario, Agente, nombre de calle, nro de calle y tipo de propiedad: \n");
		
		//Datos propietario: 
		
		System.out.println("Ingrese los datos del propietario: \n");
		Propietario pr = new Propietario();
		pr = ConstruirProp();
		
		//Dato de Agente:
		
		boolean repetir = true;
		
		do{
			im.mostrarAgentes();
			System.out.println("Introduce el dni de agente para buscarlo: ");
		   try {
			   		valor2= entrada.nextInt();
			   		repetir = false;
			   		ag = im.buscarAgente(valor2);
					if (ag == null) {
						repetir = true;
						System.out.println("Error, No se encontro ningun agente con este dni");
					}else {
						repetir = false;
					}
			   	}catch(InputMismatchException e){
			       entrada.nextLine();
			       System.out.println("Error, has introducido mal el dni");
			    }
			}while(repetir);
		   //fix para que no saltee linea
			entrada.nextLine();

		
		// Dato de nombre de calle:
		
		System.out.println("Ingrese el nombre de la calle");
		calle = entrada.nextLine();
		
		// Dato de nro de calle:
		
		repetir = true;
		
		do{
		   System.out.println("Ingrese el numero de la calle: ");
		   try {
			   		nroCalle = entrada.nextInt();
			   		repetir = false;
			   	}catch(InputMismatchException e){
			       entrada.nextLine();
			       System.out.println("Error, has introducido mal el numero de calle");
			   }
			}while(repetir);
		
		//dato de tipo de propiedad
		
		Menues m = new Menues();
		tipoProp = m.filtro1();
		
		Inmueble in = new Inmueble(pr, ag, calle, nroCalle, tipoProp);
		im.addInmueble(in);
		System.out.println("Se agrego con exito una propiedad en la inmobiliaria");
		
	}
	public void MenuAgregarAgente (Inmobiliaria im) {//Permite agregar un agente en tiempo de ejecución
		Scanner entrada = new Scanner(System.in);
		int valor2 = 0;
		
		String nombre = null; 
		String apellido = null; 
		int dni = 0;
		int telefono = 0;
		int telMovil = 0; 
		String email = null; 
		String direccion = null;
		String codpostal = null;
		String localidad = null;
		String comentarios = null;
		int nroagente = 0; 
		int cuil = 0;
		double sueldobasico = 0;
		
		System.out.println("Datos a ingresar: Nombre, Apellido, DNI, Teléfono, Celular, Email, Dirección, Código Postal, Localidad, Comentarios, Número de Agente y Sueldo Básico: \n");
		
		//Datos del agente 
		System.out.println("Ingrese los datos del agente \n");
		// Dato de nombre:
		System.out.println("Ingrese el nombre: ");
		nombre = entrada.nextLine();
		
		// Dato de apellido:				   
		System.out.println("Ingrese el apellido: ");
		apellido = entrada.nextLine();

		// Dato número de dni:
		boolean repetir = true;
		
		do{
			System.out.println("Ingrese el número de DNI del agente:");
		   try {//Chequear si existe ya el agente
		   		valor2 = entrada.nextInt();
		   		Agente agaux = im.buscarAgente(valor2);
				if (agaux == null) {
					dni = valor2;
					repetir = false;
				}else {
					System.out.println("Error: Ya existe un agente con este dni en la inmobiliaria");
					repetir = true;
				}
		   	}catch(InputMismatchException e){
		       entrada.nextLine();
		       System.out.println("Error, has introducido mal el dni");
		    }
		}while(repetir);
	   //fix para que no saltee linea
		entrada.nextLine();
		
		//Dato de email:
		System.out.println("Ingrese el email: ");
		System.out.println("\n");
		email = entrada.nextLine();
								
		// Dato de dirección:
		System.out.println("Ingrese la dirección:");
		direccion = entrada.nextLine();
		
		// Dato de código postal:
		System.out.println("Ingrese el código postal:");
		codpostal = entrada.nextLine();
		
		// Dato de localidad:
		System.out.println("Ingrese la localidad:");
		localidad = entrada.nextLine();
		
		// Dato de comentario:
		System.out.println("Ingrese algún comentario:");
		comentarios = entrada.nextLine();
		
		// Dato de nro de teléfono:
		repetir = true;
		
		do{
		   System.out.println("Ingrese el número telefonico: ");
		   try {
			   		telefono = entrada.nextInt();
			   		repetir = false;
			   	}catch(InputMismatchException e){
			       entrada.nextLine();
			       System.out.println("Error, has introducido mal el número de teléfono");
			   }
			}while(repetir);


		// Dato de nro de celular:
		repetir = true;
		
		do{
		   System.out.println("Ingrese el número de celular: ");
		   try {
			   		telMovil = entrada.nextInt();
			   		repetir = false;
			   	}catch(InputMismatchException e){
			       entrada.nextLine();
			       System.out.println("Error, has introducido mal el número de celular");
			   }
			}while(repetir);
		
		// Dato de nro de agente:
		repetir = true;
		
		do{
		   System.out.println("Ingrese el número de agente: ");
		   try {
			   		nroagente = entrada.nextInt();
			   		repetir = false;
			   	}catch(InputMismatchException e){
			       entrada.nextLine();
			       System.out.println("Error, has introducido mal el número de agente");
			   }
			}while(repetir);
		
		
		// Dato de nro de cuil:
		repetir = true;
		
		do{
		   System.out.println("Ingrese el número de cuil del agente: ");
		   try {
			   		cuil = entrada.nextInt();
			   		repetir = false;
			   	}catch(InputMismatchException e){
			       entrada.nextLine();
			       System.out.println("Error, has introducido mal el número de cuil");
			   }
			}while(repetir);
		
		// Dato de sueldo básico:
		repetir = true;
		
		do{
		   System.out.println("Ingrese el sueldo básico del agente: ");
		   try {
			   		sueldobasico = entrada.nextInt();
			   		repetir = false;
			   	}catch(InputMismatchException e){
			       entrada.nextLine();
			       System.out.println("Error, has introducido mal el sueldo del agente");
			   }
			}while(repetir);

		
		Agente ag = new Agente(nombre, apellido, dni, telefono, telMovil, email, direccion, codpostal, localidad, comentarios, nroagente, cuil, sueldobasico);
		im.addAgente(ag);
		System.out.println("Se agrego con exito el agente en la inmobiliaria");
	}

	public void MenuEliminarAgente(Inmobiliaria im) {
		Scanner entrada = new Scanner(System.in);
		int dni = 0;
		int valor2 = 0;
		
		boolean repetir = true;
		
		do{
			System.out.println("Ingrese el dni del agente a eliminar: \n");
			try {//Chequear si existe el agente
		   		valor2 = entrada.nextInt();
		   		Agente agaux = im.buscarAgente(valor2);
				if (agaux != null) {
					dni = valor2;
					repetir = false;
					im.delAgente(agaux);
				}else {
					System.out.println("Error: No existe un agente con este dni en la inmobiliaria");
					repetir = true;
				}
		   	}catch(InputMismatchException e){
		       entrada.nextLine();
		       System.out.println("Error, has introducido mal el dni");
		    }
		}while(repetir);
		
		System.out.println("Se eliminó con exito el agente en la inmobiliaria");
		
	}
	
	public void delInmueble(ArrayList <Inmueble> all_inmuebles, Inmobiliaria im) {
		if(all_inmuebles.size() > 0) {
			System.out.println("\nSeleccione el número de inmueble que quiere eliminar o presione 0 para volver atrás: ");
			String indice = entrada.nextLine();
			
			if(esIndiceOpValido(indice, all_inmuebles)) {
				try {
					
					//si el índice del inmueble ingresado es correcto y corresponde 
					//a algun inmueble de la base de datos
					//lo puedo eliminar
					im.delInmueble(all_inmuebles.get(Integer.parseInt(indice) -1).getId());
					
				}catch (Exception e) {
					System.out.println("\nERROR - no se pudo operar con el inmueble. Intente nuevamente");
				}
			
			}	
		}
	}
	
	public void menuCalcularSueldoAgente(Inmobiliaria im) {
		double sueldo;
		im.mostrarAgentes();
		boolean repetir = true;
		
		do {
			System.out.println("\nIngrese el DNI del agente sobre el cuál calcular el salario: ");
			try {
				int dni = entrada.nextInt();
				if (im.getAgentes() != null) {
					
					if (esDNIValido(dni)) {
						try {
							Agente agaux = im.buscarAgente(dni);
							sueldo = im.calcularSueldoAgente(dni);
							System.out.println("\n____________________________________________________");
							
							System.out.println("\nAgente: ");
							agaux.mostrarAgente();
							System.out.println("\nEl sueldo del agente es: " + sueldo);
							System.out.println("\n____________________________________________________");
							repetir = false;
						}catch(NullPointerException e){
							System.out.println("\nERROR - no existe un agente con ese DNI. Intente nuevamente..\n");
						}
						
					}
				}
			}catch(InputMismatchException e) {
				System.out.println("\nERROR - debe ingresar un número entero");
			}
			//fix para volver al menu anterior
			entrada.nextLine();
		}while(repetir);
		


	}
	
}