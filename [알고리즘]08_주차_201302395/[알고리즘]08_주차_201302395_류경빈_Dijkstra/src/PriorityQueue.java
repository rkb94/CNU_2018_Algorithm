public class PriorityQueue {
    public void insert(Heap heap, Node input) {
        heap.insert(input);
    }

    public Node min(Heap heap) {
        return heap.min();
    }

    public void Build_Min_Heap(Heap heap) {
        heap.Build_Min_Heap();
    }

    public void set_priority(Heap heap, int i, int priority) {
        heap.set_priority(i, priority);
    }

    public int size(Heap heap) {
        return heap.size();
    }

    public Node get(Heap heap, int i) {
        return heap.get(i);
    }

    public boolean isEmpty(Heap heap) {
        return heap.isEmpty();
    }

    public Node extract_min(Heap heap){
        return heap.extract_min();
    }

}