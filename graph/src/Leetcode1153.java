import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Description:
 * @author: Jayden
 * @date:2/26/21 5:04 PM
 */
public class Leetcode1153 {
    public static void main(String[] args) {
        Leetcode1153 test = new Leetcode1153();

        System.out.println(test.canConvert("ab", "ba"));
    }
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            }
            map.put(c1, c2);
        }
        //必须是values  要有其他的 字母可以用
        return new HashSet<Character>(map.keySet()).size() < 26;

    }
}
