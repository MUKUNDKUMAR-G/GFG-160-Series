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

// Class representing the Binary Tree
class BinaryTree {
    Node root;

    // Function to find the height of a binary tree.
    int height(Node node) {
        if (node == null) {
            return -1; // Return -1 because height is edges count
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // Function to insert nodes into the tree
    void insert(int parent, int child, char dir) {
        if (root == null) {
            root = new Node(parent);
        }

        HashMap<Integer, Node> nodeMap = new HashMap<>();
        nodeMap.put(root.data, root);

        if (!nodeMap.containsKey(parent)) {
            nodeMap.put(parent, new Node(parent));
        }
        if (!nodeMap.containsKey(child)) {
            nodeMap.put(child, new Node(child));
        }

        Node parentNode = nodeMap.get(parent);
        Node childNode = nodeMap.get(child);

        if (dir == 'L') {
            parentNode.left = childNode;
        } else {
            parentNode.right = childNode;
        }
    }

    // Driver function to take user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

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