import java.io.FileOutputStream;
import java.util.*;

public class FordFulkerson {
    static int INF = Integer.MAX_VALUE;
    static int V = 6;
    static int[][] capacity = new int[][]{
        {0, 14, 0, 18, 0, 0}, //S
        {0, 0, 10, 0, 0, 0}, // A
        {0, 0, 0, 0, 5, 15}, // B
        {0, 12, 0, 0, 10, 0}, //C
        {0, 0, 0, 0, 0, 10}, // D
        {0, 0, 0, 0, 0, 0}}; // T
    static int[][] flow = new int[V][V];

    public static void main(String[] args) {
        System.out.println("유량 네트워크 전체의 최대 용량 : " + networkFlow(0, 5));
    }

    public static int networkFlow(int source, int sink) {
        for (int i = 0; i < V; i++){
            for (int j = 0; j < V; j++){
                flow[i][j] = 0;
            }
        }
        int totalFlow = 0;
        while (true) {
            List<Integer> parent = new ArrayList<>(V);
            for (int i = 0; i < V; i++) {
                parent.add(i, -1);
            }
            Queue<Integer> q = new LinkedList<>();
            parent.set(source, source);
            ((LinkedList<Integer>) q).push(source);
            while (!q.isEmpty() && (parent.get(sink) == -1)) {
                int here = q.peek();
                ((LinkedList<Integer>) q).pop();
                for (int there = 0; there < V; ++there) {
                    if (((capacity[here][there] - flow[here][there]) > 0) && parent.get(there) == -1) {
                        q.add(there);
                        parent.set(there, here);
                    }
                }
            }
            if (parent.get(sink) == -1) break;

            int amount = INF;

            System.out.print("경로: ");
            for (int p = sink; p != source; p = parent.get(p)) {
                amount = Math.min(capacity[parent.get(p)][p] - flow[parent.get(p)][p], amount);
                System.out.print(p + "-");
            }
            System.out.print("0 / ");

            for (int p = sink; p != source; p = parent.get(p)) {
                flow[parent.get(p)][p] += amount;
                flow[p][parent.get(p)] -= amount;
            }
            totalFlow += amount;
            System.out.println("최대 용량 : " + amount);
        }
        return totalFlow;
    }

}
