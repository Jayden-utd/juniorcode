import java.util.Arrays;

/**
 * @Description:
 * @author: Jayden
 * @date:5/10/21 9:49 PM
 */
public class Leetcode973 {
    public static void main(String[] args) {
        Leetcode973 test = new Leetcode973();
        test.kClosest(new int[][]{{6, 6}, {1, 1}}, 1);

    }
    public int[][] kClosest(int[][] points, int K) {
        // 使用快速选择（快排变形） 获取 points 数组中距离最小的 K 个点（第 4 个参数是下标，因此是 K - 1）
        return quickSelect(points, 0, points.length - 1, K - 1);
    }
    public int[][] quickSelect(int[][] points, int lo, int hi, int idx) {
        int j = partition(points, lo, hi);
        if (j == idx) return Arrays.copyOf(points, idx + 1);
        return j < idx ? quickSelect(points, j + 1, points.length - 1, idx) : quickSelect(points, 0, j - 1, idx);
    }
    public int partition(int[][] points, int lo, int hi) {
        int[] v = points[lo];
        int dist = v[0] * v[0] + v[1] * v[1];
        int i = lo, j = hi;
        while (i < j) {
            while (i < j && points[j][0] * points[j][0] + points[j][1] * points[j][1] >= dist) j--;
            while (i < j && points[i][0] * points[i][0] + points[i][1] * points[i][1] <= dist) i++;
            if (i < j) {
                int[] tmp = points[i];
                points[i] = points[j];
                points[j] = tmp;
            }
        }
        points[lo] = points[i];
        points[i] = v;
        return i;
    }

}
