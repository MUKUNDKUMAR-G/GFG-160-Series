# 🌟 Count Subarrays with Given XOR

---

## 💡 Problem Statement

You are given an array of integers `arr[]` and a number \( $k$ \). The task is to count the number of **subarrays** whose XOR of elements equals \( k \).

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{arr.size()}$ $\leq$ $10^5$ \)
- \( 0 $\leq$ $\text{arr[i]}$ $\leq$ $10^5$ \)
- \( 0 $\leq$ k $\leq$ 10^5 \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public long subarrayXor(int arr[], int k);
}
```

### Parameters

- **`arr[]`**: An integer array.
- **`k`**: The target XOR value.

### Returns

- A long integer representing the count of subarrays whose XOR equals \( k \).

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. An array \( arr[] \) of \( n \) integers.
3. An integer \( k \), the target XOR value.

---

## 📤 Output Format

- An integer representing the count of subarrays with XOR \( k \).

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [4, 2, 2, 6, 4], k = 6
```

**Output**:

```plaintext
4
```

**Explanation**:

- Subarrays: \( [4, 2], [2, 2, 6], [6], [4, 2, 2, 6, 4] \).

---

### Example 2

**Input**:

```plaintext
arr = [5, 6, 7, 8, 9], k = 5
```

**Output**:

```plaintext
2
```

**Explanation**:

- Subarrays: \( [5], [5, 6, 7, 8, 9] \).

---

### Example 3

**Input**:

```plaintext
arr = [1, 1, 1, 1], k = 0
```

**Output**:

```plaintext
4
```

**Explanation**:

- Subarrays: \( [1, 1], [1, 1], [1, 1], [1, 1, 1, 1] \).

---

## 💡 Approach

### Optimized Prefix XOR with HashMap

#### Key Observations

1. **Prefix XOR**:

   - Let \( $\text{prefixXOR}[i]$ \) be the XOR of elements from index \( 0 \) to \( i \).
   - The XOR of subarray \( $\text{arr[l...r]}$ \) is:  
     \[
     $\text{subarrayXOR}$ = $\text{prefixXOR}[r]$ $\oplus$ $\text{prefixXOR}[l-1]$
     \]

2. **Transform Problem**:

   - If \( $\text{prefixXOR}[r]$ $\oplus$ k = $\text{prefixXOR}[l-1]$ \), the subarray \( $\text{arr[l...r]}$ \) has XOR \( k \).
   - Rearrange:  
     \[
     $\text{prefixXOR}[l-1]$ = $\text{prefixXOR}[r]$ $\oplus$ k
     \]

3. **HashMap Storage**:
   - Use a HashMap to store the frequency of each prefix XOR.
   - For each \( $\text{prefixXOR}[r]$ \), check if \( $\text{prefixXOR}[r]$ $\oplus$ k \) exists in the map.

---

### Algorithm

1. **Initialize Variables**:

   - A HashMap to store frequencies of prefix XOR.
   - A variable `count` to store the number of subarrays with XOR \( k \).

2. **Iterate Through the Array**:
   - Compute the running prefix XOR.
   - Check if prefix XOR equals \( k \). If yes, increment the count.
   - Check if \( $\text{prefixXOR}$ $\oplus$ k \) exists in the map. If yes, add its frequency to the count.
   - Update the frequency of the current prefix XOR in the map.

---

### ⏱️ Time & Space Complexity

### Time Complexity

- \( O(n) \): Single pass through the array with \( O(1) \) HashMap operations.

### Space Complexity

- \( O(n) \): For storing prefix XOR values in the HashMap.

---

## 🖥️ Solution

### Java Implementation

```java
import java.util.*;

class Solution {
    public long subarrayXor(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixXor = 0;
        long count = 0;

        map.put(0, 1);
        for (int num : arr) {
            prefixXor ^= num;

            int requiredXor = prefixXor ^ k;
            if (map.containsKey(requiredXor)) {
                count += map.get(requiredXor);
            }
            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }

        return count;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
4 2 2 6 4
6
```

### Execution Steps:

1. **Initialize**:

   ```plaintext
   prefixXor = 0, count = 0, map = {0: 1}
   ```

2. **Iterate through the array**:

   - \( $\text{num}$ = 4 \):

     ```plaintext
     prefixXor = 4, map = {0: 1, 4: 1}
     ```

   - \( $\text{num}$ = 2 \):

     ```plaintext
     prefixXor = 6, count = 1, map = {0: 1, 4: 1, 6: 1}
     ```

   - \( $\text{num}$ = 2 \):

     ```plaintext
     prefixXor = 4, count = 2, map = {0: 1, 4: 2, 6: 1}
     ```

   - \( $\text{num}$ = 6 \):

     ```plaintext
     prefixXor = 2, count = 3, map = {0: 1, 4: 2, 6: 1, 2: 1}
     ```

   - \( $\text{num}$ = 4 \):
     ```plaintext
     prefixXor = 6, count = 4, map = {0: 1, 4: 2, 6: 2, 2: 1}
     ```

3. **Output**:

```plaintext
Number of subarrays with XOR 6: 4
```

---

## ✨ Key Takeaways

- **HashMap Optimization** reduces time complexity to \( O(n) \).
- Works efficiently for large inputs with diverse XOR values.

**Happy Coding!** 🚀
