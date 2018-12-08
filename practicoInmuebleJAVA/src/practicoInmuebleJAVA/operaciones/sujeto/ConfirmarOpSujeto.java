package practicoInmuebleJAVA.operaciones.sujeto;

import java.util.ArrayList;

import practicoInmuebleJAVA.Agente;
import practicoInmuebleJAVA.operaciones.observer.Observer;


public class ConfirmarOpSujeto implements Sujeto{

	private float monto; 
	private Agente agente;
	private static ArrayList<Observer> arrObservadores;
	
	
	
	public ConfirmarOpSujeto(float monto, Agente agente) {
		this.monto = monto;
		this.agente = agente;
		this.arrObservadores = new ArrayList<>();

	}


	public void attach(Observer obs) {
		
		arrObservadores.add(obs);
	}

	
	public void dettach(Observer obs) {
		
		arrObservadores.remove(obs);
	}

	
	public void notifyObservers() {
		
		for(Observer obs : arrObservadores){
			obs.updateComisiones(monto, agente);
		}
	}

}
