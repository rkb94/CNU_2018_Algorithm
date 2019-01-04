import java.io.IOException;
import java.util.ArrayList;

public class SortingTest {
    public static void main(String[] args) throws IOException{
        FileManager fileManager_Sel = new FileManager("data04.txt", "data04_Sort_Sel.txt");
        FileManager fileManager_Bub = new FileManager("data04.txt", "data04_Sort_Bub.txt");
        SelectionSort selectionSort = new SelectionSort(fileManager_Sel.readFile());
        BubbleSort bubbleSort = new BubbleSort(fileManager_Bub.readFile());

        selectionSort.doSelectionSort();
        bubbleSort.doBubbleSort();
        fileManager_Sel.writeFile(selectionSort.getArray());
        fileManager_Bub.writeFile(bubbleSort.getArray());

    }

}
