package bytedance;

/**
 * @Description:
 * @author: Jayden
 * @date:2/26/21 9:56 PM
 */
public class Union {
    private int count;
    private int[] roots;
    Union(int n) {
        this.count = n;
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
    }
    public int find(int p) {
        while (roots[p] != p) {
            //roots[p] = roots[roots[p]];
            p = roots[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        // 将两棵树合并为一棵
        roots[rootP] = rootQ;
        // parent[rootQ] = rootP 也可以
        count--;
    }
    public int getCount() {
        return count;
    }
}
