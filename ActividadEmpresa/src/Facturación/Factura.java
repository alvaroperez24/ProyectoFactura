package Facturación;

import java.util.ArrayList;

public class Factura {
	
	//Atributos
	private String numero = " ";
	private String fecha = " ";
	private String fechaVenci = " ";
	private float precioBruto = 0.f;
	private float precioIVA = 0.f;
	private float totalDescuento = 0.f;
	private float precioTotal = 0.f;
	
	//Contructores uno con todo y otro solo con la clave primaria
	public Factura(String numero, String fecha, String fechaVenci, float precioBruto, float precioIVA, float descuento,
			float precioTotal) {
		//super();
		this.numero = numero;
		this.fecha = fecha;
		this.precioBruto = precioBruto;
		this.precioIVA = precioIVA;
		this.totalDescuento = descuento;
		this.precioTotal = precioTotal;
	}
	public Factura(String numero) {
		//super();
		this.numero = numero;
	}
	
	//Getters and Setters donde quitamos el set de la clave primaria para que no pueda ser modificada.
	public String getNumero() {
		return numero;
	}
	/*
	public void setNumero(String numero) {
		this.numero = numero;
	}
	*/
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public float getPrecioBruto() {
		return precioBruto;
	}
	public void setPrecioBruto(float precioBruto) {
		this.precioBruto = precioBruto;
	}
	public float getPrecioIVA() {
		return precioIVA;
	}
	public void setPrecioIVA(double precioIVA) {
		this.precioIVA = (float) precioIVA;
	}
	public float getDescuento() {
		return totalDescuento;
	}
	public void setDescuento(double descuento) {
		this.totalDescuento = (float) descuento;
	}
	public float getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = (float) precioTotal;
	}

	//Lineas de la factura
	ArrayList <LineasFactura> factura = new ArrayList<>();
	
	//Metodo para anayadir articulo a la factura
	public void anyadirArticulo (Articulo articulo, int cantidad) {
		factura.add(new LineasFactura(articulo, cantidad));
	}
	
	//Metdoo para buscar facturas
	public void buscarFactura (String buscar) {
		System.out.print("Introduzca el nombre del cliente o el número de factura que quieras buscar: ");
	}
	
	//Método para calcular el precio bruto
	public float calcularPrecioBruto() {
		float total = 0;
        for (LineasFactura linea : factura) {
            total += linea.calcularSubtotal();
        }
        return total;
    }
	
	//Método para calcular el precio de IVA
    public float calcularIVA() {
    	float total = 0;
    	for (LineasFactura linea : factura) {
            total += linea.getArticulo().getPrecio()*linea.getArticulo().getIva().devuelveIva();
        }
        return total;
    }
    
  //Método para calcular el precio de descuento
    public float calcularDesc() {
    	float total = 0;
    	for (LineasFactura linea : factura) {
    		if(linea.getArticulo().getDescuento() != null) {
    			total += linea.getArticulo().getPrecio()*linea.getArticulo().getDescuento().devuelveDesc();
    		}
        }
    	return total;
    }
    
  //Método para calcular el precio total
    public float calcularTotal() {
        return calcularPrecioBruto() + calcularIVA() - calcularDesc();
    }
	
  //Método para calcular la fecha actual
	public String calcularFecha() {
		return fecha;
	}
	
	//Método para calcular la fecha de vencimiento
	public String calcularFechaVenc() {
		return fechaVenci;
	}
	
	//Metodo para mostrar la factura final
	public void mostrarFactura(Cliente cliente) {
		System.out.println("-------");
		System.out.println("FACTURA");
		System.out.println("-------");
		
		//Muestro los datos del pedido
		System.out.println("Numero=" + numero + "\nFecha= " + calcularFecha() + "\nFecha de vencimiento= " + calcularFechaVenc());
		System.out.println("--------------------------");
		
		//Muestro los datos del cliente
		System.out.println(cliente.toString());		
		System.out.println("----------------------------------------------------------------------------");
		
		//Muestro las lineas de articulos
		for (LineasFactura linea : factura) {
			System.out.println(linea);
		}
		
		System.out.println("----------------------------------------------------------------------------");
		//Muestro los resultados
		System.out.println("SUBTOTAL:		" + calcularPrecioBruto()+"€");
		System.out.println("DESCUENTO:		" + calcularDesc()+"€");
		System.out.println("IVA:			" + calcularIVA()+"€");
		System.out.println("----------------------------------------------");
		System.out.println("TOTAL:			" + calcularTotal()+"€");
		
	}
}
