# 🌳 **Level Order Traversal of a Binary Tree**

## 📜 **Problem Statement**

Given the **root of a binary tree** with **n nodes**, perform a **level order traversal** and return the result as a list of lists.  
Each inner list represents the nodes at a **specific level** in the tree.

✅ **Level order traversal** follows **Breadth-First Search (BFS)** and visits nodes **level by level** from left to right.

---

## 📌 **Constraints**

- **1 ≤ number of nodes ≤ 10⁵**
- **0 ≤ node->data ≤ 10⁹**

---

## 📥 **Input Format**

A **binary tree** represented as `root`.

### **Example Input (Tree Representation)**

```
      1
     / \
    2   3
```

**Input:** `root = [1, 2, 3]`

---

## 📤 **Output Format**

Return a **list of lists**, where each inner list contains the elements at a specific level.

### **Example Output**

```plaintext
[[1], [2, 3]]
```

---

## 📝 **Examples & Explanations**

### **Example 1**

#### 🔹 **Input Tree**

```
      1
     / \
    2   3
```

#### ✅ **Output**

```plaintext
[[1], [2, 3]]
```

#### 🧐 **Explanation**

- **Level 1**: `[1]`
- **Level 2**: `[2, 3]`

---

### **Example 2**

#### 🔹 **Input Tree**

```
        10
       /  \
      20   30
     /  \
    40   50
```

#### ✅ **Output**

```plaintext
[[10], [20, 30], [40, 50]]
```

#### 🧐 **Explanation**

- **Level 1**: `[10]`
- **Level 2**: `[20, 30]`
- **Level 3**: `[40, 50]`

---

## 🚀 **Approach**

### 🔹 **1. Brute Force Approach (Recursive)**

#### 🔍 **Idea:**

- **Use DFS** (**Depth-First Search**) and traverse **level by level**.
- Store nodes **in an array** grouped by their depth.
- **Time Complexity**: `O(n)`
- **Space Complexity**: `O(n)` (Stack space for recursion)

#### ❌ **Why Brute Force Fails?**

- **Inefficient for large trees** (`n = 10⁵`).
- **Consumes more memory** due to recursion stack.
- **Cannot handle unbalanced trees optimally**.

---

### 🔹 **2. Optimized Approach (BFS using Queue)**

✅ **Use BFS (Breadth-First Search) with a Queue** to traverse level by level.  
✅ **Maintain a queue to process each level separately.**  
✅ **At each level, dequeue nodes, process them, and enqueue their children.**

#### 🔹 **Steps:**

1. **Use a queue** to store nodes **level-wise**.
2. **Process one level at a time**:
   - Remove nodes from the queue.
   - Store their values in a **temporary list**.
   - Add their **left and right children** to the queue.
3. **Repeat until all levels are processed**.

⏳ **Time Complexity:** **O(n)** (Each node is visited once)  
🛠️ **Space Complexity:** **O(n)** (Queue stores all nodes at one level)

---

## ✅ **Optimized BFS Solution (Java)**

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
}
```

---

## 🎯 **Example Walkthrough**

Let's take the input:

```
5
10 20 L
10 30 R
20 40 L
20 50 R
```

🟢 **Tree Representation**:

```
        10
       /  \
      20   30
     /  \
    40   50
```

### **Step-by-Step Execution**

| Queue      | Level Processed | Result                       |
| ---------- | --------------- | ---------------------------- |
| `[10]`     | `[10]`          | `[[10]]`                     |
| `[20, 30]` | `[20, 30]`      | `[[10], [20, 30]]`           |
| `[40, 50]` | `[40, 50]`      | `[[10], [20, 30], [40, 50]]` |

### ✅ **Final Output**

```plaintext
[[10], [20, 30], [40, 50]]
```

---

## 🕒 **Time & Space Complexity**

| Complexity                     | Value                                          |
| ------------------------------ | ---------------------------------------------- |
| **Worst Case Time Complexity** | **O(n)** (Each node is processed once)         |
| **Best Case Complexity**       | **O(n)**                                       |
| **Space Complexity**           | **O(n)** (Queue stores all nodes at one level) |

---

## 🎉 **Key Takeaways**

✅ **BFS + Queue** efficiently processes levels one by one.  
✅ **Each node is visited only once**, making it highly efficient.  
✅ **Avoids unnecessary recursion**, making it **iterative & memory-friendly**.  
✅ **Handles large trees efficiently** (`n = 10⁵`).

🔹 **Try running the program with different test cases! 🚀**
