import java.util.*;

class AutocompleteSystem {

    Trie root;
    String prefix;
    public AutocompleteSystem(String[] sentences, int[] times) {
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
    class Node{
        String sentence;
        int times;
        Node(String st,int t){
            sentence=st;
            times=t;
        }
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

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */