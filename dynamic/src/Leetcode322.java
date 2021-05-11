/**
 * @Description:
 * @author: Jayden
 * @date:5/4/21 1:05 PM
 */
public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount + 1]);
    }
    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem] != 0) return count[rem];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem] =  (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem];
    }

}
