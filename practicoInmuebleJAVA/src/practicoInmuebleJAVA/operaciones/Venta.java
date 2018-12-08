package practicoInmuebleJAVA.operaciones;

import practicoInmuebleJAVA.Agente;

public class Venta extends Operacion {
	private float comision_comprador;
	private final float gastos_vendedor = 3.3f;
	private final float gastos_comprador = 4.8f;
	
	
	public Venta(float monto, float comision_comprador, float comision_inmobiliaria, Agente agente) {
		super(monto, comision_inmobiliaria, agente);
		setComisionComprador(comision_comprador);
	}
	public void setComisionComprador(float comision_comprador) {
		this.comision_comprador = comision_comprador;
	}
	public float getComisionComprador() {
		// CONTROLAR COMISIONES - 3%, 3,5% o 4%
		return (monto / 100) * comision_comprador;
	}
	public float getGastosVendedor() {
		return (monto / 100) * gastos_vendedor;
	}
	public float getGastosComprador() {
		return (monto / 100) * gastos_comprador;
	}
	public float getComisionInmobiliaria() {
		// CONTROLAR COMISIONES - solo puede ser 1%, 1,5% o 2%
		return (monto / 100) * comision_inmobiliaria;
	}
	
	
	public void CalcularMontoOperacion() {
	    float montovendedor;
	    float montocomprador ;
	    float montoinmo;
	    
	        montoinmo = getComisionComprador() + getComisionInmobiliaria();
	        montovendedor = monto - getGastosVendedor() - getComisionInmobiliaria();
	        montocomprador = monto + getGastosComprador() + getComisionComprador();
	        	        
	        System.out.printf("\nEl importe a cobrar por la Inmobiliaria es: $" + montoinmo );
	        System.out.printf("\nEl importe a recibir por el Vendedor es: $" + montovendedor );
	        System.out.printf("\nEl importe a pagar por el Comprador es: $" + montocomprador );
	}
	
	@Override
	public void setCompletada(boolean completada) {
		super.setCompletada(completada);
		
		if (completada) {
			this.notificarObservadores();
			System.out.println("\n *** Transacción OK ***"); 
		
		}
	}
}