package LinkedList;

public class SplitTheTwoCircularLLInTwoHalves {

    // Function  to split a circular LinkedList
    void splitList(circular_LinkedList list)
    {

        Node head=list.head;
        Node head1=null;
        Node head2=null;

        //step 1 find the mid Node of the circular LL:(given the head is the starting point of LL

        Node slow = head,fast = head;

        while(fast.next != head && fast.next.next != head){
            slow = slow.next;
            fast = fast.next.next;
        }

        head1 = head;
        head2 = slow.next;

        //seperating two LL

        if(fast.next.next == head){
            fast.next.next = slow.next;

        }else{
            fast.next = slow.next;

        }

        slow.next = head;

        //DO NOT REMOVE THESE 2 LINES
        list.head1=head1;
        list.head2=head2;

    }
}