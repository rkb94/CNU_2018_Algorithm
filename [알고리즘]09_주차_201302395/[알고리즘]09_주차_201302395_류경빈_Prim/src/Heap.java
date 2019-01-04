public class Heap {
    private Node[] nodes;
    private int heapSize;

    public Heap() {
        this.nodes = new Node[65];
        this.heapSize = 0;
    }

    private void MIN_HEAPIFY(Node[] nodes, int index) {
        int leftChild = 2*index;
        int rightChild = 2*index+1;
        int smallest;

        if (leftChild <= heapSize && nodes[leftChild].getPath() < nodes[index].getPath()) {
            smallest = leftChild;
        }
        else {
            smallest = index;
        }

        if (rightChild <= heapSize && nodes[rightChild].getPath() < nodes[smallest].getPath()) {
            smallest = rightChild;
        }

        if (smallest != index) {
            Node temp = nodes[index];
            nodes[index] = nodes[smallest];
            nodes[smallest] = temp;

            MIN_HEAPIFY(nodes, smallest);
        }
    }

    public void BUILD_MIN_HEAP(Node[] nodes) {
        for (int i = this.heapSize/2; i >= 1; i--) {
            MIN_HEAPIFY(nodes, i);
        }
    }

    public Node[] getNodes() {
        return this.nodes;
    }

    public int getHeapSize() {
        return this.heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }
}