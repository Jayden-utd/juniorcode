import java.util.*;

/**
 * @Description:ine
 * @author: Jayden
 * @date:2/23/21 9:01 AM
 */
public class Blank {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        set.lower(1);
        set.higher(1);
        set.floor(1);
        map.ceilingKey(1);
        map.floorKey(1);
        StringBuilder sb = new StringBuilder();
        int k = 9;
        sb.append(k);
        System.out.println(sb.toString());



//
//        int[] arr = new int[]{1,3,5,2,4,6,8};
//        int[] res = new int[arr.length - 2];
//        int[] pre = new int[arr.length + 1];
//        for (int i = 1; i < pre.length; i++) {
//            pre[i] = arr[i - 1] + pre[i - 1];
//        }
//
//        for (int i = 0; i < res.length; i++) {
//            res[i] = pre[i + 3] - pre[i];
//        }
//        for (int i : res) System.out.println(i);
    List<List<Integer>> input = new LinkedList<>();


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



    public static int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) return i;
        }
        return -1;
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
