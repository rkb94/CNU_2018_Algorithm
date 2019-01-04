import java.util.ArrayList;


public class SelectionSort {
    private ArrayList<Integer> array;

    public SelectionSort(ArrayList<Integer> array){
        this.array = array;
    }

    public void doSelectionSort(){
        int size = array.size();
        int min;
        int temp;

        for (int i = 0; i < size-1; i++){
            min = i;
            for (int j=i+1; j < size; j++){
                if(array.get(min) > array.get(j)){
                    min = j;
                }
            }
            temp = array.get(min);
            array.set(min, array.get(i));
            array.set(i, temp);
        }
    }

    public void iThinkSelectionSort(){
        int min;

        for (int key = 0; key < array.size()-1; key++){
            min  = key;
            for (int k = key+1; k < array.size(); k++){
                if (array.get(min) > array.get(k)){
                    min = k;
                }
            }
            int temp = array.get(min);
            array.set(min, key);
            array.set(key, temp);
        }
    }

    public ArrayList<Integer> getArray(){
        return this.array;
    }

}
