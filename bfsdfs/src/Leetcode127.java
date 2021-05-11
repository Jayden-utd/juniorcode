import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @author: Jayden
 * @date:5/3/21 1:45 PM
 */
public class Leetcode127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Set<String> start = new HashSet<>();
        Set<String> end = new HashSet<>();
        //we can use contain in O(1) time
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        start.add(beginWord); end.add(endWord);
        int len = 1;
        while (!start.isEmpty() && !end.isEmpty()) {
            if (start.size() > end.size()) {
                Set<String> tmp = start;
                start = end;
                end = tmp;
            }
            Set<String> temp = new HashSet<String>();
            for (String word : start) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = new String(chs);
                        if (end.contains(target)) return len + 1;
                        if (!visited.contains(target) && wordSet.contains(target)) {
                            visited.add(target);
                            temp.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            len++;
            start = temp;
        }
        return 0;
    }
}
