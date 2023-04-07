import java.util.HashMap;

public class Producto {
    private String nombre;
    private float costoTotal;
    private float precio;
    private float costoAdicional;
    private HashMap<Material, Float> materialNecesario;

    public Producto(String nombre, HashMap<Material, Float> materialNecesario, float costoAdicional) {
        this.nombre = nombre;
        this.materialNecesario = materialNecesario;
        this.costoAdicional = costoAdicional;
        this.costoTotal = calcularCostoTotal();
        this.precio = calcularPrecio();
        BaseDeDatos.agregarProducto(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getCostoAdicional() {
        return costoAdicional;
    }

    public void setCostoAdicional(float costoAdicional) {
        this.costoAdicional = costoAdicional;
    }

    public HashMap<Material, Float> getMaterialNecesario() {
        return materialNecesario;
    }

    public void setMaterialNecesario(HashMap<Material, Float> materialNecesario) {
        this.materialNecesario = materialNecesario;
        this.costoTotal = calcularCostoTotal();
        this.precio = calcularPrecio();
    }

    private float calcularCostoTotal() {
        float costoTotal = 0.0f;
        for (Material material : materialNecesario.keySet()) {
            float cantidad = materialNecesario.get(material);
            float costoMaterial = material.getCosto();
            costoTotal += costoMaterial * cantidad;
        }
        return costoTotal + costoAdicional;
    }

    private float calcularPrecio() {
        return costoTotal * BaseDeDatos.getMargenGanancia();
    }

    public float calcularPrecioVenta(float margenGanancia) {
        return costoTotal * margenGanancia;
    }

    public float calcularPrecioVenta() {
        return calcularPrecioVenta(BaseDeDatos.getMargenGanancia());
    }

    
}
