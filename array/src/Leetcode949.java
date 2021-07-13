/**
 * @Description:
 * @author: Jayden
 * @date:6/30/21 10:22 AM
 */
public class Leetcode949 {

    //only 4 digits 4!=24 but index sum equal to 6

    public String largestTimeFromDigits(int[] arr) {
        String res = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i == j || i == k || j == k) continue;
                    String hour = "" + arr[i] + arr[j];
                    String minute = "" + arr[k] + arr[6 - i - j - k];
                    String date = hour + ":" + minute;
                    if(hour.compareTo("24") < 0 && minute.compareTo("60") < 0 && res.compareTo(date) < 0) {
                        res = date;
                    }
                }
            }
        }
        return res;
    }
}
