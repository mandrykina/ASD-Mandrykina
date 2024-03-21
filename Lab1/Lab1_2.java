package Lab1;

import java.util.Scanner;

public class Lab1_2 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть значення x");
        double x = scanner.nextDouble();
        double y = 1 + (3 + x) / (1 + x * x);
        System.out.println(y);
    }
}
