package algorithm;

import java.util.Stack;

public class Tree {
    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public int getValue() {
            return value;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private Node head;

    public static void getAllNode(Node head) {
        if (head != null) {
            System.out.println(head.getValue());
            getAllNode(head.left);
            getAllNode(head.right);
        }
    }

    public static void getAllNodes(Node head) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            System.out.println(head.value);
            if (head.right != null)
                stack.push(head.right);
            head = head.left;
            if (head == null){
                if (stack.isEmpty())
                    return;
                head = stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.left.right.right = new Node(6);
        getAllNodes(head);
    }
}
