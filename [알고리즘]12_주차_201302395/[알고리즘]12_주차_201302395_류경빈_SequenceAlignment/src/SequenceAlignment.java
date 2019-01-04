public class SequenceAlignment{
    static String[] x;
    static String[] y;

    static int lx;
    static int ly;

    static final int q = -2; // mismatch penalty
    static int[][] p;
    static int[][] a;
    static int[][] directionArrow;
    static int[][] doubleLinkedArrow;
    static int count = 0;

    public static void main(String[] args){
        SequenceAlignment sequenceAlignment = new SequenceAlignment();
//        sequenceAlignment.sequenceAlignment("GAACG", "GACT");
        sequenceAlignment.sequenceAlignment("actgagttaa", "acagaagta");
    }

    public void sequenceAlignment(String X, String Y){
        lx = X.length() + 1; // 공백 추가
        ly = Y.length() + 1; // 공백 추가
        p = new int[ly][lx];
        a = new int[ly][lx];
        x = new String[lx];
        y = new String[ly];
        directionArrow = new int[ly][lx]; // 화살표 방향
        doubleLinkedArrow = new int[ly][lx]; // 화살표가 두 개 있을 경우
        x[0] = ""; // 첫 번째 공백
        y[0] = ""; // 첫 번째 공백

        // 입력 값 배열 저장
        for (int i = 1; i < lx; i++){
            x[i] = X.substring(i-1, i);
        }
        for (int i = 1; i < ly; i++){
            y[i] = Y.substring(i-1, i);
        }

        // (char) 45 == "-"
        // a배열에 "-" 모두 입력
        for (int i = 0; i < lx; i++){
            for (int j = 0; j < ly; j++){
                a[j][i] = 45;
            }
        }

        // 가로 세로 첫 번째 줄 배열에 초기 값 입력
        for (int i = 0; i < lx; i++){
            a[0][i] = i*q;
        }
        for (int j = 0; j < ly; j++){
            a[j][0] = j*q;
        }

        // p 배열 생성
        makeP(lx, ly);
        for (int i = 1; i < ly; i++) {
            for (int j = 1; j < lx; j++) {
                p[i][j] = x[j].equals(y[i]) ? 1 : -1;
            }
        }

        for (int i = 1; i < ly; i++){
            for (int j = 1; j < lx; j++){
                int maxValue =
                        MAX(    a[i][j-1] + q,
                                a[i-1][j-1] + p[i][j],
                                a[i-1][j] + q   );
                a[i][j] = maxValue;

                System.out.println(++count + "번째 과정\n");

                for (int l = 0; l < ly; l++){
                    for (int t = 0; t < lx; t++){
                        if (a[l][t] == 45) {
                            System.out.printf("%4c", (char) a[l][t]);
                        } else {
                            System.out.printf("%4d", a[l][t]);
                        }
                    }
                    System.out.println();
                }
                System.out.println();

                if (maxValue == a[i][j - 1] + q) {
                    directionArrow[i][j] = 0;

                    if (maxValue == a[i - 1][j - 1] + p[i][j]) {
                        doubleLinkedArrow[i][j] = 1;
                    } else if (maxValue == a[i - 1][j] + q) {
                        doubleLinkedArrow[i][j] = 2;
                    }
                } else if (maxValue == a[i - 1][j - 1] + p[i][j]) {
                    directionArrow[i][j] = 1;
                    if (maxValue == a[i - 1][j] + q) {
                        doubleLinkedArrow[i][j] = 2;
                    }
                } else {
                    directionArrow[i][j] = 2;
                }
            }
        }

        while (true){
            int count = 0;
            StringBuffer stringBuffer = new StringBuffer();

            System.out.print("첫 번째 입력 값 : ");
            for (int i = 1; i < lx; i++){
                System.out.print(x[i]);
            }
            System.out.println();
            System.out.print("두 번째 입력 값 : ");
            int tempX = ly - 1;
            int tempY = lx - 1;

            while (tempX > 0 && tempY > 0) {
                if (directionArrow[tempX][tempY] == 0) {
                    stringBuffer.append("-");
                    if (doubleLinkedArrow[tempX][tempY] != 0) {
                        directionArrow[tempX][tempY] = doubleLinkedArrow[tempX][tempY];
                        doubleLinkedArrow[tempX][tempY] = 0;
                        count++;
                    }
                    tempY--;
                } else if (directionArrow[tempX][tempY] == 1) {
                    stringBuffer.append(y[tempX]);
                    if (doubleLinkedArrow[tempX][tempY] != 0) {
                        directionArrow[tempX][tempY] = doubleLinkedArrow[tempX][tempY];
                        doubleLinkedArrow[tempX][tempY] = 0;
                        count++;
                    }
                    tempX--;
                    tempY--;
                } else if (directionArrow[tempX][tempY] == 2) {
                    stringBuffer.append(y[tempX]);
                    if (doubleLinkedArrow[tempX][tempY] != 0) {
                        directionArrow[tempX][tempY] = doubleLinkedArrow[tempX][tempY];
                        doubleLinkedArrow[tempX][tempY] = 0;
                        count++;
                    }
                    tempX--;
                }
            }
            System.out.println(stringBuffer.reverse());
            System.out.println("점수 : " + a[tempY+1][tempX+1] + "\n");
            if (count == 0) {
                break;
            }
            count--;
        }

    }

    // p 배열 만들기
    public void makeP(int lengthX, int lengthY){
        for (int i = 1; i < lengthY; i++) {
            for (int j = 1; j < lengthX; j++) {
                if (x[j].equals(y[i])){
                    p[i][j] = 1;
                }else {
                    p[i][j] = -1;
                }
            }
        }
    }

    private int MAX(int number1, int number2, int number3) {
        if(number1 >= number2 && number1 >= number3){
            return number1;
        }
        else if(number2 >= number1 && number2 >= number3){
            return number2;
        }
        else {
            return number3;
        }
    }
}