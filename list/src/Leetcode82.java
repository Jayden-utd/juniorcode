/**
 * @Description:
 * @author: Jayden
 * @date:3/28/21 8:21 PM
 */
public class Leetcode82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        cur.next = head;
        while (head != null && head.next != null) {
            if (cur.next.val == head.next.val) {
                while (head.next != null && cur.next.val == head.next.val) {
                    head = head.next;
                }
                cur.next = head.next;
                head = head.next;

            } else {
                cur = cur.next;
                head = head.next;
            }

        }
        return dummy.next;
    }

}
