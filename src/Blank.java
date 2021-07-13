import java.util.*;

/**
 * @Description:ine
 * @author: Jayden
 * @date:2/23/21 9:01 AM
 */
public class Blank {
    public static void main(String[] args) {
        Blank test = new Blank();
        System.out.println("hello world");
        System.out.println(test.reverse("abcdefg"));
    }
    //O(n)
    public String reverse(String s) {
        int left = 0, right = s.length() - 1;
        char[] charStr = s.toCharArray();
        while (left < right) {
            char tmp = charStr[left];
            charStr[left] = charStr[right];
            charStr[right] = tmp;
            left++;
            right--;
        }
        return new String(charStr);
    }


    public String minWindow(String S, String T) {
        int m = S.length(), n = T.length(), start = -1, minLen = Integer.MAX_VALUE;
        int[][] dp = new int[m + 1][n + 1];
        for(int[] k : dp) Arrays.fill(k, -1);
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (S.charAt(i - 1) == T.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j]);
            }
            if (dp[i][n] != -1) {
                int len = i - dp[i][n];
                if (minLen > len) {
                    minLen = len;
                    start = dp[i][n];
                }
            }
        }
        return (start != -1) ? S.substring(start, start + minLen) : "";
    }
    public int subsetXORSum(int[] nums) {
        int n = nums.length, res = 0, start = 1 << n;
        for(int i = 0; i < 1 << n; i++){
            int xor = 0;
            for(int j = 0; j < nums.length; j++)
                if(((i >> j) & 1) == 1)
                    xor ^= nums[j];
            res += xor;
        }
        return res;
    }

    public static void pairedElements(int arr[], int sum)
    {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            if (arr[low] + arr[high] == sum) {
                System.out.println("The pair is : ("
                        + arr[low] + ", " + arr[high] + ")");
            }
            if (arr[low] + arr[high] > sum) {
                high--;
            }
            else {
                low++;
            }
        }
    }

    public static int nPrime(int n) {
        int num = 1, count = 0, i;
        while (count < n) {
            num = num + 1;
            for (i = 2; i <= num; i++) {
                //determines the modulo and compare it with 0
                if (num % i == 0) {
                    //breaks the loop if the above condition returns true
                    break;
                }
            }
            if (i == num) {
                //increments the count variable by 1 if the number is prime
                count = count + 1;
            }
        }
        return num;
    }


    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            map.putIfAbsent(log[0], new ArrayList<>());
            if (!map.get(log[0]).contains(log[1])) {
                map.get(log[0]).add(log[1]);
            }
        }
        int[] res = new int[k];

        for (Map.Entry<Integer, List<Integer>> tmp : map.entrySet()) {
            res[tmp.getValue().size() - 1]++;
        }
        return res;
    }
}
