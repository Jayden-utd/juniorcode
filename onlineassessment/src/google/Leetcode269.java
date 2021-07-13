package google;

import java.util.*;

/**
 * @Description:
 * @author: Jayden
 * @date:7/7/21 3:19 PM
 */
public class Leetcode269 {
    public static void main(String[] args) {
        Leetcode269 test = new Leetcode269();
        test.alienOrder(new String[]{"abc", "ab"});
    }
    public String alienOrder(String[] words) {
        // Step 0: Create data structures and find all unique letters.
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }

        // Step 1: Find all edges.
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) return "";
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)){
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    counts.put(word2.charAt(j), counts.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        // Step 2: Breadth-first search.
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (char c : counts.keySet()){
            if (counts.get(c).equals(0)) queue.add(c);
        }
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            sb.append(c);
            for (char next : adjList.get(c)){
                counts.put(next, counts.get(next) - 1);
                if (counts.get(next).equals(0)) {
                    queue.add(next);
                }
            }
        }
        if (sb.length() < counts.size()) {
            return "";
        }
        return sb.toString();
    }
}
