public interface State {
  public void onButton(final CoffeeMachine coffee);

  public void materialInsert(final CoffeeMachine coffee);

  public String current(final CoffeeMachine coffee);
}
