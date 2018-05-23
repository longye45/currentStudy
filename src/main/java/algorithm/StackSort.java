package algorithm;

import java.util.Stack;

public class StackSort {
    public static void stackSort(Stack<Integer> stack) {
        Stack<Integer> stack1 = new Stack();
        while (!stack.isEmpty()) {
            int val = stack.peek();
            if (!stack1.isEmpty() && val > stack1.peek()) {
                stack.push(stack1.pop());
            }
            stack1.push(stack.pop());
        }

        while (!stack1.isEmpty()) {
            stack.push(stack1.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 10; i++) {
            st.push(i);
        }
        for (int i = 11 ; i < 20; i++) {
            st.push(i);
        }

        stackSort(st);

        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }
}
