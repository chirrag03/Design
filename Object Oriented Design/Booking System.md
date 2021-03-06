## Booking System

### Solutioning:
 
> **Requirements:**  
> Multiples - multiple halls, shows  
> Pricing - movie and show dependent  
> Initialise -> N Multiplex -> N halls -> M seats  

<br>

> **Controller APIs:**  
> getMovieListing(Date)  			//return list of movies  
> selectMovie(movieId)				//returns list of multiplexes  
> selectMultiplex(multiplexId, movieId) 	//returns list of shows  
> selectShow(Show, multiplexId) 		//returns list of seats  
> bookSeats(Show, List<seats>)			//Returns a Ticket object  
	
> **Multiplex APIs:**  
> getShowListing(movieId) 		//returns a list of shows for this movieId  
> getSeatListing(Show)			//returns an array of seats with Type and price and availability  
> bookSeats(Show, List<seats>)		//Check again if seats available for the Show and mark the seats as booked  

<br>

> **Additional APIs:**  
getBookings(userId)  				//In Controller.....to get all bookings  
addShow(startTime, endTime, hallId, movieId)  	//In Multiplex......Adds this show to the multiplex  

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
	Map<hallId, Hall> hallIdMap;
	Map<showId, Show> showIdMap;

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

	selectShow(Show, multiplexId){
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

 
