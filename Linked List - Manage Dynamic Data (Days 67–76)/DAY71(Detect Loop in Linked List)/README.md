# Detect Loop in Linked List

---

## 💡 Problem Statement

You are given the head of a singly linked list. Your task is to determine if the linked list contains a **loop**.

A loop exists in a linked list if the `next` pointer of the last node points to any other node in the list (including itself), rather than being `null`.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{number of nodes}$ $\leq$ $10^4$ \)
- \( 1 $\leq$ $\text{node->data}$ $\leq$ $10^3$ \)
- \( 0 $\leq$ $\text{pos}$ $\leq$ $\text{Number of nodes in the linked list}$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public static boolean detectLoop(Node head);
}
```

### Parameters

- **`head`**: The head node of the linked list.

### Returns

- **`boolean`**:
  - `true` if there is a loop in the linked list.
  - `false` otherwise.

---

## 📥 Input Format

1. The head node of a singly linked list.
2. An integer `pos`, which indicates the 1-based position of the node that the last node connects back to, creating a loop. If `pos = 0`, the last node points to `null`, meaning there is no loop.

---

## 📤 Output Format

- Return `true` if a loop is present in the linked list; otherwise, return `false`.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
Linked List: 1 -> 3 -> 4, pos = 2
```

**Output**:

```plaintext
true
```

**Explanation**:  
The last node connects back to the second node, creating a loop.

## ![Example1](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700099/Web/Other/blobid1_1718699705.png)

### Example 2

**Input**:

```plaintext
Linked List: 1 -> 8 -> 3 -> 4, pos = 0
```

**Output**:

```plaintext
false
```

**Explanation**:  
The last node points to `null`, so no loop exists.

![Example 2](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700099/Web/Other/blobid2_1718699755.png)

### Example 3

**Input**:

```plaintext
Linked List: 1 -> 2 -> 3 -> 4, pos = 1
```

**Output**:

```plaintext
true
```

**Explanation**:  
The last node connects back to the first node, creating a loop.

## ![Example 3](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700332/Web/Other/blobid2_1718609744.png)

## 💡 Approach

### 1️⃣ Brute Force

1. Use a **hash table** to keep track of visited nodes.
2. Traverse the linked list while storing each node in the hash table.
3. If a node is encountered twice, a loop exists.
4. If the end of the list is reached (`null`), no loop exists.

#### Fallbacks of Brute Force

- **Space Complexity**: \( O(n) \), due to the hash table storing all visited nodes.

---

### 2️⃣ Optimized Approach (Two-Pointer / Floyd's Cycle Detection Algorithm)

#### Steps

1. Use two pointers, **slow** and **fast**, initialized at the head of the list.
2. Move `slow` one step at a time and `fast` two steps at a time.
3. If there is a loop, the `slow` and `fast` pointers will eventually meet inside the loop.
4. If `fast` reaches the end (`null`), no loop exists.

#### Why This Approach?

- **Time Complexity**: \( O(n) \), as each pointer traverses the list at most once.
- **Space Complexity**: \( O(1) \), as no extra space is used.

---

## ⏱️ Time & Space Complexity

- **Time Complexity**: \( O(n) \), where \( n \) is the number of nodes in the list.
- **Space Complexity**: \( O(1) \).

---

## 🖥️ Solution

### Java Implementation

```java
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // Move slow by 1 step and fast by 2 steps
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet, there is a loop
            if (slow == fast) {
                return true;
            }
        }

        // No loop found
        return false;
    }
}
```

---

## 🔍 Example Walkthrough

### Example Input

```plaintext
Linked List: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 3 (loop back to 3)
```

### Execution

1. **Initialization**:

   - `slow = 1`, `fast = 1`

2. **First Iteration**:

   - `slow = 2`, `fast = 3`

3. **Second Iteration**:

   - `slow = 3`, `fast = 5`

4. **Third Iteration**:

   - `slow = 4`, `fast = 3`

5. **Fourth Iteration**:

   - `slow = 5`, `fast = 5`

   **Loop Detected!**

---

### Example Output

```plaintext
true
```

## 📖 Summary

- **Floyd’s Cycle Detection Algorithm** is a highly efficient and widely used method for detecting loops in linked lists.
- It achieves \( O(n) \) time complexity and \( O(1) \) space complexity, making it an optimal solution for this problem.

---

**Happy Coding!** 🚀
