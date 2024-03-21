package Lab1;

import java.util.Scanner;

public class Lab1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        while (number < 100 || number > 999) {
            System.out.println("Введіть тризначне число");
            number = scanner.nextInt();
        }
        int digit1 = number / 100;
        int digit2 = number / 10 % 10;
        int digit3 = number % 10;
        if (digit1 != digit2 && digit1 != digit3 && digit2 != digit3)
            System.out.println("Всі цифри є різними");
        else System.out.println("Не всі цифри є різними");
    }
}
