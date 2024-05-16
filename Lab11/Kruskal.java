import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

public class Kruskal {
    private int V;
    private List<Edge> edges;
    public void addEdge(int src, int dest, int weight) {
        Edge edge = new Edge();
        edge.src = src;
        edge.dest = dest;
        edge.weight = weight;
        edges.add(edge);
    }
    private int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }
    private void union(int[] parent, int x, int y) {
        int xSet = find(parent, x);
        int ySet = find(parent, y);
        parent[xSet] = ySet;
    }

    public void kruskalMST(int[][] graph) {
        V = graph.length;
        edges = new ArrayList<>();
        for (int i = 0; i < V; ++i)
            for (int j = i + 1; j < V; ++j)
                if  (graph[i][j] != 0)
                    addEdge(i, j, graph[i][j]);
        Edge[] result = new Edge[V];
        int e = 0;
        int i = 0;
        edges.sort(Comparator.naturalOrder());
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        int comparisons = 0;
        while (e < V - 1 && i < edges.size()) {
            ++comparisons;
            Edge nextEdge = edges.get(i++);
            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);
            if (x != y) {
                result[e++] = nextEdge;
                union(parent, x, y);
            }
        }
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " - " + result[i].dest + " " + result[i].weight);
        System.out.println("Кількість порівнянь: " + comparisons);
    }
}
