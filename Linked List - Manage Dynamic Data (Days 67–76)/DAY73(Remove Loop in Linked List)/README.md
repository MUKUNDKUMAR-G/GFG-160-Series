# Remove Loop in Linked List

---

## 💡 Problem Statement

You are given the head of a singly linked list that may contain a **loop**. Your task is to **remove the loop**, if it exists, while keeping the rest of the list unchanged.

A loop in a linked list exists if the `next` pointer of the last node points back to one of the previous nodes in the list. If no loop exists, the list remains unchanged.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{size of linked list}$ $\leq$ $10^5$ \)
- The list contains **unique node values**.

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public static void removeLoop(Node head);
}
```

### Parameters

- **`head`**: The head of the singly linked list.

### Returns

The function does not return anything. It modifies the linked list in place to remove the loop, if one exists.

---

## 📥 Input Format

1. **`head`**: The head node of the singly linked list.
2. **`pos`**: An integer indicating the position (1-based index) where the last node points to create a loop. If `pos = 0`, the list does not contain a loop.

---

## 📤 Output Format

- If the loop is successfully removed, return `true`.
- If there is no loop, also return `true`.

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
A loop is present in the linked list, and it is removed.

![Example 1](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700332/Web/Other/blobid0_1718609709.png)

---

### Example 2

**Input**:

```plaintext
Linked List: 1 -> 8 -> 3 -> 4, pos = 0
```

**Output**:

```plaintext
true
```

**Explanation**:  
There is no loop in the linked list.

![Example 2](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700332/Web/Other/blobid0_1718609876.png)

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
A loop exists where the last node connects back to the first node, and the loop is removed.

![Example 3](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700332/Web/Other/blobid2_1718609744.png)

---

## 💡 Approach

### 1️⃣ Brute Force Approach

1. Use a **hash table** or a **set** to store the nodes as we traverse the linked list.
2. If a node is visited again, it means there is a loop.
3. To remove the loop, find the node just before the looped node and set its `next` pointer to `null`.

#### Fallbacks of Brute Force

- **Space Complexity**: \( O(n) \), due to the extra storage of visited nodes.
- **Time Complexity**: \( O(n) \), as the list is traversed at most twice.

---

### 2️⃣ Optimized Approach: Floyd’s Cycle Detection

We can use **Floyd’s Cycle Detection Algorithm** to detect and remove the loop efficiently.

#### Steps

1. **Detect the Loop**:

   - Use two pointers, **slow** and **fast**, starting at the head.
   - Move `slow` one step at a time and `fast` two steps at a time.
   - If a loop exists, `slow` and `fast` will meet inside the loop.
   - If `fast` or `fast.next` becomes `null`, there is no loop.

2. **Find the Starting Node of the Loop**:

   - Reset `slow` to the head of the list.
   - Move both `slow` and `fast` one step at a time until they meet.
   - The meeting point is the **first node of the loop**.

3. **Remove the Loop**:
   - Traverse the loop using the `fast` pointer to find the node just before the start of the loop.
   - Set its `next` pointer to `null` to remove the loop.

---

## ⏱️ Time & Space Complexity

- **Time Complexity**: \( O(n) \), where \( n \) is the number of nodes in the list.
  - Detecting the loop and finding the node to break the loop both require \( O(n) \).
- **Space Complexity**: \( O(1) \), as no extra space is used.

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
    public static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect the loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // If no loop exists, return
        if (slow != fast) {
            return;
        }

        // Step 2: Find the first node of the loop
        slow = head;
        Node prev = null;

        // Special case: when the loop starts at the head
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null; // Remove the loop
            return;
        }

        // General case: slow and fast meet at the loop start
        while (slow != fast) {
            prev = fast; // To keep track of the node before fast
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Remove the loop
        prev.next = null;
    }
}
```

---

## 🔍 Example Walkthrough

### Example Input:

```plaintext
Linked List: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 3 (loop back to 3)
```

### Execution

1. **Detect the Loop**:

   - `slow` and `fast` meet at node `5`.

2. **Find the Start of the Loop**:

   - Reset `slow` to the head.
   - Move `slow` and `fast` one step at a time until they meet at node `3`.

3. **Remove the Loop**:
   - Traverse the loop to find the node just before the loop start (`6`).
   - Set `fast.next = null`.

### Example Output:

```plaintext
Linked List after loop removal: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL
```

---

## 📖 Summary

- Use Floyd's Cycle Detection Algorithm to detect the loop.
- Reset one pointer to the head to find the starting node of the loop.
- Break the loop by setting the `next` pointer of the node just before the loop start to `null`.

**Happy Coding!** 🚀
