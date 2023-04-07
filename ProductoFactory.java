import java.util.HashMap;

public class ProductoFactory {
  public static Producto crearProducto(String nombre, HashMap<Material, Float> materialNecesario, float costoAdicional) {
      Producto producto = new Producto(nombre, materialNecesario, costoAdicional);
      return producto;
  }
}