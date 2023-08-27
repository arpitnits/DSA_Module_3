package Queue.Implementation;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node {

        int key;
        int val;
        Node prev = null;
        Node next = null;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    Node head, tail;
    Map<Integer, Node> cacheMap = new HashMap<>();
    LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {
        if(cacheMap.containsKey(key)) {
            Node newNode = cacheMap.get(key);
            moveToHead(newNode);
            return newNode.val;
        }
        return -1;
    }

    public void put(int key, int val) {
        Node newNode;
        //updation case
        if(cacheMap.containsKey(key)) {
            newNode = cacheMap.get(key);
            moveToHead(newNode);
            newNode.val = val;
        } else {
            //remove if size is more than capacity
            if(cacheMap.size() >= capacity) {
                removeTail();
            }
            //add new value
            newNode = new Node(key, val);
            addToHead(newNode);
            cacheMap.put(key, newNode);
        }
    }

    public void moveToHead(Node temp) {
        if(temp==head)
            return;
        if(temp==tail) {
            tail=tail.prev;
            tail.next = null;
            addToHead(temp);
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            addToHead(temp);
        }
    }

    public void addToHead(Node temp) {
        if(head==null) {
            head = tail = temp;
        } else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    public void removeTail() {
        if(tail.prev!=null) {
            tail.prev.next = null;
        } else {
            head = null;
        }
        cacheMap.remove(tail.key);
        tail = tail.prev;
    }

}

