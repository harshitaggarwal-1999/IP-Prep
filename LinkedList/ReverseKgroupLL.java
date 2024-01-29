package LinkedList;

public class ReverseKgroupLL{
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, curr = dummy, ahead = dummy;
        int count = 0;
        while(curr.next !=null){
            curr = curr.next;
            count++;
        }

        while(count >= k){
            curr = pre.next;
            ahead = curr.next;
            for(int i = 1; i < k; i++){
                curr.next = ahead.next;
                ahead.next = pre.next;
                pre.next = ahead;
                ahead = curr.next;
            }
            pre = curr;
            count-=k;
        }
        return dummy.next;
    }
}