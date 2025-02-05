# 🌳 **Mirror Tree**

## 📜 **Problem Statement**

Given a **binary tree**, convert it into its **Mirror Tree**.  
A **Mirror of a Binary Tree** is another tree with the **left and right children** of **all non-leaf nodes interchanged**.

---

## 📌 **Constraints**

- **1 ≤ number of nodes ≤ 10⁵**
- **1 ≤ node->data ≤ 10⁵**

---

## 📝 **Function Description**

### `void mirror(Node node)`

Modifies the binary tree rooted at `node` to its mirror representation.

---

## 📥 **Input Format**

- First, enter the number of nodes `n`.
- Next, enter `n-1` lines containing **three values**:
  - `parent` (parent node)
  - `child` (child node)
  - `L/R` (L for left child, R for right child)

---

## 📤 **Output Format**

Print the **in-order traversal** of the **mirrored tree**.

---

## 📝 **Examples & Explanations**

### **Example 1**

#### 🔹 **Input**

```
3
1 2 L
1 3 R
```

#### ✅ **Output**

```plaintext
3 1 2
```

#### 🧐 **Explanation**

![Explanation-example1](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700155/Web/Other/blobid0_1736926809.png)

In-order Traversal: `3 1 2`

---

### **Example 2**

#### 🔹 **Input**

```
5
1 2 L
1 3 R
2 4 L
2 5 R
```

#### ✅ **Output**

```plaintext
5 2 4 1 3
```

#### 🧐 **Explanation**

![Explanation-Example2](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700155/Web/Other/blobid1_1736926809.png)

In-order Traversal: `5 2 4 1 3`

---

## 🚀 **Approach**

### 🔹 **1. Brute Force Approach**

#### 🔍 **Idea:**

- Create a **new tree** by swapping left and right children.
- Requires **extra space** for a new tree.

⏳ **Time Complexity:** `O(n)`  
🛠️ **Space Complexity:** `O(n)`

#### ❌ **Why Brute Force Fails?**

- **Additional Space Requirement** for creating a new tree.
- **Inefficient** as it does not modify the existing tree.

---

### 🔹 **2. Optimal Approach (Recursive In-place Swap)**

✅ **Traverse the tree using Pre-order or Post-order traversal**.  
✅ **Swap the left and right children** of each node during traversal.

⏳ **Time Complexity:** **O(n)**  
🛠️ **Space Complexity:** **O(h)** (due to recursive stack, `h` is height)

---

## ✅ **Optimal Solution (Java)**

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

class BinaryTree {
    Node root;

    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        if (node == null) return;

        // Swap left and right
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recur for left and right subtrees
        mirror(node.left);
        mirror(node.right);
    }

    // Function for in-order traversal
    void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
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

### **Input:**

```
5
1 2 L
1 3 R
2 4 L
2 5 R
```

### **In-order of Mirror Tree:**

```plaintext
5 2 4 1 3
```

---

## 🕒 **Time & Space Complexity**

| Complexity                     | Value                                   |
| ------------------------------ | --------------------------------------- |
| **Worst Case Time Complexity** | **O(n)** (Every node is processed once) |
| **Space Complexity**           | **O(h)** (Recursive stack)              |

---

## 🎉 **Key Takeaways**

✅ Efficient **in-place** conversion to **Mirror Tree**  
✅ **No extra space** required apart from recursion stack  
🔹 **Experiment with different test cases! 🚀**
