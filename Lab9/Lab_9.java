import java.lang.*;
import java.util.Scanner;

public class Lab_9 {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{0, 1, Integer.MAX_VALUE, 1, 1, Integer.MAX_VALUE},
                {1, 0, 1, 1, 1, 1},
                {Integer.MAX_VALUE, 1, 0, Integer.MAX_VALUE, 1, 1},
                {1, 1, Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE},
                {1, 1, 1, 1, 0, 1},
                {Integer.MAX_VALUE, 1, 1, Integer.MAX_VALUE, 1, 0}};
        System.out.println("Оберіть алгоритм\n" +
                "1. Алгоритм Дейкстри\n" +
                "2. Алгоритм Флойда");
        Scanner sc = new Scanner(System.in);
        char verticle;
        int number = sc.nextInt();
        while (number != 0) {
            switch (number) {
                case 1:
                    System.out.println("Введіть букву вершини від a до f");
                    verticle = sc.next().charAt(0);
                    if (verticle >= 'a' && verticle <= 'f')
                        new Dijkstra(graph, verticle - 'a');
                    break;
                case 2:
                    new Floyd(graph);
                    break;
            }
            System.out.println("Оберіть алгоритм");
            number = sc.nextInt();
        }
    }
}