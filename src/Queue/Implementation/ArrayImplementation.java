package Queue.Implementation;

import java.util.LinkedList;

public class ArrayImplementation implements Queue {

    int capacity;
    int front = 0, rear = -1;
    int queueSize =0;
    int[] arr;
    public ArrayImplementation(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }


    @Override
    public void enQueue(int x) {
        if(queueSize==capacity) {
            System.out.println("Queue is Full");
        } else {
            rear = (rear+1) % capacity;
            arr[rear] = x;
            queueSize++;
        }
    }

    @Override
    public int dequeue() {
        if(queueSize==0) {
            System.out.println("Queue is Empty");
        } else {
            int x = arr[front];
            front = (front+1)%capacity;
            queueSize--;
            return x;
        }
        return Integer.MIN_VALUE;
    }

    @Override
    public int front() {
        if(queueSize==0) {
            System.out.println("Queue is Empty");
        } else {
            return arr[front];
        }
        return Integer.MIN_VALUE;
    }

    @Override
    public int rear() {
        if(queueSize==0) {
            System.out.println("Queue is Empty");
        } else {
            return arr[rear];
        }
        return Integer.MIN_VALUE;
    }
}
