import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: Jayden
 * @date:5/11/21 7:31 PM
 */

/*
* 1， 1， 10， 0.3
2， 2， 13， 0.5
3， 1， 14， 0.8
4， 2， 15， 0.1
5， 2， 17， 0.5
6， 2， 18， 0.9
7， 1， 20， 0.3
8， 1， 22， 0.5
9， 2， 24， 0.7
10，1，25， 0.6

*
* */
public class FilePair_Amazon {
    public static void main(String[] args) {
        FilePair_Amazon test = new FilePair_Amazon();

        double[][] file = new double[][]{{1,1,10,0.3},{2,2,13,0.5},{3,1,14,0.8},{4,2,15,0.1},{5,2,17,0.5},{6,2,18,0.9},
                {7,1,20,0.3},{8,1,22,0.5},{9,2,24,0.7},{10,1,25,0.6}};
        List<double[]> res = test.pair(file);
        System.out.println(res.size());
        for (double[] c : res) {
            System.out.println(c[0] + "  " + c[1]);
        }

    }

    public List<double[]> pair(double[][] file) {
        List<double[]> res = new LinkedList<>();
        Map<Double, List<double[]>> map = new HashMap<>();
        for (double[] row : file) {
            if (row[3] > 0.5) {
                if (!map.containsKey(row[1])) {
                    map.put(row[1], new LinkedList<>());
                    map.get(row[1]).add(new double[]{row[0], row[3]});
                } else {
                    List<double[]> tmp = map.get(row[1]);
                    for (int i = tmp.size() - 1; i >= 0; i--) {
                        if (tmp.get(i)[1] < 0.5) {
                            res.add(new double[]{tmp.get(i)[0], row[0]});
                            tmp.remove(i);
                            break;
                        }
                    }
                }
            } else {
                if (!map.containsKey(row[1])) {
                    map.put(row[1], new LinkedList<>());
                }
                map.get(row[1]).add(new double[]{row[0], row[3]});
            }
        }
        return res;
    }
}
