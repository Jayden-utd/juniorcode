import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: Jayden
 * @date:5/1/21 11:01 PM
 */
public class Leetcode745 {
    Map<String, Integer> map = new HashMap<>();

    public Leetcode745(String[] words) {
        for (int w = 0; w < words.length; w++) {
            for (int i = 0; i <= 10 && i <= words[w].length(); i++) {
                for (int j = 0; j <= 10 && j <= words[w].length(); j++) {
                    map.put(words[w].substring(0, i) + "#" + words[w].substring(words[w].length() - j), w);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        return map.getOrDefault(prefix + "#" + suffix, -1);
    }


//    Map<String, Integer> map;
//    TrieNode root;
//    int ans = -1;
//
//    public Leetcode745(String[] words) {
//        root = new TrieNode();
//        map = new HashMap<>();
//        root = new TrieNode();
//        for (int i = 0; i < words.length; i++) {
//            map.put(words[i], i);
//            add(words[i], root);
//        }
//    }
//
//    public void add(String word, TrieNode node) {
//        char[] wordc = word.toCharArray();
//        for (int i = 0; i < word.length(); i++) {
//            int c = wordc[i] - 'a';
//            if (node.children[c] == null) node.children[c] = new TrieNode();
//            node = node.children[c];
//        }
//        node.word = word;
//    }
//
//    public int f(String prefix, String suffix) {
//        TrieNode node=find(root,prefix);
//        if(node==null) return -1;
//        ans=-1;
//        findf(node,suffix,suffix.length());
//        return ans;
//    }
//
//    public TrieNode find(TrieNode node, String prefix){
//        for(int i=0;i<prefix.length();i++){
//            int c=prefix.charAt(i)-'a';
//            if(node.children[c]==null) return null;
//            node=node.children[c];
//        }
//        return node;
//    }
//
//    public void findf(TrieNode node,String suffix,int len){
//        if(node.word!=null){
//            int start= node.word.length()-len;
//            if(start>=0 && node.word.substring(start).equals(suffix)){
//                if(map.get(node.word)>ans) ans=map.get(node.word);
//            }
//        }
//        for(int i=0;i<26;i++){
//            if(node.children[i]!=null) findf(node.children[i],suffix,len);
//        }
//    }
//
//    class TrieNode {
//        String word;
//        TrieNode[] children;
//
//        TrieNode() {
//            word = null;
//            children = new TrieNode[26];
//        }
//    }
}
