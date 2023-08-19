package Stack;

import Stack.Implementation.ArrayImplementation;

public class StackModule {

    public static void main(String[] args) {
        ArrayImplementation stack = new ArrayImplementation();
        stack.push(3);
        stack.push(8);

        System.out.println(stack.top());

        stack.pop();
        System.out.println(stack.top());

    }
}
