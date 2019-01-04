import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileManager {
    private String inputFileName;
    private String outputFileName;

    public FileManager(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    public ArrayList<Integer> readFile() throws IOException {
        Scanner scanner = new Scanner(new File("./src/data04.txt"));
        ArrayList<Integer> inputArray = new ArrayList<>();

        while(scanner.hasNext()) {
            StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine(), ",");
            while(stringTokenizer.hasMoreTokens()) {
                inputArray.add(Integer.parseInt(stringTokenizer.nextToken()));
            }
        }
        scanner.close();
        return inputArray;
    }

    public void writeFile(ArrayList<Integer> outputArray) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File("./src/" + this.outputFileName));
        fileOutputStream.close();
        FileWriter fileWriter = new FileWriter(new File("./src/" + this.outputFileName));
        StringBuilder stringBuilder = new StringBuilder();
        while(!outputArray.isEmpty()) {
            stringBuilder.append(outputArray.remove(0));
            stringBuilder.append(",");
        }
        fileWriter.write(stringBuilder.deleteCharAt(stringBuilder.length()-1).toString());
        fileWriter.close();
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }
}