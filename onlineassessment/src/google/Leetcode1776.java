package google;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 * @author: Jayden
 * @date:7/5/21 4:50 PM
 */
public class Leetcode1776 {
    public static void main(String[] args) {
        getCollisionTimes(new int[][]{{3,4},{5,9},{6,8},{9,6}});
        System.out.println(true || false && false);
    }
    public static double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        Deque<Integer> stack = new LinkedList<>();
        double[] res = new double[n];
        for (int i = n - 1; i >= 0; --i) {
            res[i] = -1.0;
            int p = cars[i][0], s = cars[i][1];
            while (stack.size() > 0) {
                int j = stack.peekLast(), p2 = cars[j][0], s2 = cars[j][1];
                if (s <= s2 || 1.0 * (p2 - p) / (s - s2) >= res[j] && res[j] > 0)
                    stack.pollLast();
                else
                    break;
            }
            if (stack.size() > 0) {
                int j = stack.peekLast(), p2 = cars[j][0], s2 = cars[j][1];
                res[i] = 1.0 * (p2 - p) / (s - s2);
            }
            stack.add(i);
        }
        return res;




    }
}
