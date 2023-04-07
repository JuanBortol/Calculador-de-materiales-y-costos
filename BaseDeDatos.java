import java.util.ArrayList;

public class BaseDeDatos {
    private static ArrayList<Material> materiales = new ArrayList<>();
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static float margenGanancia = 1.2f;

    public static void agregarMaterial(Material material) {
        materiales.add(material);
    }

    public static ArrayList<Material> getMateriales() {
        return materiales;
    }

    public static void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    public static float getMargenGanancia() {
        return margenGanancia;
    }

    public static void setMargenGanancia(float margenGanancia) {
        BaseDeDatos.margenGanancia = margenGanancia;
    }
}

