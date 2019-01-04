public class MaxPriorityQueue {
    private MaxHeap maxHeap;
    private Node[] node;
    private int heapSize;

    public MaxPriorityQueue(MaxHeap maxHeap){
        this.maxHeap = maxHeap;
        this.node = maxHeap.getNodes();
        this.heapSize = maxHeap.getHeapSize();
    }

    public void insert(Node newNode){// 새로운 노드 삽입
        this.node[++this.heapSize] = newNode;
        // heapSize를 늘려 해당하는 곳에 newNode를 삽입
        this.maxHeap.setHeapSize(this.heapSize);
        // 늘어난 heap 사이즈로 set
        this.maxHeap.maxHeapInsert(this.node, heapSize);
        // BUILD-MAX-HEAP을 통해 MAX-HEAPIFY 실행
    }

    public Node max() {
        return this.node[1]; // MAX-HEAP에서는 1번재 노드가 제일 큰 key 값을 가지고 있기 때문에 1번째 노드를 반환한다.
    }

    public void extract_max(){
        this.node[1] = this.node[this.heapSize--];
        // node[1]:max key를 heapSize:min key 값으로 바꿔준다.
        // 그리고 heap의 사이즈를 줄여준다.
        this.maxHeap.setHeapSize(this.heapSize);
        // heapSize를 set 해준 후
        this.maxHeap.buildMaxHeap(this.node);
        // BUILD-MAX-HEAP을 통해 node를 MAX-HEAPIFY 한다.
    }

    public void increase_key(int index, int key){
        this.node[index+1].setKey(key);
        this.maxHeap.maxHeapInsert(this.node, index+1);
    }

    public void h_delete(int index){
        this.node[index] = this.node[this.heapSize--];
        this.maxHeap.setHeapSize(this.heapSize);
        this.maxHeap.buildMaxHeap(this.node);
    }
}
