package Facturación;

public class LineasFactura {
	
	//Atributos
	private Articulos articulo;
	private int cantidad = 1;
	
	//Constructores
	public LineasFactura(Articulos articulo, int cantidad) {
		super();
		this.articulo = articulo;
		this.cantidad = cantidad;
	}

	//Getters and Setters
	public Articulos getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulos articulo) {
		this.articulo = articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public float calcularImporte() {
        return articulo.getPrecio() * cantidad;
    }

	@Override
	public String toString() {
		return "id = " + articulo.getId() + "	descripción= " + articulo.getDescripcion() + "	Precio Unidad= " + articulo.getPrecio() 
		+ "	cantidad= " + cantidad + "	Importe= " + calcularImporte();
	}

}
