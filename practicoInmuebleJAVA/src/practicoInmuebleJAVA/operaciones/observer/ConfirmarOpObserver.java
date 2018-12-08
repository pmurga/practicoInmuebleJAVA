package practicoInmuebleJAVA.operaciones.observer;

import practicoInmuebleJAVA.Agente;
import practicoInmuebleJAVA.Inmobiliaria;

public class ConfirmarOpObserver implements Observer{
	Inmobiliaria inmobiliaria = new Inmobiliaria();
	
	public void updateComisiones(float monto, Agente agente){
		inmobiliaria.updateComisiones(monto, agente);
	};
	

}
