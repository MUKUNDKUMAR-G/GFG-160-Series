# 🌳 **Height of a Binary Tree**

## 📜 **Problem Statement**

Given the **root of a binary tree**, find its **height**.

✅ **Height of a tree** is the **number of edges** on the **longest path** from the **root** to a **leaf node**.  
✅ **Leaf Node** is a node **without any children**.

---

## 📌 **Constraints**

- **1 ≤ number of nodes ≤ 10⁵**
- **0 ≤ node->data ≤ 10⁵**

---

## 📥 **Input Format**

A **binary tree** represented as `root`.

**Input:**

- First, enter the number of nodes `n`.
- Next, enter `n-1` lines containing **three values**:
  - `parent` (parent node)
  - `child` (child node)
  - `L/R` (L for left child, R for right child)

---

## 📤 **Output Format**

Return an **integer**, representing the height of the tree.

---

## 📝 **Examples & Explanations**

### **Example 1**

#### 🔹 **Input**

```
5
12 8 L
12 18 R
8 5 L
8 11 R
```

#### ✅ **Output**

```plaintext
2
```

#### 🧐 **Explanation**

```
        12
       /  \
      8   18
     / \
    5  11
```

- **Longest Path:** `12 → 8 → 5` (or `12 → 8 → 11`)
- **Edges Count:** `2`

---

### **Example 2**

#### 🔹 **Input**

```
6
1 2 L
1 3 R
2 4 L
4 6 L
3 5 R
```

#### ✅ **Output**

```plaintext
3
```

#### 🧐 **Explanation**

```
        1
       / \
      2   3
     /     \
    4       5
   /
  6
```

- **Longest Path:** `1 → 2 → 4 → 6`
- **Edges Count:** `3`

---

## 🚀 **Approach**

### 🔹 **1. Brute Force (Iterative using BFS)**

#### 🔍 **Idea:**

- Use **Breadth-First Search (BFS)** and traverse **level by level**.
- Count the **number of levels**.

⏳ **Time Complexity:** `O(n)`  
🛠️ **Space Complexity:** `O(n)` (Queue for storing nodes)

#### ❌ **Why Brute Force Fails?**

- **Consumes extra space** due to **queue usage**.
- **Not optimized for deep trees**.

---

### 🔹 **2. Optimized Approach (Recursive DFS)**

✅ **Use Depth-First Search (DFS) to compute height recursively.**  
✅ **At each node, compute**:

- **Left subtree height**
- **Right subtree height**
- **Return max(left, right) + 1**

⏳ **Time Complexity:** **O(n)** (Each node is visited once)  
🛠️ **Space Complexity:** **O(h)** (Recursive stack size, `h` is the height of tree)

---

## ✅ **Optimized Recursive DFS Solution (Java)**

```java
import java.util.*;

// Node class representing a binary tree node
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

// Class representing the Binary Tree
class BinaryTree {
    Node root;

    // Function to find the height of a binary tree.
    int height(Node node) {
        if (node == null) {
            return -1; // Return -1 because height is edges count
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    // Function to insert nodes into the tree
    void insert(int parent, int child, char dir) {
        if (root == null) {
            root = new Node(parent);
        }

        HashMap<Integer, Node> nodeMap = new HashMap<>();
        nodeMap.put(root.data, root);

        if (!nodeMap.containsKey(parent)) {
            nodeMap.put(parent, new Node(parent));
        }
        if (!nodeMap.containsKey(child)) {
            nodeMap.put(child, new Node(child));
        }

        Node parentNode = nodeMap.get(parent);
        Node childNode = nodeMap.get(child);

        if (dir == 'L') {
            parentNode.left = childNode;
        } else {
            parentNode.right = childNode;
        }
    }
}
```

---

## 🎯 **Example Walkthrough**

Let's take the input:

```
5
12 8 L
12 18 R
8 5 L
8 11 R
```

🟢 **Tree Representation**:

```
        12
       /  \
      8   18
     / \
    5  11
```

### **Step-by-Step Execution**

| Node | Left Height | Right Height | Computed Height |
| ---- | ----------- | ------------ | --------------- |
| 5    | -1          | -1           | `0`             |
| 11   | -1          | -1           | `0`             |
| 8    | `0`         | `0`          | `1`             |
| 18   | -1          | -1           | `0`             |
| 12   | `1`         | `0`          | **`2`**         |

### ✅ **Final Output**

```plaintext
2
```

---

## 🕒 **Time & Space Complexity**

| Complexity                     | Value                                               |
| ------------------------------ | --------------------------------------------------- |
| **Worst Case Time Complexity** | **O(n)** (Each node is processed once)              |
| **Best Case Complexity**       | **O(n)**                                            |
| **Space Complexity**           | **O(h)** (Recursive call stack for tree height `h`) |

---

## 🎉 **Key Takeaways**

✅ **DFS Recursion** efficiently calculates **height** with **O(n) time complexity**.  
✅ **Only one recursive function call per node**, making it optimal.  
✅ **Handles deep trees efficiently** (`n = 10⁵`).

🔹 **Try running the program with different test cases! 🚀**
