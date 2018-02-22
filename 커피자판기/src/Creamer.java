public class Creamer extends Decorator {
  Creamer(Material material) {
    super(material);
  }

  public void doing() {
    super.doing();
    doingCreamer();
  }

  private void doingCreamer() {
    System.out.println("  \t+ 프림");
    Material.creamerCount--;
  }
}
