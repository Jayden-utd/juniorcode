/**
 * @Description:
 * @author: Jayden
 * @date:3/27/21 3:00 PM
 */
public class UnionFind {
    int count;
    int[] roots;
    UnionFind(int n) {
        this.count = n;
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
    }
    int find(int p) {
        if (roots[p] == p) return p;
        return roots[p] = find(roots[p]);
    }

    boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
    void union(int p, int q) {
        roots[find(p)] = find(q);
        count--;
    }
    public int count() {
        return count;
    }
}
