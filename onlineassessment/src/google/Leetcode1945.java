package google;

/**
 * @Description:
 * @author: Jayden
 * @date:7/24/21 9:50 PM
 */
public class Leetcode1945 {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }
        s = sb.toString();
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (char c : s.toCharArray()) {
                sum += c - '0';
            }
            s = Integer.toString(sum);
        }
        return Integer.parseInt(s);
    }
}
