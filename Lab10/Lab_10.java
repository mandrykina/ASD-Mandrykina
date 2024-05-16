import java.util.Scanner;

public class Lab_10 {
    public static void main(String[] args) {
        int v = 15;
        int[][] graph = new int[v][v];
        for (int i = 0; i < v; ++i)
            for (int j = 0; j < v; ++j)
                if (i == j) graph[i][j] = 0;
                else graph[i][j] = Integer.MAX_VALUE;
        graph[0][1] = 7;
        graph[1][2] = 8;
        graph[1][5] = 6;
        graph[1][6] = 6;
        graph[2][6] = 3;
        graph[3][4] = 6;
        graph[3][8] = 6;
        graph[4][0] = 5;
        graph[4][9] = 4;
        graph[5][4] = 4;
        graph[5][6] = 4;
        graph[5][10] = 3;
        graph[5][11] = 5;
        graph[7][3] = 10;
        graph[7][8] = 5;
        graph[8][4] = 3;
        graph[8][9] = 8;
        graph[9][5] = 5;
        graph[9][10] = 6;
        graph[9][12] = 4;
        graph[10][11] = 9;
        graph[12][13] = 2;
        graph[13][10] = 7;
        graph[13][11] = 8;
        graph[13][14] = 10;
        System.out.println("Оберіть алгоритм\n" + "1. Алгоритм Дейкстри\n" + "2. Алгоритм Флойда");
        Scanner sc = new Scanner(System.in);
        int verticle;
        int number = sc.nextInt();
        while (number != 0) {
            switch (number) {
                case 1:
                    System.out.println("Введіть число вершин від 1 до " + v);
                    verticle = sc.nextInt();
                    if (verticle >= 1 && verticle <= v) new Dijkstra(graph, verticle - 1);
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
