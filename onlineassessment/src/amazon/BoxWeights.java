package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description:
 * @author: Jayden
 * @date:4/26/21 3:44 PM
 */
public class BoxWeights {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(5);
        arr.add(2);
        arr.add(3);
        arr.add(1);
        arr.add(2);
        System.out.println(optimizingBoxWeights(arr));
    }
    public static List<Integer> optimizingBoxWeights(List<Integer> arr) {
        // WRITE YOUR BRILLIANT CODE HERE
        //聚合
        //map()和filter()都是Stream的转换方法，而Stream.reduce()则是Stream的一个聚合方法，
        // 它可以把一个Stream的所有元素按照聚合函数聚合成一个结果。
        int target = arr.stream().reduce(0, Integer::sum) / 2;
        System.out.println(target);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        pq.addAll(arr);
        int curSum = 0;
        List<Integer> res = new ArrayList<>();
        while (curSum <= target) {
            int val = pq.poll();
            curSum += val;
            res.add(val);
        }
        //Collections.reverse(res);
        return res;
    }
}
