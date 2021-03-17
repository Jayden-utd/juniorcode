import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description:
 * @author: Jayden
 * @date:3/8/21 4:23 PM
 */
public class Leetcode71 {
    public String simplifyPath(String path) {
        String[] str = path.split("/+");
        Deque<String> stack = new ArrayDeque<>();
        for (String tmp : str) {
            if (tmp.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!tmp.equals(".") && !tmp.equals("") && !tmp.equals("..")){
                stack.push(tmp);
            }
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }
}
