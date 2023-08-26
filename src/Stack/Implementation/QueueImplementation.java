package Stack.Implementation;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImplementation {

    Queue<Integer> queue = new LinkedList<>();
    public void push(int x) {
        queue.add(x);
        int i=0;
        while(i<queue.size()-1) {
            queue.add(queue.remove());
            i++;
        }
    }

    public int pop() {
        if(!queue.isEmpty())
            return queue.remove();
        return Integer.MIN_VALUE;
    }

    public int top() {
        if(!queue.isEmpty())
            return queue.peek();
        return Integer.MIN_VALUE;
    }

    public boolean empty() {
        return queue.size()==0;
    }
}
