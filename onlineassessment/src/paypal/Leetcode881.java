package paypal;

import java.util.Arrays;

/**
 * @Description:
 * @author: Jayden
 * @date:7/25/21 4:16 PM
 */
public class Leetcode881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boat = 0;
        int i = 0, j = people.length - 1;
        while (i <= j) {
            if (i == j) {
                boat++;
                break;
            }
            if (people[i] + people[j] <= limit) {
                boat++;
                i++;
                j--;
            } else {
                j--;
                boat++;
            }
        }
        return boat;
    }

    public int numRescueBoatsClean(int[] people, int limit) {
        Arrays.sort(people);
        int i, j;
        for (i = 0, j = people.length - 1; i <= j; j--) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
        }
        return people.length - 1 - j;
    }
}
