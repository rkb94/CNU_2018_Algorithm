public class TestDijkstra {

    public static void main (String args[]){

        char[] nodeName = { 'A', 'B', 'C', 'D', 'E' };

        int[][] w = {
                { 0, 10, 3, Dijkstra.INFINITE, Dijkstra.INFINITE },
                { Dijkstra.INFINITE, 0, 1, 2, Dijkstra.INFINITE },
                { Dijkstra.INFINITE, 4, 0, 8, 2 },
                { Dijkstra.INFINITE, Dijkstra.INFINITE, Dijkstra.INFINITE, 0, 7 },
                { Dijkstra.INFINITE, Dijkstra.INFINITE, Dijkstra.INFINITE, 9, 0 }
        };

        Dijkstra dijkstra = new Dijkstra(nodeName, w);

        dijkstra.shortestPath();
    }
}
