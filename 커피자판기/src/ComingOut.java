public class ComingOut extends Thread implements State {
  @Override
  public void onButton(final CoffeeMachine coffee) {
    System.out.println("커피가 나오는 중입니다. 조금이따 시도해 주세요.");
  }

  @Override
  public void materialInsert(final CoffeeMachine coffee) {
    System.out.println("커피가 나오는 중입니다. 조금이따 시도해 주세요.");
  }

  @Override
  public String current(final CoffeeMachine coffee) {
    return "나오는중";
  }
}
