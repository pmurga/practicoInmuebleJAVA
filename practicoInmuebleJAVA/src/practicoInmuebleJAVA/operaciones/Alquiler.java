package practicoInmuebleJAVA.operaciones;

import practicoInmuebleJAVA.Agente;
import practicoInmuebleJAVA.operaciones.sujeto.ConfirmarOpSujeto;

public class Alquiler extends Operacion {
	private boolean periodicidad_ajuste;
	private float porcentaje_ajuste;
	private int meses_adelanto;
	private int meses_duracion;
	
	
	public Alquiler(float monto, float comision_inmobiliaria, boolean periodicidad_ajuste, float porcentaje_ajuste, int meses_adelanto, int meses_duracion, Agente agente) {
		super(monto, comision_inmobiliaria, agente);
		setPeriodicidadAjuste(periodicidad_ajuste);
		setPorcentajeAjuste(porcentaje_ajuste);
		setMesesAdelanto(meses_adelanto);
		setMesesDuracion(meses_duracion);
	}
	public void setPeriodicidadAjuste(boolean periodicidad_ajuste) {
		this.periodicidad_ajuste = periodicidad_ajuste;
	}
	public void setPorcentajeAjuste(float porcentaje_ajuste) {
		this.porcentaje_ajuste = porcentaje_ajuste;
	}
	public void setMesesAdelanto(int meses_adelanto) {
		this.setMeses_adelanto(meses_adelanto);
	}
	public void setMesesDuracion(int meses_duracion) {
		this.meses_duracion = meses_duracion;
	}
	public float getMontoTotal() {
		int periodicidad = (periodicidad_ajuste ? 6 : 12);
		int cant_ajustes = (meses_duracion / periodicidad) - 1;
		float monto_actual = monto;
		float acum_monto = monto * periodicidad;
		for(int i = 0; i < cant_ajustes; i++) {
			monto_actual = monto_actual + ((monto_actual / 100) * porcentaje_ajuste);
			acum_monto += monto_actual * periodicidad;
		}
		return acum_monto;
	}
	public float getComisionInmobiliaria() {
		float montoTotal = getMontoTotal();
		// CONTROLAR LAS COMISIONES - solo puede ser 3%, 3,5%, 4% y 4,5%
		return (montoTotal / 100) * comision_inmobiliaria;
	}
	public int getMeses_adelanto() {
		return meses_adelanto;
	}
	public void setMeses_adelanto(int meses_adelanto) {
		this.meses_adelanto = meses_adelanto;
	}
	
	public void CalcularMontoOperacion() {
		float montoinqui;
	    float montoprop ;
	    float montoinmo;
	    
	        montoinmo = getComisionInmobiliaria();
	        montoinqui = getMontoTotal();
	        montoprop = montoinqui - montoinmo;
	        
	        System.out.printf("\nEl importe a cobrar por la Inmobiliaria es: $" + montoinmo);
	        System.out.printf("\nEl importe a recibir por el Propietario es: $" + montoprop);
	        System.out.printf("\nEl importe a pagar por el Inquilino es: $" + montoinqui);
	}
	
	@Override
	public void setCompletada(boolean completada) {
		super.setCompletada(completada);
		
		if (completada) { 
			
			ConfirmarOpSujeto eventoOp = new ConfirmarOpSujeto(monto, agente);
			eventoOp.notifyObservers();
			System.out.println("\n *** Transacción OK ***"); 
		
		}
	}
}