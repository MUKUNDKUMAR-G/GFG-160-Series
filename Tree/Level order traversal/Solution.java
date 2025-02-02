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
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> level = new ArrayList<>();

            while (n-- > 0) {
                Node peek = queue.poll();

                level.add(peek.data);

                if (peek.left != null) {
                    queue.add(peek.left);
                }

                if (peek.right != null) {
                    queue.add(peek.right);
                }
            }

            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        HashMap<Integer, Node> nodeMap = new HashMap<>();
        Node root = null;

        System.out.println("Enter nodes (parent, child, L/R):");
        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            char dir = sc.next().charAt(0);

            nodeMap.putIfAbsent(parent, new Node(parent));
            nodeMap.putIfAbsent(child, new Node(child));

            if (root == null) root = nodeMap.get(parent);

            if (dir == 'L') {
                nodeMap.get(parent).left = nodeMap.get(child);
            } else {
                nodeMap.get(parent).right = nodeMap.get(child);
            }
        }

        Solution obj = new Solution();
        ArrayList<ArrayList<Integer>> result = obj.levelOrder(root);

        System.out.println("Level Order Traversal: " + result);
        sc.close();
    }
}