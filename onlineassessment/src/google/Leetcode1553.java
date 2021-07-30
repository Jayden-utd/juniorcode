package google;

import java.util.*;

/**
 * @Description:
 * @author: Jayden
 * @date:7/13/21 4:58 PM
 */
public class Leetcode1553 {
    public static void main(String[] args) {
        Leetcode1553 test = new Leetcode1553();

    }
    Leetcode1553() {
        this.minDays(6);
    }
    public int minDays(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i - i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i - 2 * (i / 3)] + 1);
            }
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);

        }
        try {
            int i = 6 / 0;
        } finally {
            System.out.println("test");
        }

        return dp[n];

    }


    public static Map<String, Boolean> solution (String[][] meeting) {
        Map<String, Boolean> isKnown = new HashMap<>();
        Map<String, Integer> knowTime = new HashMap<>();
        Map<String, List<String>>  graph = new HashMap<>();

        for (int i = 0; i < meeting.length; i++) {
            if (meeting[i][0] == "A") {
                isKnown.put("A", true);
                knowTime.put("A", 0);
                knowTime.put(meeting[i][1], Integer.parseInt(meeting[i][2]));
            }else{
                isKnown.put(meeting[i][0], false);
                isKnown.put(meeting[i][1], false);
                knowTime.put(meeting[i][1], Integer.parseInt(meeting[i][2]));
            }


            if (graph.containsKey(meeting[i][0])) {
                graph.get(meeting[i][0]).add(meeting[i][1]);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(meeting[i][1]);
                graph.put(meeting[i][0], list);
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("A");
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            List<String> toKnow = graph.get(cur);
            for (int i = 0; toKnow != null && i < toKnow.size(); i++) {
                if (isKnown.get(cur) && knowTime.get(toKnow.get(i)) > knowTime.get(cur)) {
                    isKnown.put(toKnow.get(i), true);
                }else{
                    isKnown.put(toKnow.get(i), false);
                }
                queue.add(toKnow.get(i));
            }
        }
        return isKnown;
    }
}
