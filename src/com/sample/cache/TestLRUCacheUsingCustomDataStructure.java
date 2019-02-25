package com.sample.cache;

import java.util.HashMap; 

class Node { 
    int key; 
    int value; 
    Node pre; 
    Node next; 
  
    public Node(int key, int value) 
    { 
        this.key = key; 
        this.value = value; 
    } 
} 
  
class LRUCache { 
    private HashMap<Integer, Node> map; 
    private int capicity, count; 
    private Node head, tail; 
  
    public LRUCache(int capacity) 
    { 
        this.capicity = capacity; 
        map = new HashMap<>(); 
        head = new Node(0, 0); 
        tail = new Node(0, 0); 
        head.next = tail; 
        tail.pre = head; 
        head.pre = null; 
        tail.next = null; 
        count = 0; 
    } 
  
    public void deleteNode(Node node) 
    { 
        node.pre.next = node.next; 
        node.next.pre = node.pre; 
    } 
  
    public void addToHead(Node node) 
    { 
        node.next = head.next; 
        node.next.pre = node; 
        node.pre = head; 
        head.next = node; 
    } 
  
    // This method works in O(1) 
    public int get(int key) 
    { 
        if (map.get(key) != null) { 
            Node node = map.get(key); 
            int result = node.value; 
            deleteNode(node); 
            addToHead(node); 
            System.out.println("Got the value : " + 
                  result + " for the key: " + key); 
            return result; 
        } 
        System.out.println("Did not get any value" + 
                            " for the key: " + key); 
        return -1; 
    } 
  
    // This method works in O(1) 
    public void put(int key, int value) 
    { 
        System.out.println("Going to set the (key, "+  
             "value) : (" + key + ", " + value + ")"); 
        if (map.get(key) != null) { 
            Node node = map.get(key); 
            node.value = value; 
            deleteNode(node); 
            addToHead(node); 
        } 
        else { 
            Node node = new Node(key, value); 
            map.put(key, node); 
            if (count < capicity) { 
                count++; 
                addToHead(node); 
            } 
            else { 
                map.remove(tail.pre.key); 
                deleteNode(tail.pre); 
                addToHead(node); 
            } 
        } 
    } 
} 
  
/**
 * Map
 * key Node
 * 1	(1,10)
 * 2	(2,20)
 * 
 * DLL = head -> 2 -> 1 -> tail
 * 
 * when we do a get(1), then we :
 * 		a) delete 1
 *  	b) addToHead the node 1 (add it next to head(addToHead())
 * DLL = head -> 1 -> 2 -> tail
 * 
 *  when we do:
 *  put(3,30) then we do three things:
 *  	a. remove from Map 2 & 
 *  	b. delete the node 2 from tail
 *  	c. addToHead 3.
 *  DLL= head -> 3 -> 1 -> tail
 *  
 *  put(4,40) then we do three things:
 *  	a. remove from Map 1 & 
 *  	b. delete the node 1 from tail
 *  	c. addToHead 4.
 *  DLL= head -> 4 -> 3 -> tail
 *  
 *  get(1), returns -1 saying key not found in Map.
 *  
 *  get(3), will return (3,30) node by 
 *  	a) deleting 3
 *  	b) addToHead the node 3.
 *  DLL= head -> 3 -> 4 -> tail
 * 
 * 	get(4), will return (4,40) node as same as above.
 * 
 * 
 * @author Manish.Barnawal
 *
 */
public class TestLRUCacheUsingCustomDataStructure { 
    public static void main(String[] args) 
    { 
        System.out.println("Going to test the LRU "+  
                           " Cache Implementation"); 
        LRUCache cache = new LRUCache(2); 
   
        // it will store a key (1) with value  
        // 10 in the cache. 
        cache.put(1, 10);  
  
        // it will store a key (2) with value 20 in the cache. 
        cache.put(2, 20);  
        System.out.println("Value for the key: 1 is " +  
                           cache.get(1)); // returns 10 
  
        // evicts key 2 and store a key (3) with 
        // value 30 in the cache. 
        cache.put(3, 30);  
  
        System.out.println("Value for the key: 2 is " +  
                cache.get(2)); // returns -1 (not found) 
  
        // evicts key 1 and store a key (4) with 
        // value 40 in the cache. 
        cache.put(4, 40);  
        System.out.println("Value for the key: 1 is " + 
               cache.get(1)); // returns -1 (not found) 
        System.out.println("Value for the key: 3 is " +  
                           cache.get(3)); // returns 30 
        System.out.println("Value for the key: 4 is " + 
                           cache.get(4)); // return 40 
    } 
} 
