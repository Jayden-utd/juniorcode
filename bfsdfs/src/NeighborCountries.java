import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @author: Jayden
 * @date:5/10/21 2:58 PM
 */
public class NeighborCountries {
    public static int maxNeighbor(char[][] nations) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < nations.length; i++) {
            for (int j = 0; j < nations[0].length; j++) {
                char nation = nations[i][j];
                dfs(i, j, nations, map, nation);
            }
        }
        int result = 0;
        for (Set s : map.values()) {
            result = Math.max(result, s.size());
        }
        return result;
    }

    public static void dfs(int i, int j, char[][] nations, Map<Character, Set<Character>> map, char nation) {
        if (i < 0 || i >= nations.length || j < 0 || j >= nations[0].length) {
            return;
        }else if (nations[i][j] != '*' && nations[i][j] != nation) {
            if (map.get(nation) == null) {
                Set<Character> set = new HashSet<>();
                map.put(nation,set);
            }
            map.get(nation).add(nations[i][j]);
            return;
        }else if (nations[i][j] == '*') {
            return;
        }
        char temp = nations[i][j];
        nations[i][j] = '*';
        dfs(i+1, j, nations, map, nation);
        dfs(i-1, j, nations, map, nation);
        dfs(i, j+1, nations, map, nation);
        dfs(i, j-1, nations, map, nation);
        nations[i][j] = temp;
    }



    public static void main(String[] args) {
        char[][] nations = {{'A','A','B','B','C'},
                {'A','B','B','C','C'},
                {'D','E','E','E','G'},
                {'D','E','F','F','G'},};

        System.out.println(maxNeighbor(nations));
    }
}
