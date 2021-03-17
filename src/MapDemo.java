import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: Jayden
 * @date:2/22/21 7:56 PM
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(null, 1);
        map.put(null, 3);
        System.out.println(map.get(null));

    }
}
