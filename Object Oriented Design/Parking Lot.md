## Parking Lot

 ### Solutioning:
 
> **Requirements:**  
> Multiple levels  
> One entry, one exit   
> Support different slots for Truck, car, motorcycle. Can a slot be used for more than 1 type of vehicle ? NO (for now)     
> Vehicle type and RegistrationNumber   

<br>

> **APIs:**  
> Add a vehicle to a slot.   
> Remove a vehicle from the slot.    
> Bill on basis of hours and vehicle type.    

**Let's have a look at the data classes:**   

```java
class Vehicle{
     VehicleType
     regNum
}

enum VehicleType{
    TRUCK, CAR, MOTORCYCLE;
}

class Slot{
    Vehicle
    startTime
    slotNum
    floorNum
}

class Floor{
    int totalCarSlots;
    int totalTruckSlots;
    int totalMotoSlots;
    Map<VehicleType, Array<Slots>> slots;
    Map<VehicleType, PriorityQueue<Slots>> emptySlots;

    assignIfEmpty(Vehicle){
        //Remove fromEmptySlot and assign a lost.
        PriorityQueue<Slots> slots = emptySlots.get(vehicle.vehicleType);
        if(!slots.isEmpty()){
          Slot slot = slots.poll();
          return slot;
        }
        return null;
    };


    addToEmpty(Slot) {
        slot.vehicle = null;
        // slot updated
        PriorityQueue<Slots> slots = emptySlots.get(slot.vehicleType);
        slots.add(slot);
        emptySlots.put(slot.vehicleType, slots);	
    }

}

class ParkingLot{

    int floorCount;
    Array<Floor> floors;
    Map<RegistrationNumber, Slot> slotVehicleMapping;

    ParkingLot(int floors, int carSlot, int truckSlot, int motorcycleSlot){
        createFloors(..);
    }

    addVehicle(Vehicle){
        Boolean assigned = false;
        for(floor:Floors){
          Slot slot = floor.assignIfEmpty(Vehicle);
          if(slot != null) {
              assigned = true;
              slotVehicleMapping.put(vehicle.getRegistrationNumber(), slot);
          }
        }
        return assigned;
    }

    removeVehicle(registrationNumber) {
        Slot slot = slotVehicleMapping.get(vehicle.getRegistrationNumber());
        billing(Slot);
        if(slot == null) {
            // car not present
        } else {
            slotVehicleMapping.remove(registrationNumber);
            floor[slot.floorNumber].addToEmpty(slot);
        }
    }

    // can make a different class as well
    billing(Slot) {
        Time time = system_Time - slot.startTime;
        billMapping.get(slot.vehicleType) * time;
    }
}

```  
