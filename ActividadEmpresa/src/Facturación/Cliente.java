package Facturación;

import java.util.ArrayList;

public class Cliente extends Persona {

	//Lista de clientes de la empresa
    ArrayList<Cliente> listaClientes = new ArrayList<>();

    //Constructores
    public Cliente(String nombre, String direccion, String telefono, String correo) {
        super(nombre, direccion, telefono, correo);
    }

    public Cliente() {}

    //Metodo para buscar si el telefono introducido coincide con el telefono de un cliente de la lista
    public Cliente buscarPorTelefono(String telefono) {
        for (Cliente c : listaClientes) {
            if (c.getTelefono().equals(telefono)) {
                return c;
            }
        }
        return null;
    }

    //Metodo para crear un cliente
    public Cliente crearCliente(String nombre, String direccion, String telefono, String correo) {
        Cliente nuevo = new Cliente(nombre, direccion, telefono, correo);
        listaClientes.add(nuevo);
        return nuevo;
    }

    @Override
    public String toString() {
        return "Cliente:\n" + getNombre() + "\n" + getDireccion() + "\n" +
               getTelefono() + "\n" + getCorreo();
    }
}

