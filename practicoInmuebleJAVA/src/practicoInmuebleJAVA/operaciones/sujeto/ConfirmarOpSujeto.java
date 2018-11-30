package practicoInmuebleJAVA.operaciones.sujeto;

import java.util.ArrayList;
import java.util.Observer;

import practicoInmuebleJAVA.Agente;
import practicoInmuebleJAVA.operaciones.observer.ConfirmarOpObserver;


public class ConfirmarOpSujeto implements Sujeto{

	private float monto; 
	private Agente agente;
	private static ArrayList<ConfirmarOpObserver> arrObservadores;
	
	
	
	public ConfirmarOpSujeto(float monto, Agente agente) {
		this.monto = monto;
		this.agente = agente;
		this.arrObservadores = new ArrayList<>();

	}


	public void attach(ConfirmarOpObserver obs) {
		
		arrObservadores.add(obs);
	}

	
	public void dettach(ConfirmarOpObserver obs) {
		
		arrObservadores.remove(obs);
	}

	
	public void notifyObservers() {
		
		for(ConfirmarOpObserver obs : arrObservadores)
			obs.updateComisiones(monto, agente);
	}

}
