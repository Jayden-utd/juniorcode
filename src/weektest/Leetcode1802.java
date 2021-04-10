package weektest;

/**
 * @Description:
 * @author: Jayden
 * @date:3/20/21 9:46 PM
 */
//这道题我终于明白 为什么要 最后 left + 1了，因为 你在最开始 减了 1  把结果值落在了
//0 ~ 到某一个值了  如果不想纠结细节的话 那就是 right设置成 maxSum - n + 1
//题目的要求是 nums[i] is a positive interger 没有 0，但是你让范围变成了 0
public class Leetcode1802 {
    public static void main(String[] args) {
        Leetcode1802 test = new Leetcode1802();
        System.out.println(test.maxValue(4,2,6));
    }



    public int maxValue(int n, int index, int maxSum) {
        //because all elements need to be positive, so we need to minus
        maxSum -= n;
        int left = 0, right = maxSum;
        while (left < right) {
            //for not TLE we need another way to find the median
            int mid = (left + right + 1) / 2;
            //int mid = left + (right - left) / 2;
            if (test(n, index, mid) <= maxSum) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left + 1;
    }
    //we find the minimum sum
    public long test(int n, int index, int a) {
        int b = Math.max(a - index, 0);
        long res = (long) (b + a) * (a - b + 1) / 2;
        b = Math.max(a - (n - 1 - index), 0);
        res += (long) (b + a) * (a - b + 1) / 2;
        return res - a;
    }
}
