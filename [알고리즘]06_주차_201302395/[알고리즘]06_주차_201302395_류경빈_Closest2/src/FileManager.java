import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileManager{

    public FileManager() {
    }

    public ArrayList<Point> readFile() throws IOException {
        Scanner scanner = new Scanner(new File("./src/data05.txt"));
        ArrayList<Point> inputArray = new ArrayList<Point>();

        while(scanner.hasNext()) {
            StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine(), ",");

            while(stringTokenizer.hasMoreTokens()) {
                inputArray.add(new Point(Double.parseDouble(stringTokenizer.nextToken()), Double.parseDouble(stringTokenizer.nextToken())));
            }
        }
        scanner.close();
        return inputArray;
    }

}