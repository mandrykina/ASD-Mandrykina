package Lab2;

import java.util.Scanner;

public class Lab2_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        do {
            System.out.println("Введіть кількість рядків");
            N = scanner.nextInt();
        } while (N <= 0);
        int M;
        do {
            System.out.println("Введіть кількість стовпців");
            M = scanner.nextInt();
        } while (M <= 0);
        int [][] a = new int[N][M];
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < M; ++j)
                a[i][j] = (int) (Math.random() * 100) - 50;
        System.out.println("Матриця");
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j)
                System.out.printf("%4d ", a[i][j]);
            System.out.println();
        }
        System.out.println();
        int [][] b = new int[M][N];
        for (int i = 0; i < M; ++i)
            for (int j = 0; j < N; ++j)
                b[i][j] = a[j][M - i - 1];
        System.out.println("Матриця, повернута на 90 градусів проти годинникової стрілки");
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j)
                System.out.printf("%4d", b[i][j]);
            System.out.println();
        }
    }
}
