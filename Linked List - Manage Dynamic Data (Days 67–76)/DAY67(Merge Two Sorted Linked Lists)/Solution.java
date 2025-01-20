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
    Node sortedMerge(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node dummy = new Node(-1);
        Node tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next; 
        }

        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        return dummy.next; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes in the first list: ");
        int n1 = scanner.nextInt();
        Node head1 = null, tail1 = null;

        System.out.println("Enter the elements of the first list:");
        for (int i = 0; i < n1; i++) {
            int data = scanner.nextInt();
            Node newNode = new Node(data);
            if (head1 == null) {
                head1 = newNode;
                tail1 = newNode;
            } else {
                tail1.next = newNode;
                tail1 = newNode;
            }
        }

        System.out.print("Enter the number of nodes in the second list: ");
        int n2 = scanner.nextInt();
        Node head2 = null, tail2 = null;

        System.out.println("Enter the elements of the second list:");
        for (int i = 0; i < n2; i++) {
            int data = scanner.nextInt();
            Node newNode = new Node(data);
            if (head2 == null) {
                head2 = newNode;
                tail2 = newNode;
            } else {
                tail2.next = newNode;
                tail2 = newNode;
            }
        }

        Solution solution = new Solution();
        Node mergedHead = solution.sortedMerge(head1, head2);

        System.out.print("Merged Linked List: ");
        Node current = mergedHead;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : " -> NULL"));
            current = current.next;
        }

        scanner.close();
    }
}