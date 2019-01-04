import java.util.ArrayList;

public class Knapsack {

    private int bagSize;
    private int itemSize;
    private int[][] bag;
    private ArrayList<Item> items;

    public Knapsack(int bagSize, int itemSize) {
        this.bagSize = bagSize;
        this.itemSize = itemSize;
        this.bag = new int[itemSize][bagSize+1];
    }

    public int OPT(int index, int weight) {
        if (index == 0) {
            return 0;
        } else if (items.get(index).getWeight() > weight){ // bagSize의 값 보다 index의 weight가 더 클 경우
            return OPT(index - 1, weight);
        } else {
            return Math.max(OPT(index - 1, weight), items.get(index).getValue()
                    + OPT(index - 1, weight - items.get(index).getWeight()));
        }
    }

    public void insertTable() {
        for (int i = 0; i < itemSize; i++) {
            for (int j = 0; j <= bagSize; j++) {
                bag[i][j] = OPT(i, j);
                System.out.printf("%4d", 1);
            }
            System.out.println();
        }
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void printMaxValueAndPickedItems() {
        ArrayList<Integer> pickedItems = new ArrayList<>();
        System.out.println("Max : " + bag[itemSize-1][bagSize]);
        System.out.print("Items : ");
        int i = itemSize - 1;
        int j = bagSize;
        while (i > 0) {
            if (j < items.get(i).getWeight()) {
                i--;
                continue;
            } else if (bag[i][j] - bag[i - 1][j - items.get(i).getWeight()] == items.get(i).getValue()) {
                pickedItems.add(i);
                j = j - items.get(i).getWeight();
                i--;
                if (j == 0) {
                    break;
                }
            } else {
                i--;
            }
        }
        for (i = pickedItems.size() - 1; i >= 0; i--) {
            System.out.print(pickedItems.get(i) + " ");
        }
    }

}
