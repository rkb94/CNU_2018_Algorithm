import java.util.ArrayList;

public class Heap {
    ArrayList<Node> heap = null;

    public Heap() {
        heap = new ArrayList<Node>();
    }

    public int Parent(int i) {
        return (i - 1) / 2;
    }

    public int LeftChild(int i) {
        int left = 2 * i + 1; // 배열이 0부터 시작하므로
        return left; // 왼쪽 자식 index는 2 * i + 1
    }

    public int RightChild(int i) {
        int right = 2 * i + 2; // 배열이 0부터 시작하므로
        return right; // 2 * i + 2 값 반환
    }

    public Node min() { // 최소 힙에서 최소 항목은 항상 뿌리에 있으므로
        return heap.get(0);
    }

    public void swap(int a, int b) {
        Node temp = heap.get(a); // a index 노드와
        heap.set(a, heap.get(b)); // b index 노드 swap
        heap.set(b, temp);
    }

    public void Min_Heapify(int i) { // 힙 구현
        int l = LeftChild(i); // 해당 왼쪽 자식 index
        int r = RightChild(i); // 오른쪽 자식 index
        int smallest = i; // 가장 큰값
        if (l < heap.size() && heap.get(l).getDist() < heap.get(i).getDist()) {
            smallest = l; // 우선순위가 왼쪽이 낮을때
        } else {
            smallest = i; // 부모가 낮을때
        }
        if (r < heap.size()
                && heap.get(r).getDist() < heap.get(smallest).getDist()) {
            smallest = r; // 우선순위가 오른쪽이 낮을때
        }
        if (smallest != i) { // 가장 작은 것과 index가 같지 않으면 swap
            swap(i, smallest);
            Min_Heapify(smallest); // 재정렬
        }
    }

    public void set_priority(int i, int priority) {
        Node tmp = heap.get(i);		// 초기 노드 값 가져온다.
        tmp.setDist(priority);			// 우선순위 값을 바꿔준다.
        heap.set(i, tmp);			// 변경된 우선 순위값을 가진 노드 삽입
    }

    public Node extract_min() { // 가장 앞에 있는 값이 가장 작은 값이므로
        Node tmp = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1)); // 가장 끝에 있는 값을 앞으로 옮겨주고
        heap.remove(heap.size() - 1); // 노드는 삭제
        Min_Heapify(0);
        return tmp;
    }

    public void insert(Node input) {
        heap.add(input); // 새로 추가할 값을 heap에 추가 시켜준다.
        Build_Min_Heap(); // min heap 다시 만들어준다.
    }

    public void Build_Min_Heap() {
        for (int i = heap.size() / 2; i >= 0; i--) { // 전체 사이즈의 절반 즉, 마지막 노드의 부모
            // 노드부터
            Min_Heapify(i); // Min Heap 재정렬 min heap check
        }
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int size() {
        return heap.size();
    }

    public Node get(int i) {
        return heap.get(i);
    }
}