# Detect the First Node of a Loop in a Linked List

---

## 💡 Problem Statement

You are given the head of a singly linked list. Your task is to determine if there is a **loop** in the list. If a loop exists, return the **first node** of the loop. Otherwise, return `NULL`.

A loop in a linked list means that the `next` pointer of a node points back to one of the previous nodes in the list (including itself), forming a cycle.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{number of nodes}$ $\leq$ $10^6$ \)
- \( 1 $\leq$ $\text{node->data}$ $\leq$ $10^6$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public static Node findFirstNode(Node head);
}
```

### Parameters

- **`head`**: The head node of the singly linked list.

### Returns

- **The first node** of the loop if a loop exists.
- Return `NULL` if there is no loop in the linked list.

---

## 📥 Input Format

1. **`head`**: The head of the singly linked list.
2. **`pos`**: An integer indicating the 1-based position where the loop starts in the linked list. If `pos = 0`, there is no loop.

---

## 📤 Output Format

- **If a loop exists**: The data of the first node in the loop.
- **If no loop exists**: Return `-1`.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
Linked List: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 3 (loop back to 3)
```

**Output**:

```plaintext
3
```

**Explanation**:  
The loop starts at the node with value `3`.

---

### Example 2

**Input**:

```plaintext
Linked List: 1 -> 2 -> 3 -> 4, pos = 0
```

**Output**:

```plaintext
-1
```

**Explanation**:  
There is no loop in the linked list.

---

## 💡 Approach

To efficiently solve the problem, we can use **Floyd’s Cycle Detection Algorithm** (also known as the **two-pointer technique**) to detect the loop and identify the first node in the loop.

---

### 1️⃣ Brute Force Approach

1. Use a **hash table** or a **set** to keep track of visited nodes.
2. Traverse the linked list and check whether each node has already been visited:
   - If yes, it means there is a loop, and the current node is the first node of the loop.
   - If no, add the node to the hash table and continue traversal.
3. If the traversal completes without revisiting any node, there is no loop.

#### Fallbacks of Brute Force

- **Space Complexity**: \( O(n) \), due to the hash table storing all visited nodes.
- **Time Complexity**: \( O(n) \), as we traverse the entire list.

---

### 2️⃣ Optimized Approach (Floyd’s Cycle Detection Algorithm)

#### Steps

1. **Detect the Loop**:

   - Use two pointers, **slow** and **fast**, both starting at the head of the list.
   - Move `slow` one step at a time and `fast` two steps at a time.
   - If a loop exists, `slow` and `fast` will eventually meet inside the loop.
   - If `fast` or `fast.next` becomes `null`, the list has no loop.

2. **Find the First Node of the Loop**:
   - If a loop is detected, reset `slow` to the head of the list.
   - Move both `slow` and `fast` one step at a time.
   - The point where they meet is the first node of the loop.

#### Why This Approach Works?

- Once a loop is detected, the distance from the meeting point to the first node of the loop is the same as the distance from the head to the first node of the loop.
- By resetting `slow` to the head, the two pointers will converge at the first node of the loop.

---

## ⏱️ Time & Space Complexity

- **Time Complexity**: \( O(n) \), where \( n \) is the number of nodes in the list.
  - Detecting the loop requires \( O(n) \).
  - Finding the first node of the loop also requires \( O(n) \).
- **Space Complexity**: \( O(1) \), as no extra space is used.

---

## 🖥️ Solution

### Java Implementation

```java
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    public static Node findFirstNode(Node head) {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect the loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Loop detected
            if (slow == fast) {
                break;
            }
        }

        // If no loop is detected, return null
        if (slow != fast) {
            return null;
        }

        // Step 2: Find the first node of the loop
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
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

1. **Initialization**:

   - `slow = 1`, `fast = 1`

2. **Detecting the Loop**:

   - After several iterations, `slow` and `fast` meet at the node with value `5`.

3. **Finding the First Node of the Loop**:
   - Reset `slow` to the head.
   - Move `slow` and `fast` one step at a time.
   - They meet at the node with value `3`.

### Example Output:

```plaintext
3
```

---

## 📖 Summary

- Floyd’s Cycle Detection Algorithm is used to efficiently detect the loop and find the first node of the loop in \( O(n) \) time and \( O(1) \) space.
- This is the optimal solution compared to using a hash table for detecting loops.

**Happy Coding!** 🚀
