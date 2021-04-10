import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 * @author: Jayden
 * @date:4/1/21 10:41 PM
 */
public class Leetcode735 {
    public static void main(String[] args) {
        System.out.println(asteroidCollision(new int[]{-2, 2, 1, -2}));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroids[i]);
            } else if (-asteroids[i] >= stack.peek()) {
                if (-asteroids[i] > stack.peek()) i--;
                stack.pop();
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}

//for(int i: asteroids){
//        if(i > 0){
//        s.push(i);
//        }else{// i is negative
//        while(!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(i)){
//        s.pop();
//        }
//        if(s.isEmpty() || s.peek() < 0){
//        s.push(i);
//        }else if(i + s.peek() == 0){
//        s.pop(); //equal
//        }
//        }
//        }
