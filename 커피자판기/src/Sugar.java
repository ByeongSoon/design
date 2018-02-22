public class Sugar extends Decorator {
  Sugar(Material material) {
    super(material);
  }

  public void doing() {
    super.doing();
    doingSugar();
  }

  private void doingSugar() {
    System.out.println("\t+ 설탕");
    Material.sugarCount--;
  }
}
