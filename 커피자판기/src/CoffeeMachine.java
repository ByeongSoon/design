public class CoffeeMachine {
  public State machineState;
  public Material machineMaterial;

  public void setState(final State state) {//상태를 변경할 때
    this.machineState = state;
    System.out.println("\n"+"현재 상태: " + machineState.current(this));
  }

  public void setMaterial(final Material machine_material) {
    this.machineMaterial = machine_material;
  }

  private CoffeeMachine() {
    System.out.println("wisoft 커피자판기 입니다.");
  }

  public static CoffeeMachine getInstance() {
    return LazyHolder.INSTANCE;
  }

  private static class LazyHolder {
    private static final CoffeeMachine INSTANCE = new CoffeeMachine();
  }
}
