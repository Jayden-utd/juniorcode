package eBay;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description:
 * @author: Jayden
 * @date:3/16/21 12:20 PM
 */
public class e1 {
    public static void main(String[] args) {
        e1 test = new e1();

        System.out.println(test.findminAbs(new int[]{1,3,0}, new int[]{6,3,3}));
    }

    //二进制中 1 的个数
    public int numbersOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }


    public int findminAbs(int[] a, int[] b) {
        int res = 0;
        int[] diffArr = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res += Math.abs(a[i] - b[i]);
            diffArr[i] = Math.abs(a[i] - b[i]);
        }
        //for every bi, we need to find the cloasest in a
        //so we need to use binary search for sorted array a, that closest in break;
        Arrays.sort(a);
        int diff = Integer.MIN_VALUE;
        for (int i = 0; i < b.length; i++) {
            int ak = binarySearch(b[i], a);
            int tmpDiff = Math.abs(ak - b[i]);
            diff = Math.max(diff, Math.abs(diffArr[i] - tmpDiff));
        }
        return res - diff;
    }
    private int binarySearch(int value, int[] a) {
        if (value < a[0]) {
            return a[0];
        }
        if (value > a[a.length - 1]) {
            return a[a.length - 1];
        }
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (value < a[mid]) {
                hi = mid - 1;
            } else if (value > a[mid]) {
                lo = mid + 1;
            } else {
                return a[mid];
            }

        }
        //the final position of lo and hi will be lo == hi + 1
        return (a[lo] - value) < (value - a[hi]) ? a[lo] : a[hi];
    }


    public int findPatternNumber(String t, String s) {
        char begin = s.charAt(0);
        int lt = t.length(), res = 0;
        for (int i = 0; i < lt - 2; i++) {
            if (t.charAt(i) == begin && t.substring(i, i + 3).equals(s)) res++;
        }
        return res;
    }

    public int count(String X, String Y, int m, int n) {
        // Base case 1: if only one character is left
        if (m == 1 && n == 1) {
            return (X.charAt(0) == Y.charAt(0)) ? 1 : 0;
        }

        // Base case 2: if the input string `X` reaches its end
        if (m == 0) {
            return 0;
        }

        // Base case 3: if pattern `Y` reaches its end, we have found
        // subsequence
        if (n == 0) {
            return 1;
        }

        // Optimization: the solution is not possible if the number of characters
        // in the string is less than the number of characters in the pattern
        if (n > m) {
            return 0;
        }

        /*
          If the last character of both string and pattern matches,
            1. Exclude the last character from both string and pattern
            2. Exclude only the last character from the string.

          Otherwise, if the last character of the string and pattern do not match,
          recur by excluding only the last character in the string
        */

        return ((X.charAt(m - 1) == Y.charAt(n - 1)) ? count(X, Y, m - 1, n - 1) : 0) + count(X, Y, m - 1, n);
    }

    public int countDP(String X, String Y, int m, int n) {
        // `T[i][j]` stores number of times pattern `Y[0…j)`
        // appears in a given string `X[0…i)` as a subsequence
        int[][] T = new int[m + 1][n + 1];

        // if pattern `Y` is empty, we have found subsequence
        for (int i = 0; i <= m; i++) {
            T[i][0] = 1;
        }

        /*
          If the current character of both string and pattern matches,
            1. Exclude current character from both string and pattern
            2. Exclude only the current character from the string

          Otherwise, if the current character of the string and pattern do not match,
          exclude the current character from the string
        */

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                T[i][j] = ((X.charAt(i - 1) == Y.charAt(j - 1)) ? T[i - 1][j - 1] : 0)
                        + T[i - 1][j];
            }
        }
        // return last entry in the lookup table
        return T[m][n];
    }

    public void minPeaks(ArrayList<Integer> list) {
        // Length of original list
        int n = list.size();
        // Initialize resultant list
        ArrayList<Integer> result = new ArrayList<>();
        // Traverse each element of list
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            // Length of original list after
            // removing the peak element
            int size = list.size();
            // Traverse new list after removal
            // of previous min peak element
            for (int j = 0; j < size; j++) {
                // Update min and index,
                // if first element of
                // list > next element
                if (j == 0 && j + 1 < size) {
                    if (list.get(j) > list.get(j + 1)
                            && min > list.get(j)) {
                        min = list.get(j);
                        index = j;
                    }
                } else if (j == size - 1
                        && j - 1 >= 0) {

                    // Update min and index,
                    // if last elemnt of
                    // list > previous one
                    if (list.get(j)
                            > list.get(j - 1)
                            && min
                            > list.get(j)) {
                        min = list.get(j);
                        index = j;
                    }
                }
                // Update min and index, if
                // list has single element
                else if (size == 1) {

                    min = list.get(j);
                    index = j;
                }

                // Update min and index,
                // if current element >
                // adjacent elements
                else if (list.get(j) > list.get(j - 1) && list.get(j) > list.get(j + 1) && min > list.get(j)) {
                    min = list.get(j);
                    index = j;
                }
            }
            // Remove current min peak
            // element from list
            list.remove(index);
            // Insert min peak into
            // resultant list
            result.add(min);
        }
        // Print resultant list
        System.out.println(result);
    }

    //use bit operation to make ajustment on string
    public String booleanDequeBit(int n, String[] oper) {
        if (n == 0) {
            return new String();
        }
        int res = 0;
        for (int i = 0; i < oper.length; i++) {
            if (oper[i].equals("L")) {
                int k = n;
                while (k > 0) {
                    int cur = (res >> (k - 1) & 1);
                    if (cur == 1) {
                        k--;
                    } else {
                        res = res | ((k - 1) << 1);
                        break;
                    }
                }
            } else { //find index = i and set the value to 0
                int digit = oper[i].charAt(1) - '0';
                res = res & (~(n - digit - 1));
            }
        }
        return Integer.toBinaryString(res);
    }
}
