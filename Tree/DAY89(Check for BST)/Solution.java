import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    // Function to check if a Binary Tree is BST
    boolean isBST(Node root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);  // Using long to prevent overflow
    }

    // Function to check if the subtree is valid within the given range
    boolean isValid(Node root, long left, long right) {
        if (root == null) {
            return true;
        }

        // Ensure the node value lies within the valid range
        if (root.data <= left || root.data >= right) {
            return false;
        }

        // Recursively check left and right subtrees with updated ranges
        return isValid(root.left, left, root.data) && isValid(root.right, root.data, right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("false");  // Empty tree is not a BST
            sc.close();
            return;
        }
        Map<Integer, Node> nodeMap = new HashMap<>();
        Node root = null;

        System.out.println("Enter nodes (parent child L/R):");
        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            char dir = sc.next().charAt(0);

            nodeMap.putIfAbsent(parent, new Node(parent));
            nodeMap.putIfAbsent(child, new Node(child));

            if (root == null) {
                root = nodeMap.get(parent);
            }

            if (dir == 'L') {
                nodeMap.get(parent).left = nodeMap.get(child);
            } else {
                nodeMap.get(parent).right = nodeMap.get(child);
            }
        }

        Solution solution = new Solution();
        System.out.println(solution.isBST(root) ? "true" : "false");

        sc.close();
    }
}
