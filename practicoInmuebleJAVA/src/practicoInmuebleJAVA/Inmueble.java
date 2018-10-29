package practicoInmuebleJAVA;



public class Inmueble {

	private enum TipoOperacion {VENTA, ALQUILER;}; 
	private enum Estado {HABITADO_PROPIETARIO, DESHABITADO, EN_CONSTRUCCION, HABITADO_INQUILINO};
	private enum Luminosidad {ALTA, MEDIA, BAJA};
	private enum Vigilancia {VEINTICUATRO_HS, DIURNO, NOCTURNO, NO_TIENE};
	private enum EstadoConservacion {A_ESTRENAR, A_RECICLAR, IMPECABLE, BUENO, MUY_BUENO};
	private enum TipoPropiedad {ESTUDIO, LOFT, DEPARTAMENTO, PISO, DUPLEX, TRIPLEX, CHALET, CASA, LOCAL, COCHERA, OFICINA, EDIFICIO};


	private Propietario propietario;
	private Agente agente;
	
	private String calle;
	private int nro;
	private int piso;
	private String puerta;

	private TipoOperacion tipoOperacion; 
	private Estado estado;
	private Luminosidad luminosidad;
	
	private boolean exterior;
	private boolean interior;
	
	
	private Vigilancia vigilancia;
	private EstadoConservacion estadoDeConservacion;
	private TipoPropiedad tipoPropiedad;
	
///	private double mtotales; //Es la suma de metroCubiertos + metrosDescubiertos??
	private double metrosCubiertos;
	private double metrosDescubiertos;
	private int nroDormitorios;
	private int nroBanos;
	private int nroPlantas;
	private int nroAscensores;
	private String orientacion;
	private boolean pileta;
	private boolean balcon;
	private boolean patio;
	
	public Inmueble() {
		super();
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Agente getAgente() {
		return agente;
	}

	public void setAgente(Agente agente) {
		this.agente = agente;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public TipoOperacion getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(TipoOperacion tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Luminosidad getLuminosidad() {
		return luminosidad;
	}

	public void setLuminosidad(Luminosidad luminosidad) {
		this.luminosidad = luminosidad;
	}
	
	public boolean isExterior() {
		return exterior;
	}

	public void setExterior(boolean exterior) {
		this.exterior = exterior;
	}
	
	public boolean isInterior() {
		return interior;
	}

	public void setInterior(boolean interior) {
		this.interior = interior;
	}

	public double getMetrosTotales() {
		return metrosCubiertos + metrosDescubiertos;
	}

//	public void setMtotales(double mtotales) {
//		this.mtotales = mtotales;
//	}

	public double getMcubiertos() {
		return metrosCubiertos;
	}

	public void setMetrosCubiertos(double mcubiertos) {
		this.metrosCubiertos = mcubiertos;
	}

	public double getMetrosDescubiertos() {
		return metrosDescubiertos;
	}

	public void setMetrosDescubiertos(double mdescubiertos) {
		this.metrosDescubiertos = mdescubiertos;
	}

	public int getNroDormitorios() {
		return nroDormitorios;
	}

	public void setNroDormitorios(int nroDormitorios) {
		this.nroDormitorios = nroDormitorios;
	}

	public int getNroBanos() {
		return nroBanos;
	}

	public void setNroBanos(int nroBanos) {
		this.nroBanos = nroBanos;
	}

	public int getNroPlantas() {
		return nroPlantas;
	}

	public void setNroPlantas(int nroPlantas) {
		this.nroPlantas = nroPlantas;
	}

	public int getNroAscensores() {
		return nroAscensores;
	}

	public void setNroAscensores(int nroAscensores) {
		this.nroAscensores = nroAscensores;
	}

	public String getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}

	public Vigilancia getVigilancia() {
		return vigilancia;
	}

	public void setVigilancia(Vigilancia vigilancia) {
		this.vigilancia = vigilancia;
	}

	public EstadoConservacion getEstadoConservacion() {
		return estadoDeConservacion;
	}

	public void setEstadoConservacion(EstadoConservacion estConservacion) {
		this.estadoDeConservacion = estConservacion;
	}

	public boolean isPileta() {
		return pileta;
	}

	public void setPileta(boolean pileta) {
		this.pileta = pileta;
	}

	public TipoPropiedad getTipoPropiedad() {
		return tipoPropiedad;
	}

	public void setTipoPropiedad(TipoPropiedad tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}

	public boolean hasBalcon() {
		return balcon;
	}

	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}

	public boolean hasPatio() {
		return patio;
	}

	public void setPatio(boolean patio) {
		this.patio = patio;
	}
	
	
}
