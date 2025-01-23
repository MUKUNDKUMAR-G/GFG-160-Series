# Clone a Linked List with Random Pointer

---

## 💡 Problem Statement

You are given a **special linked list**, where each node contains:

1. A `next` pointer pointing to the next node in the list.
2. A `random` pointer pointing to a random node in the list, or `NULL`.

Your task is to create a **deep copy** of the given linked list, such that:

- The structure of the new list matches the original list.
- The new list is independent of the original list, i.e., any changes made to the new list should not affect the original list.
- Both the `next` and `random` pointers of the new nodes must point to new nodes in the copied list.

---

## 🔒 Constraints

- \( 1 $\leq$ n $\leq$ 100 \) (number of nodes in the list).
- \( 0 $\leq$ $\text{node->data}$ $\leq$ 1000 \).

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public Node cloneLinkedList(Node head);
}
```

### Parameters

- **`head`**: The head of the original linked list.

### Returns

- The head of the **deep copied linked list**.

---

## 📥 Input Format

1. The head node of a linked list, where each node contains:
   - An integer `data`.
   - A pointer `next` to the next node.
   - A pointer `random` to any node in the list or `NULL`.

---

## 📤 Output Format

- The head of the newly created deep copy of the linked list.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
Original List: [[1, 3], [3, 3], [5, NULL], [9, 3]]
```

**Output**:

```plaintext
Cloned List: [[1, 3], [3, 3], [5, NULL], [9, 3]]
```

**Explanation**:  
The structure and values of the new list are identical to the original list, but it is a separate copy with no shared references.

---

### Example 2

**Input**:

```plaintext
Original List: [[7, NULL], [7, NULL]]
```

**Output**:

```plaintext
Cloned List: [[7, NULL], [7, NULL]]
```

---

## 💡 Approach

### 1️⃣ Brute Force

#### Steps

1. Create a mapping between the original nodes and the cloned nodes using a `HashMap`.
2. Iterate through the original list and create a deep copy of each node. Store the mapping in the hash map.
3. Iterate through the original list again and use the hash map to set the `next` and `random` pointers of the copied nodes.

#### Fallbacks in the Brute Force Approach

- **Space Complexity**: The `HashMap` requires \( O(n) \) extra space, where \( n \) is the number of nodes.
- **Time Complexity**: Traversing the list twice takes \( O(n) \) time.

---

### 2️⃣ Optimized Approach

To achieve \( O(n) \) time complexity and \( O(1) \) space complexity:

#### Steps

1. **Interleave Cloned Nodes in the Original List**

   - Create a copy of each node and insert it immediately after the corresponding original node.
   - For example, \( A $\to$ B $\to$ C \) becomes \( A $\to$ A' $\to$ B $\to$ B' $\to$ C $\to$ C' \).

2. **Set `random` Pointers for Cloned Nodes**

   - Use the interleaved structure to set the `random` pointers for the cloned nodes based on the original list.

3. **Separate the Original and Cloned Lists**
   - Detach the cloned nodes to form the deep copy list, leaving the original list intact.

#### Why This Approach?

- **Space Complexity**: This approach uses no extra space apart from the pointers, making it \( O(1) \).
- **Time Complexity**: Traversing the list three times still takes \( O(n) \).

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
    Node random;

    Node(int x) {
        data = x;
        next = null;
        random = null;
    }
}

class Solution {
    public Node cloneLinkedList(Node head) {
        if (head == null) return null;

        // Step 1: Interleave cloned nodes
        Node current = head;
        while (current != null) {
            Node clone = new Node(current.data);
            clone.next = current.next;
            current.next = clone;
            current = clone.next;
        }

        // Step 2: Set random pointers for the cloned nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Step 3: Separate the original and cloned lists
        Node original = head;
        Node cloneHead = head.next;
        Node cloneCurrent = cloneHead;

        while (original != null) {
            original.next = original.next.next;
            if (cloneCurrent.next != null) {
                cloneCurrent.next = cloneCurrent.next.next;
            }
            original = original.next;
            cloneCurrent = cloneCurrent.next;
        }

        return cloneHead;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
Original List:
Node 1 -> Node 2 -> Node 3 -> Node 4
Node 1.random -> Node 3
Node 2.random -> Node 1
Node 3.random -> Node 4
Node 4.random -> Node 2
```

### Execution Steps

1. **Interleave Cloned Nodes**:

   ```plaintext
   Node 1 -> Node 1' -> Node 2 -> Node 2' -> Node 3 -> Node 3' -> Node 4 -> Node 4'
   ```

2. **Set `random` Pointers for Cloned Nodes**:

   ```plaintext
   Node 1'.random -> Node 3'
   Node 2'.random -> Node 1'
   Node 3'.random -> Node 4'
   Node 4'.random -> Node 2'
   ```

3. **Separate the Lists**:
   - **Original**: \( 1 \to 2 \to 3 \to 4 \).
   - **Cloned**: \( 1' \to 2' \to 3' \to 4' \).

### Output:

```plaintext
Cloned List:
Node 1' -> Node 2' -> Node 3' -> Node 4'
Node 1'.random -> Node 3'
Node 2'.random -> Node 1'
Node 3'.random -> Node 4'
Node 4'.random -> Node 2'
```

---

**Happy Coding!** 🚀
