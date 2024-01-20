package LinkedList;

public class PalindromeCheck  {
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            // if size == 0 || size == 1 then just return head;
            return head;
        }
        ListNode prev = null, curr = head, forw = null;

        while(curr != null){
            forw = curr.next;

            curr.next = prev;
            prev = curr;
            curr = forw;
        }

        return prev;
    }

    public ListNode midNode(ListNode head){
        // find the mid element and return the mid
        if(head == null || head.next == null) return head;

        ListNode slow = head, fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = midNode(head);
        ListNode newHead = reverse(mid);

        mid.next = null;
        // till now we have segreggated both LL and both are ready for travesrals
        ListNode c1 = head;
        ListNode c2 = newHead;

        // boolean because if we directly return amswer from here this will make our given LL modified which is wrong practice so we will store answer in some boolean assuming given new LLs are palindrome and wheneever we find that they are not equal we will update our boolean ans break the loop
        boolean res = true;
        while(c1 != null && c2 != null){
            if(c1.val != c2.val){
                res = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        }

        // now first reverse the second(or new LL)
        newHead = reverse(newHead);

        // then join mid to newhead just recieved
        mid.next = newHead;

        return res;
    }
}