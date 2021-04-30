package amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: Jayden
 * @date:4/26/21 11:47 PM
 */
public class CloudFront {
    public static void main(String[] args) {
        int[][] connections = new int[][]{{2, 6}, {3, 5}, {0, 1}, {2, 9}, {5, 6}};
        CloudFront test = new CloudFront();
        System.out.println(test.costEvaluation(10, connections));
    }

    public int costEvaluationDfs(int n, int[][] connections) {
        int[][] M = new int[n][n];
        for (int i = 0; i < n; i++) {
            M[i][i] = 1;
        }
        for (int[] conn : connections) {
            int x = conn[0], y = conn[1];
            M[x][y] = 1;
            M[y][x] = 1;
        }
        int[] visited = new int[M.length];

        int cost = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                int numberWare = dfs(M, visited, i);
                cost += Math.ceil(Math.sqrt(numberWare));
            }
        }
        return cost;
    }
    public int dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                return 1 + dfs(M, visited, j);
            }
        }
        return 0;
    }



    public int costEvaluation(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        for (int[] conn : connections) {
            uf.union(conn[0], conn[1]);
        }
        return uf.getCost();
    }

    class UnionFind {
        private int count = 0;
        private int[] parent, rank;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];    // path compression by halving
                p = parent[p];
            }
            return p;
        }
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
//            for (int i = 0; i < parent.length; i++) {
//                if (parent[i] == rootP) {
//                    parent[i] = rootQ;
//                }
//            }
            if (rank[rootP] > rank[rootQ]) {
                parent[rootP] = rootQ;
                rank[rootQ] += rank[rootP];
            } else {
                parent[rootQ] = rootP;
                rank[rootP] += rank[rootQ];
            }
            count--;
        }
        public int count() {
            return count;
        }
        public int getCost() {
            int cost = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) {
                    cost += Math.ceil(Math.sqrt(rank[i]));
                }
            }
            return cost;
        }
    }
}
