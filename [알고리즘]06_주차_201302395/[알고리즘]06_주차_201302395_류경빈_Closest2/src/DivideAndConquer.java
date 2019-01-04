import java.util.ArrayList;
import java.util.Comparator;

public class DivideAndConquer {
    public double divideAndConquer(ArrayList<Point> arrayList){
        arrayList.sort(Comparator.comparing(Point::getX));

        if (arrayList.size() <= 3){
            double min = distanceXY(arrayList.get(0), arrayList.get(1));
            for (int i = 0; i < arrayList.size(); i++){
                for (int j = i+1; j < arrayList.size(); j++){
                    double temp = distanceXY(arrayList.get(i), arrayList.get(j));
                    if (min > temp){
                        min  = temp;
                    }
                }
            }
            return min;
        }
        double first = divideAndConquer(new ArrayList<>(arrayList.subList(0, arrayList.size()/2)));
        double second = divideAndConquer(new ArrayList<>(arrayList.subList(arrayList.size()/2, arrayList.size())));
        double min = (first < second) ? first : second;

        ArrayList<Point> reduce = new ArrayList<>();
        Point mid = arrayList.get(arrayList.size()/2);
        for (int i = 0; i < arrayList.size(); i++) {
            if (Math.abs(arrayList.get(i).getX() - mid.getX()) < min) {
                reduce.add(arrayList.get(i));
            }
        }

        reduce.sort(Comparator.comparing(Point::getY));

        for (int i = 0; i < reduce.size(); i++) {
            for (int j = i + 1; j < reduce.size(); j++) {
                if (Math.abs(reduce.get(j).getY() - reduce.get(i).getY()) < min) {
                    double temp = distanceXY(reduce.get(i), reduce.get(j));
                    if (min > temp) {
                        min = temp;
                    }
                }
            }
        }

        return min;
    }

    private double distanceXY(Point x, Point y){
        return Math.sqrt(Math.pow((y.getX() - x.getX()),2) + Math.pow((y.getY() - x.getX()), 2));
    }
}
