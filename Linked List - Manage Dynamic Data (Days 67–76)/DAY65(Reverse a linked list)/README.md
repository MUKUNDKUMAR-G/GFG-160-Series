# 🌟 Reverse a Linked List

---

## 💡 Problem Statement

Given the `head` of a singly linked list, reverse the list and return the new `head` of the reversed list.

A linked list is reversed when the direction of all the `next` pointers in the list is flipped.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{number of nodes}$ $\leq$ 10^5 \)
- \( 1 $\leq$ $\text{data of nodes}$ $\leq$ 10^5 \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    Node reverseList(Node head);
}
```

### Parameters

- **`head`**: A reference to the head node of the singly linked list.

### Returns

- The head of the reversed linked list.

---

## 📥 Input Format

1. An integer \( n \), the number of nodes in the linked list.
2. \( n \) integers representing the data of each node in the linked list.

---

## 📤 Output Format

- A single line with the data of the nodes in the reversed linked list, separated by " -> ", ending with "NULL".

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
n = 4
head = 1 -> 2 -> 3 -> 4 -> NULL
```

**Output**:

```plaintext
4 -> 3 -> 2 -> 1 -> NULL
```

**Explanation**:

![Example 1](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700005/Web/Other/blobid0_1736947674.png)

---

### Example 2

**Input**:

```plaintext
n = 5
head = 2 -> 7 -> 10 -> 9 -> 8 -> NULL
```

**Output**:

```plaintext
8 -> 9 -> 10 -> 7 -> 2 -> NULL
```

**Explanation**:

![Example 2](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700005/Web/Other/blobid1_1736947674.png)

---

### Example 3

**Input**:

```plaintext
n = 1
head = 2 -> NULL
```

**Output**:

```plaintext
2 -> NULL
```

**Explanation**:

![Example 3](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/700005/Web/Other/blobid2_1736947674.png)

---

## 💡 Approach

### 1. Brute Force

#### Steps

1. Use a **stack** to reverse the linked list.
   - Traverse the list and push each node onto the stack.
   - Traverse the stack to rebuild the reversed list.

#### Fallbacks in Brute Force

- **Extra Space**: Storing all nodes in the stack requires \( O(n) \) space.
- **Inefficient**: Requires traversing the list multiple times.

---

### 2. Optimized Approach

#### Key Idea

- Reverse the list **in place** using pointers:
  - Maintain three pointers: `prev`, `curr`, and `next`.
  - Update the `next` pointer of the current node to point to the previous node.

#### Steps

1. Initialize `prev` to `null` and `curr` to the head of the list.
2. Traverse the list:
   - Temporarily store the `next` node.
   - Reverse the `next` pointer of the `curr` node.
   - Move `prev` to `curr` and `curr` to `next`.
3. Return `prev` as the new head.

---

## ⏱️ Time & Space Complexity

### Brute Force

- **Time Complexity**: \( O(n) \)
- **Space Complexity**: \( O(n) \)

### Optimized Approach

- **Time Complexity**: \( O(n) \)
- **Space Complexity**: \( O(1) \)

---

## 🖥️ Solution

### Java Implementation

```java
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next; // Temporarily store the next node
            curr.next = prev;      // Reverse the link
            prev = curr;           // Move prev forward
            curr = next;           // Move curr forward
        }

        return prev; // New head of the reversed list
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
Enter the number of nodes: 4
Enter the elements of the linked list:
1 2 3 4
```

### Execution Steps:

1. **Initial List**:

   ```plaintext
   1 -> 2 -> 3 -> 4 -> NULL
   ```

2. **Reversing Process**:

   - \( $\text{prev}$ = $\text{null}$, $\text{curr}$ = 1, $\text{next}$ = 2 \): Reverse \( 1 $\to$ $\text{NULL}$\).
   - \( $\text{prev}$ = 1, $\text{curr}$ = 2, $\text{next}$ = 3 \): Reverse \( 2 $\to$ 1 \).
   - Continue until \( $\text{curr}$ = $\text{null}$ \).

3. **Reversed List**:

   ```plaintext
   4 -> 3 -> 2 -> 1 -> NULL
   ```

4. **Output**:

```plaintext
Reversed Linked List: 4 -> 3 -> 2 -> 1 -> NULL
```

---

## ✨ Why Optimized Approach Works Better

- **Intuition**: Directly modifies the pointers instead of using auxiliary space like stacks or arrays.
- **Performance**: Scales linearly with the size of the list without additional memory overhead.

**Happy Coding!** 🚀
