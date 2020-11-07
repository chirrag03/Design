## LRU Cache 

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

* get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
* put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.
Support both operations in **O(1)** time complexity?


### Example :
```
LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
```



```java
class Node{
    int key;
    int value;
    Node prev;
    Node next;
}
class LRUCache {

    int capacity = 0;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            remove(curr);
            setHead(curr);
            return curr.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            curr.value = value;
            remove(curr);
            setHead(curr);
        }else{
            if(map.size() >= capacity){
                map.remove(tail.key);
                remove(tail);
            }
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            
            setHead(newNode);
            map.put(key, newNode);
        }
    }
    
    private void remove(Node curr){
        if(curr == head){
            head = head.next;
        }
        if(curr == tail){
            tail = tail.prev;
        }
        
        if(curr.next != null){
            curr.next.prev = curr.prev;
        }
        
        if(curr.prev != null){
            curr.prev.next = curr.next;   
        }
        
        curr.prev = null;
        curr.next = null;
    }
    
    private void setHead(Node curr){
        if(head == null){
            head = curr;
            tail = curr;
        }else{
            curr.next = head;
            head.prev = curr;
            head = curr;
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```  
