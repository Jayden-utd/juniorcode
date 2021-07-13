package google;

import java.util.*;

/**
 * @Description:
 * @author: Jayden
 * @date:7/8/21 3:53 PM
 */
public class Leetcode642 {
    public static void main(String[] args) {
        String[] sentences = new String[]{"i love you", "i love leetcode"};
        int[] times = new int[]{2,4};
        Leetcode642 test = new Leetcode642(sentences, times);


    }
    Trie root;
    String prefix;
    public Leetcode642(String[] sentences, int[] times) {
        root = new Trie();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }
    private void add(String s, int count) {
        Trie curr = root;
        for (char c : s.toCharArray()) {
            Trie next = curr.children.get(c);
            if (next == null) {
                next = new Trie();
                curr.children.put(c, next);
            }
            curr = next;
            curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
        }
        curr.isWord = true;
    }

    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }
        prefix += c;
        Trie curr = root;
        for (char cc : prefix.toCharArray()) {
            Trie next = curr.children.get(cc);
            if (next == null) {
                return new ArrayList<String>();
            }
            curr = next;
        }
        Trie finalCurr = curr;
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (finalCurr.counts.get(a).equals(finalCurr.counts.get(b)) ? a.compareTo(b) : finalCurr.counts.get(b) - finalCurr.counts.get(a)));
        for (String s : curr.counts.keySet()) {
            pq.add(s);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            res.add(pq.poll());
        }
        return res;
    }

    class Trie{
        Map<Character, Trie> children;
        Map<String, Integer> counts;
        boolean isWord;
        public Trie() {
            children = new HashMap<Character, Trie>();
            counts = new HashMap<String, Integer>();
            isWord = false;
        }
    }
}
