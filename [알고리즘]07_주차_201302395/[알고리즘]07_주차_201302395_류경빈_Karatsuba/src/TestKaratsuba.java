import java.util.Scanner;

public class TestKaratsuba {

    private static long x;
    private static long y;

    public static void main (String args[]){

        Scanner scanner = new Scanner(System.in);
        Karatsuba karatsuba = new Karatsuba();

        System.out.println("곱셈할 값 두 개를 입력하세요.");
        x = scanner.nextLong();
        y = scanner.nextLong();

        long result = karatsuba.karatsubaMult(x, y);

        System.out.println(result);
    }
}
