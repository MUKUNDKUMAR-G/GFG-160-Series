# 🐄 Aggressive Cows 🐄

---

## 💡 Problem Statement

You are given an array `stalls[]` containing the **positions of stalls** (unique integers) and an integer \( k \), which denotes the number of aggressive cows.

Your task is to assign stalls to \( k \) cows such that the **minimum distance** between any two cows is as **large as possible**.

---

## 🔒 Constraints

- \( 2 $\leq$ $\text{stalls.size()}$ $\leq 10^6$ \) 🧮
- \( 0 $\leq$ $\text{stalls}[i]$ $\leq 10^8$ \) 🔢
- \( 1 $\leq k$ $\leq$ $\text{stalls.size()}$ \) 🐄

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public static int aggressiveCows(int[] stalls, int k);
}
```

### Parameters

- **`stalls[]`**: An array of integers denoting the positions of stalls.
- **`k`**: The number of cows to place in the stalls.

### Returns

- An integer representing the **maximum possible minimum distance** between any two cows.

---

## 📥 Input Format

1. An array of integers `stalls[]` representing stall positions.
2. An integer `k` representing the number of cows.

---

## 📤 Output Format

- An integer representing the largest minimum distance possible between any two cows.

---

## 🎯 Examples

### Example 1

**Input**:  
`stalls = [1, 2, 4, 8, 9], k = 3`

**Output**:  
`3`

**Explanation**:

- Place the cows at `stalls[0] = 1`, `stalls[2] = 4`, and `stalls[3] = 8`.
- The minimum distance between the cows is `3`.

---

### Example 2

**Input**:  
`stalls = [10, 1, 2, 7, 5], k = 3`

**Output**:  
`4`

**Explanation**:

- Place the cows at `stalls[0] = 1`, `stalls[1] = 2`, and `stalls[4] = 10`.
- The minimum distance between the cows is `4`.

---

### Example 3

**Input**:  
`stalls = [2, 12, 11, 3, 26, 7], k = 5`

**Output**:  
`1`

**Explanation**:

- Each cow is placed in its own stall as there are exactly \( k \) stalls.
- The minimum distance between the cows is `1`.

---

## 💡 Approach

This problem can be solved using **Binary Search on Answer** combined with a **greedy approach** to check the feasibility of a given distance.

---

### Steps:

1. **Sort the Stalls**:

   - Sort the `stalls[]` array in ascending order.

2. **Binary Search on Minimum Distance**:

   - Initialize `low = 1` (smallest possible distance).
   - Initialize `high = stalls[n-1] - stalls[0]` (maximum possible distance).

3. **Feasibility Function**:

   - Create a helper function `canPlaceCows` that checks if it’s possible to place \( k \) cows with a minimum distance `mid` between them.
   - Start placing cows from the first stall and count how many cows can be placed while maintaining the minimum distance.

4. **Binary Search Logic**:

   - While `low <= high`:
     - Compute `mid = (low + high) / 2`.
     - If `canPlaceCows(mid)` returns true:
       - Update `result = mid` and search for a larger distance by setting `low = mid + 1`.
     - Otherwise, reduce the distance by setting `high = mid - 1`.

5. **Return the Result**:
   - The result will store the largest minimum distance possible.

---

## ⏱️ Time Complexity

- **Sorting**: \( $O(n \log n)$ \), where \( n \) is the size of the stalls array.
- **Binary Search**: \( $O(\log D)$ \), where \( D \) is the range of distances (max - min).
- **Feasibility Check**: \( O(n) \) for each mid-distance.

**Overall Complexity**: \( $O(n \log n + n \log D)$ \)

### Space Complexity:

- \( O(1) \): No additional space is used.

---

## 🖥️ Solution

### Java Implementation

```java

class Solution {

    // Helper function to check if we can place cows with minimum distance 'dist'
    private static boolean canPlaceCows(int[] stalls, int k, int dist) {
        int cowsPlaced = 1; // Place the first cow in the first stall
        int lastPosition = stalls[0]; // Last placed cow position

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= dist) {
                cowsPlaced++;
                lastPosition = stalls[i]; // Update last position
            }

            if (cowsPlaced >= k) { // All cows placed successfully
                return true;
            }
        }

        return false;
    }

    // Function to find the maximum minimum distance
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // Step 1: Sort the stalls

        int low = 1; // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, k, mid)) {
                result = mid; // Update the result
                low = mid + 1; // Try for a larger distance
            } else {
                high = mid - 1; // Try for a smaller distance
            }
        }

        return result;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
1 2 4 8 9
3
```

### Steps:

1. **Sorting**:  
   Sorted `stalls = [1, 2, 4, 8, 9]`.

2. **Binary Search**:

   - Start with `low = 1` and `high = 8`.
   - Test mid-distances: `4`, `2`, `3`.
   - Check feasibility for each distance using the `canPlaceCows` function.

3. **Output**:  
   The largest minimum distance is `3`.

---

### Output:

```plaintext
3
```

---

## ✨ Key Takeaways

- **Binary Search on Answer** ensures efficient search for the largest minimum distance.
- **Greedy Feasibility Check** efficiently places cows in stalls.
- Handles large inputs with optimal performance.

**Happy Coding!** 💻🚀
