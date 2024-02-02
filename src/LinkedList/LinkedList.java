package LinkedList;

public class LinkedList {
    Node head;

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    void add(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            while (temp != null && temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }

    void remove() {
        if (head != null) {
            if (head.next == null) {
                head = null;
                return;
            }
            Node temp = head, prev = head;
            while (temp != null && temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
        }
    }

    void remove(int data) {
        if (head != null) {
            Node temp = head, prev = head;
            while (temp != null && temp.next != null && temp.val != data) {
                prev = temp;
                temp = temp.next;
            }
            if (temp.val == data) prev.next = temp.next;
        }
    }

    void removeAll() {
        head = null;
    }

    void removeAll(int data) {
        while (head == null && head.val == data) head = head.next;
        if (head != null) {
            Node prev = head, temp = head.next;
            while (temp != null) {
                if (temp.val == data) prev.next = temp.next;
                else prev = temp;
                temp = temp.next;
            }
        }
    }

    void display() {
        if (head == null) System.out.println("No nodes present in LL.");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + ", ");
            temp = temp.next;
        }
        System.out.println();
    }

    void insertRec(int val, int index) {
        insertRec(val, index, head);
    }

    Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            return temp;
        }
        if (node.next == null) {
            System.out.println("\u001B[31mindex out of range of linkedlist.\u001B[0m");
        }
        node.next = insertRec(val, --index, node.next);
        return node;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        for (int i = 0; i < 10; i++) {
            double random = 100 * Math.random();
            ll.add((int) random);
        }
        ll.display();
        ll.insertRec(111, 10);
        ll.display();
    }
}
