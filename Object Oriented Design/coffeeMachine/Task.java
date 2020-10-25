package coffeeMachine;

import java.util.Map;
import java.util.concurrent.Callable;

public class Task implements Callable<Response> {

  int slotNum;
  Map<Integer, Boolean> slotAvailability;
  CoffeeMaker coffeeMaker;
  Beverage beverage;

  public Task(int slotNum, Map<Integer, Boolean> slotAvailability, CoffeeMaker coffeeMaker, Beverage beverage){
    this.slotNum = slotNum;
    this.slotAvailability = slotAvailability;
    this.coffeeMaker = coffeeMaker;
    this.beverage = beverage;
  }

  @Override
  public Response call() {
    System.out.println(String.format("Processing beverage %s for slot : %s", beverage.toString(), slotNum));
    boolean isDispensed = coffeeMaker.makeBeverage(beverage);
    slotAvailability.put(slotNum, true);
    return new Response(slotNum, beverage, isDispensed);
  }
}