import java.util.ArrayList;

public class Dijkstra {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int max = Integer.MAX_VALUE;

        char[] alpha = { 'A', 'B', 'C', 'D', 'E' };

        int[][] w = { { 0, 10, 3, max, max }, { max, 0, 1, 2, max },
                { max, 4, 0, 8, 2 }, { max, max, max, 0, 7 },
                { max, max, max, 9, 0 } };

        Heap heap = new Heap();
        PriorityQueue pq = new PriorityQueue();

        ArrayList<Node> S = new ArrayList<Node>();

        int[] d = { 0, max, max, max, max }; // d[s] = 0 , 나머지 d[v] = 무한대

        for (int i = 0; i < w.length; i++) {
            Node tmp = new Node(i, d[i]); // 각각의 d[v] 정보를 큐에 입력
            pq.insert(heap, tmp);
        }
//        System.out.println(w.length); // 배열의 길이 출력
        System.out.println("dijkstra's algorithm으로 계산한 결과는 다음과 같습니다.");
        System.out.println();
        while (!pq.isEmpty(heap)) { // heap에 내용이 남아있을때 까지
            Node tmp = pq.extract_min(heap); // 가장 작은 값 추출
            S.add(tmp); // S에 추가
            int s = S.size() - 1;
            System.out.println("=========================================================");
            System.out.println("S[" + s + "] : d["
                    + alpha[S.get(S.size() - 1).getVertex()] + "] = "
                    + d[S.get(S.size() - 1).getVertex()]);
            System.out.println("---------------------------------------------------------");
            for (int i = 0; i < w.length; i++) {
                if (!(i == tmp.getVertex())) { // 자기 자신은 빼고 계산
                    if (d[i] > d[tmp.getVertex()] + w[tmp.getVertex()][i]
                            && w[tmp.getVertex()][i] != max) { // 현재값보다 계산값이 작다면
                        d[i] = d[tmp.getVertex()] + w[tmp.getVertex()][i]; // 작은
                        // 값
                        // 입력
                    }
                }
            }
            for (int i = 0; i < pq.size(heap); i++) { // 우선순위 큐에서 순서 출력
                System.out.print("Q[" + i + "] : " + "d["
                        + alpha[pq.get(heap, i).getVertex()] + "] = "
                        + pq.get(heap, i).getDist());
                if (pq.get(heap, i).getDist() != d[pq.get(heap, i).getVertex()]) { // 값이
                    // 같지
                    // 않다면
                    pq.set_priority(heap, i, d[pq.get(heap, i).getVertex()]); // 우선순위
                    // 설정
                    System.out.print(" -> d["
                            + alpha[pq.get(heap, i).getVertex()] + "] = "
                            + pq.get(heap, i).getDist()); // 경로 출력
                }
                System.out.println("\n");
                pq.Build_Min_Heap(heap);
            }
        }
    }
}