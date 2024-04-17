package Lab4;

import Lab3.Timetable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Створити список з розкладом\n" +
                    "2. Створити список товарів");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Lab4_1.main(args);
                        break;
                    case 2:
                        Lab4_2.main(args);
                        break;
                    default:
                        continue;
                    case 0:
                        return;
                }
            }
            catch (Exception e) {
                scanner.next();
                main(args);
            }
        }
    }

    static class Lab4_1 {
        static Scanner scanner = new Scanner(System.in);
        static Node head = null;
        static class Node {
            Timetable value;
            Node next;
            public Node(Timetable value) {
                this.value = value;
            }
        }

        public static void main(String[] args) {
            int choice;
            int index;
            String NAZV;
            while (true) {
                System.out.println("1. додавання елементів до списку;\n" +
                    "2. вилучення елементів зі списку;\n" +
                    "3. пошук за заданим полем;\n" +
                    "4. друкування списку");
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            add(new Node(new Timetable(scanner)));
                            break;
                        case 2:
                            System.out.println("Порядковий номер елемента, який треба видалити");
                            index = scanner.nextInt();
                            remove(index - 1);
                            break;
                        case 3:
                            System.out.println("Введіть пункт призначення");
                            NAZV = scanner.nextLine();
                            print(NAZV);
                            break;
                        case 4:
                            print();
                            break;
                        default:
                            continue;
                        case 0:
                            return;
                    }
                }
                catch (Exception e) {
                    scanner.next();
                    Lab4_1.main(args);
                }
            }
        }

        public static void add(Node addNode) {
            if (head == null) {
                head = addNode;
                return;
            }
            Node node = head;
            while (node.next != null)
                node = node.next;
            node.next = addNode;
        }

        public static void remove(int index) {
            if (index == 0 && head != null) {
                head = head.next;
                return;
            }
            int nodeIndex = 0;
            Node node = head;
            Node prevNode = null;
            while (nodeIndex != index && node != null) {
                prevNode = node;
                node = node.next;
                nodeIndex++;
            }
            if (node != null)
                prevNode.next = node.next;
        }

        public static void print() {
            int index = 1;
            Node node = head;
            while (node != null) {
                System.out.print(index++ + ". ");
                node.value.print();
                node = node.next;
            }
        }

        public static void print(String NAZV) {
            int COUNT = 0;
            Node node = head;
            while (node != null) {
                if (node.value.NAZV.equals(NAZV)) {
                    ++COUNT;
                    node.value.print();
                }
                node = node.next;
            }
            if (COUNT == 0)
                System.out.println("Нема потягів, що відправляються в " + NAZV);
        }
    }

    static class Lab4_2 {
        static ArrayList<String> BoschProducts = new ArrayList<>();
        static ArrayList<String> PhilipsProducts = new ArrayList<>();
        static ArrayList<String> AllProducts = new ArrayList<>();

        public static void main(String[] args) {
            BoschProducts.addAll(Arrays.asList("Холодильник", "Посудомийна машина", "Пральна машина", "Духовка", "Мікрохвильова піч"));
            PhilipsProducts.addAll(Arrays.asList("Електрична зубна щітка", "Фен для волосся", "Світлодіодна лампочка",
                    "Телевізор", "Кавоварка", "Праска"));
            for (String boschProduct : BoschProducts) AllProducts.add("Bosch " + boschProduct);
            for (String philipsProduct : PhilipsProducts) AllProducts.add("Philips " + philipsProduct);
            System.out.println("Товари Bosch");
            print(BoschProducts);
            System.out.println("Товари Philips");
            print(PhilipsProducts);
            System.out.println("Всі товари");
            print(AllProducts);
        }

        public static void print(ArrayList<String> list) {
            for (String s : list) System.out.println(s);
            System.out.println();
        }
    }
}
