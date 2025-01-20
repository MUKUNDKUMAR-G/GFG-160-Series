# 🌟 Merge Two Sorted Linked Lists

---

## 💡 Problem Statement

Given the heads of two **sorted linked lists**, merge the two lists into a **single sorted linked list**. The merged list should also maintain the sorted order.

Return the head of the merged linked list.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{no. of nodes in either list}$ $\leq$ $10^3$ \)
- \( 0 $\leq$ $\text{data in nodes}$ $\leq$ $10^5$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    Node sortedMerge(Node head1, Node head2);
}
```

### Parameters

- **`head1`**: The head node of the first sorted linked list.
- **`head2`**: The head node of the second sorted linked list.

### Returns

- The head node of the merged sorted linked list.

---

## 📥 Input Format

1. Two linked lists with their respective head nodes.
2. The elements of the linked lists are in sorted order.

---

## 📤 Output Format

- A single sorted linked list.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
head1 = 5 -> 10 -> 15 -> 40
head2 = 2 -> 3 -> 20
```

**Output**:

```plaintext
2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40
```

**Explanation**:

- Combine both lists while maintaining the sorted order.

---

### Example 2

**Input**:

```plaintext
head1 = 1 -> 1
head2 = 2 -> 4
```

**Output**:

```plaintext
1 -> 1 -> 2 -> 4
```

**Explanation**:

- Merge the two lists while retaining duplicate elements.

---

## 💡 Approach

### Intuition

Since the input linked lists are already sorted, we can use a **two-pointer technique** to merge them efficiently in a single pass.

---

### Steps

1. **Handle Base Cases**:

   - If either list is `null`, return the other list.

2. **Initialize Pointers**:

   - Use a dummy node to simplify pointer manipulation.
   - Maintain a `tail` pointer to track the end of the merged list.

3. **Merge Lists**:

   - Compare the current nodes of both lists.
   - Append the smaller node to the merged list and move the respective pointer.

4. **Handle Remaining Nodes**:

   - If one list is fully traversed, append the remaining nodes of the other list.

5. **Return Result**:
   - The merged list starts from the node after the dummy node.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- \( O(n + m) \): Each node of the two linked lists is visited once, where \( n \) and \( m \) are the lengths of the two lists.

### Space Complexity

- \( O(1) \): No additional space is used beyond the pointers.

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
    Node sortedMerge(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node dummy = new Node(-1);
        Node tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }

        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        return dummy.next;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
5 10 15 40
2 3 20
```

### Execution Steps:

1. **Initial Lists**:

   - List 1: \( 5 $\to$ 10 $\to$ 15 $\to$ 40 $\to$ $\text{NULL}$ \)
   - List 2: \( 2 $\to$ 3 $\to$ 20 $\to$ $\text{NULL}$ \)

2. **Merge Process**:

   - Compare 5 and 2: Add 2 to the merged list.
   - Compare 5 and 3: Add 3 to the merged list.
   - Compare 5 and 20: Add 5 to the merged list.
   - Continue until all nodes are processed.

3. **Merged List**:

   ```plaintext
   2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40 -> NULL
   ```

4. **Output**:

```plaintext
Merged Linked List: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40 -> NULL
```

---

## ✨ Key Takeaways

- Efficient \( $O(n + m)$ \) solution leveraging sorted properties of input lists.
- Handles edge cases like empty lists seamlessly.

**Happy Coding!** 🚀
