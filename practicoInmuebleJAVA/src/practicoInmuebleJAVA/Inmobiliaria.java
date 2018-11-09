package practicoInmuebleJAVA;

import java.util.*;
import java.util.HashMap;
import java.util.Scanner;

public class Inmobiliaria {
	
	private ArrayList<Inmueble> inmuebles;
	private HashMap<Integer, Agente> agentes;
	private HashMap<Integer, Double> comisiones_agentes;
	
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

