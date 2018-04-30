package Stack;

import java.util.Stack;

public class OrderByStack {
    private static Stack<Integer> order(Stack<Integer> old) {
        Stack<Integer> newStack = new Stack<>();
        while (!old.isEmpty()) {
            int num = old.pop();
            while (!newStack.isEmpty() && newStack.peek() > num) {
                old.push(newStack.pop());
            }
            newStack.push(num);

        }
        return newStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        for (int i = 10; i > 5; i--) {
            stack.push(i);
        }
        Stack<Integer> a = order(stack);
        System.out.println(a);
    }
}
