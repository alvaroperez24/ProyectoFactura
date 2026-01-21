package Facturación;

public class Articulos {
	
	//Creo los atributos
	private String id = " ";
	private String descripcion = " ";
	private float precio = 0;
	private TipoIVA iva;
	private TipoDesc descuento;
	private int cantidad;
	
	//Contructores uno con todo y otro solo con la clave primaria
	public Articulos(String id, String descripcion, float precio, TipoIVA iva, TipoDesc descuento, Integer cantidad) {
		//super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.iva = iva;
		this.descuento = descuento;
		this.cantidad = cantidad;
	}
	
	public Articulos(String id, String descripcion, float precio, TipoIVA iva) {
		//super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.iva = iva;
	}
	
	public Articulos() {
		super();
	}

	public Articulos(String id) {
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	//Creo el toString para poder sacar los datos por consola
	@Override
	public String toString() {
		return "[id=" + id + "	 descripcion=" + descripcion + "	 precio=" + precio + "	 iva=" + iva
				+ "	 descuento=" + descuento + "	  " + cantidad + " en stock" + "]";
	}	
}
