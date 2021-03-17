package bytedance;

/**
 * @Description:
 * @author: Jayden
 * @date:2/26/21 9:56 PM
 */
public class NewRoad {
    public static void main(String[] args) {
        Union uf = new Union(4);
        uf.union(0,1);
        uf.union(1,2);
        System.out.println(uf.getCount() - 1);
    }
}
