### 📌 K-th Smallest Element in a BST

This problem requires finding the **k-th smallest element** in a given **Binary Search Tree (BST)**. Since a BST is sorted in **in-order traversal**, we can efficiently find the **k-th smallest element** using recursion or iterative traversal.

---

## **🔹 Problem Statement**

Given the root of a **BST** and an integer **k**, return the **k-th smallest element** in the BST. If the BST does not contain **k** elements, return **-1**.

---

## **🔹 Constraints**

- **1 ≤ number of nodes, k ≤ 10⁵**
- **1 ≤ node->data ≤ 10⁵**

---

## **🔹 Function Description**

```java
public int kthSmallest(Node root, int k)
```

- **Input:** Root of a BST and an integer **k**
- **Output:** **k-th smallest element** in the BST
- **Return:** **-1** if no such element exists

---

## **🔹 Input Format**

1️⃣ **First input** → Number of nodes in the BST  
2️⃣ **Next inputs** → Pairs of (parent, child, L/R) to construct the BST  
3️⃣ **Last input** → k (to find the k-th smallest element)

---

## **🔹 Output Format**

- If **k-th smallest element exists** → Print the element
- If **not present** → Print **-1**

---

## **🔹 Examples**

### **Example 1**

#### **Input:**

```
Enter number of nodes:
3
Enter nodes (parent, child, L/R):
2 1 L
2 3 R
Enter k:
2
```

#### **Tree Representation**

```
    2
   / \
  1   3
```

#### **Output:**

```
2
```

✅ **Explanation:** The in-order traversal is **[1, 2, 3]**, so the **2nd smallest** element is **2**.

---

### **Example 2**

#### **Input:**

```
Enter number of nodes:
3
Enter nodes (parent, child, L/R):
2 1 L
2 3 R
Enter k:
5
```

#### **Output:**

```
-1
```

❌ **Explanation:** The BST contains only **3 elements**, so the **5th smallest** does not exist.

---

### **Example 3**

#### **Input:**

```
Enter number of nodes:
6
Enter nodes (parent, child, L/R):
20 8 L
20 22 R
8 4 L
8 12 R
12 10 L
12 14 R
Enter k:
3
```

#### **Tree Representation**

```
       20
      /  \
     8    22
    / \
   4   12
      /  \
     10   14
```

#### **Output:**

```
10
```

✅ **Explanation:** The in-order traversal is **[4, 8, 10, 12, 14, 20, 22]**, so the **3rd smallest** element is **10**.

---

## **🔹 Approach**

### **1️⃣ Brute Force Approach - O(N log N)**

- **Store in-order traversal in an array**
- **Sort the array**
- **Return the k-th element**
  ❌ **Fallbacks**: Uses extra space **O(N)** and sorting is unnecessary.

---

### **2️⃣ Optimal Approach - Inorder Traversal (O(N) time, O(1) space)**

- Perform an **in-order traversal (Left → Root → Right)**.
- Keep **count** of visited nodes.
- Stop traversal when **k-th smallest element** is found.

---

## **🔹 Java Implementation**

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
    // Function to return the K-th smallest element in the BST
    public int kthSmallest(Node root, int k) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        int count = 0;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            count++;

            if (count == k) {
                return curr.data;
            }

            curr = curr.right;
        }

        return -1; // If k is greater than the number of nodes
    }
}

```

---

## **🔹 Complexity Analysis**

| Approach                        | Time Complexity | Space Complexity                    |
| ------------------------------- | --------------- | ----------------------------------- |
| **Brute Force (Sorting)**       | **O(N log N)**  | **O(N)**                            |
| **Optimal (Inorder Traversal)** | **O(N)**        | **O(1) (Ignoring recursion stack)** |

---

## **🔹 Why This Approach?**

✅ **Faster than sorting**  
✅ **Uses in-order traversal (natural BST property)**  
✅ **Handles large trees efficiently**

---

## **🔹 Example Walkthrough**

**Given BST:**

```
    20
   /  \
  8    22
 / \
4   12
   /  \
  10   14
```

### **In-order Traversal:**

```
[4, 8, 10, 12, 14, 20, 22]
```

### **Finding k = 3**

- Visit **4** (1st smallest)
- Visit **8** (2nd smallest)
- Visit **10** (✅ 3rd smallest)

**Answer:** **10**

---

## **🚀 Key Takeaways**

🔹 **Uses Stack for in-order traversal**  
🔹 **Handles large inputs efficiently**  
🔹 **Returns -1 if k is out of bounds**  
🔹 **Optimized for BST properties**

---

🔥 **Now you can efficiently find the k-th smallest element in a BST!** 🚀
