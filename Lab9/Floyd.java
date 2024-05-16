public class Floyd {
    static int V;
    static void print(int[][] dist)
    {
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == Integer.MAX_VALUE)
                    System.out.print(" - ");
                else
                    System.out.printf("%2s ", dist[i][j]);
            }
            System.out.println();
        }
    }

    public Floyd(int[][] dist)
    {
        V = dist.length;
        for (int k = 0; k < V; k++)
            for (int i = 0; i < V; i++)
                for (int j = 0; j < V; j++)
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
        print(dist);
    }
}
