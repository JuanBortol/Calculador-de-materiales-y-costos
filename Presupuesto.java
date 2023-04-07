import java.util.ArrayList;
import java.util.HashMap;

public class Presupuesto {
    private HashMap<Producto, Integer> productos;
    private float precioTotal;
    private float subtotal;
// private String Cliente;

    public Presupuesto(HashMap<Producto, Integer> productos, String nombreCliente) {
        this.productos = productos;
      //this.nombreCliente = nombreCliente;
        this.precioTotal = calcularPrecioTotal(BaseDeDatos.getMargenGanancia());
        this.subtotal = calcularSubtotal();
    }

    public HashMap<Producto, Integer> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<Producto, Integer> productos) {
        this.productos = productos;
        this.precioTotal = calcularPrecioTotal(BaseDeDatos.getMargenGanancia());
        this.subtotal = calcularSubtotal();
    }

    public float getPrecioTotal() {
        return precioTotal;
    }

    public float getSubtotal() {
        return subtotal;
    }

  /*  public String getNombreCliente() {
        return nombreCliente;
    }
  */
  /*  public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
  */
    public float calcularPrecioTotal(float margenGanancia) {
        float precioTotal = 0.0f;
        for (Producto producto : productos.keySet()) {
            int cantidad = productos.get(producto);
            float precioProducto = producto.calcularPrecioVenta(margenGanancia); // Llamada al método calcularPrecioVenta() con el margen de ganancia recibido
            precioTotal += precioProducto * cantidad;
        }
        return precioTotal;
    }
    
    public float calcularSubtotal() {
        float subtotal = 0.0f;
        for (Producto producto : productos.keySet()) {
            int cantidad = productos.get(producto);
            float precioProducto = producto.calcularPrecioVenta();
            subtotal += precioProducto * cantidad;
        }
        return subtotal;
    }

    public ArrayList<String> obtenerNombreProductos() {
        ArrayList<String> nombresProductos = new ArrayList<>();
        for (Producto producto : productos.keySet()) {
            nombresProductos.add(producto.getNombre());
        }
        return nombresProductos;
    }

    public HashMap<Material, Float> calcularMaterialNecesario() {
        HashMap<Material, Float> materialNecesario = new HashMap<>();
        for (Producto producto : productos.keySet()) {
            int cantidad = productos.get(producto);
            HashMap<Material, Float> porcentajeMaterial = producto.getMaterialNecesario();
            for (Material material : porcentajeMaterial.keySet()) {
                float cantidadMaterial = porcentajeMaterial.get(material) * cantidad;
                if (materialNecesario.containsKey(material)) {
                    float cantidadAnterior = materialNecesario.get(material);
                    cantidadMaterial += cantidadAnterior;
                }
                materialNecesario.put(material, cantidadMaterial);
            }
        }
        return materialNecesario;
    }
}