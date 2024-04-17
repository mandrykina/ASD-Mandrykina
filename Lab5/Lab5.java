package Lab5;

public class Lab5 {
    static Node PA, PB, PC;
    static class Node {
        int value;
        Node prev, next;
        public Node(int value, Node prev) {
            this.value = value;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        generateLists();
        insert();
        Node head = findHead(PC);
        Node tail = findTail(PC);
        Node node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
        System.out.println(head.value + " " + tail.value);
    }

    public static void generateLists() {
        int firstCount = (int) (Math.random() * 9) + 1;
        int secondCount = (int) (Math.random() * 9) + 1;
        Node prev = null;
        for (int i = 0; i < firstCount; ++i) {
            Node current = new Node((int)(Math.random() * 20), prev);
            System.out.print(current.value + " ");
            if (prev == null) {
                PA = current;
            }
            else prev.next = current;
            prev = current;
        }
        System.out.println();
        PB = prev;
        int index = (int) (Math.random() * secondCount);
        prev = null;
        for (int i = 0; i < secondCount; ++i) {
            Node current = new Node((int)(Math.random() * 20), prev);
            System.out.print(current.value + " ");
            if (i == index)
                PC = current;
            if (prev != null)
                prev.next = current;
            prev = current;
        }
        System.out.println();
        System.out.println(index + " " + PC.value);
        System.out.println();
    }

    public static void insert() {
        PA.prev = PC;
        PB.next = PC.next;
        PC.next = PA;
        if (PB.next != null)
            PB.next.prev = PB;
    }

    public static Node findHead(Node node) {
        while (node.prev != null)
            node = node.prev;
        return node;
    }

    public static Node findTail(Node node) {
        while (node.next != null)
            node = node.next;
        return node;
    }
}
