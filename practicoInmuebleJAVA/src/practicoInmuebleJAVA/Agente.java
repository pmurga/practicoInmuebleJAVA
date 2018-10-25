package practicoInmuebleJAVA;

public class Agente extends Propietario {
	
	private int nroagente;
	private int cuil;
	private double sueldobasico;
	
	public Agente() {
		super();
	}

	public int getNroagente() {
		return nroagente;
	}

	public void setNroagente(int nroagente) {
		this.nroagente = nroagente;
	}

	public int getCuil() {
		return cuil;
	}

	public void setCuil(int cuil) {
		this.cuil = cuil;
	}

	public double getSueldobasico() {
		return sueldobasico;
	}

	public void setSueldobasico(double sueldobasico) {
		this.sueldobasico = sueldobasico;
	}
	
	
}
