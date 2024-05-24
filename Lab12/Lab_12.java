import java.util.Scanner;

public class Lab_12 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] A = new int[19];
        readArray(A);
        System.out.println(countPositiveOnEven(A));
        System.out.println(sumNegativeOnOdd(A));
        int[] B = new int[17];
        readArray(B);
        System.out.println(sumNegativeOnOdd(B));
        int[] C = new int[23];
        readArray(C);
        System.out.println(countPositiveOnEven(C));
        System.out.println(sumNegativeOnOdd(C));
    }

    public static void readArray(int[] A) {
        System.out.println("Введіть " + A.length + " цілих чисел");
        for (int i = 0; i < A.length; ++i)
            A[i] = scanner.nextInt();
    }

    public static int countPositiveOnEven(int[] A) {
        int count = 0;
        for (int i = 1; i < A.length; i += 2)
            count += A[i] > 0 ? 1 : 0;
        return count;
    }

    public static int sumNegativeOnOdd(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i += 2)
            sum += A[i] < 0 ? A[i] : 0;
        return sum;
    }
}
