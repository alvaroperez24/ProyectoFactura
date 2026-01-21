package Facturación;

public enum TipoDesc {
	DIEZ (0.10f), VEINTE (0.20f), TREINTA (0.30f), CINCUENTA (0.50f);
	
	private final float descuento;
	
	TipoDesc(float descuento) {
		this.descuento = descuento;
	}

	public float getDescuento() {
		return descuento;
	}
	
	//Metodo para sacar el descuento con numeros
	public float devuelveDesc () {
		return this.descuento;
	}
	
}
