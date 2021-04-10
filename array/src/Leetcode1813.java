/**
 * @Description:
 * @author: Jayden
 * @date:4/3/21 3:24 PM
 */
public class Leetcode1813 {
    //这个题 避免了 if else
    //这道题只能一边全部insert
    //if 碰到不相等的单词，直接跳过 n - m，认为这是要插入的句子，然后再接着compare
    //最后判断 是否遍历完短的那个string字符串
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        int m = s1.length, n = s2.length;
        if (m > n) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        int i = 0;
        while (i < m && s1[i].equals(s2[i])) {
            i++;
        }
        while (i < m && s1[i].equals(s2[n - m + i])) {
            i++;
        }
        return i == m;
    }
}
