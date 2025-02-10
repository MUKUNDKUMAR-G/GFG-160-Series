# 🌳 **K Sum Paths in a Binary Tree**

## 📜 **Problem Statement**

Given a **binary tree** and an **integer `k`**, find the number of **downward paths** (from parent to child) where the sum of the node values in the path equals `k`.

🔹 **Key Constraints**:

- Paths **must always move downward** (parent to child).
- A path **can start and end at any node** in the tree.
- The sum of node values in the path should be exactly equal to `k`.

---

## 📌 **Constraints**

🔹 `1 ≤ number of nodes ≤ 10⁴`  
🔹 `-100 ≤ node value ≤ 100`  
🔹 `-10⁹ ≤ k ≤ 10⁹`

---

## ⚙️ **Function Description**

```java
class Solution {
    public int sumK(Node root, int k) {
        // Implementation goes here
    }
}
```

**Parameters**:

- `Node root` → The root node of the binary tree.
- `int k` → The target sum for downward paths.

**Returns**:

- An **integer** representing the number of valid paths with sum `k`.

---

## 📥 **Input Format**

- The first line contains an integer `n`, the **number of nodes** in the tree.
- The next `n-1` lines contain **three values**: `parent child L/R`, representing the relationship between nodes in the tree.
- The last line contains the integer `k`, representing the target sum.

---

## 📤 **Output Format**

- A **single integer** representing the count of valid downward paths with sum `k`.

---

## 🔍 **Examples with Explanation**

### **Example 1**

**Input:**

```
k = 7
root[] = [1, 2, 3, 4, 5, 6, 7]
```

**Tree Structure:**

```
       1
      / \
     2   3
    / \   \
   4   5   7
  /
 6
```

**Output:**

```
3
```

**Explanation:**  
The following **3** paths sum to `7`:

- **Path 1:** `1 → 2 → 4` (`1 + 2 + 4 = 7`)
- **Path 2:** `3 → 4` (`3 + 4 = 7`)
- **Path 3:** `7` (`7 = 7`)

---

### **Example 2**

**Input:**

```
k = 3
root[] = [1, 2, 3]
```

**Tree Structure:**

```
    1
   / \
  2   3
```

**Output:**

```
2
```

**Explanation:**  
The **2** paths that sum to `3`:

- **Path 1:** `1 → 2` (`1 + 2 = 3`)
- **Path 2:** `3` (`3 = 3`)

---

## 🛠 **Approach**

### **1️⃣ Brute Force Approach (Inefficient) ❌**

💡 **Intuition**: Try **all possible paths** using DFS and check if any sum up to `k`.

🔹 **Steps**:

1. Start from **every node** as the root.
2. Perform a DFS for **each path** and calculate the sum.
3. If the sum equals `k`, count the path.

⏳ **Time Complexity**: `O(n²)`, since for each node, we explore all possible paths.

🚨 **Fallbacks**:

- **Inefficient for large trees** (`n = 10⁴`).
- **Redundant calculations** lead to high execution time.

---

### **2️⃣ Optimized Approach using Prefix Sum (Efficient) ✅**

💡 **Intuition**:  
Instead of checking all paths separately, we use a **prefix sum + hash map** approach to track cumulative sums efficiently.

🔹 **Steps**:

1. **Use DFS** to traverse the tree.
2. **Maintain a prefix sum map** to store `prefixSum → frequency`.
3. **Check if `prefixSum - k` exists** in the map (indicating a valid path ending at current node).
4. **Update prefix sum** in the map before recursive calls and remove after returning (backtracking).

⏳ **Time Complexity**: `O(n)`, since we visit each node once.  
💾 **Space Complexity**: `O(n)`, storing prefix sums in a HashMap.

---

## 🔥 **Efficient Code Implementation**

```java
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    private int count = 0;

    public int sumK(Node root, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);

        dfs(root, 0, k, prefixSum);
        return count;
    }

    private void dfs(Node node, int currentSum, int k, Map<Integer, Integer> prefixSum) {
        if (node == null) return;

        currentSum += node.data;

        if (prefixSum.containsKey(currentSum - k)) {
            count += prefixSum.get(currentSum - k);
        }

        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);

        dfs(node.left, currentSum, k, prefixSum);
        dfs(node.right, currentSum, k, prefixSum);

        prefixSum.put(currentSum, prefixSum.get(currentSum) - 1);
    }
}
```

---

## 🎯 **Why This Approach?**

✅ **Optimized** → Uses **prefix sum hashing** to track subarrays efficiently.  
✅ **Time Complexity `O(n)`** → Visits each node **once** instead of checking all paths separately.  
✅ **Handles Negative Values** → Unlike brute force, this approach efficiently accounts for negative numbers.

---

## 🎉 **Final Thoughts**

This **optimized solution** is **fast, scalable, and efficient** for handling large binary trees! 🚀

💡 **Need further explanation or modifications? Let me know!** 😊
