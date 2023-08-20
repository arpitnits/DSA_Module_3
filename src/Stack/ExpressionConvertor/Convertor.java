package Stack.ExpressionConvertor;

import java.util.Stack;

public class Convertor {

    boolean isOperand(char operand) {
        return (operand>='A' && operand<='Z') ||
                (operand>='a' && operand<='z') ||
                    (operand>='2' && operand<='9');
    }

    int priority(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '%':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    public void infixToPostFix(String infix) {

        Stack<Character> s = new Stack<>();
        String postFix = "";
        for(int i=0;i<infix.length();i++) {
            char currChar = infix.charAt(i);

            if(isOperand(currChar)) {
                postFix+= currChar;
            } else if(currChar == '(') {
                s.push(currChar);
            } else if(currChar == ')') {
                while(!s.empty() && s.peek()!='(') {
                    postFix+=s.pop();
                }
                if(!s.empty())
                    s.pop();
            } else {
                //if operator
                while(!s.empty() && priority(s.peek())>= priority(currChar)) {
                    postFix+= s.pop();

                }
                s.push(currChar);
            }
        }

        while(!s.empty()) {
            if(s.peek() == '(')
                System.out.println("INVALID infix");
            postFix+= s.pop();
        }
        System.out.println(postFix);
    }

}
