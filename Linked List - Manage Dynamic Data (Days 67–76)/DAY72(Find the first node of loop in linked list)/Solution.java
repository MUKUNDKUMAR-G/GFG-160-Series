import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    public static Node findFirstNode(Node head) {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect the loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Loop detected
            if (slow == fast) {
                break;
            }
        }

        // If no loop is detected, return null
        if (slow != fast) {
            return null;
        }

        // Step 2: Find the first node of the loop
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();
    
        System.out.println("Enter the node values:");
        Node head = null, temp = null;
        Node[] nodeArray = new Node[n];
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            nodeArray[i] = new Node(data);
            if (head == null) {
                head = nodeArray[i];
                temp = head;
            } else {
                temp.next = nodeArray[i];
                temp = temp.next;
            }
        }
    
        System.out.println("Enter the loop position (0 for no loop):");
        int pos = sc.nextInt();
        if (pos > 0) {
            temp.next = nodeArray[pos - 1];
        }
    
        Solution solution = new Solution();
        Node loopNode = solution.findFirstNode(head);
    
        if (loopNode != null) {
            System.out.println("First node of the loop: " + loopNode.data);
        } else {
            System.out.println("No loop detected.");
        }
    
        sc.close();
    }
}