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
    // Function to return the K-th smallest element in the BST
    public int kthSmallest(Node root, int k) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        int count = 0;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            count++;

            if (count == k) {
                return curr.data;
            }

            curr = curr.right;
        }

        return -1; // If k is greater than the number of nodes
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("-1");
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

        System.out.println("Enter k:");
        int k = sc.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(root, k));

        sc.close();
    }
}