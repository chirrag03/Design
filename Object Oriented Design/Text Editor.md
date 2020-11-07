## Text Editor

### Solutioning:
 
> **Requirements:**  
> Text editor with basic functionality of:  
> - Undo  
> - Redo  
> - Search  
> - Find And Replace  

<br>

> **APIs:**  
> performOperation(operation)  
> undo()  
> redo()  
> search(String target)  
> findAndReplace(String src, String target)  

**Let's have a look at the data classes & business logic classes:**   

```java
class Context{
    int position
    String text
}

interface Operation{
  performAction(String completeText)
  undoAction(String completeText)
}

//We can have different Operations like AddCharOperation, DeleteCharOperation, CutTextOperation, PasteTextOperation
class PasteTextOperation implements Operation{
    Context context;
    
    performAction(String completeText){
       int start = 0
       int end = completeText.length
       String updatedText = completeText.substring(start, context.position) + context.text + completeText.substring(context.position, end)
       //Returns updatedText
    }
    
    undoAction(String completeText){
       int start = 0
       int end = completeText.length
       String updatedText = completeText.substring(start, context.position) + completeText.substring(context.position + context.text.length, end)
       //Returns updatedText
    }
}

class Node<T>{
  T data
  Node<T> next
  Node<T> prev
}

class Controller{
      String completeText;
      Node<Operation> undoListHead;     
      Node<Operation> undoListTail;
      Node<Operation> redoListHead;     
      Node<Operation> redoListTail;
      
      performOperation(operation){
          operation.performAction(completeText)
          addOperationToUndoList(operation)
      }
      
      //private function
      addOperationToUndoList(operation){
          if(head == null){
            Node<Operation> toBeAdded = new Node<>(operation, null, null)
            undoListHead = toBeAdded
            undoListTail = toBeAdded
          }else{
            Node<Operation> toBeAdded = new Node<>(operation, null, tail)
            undoListTail.next = toBeAdded
            undoListTail = toBeAdded
          }
      }
      
      //private function
      addOperationToRedoList(operation){

      }
      
      undo(){
          if(undoListHead == null){
            //Undo not permitted
          }
          
          Operation operation = undoListTail.data
          operation.undoAction(completeText)
          undoListTail = undoListTail.prev
          if(undoListTail == null){
            undoListHead == null
          }else{
            undoListTail.next = null
          }
          
          addOperationToRedoList(operation)
      }
      
      redo(){
          if(redoListHead == null){
            //Redo not permitted
          }
          
          Operation operation = redoListTail.data
          operation.performAction(completeText)
          redoListTail = redoListTail.prev
          if(redoListTail == null){
            redoListHead == null
          }else{
            redoListTail.next = null
          }
          
          addOperationToUndoList(operation)
      }
      
      search(String target){
          //Search target in completeText and return all indices
      }
      
      findAndReplace(String src, String target){
          int[] indices = search(src)
          //Replace target in completeText at all indices
      }
      
}

```  


**Follow Up:**  
- Replace one by one
 

