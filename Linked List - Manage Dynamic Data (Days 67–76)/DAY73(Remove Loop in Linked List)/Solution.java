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
    public static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect the loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // If no loop exists, return
        if (slow != fast) {
            return;
        }

        // Step 2: Find the first node of the loop
        slow = head;
        Node prev = null;

        // Special case: when the loop starts at the head
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null; // Remove the loop
            return;
        }

        // General case: slow and fast meet at the loop start
        while (slow != fast) {
            prev = fast; // To keep track of the node before fast
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Remove the loop
        prev.next = null;
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
        solution.removeLoop(head);
    
        // Check for loop removal
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
        sc.close();
    }
}