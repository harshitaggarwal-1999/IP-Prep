package LinkedList;


public class LinkedList {
    private class Node {
        int val;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    public void display(){
        System.out.println("-------------------------------------");

        Node temp  = this.head;
        while(temp!= null){
            System.out.print(temp.val+" , ");
            temp = temp.next;
        }
        System.out.print(" . ");
        System.out.println();
        System.out.println("--------------------------------------");
    }

    public void addLast(int item){

        Node nn = new Node();
        nn.val = item;
        nn.next = null;
        // new node creation

        // Node nn = new Node(item, null);

        // attach 
        if(this.size >= 1){
            this.tail.next = nn;
        }

        //summary updation
        if(this.size == 0){
            this.head = nn;
            this.tail = nn;
            this.size++;
        }else{
            this.tail = nn;
            this.size++;
        }

    }
}
