package Stack.Implementation;

public class ArrayImplementation {

    int top = -1;
    int size=0;
    int[] arr = new int[10000];

    public void push(int x) {
        arr[++top] = x;
    }

    public int pop() {
        int x = arr[top--];
        return x;
    }

    public int top() {
        return arr[top];
    }

    boolean isEmpty() {
        return top==-1;
    }
}
