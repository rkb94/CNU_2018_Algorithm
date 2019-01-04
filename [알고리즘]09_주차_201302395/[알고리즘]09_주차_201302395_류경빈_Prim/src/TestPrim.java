public class TestPrim {

    public static void main (String args[]){
        int[][] w = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0}, // a
                {4, 0, 8, 0, 0, 0, 0, 11, 0}, // b
                {0, 8, 0, 7, 0, 4, 0, 0, 2}, // c
                {0, 0, 7, 0, 9, 14, 0, 0, 0}, // d
                {0, 0, 0, 9, 0, 10, 0, 0, 0}, // e
                {0, 0, 4, 14, 10, 0, 2, 0, 0}, // f
                {0, 0, 0, 0, 0, 2, 0, 1, 6}, //g
                {8, 11, 0, 0, 0, 0, 1, 0, 7}, // h
                {0, 0, 2, 0, 0, 0, 6, 7, 0} // i
        };

        Prim prim = new Prim(w.length);
        prim.shortestPath(w, 0);
    }
}
