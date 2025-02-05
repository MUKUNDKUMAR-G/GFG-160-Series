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
    Node root;
    Map<Integer, Node> nodeMap = new HashMap<>();

    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        if (node == null) return;

        // Swap left and right
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recur for left and right subtrees
        mirror(node.left);
        mirror(node.right);
    }

    // Function for in-order traversal
    void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // Function to insert nodes into the tree
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

    // Driver function to take user input
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

        tree.mirror(tree.root);


        System.out.println("In-order Traversal of Mirror Tree:");
        tree.inOrder(tree.root);
        sc.close();
    }
}
