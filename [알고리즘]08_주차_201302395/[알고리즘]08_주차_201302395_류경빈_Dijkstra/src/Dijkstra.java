import java.util.ArrayList;

public class Dijkstra {

    public static final int INFINITE = Integer.MAX_VALUE;

    private char[] nodeName;
    private int[][] w;
    private int[] d;

    public void setNodeName(char[] _nodeName){
        this.nodeName = _nodeName;
    }

    public char[] getNodeName(){
        return this.nodeName;
    }

    public void setW(int[][] _w){
        this.w = _w;
    }

    public int[][] getW(){
        return this.w;
    }

    public Dijkstra(char[] nodeName, int[][] array){
        setNodeName(nodeName);
        setW(array);
    }

    public void shortestPath() {
        Heap heap =          new Heap(); // 힙..
        PriorityQueue Q =    new PriorityQueue(); // 나머지 정점들의 큐
        ArrayList<Node> S =  new ArrayList<Node>(); // 시작 정점으로부터 최단 경로가 이미 발견된 정점들의 집합

        makeDistance(); // distance 배열 초기화..
        // d[]는 출발점을 제외한 모든 값을 INFINITE로 초기화 해준다.

        for (int i = 0; i < w.length; i++){
            Node temp = new Node(i, d[i]);
            Q.insert(heap, temp); // Q에 Node(vertex, dist(=d[i]))를 순서대로 삽입..
        }

        System.out.println("dijkstra's algorithm으로 계산한 결과는 다음과 같습니다.");
        System.out.println();

        while (!Q.isEmpty(heap)){ // Q의 값이 모두 빠질때 까지.. 하면서 Q의 Node의 dist값도 최신화 시킴..
            Node temp = Q.extract_min(heap); // 가장 작은 heap 값 추출..
            S.add(temp); // 발견된 정점이지만 해당 정점의 값이 최소이기 때문에 Q에서 우선순위로 나온거임
            int s = S.size()-1;
            System.out.println("=========================================================");
            System.out.println("S[" + s + "] : d{" + nodeName[S.get(S.size() - 1).getVertex()] + "] = " + d[S.get(S.size() - 1).getVertex()]);
            System.out.println("---------------------------------------------------------");
            for (int i = 0; i < w.length; i++) {
                if (!(i == temp.getVertex())) { // 자기 자신은 빼고 계산
                    if (d[i] > d[temp.getVertex()] + w[temp.getVertex()][i] && w[temp.getVertex()][i] != INFINITE) { // 현재값보다 계산값이 작다면
                        d[i] = d[temp.getVertex()] + w[temp.getVertex()][i]; // 작은 값 입력
                    }
                }
            }
            for (int i = 0; i < Q.size(heap); i++) { // 우선순위 큐에서 순서 출력
                System.out.print("Q[" + i + "] : " + "d[" + nodeName[Q.get(heap, i).getVertex()] + "] = " + Q.get(heap, i).getDist());
                if (Q.get(heap, i).getDist() != d[Q.get(heap, i).getVertex()]) { // 값이 같지 않다면
                    Q.set_priority(heap, i, d[Q.get(heap, i).getVertex()]); // 우선순위 설정
                    System.out.print(" -> d["
                            + nodeName[Q.get(heap, i).getVertex()] + "] = "
                            + Q.get(heap, i).getDist()); // 경로 출력
                }
                System.out.println("\n");
                Q.Build_Min_Heap(heap);
            }

        }
    }

    public void makeDistance(){
        this.d = new int[w.length];
        d[1] = 0;
        for (int i = 1; i < d.length; i++){
            d[i] = INFINITE;
        }
    }
}
