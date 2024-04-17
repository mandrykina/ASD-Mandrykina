package Lab6;

public class Stack {
    static Node top;

    static class Node {
        String value;
        Node next;
        public Node(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        push(new Node("sdf"));
        push(new Node("2"));
        push(new Node("ssd4"));
        push(new Node("hello"));
        print();
        pop();
        pop();
        print();
        System.out.println("Рядок мінімальної довжини: " + minLength());
    }

    public static void push(Node node) {
        node.next = top;
        top = node;
    }

    public static void pop() {
        if (top == null) System.out.println("Стек пустий");
        top = top.next;
    }

    public static void print() {
        Node node = top;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println();
    }

    public static String minLength() {
        if (top == null)
            return "";
        Node node = top;
        String minLength = top.value;
        while (node != null) {
            if (node.value.length() < minLength.length())
                minLength = node.value;
            node = node.next;
        }
        return minLength;
    }
}
