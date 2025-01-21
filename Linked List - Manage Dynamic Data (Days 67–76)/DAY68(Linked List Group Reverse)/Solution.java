import java.util.Scanner;
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // Edge cases
        if (head == null || k == 1) {
            return head;
        }

        // Count total nodes
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // Create a dummy node
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        curr = head;

        // Process all groups
        while (count >= k) {
            curr = prev.next; // First node of current k-group
            Node next = curr.next; // Second node of current k-group

            // Reverse k-1 links for k nodes
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }

            prev = curr;
            count -= k;
        }

        // If remaining nodes are less than k, reverse them too
        if (count > 0) {
            curr = prev.next;
            Node next = curr.next;
            while (next != null) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();
        Node head = null, tail = null;

        System.out.println("Enter the elements of the linked list:");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        Node newHead = reverseKGroup(head, k);

        System.out.println("Reversed Linked List:");
        Node current = newHead;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : " -> NULL"));
            current = current.next;
        }

        scanner.close();
    }
}