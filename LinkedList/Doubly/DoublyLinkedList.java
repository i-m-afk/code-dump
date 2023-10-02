package LinkedList.Doubly;

public class DoublyLinkedList {
    int data;
    DoublyLinkedList prev;
    DoublyLinkedList next;

    DoublyLinkedList(int data) {
        this.data = data;
    }

    private DoublyLinkedList insertAtFront(DoublyLinkedList head) {
        if (head == null)
            return new DoublyLinkedList(data);
        DoublyLinkedList current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new DoublyLinkedList(data);
        return head;
    }

    private DoublyLinkedList insertAtRear(DoublyLinkedList head) {
        if (head == null)
            return new DoublyLinkedList(data);
        DoublyLinkedList current = head;
        while (current.prev != null) {
            current = current.prev;
        }
        current.prev = new DoublyLinkedList(data);
        return head;
    } 
}
