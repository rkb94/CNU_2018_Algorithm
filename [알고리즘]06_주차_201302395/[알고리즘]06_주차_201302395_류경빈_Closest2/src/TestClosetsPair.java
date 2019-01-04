import java.io.IOException;
import java.util.ArrayList;

public class TestClosetsPair extends ArrayList<Point> {

    public static void main(String[] args) throws IOException{
        FileManager fileManager = new FileManager();
        DivideAndConquer divideAndConquer = new DivideAndConquer();
        double result = divideAndConquer.divideAndConquer(fileManager.readFile());
        System.out.println(result);
    }
}
