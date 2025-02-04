import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    // Class to store diameter
    static class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int h, int d) {
            height = h;
            diameter = d;
        }
    }

    // Function to find diameter using DFS
    static TreeInfo diameterUtil(Node node) {
        if (node == null) {
            return new TreeInfo(-1, 0);  // height = -1, diameter = 0
        }

        TreeInfo left = diameterUtil(node.left);
        TreeInfo right = diameterUtil(node.right);

        int height = Math.max(left.height, right.height) + 1;
        int currDiameter = left.height + right.height + 2;
        int maxDiameter = Math.max(currDiameter, Math.max(left.diameter, right.diameter));

        return new TreeInfo(height, maxDiameter);
    }

    // Main function to return diameter
    int diameter(Node root) {
        return diameterUtil(root).diameter;
    }

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

        System.out.println("Diameter of the tree: " + tree.diameter(tree.root));
        sc.close();
    }
}