package LinkedList;

public class clientLL {
    public static void main(String[] args) throws Exception {
        LinkedList ll = new LinkedList();
        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.display();

        ll.addFirst(5);
        ll.display();

        ll.addLast(40);
        ll.addFirst(1);
        ll.display();

        // ll.getFirst();
        // ll.getLast();

        // ll.getAtI(0);
        // ll.getAtI(6);
        // ll.getAtI(5);

        // ll.addAt(35, 5);
        // ll.display();

        // ll.addAt(45, 7);
        // ll.display();

        // ll.removeFirst();
        // ll.display();

        
        // ll.removeLast();
        // ll.display();
        // ll.removeLast();
        // ll.display();
        // ll.removeLast();
        // ll.display();
        // ll.removeLast();
        // ll.display();
        // ll.removeLast();
        // ll.display();
        // ll.removeLast();
        // ll.display();

//        ll.removeAtI(3);
//        ll.display();
//        ll.removeAtI(3);
//        ll.removeAtI(3);
//        ll.display();

//        ll.reverseData();
//        ll.display();
//
//        ll.reverseLLByPointers();
//        ll.display();

//        ll.midNode();

        System.out.println(ll.kthNodeForTail(4));
    }
    
}
