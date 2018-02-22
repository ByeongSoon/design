import org.omg.CORBA.MARSHAL;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
  private static boolean materialCheck(final Material material) {//재료가 없는지 판단
    if (Material.beanCount == 0 || Material.sugarCount == 0 || Material.creamerCount == 0) {
      return false;
    } else {
      return true;
    }
  }

  private static void materialAdd(final Material material) {//재료를 추가해주는 메소드
    Material.beanCount = Material.maxSize;
    Material.creamerCount = Material.maxSize;
    Material.sugarCount = Material.maxSize;
  }

  private static void delay(){
    try {
      Thread.sleep(2500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("커피를 가져가세요.");
  }
  private static void materialCount(){
    System.out.print("남은 재료(");
    System.out.print(
        "원두: " + Material.beanCount +
            " 설탕: " + Material.sugarCount +
            " 프림: " + Material.creamerCount);
    System.out.println(")"+"\n");
  }

  public static void main(String[] args) {
    CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();//싱글톤으로 단 한개의 객체 생성

    Material blackCoffee = new Bean();//블랙커피
    Material sugarCoffee = new Sugar(new Bean());//설탕커피
    Material creamerCoffee = new Creamer(new Bean());//프림커피
    Material milkCoffee = new Creamer(new Sugar(new Bean()));//밀크커피

    int button = 0;
    String password;
    boolean checker;
    Scanner in = new Scanner(System.in);
    Scanner in_password = new Scanner(System.in);

    Sale saleState = new Sale();//판매중 상태의 객체
    NoMaterial nomaterial = new NoMaterial();// 재료부족
    ComingOut coming_out = new ComingOut();

    while (true) {
      checker = materialCheck(coffeeMachine.machineMaterial);
      if (checker) {
        coffeeMachine.setState(saleState);//현재 상태를 판매중으로 만듬
      } else {
        coffeeMachine.setState(nomaterial);//재료 없음으로 상태를 변경
      }
      System.out.println("---------------------------------------------------");
      System.out.println("1.블랙커피  2.설탕커피  3.프림커피 4.밀크커피  5.관리");//선택 버튼
      System.out.println("---------------------------------------------------");

      try {
        button = in.nextInt();
      } catch (InputMismatchException ime) {
        System.out.println("숫자만 입력해주새요!!");
        System.out.println("종료합니다.");
        break;
      }
      if (!checker && button != 5) {
        coffeeMachine.machineState.onButton(coffeeMachine);
        continue;
      }
      switch (button) {
        case 1:
          System.out.println("블랙 커피 누름");
          coffeeMachine.machineState.onButton(coffeeMachine);//판매중일때 뽑기 버튼을 누름
          coffeeMachine.setState(coming_out);//나오는중으로 상태변경
          coffeeMachine.setMaterial(blackCoffee);//재료를 해당 커피로 변경
          System.out.print("\n" + "재료 :");
          coffeeMachine.machineMaterial.doing();//해당 재료가 출력되도록
          materialCount();//남은 재료가 얼마나 있는지를 보여준다
          delay();//2.5초의 지연을준다.
          break;
        case 2:
          System.out.println("설탕 커피 누름");
          coffeeMachine.machineState.onButton(coffeeMachine);//판매중일때 뽑기 버튼을 누름
          coffeeMachine.setState(coming_out);//나오는중으로 상태변경
          coffeeMachine.setMaterial(sugarCoffee);
          System.out.print("\n"+"재료 :");
          coffeeMachine.machineMaterial.doing();
          materialCount();
          delay();
          break;
        case 3:
          System.out.println("프림 커피 누름");
          coffeeMachine.machineState.onButton(coffeeMachine);
          coffeeMachine.setState(coming_out);
          coffeeMachine.setMaterial(creamerCoffee);
          System.out.println();
          System.out.print("\n"+"재료 :");
          coffeeMachine.machineMaterial.doing();
          materialCount();
          delay();
          break;
        case 4:
          System.out.println("밀크 커피 누름");
          coffeeMachine.machineState.onButton(coffeeMachine);//판매중일때 뽑기 버튼을 누름
          coffeeMachine.setState(coming_out);
          coffeeMachine.setMaterial(milkCoffee);
          System.out.print("\n"+"재료 :");
          coffeeMachine.machineMaterial.doing();
          materialCount();
          delay();
          break;
        case 5:
          System.out.print("관리 비밀번호를 입력해주세요: ");
          password = in_password.nextLine();
          if (password.equals("tkfkdgo1")) {
            System.out.println("1. 재료넣기 2. 기계종료");
            button = in.nextInt();
            if (button == 2) {
              System.out.println("기계를 종료합니다.");
              System.exit(0);
            } else if (button == 1) {
              coffeeMachine.machineState.materialInsert(coffeeMachine);
              if (!checker)
                materialAdd(coffeeMachine.machineMaterial);
              break;
            }
          } else {
            System.out.println("비밀번호가 잘못되었습니다.\n");
          }
        default:
          System.out.println("잘못된 입력입니다. 다시 눌러주세요.\n");
          break;
      }
    }
  }
}
