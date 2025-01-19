# 🔄 Rotate a Linked List

---

## 💡 Problem Statement

Given the `head` of a singly linked list and an integer `k`, your task is to **left rotate** the linked list `k` times.  
A left rotation shifts the list such that the head moves to the end, and all elements move one step to the left \( k \) times.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{number of nodes}$ $\leq$ $10^5$ \)
- \( 0 $\leq$ k $\leq$ $10^9$ \)
- \( 0 $\leq$ $\text{data of nodes}$ $\leq$ $10^9$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public Node rotate(Node head, int k);
}
```

### Parameters

- **`head`**: A reference to the head node of the singly linked list.
- **`k`**: The number of left rotations to perform.

### Returns

- The new head of the rotated linked list after \( k \) rotations.

---

## 📥 Input Format

1. A singly linked list starting with `head`.
2. An integer \( k \), the number of rotations to perform.

---

## 📤 Output Format

- The new head of the linked list after performing \( k \) left rotations.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
head = 10 -> 20 -> 30 -> 40 -> 50
k = 4
```

**Output**:

```plaintext
50 -> 10 -> 20 -> 30 -> 40 -> NULL
```

**Explanation**:

1. Rotate 1: \( 20 $\to$ 30 $\to$ 40 $\to$ 50 $\to$ 10 \).
2. Rotate 2: \( 30 $\to$ 40 $\to$ 50 $\to$ 10 $\to$ 20 \).
3. Rotate 3: \( 40 $\to$ 50 $\to$ 10 $\to$ 20 $\to$ 30 \).
4. Rotate 4: \( 50 $\to$ 10 $\to$ 20 $\to$ 30 $\to$ 40 \).

---

### Example 2

**Input**:

```plaintext
head = 10 -> 20 -> 30 -> 40
k = 6
```

**Output**:

```plaintext
30 -> 40 -> 10 -> 20 -> NULL
```

**Explanation**:

- \( k = 6 \) results in \( k $\%$ 4 = 2 \).
- Rotate 1: \( 20 $\to$ 30 $\to$ 40 $\to$ 10 \).
- Rotate 2: \( 30 $\to$ 40 $\to$ 10 $\to$ 20 \).

---

## 💡 Approach

### 1. Brute Force (Inefficient)

#### Steps

1. Perform \( k \) left rotations one by one.
   - For each rotation, move the head to the end of the list.

#### Fallbacks in Brute Force

- **Inefficient for large \( k \)**:  
  \( k \) can be as large as \( $10^9$ \), which results in excessive iterations.
- **Repetitive Traversals**:  
  Each rotation requires traversing the list, making the time complexity \( O(k $\times$ n) \).

---

### 2. Optimized Approach

#### Key Idea

- Use **modulo** to reduce \( k \):  
  \( k = k $\%$ $\text{length of the list}$ \).
- Close the linked list into a circular list and break it at the appropriate position.

#### Steps

1. **Calculate Length**: Traverse the list to determine its length and connect the last node to the head, forming a circular list.
2. **Optimize \( k \)**: Reduce \( k \) using \( k = k $\%$ $\text{length}$ \).
3. **Traverse to New Head**:
   - Traverse the list to \( $\text{length}$ - k \) position.
   - Break the circular connection and return the new head.

---

## ⏱️ Time & Space Complexity

- **Time Complexity**: \( O(n) \)
  - \( O(n) \) to calculate the length.
  - \( O(n) \) to locate the new head.
- **Space Complexity**: \( O(1) \)
  - No additional data structures are used.

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
    public Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find the length of the list and make it circular
        Node current = head;
        int length = 1;
        while (current.next != null) {
            length++;
            current = current.next;
        }
        current.next = head; // Connect the last node to the head to make it circular

        // Step 2: Reduce k using modulo
        k = k % length;
        if (k == 0) {
            current.next = null; // Break the circular connection
            return head;
        }

        // Step 3: Traverse to the (length - k)th node
        current = head;
        for (int i = 0; i < k - 1; i++) {
            current = current.next;
        }

        // Step 4: Update the new head and break the circular connection
        Node newHead = current.next;
        current.next = null;

        return newHead;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
Enter the number of nodes: 5
Enter the elements of the linked list:
10 20 30 40 50
Enter the number of rotations: 4
```

### Execution Steps:

1. **Initial List**:

   ```plaintext
   10 -> 20 -> 30 -> 40 -> 50 -> NULL
   ```

2. **Calculate Length**:  
   Length = 5.

3. **Optimize \( k \)**:  
   \( k = 4 \% 5 = 4 \).

4. **Find New Head**:  
   Traverse to the \( 4 \)th node and break the connection.

5. **Reordered List**:

   ```plaintext
   50 -> 10 -> 20 -> 30 -> 40 -> NULL
   ```

6. **Output**:

```plaintext
Rotated Linked List: 50 -> 10 -> 20 -> 30 -> 40 -> NULL
```

---

## ✨ Key Takeaways

- This solution is efficient for large \( k \) due to the use of modulo.
- Forms and breaks a circular list, avoiding multiple traversals.

**Happy Coding!** 🚀
