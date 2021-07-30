package google;

import java.util.*;

/**
 * @Description:
 * @author: Jayden
 * @date:7/16/21 12:57 PM
 */
public class Leetcode1048 {
    public List<String> longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();
        Arrays.sort(words, (a, b)->a.length() - b.length());
        int res = 0;
        List<String> result = new ArrayList<>();

        for (String word : words) {
            int best = 0;
            String bestPre = "";
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                if (dp.getOrDefault(prev,0) + 1 > best) {
                    best = dp.getOrDefault(prev, 0) + 1;
                    bestPre = prev;
                }
                //best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            if (map.get(bestPre) != null) {
                List<String> list = new ArrayList<>();
                for (String s : map.get(bestPre))    {
                    list.add(s);
                }
                list.add(word);
                map.put(word, list);
            } else{
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(word, list);
            }

            if (best > res) {
                res = best;
                result = map.get(word);
            }
        }
        return result;
    }
}
