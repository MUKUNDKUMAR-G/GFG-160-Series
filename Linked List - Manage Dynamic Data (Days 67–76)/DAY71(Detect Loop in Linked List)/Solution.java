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
    // Function to check if the linked list has a loop.
    public boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // Move slow by 1 step and fast by 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet, there is a loop
            if (slow == fast) {
                return true;
            }
        }

        // No loop found
        return false;
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
        boolean hasLoop = solution.detectLoop(head);
    
        System.out.println("Loop detected: " + hasLoop);
        sc.close();
    }
}