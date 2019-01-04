import java.io.File;
//import java.io.FileReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MaxHeap {
    private Node[] node;
    private int heapSize;
    File path = new File("./src/data03.txt"); // data03.txt 경로

    public MaxHeap(){ // Constructor
        this.node = new Node[65];
        this.heapSize = 0;
    }

    public void fileReader() throws IOException{
        Scanner scanner = new Scanner(new InputStreamReader(new FileInputStream(path),"MS949")); // 한글 깨지는거 처리..
        for (int i = 1; scanner.hasNext(); i++){
            StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine(), ",");
            while (stringTokenizer.hasMoreTokens()){
                this.node[i] = new Node(Integer.parseInt(stringTokenizer.nextToken()), stringTokenizer.nextToken());
                this.heapSize++;
            }
        }
        scanner.close();
    }

    private void maxHeapify(Node[] node, int index){
        int leftChild = 2*index;
        int rightChild = 2*index+1;
        int largest = index;

        if (leftChild <= heapSize && node[leftChild].getKey() > node[index].getKey()){
            // parent node의 key 값과 node[leftchild]의 key값을 비교한다.
            largest = leftChild; // leftChild의 값이 클경우 largest는 leftchild로 바뀐다.
        }
        else {
            largest = index; // 아니면 그대로 largest 값은 index 값을 가진다.
        }

        if (rightChild <= heapSize && node[rightChild].getKey() > node[largest].getKey()){
            // rightChild 와 largest 인덱스의 key값과 비교
            largest = rightChild;
        }

        if (largest != index){
            // 최대 값이 index가 아닐 경우 이는 위에서 leftChild의 값을 가지거나 rightChild의 값을 가지는 경우와 같다.
            // 값을 교환해준다..
            Node temp = node[index];
            node[index] = node[largest];
            node[largest] = temp;
            // 그리고 largest의 값이 또 다른 것들과 비교해서 클 수 있기 때문에 새롭게 maxHeapify 해준다.
            maxHeapify(node, largest);
        }
    }

    public void buildMaxHeap(Node[] node) {
        for (int i = this.heapSize/2; i >= 1; i--) {
            maxHeapify(node, i);
        }
    }

    public void maxHeapInsert(Node[] node, int index){
        int newKey = index;

        while ((newKey > 1) && (node[newKey/2].getKey() < node[newKey].getKey())) {
            Node temp = node[newKey];
            node[newKey] = node[newKey/2];
            node[newKey/2] = temp;
            newKey = newKey/2;
        }
    }

    public void printQueue() {
        for (int i = 1; i <= this.heapSize; i++) {
            int num = i-1;
            System.out.println("[" + num + "] " + this.node[i].toString());
        }
    }

    public Node[] getNodes() {
        return this.node;
    }

    public int getHeapSize() {
        return this.heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }
}
