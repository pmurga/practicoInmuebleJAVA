package practicoInmuebleJAVA.operaciones;

import java.util.ArrayList;
import java.util.List;

import practicoInmuebleJAVA.Agente;
import practicoInmuebleJAVA.operaciones.observer.ConfirmarOpObserver;

public abstract class Operacion {
	protected float monto;
	protected float comision_inmobiliaria;
	protected Agente agente;
	private boolean completada;
	protected List<ConfirmarOpObserver> observadores;
	
	public Operacion(float monto, float comision, Agente agente) {
		this.observadores = new ArrayList<>();
		setMonto(monto);
		setComisionInmobiliaria(comision);
		setAgenteOp(agente);
	}
	public void agregarObservador(ConfirmarOpObserver obs) {
		this.observadores.add(obs);
	}
	
	public abstract void notificarObservadores();
	
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public void setComisionInmobiliaria(float comision_inmobiliaria) {
		this.comision_inmobiliaria = comision_inmobiliaria;
	}
	public String getTipo() {
		return (this instanceof Venta ? "Venta" : "Alquiler");
	}
	public float getMonto() {
		return monto;
	}
	public abstract float getComisionInmobiliaria();
	
	public boolean isCompletada() {
		return completada;
	}
	public void setCompletada(boolean completada) {
		this.completada = completada;
	}
	public void setAgenteOp(Agente agente){
		this.agente = agente;
	}
	public Agente getAgenteOp(){
		return agente;
	}
	public abstract void CalcularMontoOperacion();
	
}