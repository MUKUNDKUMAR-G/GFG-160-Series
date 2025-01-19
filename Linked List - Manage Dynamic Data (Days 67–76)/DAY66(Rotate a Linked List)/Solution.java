import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    public Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find the length of the list and make it circular
        Node current = head;
        int length = 1;
        while (current.next != null) {
            length++;
            current = current.next;
        }
        current.next = head; // Connect the last node to the head to make it circular

        // Step 2: Reduce k using modulo
        k = k % length;
        if (k == 0) {
            current.next = null; // Break the circular connection
            return head;
        }

        // Step 3: Traverse to the (length - k)th node
        current = head;
        for (int i = 0; i < k - 1; i++) {
            current = current.next;
        }

        // Step 4: Update the new head and break the circular connection
        Node newHead = current.next;
        current.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements of the linked list:");
        Node head = null, tail = null;

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

        System.out.print("Enter the number of rotations: ");
        int k = scanner.nextInt();

        Solution solution = new Solution();
        Node rotatedHead = solution.rotate(head, k);
        
        System.out.print("Rotated Linked List: ");
        Node current = rotatedHead;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : " -> NULL"));
            current = current.next;
        }

        scanner.close();
    }
}