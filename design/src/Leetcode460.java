import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Description:
 * @author: Jayden
 * @date:5/2/21 7:43 PM
 */
public class Leetcode460 {
    // key 到 val 的映射，我们后文称为 KV 表
    Map<Integer, Integer> keyToVal;
    // key 到 freq 的映射，我们后文称为 KF 表
    Map<Integer, Integer> keyToFreq;
    // freq 到 key 列表的映射，我们后文称为 FK 表
    Map<Integer, LinkedList<Integer>> freqToKeys;
    // 记录最小的频次
    int minFreq;
    // 记录 LFU 缓存的最大容量
    int cap;
    public Leetcode460(int capacity) {
        this.keyToVal = new HashMap<>();
        this.keyToFreq = new HashMap<>();
        this.freqToKeys = new HashMap<>();
        this.minFreq = 0;
        this.cap = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if(cap<=0)
            return;
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }

        if (this.cap <= keyToVal.size()) {
            removeMinFreqKey();
        }
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedList<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }

    private void removeMinFreqKey() {
        LinkedList<Integer> keyList = freqToKeys.get(this.minFreq);
        int deletedKey = keyList.iterator().next();
        keyList.remove((Object)deletedKey);
        if (keyList.isEmpty()) freqToKeys.remove(this.minFreq);
        keyToVal.remove(deletedKey);
        keyToFreq.remove(deletedKey);
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        freqToKeys.get(freq).remove((Object)key);
        freqToKeys.putIfAbsent(freq + 1, new LinkedList<>());
        freqToKeys.get(freq + 1).add(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == minFreq) {
                this.minFreq++;
            }
        }
    }
}
