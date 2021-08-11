/**
 * @Description:
 * @author: Jayden
 * @date:7/29/21 10:13 PM
 */
public class Leetcode547 {
    public int findCircleNum(int[][] isConnected) {
        Union uf = new Union(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    class Union {
        int number;
        int[] parent;
        int count;
        Union(int number) {
            this.count = count;
            this.number = number;
            this.parent = new int[number];
            for (int i = 0; i < number; i++) {
                parent[i] = i;
            }
        }

        public int find(int a) {
            while (parent[a] != a) {
                a = parent[a];
            }
            return a;
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return;
            parent[a] = pb;
            count--;
        }

        public int getPro() {
            return count;
        }
    }



}
