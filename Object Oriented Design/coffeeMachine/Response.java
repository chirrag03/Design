package coffeeMachine;

public class Response {

  int slotNum;
  Beverage beverage;
  boolean isDispensed;

  public Response(int slotNum, Beverage beverage, boolean isDispensed) {
    this.slotNum = slotNum;
    this.beverage = beverage;
    this.isDispensed = isDispensed;
  }

  public int getSlotNum() {
    return slotNum;
  }

  public Beverage getBeverage() {
    return beverage;
  }

  public boolean isDispensed() {
    return isDispensed;
  }
}
