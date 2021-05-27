package array;

import java.util.*;

/**
 * @Description:
 * @author: Jayden
 * @date:5/25/21 11:02 AM
 */
public class Easy_ValidateSubsequence {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int arrIdx = 0, seqIdx = 0;
        while (arrIdx < array.size() && seqIdx < sequence.size()) {
            if (array.get(arrIdx).equals(sequence.get(seqIdx))) {
                seqIdx++;
            }
            arrIdx++;
        }
        return seqIdx == sequence.size();
    }

    public int nonConstructibleChange(int[] coins) {
        // Write your code here.
        Arrays.sort(coins);
        int currentChanged = 0;
        for(int coin : coins) {
            if (coin > currentChanged + 1) {
                return currentChanged + 1;
            }
            currentChanged += coin;
        }
        return currentChanged + 1;

    }
}
