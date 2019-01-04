public class Queue {
    private Heap minHeap;
    private Node[] nodes;
    private int heapSize;

    public Queue(Heap minHeap) {
        this.minHeap = minHeap;
        this.nodes = minHeap.getNodes();
        this.heapSize = minHeap.getHeapSize();
    }

    public void insert(Node newNode) {
        this.nodes[++this.heapSize] = newNode;
        this.minHeap.setHeapSize(this.heapSize);
        this.minHeap.BUILD_MIN_HEAP(this.nodes);
    }

    public Node min() {
        return this.nodes[1];
    }

    public Node extract_min() {
        Node temp = this.nodes[1];
        this.nodes[1] = this.nodes[this.heapSize--];
        this.minHeap.setHeapSize(this.heapSize);
        this.minHeap.BUILD_MIN_HEAP(this.nodes);
        return temp;
    }

    public void updateDistance(int index, int path) {
        for (int i = 1; i <= heapSize; i++) {
            if (index == nodes[i].getVertex()) {
                nodes[i].setPath(path);
                this.minHeap.BUILD_MIN_HEAP(this.nodes);
                return;
            }
        }
    }

    public boolean hasVertex(int index) {
        for (int i = 1; i <= heapSize; i++) {
            if (index == nodes[i].getVertex()) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.heapSize == 0;
    }
}