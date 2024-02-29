package LinkedList;

import java.util.HashMap;

public class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node() {

        }
    }

    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int cap;

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        cap = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            extract(temp);
            addbeforetail(temp);
            return temp.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            extract(temp);
            temp.val = value;
            addbeforetail(temp);
        } else {
            if (map.size() == cap) {
                Node temp = head.next;
                extract(temp);
                map.remove(temp.key);
            }
            Node node = new Node();
            node.key = key;
            node.val = value;
            map.put(key, node);
            addbeforetail(node);
        }
    }

    public void extract(Node node) {
        Node nodem1 = node.prev;
        Node nodep1 = node.next;

        nodem1.next = nodep1;
        nodep1.prev = nodem1;
        node.next = null;
        node.prev = null;

    }

    public void addbeforetail(Node node) {
        Node tailm1 = tail.prev;
        tailm1.next = node;
        node.next = tail;
        node.prev = tailm1;
        tail.prev = node;
    }
}
