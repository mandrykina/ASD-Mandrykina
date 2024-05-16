public class Dijkstra {
    static int V;

    static int minDistance(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }

    static void printSolution(int[] dist) {
        for (int i = 0; i < V; i++) {
            System.out.printf("Відстань до %s: ", (char) ('a' + i));
            if (dist[i] == Integer.MAX_VALUE) System.out.println("-");
            else System.out.println(dist[i]);
        }
    }

    public Dijkstra(int[][] graph, int src) {
        V = graph.length;
        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < V; v++)
                if (!sptSet[v] && graph[u][v] != Integer.MAX_VALUE && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
        printSolution(dist);
    }
}
