package google;

import java.util.*;

/**
 * @Description:
 * @author: Jayden
 * @date:6/24/21 6:33 PM
 */
public class Leetcode {
    public static void main(String[] args) {
        int[] arr = {-9,8, -1}; // answer 8
        System.out.println(minAmplitude(arr));

    }

    static int getResult(int[] arr){
        int sum = 0;
        Arrays.sort(arr);

        for(int a: arr){
            sum += a;
        }
        int[][] dp = new int[arr.length][sum/2 + 1];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if( i == 0){
                    if(arr[i] <= j){
                        dp[i][j] = Math.max(0,  arr[i]);
                    }else{
                        dp[i][j] = 0;
                    }
                }else{
                    if(arr[i] > j){
                        dp[i][j] = dp[i- 1][j];
                    }else{
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - arr[i]] + arr[i]);
                    }
                }

            }
        }
        return (sum - 2 * dp[arr.length-1][sum/2]);
    }


    public static int minAmplitude(int[] A) {
        if(A.length <= 4) return 0;
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : A) {
            maxQueue.add(n);
            if(maxQueue.size() > 4) maxQueue.poll();
            minQueue.add(n);
            if(minQueue.size() > 4) minQueue.poll();
        }
        List<Integer> maxList = new ArrayList<>();
        while(maxQueue.size() > 0) maxList.add(maxQueue.poll());
        List<Integer> minList = new ArrayList<>();
        while(minQueue.size() > 0) minList.add(minQueue.poll());
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= 3; i++) {
            ans = Math.min(ans, maxList.get(i) - minList.get(3-i));
        }
        return ans;
    }

    public static int numSplits(String S) {
        int rc[] = new int[26], lc[] = new int[26], l = 0, r = 0, res = 0;
        for (char c : S.toCharArray()) if (rc[c - 'a']++ == 0) r++;
        for (char c : S.toCharArray()) {
            if (lc[c - 'a']++ == 0) l++;
            if (--rc[c - 'a'] == 0) r--;
            if (l == r) res++;
        }
        return res;
    }

    public static void giveMeMaxTime(String tim){
        char[] timChar = tim.toCharArray();

        if(timChar[0] == '?')
            timChar[0] = (timChar[1] <= '3' || timChar[1] == '?') ? '2' : '1';

        if(timChar[1] == '?')
            timChar[1] = (timChar[0] == '2') ? '3' : '9';

        timChar[3] = (timChar[3] == '?') ? '5' : timChar[3];
        timChar[4] = (timChar[4] == '?') ? '9' : timChar[4];

        System.out.println(timChar);

    }


    public int minDominoRotations(int[] A, int[] B) {
        int[] countA = new int[7], countB = new int[7], same = new int[7];
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            countA[A[i]]++;
            countB[B[i]]++;
            if (A[i] == B[i])
                same[A[i]]++;
        }
        for (int i  = 1; i < 7; ++i)
            if (countA[i] + countB[i] - same[i] == n)
                return n - Math.max(countA[i], countB[i]);
        return -1;
    }

    public static int calculateTime(String keyboard, String word) {
        int[] index = new int[26];
        for (int i = 0; i < keyboard.length(); ++i)
        {
            index[keyboard.charAt(i) - 'a'] = i;
        }

        int sum = 0;
        int last = 0;
        for (char c : word.toCharArray())
        {
            sum += Math.abs(index[c - 'a'] - last);
            last = index[c - 'a'];
        }

        return sum;
    }
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public int maxLevelSum(TreeNode root) {
        int level = 1;
        int res = 1;
        int sum = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sumCur = 0;
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();
                sumCur += tmp.val;

                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
            }
            if (sumCur > sum) {
                sum = sumCur;
                res = level;
            }
            level++;
        }
        return res;
    }

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int charLen = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '-') {
                if (charLen > 0 && charLen % k == 0)
                {
                    sb.append('-');
                }
                sb.append(s.charAt(i));
                charLen++;
            }
        }
        return sb.reverse().toString().toUpperCase();
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            int domainIndex = email.indexOf('@');
            for (int i = 0; i < domainIndex; i++) {
                if (email.charAt(i) == '+') break;
                if (email.charAt(i) == '.') continue;
                sb.append(email.charAt(i));
            }
            sb.append(email.substring(domainIndex));
            unique.add(sb.toString());
        }
        return unique.size();
    }


    public int minDaysBloom(int[] a, int k, int n) {
        if (a == null || n == 0 || k == 0) return 0;
        if (n * k > a.length) return -1;
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int val : a) { l = Math.min(l, val); r = Math.max(r, val); }
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isValid(a, k, n, mid)) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }

    public boolean isValid(int a[], int size, int count, int day) {
        int curcount = 0, cursize = 0;
        for (int val : a) {
            if (val <= day) {
                cursize++;
            } else {
                cursize = 0;
            }
            if (cursize == size) { cursize = 0; curcount++; }
            if (curcount == count) return true;
        }
        return false;
    }

    public int[] findStores(int[] houses, int[] stores) {
        int n = houses.length, m = stores.length;
        int[] result = new int[n];
        Arrays.sort(stores);
        for (int i = 0; i < n; i++) {
            int house = houses[i], dist = Integer.MAX_VALUE, store = 0;
            int left = 0, right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (stores[mid] == house) {
                    store = house;
                    break;
                } else {
                    int d = Math.abs(house - stores[mid]);
                    if (d == dist) {
                        store = Math.min(store, stores[mid]);
                    } else if (d < dist) {
                        dist = d;
                        store = stores[mid];
                    }
                    if (stores[mid] < house) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
            result[i] = store;
        }
        return result;
    }
}
