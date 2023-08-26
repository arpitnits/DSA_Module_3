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

    int celebrity(int M[][], int n) {
        Stack<Integer> celebStack = new Stack<>();
        for(int i=0;i<n;i++) {
            celebStack.push(i);
        }

        while(celebStack.size()>=2) {
            int first = celebStack.pop();
            int second = celebStack.pop();

            //both don't know eachOther
            if(M[first][second] == 0 && M[second][first]==0) {

            }
            //both Knows eachOther
            else if(M[first][second] == 1 && M[second][first]==1) {

            } else if(M[first][second]==1) {
                celebStack.push(second);
            } else if(M[second][first]==1) {
                celebStack.push(first);
            }
        }

        if(!celebStack.empty()) {
            int celeb = celebStack.pop();

            //check row - celeb should not know anyone
            for(int col=0;col<n;col++) {
                if(M[celeb][col]==1)
                    return -1;
            }

            //check col
            for(int row=0;row<n;row++) {
                if(row!=celeb && M[row][celeb]==0)
                    return -1;
            }
            return celeb;
        }
        return -1;
    }







}
