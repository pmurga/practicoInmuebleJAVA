package practicoInmuebleJAVA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import practicoInmuebleJAVA.UI.Menues;
import practicoInmuebleJAVA.operaciones.observer.ConfirmarOpObserver;
import practicoInmuebleJAVA.operaciones.observer.Observer;

public class Inmobiliaria  {
	
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

	public ArrayList<Inmueble> getInmuebles() {
		return inmuebles;
	}

	public void addInmueble(Inmueble inmueble) { this.inmuebles.add(inmueble); }

	public void delInmueble(Inmueble inmueble) { this.inmuebles.remove(inmueble); }

	public void addAgente(Agente agente) {
		this.comisiones_agentes.put(((Persona)agente).getDni(), (double) 0);
		this.agentes.put(((Persona)agente).getDni(), agente);
	}
	
	public void delAgente(Agente agente) {
		this.comisiones_agentes.remove(((Persona)agente).getDni());
		this.agentes.remove(((Persona)agente).getDni());
	}

	public double calcularSueldoAgente(int agente){
		return (this.comisiones_agentes.get(agente) + this.agentes.get(agente).getSueldobasico());
	}
	
	
	public void updateComisiones(float monto, Agente agente){
		Double comision_actual = this.comisiones_agentes.get(agente);
		Float monto_comision = monto*2/100;
		
		this.comisiones_agentes.put(((Persona)agente).getDni(), (double) comision_actual + monto_comision);
		
	};
	
	//eliminar de la lista de resultados todos los inmuebles cuya op. ya haya sido confirmada
	private void eliminarOPcompletadas(List<Inmueble> inmuebles) {
		
		ArrayList<Inmueble> encontrados = new ArrayList<Inmueble>();
		for (Inmueble inmueble : inmuebles) {
			if(inmueble.getOp().isCompletada()) {
				encontrados.add(inmueble);
			}	
		}
		inmuebles.removeAll(encontrados);	
	}
	
	public List<Inmueble> buscarInmueble (ArrayList<String> filtros){
		
		//copiar contenidos de la lista de inmuebles a lista de resultados para trabajar con auxiliar
		//ya que luego eliminaré elementos que no matchean los criterios de filtrado
		List<Inmueble> resultados = new ArrayList<Inmueble>(this.inmuebles);
		
		//evaluar filtro según opciones soportadas 
		for (int i=0; i<filtros.size() ; i++) {
		
			evaluarFiltro(i, filtros.get(i), resultados);
			
		}
		
		eliminarOPcompletadas(resultados);

		return resultados;
	}
	
	private void evaluarFiltro(int i, String filtro, List<Inmueble> resultados) {
		
		//opciones soportadas --> tipoProp(0), estado(1), luminosidad(2), vigilancia(3), estConserva(4)
		// dudas ? --> ver método Filtros de practicoInmuebleJAVA.UI.Menues
		//filtro = VACIO (op. = TODOS/AS) --> se ignora dicho criterio 
		//si el usuario no ingresó nada para esa opción (VACIO = '*' en la busqueda)
		
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
	//evaluará para cada criterio eliminando aquellos inmuebles que no cumplan con la op. ingresada
	private void evaluarTipoProp(String filtro, List<Inmueble> resultados) {
		
		ArrayList<Inmueble> encontrados = new ArrayList<Inmueble>();
		for (Inmueble inmueble : resultados) {
			if (!filtro.equalsIgnoreCase(inmueble.getNameTipoPropiedad())) {
					encontrados.add(inmueble);
			}	
		}
		if (!encontrados.isEmpty()){
			resultados.removeAll(encontrados);
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
			resultados.removeAll(encontrados);
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
			resultados.removeAll(encontrados);
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
			resultados.removeAll(encontrados);
		}
	}
	private void evaluarEstConserva(String filtro, List<Inmueble> resultados) {
		ArrayList<Inmueble> encontrados = new ArrayList<Inmueble>();					
		for (Inmueble inmueble : resultados) {
			if (inmueble.isDefEstadoConservacion()) {
				if (!filtro.equalsIgnoreCase(inmueble.getNameEstadoConservacion())) {
						encontrados.add(inmueble);
				}
			}
				
		}
		if (!encontrados.isEmpty()){
			 resultados.removeAll(encontrados);
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
		
				inmueble.mostrarInmueble();
				
				c += 1;
			}
		}else {
			System.out.println("\nERROR - No hay inmuebles disponibles con ese criterio en este momento!");
			System.out.println("\nPuede probar nuevamente utilizando un criterio distinto o ampliar la búsqueda usando la opción TODOS en cada filtro.");
			System.out.println("\n____________________________________________________");

		}
		
	}

	// Metodo para buscar un agente y devolverlo.
	public Agente buscarAgente (int dni) { return this.agentes.get(dni); }
		
	public void Operar(int id_inmueble){
		
		boolean encontrado = false;
		
			for(Inmueble inmueble : this.inmuebles){
				if(inmueble.getId() == id_inmueble){
					encontrado = true;
					Menues menu = new Menues();
					menu.menuOperar(inmueble);
					
				}
			}
			if (!encontrado) {
				System.out.println("\nERROR - no se ha encontrado ningún inmueble con el id indicado");
			}
		
	}

	public void delInmueble(int id_inmueble) {
		
		ArrayList<Inmueble> encontrados = new ArrayList<Inmueble>();
		
		for(Inmueble inmueble : this.inmuebles){
			if(inmueble.getId() == id_inmueble){
				System.out.println("\n____________________________________________________");
				System.out.println("\nEl siguiente inmueble será eliminado de la base de datos:\n ");
				inmueble.mostrarInmueble();
				encontrados.add(inmueble);

			}
		}
		if (encontrados.isEmpty()) {
			System.out.println("\nERROR - no se ha encontrado ningún inmueble con esas característica en la base de datos");
		}else {
			this.inmuebles.removeAll(encontrados);
			System.out.println("\nEl inmueble fue eliminado exitosamente!");
			System.out.println("\n");
		}
		
	}
	
	public void mostrarAgentes () {
		
		int c = 1;
		System.out.println("\n____________________________________________________");
		System.out.println("\nLista de Agentes: ");
		if (!inmuebles.isEmpty()) {
			
			for (Agente agente : agentes.values()) {
				System.out.println("\nAgente: " + c);
		
				agente.mostrarAgente();
				
				System.out.println("\n____________________________________________________");

				
				c += 1;
			}
		}else {
			System.out.println("\nERROR - No hay agentes en la inmobiliaria en este momento.");
			System.out.println("\n____________________________________________________");

		}
		
	}
	
	public ArrayList<Agente> getAgentes() {
		
		ArrayList<Agente> resultados = new ArrayList<>();
		
		for (Agente agente : agentes.values()) {
			resultados.add(agente);
		}
		return resultados;
			
		
	}
}


