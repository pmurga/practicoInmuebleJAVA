package practicoInmuebleJAVA.operaciones;

public class Venta extends Operacion {
	private float comision_comprador;
	// gastos vendedor y comprador podrían ser final
	private float gastos_vendedor;
	private float gastos_comprador;
	
	public Venta(float monto, float comision_comprador, float comision_inmobiliaria, float gastos_vendedor, float gastos_comprador) {
		super(monto, comision_inmobiliaria);
		setComisionComprador(comision_comprador);
		setGastosComprador(gastos_comprador);
		setGastosVendedor(gastos_vendedor);
	}
	public void setComisionComprador(float comision_comprador) {
		this.comision_comprador = comision_comprador;
	}
	public void setGastosComprador(float gastos_comprador) {
		this.gastos_comprador = gastos_comprador;
	}
	public void setGastosVendedor(float gastos_vendedor) {
		this.gastos_vendedor = gastos_vendedor;
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
}