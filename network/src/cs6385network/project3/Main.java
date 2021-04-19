package cs6385network.project3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    //Given at least 5 examples; so lets take 6 examples here
    private static int numberOfExamples = 6;

    //Take n random points in the plane; n >= 15; lets take n = 18 here
    private static int n = 18;
    public static int x, y;
    public static long Algo1Time1, Algo1Time2, Algo2Time1, Algo2Time2;

    public static void main(String[] args) throws IOException {
        for (int ex = 0; ex < numberOfExamples; ex++) {
            System.out.println("Experiment Number: " + (ex + 1) + " starts here:");
            HashMap<Integer, Point> points = new HashMap<Integer, Point>();
            Set<Integer> set = new TreeSet<>();
            //Creates n number of points on a plane by generating x and y coordinates from 0-100
            int numPoints = 0;
            System.out.println("The " + ex + " experiment");
            while (set.size() < 18) {
                x = (int) (Math.random() * (100));
                y = (int) (Math.random() * (100));
                if (!set.contains(x * 10 + y)) {
                    points.put(numPoints++, new Point(x, y));
                    set.add(x * 10 + y);
                    System.out.println("x :" + x + " " + "y :" + y);
                }
            }

            //run Constructive Heuristic Algorithm
            Algo2Time1 = System.currentTimeMillis();
            Algorithm1_Constructive.init(n, points, ex);
            Algo2Time2 = System.currentTimeMillis();
            System.out.println("The running time of Constructive Heuristic Algorithm: " + (Algo2Time2 - Algo2Time1) + " ms");

            //Running the Local Search Heuristic Algorithm
            Algo1Time1 = System.currentTimeMillis();
            Algorithm2_LocalSearch.init(n, points, ex);
            Algo1Time2 = System.currentTimeMillis();
            System.out.println("The running time of Local Search Heuristic Algorithm: " + (Algo1Time2 - Algo1Time1) + " ms");

            System.out.println("Experiment Number: " + (ex + 1) + " ends here!");
            System.out.println("                ");
        }
    }

}
