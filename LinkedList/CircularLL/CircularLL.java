package LinkedList.CircularLL;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }

    Node() {
        next = null;
    }
}
/*
 * Structure of Singly CLL is same as Singly Linked List
 * and Structure of Doubly CLL is same as Doubly Linked List
 * Simple Circular Linked List Preparation
 * Notes: 1) Empty CLL is represented as "null"
 * 2) Single CLL points itself
 * 3) Below is not a correct way as it linked list should be circular
 * after every instertion
 * Advantages:
 * a) Can traverse the whole Linked list by any of the nodes
 * b) Implementation of Round Robin Algorithm
 * C) Insertion at begining and At the End by maintaing only one
 * reference/pointer (tail), useful for implementation of queue datastructure
 * Disadvantages:
 * a) Implementations of operations become complex
 * 
 */

public class CircularLL {
    private void naiveInit() {
        Node head = new Node(10);
        head.next = new Node(5);
        head.next.next = new Node(20);
        head.next.next.next = new Node(15);
        head.next.next.next.next = head; // this makes ll circular

        Node current = head;
        int k = 0; // to avoid infinte loop
        while (current != null && k++ < 10) {
            System.out.print(current.data + "--->");
            current = current.next;
        }
    }

    /*
     * Function to print nodes in a given Circular linked list
     * https://practice.geeksforgeeks.org/problems/circular-linked-list-traversal/1
     */
    void printList(Node head) {
        if (head == null) {
            System.out.println("linked list is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
    }

    private Node insertNodeAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newNode; // change old last node point to newNode
        newNode.next = head; // point newNode to head
        return head;
    }

    private Node insertNodeAtFront(Node head, int data) {
        Node newHead = new Node(data);
        if (head == null) {
            newHead.next = newHead;
            return newHead;
        }
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newHead;
        newHead.next = head;
        return newHead;
    }

    // delete head
    private Node deleteHead(Node head) {
        if (head == null) {
            throw new Error("Can't perform delete operation on null list.");
        }
        if (head == head.next)
            return null;
        Node current = head;
        while (current.next != head)
            current = current.next;
        current.next = head.next;
        return head.next;
    }

    // delete kth node
    private Node deleteKthNode(Node head, int k) {
        if (head == null)
            throw new NullPointerException("null list.");
        if (k <= 0)
            throw new IllegalArgumentException("Invalid value of k.");
        if (k == 1) {
            return deleteHead(head);
        }
        Node current = head;
        for (int i = 0; i < k - 2; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }

    // circular doubly linked list

    public static void main(String[] args) {
        // CircularLL cll = new CircularLL();
        // cll.naiveInit();
        Node head = null;
        CircularLL obj = new CircularLL();
        head = obj.insertNodeAtEnd(head, 12);
        head = obj.insertNodeAtEnd(head, 213);
        head = obj.insertNodeAtEnd(head, 23);

        obj.printList(head);
        System.out.println();
        // head = obj.deleteHead(head);
        // head = obj.deleteHead(head);
        // head = obj.deleteHead(head);
        head = obj.deleteKthNode(head, -1);

        obj.printList(head);
    }
}
