package google;

import java.util.*;

/**
 * @Description:
 * @author: Jayden
 * @date:7/11/21 5:28 PM
 */
public class Leetcode1088 {
    public static void main(String[] args) {
        Leetcode1088 test = new Leetcode1088();
        test.confusingNumberII(100);
    }
    int size = 0;
    int target;
    public int confusingNumberII(int n) {
        List<Integer> digits = new ArrayList<>();
        digits.add(0);
        digits.add(1);
        digits.add(6);
        digits.add(8);
        digits.add(9);
        target = n;
        backtrack(digits, 0);
        return size;

    }
    public void backtrack(List<Integer> list, long curNum) {
        if (confusingNumber(curNum)) {
            size++;
        }
        for (int i = 0; i < list.size(); i++) {
            if (curNum * 10 + list.get(i) <= target && curNum * 10 + list.get(i) != 0) {
                curNum = curNum * 10 + list.get(i);
                System.out.println(curNum);
                backtrack(list, curNum);
                curNum = curNum / 10;
            }
        }
    }

    public boolean confusingNumber(long n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(6, 9);
        map.put(9, 6);
        map.put(0, 0);
        map.put(1, 1);
        map.put(8, 8);
        long newNum = 0;
        long x = n;
        while (x != 0) {
            long remainder = x % 10;
            newNum = newNum * 10 + map.get((int)remainder);
            x /= 10;
        }
        return n != newNum;
    }

}
