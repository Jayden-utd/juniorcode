package google;

/**
 * @Description:
 * @author: Jayden
 * @date:8/8/21 6:10 PM
 */
public class Leetcode1423 {

    //convert the problem to calculate the min

    public int maxScore(int[] cardPoints, int k) {
        int min = Integer.MAX_VALUE;
        int windowLen = cardPoints.length - k;
        int l = 0;
        int r = 0;
        int total = 0;
        int cur = 0;
        for (; r < cardPoints.length; r++) {
            total += cardPoints[r];
            cur += cardPoints[r];
            if (r - l + 1 == windowLen) {
                min = Math.min(min, cur);
                cur -= cardPoints[l++];
            }
        }
        return total - (min == Integer.MAX_VALUE ? 0 : min);
    }
}
