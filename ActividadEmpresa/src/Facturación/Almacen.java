package Facturación;

import java.util.ArrayList;

public class Almacen {

	//Lista de articulos
	ArrayList<Articulos> articulos = new ArrayList<>();

	//Metodo para añadir articulos a la lista de articulos
    public void anyadirArticulo(Articulos articulo) {
        articulos.add(articulo);
    }

    //Metodo para mostrar los articulos de la lista de articulos
    public void mostrarArticulos() {
        for (Articulos articulo : articulos) {
            System.out.println(articulo);
        }
    }
}
