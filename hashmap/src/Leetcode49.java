import java.util.*;

/**
 * @Description:
 * @author: Jayden
 * @date:3/17/21 6:48 PM
 */
public class Leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String value = new String(tmp);
            if (!map.containsKey(value)) {
                map.put(value, new ArrayList<>());
            }
            map.get(value).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
