import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Jayden
 * @date:4/10/21 9:30 AM
 */
public class Leetcode89 {
    public static void main(String[] args) {
        System.out.println(grayCode2(3));
    }
    //gray code
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int add = 1 << i;
            for (int j = list.size() - 1; j >= 0; j--) {
                list.add(list.get(j) + add);
            }
        }
        return list;
    }

    public static List<Integer> grayCode2(int n) {
        List<Integer> gray = new ArrayList<Integer>();
        gray.add(0); //初始化第零项
        for (int i = 1; i < 1 << n; i++) {
            //得到上一个的值
            int previous = gray.get(i - 1);
            //同第一项的情况
            if (i % 2 == 1) {
                previous ^= 1; //和 0000001 做异或，使得最右边一位取反
                gray.add(previous);
                //同第二项的情况
            } else {
                int temp = previous;
                //寻找右边起第第一个为 1 的位元
                for (int j = 0; j < n; j++) {
                    if ((temp & 1) == 1) {
                        //和 00001000000 类似这样的数做异或，使得相应位取反
                        previous = previous ^ (1 << (j + 1));
                        gray.add(previous);
                        break;
                    }
                    temp = temp >> 1;
                }
            }
        }
        return gray;
    }

     public List<Integer> grayCodeEasy(int n) {
         List<Integer> list = new ArrayList<>();
         for (int i = 0; i < Math.pow(2, n); i++) {
             list.add((i >> 1) ^ i);
         }
         return list;
     }
}
