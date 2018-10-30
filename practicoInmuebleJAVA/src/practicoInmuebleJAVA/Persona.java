package practicoInmuebleJAVA;

public class Persona {
	
	private String nombre;
    private String apellido;
    private int dni;
    private int telefono;
    private int telMovil;
    private String email;
    private String direccion;
    private String codpostal;
    private String localidad;
    private String comentarios;
	
    
		/**
	 * @param nombre
	 * @param apellido
	 * @param dni
	 * @param telefono
	 * @param telMovil
	 * @param email
	 * @param direccion
	 * @param codpostal
	 * @param localidad
	 * @param comentarios
	 */
	public Persona(String nombre, String apellido, int dni, int telefono, int telMovil, String email, String direccion,
			String codpostal, String localidad, String comentarios) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.telMovil = telMovil;
		this.email = email;
		this.direccion = direccion;
		this.codpostal = codpostal;
		this.localidad = localidad;
		this.comentarios = comentarios;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getTelMovil() {
		return telMovil;
	}
	public void setTelMovil(int telMovil) {
		this.telMovil = telMovil;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCodpostal() {
		return codpostal;
	}
	public void setCodpostal(String codpostal) {
		this.codpostal = codpostal;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
   
}