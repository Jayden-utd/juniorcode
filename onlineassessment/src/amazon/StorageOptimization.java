package amazon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @author: Jayden
 * @date:4/26/21 3:52 PM
 */
public class StorageOptimization {
    public static void main(String[] args) {
        List<Integer> h = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        h.add(2);
        h.add(3);
        v.add(3);
        System.out.println(storageOptimization(5, 5, h, v));
    }

    private static int longest(List<Integer> arr) {
        arr.sort(null);
        int last = -1;
        int consec = 0;
        int maxConsec = 0;
        for (int val : arr) {
            if (val != last + 1)
                consec = 0;
            last = val;
            consec++;
            maxConsec = Math.max(maxConsec, consec);
        }
        return maxConsec;
    }
    public static int storageOptimization(int n, int m, List<Integer> h, List<Integer> v) {
        return (longest(h) + 1) * (longest(v) + 1);
    }


//    public static int storageOptimization(int n, int m, List<Integer> h, List<Integer> v) {
//        Collections.sort(h);
//        Collections.sort(v);
//        int height = n + 1, width = m + 1, H = Math.max(h.get(0),
//                height - h.get(h.size() - 1)),
//                V = Math.max(v.get(0), width - v.get(v.size() - 1));
//        for (int i = 1; i < h.size(); ++i) {
//            H = Math.max(H, h.get(i)- h.get(i - 1));
//        }
//        for (int i = 1; i < v.size(); ++i) {
//            V = Math.max(V, v.get(i)- v.get(i - 1));
//        }
//        return H * V;
//    }
}
