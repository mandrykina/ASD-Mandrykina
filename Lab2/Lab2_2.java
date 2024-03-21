package Lab2;

import java.util.Scanner;

public class Lab2_2 {
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
        int [] b = new int [N];
        for (int i = 0; i < N / 2; ++i)
            b[i] = a[i * 2 + 1];
        for (int i = N / 2; i < N; ++i)
            b[i] = a[(i - N / 2) * 2];
        a = b;
        System.out.println("Масив, у якому в першій половині стоять елементи, що мали парні індекси, а в другій - непарні");
        for (int elem : a)
            System.out.print(elem + " ");
        System.out.println();
    }
}
