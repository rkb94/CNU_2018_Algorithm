import java.io.*;
import java.util.Arrays;

public class main {

    private static int inversionCount = 0;
    public static void main(String args[]) throws IOException {
        File path = new File("./src/data02.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            String line;
            String[] splitedStr = null;

            while ((line = reader.readLine()) != null) {

                splitedStr = null;
                splitedStr = line.split(",");

                for (int i = 0; i < splitedStr.length; i++) {
                    splitedStr[i] = splitedStr[i].trim();
                }
            }

            reader.close();
            int[] nums = Arrays.stream(splitedStr).mapToInt(Integer::parseInt).toArray();
            int[] mergeSortedArray = mergeSort(nums, 0, nums.length -1);

            System.out.println("Inversion Count : " + inversionCount);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static int[] mergeSort(int[] arr, int l, int r) {
        if(l<r) {
            int mid = (l+r)/2; // mid 계산
            mergeSort(arr, l, mid); // merge left 전반부 정렬
            mergeSort(arr, mid+1, r); // merge right 후반부 정렬
            merge(arr, l, mid, r); // 합 arr의 l 부터 mid 까지, mid+1에서 r 까지
        }
        return arr;
    }
    public static void merge(int arr[], int l, int mid, int r) {
        int i = l;
        int j = mid+1; // merge right 후반부 첫 번째 원소
        int k = l; // temp의 시작점을 뜻
        int temp[] = new int[arr.length];

        while(i<=mid && j<=r) {
            // merge right와 left 배열이 끝날 때 까지를 의미 i값이 mid 값 즉 merge left의 값 끝까지를 뜻함..
            if(arr[i] < arr[j]) {
                // merge left와 right 값을 비교해서 더 작은 값을 가지는 배열의 원소를 temp에 저장한다.
                temp[k++] = arr[i++];
            }else {
                System.out.println("["+ arr[i]+", "+arr[j]+"]");
                temp[k++] = arr[j++];
                inversionCount += mid+1-i;
            }
        }
        // merge left, right 둘 중 하나의 배열의 원소를 모두 탐색했을 경우 넘어간다.
        while(i<=mid) // merge left 배열의 원소들이 남았을 경우
            temp[k++] = arr[i++];
        while(j<=r) // merge right 배열의 원소들이 남았을 경우
            temp[k++] = arr[j++];
        for(int index=l; index<k; index++) {
            arr[index] = temp[index]; // temp 배열을 arr에 복사중..
        }
    }
}