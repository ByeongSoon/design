public class Sale implements State {
  @Override
  public void onButton(final CoffeeMachine coffee) {
    System.out.println("커피가 나옵니다.");
  }

  @Override
  public void materialInsert(final CoffeeMachine coffee) {
    System.out.println("아직 재료가 충분합니다.");
  }

  @Override
  public String current(final CoffeeMachine coffee) {
    return "판매중";
  }
}
