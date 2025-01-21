# Reverse Linked List in Groups of K

---

## 💡 Problem Statement

Given the head of a **singly linked list** and an integer \( k \), reverse every group of \( k \) nodes in the linked list.  
If the number of nodes left at the end is less than \( k \), reverse those nodes as well.

---

### Visual Representation

```
Before: 1 → 2 → 3 → 4 | 5 → 6 → 7 → 8   (k=4)
After:  4 → 3 → 2 → 1 | 8 → 7 → 6 → 5
        └─── Group 1 ──┘ └─── Group 2 ──┘
```

---

## 🔒 Constraints

| Parameter  | Constraint | Mathematical Notation             |
| ---------- | ---------- | --------------------------------- |
| List Size  | 1 to 10⁵   | \( 1 $\leq$ n $\leq$ $10^5$ \)    |
| Node Data  | 1 to 10⁶   | \( 1 $\leq$ data $\leq$ $10^6$ \) |
| Group Size | 1 to n     | \( 1 $\leq$ k $\leq$ n \)         |

---

## ⚙️ Function Specification

### Method Signature

```java
public static Node reverseKGroup(Node head, int k)
```

### Node Structure

```java
class Node {
    int data;      // Node value
    Node next;     // Next node reference

    Node(int key) {
        data = key;
        next = null;
    }
}
```

### Parameters

- **`head`**: The head node of the singly linked list.
- **`k`**: The size of each group to reverse.

### Returns

- The head of the modified linked list with groups reversed.

---

## 📥 Input Format

1. A reference to the head of a singly linked list.
2. An integer \( k \), the size of groups for reversing.

---

## 📤 Output Format

- A single linked list with nodes reversed in groups of \( k \).

---

## 🎯 Examples

### Example 1: Perfect Groups

```plaintext
Input:
─────────────────────────────────
head = 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
k = 4

Process:
─────────────────────────────────
Step 1: [1 → 2 → 3 → 4] → 5 → 6 → 7 → 8
        └─── Group 1 ───┘
Step 2: [4 → 3 → 2 → 1] → 5 → 6 → 7 → 8
        └── Reversed 1 ─┘
Step 3: 4 → 3 → 2 → 1 → [5 → 6 → 7 → 8]
                        └─── Group 2 ───┘
Final:  4 → 3 → 2 → 1 → [8 → 7 → 6 → 5]
                        └── Reversed 2 ─┘
```

### Example 2: With Remainder

```plaintext
Input:
─────────────────────────────────
head = 1 → 2 → 3 → 4 → 5
k = 3

Process:
─────────────────────────────────
Step 1: [1 → 2 → 3] → 4 → 5
        └─ Group 1 ─┘
Step 2: [3 → 2 → 1] → 4 → 5
        └─ Reversed ┘
Step 3: 3 → 2 → 1 → [4 → 5]
                    └ Remainder ┘
Final:  3 → 2 → 1 → [5 → 4]
                    └ Reversed ┘
```

---

## 💡 Approach

### Intuition

Reversing the list in groups of \( k \) can be done efficiently using a **dummy node** to simplify pointer manipulation and iterating through the list.  
For every group of \( k \):

1. Reverse the links between the \( k \) nodes.
2. Update the pointers of the previous and next groups to maintain continuity.
3. If nodes remaining are less than \( k \), reverse them as a smaller group.

---

### Steps

1. **Edge Cases**:

   - If \( k = 1 \) or the linked list has fewer than \( k \) nodes, no reversal is needed.

2. **Count Nodes**:

   - Traverse the linked list to count the total number of nodes.

3. **Reverse Groups**:

   - For every group of \( k \), reverse \( k \) links while maintaining pointers for continuity.

4. **Handle Remaining Nodes**:
   - If the remaining nodes are less than \( k \), reverse them separately.

---

## 💡 Algorithm Design

### Core Strategy

1. **Initialization Phase**

   ```
   dummy → head → node₁ → node₂ → ... → nodeₖ
   ```

2. **Group Processing**

   ```
   For each group:
   prev → [node₁ → node₂ → ... → nodeₖ] → next_group
         └────── Reverse These ───────┘
   ```

3. **Remainder Handling**
   ```
   If remaining_nodes < k:
   reverse(remaining_nodes)
   ```

### Key Techniques

1. **Dummy Node Usage**

   - Purpose: Simplifies head modification
   - Implementation: `Node dummy = new Node(0)`

2. **Three-Pointer Mechanism**

   ```java
   Node prev = dummy;    // Group anchor
   Node curr = head;     // Active node
   Node next = null;     // Next node to process
   ```

3. **Group Validation**
   ```java
   // Count nodes for group processing
   int count = getCount(head);
   while (count >= k) {
       // Process group
       count -= k;
   }
   ```

## ⏱️ Time & Space Complexity

- **Time Complexity**: \( O(n) \), where \( n \) is the number of nodes in the linked list. Each node is visited once.
- **Space Complexity**: \( O(1) \), as no additional space is used beyond pointers.

---

## 🖥️ Solution

### Java Implementation

```java
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // Edge cases
        if (head == null || k == 1) {
            return head;
        }

        // Count total nodes
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // Create a dummy node
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        curr = head;

        // Process all groups
        while (count >= k) {
            curr = prev.next; // First node of current k-group
            Node next = curr.next; // Second node of current k-group

            // Reverse k-1 links for k nodes
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }

            prev = curr;
            count -= k;
        }

        // If remaining nodes are less than k, reverse them too
        if (count > 0) {
            curr = prev.next;
            Node next = curr.next;
            while (next != null) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
        }

        return dummy.next;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
Enter the number of nodes: 8
Enter the elements of the linked list:
1 2 3 4 5 6 7 8
Enter the value of k: 4
```

### Execution Steps:

1. **Initial List**:

   ```plaintext
   1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> NULL
   ```

2. **Reverse First Group**:

   - Group: \( 1, 2, 3, 4 \) → \( 4, 3, 2, 1 \).

3. **Reverse Second Group**:

   - Group: \( 5, 6, 7, 8 \) → \( 8, 7, 6, 5 \).

4. **Resulting List**:

   ```plaintext
   4 -> 3 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5 -> NULL
   ```

5. **Output**:

```plaintext
Reversed Linked List:
4 -> 3 -> 2 -> 1 -> 8 -> 7 -> 6 -> 5 -> NULL
```

---

## ✨ Key Takeaways

- Handles edge cases seamlessly, such as \( k = 1 \) or incomplete groups.
- Efficient \( O(n) \) solution using constant space.

**Happy Coding!** 🚀
