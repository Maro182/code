import java.util.ArrayList;
import java.util.List;

public class Prim {
    static List<Edge> list(int[][] adj) {
        List<Edge> f = new ArrayList<>();
        return f;
    }
    public static void prim(int n, int[][] w) {
        int i, unear = 0;
        int min;
        Edge e;
        int[] nearest = new int[n];
        int[] distance = new int[n];
        List<Edge> f = list(w);
        for (i = 2; i <= n; i++) {
            nearest[i] = 1;
            distance[i] = w[1][i];
        }
        while (n > 1) {
            min = 99999;
            for (i = 2; i <= n; i++) {
                if (distance[i] < min && distance[i] >= 0) {
                    min = distance[i];
                    unear = i;
                }
            }
            e = new Edge(n, unear, nearest[unear]);
            f.add(e);
            distance[unear] = -1;
            for (i = 2; i <= n; i++) {
                if (w[i][unear] < distance[i]) {
                    distance[i] = w[i][unear];
                    nearest[i] = unear;
                }
            }
            n--;
        }
    }
    public static void main(String[] args) {
        
    }
}
class Edge {
    int from , to , weight;
    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

