package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @author: Jayden
 * @date:7/1/21 11:32 AM
 */
public class Leetcode528 {
    int total;
    List<Integer> list;
    public Leetcode528(int[] w) {
        list = new ArrayList<>();
        total = 0;
        for (int s : w) {
            total += s;
            list.add(total);
        }
    }

    public int pickIndex() {
        Random random = new Random();
        int rand = random.nextInt(total);
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= rand) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return left;
    }
}
