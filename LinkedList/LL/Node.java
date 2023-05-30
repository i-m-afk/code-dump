package LinkedList.LL;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class Main {
    // Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x) {
        Node temp = new Node(x);
        if (head == null)
            return temp;
        temp.next = head;
        return temp;
    }

    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        Node temp = new Node(x);
        Node res = head;
        if (head == null)
            return temp;
        while (head.next != null) {
            head = head.next;
        }
        head.next = temp;
        return res;
    }

    public static void main(String[] args) {

        Node a = new Node(10);
        Node b = new Node(5);
        Node c = new Node(69);
        Node d = new Node(12321);
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.print(a.next.next.next.data + " ");
        // traversal
        // Node head = a;
        // while (head != null) {
        // System.out.print(head.data + " ");
        // head = head.next;
        // }
    }
}