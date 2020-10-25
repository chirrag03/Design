package coffeeMachine;

public class Request{
  int slotNum;
  Beverage beverage;

  public Request(int slotNum, Beverage beverage) {
    this.slotNum = slotNum;
    this.beverage = beverage;
  }
}
