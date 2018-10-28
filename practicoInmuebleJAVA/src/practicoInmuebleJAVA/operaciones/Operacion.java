public abstract class Operacion {
	protected float monto;
	protected float comision_inmobiliaria;
	
	public Operacion(float monto, float comision) {
		setMonto(monto);
		setComisionInmobiliaria(comision);
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
}