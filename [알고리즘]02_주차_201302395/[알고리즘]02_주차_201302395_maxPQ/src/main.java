

import java.io.IOException;
import java.util.Scanner;
public class main {
    public static void main(String[] args) throws IOException {
        MaxHeap maxHeap = new MaxHeap();

        maxHeap.fileReader();
        maxHeap.buildMaxHeap(maxHeap.getNodes());

        MaxPriorityQueue maxPriorityQueue = new MaxPriorityQueue(maxHeap);

        System.out.println("**** 현재 우선 순위 큐에 저장되어 있는 작업 대기 목록은 다음과 같습니다. ****");
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println();
            maxHeap.printQueue();
            System.out.println();

            System.out.println("------------------------------------------------");
            System.out.println("1. 작업추가   2. 최대값   3. 최대 우선순위 작업처리");
            System.out.println("4. 원소 키값 증가         5. 작업 제거     6. 종료");
            System.out.println("------------------------------------------------");


            switch (scanner.nextInt()) {
                case 1:
                    System.out.print("신규 작업명 : ");
                    String subject = scanner.next();
                    System.out.print("우선 순위 (0~999) : ");
                    int priority = scanner.nextInt();
                    maxPriorityQueue.insert(new Node(priority, " " + subject));
                    System.out.println("**** 작업 추가 완료 ****");
                    break;
                case 2:
                    System.out.println("**** MAX : " + maxPriorityQueue.max().toString() + "****");
                    break;
                case 3:
                    maxPriorityQueue.extract_max();
                    System.out.println("**** 한 개의 작업을 처리했습니다. ****");
                    break;
                case 4:
                    System.out.print("수정할 노드 x : ");
                    int index = scanner.nextInt();
                    if (index > maxHeap.getHeapSize()) {
                        System.out.println("**** 잘못된 입력입니다. ****");
                        break;
                    }
                    System.out.print("수정할 key : ");
                    int key = scanner.nextInt();
                    maxPriorityQueue.increase_key(index, key);
                    System.out.println("**** 한 개의 작업을 처리했습니다. ****");
                    break;
                case 5:
                    System.out.print("삭제할 노드 x 입력 : ");
                    index = scanner.nextInt();
                    if (index > maxHeap.getHeapSize()) {
                        System.out.println("**** 잘못된 입력입니다. ****");
                        break;
                    }
                    maxPriorityQueue.h_delete(index+1);
                    System.out.println("**** 한 개의 작업을 처리했습니다. ****");
                    break;
                case 6:
                    return;
                default:
                    System.out.println("**** 잘못된 입력입니다. ****");
                    break;
            }
        }
    }
}
