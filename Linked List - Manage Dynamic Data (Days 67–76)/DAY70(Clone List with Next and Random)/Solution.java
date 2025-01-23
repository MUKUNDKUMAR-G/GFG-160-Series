import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}

class Solution {
    public Node cloneLinkedList(Node head) {
        if (head == null) return null;

        // Step 1: Interleave cloned nodes
        Node current = head;
        while (current != null) {
            Node clone = new Node(current.data);
            clone.next = current.next;
            current.next = clone;
            current = clone.next;
        }

        // Step 2: Set random pointers for the cloned nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original and cloned lists
        Node original = head;
        Node cloneHead = head.next;
        Node cloneCurrent = cloneHead;

        while (original != null) {
            original.next = original.next.next;
            if (cloneCurrent.next != null) {
                cloneCurrent.next = cloneCurrent.next.next;
            }
            original = original.next;
            cloneCurrent = cloneCurrent.next;
        }

        return cloneHead;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();
    
        System.out.println("Enter node values and their random pointers (-1 for NULL):");
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
    
        for (int i = 0; i < n; i++) {
            int randomIndex = sc.nextInt();
            if (randomIndex != -1) {
                nodeArray[i].random = nodeArray[randomIndex];
            }
        }
    
        Solution solution = new Solution();
        Node clonedHead = solution.cloneLinkedList(head);
    
        System.out.println("Cloned List:");
        while (clonedHead != null) {
            System.out.print("[" + clonedHead.data + ", " + (clonedHead.random != null ? clonedHead.random.data : "NULL") + "] ");
            clonedHead = clonedHead.next;
        }
        sc.close();
    }
}