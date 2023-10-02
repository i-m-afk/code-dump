package LinkedList.LL;

public class LinkedList {
    int data;
    LinkedList next;

    LinkedList(int data) {
        this.data = data;
        next = null;
    }

    static private LinkedList insertNodeTail(LinkedList head, int data) {
        if (head == null)
            return new LinkedList(data);
        LinkedList temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = new LinkedList(data);
        return head;
    }

    static private LinkedList insertNodeStart(LinkedList head, int data) {
        if (head == null)
            return new LinkedList(data);
        LinkedList temp = new LinkedList(data);
        temp.next = head;
        return temp;
    }

    static private LinkedList insertNodeAtKthPosition(LinkedList head, int data, int k) {
        if (k < 0) {
            System.out.println("invalid position");
            return head;
        }

        if (k == 0) {
            LinkedList newHead = new LinkedList(data);
            newHead.next = head;
            return newHead;
        }

        LinkedList prev = null;
        LinkedList curr = head;
        while (k-- > 0 && curr != null) {
            prev = curr;
            curr = curr.next;
        }

        if (k > 0) {
            System.out.println("Position out of bounds");
            return head;
        }

        prev.next = new LinkedList(data);
        prev.next.next = curr;
        return head;
    }

    static private LinkedList deleteEndNode(LinkedList head) {
        if (head == null || head.next == null)
            return null;
        LinkedList temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    static private int length(LinkedList head) {
        if (head == null)
            return 0;
        int len = 1;
        while (head.next != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    static private LinkedList deleteKthNode(LinkedList head, int k) {
        int len = length(head);
        if (k >= len) {
            System.out.println("Size of K can't be more than that of list");
            return head;
        }
        if (k == 0)
            return head.next;
        LinkedList curr = head;
        LinkedList prev = null;
        for (int i = 0; i < k; i++) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return head;
    }

    static private LinkedList reverseLinkedList(LinkedList head) {
        LinkedList temp = head;
        LinkedList curr = null;
        while (temp != null) {
            curr = insertNodeStart(curr, temp.data);
            temp = temp.next;
        }
        return curr;
    }

    static private boolean search(LinkedList head, int element) {
        while (head != null) {
            if (head.data == element)
                return true;
            head = head.next;
        }
        return false;
    }

    static private boolean isLoop(LinkedList head) {
        LinkedList fast = head;
        LinkedList slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;

        }
        return false;
    }

    // delete a node with only pointer given to it
    private void deleteWithRef(LinkedList node) {
        LinkedList nextNode = node.next;

        node.data = nextNode.data;
        node.next = nextNode.next;
    }

    public static void main(String[] args) {
        LinkedList head = null;

        head = insertNodeTail(head, 10);
        head = insertNodeTail(head, 20);
        head = insertNodeTail(head, 30);
        head = insertNodeTail(head, 40);
        head = insertNodeTail(head, 50);

        System.out.println(isLoop(head));
        // head = deleteEndNode(head);
        // head = deleteEndNode(head);
        // head = deleteEndNode(head);
        LinkedList temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("length: " + length(head));
        // head = deleteKthNode(head, 5);
        // head = insertNodeAtKthPosition(head, 0, 5);
        head = reverseLinkedList(head);
        // System.out.println(search(head, 320));
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

    }
}
