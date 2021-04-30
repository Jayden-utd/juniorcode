package amazon;

import java.util.*;

/**
 * @Description:
 * @author: Jayden
 * @date:4/26/21 9:59 AM
 */
public class TransactionLogs {
    public static void main(String[] args) {

    }
    public static List<String> getFraudIds(List<List<String>> logData, int threshold) {
        List<String> list = new LinkedList();
        Map<String, Integer> map = new TreeMap(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int i1 = Integer.parseInt(s1);
                int i2 = Integer.parseInt(s2);
                if (i2 > i1) return 1;
                if (i1 > i2) return -1;
                return 0;
            }
        });
        for (List<String> log : logData) {
            Set<String> set = new HashSet();
            set.add(log.get(0));
            set.add(log.get(1));
            for (String s : set) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() >= threshold) list.add(e.getKey());
        }
        return list;
    }
}
