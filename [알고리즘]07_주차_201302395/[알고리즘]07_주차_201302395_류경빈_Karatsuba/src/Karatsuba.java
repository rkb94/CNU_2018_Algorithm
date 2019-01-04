import java.util.Scanner;

public class Karatsuba {

    private static final int THRESHOLD = 3;

    private static long result = 0;

    public Karatsuba(){}

    public int howLongNumber (long number){
        return (int)((Math.log10(number)+1));
    }

    public int midNumber (long length){
        return (int)(Math.pow(10,(length/2)));
    }

    public long divisionNumber (long number, int divider){
        return number/divider;
    }

    public long remainderNumber (long number, int divider){
        return number%divider;
    }

    public long karatsubaMult (long numX, long numY){

        int x = howLongNumber(numX);
        int y = howLongNumber(numY);
        int d = x < y ? x : y;

        if (numX < numY){
            return karatsubaMult(numY, numX);
        }
        else if (x == 0 || y == 0){
            return 0;
        }
        else if (d <= THRESHOLD){
            return numX*numY;
        }

        int mid = midNumber(d);

        long x1 = divisionNumber(numX, mid);
        long x0 = remainderNumber(numX, mid);

        long y1 = divisionNumber(numY, mid);
        long y0 = remainderNumber(numY, mid);

        long z2 = this.karatsubaMult(x1, y1);
        long z0 = this.karatsubaMult(x0, y0);
        long z1 = this.karatsubaMult((x0+x1), (y0+y1))-z2-z0;

        long result = (long) (z2*(Math.pow(mid,2))+z1*mid+z0);
        return result;
    }
}
