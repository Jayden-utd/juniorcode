import java.util.PriorityQueue;

/**
 * @Description:
 * @author: Jayden
 * @date:3/5/21 11:38 AM
 */
public class FuckList {
    public static void main(String[] args) {
        FuckList test = new FuckList();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        pq.add(new int[]{1,4});
        pq.add(new int[]{1,5});
        System.out.println(pq.poll()[1]);


//
//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(4);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(2);
//        ListNode l5 = new ListNode(5);
//        ListNode l6 = new ListNode(2);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
//        l6.next = null;
//        ListNode cr = test.partition(l1, 3);
//        while (cr != null) {
//            System.out.println(cr.val);
//            cr = cr.next;
//        }

    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if(fast == null || fast.next == null) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
    //160 相交节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }
    //reverse 206
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev.next;
    }
    //reverse part of it 92
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        for (int i = m; i < n; i++) {
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return dummy.next;
    }
    //328
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return null;
        ListNode odd = head, even = head.next;
        ListNode evenHead = even;
        //point : 画图 分 奇数偶数 找到终止条件
        while (even != null && even.next != null) {
            odd.next = even.next;
            even.next = odd.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    //86
    public ListNode partition(ListNode head, int x) {
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;
        while (head!=null){
            if (head.val<x){
                before.next=head;
                before=before.next;
            }else {
                after.next=head;
                after=after.next;
            }
            head=head.next;
        }
        after.next=null;
        before.next=after_head.next;
        return before_head.next;
    }
    //203
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                ListNode tmp = cur;
                while (tmp.next != null && tmp.next.val == val) {
                    tmp = tmp.next;
                }
                cur.next = tmp.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
