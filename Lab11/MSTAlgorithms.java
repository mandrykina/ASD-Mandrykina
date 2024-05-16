public class MSTAlgorithms {

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 5, 2, 3, 0, 0, 0, 0, 0},
                {5, 0, 0, 6, 6, 5, 0, 0, 0},
                {2, 0, 0, 4, 0, 0, 2, 0, 0},
                {3, 6, 4, 0, 3, 0, 7, 8, 0},
                {0, 6, 0, 3, 0, 4, 0, 0, 0},
                {0, 5, 0, 0, 4, 0, 0, 3, 0},
                {0, 0, 2, 7, 0, 0, 0, 0, 3},
                {0, 0, 0, 8, 0, 3, 0, 0, 4},
                {0, 0, 0, 0, 0, 0, 3, 4, 0}
        };
        new Prim().primMST(adjacencyMatrix);
        System.out.println();
        new Kruskal().kruskalMST(adjacencyMatrix);
    }
}