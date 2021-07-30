package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: Jayden
 * @date:7/12/21 11:54 PM
 */
public class Leetcode1548 {
    public static void main(String[] args) {
        Leetcode1548 test = new Leetcode1548();
        test.mostSimilar(5,new int[][]{{0,2},{0,3},{1,2},{1,3},{1,4},{2,4}}, new String[]{"ATL","PEK","LAX","DXB","HND"},
                new String[]{"ATL","DXB","HND","LAX"});
    }
    List<List<Integer>> adjMatrix;
    String[] names;
    String[] targetPath;
    int[][] visited;
    int[][] nextChoiceForMin;
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        this.names = names;
        this.targetPath = targetPath;
        this.visited = new int[names.length][targetPath.length];
        this.nextChoiceForMin = new int[names.length][targetPath.length];
        this.adjMatrix = new ArrayList<>();
        for (int[] x : visited) Arrays.fill(x, -1);

        for (int i = 0; i < n; i++) {
            adjMatrix.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adjMatrix.get(road[0]).add(road[1]);
            adjMatrix.get(road[1]).add(road[0]);
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < n; i++) {
            int resp = dfs(i, 0);
            if (resp < min) {
                min = resp;
                start = i;
            }
        }
        // BUILD THE ANSWER BASED ON WHATS THE BEST NEXT CHOICE
        List<Integer> ans = new ArrayList<Integer>();
        while (ans.size() < targetPath.length) {
            ans.add(start);
            start = nextChoiceForMin[start][ans.size() - 1];
        }

        return ans;
    }
    
    public int dfs(int namesIdx, int currPathIdx) {
        if (visited[namesIdx][currPathIdx] != -1) return visited[namesIdx][currPathIdx];
        int editDist = (names[namesIdx].equals(targetPath[currPathIdx])) ? 0 : 1;
        if (currPathIdx == targetPath.length-1) return editDist;
        int min = Integer.MAX_VALUE;
        for(int neighbor : adjMatrix.get(namesIdx)) {
            int neighborCost = dfs(neighbor, currPathIdx+1);
            if (neighborCost < min) {
                min = neighborCost;
                nextChoiceForMin[namesIdx][currPathIdx] = neighbor;
            }
        }
        editDist += min; // UPDATE OUR EDIT DISTANCE
        visited[namesIdx][currPathIdx] = editDist; // SAVE OUR EDIT DISTANCE
        return editDist; // RETURN OUR EDIT DISTANCE
    }
}
