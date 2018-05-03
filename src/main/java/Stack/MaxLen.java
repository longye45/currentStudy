package Stack;

/**
 * 求解和为某值的最大深度
 */
public class MaxLen {

    static int a;

    public static class Node {
        public int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int getMaxLen(Node head, int value) {
        int maxLen = 0;
        if (head == null) {
            return 0;
        }
        process(head, 0, 0, value, maxLen);
        return a;
    }

    public static void process(Node head, int level, int sum, int value, int maxLen) {
        if (head == null || sum == value) {
            return;
        }
        sum += head.value;
        if (sum == value) {
            a = a >= level ? maxLen : level;
        } else {
            process(head.left, level + 1, sum, value, maxLen);
            process(head.right, level + 1, sum, value, maxLen);
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(3);
        head.right.right = new Node(2);
        head.right.right.left = new Node(1);
        System.out.println(getMaxLen(head, 7));
    }
}
