import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Jayden
 * @date:4/15/21 9:33 AM
 */
public class NoIncreasing {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        System.out.println(maxInversions(arr));
    }
    public static long maxInversions(List<Integer> arr) {
        int[] arrNum = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            arrNum[i] = arr.get(i);
        }
        return numOfIncSubseqOfSizeK(arrNum, arr.size(), 3);
    }
    public static long numOfIncSubseqOfSizeK(int arr[], int n, int k) {
        //reverse(arr);
        long dp[][] = new long[k][n], sum = 0;
        // count of increasing subsequences of size 1
        // ending at each arr[i]
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // building up the matrix dp[][]
        // Here 'l' signifies the size of
        // increassing subsequence of size (l+1).
        for (int l = 1; l < k; l++) {
            // for each increasing subsequence of size 'l'
            // ending with element arr[i]
            for (int i = l; i < n; i++) {
                // count of increasing subsequences of size 'l'
                // ending with element arr[i]
                dp[l][i] = 0;
                for (int j = l - 1; j < i; j++) {
                    if (arr[j] < arr[i]) {
                        dp[l][i] += dp[l - 1][j];
                    }
                }
            }
        }
        // sum up the count of increasing subsequences of
        // size 'k' ending at each element arr[i]
        for (int i = k - 1; i < n; i++) {
            sum += dp[k - 1][i];
        }
        // required number of increasing
        // subsequences of size k
        return sum;
    }

}
