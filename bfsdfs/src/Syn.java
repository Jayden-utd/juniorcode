/*
 If a is a synonym of b and b is a synonym of c, this implies that a is a synonym of c and c is a synonym of a
input:
-> "advice:counsel counsel:suggestion suggestion:advice activity:briskness briskness:liveliness"
-> "advice"
List<List<String>>


In this example, advice, counsel, suggestion are all synonyms of each other, while advice is not a synonym of activity.

Problem: Given an input data in the format above and a word, write a program to find out all the synonyms of that word.
 */

import java.util.*;

class Syn {
    public static void main(String[] args) {
        //graph, connected components, disjoint graphs
        String input = "advice:counsel counsel:suggestion suggestion:advice activity:briskness briskness:liveliness";
        String intput2 = "advice:counsel advice:help";
        String input3 = "a:b c:b d:b";
        String input4 = "a:b c:b d:b";  String word4 = "a";
        String word = "advice";
        //System.out.println("run");
        Set<String> res = findSyn(input3, word4);
        for(String tmp : res) {
            System.out.print(tmp + " ");
        }
    }
    public static Set<String> findSyn (String input, String word) {
        Map<String, Set<String>> map = new HashMap<>();
        //mark the relationship
        String[] rel = input.split(" ");  //pairs
        if(rel.length == 0) {
            return new HashSet<>();
        }
        //refactor, better unit testing, better readability
        for(int i = 0; i < rel.length; i++) {  //for (String str : rel)
            String[] tmp = rel[i].split(":"); //wordList
            map.putIfAbsent(tmp[0], new HashSet<>());
            map.putIfAbsent(tmp[1], new HashSet<>());
            map.get(tmp[0]).add(tmp[1]);
            map.get(tmp[1]).add(tmp[0]);
        }
        Set<String> res = new HashSet<>();
        //dpeth first search
        Set<String> set = new HashSet<>();
        dfs(word, map, set, res);
        //note: we don't want input word in the output res
        res.remove(word);  //O(1)

//     for(Map.Entry<String, List<String>> tmp : map.entrySet) {
//        List<String> list = new LinkedList<>();
//        list = dfs(tmp.getKey(), map, set, list, res);
//        if(list.size() > 0) res.add(list);
//     }
        return res;
    }
    //
    public static void dfs(String cur, Map<String, Set<String>> map, Set<String> set, Set<String> res) {
        //end condition
        if(set.contains(cur)) {
            return;
        }
        set.add(cur);
        res.add(cur); //redundant
        Set<String> next = map.get(cur);
        for(String s : next) {
            dfs(s, map, set, res);
        }
    }
}