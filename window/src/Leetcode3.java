import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @author: Jayden
 * @date:3/17/21 3:47 PM
 */
public class Leetcode3 {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                //set size is the length
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return res;
    }
}
