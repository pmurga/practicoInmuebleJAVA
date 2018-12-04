package practicoInmuebleJAVA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import practicoInmuebleJAVA.UI.Menues;
import practicoInmuebleJAVA.operaciones.observer.ConfirmarOpObserver;

public class Inmobiliaria implements ConfirmarOpObserver {
	
	private ArrayList<Inmueble> inmuebles;
	private HashMap<Integer, Agente> agentes;
	private HashMap<Integer, Double> comisiones_agentes;
	
	private static ArrayList<ConfirmarOpObserver> arrObservadores;
	
	
	//Después modificar este constructor
	public Inmobiliaria() {
		this.inmuebles = new ArrayList<Inmueble>();
		this.agentes = new HashMap<Integer, Agente>();
		this.comisiones_agentes = new HashMap<Integer, Double>();
		
	}

	public void addInmueble(Inmueble inmueble) { this.inmuebles.add(inmueble); }
	
	public void addAgente(Agente agente) {
		this.comisiones_agentes.put(((Persona)agente).getDni(), (double) 0);
		this.agentes.put(((Persona)agente).getDni(), agente);
	}

	public double calcularSueldoAgente(int agente){
		return (this.comisiones_agentes.get(agente) + this.agentes.get(agente).getSueldobasico());
	}
	
	@Override
	public void updateComisiones(float monto, Agente agente){
		Double comision_actual = this.comisiones_agentes.get(agente);
		Float monto_comision = monto*2/100;
		
		this.comisiones_agentes.put(((Persona)agente).getDni(), (double) comision_actual + monto_comision);
		
	};
	
	private ArrayList<Inmueble> copiarArray(ArrayList<Inmueble> array) {
		
		ArrayList <Inmueble> respuesta = new ArrayList<Inmueble>();
		
		for (Inmueble elem : array) {	
			respuesta.add(elem);
		}
		
		return respuesta;
		
	}
	
	public List<Inmueble> buscarInmueble (ArrayList<String> filtros){
		
		//copiar contenidos de la lista de inmuebles a lista de resultados para trabajar con auxiliar
		List<Inmueble> resultados = new ArrayList<Inmueble>(this.inmuebles);
		//resultados = copiarArray(this.inmuebles);
		
		//evaluar filtro según opciones soportadas 
		for (int i=0; i<filtros.size() ; i++) {
			System.out.println(i);
			System.out.println("filtros get: " + filtros.get(i));
			evaluarFiltro(i, filtros.get(i), resultados);
			System.out.println("Vuelta: " + i);
			
		}
		return resultados;
	}
	
	private void evaluarFiltro(int i, String filtro, List<Inmueble> resultados) {
		
		//opciones soportadas --> tipoProp(0), estado(1), luminosidad(2), vigilancia(3), estConserva(4)
		// dudas ? --> ver método Filtros de practicoInmuebleJAVA.UI.Menues
		//filtro = VACIO si el usuario no ingresó nada para esa opción (VACIO = '*' en la busqueda)
		
		System.out.println("filtro evaluar filtro: " + filtro);
		if (!filtro.equals("VACIO")){
			if (i == 0) {evaluarTipoProp(filtro,resultados);}
			if (i == 1) {evaluarEstado(filtro,resultados);}
			if (i == 2) {evaluarLuminosidad(filtro,resultados);}
			if (i == 3) {evaluarVigilancia(filtro,resultados);}
			if (i == 4) {evaluarEstConserva(filtro,resultados);}
		}
	}
	
	/* CRITERIOS OBTENIDOS DE CLASE INMUEBLE
	private enum Estado {HABITADO_PROPIETARIO, DESHABITADO, EN_CONSTRUCCION, HABITADO_INQUILINO};
	private enum Luminosidad {ALTA, MEDIA, BAJA};
	private enum Vigilancia {VEINTICUATRO_HS, DIURNO, NOCTURNO, NO_TIENE};
	private enum EstadoConservacion {A_ESTRENAR, A_RECICLAR, IMPECABLE, BUENO, MUY_BUENO};
	private enum TipoPropiedad {ESTUDIO, LOFT, DEPARTAMENTO, PISO, DUPLEX, TRIPLEX, CHALET, CASA, LOCAL, COCHERA, OFICINA, EDIFICIO};
	*/
	
	private void evaluarTipoProp(String filtro, List<Inmueble> resultados) {
		
		ArrayList<Inmueble> encontrados = new ArrayList<Inmueble>();
		for (Inmueble resultado : resultados) {
			if (!filtro.equalsIgnoreCase(resultado.getNameTipoPropiedad())) {
				encontrados.add(resultado);
			}	
		}
		if (!encontrados.isEmpty()){
			for (Inmueble encontrado : encontrados) {
				System.out.println(encontrado.getCalle() + encontrado.getNro());
				resultados.remove(encontrado);
			}
			for (Inmueble resultado : resultados) {
				System.out.println(resultado.getTipoPropiedad() + resultado.getCalle() + resultado.getNro());
			}
		}
	}
	private void evaluarEstado(String filtro, List<Inmueble> resultados) {
		ArrayList<Inmueble> encontrados = new ArrayList<Inmueble>();	
		for (Inmueble inmueble : resultados) {
			if (inmueble.isDefEstado()){			
				if (!filtro.equalsIgnoreCase(inmueble.getNameEstado())) {
					encontrados.add(inmueble);
				}
			}	
		}
		if (!encontrados.isEmpty()){
			//resultados.removeAll(encontrados);
		}
	}	
	private void evaluarLuminosidad(String filtro, List<Inmueble> resultados) {
		ArrayList<Inmueble> encontrados = new ArrayList<Inmueble>();	
		for (Inmueble inmueble : resultados) {
			if (inmueble.isDefLuminosidad()) {
				if (!filtro.equalsIgnoreCase(inmueble.getNameLuminosidad())) {
					encontrados.add(inmueble);
				}	
			}
		}
		if (!encontrados.isEmpty()){
			//resultados.removeAll(encontrados);
		}
	}	
	private void evaluarVigilancia(String filtro, List<Inmueble> resultados) {
		ArrayList<Inmueble> encontrados = new ArrayList<Inmueble>();			
		for (Inmueble inmueble : resultados) {
			if (inmueble.isDefVigilancia()) {
				if (!filtro.equalsIgnoreCase(inmueble.getNameVigilancia())) {
					encontrados.add(inmueble);
				}
			}	
		}
		if (!encontrados.isEmpty()){
			//resultados.removeAll(encontrados);
		}
	}
	private void evaluarEstConserva(String filtro, List<Inmueble> resultados) {
		ArrayList<Inmueble> encontrados = new ArrayList<Inmueble>();					
		for (Inmueble inmueble : resultados) {
			if (inmueble.isDefEstadoConservacion()) {
				if (!filtro.equalsIgnoreCase(inmueble.getNameEstadoConservacion())) {
					System.out.println(inmueble);
					encontrados.add(inmueble);
				}
			}
				
		}
		if (!encontrados.isEmpty()){
			// resultados.removeAll(encontrados);
		}
	}
	
	public void mostrarALLInmuebles() {
		this.mostrarInmuebles(this.inmuebles);
	}
	
	public void mostrarInmuebles (List <Inmueble> inmuebles) {
		
		int c = 1;
		System.out.println("\n____________________________________________________");
		System.out.println("\nLista de Inmuebles: ");
		if (!inmuebles.isEmpty()) {
			
			for (Inmueble inmueble : inmuebles) {
				System.out.println("\nInmueble: " + c);
				
				if (inmueble.getPiso() != 0) {
					System.out.println("  - Domicilio: " + inmueble.getCalle() + " " + inmueble.getNro() + " Piso: " + inmueble.getPiso() + inmueble.getPuerta());
				}else {
					System.out.println("  - Domicilio: " + inmueble.getCalle() + " " + inmueble.getNro());					
				}

				System.out.println("  - Tipo de Propiedad: " + inmueble.getTipoPropiedad());
				System.out.println("  - Disponible para: " + inmueble.getOPDisponible());
				System.out.println("\n____________________________________________________");
				
				c += 1;
			}
		}else {
			System.out.println("ERROR - No hay inmuebles disponibles en este momento.");
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
	
	// Metodo para buscar un agente y devolverlo.
	public Agente BuscarAgente (int dni, Inmobiliaria im) {
		Agente ag = null;
		ag = im.agentes.get(dni);
		return ag;
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
		pr = im.ConstruirProp();
		
		//Dato de Agente:
		
		boolean repetir = true;
		
		do{
		   System.out.println("Introduce el dni de agente para buscarlo: ");
		   try {
			   		valor2= entrada.nextInt();
			   		repetir = false;
			   		ag = im.BuscarAgente(valor2, im);
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
}


