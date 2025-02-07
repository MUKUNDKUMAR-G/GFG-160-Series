import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result); 
        result.add(node.data);            
        inorderHelper(node.right, result); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        HashMap<Integer, Node> map = new HashMap<>();
        Node root = null;

        System.out.println("Enter nodes (parent, child, L/R):");
        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            char dir = sc.next().charAt(0);

            map.putIfAbsent(parent, new Node(parent));
            map.putIfAbsent(child, new Node(child));

            if (root == null) root = map.get(parent);

            if (dir == 'L') {
                map.get(parent).left = map.get(child);
            } else {
                map.get(parent).right = map.get(child);
            }
        }

        Solution obj = new Solution();
        ArrayList<Integer> inorderTraversal = obj.inOrder(root);
        System.out.println("Inorder Traversal: " + inorderTraversal);
        sc.close();
    }
}