package Lab7;

import java.util.Scanner;

public class Lab7 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(null);
        int [] a = new int[] {1212, 3451, 7694, 4512, 4352, 8732, 7326, 2350, 4536, 2387, 5746, 6776, 4316, 1324};
        for (int i : a)
            if (i / 1000 + i / 100 % 10 == i / 10 % 10 + i % 10)
                tree.insert(i);
        tree.printInLine(tree.root);
        System.out.println();
        int choice;
        int value;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Вставити елемент\n" +
                    "2. Видалити елемент\n" +
                    "3. Вивести дерево\n" +
                    "4. Перевірити присутність елементу\n" +
                    "5. Видалити листи дерева");
            try {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        value = scanner.nextInt();
                        tree.insert(value);
                        break;
                    case 2:
                        value = scanner.nextInt();
                        tree.removeByValue(value);
                        break;
                    case 3:
                        tree.printTree();
                        break;
                    case 4:
                        value = scanner.nextInt();
                        if (tree.search(tree.root, value) != null) System.out.println("Елемент присутній");
                        else System.out.println("Елемент відсутній");
                        break;
                    case 5:
                        tree.removeLeavesAndPrint();
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
}
