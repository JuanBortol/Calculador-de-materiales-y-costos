import java.util.ArrayList;

public class ListaDePrecios {
    private ArrayList<Producto> productos;

    public ListaDePrecios() {
        productos = new ArrayList<Producto>();
    }

    public void actualizarListaDePrecios() {
        ArrayList<Producto> nuevosProductos = BaseDeDatos.getProductos();
        productos.clear();
        productos.addAll(nuevosProductos);
    }

    public ArrayList<String> obtenerListaDePrecios() {
        ArrayList<String> listaPrecios = new ArrayList<String>();
        for (Producto producto : productos) {
            float precioVenta = producto.calcularPrecioVenta();
            String nombreProducto = producto.getNombre();
            listaPrecios.add(nombreProducto + " - " + precioVenta);
        }
        return listaPrecios;
    }
}