import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    int maxSum;

    // Function to return the maximum path sum from any node in a tree.
    int findMaxSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    // Helper function using DFS to compute maximum path sum
    private int dfs(Node node) {
        if (node == null) return 0;

        // Compute left and right max path sums (ignore negatives)
        int leftMax = Math.max(0, dfs(node.left));
        int rightMax = Math.max(0, dfs(node.right));

        // Update global max sum considering this node as the root of max path
        maxSum = Math.max(maxSum, leftMax + rightMax + node.data);

        // Return max path sum including this node
        return node.data + Math.max(leftMax, rightMax);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Maximum Path Sum: 0");
            sc.close();
            return;
        }

        Map<Integer, Node> map = new HashMap<>();
        Node root = null;

        System.out.println("Enter nodes (parent child L/R):");
        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            char dir = sc.next().charAt(0);

            map.putIfAbsent(parent, new Node(parent));
            map.putIfAbsent(child, new Node(child));

            if (root == null)
                root = map.get(parent);

            if (dir == 'L')
                map.get(parent).left = map.get(child);
            else
                map.get(parent).right = map.get(child);
        }

        Solution obj = new Solution();
        System.out.println("Maximum Path Sum: " + obj.findMaxSum(root));
        sc.close();
    }
}