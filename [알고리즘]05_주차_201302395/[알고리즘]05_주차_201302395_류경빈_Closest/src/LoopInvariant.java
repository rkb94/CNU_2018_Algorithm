public class LoopInvariant {

    private int [] array;
    private int key;

    public LoopInvariant(int [] array, int key){
        this.array = array;
        this.key = key;
    }

    public int doLoopInvariant(){
        int mid;
        int low = 0;
        int high = array.length-1;

        // <Initialization>
        // Loop Invariant : low < high 성립
        // Loop Invariant : A[low] < key < A[high] 성립
        while (high >= low){
            // <Maintenance>
            // Loop Invariant : low < high 성립
            // Loop Invariant : A[low] < key < A[high] 성립
            mid = (high + low)/2;

            if (key == array[mid]){
                return mid;
            }
            else if (key < array[mid]){
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        // <Termination>
        // Loop Invariant : low < high 성립
        // Loop Invariant : A[low] < key < A[high] 성립
        return -(low+1);
    }
}
