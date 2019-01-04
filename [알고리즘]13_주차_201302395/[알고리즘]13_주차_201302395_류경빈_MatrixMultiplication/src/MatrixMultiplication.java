import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MatrixMultiplication {
    public static final int INFINITE = Integer.MAX_VALUE;

    public static int[][] s;
    public static int[][] m;

    public static void matrixChainOrder(ArrayList<Integer> p){
        m = new int[p.size()][p.size()];
        s = new int[p.size()][p.size()];
        int n = p.size()-1;
        for (int i = 1; i <= n; i++){
            m[i][i] = 0;
        }
        for (int l = 2; l <= n; l++){
            for (int i = 1; i <= n-l+1; i++){
                int j = i+l-1;
                m[i][j] = INFINITE;
                for (int k = i; k <= j-1; k++){
                    int q = m[i][k] + m[k+1][j] + p.get(i-1) * p.get(k) * p.get(j);
                    if (q < m[i][j]){
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        printData(m, s);
    }

    public static void printData(int[][] m, int[][] s){
        int n = m.length-1;
        System.out.println("-------------------------------------");
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i > j) {
                    m[i][j] = -1;
                    System.out.printf("%6d", m[i][j]);
                }
                else {
                    System.out.printf("%6d", m[i][j]);
                }
            }
            System.out.println();
        }

        System.out.println("-------------------------------------");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= j) {
                    s[i][j] = -1;
                    System.out.printf("%6d", s[i][j]);
                }else {
                    System.out.printf("%6d", s[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("-------------------------------------");
    }

    public static void printOptimalParens(int[][] s, int i , int j){
        if (i == j) {
            System.out.print("A" + (i));
        } else {
            System.out.print("(");
            printOptimalParens(s, i, s[i][j]);
            printOptimalParens(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void printArray(ArrayList arrayList, int num){
        for (int i = 1; i < num-1; i++){
            System.out.println("A(" + i + ")  =\t" + arrayList.get(i-1) + " x " + arrayList.get(i));
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> p = new ArrayList<>();
        int num = 1;
        int input;

        System.out.println("입력을 마칠 경우 0을 입력하세요.");
        while (true){
            System.out.print(num+"번 째 곱할 값 : ");
            input = scanner.nextInt();
            if (input == 0){
                break;
            }
            p.add(input);
            num++;
        }

        System.out.println("-------------------------------------");
        printArray(p, num);
        matrixChainOrder(p);
        System.out.println("Optimal solution : " + m[1][m.length - 1]);
        System.out.print("Optimal parens : ");
        printOptimalParens(s, 1, num-2);

    }
}
