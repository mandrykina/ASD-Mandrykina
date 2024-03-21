package Lab1;

import java.util.Scanner;

public class Lab1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть координати першої точки");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        System.out.println("Введіть координати другої точки");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        System.out.println("Введіть координати третьої точки");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        double side1 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double side2 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        double side3 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));

        double perimeter = side1 + side2 + side3;
        double halfPerimeter = perimeter / 2;
        double square = Math.sqrt(halfPerimeter * (halfPerimeter - side1) * (halfPerimeter - side2) * (halfPerimeter - side3));
        System.out.println("Периметр: " + perimeter);
        System.out.println("Площа " + square);
    }
}
