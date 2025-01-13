# 🌊 Container With Most Water

---

## 💡 Problem Statement

You are given an array `arr[]` of non-negative integers, where each element `arr[i]` represents the height of vertical lines. The task is to find the maximum amount of water that can be contained between any two lines, together with the x-axis.

### Key Points:

- Water can only be trapped between two vertical lines, where the height is determined by the shorter line between the two.
- The width of the container is the distance between the two lines.
- The water trapped is the area formed by the height of the shorter line and the width between the lines.

Note: In the case of a single vertical line, it will not be able to hold water.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{arr.size()}$ $\leq$ $10^5$ \)
- \( 1 $\leq$ $\text{arr[i]}$ $\leq$ $10^4$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public int maxWater(int[] arr);
}
```

### Parameters

- **arr[]**: An array of integers representing the heights of vertical lines.

### Returns

- An integer representing the maximum amount of water that can be contained.

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. An array \( arr[] \) of \( n \) integers representing the heights of vertical lines.

---

## 📤 Output Format

- An integer representing the maximum amount of water that can be contained between any two lines.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [1, 5, 4, 3]
```

**Output**:

```plaintext
6
```

**Explanation**:

- The maximum water is trapped between the lines at indices 1 and 3 with a width of 2. The height of the container is `min(5, 3) = 3`.
- Area = \( 3 $\times$ 2 = 6 \).

---

### Example 2

**Input**:

```plaintext
arr = [3, 1, 2, 4, 5]
```

**Output**:

```plaintext
12
```

**Explanation**:

- The maximum water is trapped between the lines at indices 0 and 4 with a width of 4. The height of the container is `min(5, 3) = 3`.
- Area = \( 3 $\times$ 4 = 12 \).

---

### Example 3

**Input**:

```plaintext
arr = [2, 1, 8, 6, 4, 6, 5, 5]
```

**Output**:

```plaintext
25
```

**Explanation**:

- The maximum water is trapped between the lines at indices 2 and 7 with a width of 5. The height of the container is `min(8, 5) = 5`.
- Area = \( 5 $\times$ 5 = 25 \).

---

## 💡 Approach

### Two-Pointer Approach

1. **Two Pointers Initialization**:

   - Start with two pointers: `left` at the beginning (`0`) and `right` at the end (`n-1`) of the array.
   - Initialize a variable `ans` to store the maximum water trapped.

2. **Calculate Water**:

   - Calculate the water trapped at each step by computing the area between the lines at the `left` and `right` indices. The area is determined by the formula:  
     \( $\text{Area}$ = $\min(\text{height}[left]$, $\text{height}[right])$ $\times$ ($\text{right}$ - $\text{left}$) \).
   - Update the `ans` with the maximum of the current `ans` and the calculated area.

3. **Move Pointers**:

   - Move the pointer pointing to the shorter line towards the other pointer to try and find a better combination.

4. **End Condition**:
   - Repeat the process until `left` is no longer less than `right`.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- \( O(n) \): We iterate through the array once, adjusting the `left` and `right` pointers.

### Space Complexity

- \( O(1) \): We use only a constant amount of extra space.

---

## 🖥️ Solution

### Java Implementation

```java
class Solution {
    public int maxWater(int[] arr) {
        int n = arr.length;

        int left = 0;
        int right = n - 1;

        int ans = 0;

        while (left < right) {
            int tempWater = Math.min(arr[left], arr[right]) * (right - left);

            ans = Math.max(ans, tempWater);

            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
3 1 2 4 5
```

### Execution Steps:

1. **Initial Variables**:

   ```plaintext
   left = 0, right = 4, ans = 0
   ```

2. **Processing Each Step**:

   - \( $\text{left}$ = 0, $\text{right}$ = 4 \):  
     \( $\text{tempWater}$ = $\min(3, 5)$ $\times$ (4 - 0) = 3 $\times$ 4 = 12 \).  
     `ans = 12`.
     Move `left` pointer to `1`.

   - \( $\text{left}$ = 1, $\text{right}$ = 4 \):  
     \( $\text{tempWater}$ = $\min(1, 5)$ $\times$ (4 - 1) = 1 $\times$ 3 = 3 \).  
     `ans = 12`.
     Move `left` pointer to `2`.

   - \( $\text{left}$ = 2, $\text{right}$ = 4 \):  
     \( $\text{tempWater}$ = $\min(2, 5)$ $\times (4 - 2)$ = 2 $\times$ 2 = 4 \).  
     `ans = 12`.
     Move `left` pointer to `3`.

   - \( $\text{left}$ = 3, $\text{right}$ = 4 \):  
     \( $\text{tempWater}$ = $\min(4, 5)$ $\times$ (4 - 3) = 4 $\times$ 1 = 4 \).  
     `ans = 12`.
     Move `left` pointer to `4`.

3. **Final Result**:
   ```plaintext
   Maximum water that can be contained: 12
   ```

---

## ✨ Key Takeaways

- The two-pointer technique ensures that we check all possible containers with a time complexity of \( O(n) \), making it efficient for large inputs.
- The approach is simple and avoids the need for nested loops, which would be less efficient.

**Happy Coding!** 🚀
