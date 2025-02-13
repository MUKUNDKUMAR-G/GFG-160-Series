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

        ArrayList<ArrayList<Integer>> result = tree.levelOrder(tree.root);

        System.out.println("Level Order Traversal: " + result);
        sc.close();
    }
}