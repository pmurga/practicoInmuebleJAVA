package practicoInmuebleJAVA;

public class Agente extends Persona {
	
	private int nroagente;
	private int cuil;
	private double sueldobasico;
	
	
	/**
	 * @param nroagente
	 * @param cuil
	 * @param sueldobasico
	 */
	public Agente(String nombre, String apellido, int dni, int telefono, int telMovil, String email, String direccion,
			String codpostal, String localidad, String comentarios, int nroagente, int cuil, double sueldobasico) {
		super (nombre, apellido, dni, telefono, telMovil, email, direccion, codpostal, localidad, comentarios);
		this.nroagente = nroagente;
		this.cuil = cuil;
		this.sueldobasico = sueldobasico;
	}

	public Agente() {
		// TODO Auto-generated constructor stub
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
