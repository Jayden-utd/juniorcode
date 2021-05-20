/**
 * @Description:
 * @author: Jayden
 * @date:5/18/21 10:16 AM
 */
public class Leetcode12 {
    public static void main(String[] args) {
        Leetcode12 test = new Leetcode12();
        System.out.println(test.intToRoman(3000));
    }
    //loop over each symbol, from largest to smallest,
    // checking how many copies of the current symbol fit into the remaining integer.
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < values.length && num>=0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i]<=num){
                num-=values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}
