package weektest;

import java.util.Arrays;

/**
 * @Description:
 * @author: Jayden
 * @date:3/27/21 9:49 PM
 */
public class Leetcode1806 {
    public static void main(String[] args) {
        System.out.println(reinitializePermutation(8));
    }
    public static int reinitializePermutation(int n) {
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i;
        }
        int[] oper = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                oper[i] = num[i / 2];
            } else {
                oper[i] = num[n / 2 + (i - 1) / 2];
            }
        }
        int operNum = 1;
        int[] tmp = new int[n];
        while (!Arrays.equals(num, oper)) {
            for (int i = 0; i < n; i++) {
                tmp[i] = oper[i];
            }
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    oper[i] = tmp[i / 2];
                } else {
                    oper[i] = tmp[n / 2 + (i - 1) / 2];
                }
            }
            operNum++;
        }
        return operNum;
    }
    //这个题 很自然会想到 要通过举例进行观察，当然你可以直接暴力模拟过程
    //但是观察之后，你会发现 比如 i = 1的时候 它其实一直需要的是 上一次数组的某一个位置的元素
    //然后盯着那一个位置的元素 看看都是怎么算来的
    public int reinitializePermutationSimple(int n) {
        int mid = n / 2;
        int cnt = 1;
        while (mid != 1) {
            if (mid % 2 == 0) {
                mid = mid / 2;
            } else {
                mid = n / 2 + (mid - 1) / 2;
            }
            cnt++;
        }
        return cnt;
    }
}
