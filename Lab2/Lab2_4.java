package Lab2;

import java.util.Scanner;

public class Lab2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        do {
            System.out.println("Введіть розмірність матриці");
            N = scanner.nextInt();
        } while (N <= 0);
        int[][] a = new int[N][N];
        for (int i = 0; i < N / 2; ++i)
            for (int j = i + 1; j < N - i - 1; ++j)
                a[i][j] = 1;
        for (int i = N / 2; i < N; ++i)
            for (int j = N - i; j < i; ++j)
                a[i][j] = 1;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }
}
