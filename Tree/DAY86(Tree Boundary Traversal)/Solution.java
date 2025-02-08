import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> boundary = new ArrayList<>();

        if(node == null){
            return boundary;
        }


        if(!isLeaf(node)){
            boundary.add(node.data);
        }

        getLeftBoundary(node.left, boundary);
        getLeafNodes(node, boundary);

        // ArrayList<Integer>  rightBoundary = new ArrayList<>();
        getRightBoundary(node.right, boundary);
        // Collections.reverse(rightBoundary);

        // boundary.addAll(rightBoundary);

        return boundary;
    }

    private static boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }

    private static void getLeftBoundary(Node root, ArrayList<Integer> arr){
        if(root == null || isLeaf(root)){
            return;
        }

        arr.add(root.data);
        if(root.left != null) getLeftBoundary(root.left, arr);
        else if(root.right != null)getLeftBoundary(root.right, arr);
    }

    private static void getLeafNodes(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }

        if(isLeaf(root)){
            arr.add(root.data);
            return;
        }

        getLeafNodes(root.left, arr);
        getLeafNodes(root.right, arr);
    }

    private static void getRightBoundary(Node root, ArrayList<Integer> arr){
        if(root == null || isLeaf(root)){
            return;
        }

        if(root.right != null)getRightBoundary(root.right, arr);
        else if(root.left != null)getRightBoundary(root.left, arr);

        arr.add(root.data);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Boundary Traversal: []");
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
        ArrayList<Integer> result = obj.boundaryTraversal(root);

        System.out.println("Boundary Traversal: " + result);
        sc.close();
    }
}