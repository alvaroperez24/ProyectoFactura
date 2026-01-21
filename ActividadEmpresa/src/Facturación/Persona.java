package Facturación;

public abstract class Persona {
	
	//Atributos
	private String nombre = " ";
	private String direccion = " ";
	private String telefono = " ";
	private String correo = " ";
	
	//Creo constructores
	public Persona(String nombre, String direccion, String telefono, String correo) {
		//super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correo = correo;
	}

	public Persona(String nombre) {
		//super();
		this.nombre = nombre;
	}
	
	public Persona () {}

	//Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
}
