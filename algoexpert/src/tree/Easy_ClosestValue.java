package tree;

import java.util.*;

/**
 * @Description:
 * @author: Jayden
 * @date:5/26/21 11:51 AM
 */
public class Easy_ClosestValue {
    public static void main(String[] args) {

    }

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Write your code here.
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        int sum = 0;
        if (fastest) {
            for (int i = 0; i < redShirtSpeeds.length; i++) {
                sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[blueShirtSpeeds.length - i - 1]);
            }

        } else {
            for (int i = 0; i < redShirtSpeeds.length; i++) {
                sum += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            }
        }

        return sum;
    }


}
