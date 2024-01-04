package LinkedList;

class Node {
    int data;
    Node next, random;

    Node(int x) {
        data = x;
        next = random = null;
    }
}

public class cloneALinkedList {
    public static void main(String[] args) {
        // Creating a linked list with random pointer
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;

        // Print the original list
        System.out.println("The original linked list:");
        printList(head);

        // Function call
        Node sol = cloneLinkedList(head);

        System.out.println("The cloned linked list:");
        printList(sol);
    }

    public static Node cloneLinkedList(Node head) {
        if(head == null)return null;

        // step 1 mapping
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.data);

            newNode.next = curr.next;
            curr.next = newNode;

            curr = newNode.next;
        }
        // now a mapped node with clone is ready now we have to set the random pointers

        // step 2 setting the random pointers
        curr = head;
        while(curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        // now random piinters are also set now we have to segregate the two linked list

        //step 3 segregating the linked list
        curr = head;
        Node clonedCurr = head.next;
        Node clonedHead = head.next;

        while(clonedCurr.next != null){
            curr.next = curr.next.next;
            clonedCurr.next  = clonedCurr.next.next;

            curr = curr.next;
            clonedCurr = clonedCurr.next;
        }

        clonedCurr.next = null;
        curr.next = null;


        return clonedHead;
    }

    // Function to print the linked list
    public static void printList(Node head) {
        System.out.print(head.data + "(" + head.random.data + ")");
        head = head.next;
        while (head != null) {
            System.out.print(" -> " + head.data + "(" + head.random.data + ")");
            head = head.next;
        }
        System.out.println();
    }
}
