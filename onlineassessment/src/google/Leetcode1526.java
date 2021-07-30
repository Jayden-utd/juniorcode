package google;

/**
 * @Description:
 * @author: Jayden
 * @date:7/27/21 2:36 PM
 */
public class Leetcode1526 {
    public int minNumberOperations(int[] target) {
        //Whenever the current element a is bigger than the previous element,
        //we need at lease a - pre operations to make this difference.
        int sumOpe = target[0];
        for (int i = 1; i < target.length; i++) {
            sumOpe += Math.max(0, target[i] - target[i - 1]);
        }
        return sumOpe;
    }
}
