import java.util.Stack;

/**
 * @Description:
 * @author: Jayden
 * @date:3/28/21 6:12 PM
 */
public class Leetcode151 {
    private Stack<Integer> data;
    private Stack<Integer> helper;

    /** initialize your data structure here. */
    public Leetcode151() {
        data=new Stack<>();
        helper=new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if(helper.isEmpty() || helper.peek()>=x){
            helper.push(x);
        }else{
            helper.push(helper.peek());
        }
    }

    public void pop() {
        if(!data.isEmpty()){
            data.pop();
            helper.pop();
        }
    }

    public int top() {
        if(!data.isEmpty()){
            return data.peek();
        }
        return -1;
    }

    public int getMin() {
        if(!helper.isEmpty()){
            return helper.peek();
        }
        return -1;
    }
}

//这个题如果 push进去的值不是 2^31，那么突破点就是 可以不用2个stack，用一个 存差值
//public class 设计一个有gitMin的栈 {
//
//    private Stack<Integer> stack = new Stack<Integer>();
//    private int min;
//
//    public void push(int x) {
//        if (stack.isEmpty()) {
//            min = x;
//            stack.push(0);
//        } else {
//            // 计算差值
//            int compare = x - min;
//            stack.push(compare);
//            // 如果差值小于0，显然 x 成为最小值，否则最小值不变
//            min = compare < 0 ? x : min;
//        }
//    }
//
//    public void pop() {
//        int top = stack.peek();
//        // 如果top小于0，显然最小值也一并会被删除，此时更新最小值
//        min = top < 0 ? (min - top) : min;
//        stack.pop();
//    }
//
//    public int getMin() {
//        return min;
//    }
//}