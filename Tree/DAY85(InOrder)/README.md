# 🌳 Inorder Traversal of a Binary Tree

## 📜 Problem Statement

Given the root of a **binary tree**, your task is to return the **Inorder Traversal** of the tree.

📌 **Inorder Traversal Rule:**  
1️⃣ **Left subtree** (visit all nodes in the left subtree)  
2️⃣ **Current node** (process the root)  
3️⃣ **Right subtree** (visit all nodes in the right subtree)

---

## 📌 Constraints

✅ **1 ≤** number of nodes **≤ 10⁵**  
✅ **0 ≤** node’s value **≤ 10⁵**

---

## 🔍 Function Description

```java
class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        // Implementation here
    }
}
```

### **🔹 Parameters:**

- `root` → The root node of the binary tree.

### **🔹 Returns:**

- An `ArrayList<Integer>` containing the **inorder traversal** of the tree.

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
Inorder traversal sequence.
```

---

## 📚 Examples & Explanations

### **Example 1**

#### **🔹 Input:**

```
5
1 2 L
1 3 R
2 4 L
2 5 R
```

#### **🔹 Output:**

```
4 2 5 1 3
```

#### **🔹 Explanation:**

The constructed tree looks like:

```
       1
      / \
     2   3
    / \
   4   5
```

📌 **Inorder Traversal:** `[4, 2, 5, 1, 3]`

---

### **Example 2**

#### **🔹 Input:**

```
6
8 1 L
8 5 R
1 7 R
5 10 L
5 6 R
10 6 R
```

#### **🔹 Output:**

```
1 7 8 10 6 5 6
```

#### **🔹 Explanation:**

The constructed tree looks like:

```
        8
       / \
      1   5
       \  / \
       7 10  6
          \
           6
```

📌 **Inorder Traversal:** `[1, 7, 8, 10, 6, 5, 6]`

---

## 🛠️ **Approach**

### **🔹 1. Recursive Approach (Simple & Clean) 🚀**

#### ✅ **Steps:**

1. **Base Case:** If `root == null`, return.
2. **Recursive Call:**
   - Traverse **left subtree**
   - Process **current node**
   - Traverse **right subtree**

#### ✅ **Time Complexity:** **O(n)**

#### ✅ **Space Complexity:** **O(n) (Recursion Stack)**

---

### **🔹 2. Iterative Approach (Using Stack) 🔥**

#### ✅ **Steps:**

1. Use a **stack** to store nodes and traverse the tree **without recursion**.
2. **Push left nodes** until we reach `null`.
3. **Process node**, then **traverse right subtree**.

#### ✅ **Time Complexity:** **O(n)**

#### ✅ **Space Complexity:** **O(n) (Stack Storage)**

---

## 🚀 **Optimized Solution (Recursive Implementation)**

```java
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
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);
        result.add(node.data);
        inorderHelper(node.right, result);
    }
}
```

---

## 🚀 **Iterative Approach (Using Stack)**

```java
import java.util.*;

class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            result.add(curr.data);
            curr = curr.right;
        }

        return result;
    }
}
```

---

## 🛠 **Dry Run Example**

### **Input**

```
5
1 2 L
1 3 R
2 4 L
2 5 R
```

### **Tree Construction**

```
       1
      / \
     2   3
    / \
   4   5
```

### **Output**

```
4 2 5 1 3
```

---

## 🚀 **Complexity Analysis**

| Approach              | Time Complexity | Space Complexity       |
| --------------------- | --------------- | ---------------------- |
| **Recursive**         | O(n)            | O(n) (Recursion Stack) |
| **Iterative (Stack)** | O(n)            | O(n) (Stack Storage)   |

✅ **Both approaches are efficient for large trees!**

---

## 🎯 **Key Takeaways**

✅ Uses **O(n) time complexity**  
✅ **Recursive & Iterative approaches**  
✅ **Handles large input sizes effectively**  
✅ **Can be applied to other tree traversal problems**

---

## 🎯 **Final Thoughts**

This approach is **optimized, easy to understand, and efficient** 🚀. If you have any questions or suggestions for improvements, let me know! 😊🔥

---

### 🔥 **Happy Coding! 🚀💻**
