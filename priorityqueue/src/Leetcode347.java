import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description:
 * @author: Jayden
 * @date:3/10/21 11:07 AM
 */
public class Leetcode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (map.get(o1) - map.get(o2)));
        for(int n : map.keySet()) {
            pq.offer(n);
            if (pq.size() > k) pq.poll();
        }
        int[] top_k=new int[k];
        for (int i = 0; i < k; i++) {
            top_k[i]=pq.poll();
        }
        return top_k;
    }
}
