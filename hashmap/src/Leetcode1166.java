import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: Jayden
 * @date:4/21/21 5:56 PM
 */
public class Leetcode1166 {
    public static void main(String[] args) {
        Leetcode1166 test = new Leetcode1166();
        System.out.println(test.createPath("/leet", 1));
        System.out.println(test.createPath("/leet/code", 2));
        System.out.println(test.get("/leet/code"));
        System.out.println(test.createPath("/leet/code", 3));
        System.out.println(test.get("/leet/code"));

    }

    Map<String, Integer> map;

    public Leetcode1166() {
        map = new HashMap<>();
        map.put("", -1);
    }

    public boolean createPath(String path, int value) {
       int index = path.lastIndexOf("/");
       String parent = path.substring(0, index);
       if (!map.containsKey(parent)) return false;
       return map.putIfAbsent(path, value) == null;

    }

    public int get(String path) {
        return map.getOrDefault(path, -1);
    }
}
