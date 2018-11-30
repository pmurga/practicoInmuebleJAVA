package practicoInmuebleJAVA.operaciones.sujeto;

import practicoInmuebleJAVA.operaciones.observer.ConfirmarOpObserver;

public interface Sujeto {

	public void attach(ConfirmarOpObserver obs);
	public void dettach (ConfirmarOpObserver obs);
	public void notifyObservers();
}
