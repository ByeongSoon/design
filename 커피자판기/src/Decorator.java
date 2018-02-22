
public class Decorator extends Material {
  private Material decoratorMaterial;

  Decorator(final Material material) {
    this.decoratorMaterial = material;
  }

  @Override
  public void doing() {
    decoratorMaterial.doing();
  }
}
