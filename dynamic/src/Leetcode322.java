import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @author: Jayden
 * @date:5/4/21 1:05 PM
 */
public class Leetcode322 {
    //recursive
    int res = Integer.MAX_VALUE;

    public int coinChangerecursive(int[] coins, int amount) {
        if (coins.length == 0) return -1;
        findway(coins, amount, 0);
        if (res == Integer.MAX_VALUE) return -1;
        return res;
    }

    private void findway(int[] coins, int amount, int count) {
        if (amount < 0) return;
        if (amount == 0) {
            res = Math.min(res, count);
        }
        for (int i = 0; i < coins.length; i++) {
            findway(coins, amount - coins[i], 1 + count);
        }
    }


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
        count[rem] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem];
    }


    public static List<Integer> sol(int[] coins, int amount) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(coins);
        int[] arr = new int[coins.length];
        for (int i = 0; i < coins.length; i++) {
            arr[i] = coins[coins.length - 1 - i];
        }
        List<List<Integer>> allCombinations = new ArrayList<>();
        List<Integer> combiantion = new ArrayList<>();
        dfs(allCombinations, combiantion, amount, arr, 0);
        result = getBestCombination(allCombinations, arr);
        return result;
    }

    public static void dfs(List<List<Integer>> allCombinations, List<Integer> combiantion, int remain, int[] arr, int index) {
        if (index == arr.length) {
            if (remain == 0) {
                allCombinations.add(new ArrayList<>(combiantion));
            }
            return;
        }
        for (int i = 0; i <= remain / arr[index]; i++) {
            combiantion.add(i);
            dfs(allCombinations, combiantion, remain - i * arr[index], arr, index + 1);
            combiantion.remove(combiantion.size() - 1);
        }
    }

    public static List<Integer> getBestCombination(List<List<Integer>> allCombinations, int[] arr) {
        List<Integer> bestCombination = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int maxAmount = 0;
            for (int j = 0; j < allCombinations.size(); j++) {
                if (allCombinations.get(j).get(i) > maxAmount) {
                    maxAmount = allCombinations.get(j).get(i);
                    bestCombination = allCombinations.get(j);
                }
            }
            if (maxAmount > 0) {
                break;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < bestCombination.size(); i++) {
            if (bestCombination.get(i) > 0) {
                for (int j = 0; j < bestCombination.get(i); j++) {
                    result.add(arr[i]);
                }
            }
        }
        return result;
    }


}
