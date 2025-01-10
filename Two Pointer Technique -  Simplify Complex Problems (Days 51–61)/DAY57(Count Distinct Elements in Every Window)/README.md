# 🌟 Count Distinct Elements in Every Window

---

## 💡 Problem Statement

Given an integer array `arr[]` and a number `k`, find the count of **distinct elements** in every window of size `k` in the array.

### Example Explanation

For each sliding window of size `k` in `arr[]`, count the number of unique elements in that window and return the counts as a list.

---

## 🔒 Constraints

- \( 1 $\leq$ k $\leq$ $\text{arr.size()}$ $\leq$ $10^5$ \)
- \( 1 $\leq$ $\text{arr[i]}$ $\leq$ $10^5$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k);
}
```

### Parameters

- **`arr[]`**: An integer array.
- **`k`**: An integer representing the size of the sliding window.

### Returns

- An `ArrayList<Integer>` containing the count of distinct elements for each window.

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. An array \( arr[] \) of \( n \) integers.
3. An integer \( k \), the size of the sliding window.

---

## 📤 Output Format

- A list of integers where each element represents the count of distinct elements in the corresponding window.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [1, 2, 1, 3, 4, 2, 3], k = 4
```

**Output**:

```plaintext
[3, 4, 4, 3]
```

**Explanation**:

- Window 1: \( [1, 2, 1, 3] \) → Distinct = 3.
- Window 2: \( [2, 1, 3, 4] \) → Distinct = 4.
- Window 3: \( [1, 3, 4, 2] \) → Distinct = 4.
- Window 4: \( [3, 4, 2, 3] \) → Distinct = 3.

---

### Example 2

**Input**:

```plaintext
arr = [4, 1, 1], k = 2
```

**Output**:

```plaintext
[2, 1]
```

**Explanation**:

- Window 1: \( [4, 1] \) → Distinct = 2.
- Window 2: \( [1, 1] \) → Distinct = 1.

---

### Example 3

**Input**:

```plaintext
arr = [1, 1, 1, 1, 1], k = 3
```

**Output**:

```plaintext
[1, 1, 1]
```

**Explanation**:  
All windows contain the same element, so the distinct count is 1 for each.

---

## 💡 Approach

### Optimized Sliding Window with HashMap

1. **Use a HashMap**:

   - Maintain a frequency map to track the occurrence of each element in the current window.

2. **Initialize the First Window**:

   - Process the first `k` elements and count distinct elements using the HashMap.

3. **Slide the Window**:

   - Remove the element that goes out of the window by decrementing its frequency in the HashMap.
   - If its frequency becomes zero, remove it from the HashMap.
   - Add the new element entering the window and update its frequency in the HashMap.

4. **Record Distinct Count**:

   - The size of the HashMap at each step gives the count of distinct elements.

5. **Edge Cases**:
   - \( k > $\text{arr.size()}$ \): Return an empty list.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- \( O(n) \): Each element is added and removed from the HashMap at most once.

### Space Complexity

- \( O(k) \): Space used by the HashMap for at most \( k \) distinct elements.

---

## 🖥️ Solution

### Java Implementation

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < k; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        result.add(freqMap.size());

        for (int i = k; i < arr.length; i++) {
            int outgoing = arr[i - k];
            freqMap.put(outgoing, freqMap.get(outgoing) - 1);
            if (freqMap.get(outgoing) == 0) {
                freqMap.remove(outgoing);
            }
            int incoming = arr[i];
            freqMap.put(incoming, freqMap.getOrDefault(incoming, 0) + 1);

            result.add(freqMap.size());
        }

        return result;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
1 2 1 3 4 2 3
 4
```

### Execution Steps:

1. **First Window**: \( [1, 2, 1, 3] \) → Distinct = 3.
2. **Second Window**: \( [2, 1, 3, 4] \) → Distinct = 4.
3. **Third Window**: \( [1, 3, 4, 2] \) → Distinct = 4.
4. **Fourth Window**: \( [3, 4, 2, 3] \) → Distinct = 3.

### Output:

```plaintext
Distinct counts in each window: [3, 4, 4, 3]
```

---

## ✨ Key Takeaways

- **HashMap** is used for efficient tracking of frequencies within the window.
- Sliding window ensures \( O(n) \) time complexity, making the solution scalable for large inputs.

**Happy Coding!** 🚀
