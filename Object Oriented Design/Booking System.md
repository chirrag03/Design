## Booking System

### Solutioning:
 
> **Requirements:**  
> Multiples - multiple halls, shows  
> Pricing - movie and show dependent  
> Initialise -> N Multiplex -> N halls -> M seats  

<br>

> **APIs:**  
> addShow(int startTime, int endTime, Hall, Show)  
> getShowListing(Location, Date, MovieName)  
> getSeatListing(Show)			//Show prices also  
> bookTickets(show, list<seats>)  
> getBookings(userId)  


**Let's have a look at the data classes & business logic classes:**   

```java
class Movie{
	int id
	int name
	String meta
}

class Seat{
	int id
	int hallId
	int price					//On basis of gold, silver
	int Type
	Status
}

enum Type{
	GOLD, PLATINUM, SILVER
}

class Show{
	int id
	int startTime
  int endTime
	int movieId
	int hallId
	Boolean[][] availableSeats			
	int priceMultiplicationFactor		//On basis of movie or time (morning or evening)
}
class Hall{
	int id
	int multiplexId
	Seats[][] seats
}

class Ticket{
	int id
	int userId
	int multiplexId
	int showId
	List<seats>
	int price
	int timestamp
}

class Multiplex{
  int id
  String name
  String address
	Map<hallId, Hall>
	Map<showId, Show>

	getShowListing(movieId){
    //returns a list of shows for this movieId
  }

  getSeatListing(Show){
    //Show -> hallId -> Hall -> Seats
    //Use Show -> availableSeats to filter available seats
    //update prices of seats on basis of show multiplication factor
    //returns an array of seats with Type and price and availability
  }

  bookSeats(Show, List<seats>){
    //Check again if seats available for the Show
    //mark the seats as booked
  }
}

class Controller{
	Map<multiplexId, Multiplex> multiplexMap
	Map<movie, list<multiplexId>> movieMultiplexMapping

	getMovieListing(Date){
     //return list of movies
  }

  selectMovie(movieId){
    //returns list of multiplexes
  }

  selectMultiplex(multiplexId, movieId){
    //Fetch the Multiplex from multiplexMap
    multiplex.getShowListing(movieId)
  }

  select show(Show, multiplexId){
    multiplex.getSeatListing(Show)
  }

  bookSeats(Show, List<seats>){
    multiplex.bookSeats(Show, List<seats>)
    //Returns a Ticket object
  }

}

```  

**Follow Up:**  
- Concurrency issue when 2 people are booking the same seat.  
Can be resolved using Optimistic/Pessimistic Locking. Pessimistic Locking is more suitable for transactional processing. Window based.

 
