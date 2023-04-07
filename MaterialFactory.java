public class MaterialFactory {
    
  public static Material crearMaterial(String nombre, float costo) {
      return new Material(nombre, costo);
  }
  
}
