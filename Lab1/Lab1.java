package Lab1;

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("1. Дано координати трьох вершин трикутника (x1, y1), (x2, y2), (x3, y3). Знайти його периметр та площу.\n" +
                    "2. Обчислити значення у, де y=1+(3+x)/(1+x^2 ).\n" +
                    "3. Перевірити істинність твердження: «Всі цифри даного тризначного числа різні».\n");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Lab1_1.main(args);
                    break;
                case 2:
                    Lab1_2.main(args);
                    break;
                case 3:
                    Lab1_3.main(args);
                    break;
                default:
                    continue;
                case 0:
                    scanner.close();
                    return;
            }
        }
    }
}
