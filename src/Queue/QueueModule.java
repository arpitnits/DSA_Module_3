package Queue;

import Queue.Implementation.ArrayImplementation;
import Queue.Implementation.Queue;

public class QueueModule {

    public static void main(String[] args) {
        Queue queue = new ArrayImplementation(100);
        queue.enQueue(4);
        queue.enQueue(8);

        System.out.println(queue.front());
        System.out.println(queue.rear());

        queue.dequeue();

        System.out.println(queue.front());
        System.out.println(queue.rear());
    }

}
