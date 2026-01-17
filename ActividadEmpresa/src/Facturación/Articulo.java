package Facturación;

public class Articulo {
	
	private String id = " ";
	private String descripcion = " ";
	private float precio = 0;
	private TipoIVA iva;
	private TipoDesc descuento;
	
	//Contructores uno con todo y otro solo con la clave primaria
	public Articulo(String id, String descripcion, float precio, TipoIVA iva, TipoDesc descuento) {
		//super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.iva = iva;
		this.descuento = descuento;
	}
	
	public Articulo(String id, String descripcion, float precio, TipoIVA iva) {
		//super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.iva = iva;
	}
	
	public Articulo(String id) {
		//super();
		this.id = id;
	}
	
	//Getters and Setters donde quitamos el set de la clave primaria para que no pueda ser modificada.
	public String getId() {
		return id;
	}
	/*
	public void setId(String id) {
		this.id = id;
	}
	*/
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio =  precio;
	}
	public TipoIVA getIva() {
		return iva;
	}
	public void setIva(TipoIVA iva) {
		this.iva = iva;
	}
	public TipoDesc getDescuento() {
		return descuento;
	}
	public void setDescuento(TipoDesc descuento) {
		this.descuento = descuento;
	}

	//Creo el toString para poder sacar los datos por consola
	@Override
	public String toString() {
		return "descripcion= " + descripcion + " 	precio= " + precio + " 	iva= " + iva.devuelveIva();
	}
	
	
}
