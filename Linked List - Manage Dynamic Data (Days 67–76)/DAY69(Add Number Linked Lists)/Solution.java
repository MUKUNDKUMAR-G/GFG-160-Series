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
    public static Node addTwoLists(Node num1, Node num2) {
        // Reverse both linked lists
        num1 = reverse(num1);
        num2 = reverse(num2);

        Node result = null; // Head of the result list
        Node temp = null;   // Temporary pointer for appending nodes
        int carry = 0;      // Variable to store carry
        int sum = 0;        // Variable to store digit sum

        // Traverse both lists
        while (num1 != null || num2 != null || carry != 0) {
            sum = carry;

            // Add digit from num1
            if (num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }

            // Add digit from num2
            if (num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }

            // Calculate carry and current digit
            carry = sum / 10;
            sum = sum % 10;

            // Create a new node for the current digit
            Node newNode = new Node(sum);
            if (result == null) {
                result = newNode;
            } else {
                temp.next = newNode;
            }
            temp = newNode;
        }

        // Add remaining carry
        if (carry > 0) {
            temp.next = new Node(carry);
        }

        // Reverse the result list to correct order
        result = reverse(result);

        // Remove leading zeros
        while (result != null && result.data == 0 && result.next != null) {
            result = result.next;
        }

        return result;
    }

    // Helper method to reverse a linked list
    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes in the first linked list: ");
        int n1 = scanner.nextInt();
        Node num1 = null, tail1 = null;

        System.out.println("Enter the digits of the first number:");
        for (int i = 0; i < n1; i++) {
            int data = scanner.nextInt();
            Node newNode = new Node(data);
            if (num1 == null) {
                num1 = newNode;
                tail1 = newNode;
            } else {
                tail1.next = newNode;
                tail1 = newNode;
            }
        }

        System.out.print("Enter the number of nodes in the second linked list: ");
        int n2 = scanner.nextInt();
        Node num2 = null, tail2 = null;

        System.out.println("Enter the digits of the second number:");
        for (int i = 0; i < n2; i++) {
            int data = scanner.nextInt();
            Node newNode = new Node(data);
            if (num2 == null) {
                num2 = newNode;
                tail2 = newNode;
            } else {
                tail2.next = newNode;
                tail2 = newNode;
            }
        }

        Node result = addTwoLists(num1, num2);

        System.out.println("Sum of the numbers:");
        Node current = result;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : " -> NULL"));
            current = current.next;
        }

        scanner.close();
    }
}