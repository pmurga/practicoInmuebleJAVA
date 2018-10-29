package practicoInmuebleJAVA;

import java.util.ArrayList;

public class Inmobiliaria {
	
	private ArrayList<Inmueble> inmuebles;
	private ArrayList<Agente> agentes;
	
	public void addInmueble(Inmueble inmueble) { this.inmuebles.add(inmueble); }
	
	public void addAgente(Agente agente) { this.agentes.add(agente); }
	
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
