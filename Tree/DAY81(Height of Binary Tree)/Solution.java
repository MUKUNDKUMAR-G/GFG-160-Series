import java.util.*;

// Node class representing a binary tree node
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}


class Solution {
    Node root;
    Map<Integer, Node> nodeMap = new HashMap<>();

    // Function to find the height of a binary tree.
    int height(Node node) {
        if (node == null) {
            return -1; // Return -1 because height is edges count
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    void insert(int parent, int child, char dir) {
        Node parentNode = nodeMap.getOrDefault(parent, new Node(parent));
        nodeMap.put(parent, parentNode);

        Node childNode = nodeMap.getOrDefault(child, new Node(child));
        nodeMap.put(child, childNode);

        if (dir == 'L') {
            parentNode.left = childNode;
        } else {
            parentNode.right = childNode;
        }

        if (root == null) {
            root = parentNode;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution tree = new Solution();

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        System.out.println("Enter nodes (parent, child, L/R):");
        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            char dir = sc.next().charAt(0);
            tree.insert(parent, child, dir);
        }

        System.out.println("Height of the tree: " + tree.height(tree.root));
        sc.close();
    }
}