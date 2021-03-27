/**
 * @Description:
 * @author: Jayden
 * @date:3/26/21 10:48 AM
 */
public class Leetcode24 {
    //list题 1.dummy节点  2.画图  3 试试recursive
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode n = head.next;
        head.next = swapPairs(n.next);
        n.next = head;
        return n;
    }
}
