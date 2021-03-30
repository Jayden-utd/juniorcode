package weektest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: Jayden
 * @date:3/27/21 10:13 PM
 */
public class Leetcode1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> know : knowledge) {
            map.put(know.get(0), know.get(1));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int next = i;
                while (s.charAt(next) != ')') next++;
                String key = s.substring(i + 1, next);
                if (map.containsKey(key)) {
                    sb.append(map.get(key));
                } else {
                    sb.append("?");
                }
                i = next;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }
}
