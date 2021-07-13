package google;

import java.util.*;

/**
 * @Description:
 * @author: Jayden
 * @date:7/6/21 5:43 PM
 */
public class Leetcode218 {
    public static void main(String[] args) {
        Leetcode218 test = new Leetcode218();
        int[][] buildings = new int[][]{{2,7,5},{3,9,10}};
        test.getSkyline(buildings);
        LinkedList<Integer> list = new LinkedList<>();

    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] b : buildings) {
            // Nice trick to put negative height for the left edge
            heights.add(new int[] {b[0], b[2]});
            heights.add(new int[] {b[1], -b[2]});
        }
        Collections.sort(heights, (a, b) -> a[0] != b[0] ?
                a[0] - b[0] :
                /* Because we use negative heights here we could get the correct sorting order*/ b[1] - a[1]);

        // Max heap of heights
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        // Height of the previous key point
        int prev = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int[] h : heights) {
            if (h[1] > 0) {
                // Add the building to priority queue
                pq.offer(h[1]);
            } else {
                // Remove the building from priority queue
                pq.remove(-h[1]);
            }
            int cur = pq.peek();
            // Height changes, so add a new key point to the result
            if (prev != cur) {
                result.add(new ArrayList<>(){{add(h[0]); add(cur); }});
                prev = cur;
            }
        }
        return result;
    }







    /**
     *  Divide-and-conquer algorithm to solve skyline problem,
     *  which is similar with the merge sort algorithm.
     */
//    public List<List<Integer>> getSkyline(int[][] buildings) {
//        int n = buildings.length;
//        List<List<Integer>> output = new ArrayList<List<Integer>>();
//
//        // The base cases
//        if (n == 0) return output;
//        if (n == 1) {
//            int xStart = buildings[0][0];
//            int xEnd = buildings[0][1];
//            int y = buildings[0][2];
//
//            output.add(new ArrayList<Integer>() {{add(xStart); add(y); }});
//            output.add(new ArrayList<Integer>() {{add(xEnd); add(0); }});
//            // output.add(new int[]{xStart, y});
//            // output.add(new int[]{xEnd, 0});
//            return output;
//        }
//
//        // If there is more than one building,
//        // recursively divide the input into two subproblems.
//        List<List<Integer>> leftSkyline, rightSkyline;
//        leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, n / 2));
//        rightSkyline = getSkyline(Arrays.copyOfRange(buildings, n / 2, n));
//
//        // Merge the results of subproblem together.
//        return mergeSkylines(leftSkyline, rightSkyline);
//    }
//
//    /**
//     *  Merge two skylines together.
//     */
//    public List<List<Integer>> mergeSkylines(List<List<Integer>> left, List<List<Integer>> right) {
//        int nL = left.size(), nR = right.size();
//        int pL = 0, pR = 0;
//        int currY = 0, leftY = 0, rightY = 0;
//        int x, maxY;
//        List<List<Integer>> output = new ArrayList<List<Integer>>();
//
//        // while we're in the region where both skylines are present
//        while ((pL < nL) && (pR < nR)) {
//            List<Integer> pointL = left.get(pL);
//            List<Integer> pointR = right.get(pR);
//            // pick up the smallest x
//            if (pointL.get(0) < pointR.get(0)) {
//                x = pointL.get(0);
//                leftY = pointL.get(1);
//                pL++;
//            }
//            else {
//                x = pointR.get(0);
//                rightY = pointR.get(1);
//                pR++;
//            }
//            // max height (i.e. y) between both skylines
//            maxY = Math.max(leftY, rightY);
//            // update output if there is a skyline change
//            if (currY != maxY) {
//                updateOutput(output, x, maxY);
//                currY = maxY;
//            }
//        }
//
//        // there is only left skyline
//        appendSkyline(output, left, pL, nL, currY);
//
//        // there is only right skyline
//        appendSkyline(output, right, pR, nR, currY);
//
//        return output;
//    }
//
//    /**
//     * Update the final output with the new element.
//     */
//    public void updateOutput(List<List<Integer>> output, int x, int y) {
//        // if skyline change is not vertical -
//        // add the new point
//        if (output.isEmpty() || output.get(output.size() - 1).get(0) != x)
//            output.add(new ArrayList<Integer>() {{add(x); add(y); }});
//            // if skyline change is vertical -
//            // update the last point
//        else {
//            output.get(output.size() - 1).set(1, y);
//        }
//    }
//
//    /**
//     *  Append the rest of the skyline elements with indice (p, n)
//     *  to the final output.
//     */
//    public void appendSkyline(List<List<Integer>> output, List<List<Integer>> skyline,
//                              int p, int n, int currY) {
//        while (p < n) {
//            List<Integer> point = skyline.get(p);
//            int x = point.get(0);
//            int y = point.get(1);
//            p++;
//
//            // update output
//            // if there is a skyline change
//            if (currY != y) {
//                updateOutput(output, x, y);
//                currY = y;
//            }
//        }
//    }
}
