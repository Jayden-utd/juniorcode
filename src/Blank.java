import java.util.*;

/**
 * @Description:ine
 * @author: Jayden
 * @date:2/23/21 9:01 AM
 */
public class Blank {
    public static void main(String[] args) {
        Blank test = new Blank();
        int[][] edges = new int[][]{{1, 2, 0}, {2, 5, 10}, {3, 4, 20}, {5, 3, 40}};
        List<String> res = test.spray(new String[]{"1", "2", "2", "3", "3", "3", "2", "1"});
        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.println(res.get(i));
        }
    }
    int money = 0;
    public int getMoney(int[] A, int[] B, int cost) {
        dfs(A, B, cost, 0, 1,0);
        dfs(A, B, cost, 0, 2,0);
        return money;
    }

    private void dfs(int[] a, int[] b, int cost, int day, int position, int current) {
        if (day == a.length) {
            money = Math.max(money, current);
            return;
        }
        if (position == 1) {
            dfs(a, b, cost, day + 1, 1, current + a[day]);
            dfs(a, b, cost, day + 1, 2, current + b[day] - cost);
        } else {
            dfs(a, b, cost, day + 1, 2, current + b[day]);
            dfs(a, b, cost, day + 1, 1, current + a[day] - cost);
        }
    }


    public List<String> sol (List<String> input, int finalSize) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : input) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> map.get(s1) - map.get(s2));
        for (String s : map.keySet()) {
            minHeap.add(s);
        }
        while (minHeap.size() >= finalSize) {
            minHeap.poll();
        }
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        return result;
    }



    public boolean checkSet(int[][] input, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < input[0].length; i++) {
            for (int j = 0; j < input.length; j++) {
                set.add(input[j][i]);
            }
            if (set.size() != 1 || set.size() != k) return false;
            set.clear();
        }
        return true;
    }


    public double minAreaFreeRect(int[][] points) {
        Arrays.sort(points, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
        double res = Double.MAX_VALUE;
        Map<String, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                long dis = (long) (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
                        (long) (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                double centerX = (double) (points[j][0] + points[i][0]) / 2;
                double centerY = (double) (points[j][1] + points[i][1]) / 2;
                String key = "" + dis + "+" + centerX + "+" + centerY;
                map.computeIfAbsent(key, k -> new ArrayList<int[]>());
                map.get(key).add(new int[]{i, j});
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                List<int[]> list = map.get(key);
                for (int i = 0; i < list.size(); i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        int p1 = list.get(i)[0];
                        int p2 = list.get(j)[0];
                        int p3 = list.get(j)[1];
                        // len1 and len2 are the length of the sides of a rectangle
                        double len1 = Math.sqrt((points[p1][0] - points[p2][0]) * (points[p1][0] - points[p2][0]) +  (points[p1][1] - points[p2][1]) * (points[p1][1] - points[p2][1]));
                        double len2 = Math.sqrt((points[p1][0] - points[p3][0]) * (points[p1][0] - points[p3][0]) +  (points[p1][1] - points[p3][1]) * (points[p1][1] - points[p3][1]));
                        double area = len1 * len2;
                        res = Math.min(res, area);
                    }
                }
            }
        }

        return res == Double.MAX_VALUE ? 0.0 : res;
    }

    public List<String> spray(String[] input) {
        Deque<String> stack = new ArrayDeque<>();
        for (String cur : input) {
            if (stack.isEmpty()) {
                stack.push(cur);
            } else {
                if (stack.peek().equals(cur)) {
                    String tmp = stack.pop();
                    if (!stack.isEmpty() && stack.peek().equals(cur)) {
                        stack.pop();
                    } else {
                        stack.push(tmp);
                        stack.push(cur);
                    }
                } else {
                    stack.push(cur);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (String cur : stack) {
            res.add(stack.pop());
        }
        Collections.reverse(res);
        return res;
    }


    public int minDis(int[][] edges, int A, int B) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            if (!adj.containsKey(edge[0])) {
                adj.put(edge[0], new ArrayList<>());
                adj.get(edge[0]).add(edge[1]);
            } else {
                adj.get(edge[0]).add(edge[1]);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int step = 0;
        queue.add(A);
        visited.add(A);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curNode = queue.poll();
                visited.add(curNode);
                if (curNode == B) return step;
                for (int next : adj.get(curNode)) {
                    if (!visited.contains(next)) {
                        queue.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String minWindow(String S, String T) {
        int m = S.length(), n = T.length(), start = -1, minLen = Integer.MAX_VALUE;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] k : dp) Arrays.fill(k, -1);
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
        for (int i = 0; i < 1 << n; i++) {
            int xor = 0;
            for (int j = 0; j < nums.length; j++)
                if (((i >> j) & 1) == 1)
                    xor ^= nums[j];
            res += xor;
        }
        return res;
    }

    public static void pairedElements(int arr[], int sum) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            if (arr[low] + arr[high] == sum) {
                System.out.println("The pair is : ("
                        + arr[low] + ", " + arr[high] + ")");
            }
            if (arr[low] + arr[high] > sum) {
                high--;
            } else {
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
