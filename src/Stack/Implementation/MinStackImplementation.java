package Stack.Implementation;

import java.util.Stack;

public class MinStackImplementation {

    Stack<Integer> s = new Stack<>();
    int minEle = -1;

    /*returns min element from stack*/
    int getMin()
    {
        return minEle;
    }

    /*returns pop element from stack*/
    int pop()
    {
        int val = -1;
        if(!s.empty()) {
            val = s.peek();
            if(val < minEle) {
                val = minEle;
                minEle = 2*minEle - s.peek();
            }
            s.pop();
        }
        if(s.empty()) {
            minEle = -1;
        }
        return val;
    }

    /*push element x into the stack*/
    void push(int x)
    {
        if(s.empty()) {
            s.push(x);
            minEle = x;
        } else if(x>=minEle) {
            s.push(x);
        } else {
            s.push(2*x - minEle);
            minEle = x;
        }
    }
}
