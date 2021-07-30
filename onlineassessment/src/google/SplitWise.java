package google;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * @Description:
 * @author: Jayden
 * @date:7/19/21 3:53 PM
 */
public class SplitWise {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        p1.idx = 0;
        p2.idx = 1;
        p3.idx = 2;
        Person[] persons = {p1, p2, p3};
        SplitWise splitWise = new SplitWise(persons);
        splitWise.addDebt(0, 1, 10);
        splitWise.addDebt(0, 1, 10);
    }

    static class Edge{
        int from, to, amount;

        public Edge(int from, int to, int amount) {
            this.from = from;
            this.to = to;
            this.amount = amount;
        }
    }
    static class Person{
        int idx;
        Map<Integer, Integer> mp = new HashMap<>();
    }
    Person[] persons;
    int[] pars;
    public SplitWise(Person[] persons) {
        this.persons = persons;
        pars = new int[persons.length];
        Arrays.fill(pars, -1);
    }

    void addDebt(int from, int to, int amount){
        if (find(from, pars) == find(to, pars)){
//            they are already connected, when it is a loop we can remove this edge with dfs
            dfs(from, -1, to, -amount);
        }else{
            persons[from].mp.put(to, amount);
            persons[to].mp.put(from, -amount);
            union(persons[from].idx, persons[to].idx, pars);
        }
    }

    boolean dfs(int curPerson, int parent, int targetPerson, int amount){
        Map<Integer, Integer> mp = persons[curPerson].mp;
        if (curPerson == targetPerson) {
            return true;
        }else{
            int nxtId = -1;
            for(int nxt : mp.keySet()){
                if (nxt == parent) continue;
                if (dfs(nxt, curPerson, targetPerson, amount)){
                    nxtId = nxt;
                    break;
                }
            }
            if (nxtId != -1){
                int curAmount = mp.get(nxtId);
//            update the edge
                mp.put(nxtId, curAmount - amount);
//            update the reverse edge
                persons[nxtId].mp.put(curPerson, amount - curAmount);
                return true;
            }else{
                return false;
            }
        }
    }

    int dfs(int cur, int tar, int parent){
        if (cur == tar) return 0;
        for(int idx : persons[cur].mp.keySet()){
            if (idx == parent) continue;
            int get = dfs(idx, tar, cur);
            if (get >= 0){
//                may have some problem with minus or addition
                return (persons[cur].mp.get(idx) + get);
            }
        }
        return -1;
    }

    int getDebt(int from, int to){
        return dfs(from, to, -1);
    }


    //    union find template
    static int find(int i, int[] par){
        if (par[i] < 0) return i;
        return par[i] = find(par[i], par);
    }
    static boolean union(int i, int j, int[] par){
        int pi = find(i, par);
        int pj = find(j, par);
        if (pi == pj) return false;
        if (par[pi] < par[pj]){
            par[pi] += par[pj];
            par[pj] = pi;
        }else{
            par[pj] += par[pi];
            par[pi] = pj;
        }
        return true;
    }


}
