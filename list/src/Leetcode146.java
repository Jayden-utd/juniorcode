import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Description:
 * @author: Jayden
 * @date:5/15/21 11:47 AM
 */
public class Leetcode146 {
    // store key value to be able to get the value by key with constatn time
    private Map<Integer, Integer> map;
    LinkedList<Integer> list;
    int size;
    public Leetcode146(int capacity) {
        this.map  = new HashMap();
        this.list = new LinkedList<>();
        this.size = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            // remove key from the queue
            list.remove((Integer) key);
            // move the new key to the end (head)
            list.addLast(key);
            // get value from map
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) list.remove((Integer) key);
        list.addLast(key);
        if (list.size() > this.size) {
            int lastKey = list.removeFirst();
            map.remove(lastKey);
        }
        map.put(key, value);
    }
}
