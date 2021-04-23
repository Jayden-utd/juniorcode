import java.util.Arrays;

/**
 * @Description:
 * @author: Jayden
 * @date:4/20/21 9:52 AM
 */
public class Leetcode1135 {
    //Kruskal MST and union find
    public int minimumCost(int N, int[][] connections) {
        UF uf = new UF(N);
        int res = 0;
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        for (int[] conn : connections) {
            if(uf.union(conn[0]-1, conn[1]-1)) {
                res += conn[2];
            }

        }
        return uf.getCompnent() == 1 ? res : -1;

    }
    class UF {
        int compnent;
        int[] parent;
        UF(int n) {
            this.compnent = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public boolean union(int p, int q) {
            int pv1 = find(p);
            int pv2 = find(q);
            if (pv1 == pv2) return false;
            parent[pv1] = pv2;
            compnent--;
            return true;
        }
        public int find(int v) {
            while (parent[v] != v) {
                v = parent[v];
            }
            return v;
        }
        public int getCompnent() {
            return compnent;
        }
    }
}
