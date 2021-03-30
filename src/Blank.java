import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;


/**
 * @Description:ine
 * @author: Jayden
 * @date:2/23/21 9:01 AM
 */
public class Blank {
    public static void main(String[] args) {
        int[] num = new int[3];
        int[] tmp = num;
        tmp[2] = 100;
        System.out.println(num[2]);
       



    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0, sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) res += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    private static List<Integer> getPrimeNumberToN(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (numberIsPrime(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean numberIsPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void numberofdays(int N) {
        //this is default OUTPUT. You can change it.
        int P = -404;
        int Q = -404;
        if (N >= 4) {
            P = 1;
            Q = 1;
            System.out.println(P + " " + Q);
        } else if (N == 3) {
            P = 2;
            Q = 5;
            System.out.println(P + " " + Q);
        } else if (N == 2) {
            P = 5;
            Q = 7;
            System.out.println(P + " " + Q);
        } else if (N == 1) {
            P = 3;
            Q = 7;
            System.out.println(P + " " + Q);
        } else {
            P = 0;
            Q = 1;
            System.out.println(P + " " + Q);
        }
    }

    public static int findMinimumCost(int N, int K, int[] A) {
        //this is default OUTPUT. You can change it.
        int result = -404;
        result = 0;
        //write your Logic here:
        Arrays.sort(A);
        for (int i = 0; i < K; i++) {
            result += A[i];
        }
        return result;
    }

    public static int numberTheory(int N, int K) {
        //this is default OUTPUT. You can change it.
        int result = K / N;
        int remain = K % N;
        if (result % 2 == 0) {
            return K;
        } else {
            return (result + 1) * N - (remain - 1);
        }
    }

}
