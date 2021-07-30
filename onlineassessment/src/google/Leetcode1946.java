package google;

/**
 * @Description:
 * @author: Jayden
 * @date:7/25/21 12:24 PM
 */
public class Leetcode1946 {
    public String maximumNumber(String num, int[] change){
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int value = chars[i] - '0';
            if (change[value] > value) {
                for (int j = value; j < num.length(); j++) {
                    if (change[j] >= chars[j] - '0') {
                        chars[j] = (char)(change[j] + '0');
                    } else {
                        break;
                    }
                }
                break;
            }
        }
        return new String(chars);
    }
}
