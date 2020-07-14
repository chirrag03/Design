## Elevator System

### Solutioning:
 
> **Requirements:**  
> N lifts  
> Only lift for one request     

<br>

> **APIs:**  
> Assign a lift to a request   

**Let's have a look at the data classes & business logic classes:**   

```java
class Lift{
    int number;
    int maxCapacity;
    State state;

    PriorityQueue<Integer> minHeap = nextStopsForUpDirection;     //Stops above the curr postion of lift
    PriorityQueue<Integer> maxHeap = nextStopsForDownDirection;   //Stops below the curr postion of lift
}

class State{
    int currentFloor;
    TreeSet floorsToReach;
    Direction direction;
}

enum Direction{
    UP, DOWN, IDLE
}

class Request{
    int floor;
    Direction direction;
}

class Controller{

    Map<Direction, List<Lift>>DirectionByLift;    // can use TreeMap floorNumber as well
                                                  // that will stop list iteration.
    Map<Lift, State>LiftByState;

    init(){
        createLifts(..)       //At 0 floor
    }

    assign(Request request){
        int floorToSend = null;
        
        if(Request.floor != 0 && Request.direction==Up)     //Anywhere in Middle to UP
          liftsByFloorNumbers = StateByLift.get(Up);
          liftWithsameDirection = lowerBound;
          
          liftsByFloorNumbers = StateByLift.get(IDLE);
          closestIdle = min(upperBound, lowerBound);

          If (liftsWithSameDirection == null && closesIdle == null) {
          liftsByFloorNumbers = StateByLift.get(Down);
          liftWithsameDirection = upperBound;
        }
        // logic to find floor 
        // if list -> iterate on the list -> floor which closest and down.
        // if TreeMap -> lowerbound

        lift.move(this,5);
        }
        Else{
        //Down case

        liftsByFloorNumbers = StateByLift.get(Down);
        floorToSend = liftsByFloorNumbers.upperBound(request.floorNumber);
    }


    if(floorToSend==null)
    {
    liftsByFloorNumbers = StateByLift.get(IDLE);
    floorToSend = min(upperBound, lowerBound);
    }





```  

**Additional feature:**  
- Handle capacity and raise alarm

**Notes:**  

1) Middle to up (Middle means 2 to N-1) 
- First priority -> located down and going up + Idle elevators -> find closest  
- Second priority -> located down and going down -> find farthest  
- Last -> assign any lift 

2) Middle to down (Middle means 2 to N-1)  

3) Lowest to up (lowest means 0)  

4) Highest to down (highest means top floor)  

 
