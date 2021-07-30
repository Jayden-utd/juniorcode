package google;

import java.util.*;

/**
 * @Description:
 * @author: Jayden
 * @date:7/29/21 5:06 PM
 */
public class Result {
    public static void main(String[] args) {
        Result res = new Result();
//        ArrayList<Connection> connections = new ArrayList<>();
//        connections.add(new Connection("A", "B", 1));
//        connections.add(new Connection("B", "C", 4));
//        connections.add(new Connection("B", "D", 6));
//        connections.add(new Connection("D", "E", 5));
//        connections.add(new Connection("C", "E", 1));
        List<List<String>> connection = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            connection.add(new ArrayList<>());
        }
        connection.get(0).add("A");
        connection.get(0).add("B");
        connection.get(0).add("1");
        connection.get(1).add("B");
        connection.get(1).add("C");
        connection.get(1).add("4");

        connection.get(2).add("B");
        connection.get(2).add("D");
        connection.get(2).add("6");
        connection.get(3).add("D");
        connection.get(3).add("E");
        connection.get(3).add("5");
        connection.get(4).add("C");
        connection.get(4).add("E");
        connection.get(4).add("1");



        List<List<String>> result = res.minimizeCost(connection);
        if (result != null) {
            for (List<String> cur : result)
                System.out.println(cur.get(0) + ", " + cur.get(1) + ", " + cur.get(2));
        }
    }


    static class Connection {
        String firstTown;
        String secondTown;
        int cost;

        Connection() {

        }

        Connection(String t1, String t2, int c) {
            firstTown = t1;
            secondTown = t2;
            cost = c;
        }
    }

    List<List<String>> minimizeCost(List<List<String>> connection){
        ArrayList<Connection> ls = new ArrayList<>();
        for(List<String> s : connection) ls.add(new Connection(s.get(0), s.get(1), Integer.valueOf(s.get(2))));
        ArrayList<Connection> res = minimumCostConnection(ls);
        return convertConnectionIntoString(res);
    }

    List<List<String>> convertConnectionIntoString(ArrayList<Connection> connections){
        List<List<String>> res = new ArrayList<>();
        for(Connection connection : connections){
            res.add(List.of(connection.firstTown, connection.secondTown, String.valueOf(connection.cost)));
        }
        return res;
    }

    public ArrayList<Connection> minimumCostConnection(ArrayList<Connection> connections) {
        // WRITE YOUR CODE HERE
        PriorityQueue<Connection> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a.cost, b.cost);
        });
        Map<String, String> mp = new HashMap<>();
        Map<String, Integer> pars = new HashMap<>();
        for (Connection c : connections) {
            pq.add(c);
            String s1 = c.firstTown;
            String s2 = c.secondTown;
            if (!mp.containsKey(s1)) {
                mp.put(s1, s1);
                pars.put(s1, 1);
            }
            if (!mp.containsKey(s2)) {
                mp.put(s2, s2);
                pars.put(s2, 1);
            }
        }
        ArrayList<Connection> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            Connection c = pq.poll();
            if (find(mp, c.firstTown).equals(find(mp, c.secondTown))) {
                continue;
            } else {
                union(mp, c.firstTown, c.secondTown, pars);
                res.add(c);
            }
        }
        Collections.sort(res, (a, b) -> {
            if (a.firstTown.equals(b.firstTown)) return a.secondTown.compareTo(b.secondTown);
            return a.firstTown.compareTo(b.firstTown);
        });
        if (pars.size() != 1) {
            return null;
        }
        return res;
    }

    String find(Map<String, String> mp, String v) {
        if (mp.get(v).equals(v)) {
            return v;
        }
        String get = find(mp, mp.get(v));
        mp.put(v, get);
        return get;
    }

    void union(Map<String, String> mp, String v1, String v2, Map<String, Integer> pars) {
        String p1 = find(mp, v1);
        String p2 = find(mp, v2);
        if (p1.equals(p2)) return;
        int val1 = pars.get(p1);
        int val2 = pars.get(p2);
        if (val1 > val2) {
            pars.put(p1, pars.getOrDefault(p1, 0) + val2);
            pars.remove(p2);
            mp.put(p2, p1);
        } else {
            pars.put(p2, pars.getOrDefault(p2, 0) + val1);
            pars.remove(p1);
            mp.put(p1, p2);
        }
    }
}
