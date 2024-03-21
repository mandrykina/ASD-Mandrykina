package Lab2;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("1. В одновимірному масиві розмірності N обчислити:\n" +
                    "– модулі елементів з непарними індексами;\n" +
                    "– добуток елементів, що розташовані між заданими елементами.\n" +
                    "2. Перетворити матрицю таким чином щоб в її першій половині стояли елементи, що мають непарні індекси, а в другій - парні.\n" +
                    "3. Прямокутну цілочисельну матрицю повернути на 90° проти годинникової стрілки.\n" +
                    "4. Квадратну матрицю розмірності N заповнити одиницями у верхньому та нижньому трикутниках між діагоналями матриці, решту заповнити нулями.\n");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Lab2_1.main(args);
                    break;
                case 2:
                    Lab2_2.main(args);
                    break;
                case 3:
                    Lab2_3.main(args);
                    break;
                case 4:
                    Lab2_4.main(args);
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
