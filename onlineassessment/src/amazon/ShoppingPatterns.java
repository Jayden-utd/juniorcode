package amazon;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description:
 * @author: Jayden
 * @date:4/27/21 6:08 PM
 */
public class ShoppingPatterns {
    public static int shoppingPatterns(int productsNodes, List<Integer> productsFrom, List<Integer> productsTo) {
        List<HashSet<Integer>> neighbors = IntStream.range(0, productsNodes).mapToObj(i -> new HashSet<Integer>()).collect(Collectors.toList());
        for (int i = 0; i < productsFrom.size(); i++) {
            // convert from 1-based to 0-based indexing
            int u = productsFrom.get(i) - 1;
            int v = productsTo.get(i) - 1;
            neighbors.get(u).add(v);
            neighbors.get(v).add(u);
        }
        int minSum = Integer.MAX_VALUE;
        // all (u, v, w) where
        // - (u, v), (v, w), (u, w) are neighbors (trio)
        // - u < v < w (to avoid duplicates, as optimization)
        for (int u = 0; u < neighbors.size(); u++) {
            HashSet<Integer> u_ns = neighbors.get(u);
            for (int v : u_ns) {
                if (v < u)
                    continue;
                for (int w : u_ns) {
                    HashSet<Integer> v_ns = neighbors.get(v);
                    if (w < u || !v_ns.contains(w))
                        continue;
                    HashSet<Integer> w_ns = neighbors.get(w);
                    // each neighbors set include the other 2 in the trio,
                    // which we don't count in product score
                    int curSum = u_ns.size() + v_ns.size() + w_ns.size() - 6;
                    minSum = Math.min(minSum, curSum);
                }
            }
        }
        return minSum != Integer.MAX_VALUE ? minSum : -1;
    }

}