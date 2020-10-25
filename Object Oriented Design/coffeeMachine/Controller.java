package coffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Controller {

  private int N;
  private CoffeeMaker coffeeMaker;
  private ThreadPoolExecutor executor;
  private Map<Integer, Boolean> slotAvailability;

  public Controller(int numOfSlots){
    System.out.println("----------------------------------");
    System.out.println(String.format("Initializing Machine With %s slots", numOfSlots));

    this.N = numOfSlots;

    this.slotAvailability = new HashMap<>();
    for(int i=1;i<=numOfSlots;i++){
      this.slotAvailability.put(i, true);
    }

    this.coffeeMaker = new CoffeeMaker();

    this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(N);

    System.out.println("Initialization Complete");
    System.out.println("----------------------------------");
  }

  public void startMachine(){
    while(true){
      try {
        Request request = takeOrder();
        handleOrder(request);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private Request takeOrder() throws IOException {
    BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));

    System.out.println("Available slots : " + availableSlots());
    System.out.println("Enter slot no.: ");
    int slotNum = Integer.parseInt(inp.readLine());

    System.out.println("Available beverages : " + Arrays.toString(Beverage.values()));
    System.out.println("Enter beverage: ");
    Beverage beverage = Beverage.valueOf(inp.readLine());

    return new Request(slotNum, beverage);
  }

  public List<Integer> availableSlots(){
    List<Integer> list = new ArrayList<>();
    for(Entry<Integer, Boolean> e : slotAvailability.entrySet()){
      if(e.getValue()){
        list.add(e.getKey());
      }
    }
    return list;
  }

  public Future<Response> handleOrder(Request request){
    if(slotAvailability.getOrDefault(request.slotNum, false)){
      slotAvailability.put(request.slotNum, false);
      return executor.submit(new Task(request.slotNum, slotAvailability, coffeeMaker, request.beverage));
    }else {
      System.out.println("Already processing order on this slot " + request.slotNum);
      return new FailedFuture(new Response(request.slotNum, request.beverage, false));
    }
  }

  public void addIngredient(Ingredient ingredient, int unit) {
    coffeeMaker.addIngredient(ingredient, unit);
  }

}
