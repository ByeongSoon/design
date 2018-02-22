public class NoMaterial implements State {
  @Override
  public void onButton(final CoffeeMachine coffee) {
    System.out.println("재료가 부족합니다.");
  }

  @Override
  public void materialInsert(final CoffeeMachine coffee) {
    System.out.println("재료를 모두 채웁니다.");
  }

  @Override
  public String current(final CoffeeMachine coffee) {
    return "재료부족";
  }
}
