package google;

import java.util.*;

/**
 * @Description:
 * @author: Jayden
 * @date:7/6/21 12:13 PM
 */
public class Leetcode126 {
    public static void main(String[] args) {
        Leetcode126 test = new Leetcode126();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        test.findLadders("hit", "cog", wordList);
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) return res;
        Deque<String> path=new LinkedList<>();
        path.addLast(beginWord);
        //bfs得到后继节点列表
        Map<String, Set<String>> successors = new HashMap<>();
        boolean found = bfs(beginWord, endWord, wordSet, successors);
        if (!found) return res;
        dfs(beginWord,endWord,successors,path,res);
        return res;
    }

    public boolean bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> successors) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        // 当前层访问过的结点，当前层全部遍历完成以后，再添加到总的 visited 集合里
        Set<String> nextLevelVisited = new HashSet<>();
        boolean found = false;
        queue.add(beginWord);
        visited.add(beginWord);
        int wordLen = beginWord.length();
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                String currentWord = queue.poll();
                char[] charArray = currentWord.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char originChar=charArray[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k==originChar) continue;;
                        charArray[j]=k;
                        String nextWord=new String(charArray);
                        if (wordSet.contains(nextWord)){
                            if (!visited.contains(nextWord)){
                                if (nextWord.equals(endWord)) found=true;
                                if (!nextLevelVisited.contains(nextWord)){
                                    queue.offer(nextWord);
                                    nextLevelVisited.add(nextWord);
                                }
                                successors.computeIfAbsent(currentWord,a -> new HashSet<>());
                                successors.get(currentWord).add(nextWord);
                            }
                        }
                    }
                    charArray[j]=originChar;
                }
            }
            if (found) break;
            visited.addAll(nextLevelVisited);
            nextLevelVisited.clear();
        }
        return found;
    }
    public void dfs(String beginWord, String endWord,Map<String, Set<String>> successors,Deque<String> path,List<List<String>> res){
        if (beginWord.equals(endWord)){
            res.add(new ArrayList<>(path));
            return;
        }
        if (!successors.containsKey(beginWord)){
            return;
        }
        Set<String> set=successors.get(beginWord);
        for (String nextWord:set){
            path.addLast(nextWord);
            dfs(nextWord,endWord,successors,path,res);
            path.removeLast();
        }
    }
}
