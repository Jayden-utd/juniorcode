import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description:
 * @author: Jayden
 * @date:3/10/21 11:20 AM
 */
public class Leetcode23 {
//    public ListNode mergeKLists(ListNode[] lists) {
//        return dc(lists, 0, lists.length - 1);
//    }
//    public ListNode dc(ListNode[] lists, int left, int right) {
//        if (left==right) return lists[left];
//        int mid = left + (right - left) / 2;
//        ListNode l1 = dc(lists, left, mid);
//        ListNode l2 = dc(lists, mid + 1, right);
//        return merge(l1, l2);
//    }
//    public ListNode merge(ListNode l1, ListNode l2) {
//        ListNode dummy = new ListNode(0);
//        ListNode prev = dummy;
//        while (l1 != null && l2 != null) {
//            if(l1.val< l2.val){
//                prev.next=l1;
//
//                l1=l1.next;
//            }else {
//                prev.next=l2;
//                l2=l2.next;
//            }
//            prev=prev.next;
//        }
//        prev.next = l1 == null ? l2 : l1;
//        return dummy.next;
//    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>((o1, o2) -> (o1.val - o2.val));

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
