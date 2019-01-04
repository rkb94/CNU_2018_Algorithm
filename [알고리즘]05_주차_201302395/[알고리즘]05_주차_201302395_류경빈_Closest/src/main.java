public class main {

    public static void main (String [] args){
        int [] A = {1,2,3,4,5,6,7,8,9,10};
        LoopInvariant loopInvariant = new LoopInvariant(A, 3);
        System.out.println(loopInvariant.doLoopInvariant());
    }

}
