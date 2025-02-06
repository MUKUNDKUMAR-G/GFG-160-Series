import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int key) {
        data = key;
        left = right = null;
    }
}

class Solution {
    static int preorderIndex = 0; 
    static Map<Integer, Integer> inorderMap; 

    public static Node buildTree(int inorder[], int preorder[]) {
        preorderIndex = 0;
        inorderMap = new HashMap<>();
        
        // Store inorder indices in a HashMap
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return constructTree(preorder, 0, inorder.length - 1);
    }

    private static Node constructTree(int preorder[], int left, int right) {
        if (left > right) return null;

        int rootValue = preorder[preorderIndex++];
        Node root = new Node(rootValue);

        int inorderIdx = inorderMap.get(rootValue);

        root.left = constructTree(preorder, left, inorderIdx - 1);
        root.right = constructTree(preorder, inorderIdx + 1, right);

        return root;
    }

    // Postorder Traversal
    public static void postorderTraversal(Node root) {
        if (root == null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        int inorder[] = new int[n];
        int preorder[] = new int[n];

        System.out.println("Enter inorder traversal:");
        for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();

        System.out.println("Enter preorder traversal:");
        for (int i = 0; i < n; i++) preorder[i] = sc.nextInt();

        Node root = buildTree(inorder, preorder);
        System.out.println("Postorder Traversal:");
        postorderTraversal(root);
        
        sc.close();
    }
}