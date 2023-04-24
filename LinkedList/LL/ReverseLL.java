package LinkedList.LL;

public class ReverseLL {
    Node reverseList(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}