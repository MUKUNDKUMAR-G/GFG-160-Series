# Add Two Numbers Represented by Linked Lists

---

## 💡 Problem Statement

You are given the heads of two singly linked lists, `num1` and `num2`, representing two non-negative integers. Each linked list contains the digits of the number in reverse order. Your task is to return the head of a linked list representing the sum of these two numbers.

The result should not contain leading zeros.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{size of both linked lists}$ $\leq$ $10^6$ \)
- \( 0 $\leq$ $\text{elements of both linked lists}$ $\leq$ 9 \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    static Node addTwoLists(Node num1, Node num2);
}
```

### Parameters

- **`num1`**: Head of the first linked list representing the first number.
- **`num2`**: Head of the second linked list representing the second number.

### Returns

- The head of the resulting linked list representing the sum.

---

## 📥 Input Format

1. A reference to the head of the first linked list.
2. A reference to the head of the second linked list.

---

## 📤 Output Format

- The head of the resulting linked list, representing the sum.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
num1 = 4 -> 5
num2 = 3 -> 4 -> 5
```

**Output**:

```plaintext
3 -> 9 -> 0
```

**Explanation**:

- Numbers: \( num1 = 45 \), \( num2 = 345 \).
- Sum = \( 45 + 345 = 390 \).

---

### Example 2

**Input**:

```plaintext
num1 = 0 -> 0 -> 6 -> 3
num2 = 0 -> 7
```

**Output**:

```plaintext
7 -> 0
```

**Explanation**:

- Numbers: \( num1 = 63 \), \( num2 = 7 \).
- Sum = \( 63 + 7 = 70 \).

---

## 💡 Approach

### Intuition

To add numbers represented as linked lists in reverse order:

1. Reverse the linked lists to process the numbers from the least significant digit.
2. Perform digit-wise addition, tracking carry-over.
3. Reverse the result back to restore the correct order.
4. Remove leading zeros from the result, if any.

---

### Steps

1. **Reverse the Input Lists**:

   - Reverse both `num1` and `num2` to handle the least significant digit first.

2. **Add the Numbers**:

   - Use a loop to add corresponding digits from `num1` and `num2`, including the carry.
   - Create a new node for the sum of each digit.

3. **Handle Remaining Carry**:

   - If a carry is left after processing all nodes, add it as a new node.

4. **Reverse the Result**:

   - Reverse the resulting list to restore the correct order.

5. **Remove Leading Zeros**:
   - Traverse the list and skip leading zeros, except when the result has only one node.

---

## ⏱️ Time & Space Complexity

- **Time Complexity**: \( O(n + m) \), where \( n \) and \( m \) are the lengths of `num1` and `num2`. Each node is processed once.
- **Space Complexity**: \( O(1) \), as no additional data structures are used beyond pointers.

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
    public static Node addTwoLists(Node num1, Node num2) {
        // Reverse both linked lists
        num1 = reverse(num1);
        num2 = reverse(num2);

        Node result = null; // Head of the result list
        Node temp = null;   // Temporary pointer for appending nodes
        int carry = 0;      // Variable to store carry
        int sum = 0;        // Variable to store digit sum

        // Traverse both lists
        while (num1 != null || num2 != null || carry != 0) {
            sum = carry;

            // Add digit from num1
            if (num1 != null) {
                sum += num1.data;
                num1 = num1.next;
            }

            // Add digit from num2
            if (num2 != null) {
                sum += num2.data;
                num2 = num2.next;
            }

            // Calculate carry and current digit
            carry = sum / 10;
            sum = sum % 10;

            // Create a new node for the current digit
            Node newNode = new Node(sum);
            if (result == null) {
                result = newNode;
            } else {
                temp.next = newNode;
            }
            temp = newNode;
        }

        // Add remaining carry
        if (carry > 0) {
            temp.next = new Node(carry);
        }

        // Reverse the result list to correct order
        result = reverse(result);

        // Remove leading zeros
        while (result != null && result.data == 0 && result.next != null) {
            result = result.next;
        }

        return result;
    }

    // Helper method to reverse a linked list
    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
num1 = 4 -> 5
num2 = 3 -> 4 -> 5
```

### Execution Steps:

1. **Reverse Input Lists**:

   - \( num1 = 5 -> 4 \)
   - \( num2 = 5 -> 4 -> 3 \).

2. **Add Digits**:

   - Add \( 5 + 5 = 10 \), carry \( 1 \), result \( 0 \).
   - Add \( 4 + 4 + 1 = 9 \), carry \( 0 \), result \( 9 \).
   - Add \( 3 + 0 + 0 = 3 \), carry \( 0 \), result \( 3 \).

3. **Result Before Reversing**:

   ```plaintext
   0 -> 9 -> 3
   ```

4. **Reverse Result**:

   ```plaintext
   3 -> 9 -> 0
   ```

5. **Remove Leading Zeros**:
   - No leading zeros to remove.

### Output:

```plaintext
3 -> 9 -> 0
```

---

**Happy Coding!** 🚀
