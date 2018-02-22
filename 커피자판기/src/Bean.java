public class Bean extends Material {
  @Override
  public void doing() {
    System.out.println("원두");
    Material.beanCount--;
  }
}