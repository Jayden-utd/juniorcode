package weektest;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Description:
 * @author: Jayden
 * @date:3/20/21 10:32 PM
 */
public class Leetcode1801 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        TreeMap<Integer, Long> buy = new TreeMap();
        TreeMap<Integer, Long> sell = new TreeMap();
        for(int []order: orders){
            long orderCount = order[1];
            if(order[2] == 0){
                while(true){
                    Map.Entry<Integer, Long> me = sell.firstEntry();
                    if(orderCount == 0 || me == null || me.getKey() > order[0]){
                        break;
                    }
                    if(me.getValue() <= orderCount){
                        sell.remove(me.getKey());
                    }else{
                        sell.put(me.getKey(), me.getValue() - orderCount);
                    }
                    orderCount = Math.max(0, orderCount - me.getValue());
                }
                if(orderCount != 0)
                    buy.put(order[0], buy.getOrDefault(order[0], 0L) + orderCount);
            }else{
                while(true){
                    Map.Entry<Integer, Long> me = buy.lastEntry();
                    if(orderCount == 0 || me == null || me.getKey() < order[0]){
                        break;
                    }
                    if(me.getValue() <= orderCount){
                        buy.remove(me.getKey());
                    }else{
                        buy.put(me.getKey(), me.getValue() - orderCount);
                    }
                    orderCount = Math.max(0, orderCount - me.getValue());
                }
                if(orderCount != 0)
                    sell.put(order[0], sell.getOrDefault(order[0], 0L) + orderCount);
            }
        }
        long ans = 0;
        for(Long i: buy.values()){
            ans += i;
        }
        for(Long i: sell.values()){
            ans += i;
        }
        return (int)(ans % 1000000007);
    }
}
