import java.util.HashMap;
import java.util.Scanner;

class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            addToFront(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addToFront(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToFront(newNode);

            if (map.size() > capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the cache capacity: ");
        int cap = scanner.nextInt();

        LRUCache cache = new LRUCache(cap);

        System.out.print("Enter the number of queries: ");
        int Q = scanner.nextInt();

        System.out.println("Enter queries in the following format:");
        System.out.println("- For PUT: PUT x y");
        System.out.println("- For GET: GET x");
        System.out.println("Example: PUT 1 2");

        for (int i = 0; i < Q; i++) {
            System.out.print("Query " + (i + 1) + ": ");
            String operation = scanner.next();

            if (operation.equals("PUT")) {
                int key = scanner.nextInt();
                int value = scanner.nextInt();
                cache.put(key, value);
                System.out.println("Inserted/Updated key " + key + " with value " + value);
            } else if (operation.equals("GET")) {
                int key = scanner.nextInt();
                int value = cache.get(key);
                System.out.println("Value for key " + key + ": " + value);
            } else {
                System.out.println("Invalid query. Please use PUT or GET.");
                i--; // Retry the same query index
            }
        }

        scanner.close();
    }
}