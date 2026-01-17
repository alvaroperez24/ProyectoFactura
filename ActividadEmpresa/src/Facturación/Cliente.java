package Facturación;

public class Cliente extends Persona {

	//Creo los contructores que son de la superclase de Persona
	public Cliente(String nombre, String direccion, String telefono, String correo) {
		super(nombre, direccion, telefono, correo);
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
	}

	//Creo el toString para que luego pueda sacarlos por consola
	@Override
	public String toString() {
		return "Cliente:\n" + getNombre() + "\n" + getDireccion() + "\n" + getTelefono() + "\n"
				+ getCorreo();
	}
	
	
}
