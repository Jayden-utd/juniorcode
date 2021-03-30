package weektest;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @author: Jayden
 * @date:3/27/21 9:40 PM
 */
public class Leetcode5713 {
    public int numDifferentIntegers(String word) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                int num = 0;
                while(i < word.length() && Character.isDigit(word.charAt(i))) {
                    num = num * 10 + word.charAt(i) - '0';
                    i++;
                }
                set.add(num);
                i--;
            }
        }
        return set.size();
    }
}
