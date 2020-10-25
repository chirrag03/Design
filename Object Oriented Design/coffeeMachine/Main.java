package coffeeMachine;

public class Main {
  public static void main(String[] args){
    //Declare a controller for a machine with 3 slots
    Controller controller = new Controller(3);
    controller.startMachine();
  }
}
