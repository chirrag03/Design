## Elevator System

### Solutioning:
 
> **Requirements:**  
> N lifts  
> Only lift for one request     

<br>

> **APIs:**  
> Assign a lift to a request   
> Add a stop in a lift

**Let's have a look at the data classes & business logic classes:**   

```java
class Lift{
    int number;
    int maxCapacity;
    State state;
    Controller controller;       //to initiate a callback

    PriorityQueue<Integer> minHeap = nextStopsForUpDirection;     //Stops above the curr postion of lift
    PriorityQueue<Integer> maxHeap = nextStopsForDownDirection;   //Stops below the curr postion of lift
    
    addStopRequest(int floorToReach){
        //add the next stop to the required heap
        
        //initiate the move function if the lift is IDLE
    }
    
    move(){
       //If the minHeap and maxHeap both become empty then put the lift in IDLE state

       //Move in the required direction and keep updating the currentFloor and direction

       //If the lift changes direction then do a callback on the controller
    }
}

class State{
    int currentFloor;
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

    Map<Direction, List<Lift>> DirectionLiftMap;    
                                                  
    init(){
        createLifts(..)       //At 0 floor
    }

    //Assigns a lift to the given request
    assign(Request request){
        int floorToSend = null;
        
        //Handle Case 1: Anywhere in Middle to Up
        if(request.floor != 0 && request.direction==Up){    
        
           //First priority -> located down and going up + Idle elevators -> find closest  
           liftsByFloorNumbers = DirectionLiftMap.get(UP);
           liftWithsameDirection = liftsByFloorNumbers.lowerBound(request.floorNumber); // iterate on list -> find floor which is closest and below request Floor 


           liftsByFloorNumbers = DirectionLiftMap.get(IDLE);
           closestIdle = min(liftsByFloorNumbers.upperBound(request.floorNumber), liftsByFloorNumbers.lowerBound(request.floorNumber));


           if(liftsWithSameDirection == null && closesIdle == null) {

             //Second priority -> located down and going down -> find farthest
             liftsByFloorNumbers = DirectionLiftMap.get(Down);
             liftWithOppositeDirection = farthest;

             //Last -> assign any lift 

            } 
        }
        
        //Handle Case 2: Anywhere in Middle to Down
        //Handle Case 3: Anywhere in Lowest to Up
        //Handle Case 4: Anywhere in Highest to Down
        
        return lift;
    }
    
    //Updates the DirectionLiftMap...Will be called by lift when changing direction
    callback(Lift, OldDirection, NewDirection){

    }
        
}

   

```  

**Additional feature:**  
- Handle capacity and raise alarm
- Handle out of order lifts .....for this we can keep a list of such lifts in the controller


**Notes:**  

1) Middle to up (Middle means 2 to N-1) 
- First priority -> located down and going up + Idle elevators -> find closest  
- Second priority -> located down and going down -> find farthest  
- Last -> assign any lift 

2) Middle to down (Middle means 2 to N-1)  

3) Lowest to up (lowest means 0)  

4) Highest to down (highest means top floor)  

 
