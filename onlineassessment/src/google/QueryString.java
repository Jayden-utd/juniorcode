package google;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 * @author: Jayden
 * @date:7/29/21 4:20 PM
 */
public class QueryString {
    public boolean query(String query, int input) {
        int n = query.length();
        Deque<Integer> stackNumber = new LinkedList<>();
        Deque<Character> stackComparison = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = query.charAt(i);
            if (c == 'x') {
                stackNumber.push(input);
            } else if (c == '<' || c == '>' || c == '=') {

            }
        }
//        for (int i = 0; i < n; i++) {
//            char c = query.charAt(i);
//            if (Character.isDigit(c)) {
//                num = num * 10 + c - '0';
//            } else if (c == '(') {
//                int j = i, cnt = 0;
//                for (; i < n; i++) {
//                    if (query.charAt(i) == '(') ++cnt;
//                    if (query.charAt(i) == ')') --cnt;
//                    if (cnt == 0) break;
//                }
//                res = query(query.substring(j + 1, i), input);
//            }
//            if (c == 'a' || c == 'o' ||  i == n - 1) {
//                switch (op)
//
//
//
//            }
//
//        }
        return true;
    }
}
