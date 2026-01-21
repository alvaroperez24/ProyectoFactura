package Facturación;

import java.time.LocalDate;
import java.util.ArrayList;

public class Factura {
	
	//Atributos
	private static int contador = 1;
	private int numero;
	private LocalDate fecha;
	private float precioBruto = 0.f;
	private float precioIVA = 0.f;
	private float totalDescuento = 0.f;
	private float precioTotal = 0.f;
	ArrayList <LineasFactura> lineas = new ArrayList<>(); //Lineas de la factura
	
	//Contructores
	public Factura(int numero, LocalDate fecha, String fechaVenci, float precioBruto, float precioIVA, float descuento,
			float precioTotal) {
		//super();
		this.fecha = fecha;
		this.precioBruto = precioBruto;
		this.precioIVA = precioIVA;
		this.totalDescuento = descuento;
		this.precioTotal = precioTotal;
	}
	
	public Factura() {
		this.numero = contador++;
		this.fecha = LocalDate.now();
        this.lineas = new ArrayList<>();
	}
	
	//Getters and Setters donde quitamos el set de la clave primaria para que no pueda ser modificada.
	public int getNumero() {
		return numero;
	}
	/*
	public void setNumero(String numero) {
		this.numero = numero;
	}
	*/
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
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

	ArrayList <Factura> listaFacturas = new ArrayList<>(); // Lista de todas las facturas creadas
	
	//Metodo para crear facturas y añadirlas en la lista de facturas
	public Factura crearFactura() {
	    Factura f = new Factura();
	    listaFacturas.add(f);
	    return f;
	}
	
	//Metodo para anayadir articulo a la factura
	public void anayadirProducto (Articulos articulo, int cantidad) {
		lineas.add(new LineasFactura(articulo, cantidad));
	}
	
	//Método para calcular el precio bruto
	public float calcularPrecioBruto() {
		float total = 0;
        for (LineasFactura linea : lineas) {
            total += linea.calcularImporte();
        }
        return total;
    }
	
	//Método para calcular el precio de IVA
    public float calcularIVA() {
    	float total = 0;
    	for (LineasFactura linea : lineas) {
            total += linea.getArticulo().getPrecio()*linea.getCantidad()*linea.getArticulo().getIva().devuelveIva();
        }
        return total;
    }
    
  //Método para calcular el precio de descuento
    public float calcularDesc() {
    	float total = 0;
    	for (LineasFactura linea : lineas) {
    		if(linea.getArticulo().getDescuento() != null) {
    			total += linea.getArticulo().getPrecio() * linea.getCantidad() * linea.getArticulo().getDescuento().devuelveDesc();
    		}else if (linea.getArticulo().getDescuento() == null) {	
    			total += 0;
    		}
        }
    	return total;
    }
    
  //Método para calcular el precio total
    public float calcularTotal() {
        return calcularPrecioBruto() + calcularIVA() - calcularDesc();
    }
	
  //Método para calcular la fecha actual
	public LocalDate calcularFecha() {
		fecha = LocalDate.now();
		return fecha;
	}
	
	//Metodo para mostrar la factura final
	public void contruirFactura(Cliente cliente) {
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("FACTURA");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		//Muestro los datos del pedido
		System.out.println("Numero=" + this.numero + "\nFecha= " + calcularFecha());
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		//Muestro los datos del cliente
		System.out.println(cliente);
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		//Muestro las lineas de articulos
		for (LineasFactura linea : lineas) {
			System.out.println(linea);
		}
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		//Muestro los resultados
		System.out.println("SUBTOTAL:		" + calcularPrecioBruto()+"€");
		System.out.println("DESCUENTO:		" + calcularDesc()+"€");
		System.out.println("IVA:			" + calcularIVA()+"€");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("TOTAL:			" + calcularTotal()+"€");
		
	}
}
