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
    private int count = 0;

    public int sumK(Node root, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1); 

        dfs(root, 0, k, prefixSum);
        return count;
    }

    private void dfs(Node node, int currentSum, int k, Map<Integer, Integer> prefixSum) {
        if (node == null) return;

        currentSum += node.data;

        if (prefixSum.containsKey(currentSum - k)) {
            count += prefixSum.get(currentSum - k);
        }

        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);

        dfs(node.left, currentSum, k, prefixSum);
        dfs(node.right, currentSum, k, prefixSum);

        prefixSum.put(currentSum, prefixSum.get(currentSum) - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Number of valid paths: 0");
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

        System.out.println("Enter target sum (k):");
        int k = sc.nextInt();

        Solution obj = new Solution();
        System.out.println("Number of valid paths: " + obj.sumK(root, k));
        sc.close();
    }
}