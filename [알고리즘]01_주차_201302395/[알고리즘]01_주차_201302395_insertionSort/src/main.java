import java.io.*;
import java.util.Arrays;

public class main {
    public static void main(String args[]) throws IOException {

        File path = new File("./src/data02.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            String line;
            String[] splitedStr = null;

            while( (line = reader.readLine()) != null ) {

                splitedStr = null;
                splitedStr = line.split(",");

                for (int i = 0; i < splitedStr.length; i++) {
                    splitedStr[i] = splitedStr[i].trim();
                }
            }

            reader.close();

            // string 배열을 int형으로 바꿔준다.
            int[] nums_insertion = Arrays.stream(splitedStr).mapToInt(Integer::parseInt).toArray();
            int[] nums_binary = Arrays.stream(splitedStr).mapToInt(Integer::parseInt).toArray();

            long start_insertion = System.nanoTime();

            int[] insertionSortedArray = insertionSort(nums_insertion);

            long end_insertion = System.nanoTime();


            long start_binary = System.nanoTime();

            int[] binaryInsertionSortedArray = binaryInsertionSort(nums_binary);

            long end_binary = System.nanoTime();

            Double time_binary = Double.valueOf(end_binary) - Double.valueOf(start_binary);
            Double time_insertion = Double.valueOf(end_insertion) - Double.valueOf(start_insertion);

            System.out.println("InsertionSort Run Time : " + time_insertion/1000000 + "sec");
            System.out.println("binaryInsertionSort Run Time : " + time_binary/1000000 + "sec");


            makeTxt(binaryInsertionSortedArray, "[알고리즘]01_주차_201302395_binary_insertion.txt");
            makeTxt(insertionSortedArray, "[알고리즘]01_주차_201302395_Insertion.txt");

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }


    public static void printArrays(int[] arr){
        for (int i = 0; i < arr.length; i++){
            if (i==arr.length-1){
                System.out.println(arr[i]);
            }
            else {
                System.out.print(arr[i]+",");
            }
        }
    }

    public static void makeTxt(int[] arr, String fileName) throws IOException {
        String index;
        int num;
        try {
            File file = new File("./src/"+fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < arr.length; i++){
                num = arr[i];
                index = String.valueOf(num);
                if (i == arr.length-1){
                    bufferedWriter.write(index);
                }
                else {
                    bufferedWriter.write(index + ",");
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static int[] insertionSort(int[] A){
        for (int j = 1; j < A.length; j++){
            // 두 번째 원소 부터 시작해서 A.length 까지
            int key = A[j]; // key <- A[j]
            int i = j-1; // i <- j-1

            while (i>=0 && A[i]>key){ // i > 0 and A[i]>key
                A[i+1] = A[i]; // A[i+1] <- A[i]
                i--; // i <- i-1
            }
            A[i+1] = key; // A[i+1] = key

        }
        return A;
    }

    public static int[] binaryInsertionSort(int[] A){
        int key, high, low, mid;
        for (int i = 1; i < A.length; i++){
            key = A[i];
            low = 0;
            high = i-1;

            while (low <= high){
                mid = (low + high)/2;
                if (A[mid] < key){
                    low = mid+1;
                }
                else {
                    high = mid-1;
                }
            }
            for (int j = i-1; j > low-1; j--){
                A[j+1] = A[j];
            }
            A[low] = key;

        }
        return A;
    }
}