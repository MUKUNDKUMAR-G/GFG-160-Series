# 🚀 LRU Cache Implementation

## 📝 Problem Statement

Design a data structure that functions as an **LRU (Least Recently Used) Cache**. The cache has a fixed capacity (`cap`), and it supports two types of queries:

1. **PUT x y**: Sets the value of the key `x` to `y`.
2. **GET x**: Returns the value of the key `x` if it exists in the cache; otherwise, returns `-1`.

The cache should evict the least recently used item when it reaches its capacity.

---

## 🔒 Constraints

1. `1 <= cap <= 10^3`
2. `1 <= Q <= 10^5` (where `Q` is the number of queries)
3. `1 <= x, y <= 10^4`

---

## 📋 Function Description

The `LRUCache` class has the following methods:

1. **`LRUCache(int cap)`**: Initializes the cache with the given capacity.
2. **`int get(int key)`**: Returns the value of the key if it exists in the cache; otherwise, returns `-1`.
3. **`void put(int key, int value)`**: Updates the value of the key if it exists. If the key does not exist, it adds the key-value pair to the cache. If the cache reaches its capacity, it removes the least recently used item before inserting the new item.

---

## 📥 Input Format

The input consists of:

1. The cache capacity `cap`.
2. The number of queries `Q`.
3. A list of queries, where each query is either:
   - `["PUT", x, y]`: Inserts or updates the key-value pair `(x, y)`.
   - `["GET", x]`: Retrieves the value associated with key `x`.

---

## 📤 Output Format

For each `GET` query, output the value of the key if it exists in the cache; otherwise, output `-1`.

---

## 🧩 Examples with Explanation

### Example 1:

**Input:**

```
cap = 2, Q = 2
Queries = [["PUT", 1, 2], ["GET", 1]]
```

**Output:**

```
[2]
```

**Explanation:**

1. `["PUT", 1, 2]`: Inserts the key-value pair `(1, 2)` into the cache.
2. `["GET", 1]`: Retrieves the value `2` for key `1`.

---

### Example 2:

**Input:**

```
cap = 2, Q = 8
Queries = [["PUT", 1, 2], ["PUT", 2, 3], ["PUT", 1, 5], ["PUT", 4, 5], ["PUT", 6, 7], ["GET", 4], ["PUT", 1, 2], ["GET", 3]]
```

**Output:**

```
[5, -1]
```

**Explanation:**

1. `["PUT", 1, 2]`: Inserts `(1, 2)`.
2. `["PUT", 2, 3]`: Inserts `(2, 3)`. Cache: `1 -> 2, 2 -> 3`.
3. `["PUT", 1, 5]`: Updates `(1, 2)` to `(1, 5)`. Cache: `2 -> 3, 1 -> 5`.
4. `["PUT", 4, 5]`: Inserts `(4, 5)`. Cache reaches capacity, so `(2, 3)` is evicted. Cache: `1 -> 5, 4 -> 5`.
5. `["PUT", 6, 7]`: Inserts `(6, 7)`. Cache reaches capacity, so `(1, 5)` is evicted. Cache: `4 -> 5, 6 -> 7`.
6. `["GET", 4]`: Retrieves `5` for key `4`. Cache: `6 -> 7, 4 -> 5`.
7. `["PUT", 1, 2]`: Inserts `(1, 2)`. Cache reaches capacity, so `(6, 7)` is evicted. Cache: `4 -> 5, 1 -> 2`.
8. `["GET", 3]`: Key `3` does not exist in the cache, so returns `-1`.

---

## 🛠️ Approach

### 1. Brute Force Approach

- Use a list to store key-value pairs.
- For every `GET` or `PUT` operation, traverse the list to find the key.
- If the key is found, move it to the front (most recently used).
- If the cache reaches capacity, remove the last element (least recently used).

**Fallbacks in Brute Force:**

- **Time Complexity**: `O(n)` for both `GET` and `PUT` operations, where `n` is the number of elements in the cache. This is inefficient for large `Q` (up to `10^5`).
- **Space Complexity**: `O(cap)` for storing the cache.

---

### 2. Optimized Approach (Using HashMap and Doubly Linked List)

- Use a **HashMap** to store keys and their corresponding nodes in a **Doubly Linked List**.
- The Doubly Linked List maintains the order of usage:
  - The **head** points to the most recently used item.
  - The **tail** points to the least recently used item.
- For every `GET` or `PUT` operation:
  - If the key exists, move the corresponding node to the front.
  - If the key does not exist, add a new node to the front.
  - If the cache reaches capacity, remove the node at the tail.

**Why This Approach?**

- **Time Complexity**: `O(1)` for both `GET` and `PUT` operations.
- **Space Complexity**: `O(cap)` for storing the cache.

**Intuition**:

- The HashMap provides `O(1)` access to any node.
- The Doubly Linked List allows `O(1)` insertion and removal of nodes.

---

## ⏳ Time & Space Complexity

- **Time Complexity**:
  - `GET`: `O(1)`
  - `PUT`: `O(1)`
- **Space Complexity**: `O(cap)` for storing the cache.

---

## 💻 Solution Code

```java
import java.util.HashMap;

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
```

---

## 🚶 Example Walkthrough

### Input:

```
cap = 2, Q = 8
Queries = [["PUT", 1, 2], ["PUT", 2, 3], ["PUT", 1, 5], ["PUT", 4, 5], ["PUT", 6, 7], ["GET", 4], ["PUT", 1, 2], ["GET", 3]]
```

### Execution:

1. `PUT 1 2`: Cache = `[(1, 2)]`
2. `PUT 2 3`: Cache = `[(1, 2), (2, 3)]`
3. `PUT 1 5`: Cache = `[(2, 3), (1, 5)]`
4. `PUT 4 5`: Cache = `[(1, 5), (4, 5)]` (Evicts `(2, 3)`)
5. `PUT 6 7`: Cache = `[(4, 5), (6, 7)]` (Evicts `(1, 5)`)
6. `GET 4`: Returns `5`. Cache = `[(6, 7), (4, 5)]`
7. `PUT 1 2`: Cache = `[(4, 5), (1, 2)]` (Evicts `(6, 7)`)
8. `GET 3`: Returns `-1`.

### Output:

```
[5, -1]
```

---

## 🌟 Conclusion

The optimized approach using a **HashMap** and **Doubly Linked List** ensures efficient `O(1)` operations for both `GET` and `PUT`, making it suitable for large inputs. This solution elegantly balances time and space complexity while maintaining the LRU property. 🎉
