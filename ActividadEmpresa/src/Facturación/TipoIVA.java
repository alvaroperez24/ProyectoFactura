package Facturación;

public enum TipoIVA {
	
	//Clase enumerada para separar los dos tipos de IVA
	NORMAL (0.21f), REDUCIDO(0.15f);
	
	private final float tasa;

	TipoIVA(float tasa) {
		this.tasa = tasa;
	}

	public float getTasa() {
		return tasa;
	}
	
	public float devuelveIva () {
		return this.tasa;
	}
}
