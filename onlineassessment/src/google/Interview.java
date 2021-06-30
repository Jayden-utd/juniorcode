package google;

import java.util.*;

/**
 * @Description:
 * @author: Jayden
 * @date:6/26/21 12:05 PM
 */
public class Interview {
    public static void main(String[] args) {

    }

    public  int minimumEffortPath(int[][] heights) {
        int left = 0, right = 1000000;
        while (left <= right) {
            int mid = left + (right - left) /2;
            if (isValid(heights, mid)){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean isValid(int[][] heights, int k) {
        int row = heights.length, col = heights[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == row - 1 && cur[1] == col - 1) return true;
            for (int[] direction : directions) {
                int adjacentX = cur[0] + direction[0];
                int adjacentY = cur[1] + direction[1];
                if (isValidCell(adjacentX, adjacentY, row, col) && !visited[adjacentX][adjacentY]) {
                    int currentDifference = Math.abs(heights[adjacentX][adjacentY] - heights[cur[0]][cur[1]]);
                    if (currentDifference <= k) {
                        visited[adjacentX][adjacentY] = true;
                        queue.offer(new int[]{adjacentX, adjacentY});
                    }
                }
            }
        }
        return false;
    }

    private boolean isValidCell(int x, int y, int row, int col) {
        return x >= 0 && x <= row - 1 && y >= 0 && y <= col - 1;
    }


    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<>((a, b) -> (b - a));
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], (double)(target - position[i]) / speed[i]);
        }

        double cur = 0;
        int count = 0;
        for (Map.Entry<Integer, Double> entry : map.entrySet()) {
            if (entry.getValue() <= cur) continue;
            cur = entry.getValue();
            count++;
        }
        return count;
    }


    public int wordsTyping(String[] sentence, int rows, int cols) {
        String sent = String.join(" ", sentence) + " ";
        int pos = 0, len = sent.length();
        for (int i = 0; i < rows; i++) {
            pos += cols;
            while (pos >= 0 && sent.charAt(pos % len) != ' ') pos--;
            pos++;
        }
        return pos / len;
    }

    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Deque<String>> map = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++) {
            map.put(i, new ArrayDeque<>());
        }

        for (String word : words) {
            map.get(word.charAt(0)).addLast(word);
        }
        int count = 0;
        for (char tmp : s.toCharArray()) {
            Deque<String> group = map.get(tmp);
            int size = group.size();
            for (int i = 0; i < size; i++) {
                String cur = group.removeFirst();
                if (cur.length() == 1) {
                    count++;
                } else {
                    map.get(cur.charAt(1)).addLast(cur.substring(1));
                }
            }
        }
        return count;
    }

    public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        List<int[]> sorted = new ArrayList<>();
        for (int i = 0 ; i < indexes.length; i++) sorted.add(new int[]{indexes[i], i});
        Collections.sort(sorted, Comparator.comparing(i -> -i[0]));
        for (int[] ind: sorted) {
            int i = ind[0], j = ind[1];
            String s = sources[j], t = targets[j];
            if (S.substring(i, i + s.length()).equals(s)) S = S.substring(0, i) + t + S.substring(i + s.length());
        }
        return S;
    }
}
