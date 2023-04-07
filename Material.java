
public class Material {
    private String nombre;
    private float costo;

    public Material(String nombre, float costo) {
        this.nombre = nombre;
        this.costo = costo;
        BaseDeDatos.agregarMaterial(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}