import java.util.Arrays;

/**
 * @Description:
 * @author: Jayden
 * @date:3/31/21 11:21 PM
 */
public class Leetcode1465 {
    public static void main(String[] args) {
        System.out.println(maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}));
    }
    //we need to find the max value of height and length
    //so we can compare every interval if we sort the cuts before
    //multiply those two max value and take mod 10e7
    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int m = horizontalCuts.length, n = verticalCuts.length,
                H = Math.max(horizontalCuts[0], h - horizontalCuts[m - 1]),
                V = Math.max(verticalCuts[0], w - verticalCuts[n - 1]);
        for (int i = 1; i < horizontalCuts.length; ++i) {
            H = Math.max(H, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < verticalCuts.length; ++i) {
            V = Math.max(V, verticalCuts[i] - verticalCuts[i - 1]);
        }
        return (int)(H * 1L * V % 1_000_000_007);
    }
}
