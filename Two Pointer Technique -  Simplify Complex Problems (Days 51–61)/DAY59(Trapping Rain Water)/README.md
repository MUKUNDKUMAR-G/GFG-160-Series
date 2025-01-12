# 🌧️ Trapping Rain Water

---

## 💡 Problem Statement

You are given an array `arr[]` where each element represents the height of a block. Compute how much water can be trapped between the blocks during the rainy season. The width of each block is 1 unit.

---

## 🔒 Constraints

- \( 1 < $\text{arr.size()}$ < $10^5$ \)
- \( 0 < $\text{arr[i]}$ < $10^3$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public int maxWater(int[] arr);
}
```

### Parameters

- **`arr[]`**: An array of integers representing block heights.

### Returns

- An integer representing the total amount of water trapped between the blocks.

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. An array \( arr[] \) of \( n \) integers.

---

## 📤 Output Format

- An integer representing the total amount of trapped water.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [3, 0, 1, 0, 4, 0, 2]
```

**Output**:

```plaintext
10
```

**Explanation**:  
Water trapped in each position:

- \( [0, 3, 2, 3, 0, 2, 0] \) → Total = \( 10 \).

---

### Example 2

**Input**:

```plaintext
arr = [3, 0, 2, 0, 4]
```

**Output**:

```plaintext
7
```

**Explanation**:  
Water trapped in each position:

- \( [0, 3, 1, 3, 0] \) → Total = \( 7 \).

---

### Example 3

**Input**:

```plaintext
arr = [1, 2, 3, 4]
```

**Output**:

```plaintext
0
```

**Explanation**:  
No water can be trapped.

---

## 💡 Approach

### Two-Pointer Approach

1. **Use Two Pointers**:

   - Initialize `left = 0` and `right = n - 1`.
   - Use variables `leftMax` and `rightMax` to store the maximum heights encountered so far from the left and right ends, respectively.

2. **Move the Pointers**:

   - If `arr[left] < arr[right]`:
     - If `arr[left] > leftMax`, update `leftMax`.
     - Else, add the difference `leftMax - arr[left]` to the total water.
     - Move the `left` pointer rightward.
   - Else:
     - If `arr[right] > rightMax`, update `rightMax`.
     - Else, add the difference `rightMax - arr[right]` to the total water.
     - Move the `right` pointer leftward.

3. **Edge Cases**:
   - If the array size is less than 3, return `0` (no water can be trapped).

---

## ⏱️ Time & Space Complexity

### Time Complexity

- \( O(n) \): The array is traversed once using the two-pointer technique.

### Space Complexity

- \( O(1) \): No additional space is used.

---

## 🖥️ Solution

### Java Implementation

```java
class Solution {
    public int maxWater(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left <= right) {
            if (arr[left] < arr[right]) {
                if (arr[left] > leftMax) {
                    leftMax = arr[left];
                } else {
                    totalWater += leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] > rightMax) {
                    rightMax = arr[right];
                } else {
                    totalWater += rightMax - arr[right];
                }
                right--;
            }
        }

        return totalWater;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
3 0 2 0 4
```

### Execution Steps:

1. **Initial Variables**:

   ```plaintext
   left = 0, right = 4, leftMax = 0, rightMax = 0, totalWater = 0
   ```

2. **Processing Each Step**:

   - \( $\text{left}$ = 0, $\text{right}$ = 4 \): Update `leftMax = 3`.
   - \( $\text{left}$ = 1, $\text{right}$ = 4 \): Add \( 3 \) to `totalWater`.
   - \( $\text{left}$ = 2, $\text{right}$ = 4 \): Add \( 1 \) to `totalWater`.
   - \( $\text{left}$ = 3, $\text{right}$ = 4 \): Add \( 3 \) to `totalWater`.
   - \( $\text{left}$ = 4, $\text{right}$ = 4 \): Update `rightMax = 4`.

3. **Final Result**:
   ```plaintext
   Total water trapped: 7
   ```

---

## ✨ Key Takeaways

- The **two-pointer approach** ensures \( O(n) \) time complexity while keeping the space usage minimal.
- Edge cases like small arrays or flat terrain are handled gracefully.

**Happy Coding!** 🚀
