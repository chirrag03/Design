package coffeeMachine.test;

import coffeeMachine.Beverage;
import coffeeMachine.Controller;
import coffeeMachine.Ingredient;
import coffeeMachine.Request;
import coffeeMachine.Response;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TestController {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    dispenseAllSlots();
    dispenseAllSlotsOutOfIngredients();
    dispenseAllSlotsWithRefill();
  }

  private static void dispenseAllSlots() throws ExecutionException, InterruptedException {
    System.out.println("----------------------------------");
    System.out.println("Running TESTCASE 1");

    //Declare a controller for a machine with 3 slots
    Controller controller = new Controller(3);

    Request request1 = new Request(1, Beverage.BLACK);
    Request request2 = new Request(1, Beverage.CAPPUCCINO);
    Request request3 = new Request(2, Beverage.CAPPUCCINO);
    Request request4 = new Request(3, Beverage.AMERICANO);
    Request request5 = new Request(1, Beverage.LATTE);

    Future<Response> response1 = controller.handleOrder(request1);
    Future<Response> response2 = controller.handleOrder(request2);
    Future<Response> response3 = controller.handleOrder(request3);
    Future<Response> response4 = controller.handleOrder(request4);
    Future<Response> response5 = controller.handleOrder(request5);

    //Following beverages should be dispensed from slots: 1 BLACK, 2 CAPPUCCINO, 3 AMERICANO
    if(assertTrue(response1.get(), 1, Beverage.BLACK, true)
        && assertTrue(response2.get(), 1, Beverage.CAPPUCCINO, false)
        && assertTrue(response3.get(), 2, Beverage.CAPPUCCINO, true)
        && assertTrue(response4.get(), 3, Beverage.AMERICANO, true)
        && assertTrue(response5.get(), 1, Beverage.LATTE, false)){
      System.out.println("Test Case 1 Passed");
    }
    System.out.println("----------------------------------");
  }

  private static boolean assertTrue(Response response, int slotNum, Beverage beverage, boolean isDispensed){
    if(response.getSlotNum() == slotNum && response.getBeverage().equals(beverage) && response.isDispensed() == isDispensed){
      return true;
    }
    return false;
  }

  private static void dispenseAllSlotsOutOfIngredients() throws ExecutionException, InterruptedException {
    System.out.println("----------------------------------");
    System.out.println("Running TESTCASE 2");

    //Declare a controller for a machine with 3 slots
    Controller controller = new Controller(3);

    Request request1 = new Request(1, Beverage.BLACK);
    Request request2 = new Request(1, Beverage.CAPPUCCINO);
    Request request3 = new Request(2, Beverage.CAPPUCCINO);
    Request request4 = new Request(3, Beverage.AMERICANO);
    Request request5 = new Request(1, Beverage.LATTE);

    Future<Response> response1 = controller.handleOrder(request1);
    Future<Response> response2 = controller.handleOrder(request2);
    Future<Response> response3 = controller.handleOrder(request3);
    Future<Response> response4 = controller.handleOrder(request4);
    Future<Response> response5 = controller.handleOrder(request5);

    try {
      Thread.sleep(4000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //Following beverages should be dispensed from slots: 1 BLACK, 2 CAPPUCCINO, 3 AMERICANO
    //Only 1 out of AMERICANO or LATTE is prepared
    Request request6 = new Request(3, Beverage.AMERICANO);
    Request request7 = new Request(1, Beverage.MOCHA);
    Future<Response> response6  = controller.handleOrder(request6);
    Future<Response> response7 = controller.handleOrder(request7);

    if(assertTrue(response1.get(), 1, Beverage.BLACK, true)
        && assertTrue(response2.get(), 1, Beverage.CAPPUCCINO, false)
        && assertTrue(response3.get(), 2, Beverage.CAPPUCCINO, true)
        && assertTrue(response4.get(), 3, Beverage.AMERICANO, true)
        && assertTrue(response5.get(), 1, Beverage.LATTE, false)
        && assertTrue(response6.get(), 3, Beverage.AMERICANO, true)
        && assertTrue(response7.get(), 1, Beverage.MOCHA, false)){
      System.out.println("Test Case 2 Passed");
    }
  }

  private static void dispenseAllSlotsWithRefill() throws ExecutionException, InterruptedException {
    //Declare a controller for a machine with 3 slots
    Controller controller = new Controller(3);

    Request request1 = new Request(1, Beverage.BLACK);
    Request request2 = new Request(1, Beverage.CAPPUCCINO);
    Request request3 = new Request(2, Beverage.CAPPUCCINO);
    Request request4 = new Request(3, Beverage.AMERICANO);
    Request request5 = new Request(1, Beverage.LATTE);

    Future<Response> response1 = controller.handleOrder(request1);
    Future<Response> response2 = controller.handleOrder(request2);
    Future<Response> response3 = controller.handleOrder(request3);
    Future<Response> response4 = controller.handleOrder(request4);
    Future<Response> response5 = controller.handleOrder(request5);

    try {
      Thread.sleep(4000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //Following beverages should be dispensed from slots: 1 BLACK, 2 CAPPUCCINO, 3 AMERICANO
    //Only 1 out of AMERICANO or LATTE is prepared
    Request request6 = new Request(3, Beverage.AMERICANO);
    Request request7 = new Request(1, Beverage.MOCHA);
    Future<Response> response6  = controller.handleOrder(request6);
    Future<Response> response7 = controller.handleOrder(request7);

    try {
      Thread.sleep(4000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    controller.addIngredient(Ingredient.GROUND_COFFEE_BEANS, 5);
    Request request8 = new Request(1, Beverage.MOCHA);
    Future<Response> response8 = controller.handleOrder(request8);

    if(assertTrue(response1.get(), 1, Beverage.BLACK, true)
        && assertTrue(response2.get(), 1, Beverage.CAPPUCCINO, false)
        && assertTrue(response3.get(), 2, Beverage.CAPPUCCINO, true)
        && assertTrue(response4.get(), 3, Beverage.AMERICANO, true)
        && assertTrue(response5.get(), 1, Beverage.LATTE, false)
        && assertTrue(response6.get(), 3, Beverage.AMERICANO, true)
        && assertTrue(response7.get(), 1, Beverage.MOCHA, false)
        && assertTrue(response8.get(), 1, Beverage.MOCHA, true)){
      System.out.println("Test Case 3 Passed");
    }
  }
}
