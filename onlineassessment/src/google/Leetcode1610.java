package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @author: Jayden
 * @date:7/5/21 12:08 PM
 */
public class Leetcode1610 {
    //window
    //转化成 数组形式
    //注意连接  所以 + 360度
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angels = new ArrayList<>();
        int count = 0;
        for (List<Integer> point : points) {
            int x = point.get(0) - location.get(0);
            int y = point.get(1) - location.get(1);
            if (x == 0 && y == 0) {
                count++;
                continue;
            }
            angels.add(Math.atan2(y, x) * 180 / Math.PI);
        }
        Collections.sort(angels);

        List<Double> tmp = new ArrayList<>(angels);
        for (double d : angels) tmp.add(d + 360);
        int res = count;
        for (int i = 0, j = 0; i < tmp.size(); i++) {
            while (tmp.get(i) - tmp.get(j) > angle) {
                j++;
            }
            res = Math.max(res, count + j - i + 1);
        }
        return res;
    }
}
