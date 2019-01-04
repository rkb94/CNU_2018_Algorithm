import java.util.ArrayList;

public class BubbleSort {
    private ArrayList<Integer> array;

    public BubbleSort(ArrayList<Integer> array){
        this.array = array;
    }

    public void doBubbleSort(){
        int temp = 0;
        for (int i = array.size()-1; i>=0; i--){
            for (int j=0; j<i; j++){
                if (array.get(j) > array.get(j+1)){
                    temp = array.get(j);
                    array.set(j, array.get(j+1));
                    array.set(j+1, temp);
                }
            }
        }
    }

    public void iThinkBubbleSort(){
        int temp;
        for (int max = array.size()-1; max>=0; max--){
            for (int currentIndex = 0; currentIndex < max; currentIndex++){
                if (array.get(currentIndex) > array.get(currentIndex+1)){
                    temp = array.get(currentIndex);
                    array.set(currentIndex, array.get(currentIndex+1));
                    array.set(currentIndex+1, temp);
                }
            }
        }
    }

    public ArrayList<Integer> getArray(){
        return this.array;
    }

}

