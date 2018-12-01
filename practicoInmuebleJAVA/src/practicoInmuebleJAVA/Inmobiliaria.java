package practicoInmuebleJAVA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

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
		this.comisiones_agentes.put(agente.getNroagente(), (double) 0);
		this.agentes.put(agente.getNroagente(), agente);
	}

	public double calcularSueldoAgente(int agente){
		return (this.comisiones_agentes.get(agente) + this.agentes.get(agente).getSueldobasico());
	}
	
	@Override
	public void updateComisiones(float monto, Agente agente){
		Double comision_actual = this.comisiones_agentes.get(agente);
		Float monto_comision = monto*2/100;
		
		this.comisiones_agentes.put(agente.getNroagente(), (double) comision_actual + monto_comision);
		
	};
	
	
	public ArrayList<Inmueble> buscarInmueble (ArrayList<String> filtros){
		
		ArrayList<Inmueble> resultados = new ArrayList<Inmueble>();
		
		//copiar contenidos de la lista de inmuebles a lista de resultados para trabajar con auxiliar
		for (Inmueble inmueble : this.inmuebles) {	
			resultados.add(inmueble);
		}
		//evaluar filtro según opciones soportadas 
		for (int i=0; i<=filtros.size() ; i++) {
			
			evaluarFiltro(i, filtros.get(i),resultados);
			
		}
		return resultados;
	}
	
	private void evaluarFiltro(int i, String filtro, ArrayList<Inmueble> resultados) {
		
		//opciones soportadas --> tipoProp(0), estado(1), luminosidad(2), vigilancia(3), estConserva(4)
		// dudas ? --> ver método Filtros de practicoInmuebleJAVA.UI.Menues
		//filtro = null si el usuario no ingresó nada para esa opción (null = '*' en la busqueda)
		if (filtro != "VACIO"){
			
			if (i == 0) {evaluarTipoProp(filtro,resultados);}
			if (i == 1) {evaluarEstado(filtro,resultados);}
			if (i == 2) {evaluarLuminosidad(filtro,resultados);}
			if (i == 3) {evaluarVigilancia(filtro,resultados);}
			if (i == 4) {evaluarEstConserva(filtro,resultados);}

		}
	}
	
	/* CRITERIOS OBTENIDOS DE CLASE INMUBLE
	private enum Estado {HABITADO_PROPIETARIO, DESHABITADO, EN_CONSTRUCCION, HABITADO_INQUILINO};
	private enum Luminosidad {ALTA, MEDIA, BAJA};
	private enum Vigilancia {VEINTICUATRO_HS, DIURNO, NOCTURNO, NO_TIENE};
	private enum EstadoConservacion {A_ESTRENAR, A_RECICLAR, IMPECABLE, BUENO, MUY_BUENO};
	private enum TipoPropiedad {ESTUDIO, LOFT, DEPARTAMENTO, PISO, DUPLEX, TRIPLEX, CHALET, CASA, LOCAL, COCHERA, OFICINA, EDIFICIO};
	*/
	
	private void evaluarTipoProp(String filtro, ArrayList<Inmueble> resultados) {
		
		for (Inmueble inmueble : resultados) {
			if (!filtro.equalsIgnoreCase(inmueble.getNameTipoPropiedad())) {
				resultados.remove(inmueble);
			}	
		}	
	}
	private void evaluarEstado(String filtro, ArrayList<Inmueble> resultados) {
		
		for (Inmueble inmueble : resultados) {
			if (!filtro.equalsIgnoreCase(inmueble.getNameTipoPropiedad())) {
				resultados.remove(inmueble);
			}	
		}	
	}	
	private void evaluarLuminosidad(String filtro, ArrayList<Inmueble> resultados) {
		
		for (Inmueble inmueble : resultados) {
			if (!filtro.equalsIgnoreCase(inmueble.getNameTipoPropiedad())) {
				resultados.remove(inmueble);
			}	
		}	
	}	
	private void evaluarVigilancia(String filtro, ArrayList<Inmueble> resultados) {
		
		for (Inmueble inmueble : resultados) {
			if (!filtro.equalsIgnoreCase(inmueble.getNameTipoPropiedad())) {
				resultados.remove(inmueble);
			}	
		}	
	}
	private void evaluarEstConserva(String filtro, ArrayList<Inmueble> resultados) {
		
		for (Inmueble inmueble : resultados) {
			if (!filtro.equalsIgnoreCase(inmueble.getNameTipoPropiedad())) {
				resultados.remove(inmueble);
			}	
		}	
	}
	
	public void mostrarALLInmuebles() {
		this.mostrarInmuebles(this.inmuebles);
	}
	
	public void mostrarInmuebles (ArrayList <Inmueble> inmuebles) {
		
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
		Scanner entrada = new Scanner(System.in);
		Propietario propietario = new Propietario();
		
		System.out.println("Ingrese el nombre:");
		propietario.setNombre(entrada.nextLine());
		
		System.out.println("Ingrese el apellido:");
		propietario.setApellido(entrada.nextLine());
		
		
		boolean repetir = true;

		do{
		   System.out.println("Introduce el dni: ");
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
		   System.out.println("Introduce el telefono: ");
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
		   System.out.println("Introduce el telefono movil: ");
		   try {
			   		valor2= entrada.nextInt();
			   		repetir = false;
			   		propietario.setTelMovil(valor2);
			   }catch(InputMismatchException e){
			       entrada.nextLine();
			       System.out.println("Error, has introducido mal el telefono movil");
			   }
			}while(repetir);
		
		System.out.println("Ingrese el email:");
		propietario.setEmail(entrada.nextLine());
		
		System.out.println("Ingrese la direccion:");
		propietario.setDireccion(entrada.nextLine());
		
		System.out.println("Ingrese el codigo postal:");
		propietario.setCodpostal(entrada.nextLine());
		
		System.out.println("Ingrese la localidad:");
		propietario.setLocalidad(entrada.nextLine());
		
		System.out.println("Ingrese comentarios:");
		propietario.setComentarios(entrada.nextLine());
					
		return propietario;
	}
	
	public Agente BuscarAgente (int dni) {
		Agente ag = new Agente ();
		for (Map.Entry<Integer, Agente> ags: this.agentes.entrySet()) {
			if (ags.getValue().getDni() == dni) {
				ag = ags.getValue(); 
			}
		}
		return ag;
	}

}
