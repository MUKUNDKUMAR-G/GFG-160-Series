# 🌳 Check for BST (Binary Search Tree)

## 📌 Problem Statement

Given the root of a binary tree, determine whether it is a **Binary Search Tree (BST)** or not.

### 🔹 Properties of a BST:

1. The left subtree of a node contains only nodes with keys **less** than the node's key.
2. The right subtree of a node contains only nodes with keys **greater** than the node's key.
3. Both the left and right subtrees must also be **BSTs**.
4. **No duplicate values** are allowed in a BST.

---

## 📜 Constraints

- **1 ≤ number of nodes ≤ 10⁵**
- **1 ≤ node->data ≤ 10⁹**

---

## 📝 Function Description

```java
boolean isBST(Node root)
```

- **Input**: A `Node root` representing the root of the binary tree.
- **Output**: Returns `true` if the tree is a valid BST, otherwise returns `false`.

---

## 📥 Input Format

- The first line contains the number of nodes `n`.
- The next `n-1` lines contain three values:
  - `parent node value`, `child node value`, and `'L'` or `'R'` (denoting left or right child).

---

## 📤 Output Format

- Print **"true"** if the tree is a valid BST.
- Print **"false"** otherwise.

---

## 🔍 Examples

### **Example 1**

#### **Input:**

```
root = [2, 1, 3, N, N, N, 5]
```

#### **Output:**

```
true
```

#### **Explanation:**

```
    2
   / \
  1   3
       \
        5
```

The left subtree contains **smaller** values and the right subtree contains **greater** values. ✅ **Valid BST**

---

### **Example 2**

#### **Input:**

```
root = [2, N, 7, N, 6, N, 9]
```

#### **Output:**

```
false
```

#### **Explanation:**

```
    2
     \
      7
       \
        6  ❌ (Wrong: 6 < 7)
         \
          9
```

Here, `6` is in the right subtree of `7` but is **less than** `7`, violating the BST property. ❌ **Not a BST**

---

## 🏆 **Approach**

### **1️⃣ Brute Force Approach (Inorder Traversal) - O(n) Time, O(n) Space**

- Perform an **inorder traversal** (Left → Root → Right).
- Store values in an **array** and check if the array is sorted.
- If sorted, it's a **BST**; otherwise, it's **not**.

#### 🔴 **Fallbacks**:

- Requires **extra space** (O(n)).
- **Inefficient** for large trees.

---

### **2️⃣ Optimized Approach (Using Recursion) - O(n) Time, O(1) Space**

**🔹 Idea**:

- Instead of storing values, **check in-place** using **valid range constraints** (`min, max`).
- Recursively **restrict** the allowed value range for each subtree.

**✅ Steps:**

1. Start with **range (-∞, +∞)**.
2. Check if `root.data` is **within range**.
3. Recursively check **left subtree** with range `(-∞, root.data)`.
4. Recursively check **right subtree** with range `(root.data, +∞)`.

---

## ⏳ Time & Space Complexity

| Approach                            | Time Complexity | Space Complexity |
| ----------------------------------- | --------------- | ---------------- |
| **Brute Force (Inorder Traversal)** | **O(n)**        | **O(n)**         |
| **Optimized (Recursive)**           | **O(n)**        | **O(1)**         |

---

## 💡 **Optimized Solution (Java)**

```java
class Solution {
    // Function to check if a Binary Tree is BST
    boolean isBST(Node root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);  // Use long to avoid integer overflow
    }

    // Function to check if the subtree is valid within the given range
    boolean isValid(Node root, long left, long right) {
        if (root == null) {
            return true;
        }

        if (root.data >= left || root.data <= right) {
            return false;
        }

        return isValid(root.left, left, root.data) && isValid(root.right, root.data, right);
    }
}
```

---

## 🔄 **Example Walkthrough**

**Test Input:**

```
Number of nodes: 5
Nodes: [10, 5, 20, N, N, 9, 25]
```

**Tree Representation:**

```
    10
   /  \
  5   20
      /  \
     9   25
```

**Output:**

```
false
```

**Explanation:**

- `9` is in the right subtree of `10` but is **less than** `10`. ❌ **Not a BST**

---

## 🎯 **Key Takeaways**

✔️ **Uses recursion to validate BST efficiently.**  
✔️ **Avoids extra space (O(1) auxiliary space).**  
✔️ **Handles large constraints efficiently (O(n) time complexity).**  
✔️ **Prevents integer overflow using `Long.MIN_VALUE` and `Long.MAX_VALUE`.**

🚀 **This is the most optimal way to check if a binary tree is a BST!** 🎯
