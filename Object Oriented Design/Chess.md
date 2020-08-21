## Chess

### Solutioning:
 
> **Requirements:**  
> 2 player chess game

<br>

> **APIs:**  
> To start a game (initialise board, players, turn)     
> Move (player moving a piece)    
> Display current state   

**Let's have a look at the data classes & business logic classes:**   

```java
class Coord{
    int x
    int y
}

class Piece{
    Color color
    Type type
    PieceBehaviour pieceBehaviour
    
    isvalidMove(coordStart, coordEnd){
       pieceBehaviour.isvalidMove(coordStart, coordEnd)
    }
    
    setPieceBehaviour(PieceBehaviour b){
       this.pieceBehaviour = b
    }
}

class PawnBehaviour implements PieceBehaviour{
    
    int[] deltaX = {0}
    int[] deltaY = {1}
    
    isvalidMove(coordStart, coordEnd){
        //Check if it is possible to reach coordEnd just by adding deltaX[i] and deltaY[i] to coordStart
    }
}

class KnightBehaviour implements PieceBehaviour{
    
    int[] deltaX = {-2, -1, 1, 2, 2, 1, -1, -2}
    int[] deltaY = {1, 2, 2, 1, -1, -2, -2, -1}
    
    isvalidMove(coordStart, coordEnd){
        //Check if it is possible to reach coordEnd just by adding deltaX[i] and deltaY[i] to coordStart
    }
}


class Player{
    String name
    Color color
}

enum Color{ BLACK, WHITE}

enum Type{PAWN, BISHOP, KING, QUEEN, ROOK, KNIGHT}

class Board{
    Piece[][] pieces;
    Map<Color,List<Pieces>> allPieces;
    
    public Board(){
        pieces = new Piece[8][8];
        //Piece initialise
    }

    move(player.color, coordStart, coordEnd){
        //Validation
        Piece srcPiece = pieces[startX][startY]
        Piece destPiece = pieces[endX][endY]
        
        if(srcPiece == null){
            //throw exception
        }

        if(srcPiece.color != player.color){
          //throw exception
        }
        
        if(destPiece != null && destPiece.color == player.color){
          //throw exception
        }

        if(srcPiece.isValidMove(coordStart, coordEnd)){
          //throw exception
        }

        pieces[startX][startY] = null
        pieces[endX][endY] = srcPiece
    }

    display()
}

class GameController{
      Board board;
      Player player1;	//White
      Player player2;	//Black
      turn 	

      startGame(){
          //Initialize board
          board = Board();

          //Initialise Player 1 and 2

          turn = 1
      }

      move(player, coordStart, coordEnd){
      
          //Validation that move has been played by correct player
          if((turn == 1 && player != player1) || (turn == 2 && player != player2)){
            //Throw Exception
          }
          
          //Validation that start and end coord is within board
          if(!isValidCoord(coordStart) || !isValidCoord(coordEnd)){
            //Throw Exception
          }
          
          board.move(player.color, coordStart, coordEnd)
    }
}

```  

**Notes:**  
Making use of Strategy Pattern here to define behaviour of a piece. This pattern allows changing the behaviour of a piece at runtime which could be a use case when:  
If the Pawn reaches the opposite side of the chessboard, it has the unique ability to promote to another chess piece.  
The pawn can become a Queen, Bishop, Rook, or Knight. There are no restrictions to how many pieces of a given type you can have via promotion.

**Follow Up:**  
- How to reincarnate a piece…...keep a Map<Color,List<Pieces>> allPieces;
- Undo option…..Use a stack to store the moves  
 
```java
class Move{
   Player player
   Piece srcPiece
   Coord coordStart
   Coord coordEnd
   Piece destPiece   //This is captured piece or the opponent's piece replaced by the src piece
}
```
