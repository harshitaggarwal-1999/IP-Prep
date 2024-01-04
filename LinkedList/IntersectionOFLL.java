package LinkedList;

public class IntersectionOFLL {
    //Function to find intersection point in Y shaped Linked Lists.
    int size(Node head) {
        if (head == null) {
            return 0;
        }
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;

    }

    int intersectPoint(Node head1, Node head2) {
        // code here

        //step 1 get the sizes of both LL
        int size1 = size(head1);
        int size2 = size(head2);


        // Step 2 : find the difference of both LLs
        int diff = Math.abs(size1 - size2);


        // step 3 : to find which LL is bigger
        Node toMove = null; // the node which needs to be moved
        boolean head1Bigger = false; // to identify which node needs to be moved and which LL node will be starting from head itself

        if (size1 > size2) {
            toMove = head1;
            head1Bigger = true;
        } else {
            toMove = head2;
        }

        // step 4 : move the lengthier LL by the differnce steps ahead
        while (diff-- > 0) {
            toMove = toMove.next;
        }

        //step 5: find the intersection point by moving the both pointers and to assign which was bigger
        Node curr1 = null;
        Node curr2 = null;
        if (head1Bigger) {
            curr1 = toMove;
            curr2 = head2;

        } else {
            curr1 = head1;
            curr2 = toMove;
        }

        Node ans = null;
        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2) {
                ans = curr1;
                break;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        // shows that while iterating the LL reached to the end means there is no intersection point
        if (ans == null) {
            return -1;
        }

        return ans.data;

    }
}


