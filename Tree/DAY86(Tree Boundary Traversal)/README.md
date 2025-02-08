# 🌳 Tree Boundary Traversal

## 📜 Problem Statement

Given the root of a **binary tree**, return its **boundary traversal** in the following order:

1️⃣ **Left Boundary** → Nodes on the leftmost path **excluding leaf nodes**.  
2️⃣ **Leaf Nodes** → All leaf nodes in **left-to-right order**.  
3️⃣ **Right Boundary (Reverse Order)** → Nodes on the rightmost path **excluding the root and leaf nodes**, printed in **reverse order**.

📌 **Note:** If there is no left or right subtree, the root itself is considered part of the boundary.

---

## 📌 Constraints

✅ **1 ≤** number of nodes **≤ 10⁵**  
✅ **1 ≤** node's value **≤ 10⁵**

---

## 🔍 Function Description

```java
class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {

    }
}
```

### **🔹 Parameters:**

- `node` → The root node of the binary tree.

### **🔹 Returns:**

- An `ArrayList<Integer>` containing the **boundary traversal** of the tree.

---

## 📥 Input Format

```
n
parent child L/R
...
```

- `n` → Number of nodes in the tree.
- The next `n-1` lines describe **parent-child relationships** with direction (`L` for left, `R` for right).

---

## 📤 Output Format

```
Boundary Traversal Sequence
```

---

## 📚 Examples & Explanations

### **Example 1**

#### **🔹 Input:**

```
8
1 2 L
1 3 R
2 4 L
2 5 R
3 6 L
3 7 R
5 8 L
5 9 R
```

#### **🔹 Output:**

```
1 2 4 8 9 6 7 3
```

#### **🔹 Explanation:**

Tree representation:

```
        1
       / \
      2   3
     / \  / \
    4   5 6  7
       / \
      8   9
```

📌 **Boundary Traversal:** `[1, 2, 4, 8, 9, 6, 7, 3]`  
✅ **Left boundary**: `[1, 2, 4]`  
✅ **Leaf nodes**: `[8, 9, 6, 7]`  
✅ **Right boundary**: `[3]`

---

### **Example 2**

#### **🔹 Input:**

```
5
1 2 L
2 4 L
2 9 R
4 6 L
4 5 R
```

#### **🔹 Output:**

```
1 2 4 6 5 9
```

#### **🔹 Explanation:**

Tree representation:

```
       1
      /
     2
    / \
   4   9
  / \
 6   5
```

📌 **Boundary Traversal:** `[1, 2, 4, 6, 5, 9]`

---

## 🛠️ **Approach**

### **🔹 1. Brute Force Approach (Inefficient) 🚨**

#### ❌ **Problems:**

- Traversing the entire tree **multiple times** (O(n²) worst case).
- Uses **extra space** for checking duplicates.
- **Complex implementation**.

#### **Time Complexity:** **O(n²)**

#### **Space Complexity:** **O(n)**

---

### **🔹 2. Optimized Approach (Best Solution) 🚀**

#### ✅ **Steps:**

1. **Print Left Boundary** (excluding leaves).
2. **Print Leaf Nodes** (left-to-right order).
3. **Print Right Boundary** (excluding root and leaves, in reverse order).

#### ✅ **Efficient Traversal**

- **O(n) Time Complexity** → Each node is visited once.
- **O(n) Space Complexity** → Stores only the boundary nodes.

---

## 🚀 **Optimized Code Implementation**

```java
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
        else (root.right != null)getLeftBoundary(root.right, arr);
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
        else (root.left != null)getRightBoundary(root.left, arr);

        arr.add(root.data);
    }
}
```

---

## 🚀 **Complexity Analysis**

| Approach               | Time Complexity | Space Complexity |
| ---------------------- | --------------- | ---------------- |
| **Brute Force**        | O(n²)           | O(n)             |
| **Optimized Approach** | O(n)            | O(n)             |

✅ **The optimized approach ensures efficient traversal and minimal memory usage.**

---

## 🛠 **Dry Run Example**

### **Input**

```
5
1 2 L
2 4 L
2 9 R
4 6 L
4 5 R
```

### **Tree Construction**

```
       1
      /
     2
    / \
   4   9
  / \
 6   5
```

### **Boundary Traversal Output**

```
1 2 4 6 5 9
```

✅ **Left boundary:** `[1, 2, 4]`  
✅ **Leaf nodes:** `[6, 5]`  
✅ **Right boundary (reverse order):** `[9]`

---

## 🎯 **Key Takeaways**

✅ **Efficient O(n) solution**  
✅ **Uses minimal space**  
✅ **Handles large trees effectively**  
✅ **Can be applied to real-world hierarchical structures**

---

## 🎯 **Final Thoughts**

This solution is **optimized, easy to understand, and efficient** 🚀. If you have any questions or suggestions for improvements, feel free to reach out! 😊🔥

---

### 🔥 **Happy Coding! 🚀💻**
