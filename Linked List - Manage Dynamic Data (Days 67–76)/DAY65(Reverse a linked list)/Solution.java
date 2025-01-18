import java.util.Scanner;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next; // Temporarily store the next node
            curr.next = prev;      // Reverse the link
            prev = curr;           // Move prev forward
            curr = next;           // Move curr forward
        }

        return prev; // New head of the reversed list
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

        Solution solution = new Solution();
        Node reversedHead = solution.reverseList(head);

        System.out.print("Reversed Linked List: ");
        Node current = reversedHead;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : " -> NULL"));
            current = current.next;
        }

        scanner.close();
    }
}