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
    isvalidMove(coordStart, coordEnd){

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
        if(pieces[startX][startY] == null){
            //throw exception
        }

        Piece srcPiece = pieces[startX][startY]
        Piece destPiece = pieces[endX][endY]

        if(srcPiece.color != player.color && destPiece.color == player.color){
          //throw exception
        }

        if(srcPiece.isValidMove(startX, startY, endX, endY)){
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

      move(player, startX, startY, endX, endY){
          //Validation that move has been played by correct player
          if(turn == 1 && player == player1 || turn == 2 && player == player2){
            board.move(player.color, coordStart, coordEnd)
          }else{
            //Throw Exception
          }
    }
}


```  
