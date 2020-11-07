## LeaderBoard

### Solutioning:
 
**Caution:**  
This design is not complete. Read how to compute rank in time better than 0(n).  


> **Requirements:**  
> Game or competition? Codechef Competition, One Competition,  
> Many users  
> Every User will have One Rank   
> Filtering on Criteria (Rank)  
> LeaderBoard is based on Score, computing Rank  
> If Score is the same? Same Rank but shown in sorted alphabetical order  
> Pagination  


<br>

> **APIs:**  
> Add User score - add(UsedId, Score)  
> Give me rank - getRankByFilter(Filter filter)  
> List Top N ranks starting at position start - listRank(start, total_ranks)(1025,1050)  


**Let's have a look at the data classes & business logic classes:**   

```java
class User{
    String id;
    String name;
    String collegeName;
    String location;
}

class Competition{
    String id;
    String name;
    Map<userId, score>
    TreeMap<score,Set<UserIds>>

    addUserOrUpdate(userId,score) // o(1)
    {

    }

    getRankByUserId(String UserId) //O(n)
    {

    }

    listRank()
    {
    }
}

class Filter{

}

class Leaderboard{
	
    Map<competitionId,Competition> competitions;
    Leaderboard(String CompetitionId){
      // Get Competition class.
    }

    getRank(comeptitionId, userId){
        competitions.get(comeptitionId).getRankByUserId(userId);
    }

    updateRank(competitionId, userId, score){
        competitions.get(comeptitionId).addUserOrUpdate(userId);
    }

    getRankByFilter(){
        //Convert filter to UserIds
    }

}

```  


