package practicoInmuebleJAVA.operaciones;

import practicoInmuebleJAVA.Agente;
import practicoInmuebleJAVA.operaciones.observer.ConfirmarOpObserver;
import practicoInmuebleJAVA.operaciones.sujeto.ConfirmarOpSujeto;

public abstract class Operacion {
	protected float monto;
	protected float comision_inmobiliaria;
	protected Agente agente;
	private boolean completada;
	ConfirmarOpSujeto monitor = new ConfirmarOpSujeto(monto, agente);
	
	public Operacion(float monto, float comision, Agente agente) {
		setMonto(monto);
		setComisionInmobiliaria(comision);
		setAgenteOp(agente);
		monitor.attach(new ConfirmarOpObserver());
	}
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