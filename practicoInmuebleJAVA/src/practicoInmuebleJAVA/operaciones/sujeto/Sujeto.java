package practicoInmuebleJAVA.operaciones.sujeto;

import practicoInmuebleJAVA.operaciones.observer.Observer;

public interface Sujeto {

	public void attach(Observer obs);
	public void dettach (Observer obs);
	public void notifyObservers();
}
