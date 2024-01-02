package LinkedList;

public class LinkedList {
    private class Node {
        int val;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    public void display() {
        System.out.println("-------------------------------------");

        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.val + " , ");
            temp = temp.next;
        }
        System.out.print(" . ");
        System.out.println();
        System.out.println("--------------------------------------");
    }

    public void addLast(int item) {

        Node nn = new Node();
        nn.val = item;
        nn.next = null;
        // new node creation

        // Node nn = new Node(item, null);

        // attach
        if (this.size >= 1) {
            this.tail.next = nn;
        }

        // summary updation
        if (this.size == 0) {
            this.head = nn;
            this.tail = nn;
            this.size++;
        } else {
            this.tail = nn;
            this.size++;
        }
    }

    public void addFirst(int item) {
        Node nn = new Node();
        nn.val = item;
        nn.next = null;

        if (size >= 1) {
            nn.next = this.head;
        }
        // summary updation
        if (size == 0) {
            this.head = nn;
            this.tail = nn;
            this.size++;
        } else {
            this.head = nn;
            this.size++;
        }
    }

    public void getFirst() {
        System.out.println(this.head.val);
    }

    public void getLast() {
        System.out.println(this.tail.val);
    }

    public void getAtI(int counter) {
        if (this.size == 0) {
            System.out.println("LL is Empty");
            return;
        }
        Node nn = head;
        if (counter < 0 || counter + 1 > size) {
            System.out.println("out Of Range");
            return;
        }
        while (counter-- > 0) {
            nn = nn.next;
        }
        System.out.println("val is : " + nn.val);
    }

    private Node getNodeAtI(int counter) throws Exception {
        if (this.size == 0) {
            throw new Exception("LL is Empty");
        }
        Node nn = head;
        if (counter < 0 || counter + 1 > size) {
            throw new Exception("Invalid index");
        }
        while (counter-- > 0) {
            nn = nn.next;
        }
        return nn;
    }

    public void addAt(int item, int idx) throws Exception {

        if (idx < 0 || idx > size) {
            throw new Exception("Out Of Index");
        }

        if (idx == 0) {
            addFirst(item);
        } else if (idx == size) {
            addLast(item);
        } else {
            // make new node
            Node nn = new Node();
            nn.val = item;
            nn.next = null;

            // attach
            Node nm1 = getNodeAtI(idx - 1);
            Node nm2 = nm1.next;

            nm1.next = nn;
            nn.next = nm2;

            // summary updation
            this.size++;

        }

    }

    public void removeFirst() throws Exception {

        if (size <= 0)
            throw new Exception("List is already Empty");
        // detach
        if (size == 1) {
            head = null;
        } else {
            Node temp = head.next;
            head.next = null;
            head = temp;
        }

        // summary updation
        this.size--;
    }

    public void removeLast() throws Exception {
        System.out.println("remove last called");

        if (size <= 0)
            throw new Exception("List is already Empty");

        // detach
        if (size > 1) {
            Node tn = getNodeAtI(this.size - 2);
            tn.next = null;
            this.tail = tn;
        } else {
            this.head = null;
            this.tail = null;
        }

        // summary updation
        this.size--;

    }

    public void removeAtI(int idx) throws Exception {

        //detach
        if(idx == 0){
            removeFirst();
        }else if(idx == size-1){
            removeLast();
        }else{
            Node tn = getNodeAtI(idx-1);
            Node toBeRemoved = tn.next;
            tn.next = toBeRemoved.next;
            toBeRemoved.next = null;
        }

        // summary updation
        this.size--;
    }
    public void reverseData() throws Exception {

        int left = 0;
        int right = size-1;

        while(left < right){
            Node ln = getNodeAtI(left);
            Node rn =  getNodeAtI(right);

            int temp = ln.val;
            ln.val = rn.val;
            rn.val = temp;

            left++;
            right--;

        }
    }

    public void reverseLLByPointers() throws Exception {
        if(size == 0){
            throw new Exception("LL is empty");
        }

        if(size >= 2) {
            Node prev = this.head;
            Node curr = prev.next;

            while(curr != null){
                Node ahead = curr.next;
                curr.next = prev;
                prev = curr;
                curr = ahead;
            }

            Node t = this.head;
            this.head = this.tail;
            this.tail = t;

            tail.next = null;
        }
    }

    public Node midNode(){
        Node slow = this.head;
        Node fast = this.head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);
        return slow;


    }
    public int kthNodeForTail(int k) throws Exception {
        Node fast = this.head;
        Node slow = this.head;

        if(k>= size)throw new Exception("Out Of range");

        // first fast pointer iteration and set
        while(k-- > 0){
            fast = fast.next;
        }
        // fetching answer via loop
        while (fast.next!= null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow.val;

    }
}
