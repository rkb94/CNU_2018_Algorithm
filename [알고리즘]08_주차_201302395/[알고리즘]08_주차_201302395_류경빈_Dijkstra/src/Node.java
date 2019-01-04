public class Node {
    private int vertex;
    private int dist;

    public Node(int vertex, int dist){
        this.vertex = vertex;
        this.dist = dist;
    }

    public int getVertex() {
        return vertex;
    }
    public void setVertex(int vertex) {
        this.vertex = vertex;
    }
    public int getDist() {
        return dist;
    }
    public void setDist(int dist) {
        this.dist = dist;
    }

}