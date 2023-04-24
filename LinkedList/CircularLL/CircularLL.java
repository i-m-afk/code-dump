package LinkedList.CircularLL;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
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

        int k = 0; // to avoid infinte loop
        while (head != null && k++ < 10) {
            System.out.print(head.data + "--->");
            head = head.next;
        }
    }

    /*
     * Function to print nodes in a given Circular linked list
     * https://practice.geeksforgeeks.org/problems/circular-linked-list-traversal/1
     */
    void printList(Node head) {
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        CircularLL cll = new CircularLL();
        // cll.naiveInit();
    }
}
