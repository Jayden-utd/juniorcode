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
        double[] res = getCollisionTimes(new int[][]{{5,4},{8,3},{9,1}});
        for (double i : res) {
            System.out.println(i);
        }
        System.out.println((true || false) && false);
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
    //保持追到的速度 严格递减 从 last index 往前
    //
    public double[] getCollisionTimesSecond(int[][] cars) {
        int n = cars.length;
        double[] res = new double[n];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            res[i] = -1;
            int p = cars[i][0];
            int s = cars[i][1];
            while (!deque.isEmpty() && (s <= cars[deque.peekLast()][1] || 1.0 * (cars[deque.peekLast()][0] - p) / (s - cars[deque.peekLast()][1]) >= res[deque.peekLast()] && res[deque.peekLast()] > 0)) {
                deque.pollLast();
            }
            if (!deque.isEmpty()) {
                //calculate
                int j = deque.peekLast(), p2 = cars[j][0], s2 = cars[j][1];
                res[i] = 1.0 * (p2 - p) / (s - s2);
            }
            deque.add(i);
        }
        return res;


    }
}
