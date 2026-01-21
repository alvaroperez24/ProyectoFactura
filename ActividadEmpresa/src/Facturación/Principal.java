package Facturación;

import java.util.*;

public class Principal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Creo los artículos y los meto en el almacén
        Almacen almacen = new Almacen();
        almacen.anyadirArticulo(new Articulos("01", "Coche de juguete", 25.50f, TipoIVA.REDUCIDO, TipoDesc.CINCUENTA, 100));
        almacen.anyadirArticulo(new Articulos("02", "Moto de juguete", 85.50f, TipoIVA.NORMAL, TipoDesc.CINCUENTA, 150));
        almacen.anyadirArticulo(new Articulos("05", "Tostadora", 40.50f, TipoIVA.REDUCIDO, TipoDesc.CINCUENTA, 100));
        almacen.anyadirArticulo(new Articulos("03", "Pala de padel", 71.50f, TipoIVA.REDUCIDO, TipoDesc.CINCUENTA, 100));
        almacen.anyadirArticulo(new Articulos("04", "Chicles", 4.50f, TipoIVA.REDUCIDO, TipoDesc.CINCUENTA, 100));

        // Lista global de clientes
        Cliente clientes = new Cliente();

        //Hago que el programa se repita constantemente
        while (true) {

            Cliente clienteActual = null;
            String respuesta = "";

            // Selección/registro de cliente
            while (!respuesta.equals("S") && !respuesta.equals("N")) {
                System.out.println("¿Ya es cliente? (S/N): ");
                respuesta = sc.nextLine().toUpperCase();

                // Si ya es cliente se le pedira el número de telefono
                if (respuesta.equals("S")) {
                    System.out.println("Introduce tu número de teléfono:");
                    String telefono = sc.nextLine();
                    clienteActual = clientes.buscarPorTelefono(telefono);

                    if (clienteActual == null) {
                        System.out.println("No existe ese cliente. Regístrese.");
                        respuesta = ""; // Si no es correcto el telefono fuerzo a repetir
                    }

                // Si la respuesta es no le pido que se registre
                } else if (respuesta.equals("N")) {
                	System.out.println("REGISTRARSE:");
                    System.out.println("Introduce tu nombre:");
                    String nombre = sc.nextLine();
                    System.out.println("Introduce tu dirección:");
                    String direccion = sc.nextLine();
                    System.out.println("Introduce tu teléfono:");
                    String telefono = sc.nextLine();
                    System.out.println("Introduce tu correo:");
                    String correo = sc.nextLine();

                    // Creo el cliente
                    clienteActual = clientes.crearCliente(nombre, direccion, telefono, correo);

                // Si no elije S o N
                } else {
                    System.out.println("Respuesta incorrecta.");
                }
            }

            // CREO UNA NUEVA FACTURA PARA ESTE CLIENTE
            Factura factura = new Factura(); // número automático

            // Añadir productos
            String articulo = "";
            System.out.println("Añade tus productos y cuando termine presione la tecla 0 para pagar.");

            //Bucle hasta que el cliente termine de meter los productos
            while (!articulo.equals("0")) {
                almacen.mostrarArticulos(); //Muestro los articulos
                System.out.println("Selecciona el producto:");
                articulo = sc.nextLine();

                if (articulo.equals("0")) break; //Si el cliente selecciona el 0 se acaba el bucle

                boolean encontrado = false;
                for (Articulos a : almacen.articulos) {
                    if (a.getId().equals(articulo)) {
                        encontrado = true;
                        System.out.println("Selecciona la cantidad:");
                        int cantidad = sc.nextInt();
                        sc.nextLine();

                        // Si pide mas de los que hay en stock se denega sino lo añado a su lista de factura
                        if (cantidad > a.getCantidad()) {
                            System.out.println("No se pudo añadir debido a exceso de cantidad. Nos quedan " + a.getCantidad());
                        } else {
                            factura.anayadirProducto(a, cantidad);
                            a.setCantidad(a.getCantidad() - cantidad);
                            System.out.println("Añadido a tu compra.");
                        }
                        break;
                    }
                }
                //Si no introduce un id que exista en el almacen se lo indico
                if (!encontrado) {
                    System.out.println("Producto no encontrado.");
                }
            }

            // Muestro la factura
            factura.contruirFactura(clienteActual); // ahora mostrará el número correcto

            limpiarPantalla();
        }
    }
    
    //Metodo para simular un salto de pagina para que desaparezca el anterior pedido
    public static void limpiarPantalla() {
    	System.out.println("\nPresiona ENTER para terminar...");
        sc.nextLine();
        System.out.println("\n".repeat(50));
    }
}
