# 🌟 Product Array Puzzle

---

## 💡 Problem Statement

You are given an array `arr[]`. Construct a **product array** `res[]` such that each element in `res[i]` is the product of all elements in `arr[]` except `arr[i]`.

**Key Points**:

- You cannot use division to solve the problem.
- Each element in `res[]` must lie within the 32-bit integer range.

---

## 🔒 Constraints

- \( 2 $\leq$ $\text{arr.size()}$ $\leq$ $10^5$ \)
- \( $-100$ $\leq$ $\text{arr[i]}$ $\leq$ 100 \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public static int[] productExceptSelf(int arr[]);
}
```

### Parameters

- **`arr[]`**: An array of integers containing \( n \) elements.

### Returns

- An array `res[]` where each \( $\text{res[i]}$ \) is the product of all elements in `arr[]` except `arr[i]`.

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. An array \( arr[] \) of \( n \) integers.

---

## 📤 Output Format

- An array \( res[] \) of size \( n \).

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [10, 3, 5, 6, 2]
```

**Output**:

```plaintext
[180, 600, 360, 300, 900]
```

**Explanation**:

- \( $\text{res[0]}$ = 3 $\times$ 5 $\times$ 6 $\times$ 2 = 180 \).
- \( $\text{res[1]}$ = 10 $\times$ 5 $\times$ 6 $\times$ 2 = 600 \).
- \( $\text{res[2]}$ = 10 $\times$ 3 $\times$ 6 $\times$ 2 = 360 \).

---

### Example 2

**Input**:

```plaintext
arr = [12, 0]
```

**Output**:

```plaintext
[0, 12]
```

**Explanation**:

- \( $\text{res[0]}$ = 0 $\times$ 12 = 0 \).
- \( $\text{res[1]}$ = 12 $\times$ 1 = 12 \).

---

## 💡 Approach

### 1. Brute Force

1. For every index \( i \):
   - Calculate the product of all elements except \( $\text{arr[i]}$ \).
2. Use a nested loop:
   - Outer loop iterates over all elements.
   - Inner loop calculates the product for the current index \( i \).

#### Fallbacks in Brute Force

- **Time Complexity**: \( $O(n^2)$ \), as the nested loops make this inefficient for large arrays.
- **Space Complexity**: \( O(1) \).
- **Why It Fails**: Performance degrades for large \( n \).

---

### 2. Optimized Approach

**Key Idea**: Use prefix and suffix products to calculate the result in \( O(n) \).

1. **Prefix Product Array**:

   - Calculate cumulative product from the start of the array up to \( i-1 \).

2. **Suffix Product Array**:

   - Calculate cumulative product from the end of the array up to \( i+1 \).

3. **Combine**:
   - For each index \( i \), \( $\text{res[i]}$ = $\text{prefix[i]} $\times$ $\text{suffix[i]}$ \).

#### Steps:

1. Create an array `res[]` to store the results.
2. Traverse the array twice:
   - First pass: Use a running product to populate the prefix product in `res[]`.
   - Second pass: Use a running product from the end to multiply suffix products into `res[]`.

---

## ⏱️ Time & Space Complexity

### Optimized Approach

- **Time Complexity**: \( O(n) \)
- **Space Complexity**: \( O(1) \) (if we reuse `res[]` for prefix and suffix calculations).

---

## 🖥️ Solution

### Java Implementation

```java
class Solution {
    public static int[] productExceptSelf(int[] arr) {
        int n = arr.length;

        int[] res = new int[n];

        // Step 1: Calculate prefix products
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix *= arr[i];
        }

        // Step 2: Calculate suffix products and combine with prefix
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= arr[i];
        }

        return res;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
Enter the size of the array: 5
Enter the elements of the array:
10 3 5 6 2
```

### Execution Steps:

1. **Initial Variables**:

   ```plaintext
   arr = [10, 3, 5, 6, 2]
   res = [1, 1, 1, 1, 1]
   ```

2. **First Pass (Prefix Products)**:

   ```plaintext
   i = 0: prefix = 1 → res[0] = 1, prefix *= 10 = 10
   i = 1: prefix = 10 → res[1] = 10, prefix *= 3 = 30
   i = 2: prefix = 30 → res[2] = 30, prefix *= 5 = 150
   i = 3: prefix = 150 → res[3] = 150, prefix *= 6 = 900
   i = 4: prefix = 900 → res[4] = 900, prefix *= 2 = 1800
   ```

   Result after prefix pass:

   ```plaintext
   res = [1, 10, 30, 150, 900]
   ```

3. **Second Pass (Suffix Products)**:

   ```plaintext
   i = 4: suffix = 1 → res[4] *= 1 = 900, suffix *= 2 = 2
   i = 3: suffix = 2 → res[3] *= 2 = 300, suffix *= 6 = 12
   i = 2: suffix = 12 → res[2] *= 12 = 360, suffix *= 5 = 60
   i = 1: suffix = 60 → res[1] *= 60 = 600, suffix *= 3 = 180
   i = 0: suffix = 180 → res[0] *= 180 = 180, suffix *= 10 = 1800
   ```

   Result after suffix pass:

   ```plaintext
   res = [180, 600, 360, 300, 900]
   ```

4. **Output**:
   ```plaintext
   Product array: 180 600 360 300 900
   ```

---

## ✨ Key Takeaways

- Efficient \( O(n) \) solution using prefix and suffix products.
- Avoids the pitfalls of division and handles edge cases like zeros gracefully.

**Happy Coding!** 🚀
