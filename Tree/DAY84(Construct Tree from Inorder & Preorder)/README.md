# 🌳 Construct Tree from Inorder & Preorder Traversal

## 📜 Problem Statement

Given two integer arrays **inorder** and **preorder** representing the inorder and preorder traversal of a binary tree, your task is to **construct the tree** and return the root node of the constructed tree.

📌 **Note:** The output should be printed in **postorder traversal** of the constructed tree.

---

## 📌 Constraints

✅ **1 ≤** number of nodes **≤ 10³**  
✅ **0 ≤** nodes’ values **≤ 10³**  
✅ Both `inorder` and `preorder` arrays contain **unique values**.

---

## 🔍 Function Description

```java
class Solution {
    public static Node buildTree(int inorder[], int preorder[]) {
        // Implementation here
    }
}
```

### **🔹 Parameters:**

- `inorder[]` → An array representing the inorder traversal of the tree.
- `preorder[]` → An array representing the preorder traversal of the tree.

### **🔹 Returns:**

- The root node of the constructed **binary tree**.

---

## 📥 Input Format

```
n
inorder[] values
preorder[] values
```

- `n` → Number of nodes in the tree.
- `inorder[]` → The inorder traversal array.
- `preorder[]` → The preorder traversal array.

---

## 📤 Output Format

```
Postorder traversal of the constructed tree.
```

---

## 📚 Examples & Explanations

### **Example 1**

#### **🔹 Input:**

```
4
1 6 8 7
1 6 7 8
```

#### **🔹 Output:**

```
8 7 6 1
```

#### **🔹 Explanation:**

The constructed tree looks like:

```
       1
      / \
     6   7
         /
        8
```

📌 **Postorder traversal:** `[8, 7, 6, 1]`

---

### **Example 2**

#### **🔹 Input:**

```
6
3 1 4 0 2 5
0 1 3 4 2 5
```

#### **🔹 Output:**

```
3 4 1 5 2 0
```

#### **🔹 Explanation:**

The constructed tree looks like:

```
       0
      / \
     1   2
    / \   \
   3   4   5
```

📌 **Postorder traversal:** `[3, 4, 1, 5, 2, 0]`

---

## 🛠️ **Approach**

### **🔹 1. Brute Force Approach (Inefficient) 🚨**

#### ✅ **Steps:**

1. Pick the first element of `preorder[]` as the **root**.
2. Find the index of this root in `inorder[]`.
3. Recursively construct the left and right subtrees.

#### ⚠️ **Fallbacks:**

- Searching for an element in `inorder[]` takes **O(n)** time → **Total Time Complexity: O(n²)** (slow for large `n`).

---

### **🔹 2. Optimized Approach (Using HashMap) 🔥**

#### ✅ **Steps:**

1. **Use a HashMap** to store indexes of `inorder[]` for **O(1) lookup**.
2. Maintain a global variable to track the current **preorder index**.
3. Recursively build the tree in **O(n) time**.

#### ✅ **Time Complexity:** **O(n)**

#### ✅ **Space Complexity:** **O(n) for recursion stack + HashMap**

---

## 🚀 **Optimized Solution (Code Implementation)**

```java
import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int key) {
        data = key;
        left = right = null;
    }
}

class Solution {
    static int preorderIndex = 0;
    static Map<Integer, Integer> inorderMap;

    public static Node buildTree(int inorder[], int preorder[]) {
        preorderIndex = 0;
        inorderMap = new HashMap<>();

        // Store inorder indices in a HashMap
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return constructTree(preorder, 0, inorder.length - 1);
    }

    private static Node constructTree(int preorder[], int left, int right) {
        if (left > right) return null;

        int rootValue = preorder[preorderIndex++];
        Node root = new Node(rootValue);

        int inorderIdx = inorderMap.get(rootValue);

        root.left = constructTree(preorder, left, inorderIdx - 1);
        root.right = constructTree(preorder, inorderIdx + 1, right);

        return root;
    }
}
```

---

## 🛠 **Dry Run Example**

### **Input**

```
5
2 5 4 1 3
1 4 5 2 3
```

### **Tree Construction**

```
       1
      / \
     4   3
    / \
   5   2
```

### **Output**

```
2 5 4 3 1
```

---

## 🚀 **Complexity Analysis**

| Approach                | Time Complexity | Space Complexity                     |
| ----------------------- | --------------- | ------------------------------------ |
| **Brute Force**         | O(n²)           | O(n)                                 |
| **Optimized (HashMap)** | **O(n)**        | **O(n) (HashMap + Recursion Stack)** |

✅ **Optimized approach is the best choice for large trees.**

---

## 🎯 **Key Takeaways**

✅ Uses **O(n) time complexity** with **HashMap optimization**  
✅ **Efficient recursion** for tree construction  
✅ **Postorder traversal output**  
✅ **Handles large input sizes** effectively

---

## 🎯 **Final Thoughts**

This approach is **optimized, easy to understand, and efficient** 🚀. If you have any questions or suggestions for improvements, let me know! 😊🔥

---

### 🔥 **Enjoy Coding! 🚀💻**
