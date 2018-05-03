package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTreeByLevel {
    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printByLevel(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        int level = 1;
        Node last = head;
        Node nLast = null;
        queue.offer(head);
        System.out.println("Level" + (level++) + ":");
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.println(head.value + " ");
            if (head.left != null) {
                queue.offer(head.left);
                nLast = head.left;
            }
            if (head.right != null) {
                queue.offer(head.right);
                nLast = head.right;
            }
            if (head == last && !queue.isEmpty()) {
                System.out.println("Level" + (level++) + " ");
                last = nLast;
            }
        }
        System.out.println();
    }
}
