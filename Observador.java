import java.util.HashMap;

public interface Observador {
  void actualizar(float precioTotal, HashMap<Material, Float> materialesRequeridos);
}
