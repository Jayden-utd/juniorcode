import java.util.*;


/**
 * @Description:ine
 * @author: Jayden
 * @date:2/23/21 9:01 AM
 */
public class Blank {
    public static void main(String[] args) {
        int[] s1 = new int[]{1,2};
        int[] s2 = new int[]{1,2};
        System.out.println(Arrays.equals(s1,s2));
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(0, 1);
        l2.add(l2.size(), 2);

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

    public static int maxValue(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            //if bigger then update
            if (arr[i] + arr[i + 1] > res) {
                res = arr[i] + arr[i + 1];
            }
        }
        return res;
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
