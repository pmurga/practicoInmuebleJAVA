package practicoInmuebleJAVA;

import practicoInmuebleJAVA.operaciones.*;

public class Inmueble {
	
	
	//NO_DEFINIDO permite inicializar los enums con un valor default para que no sean null en caso de
	//no estar seteados. De esta forma al realizar una búsqueda de propiedades todos los inmuebles
	//no definidos se toman como un "wildcard"
	private enum Estado {HABITADO_PROPIETARIO, DESHABITADO, EN_CONSTRUCCION, HABITADO_INQUILINO, NO_DEFINIDO};
	private enum Luminosidad {ALTA, MEDIA, BAJA, NO_DEFINIDO};
	private enum Vigilancia {VEINTICUATRO_HS, DIURNO, NOCTURNO, NO_TIENE, NO_DEFINIDO};
	private enum EstadoConservacion {A_ESTRENAR, A_RECICLAR, IMPECABLE, BUENO, MUY_BUENO, NO_DEFINIDO};
	private enum TipoPropiedad {ESTUDIO, LOFT, DEPARTAMENTO, PISO, DUPLEX, TRIPLEX, CHALET, CASA, LOCAL, COCHERA, OFICINA, EDIFICIO, NO_DEFINIDO};

	private Propietario propietario;
	private Agente agente;
	
	private String calle;
	private int nro;
	private int piso;
	private String puerta;


	private Operacion op; 	// Tipo de la Operacion --> se maneja con clase Operacion
	private Estado estado;
	private Luminosidad luminosidad;
	
	private boolean exterior;
	private boolean interior;
	
	
	private Vigilancia vigilancia;
	private EstadoConservacion estadoDeConservacion;
	private TipoPropiedad tipoPropiedad;
	
//	private double metrosTotales; //Es la suma de metroCubiertos + metrosDescubiertos??
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
	
	public Inmueble(){};
	
	public Inmueble(Propietario propietario, Agente agente,  String calle,Integer  numero , String tipoPropiedad) {
		
		this.propietario = propietario;
		this.agente = agente;
		this.calle = calle;
		this.nro = numero;
		this.piso = 0 ; // PB
		setTipoPropiedad(tipoPropiedad);
		setCriteriosDefault();
	};
	
	public Inmueble(Propietario propietario, Agente agente, String calle,int numero, int piso, String puerta, String tipoPropiedad ) {
		
		this.propietario = propietario;
		this.agente = agente;
		this.calle = calle;
		this.nro = numero;
		this.piso = piso;
		this.puerta = puerta;
		setTipoPropiedad(tipoPropiedad);
		setCriteriosDefault();
	};

	
	//inicializar criterios en su valor default para ser tomados por la búsqueda como un wildcard
	private void setCriteriosDefault() {
		this.estado = Estado.NO_DEFINIDO;
		this.luminosidad = Luminosidad.NO_DEFINIDO;
		this.vigilancia = Vigilancia.NO_DEFINIDO;
		this.estadoDeConservacion = EstadoConservacion.NO_DEFINIDO;
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

	public Operacion getOp() {
		return op;
	}
	
	public void setOp(Operacion operacion){
		this.op = operacion;
	}

	public String getEstado() {

		if (estado == Estado.NO_DEFINIDO) {
			return "El tipo de estado no está definido";
		}
		
		return estado.name();
		
	}

	public void setEstado(String estado) {//HABITADO_PROPIETARIO, DESHABITADO, EN_CONSTRUCCION, HABITADO_INQUILINO, NO_DEFINIDO
		
		if (estado == "HABITADO_PROPIETARIO"){
			this.estado = Estado.HABITADO_PROPIETARIO;
		}
		else if (estado == "DESHABITADO"){
			this.estado = Estado.DESHABITADO;
		}
		else if (estado == "EN_CONSTRUCCION"){
			this.estado = Estado.EN_CONSTRUCCION;
		}
		else if (estado == "HABITADO_INQUILINO"){
			this.estado = Estado.HABITADO_INQUILINO;
		}
		//el tipo de estado que se ingresó no es válido y por lo tanto no está definido
		else {
			this.estado = Estado.NO_DEFINIDO;
		}
		
	}

	public String getLuminosidad() {
		
		if (luminosidad == Luminosidad.NO_DEFINIDO) {
			return "El tipo de luminosidad no está definido";
		}
		
		return luminosidad.name();
	}

	public void setLuminosidad(String luminosidad) {//ALTA, MEDIA, BAJA, NO_DEFINIDO
		
		if (luminosidad == "ALTA"){
			this.luminosidad = Luminosidad.ALTA;
		}
		else if (luminosidad == "MEDIA"){
			this.luminosidad = Luminosidad.MEDIA;
		}
		else if (luminosidad == "BAJA"){
			this.luminosidad = Luminosidad.BAJA;
		}
		//el tipo de luminosidad que se ingresó no es válido y por lo tanto no está definido
		else {
			this.luminosidad = Luminosidad.NO_DEFINIDO;
		}
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
	

	public String getVigilancia() {
		
		if (vigilancia == Vigilancia.NO_DEFINIDO) {
			return "El tipo de vigilancia no está definido";
		}
		
		return vigilancia.name();
		
	}

	public void setVigilancia(String vigilancia) {//VEINTICUATRO_HS, DIURNO, NOCTURNO, NO_TIENE, NO_DEFINIDO
		
		if (vigilancia == "VEINTICUATRO_HS"){
			this.vigilancia = Vigilancia.VEINTICUATRO_HS;
		}
		else if (vigilancia == "DIURNO"){
			this.vigilancia = Vigilancia.DIURNO;
		}
		else if (vigilancia == "NOCTURNO"){
			this.vigilancia = Vigilancia.NOCTURNO;
		}
		else if (vigilancia == "NO_TIENE"){
			this.vigilancia = Vigilancia.NO_TIENE;
		}
		//el tipo de vigilancia que se ingresó no es válida y por lo tanto no está definida
		else {
			this.vigilancia = Vigilancia.NO_DEFINIDO;
		}
		
	}

	public String getEstadoConservacion() {
		
		if (estadoDeConservacion == EstadoConservacion.NO_DEFINIDO) {
			return "El tipo de estado de conservacion no está definido";
		}
		
		return estadoDeConservacion.name();
		
	}

	public void setEstadoConservacion(String estConservacion) {//A_ESTRENAR, A_RECICLAR, IMPECABLE, BUENO, MUY_BUENO, NO_DEFINIDO
	
		if (estConservacion == "A_ESTRENAR"){
			this.estadoDeConservacion = EstadoConservacion.A_ESTRENAR;
		}
		else if (estConservacion == "A_RECICLAR"){
			this.estadoDeConservacion = EstadoConservacion.A_RECICLAR;
		}
		else if (estConservacion == "IMPECABLE"){
			this.estadoDeConservacion = EstadoConservacion.IMPECABLE;
		}
		else if (estConservacion == "BUENO"){
			this.estadoDeConservacion = EstadoConservacion.BUENO;
		}
		else if (estConservacion == "MUY_BUENO"){
			this.estadoDeConservacion = EstadoConservacion.MUY_BUENO;
		}
		//el tipo de estado de conservación que se ingresó no es válido y por lo tanto no está definido
		else {
			this.estadoDeConservacion = EstadoConservacion.NO_DEFINIDO;
		}
		
	}
	
	public String getTipoPropiedad() {
		
		if (tipoPropiedad == TipoPropiedad.NO_DEFINIDO) {
			return "El tipo de propiedad no está definido";
		}
		
		return tipoPropiedad.name();
	}

	public void setTipoPropiedad(String tipoPropiedad) {
		
		if (tipoPropiedad == "ESTUDIO"){
				this.tipoPropiedad = TipoPropiedad.ESTUDIO;
		}
		else if (tipoPropiedad == "LOFT"){
			this.tipoPropiedad = TipoPropiedad.LOFT;
		}
		else if (tipoPropiedad == "DEPARTAMENTO"){
			this.tipoPropiedad = TipoPropiedad.DEPARTAMENTO;
		}
		else if (tipoPropiedad == "PISO"){
			this.tipoPropiedad = TipoPropiedad.PISO;
		}
		else if (tipoPropiedad == "DUPLEX"){
			this.tipoPropiedad = TipoPropiedad.DUPLEX;
		}		
		else if (tipoPropiedad == "TRIPLEX"){
			this.tipoPropiedad = TipoPropiedad.TRIPLEX;
		}
		else if (tipoPropiedad == "CHALET"){
			this.tipoPropiedad = TipoPropiedad.CHALET;
		}		
		else if (tipoPropiedad == "CASA"){
			this.tipoPropiedad = TipoPropiedad.CASA;
		}
		else if (tipoPropiedad == "LOCAL"){
			this.tipoPropiedad = TipoPropiedad.LOCAL;
		}
		else if (tipoPropiedad == "COCHERA"){
			this.tipoPropiedad = TipoPropiedad.COCHERA;
		}		
		else if (tipoPropiedad == "OFICINA"){
			this.tipoPropiedad = TipoPropiedad.OFICINA;
		}
		else if (tipoPropiedad == "EDIFICIO"){
			this.tipoPropiedad = TipoPropiedad.EDIFICIO;
		}
		//el tipo de propiedad que se ingresó no es válida y por lo tanto no está definida
		else {
			this.tipoPropiedad = TipoPropiedad.NO_DEFINIDO;
		}
		
	}
	

	public double getMetrosTotales() {
		return metrosCubiertos + metrosDescubiertos;
	}

//	public void setMetrosTotales(double mTotales) {
//		this.metrosTotales = mTotales;
//	}

	
	public double getMetrosCubiertos() {
		return metrosCubiertos;
	}

	public void setMetrosCubiertos(double mcubiertos) {
		this.metrosCubiertos = mcubiertos;
	}

	public double getMetrosDescubiertos() {
		return metrosDescubiertos;
	}

	public void setMetrosDescubiertos(double mDescubiertos) {
		this.metrosDescubiertos = mDescubiertos;
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

	public boolean isPileta() {
		return pileta;
	}

	public void setPileta(boolean pileta) {
		this.pileta = pileta;
	}


	public boolean isBalcon() {
		return balcon;
	}

	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}

	public boolean isPatio() {
		return patio;
	}

	public void setPatio(boolean patio) {
		this.patio = patio;
	}
	
	public String getNameTipoPropiedad() {
		return this.tipoPropiedad.name();
	}
	public String getNameLuminosidad() {
		return this.luminosidad.name();
	}
	public String getNameVigilancia() {
		return this.vigilancia.name();
	}
	public String getNameEstadoConservacion() {
		return this.estadoDeConservacion.name();
	}
	public String getNameEstado() {
		return this.estado.name();
	}
	
	public void vender(float precio, float comision_comprador , float comision_inmobiliaria, Agente agente) {
		
		this.op = new Venta(precio , comision_comprador , comision_inmobiliaria, agente);
		
	}
	
	public void alquilar(float alq_mensual, float comision_inmobiliaria, boolean es_anual , float porc_ajuste , int meses_adelanto,  int meses_duracion) {
		
		this.op = new Alquiler(alq_mensual , comision_inmobiliaria , es_anual, porc_ajuste, meses_adelanto, meses_duracion);
		
	}
	
	public String getOPDisponible() {
		
		if (this.op instanceof Alquiler) {
			return "Alquiler";
		}
		if (this.op instanceof Venta) {
			return "Venta";
		}
		return "Una Operación aún no ha sido seteada para este inmueble";
		
	}
	
	
}
