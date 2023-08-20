package Stack;

import java.util.Stack;

public class StackProblems {

    boolean isPair(char open, char close) {
        return (close==')' && open=='(') ||
                (close=='}' && open=='{') ||
                    (close==']' && open=='[');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(!stack.empty() && isPair(stack.peek() ,s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public int[] calculateSpan(int price[], int n)
    {
        Stack<Integer> s = new Stack<>();
        int[] span = new int[n];
        for(int i=0;i<n;i++) {
            while(!s.empty() && price[s.peek()] <= price[i]) {
                s.pop();
            }
            span[i] = s.empty() ? (i+1) : (i-s.peek());
            s.push(i);
        }
        return span;
    }
}
