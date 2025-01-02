# 🌟 Subarrays with Sum \( $K$ \)

---

## 💡 Problem Statement

Given an unsorted array of integers `arr[]`, find the **number of continuous subarrays** whose sum is exactly equal to a given number \( $k$ \).

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{arr.size()}$ $\leq$ $10^5$ \)
- \( $-10^3$ $\leq$ $\text{arr[i]}$ $\leq$ $10^3$ \)
- \( $-10^7$ $\leq$ k $\leq$ $10^7$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public int countSubarrays(int arr[], int k);
}
```

### Parameters

- **`arr[]`**: An integer array.
- **`k`**: The target sum.

### Returns

- An integer representing the number of continuous subarrays with a sum equal to \( k \).

---

## 📥 Input Format

1. An integer \($n$ \), the size of the array.
2. An array \( $arr[]$ \) of \( n \) integers.
3. An integer \( $k$ \), the target sum.

---

## 📤 Output Format

- An integer representing the count of subarrays whose sum equals \( k \).

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [10, 2, -2, -20, 10], k = -10
```

**Output**:

```plaintext
3
```

**Explanation**:

- Subarrays: \( $\text{arr[0...3]}$, $\text{arr[1...4]}$, $\text{arr[3...4]}$ \) have sum equal to \( $-10$ \).

---

### Example 2

**Input**:

```plaintext
arr = [9, 4, 20, 3, 10, 5], k = 33
```

**Output**:

```plaintext
2
```

**Explanation**:

- Subarrays: \( $\text{arr[0...2]}$, $\text{arr[2...4]}$ \) have sum equal to \( 33 \).

---

### Example 3

**Input**:

```plaintext
arr = [1, 3, 5], k = 0
```

**Output**:

```plaintext
0
```

**Explanation**:

- No subarray has a sum of \( 0 \).

---

## 💡 Approach

### Optimized Prefix Sum with HashMap

Instead of brute-forcing all subarrays (\( $O(n^2)$ \)), we use the **prefix sum technique** with a **HashMap** for efficient lookup.

### Key Observations

1. **Prefix Sum**:

   - The sum of elements from index \( 0 \) to \( i \) is stored as `prefixSum`.
   - The sum of a subarray \( $\text{arr[l...r]}$ \) is given by:  
     \[
     $\text{subarraySum}$ = $\text{prefixSum}[r]$ - $\text{prefixSum}[l-1]$
     \]

2. **Transform Problem**:

   - If \( $\text{prefixSum}[i] - k$ \) exists in the HashMap, it implies there is a subarray ending at \( i \) with sum \( k \).

3. **HashMap Storage**:
   - Key: `prefixSum`.
   - Value: Count of how many times this `prefixSum` has occurred so far.

---

### Algorithm

1. Initialize a HashMap `map` to store prefix sums and their frequencies.
2. Iterate through the array while maintaining a running `prefixSum`.
   - If `prefixSum == k`, increment the count.
   - If `prefixSum - k` exists in the map, add its frequency to the count.
   - Update the frequency of `prefixSum` in the map.
3. Return the total count.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- \( O(n) \): Single pass through the array with \( O(1) \) HashMap operations.

### Space Complexity

- \( O(n) \): For storing prefix sums in the HashMap.

---

## 🖥️ Solution

### Java Implementation

```java

class Solution {
    public int countSubarrays(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, prefixSum = 0;

        map.put(0, 1);

        for (int num : arr) {
            prefixSum += num;

            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
10 2 -2 -20 10
-10
```

### Execution Steps:

1. **Initialize**:

   ```plaintext
   prefixSum = 0, count = 0, map = {0: 1}
   ```

2. **Iterate through the array**:

   - \( $\text{num} = 10$ \):

     ```plaintext
     prefixSum = 10, map = {0: 1, 10: 1}
     ```

   - \( $\text{num} = 2$ \):

     ```plaintext
     prefixSum = 12, map = {0: 1, 10: 1, 12: 1}
     ```

   - \( $\text{num} = -2$ \):

     ```plaintext
     prefixSum = 10, map = {0: 1, 10: 2, 12: 1}
     ```

   - \( $\text{num} = -20$ \):

     ```plaintext
     prefixSum = -10, count = 1, map = {0: 1, 10: 2, 12: 1, -10: 1}
     ```

   - \( $\text{num} = 10$ \):
     ```plaintext
     prefixSum = 0, count = 3, map = {0: 2, 10: 2, 12: 1, -10: 1}
     ```

3. **Output**:

```plaintext
Number of subarrays with sum -10: 3
```

---

## ✨ Key Takeaways

- **Prefix Sum with HashMap** reduces complexity to \( O(n) \).
- Works efficiently with negative numbers and large arrays.
- Handles edge cases like empty subarrays and overlapping subarrays seamlessly.

**Happy Coding!** 🚀
