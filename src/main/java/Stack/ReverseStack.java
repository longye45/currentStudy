package Stack;

import java.util.Stack;

public class ReverseStack {

    public static int getAndRemoveStack(Stack<Integer> stack) {
        int num = stack.pop();
        if (stack.isEmpty())
            return num;
        else{
            int last = getAndRemoveStack(stack);
            stack.push(num);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int i = getAndRemoveStack(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
//        reverse(stack);
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(getAndRemoveStack(stack));
        }
    }
}
