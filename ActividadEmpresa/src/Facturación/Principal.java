package Facturación;

public class Principal {

	public static void main(String[] args) {
		
		//Creo los clientes
		Cliente cliente1 = new Cliente("Antonio", "Avenida doctor jimenez diaz 11", "623228840", "alvaroperezz24@gmail.com");
		Cliente cliente2 = new Cliente("Antonio");
		
		//Creo los articulos
		Articulo articulo1 = new Articulo("01", "Coche de juguete", 25.50f, TipoIVA.REDUCIDO, TipoDesc.CINCUENTA);
		Articulo articulo2 = new Articulo("02", "Moto de juguete ", 20.50f, TipoIVA.NORMAL, TipoDesc.DIEZ);
		Articulo articulo3 = new Articulo("03", "Portatil	", 500.50f, TipoIVA.REDUCIDO);
		Articulo articulo5 = new Articulo("04", "Chicles	", 2.50f, TipoIVA.REDUCIDO);
		
		//Creo la factura
		Factura factura1 = new Factura("01");
		
		//Añado los articulos a la factura
		factura1.anyadirArticulo(articulo5, 1);
		factura1.anyadirArticulo(articulo1, 2);
		factura1.anyadirArticulo(articulo2, 3);
		factura1.anyadirArticulo(articulo3, 1);
		
		//Muestro la factura
		factura1.mostrarFactura(cliente1);
	}

}
