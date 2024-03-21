package Lab2;

import java.util.Scanner;

public class Lab2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        do {
            System.out.println("Введіть кількість елементів");
            N = scanner.nextInt();
        } while (N <= 0);
        int [] a = new int [N];
        for (int i = 0; i < N; ++i)
            a[i] = (int) (Math.random() * 100) - 50;
        System.out.println("Масив");
        for (int elem : a)
            System.out.print(elem + " ");
        System.out.println();
        System.out.println("Модулі елементів з непарними індексами");
        for (int i = 1; i < N; i += 2)
            System.out.print(Math.abs(a[i]) + " ");
        System.out.println();
        System.out.println("Введіть індекс початку");
        int first = -1;
        while (first < 0 || first >= N) {
            first = scanner.nextInt();
        }
        System.out.println("Введіть індекс кінця");
        int second = -1;
        while (second < 0 || second >= N) {
            second = scanner.nextInt();
        }
        int product = 1;
        for (int i = first + 1; i < second; ++i)
            product *= a[i];
        System.out.println("Добуток елементів між заданими індексами");
        System.out.println(product);
    }
}
