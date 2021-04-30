package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * @author: Jayden
 * @date:4/26/21 6:31 PM
 */
public class PrimeAir {
    public static List<List<Integer>> getPairs(List<List<Integer>> a, List<List<Integer>> b, int target) {
        // WRITE YOUR BRILLIANT CODE HERE
        Comparator<List<Integer>> cmp = Comparator.comparing(p -> p.get(1));
        Collections.sort(a, cmp);
        Collections.sort(b, cmp.reversed());
        int maxSum = Integer.MIN_VALUE;
        ArrayList<List<Integer>> maxPairs = new ArrayList<>();
        for (int i = 0, j = 0; i < a.size() && j < b.size();) {
            List<Integer> x = a.get(i);
            List<Integer> y = b.get(j);
            int curSum = x.get(1) + y.get(1);
            if (curSum > target) {
                j++;
                continue;
            }
            if (curSum > maxSum) {
                maxSum = curSum;
                maxPairs.clear();
            }
            for (int k = j; k < b.size(); k++) {
                List<Integer> z = b.get(k);
                if (!z.get(1).equals(y.get(1)))
                    break;
                maxPairs.add(List.of(x.get(0), z.get(0)));
            }
            i++;
        }
        return maxPairs;
    }
}
