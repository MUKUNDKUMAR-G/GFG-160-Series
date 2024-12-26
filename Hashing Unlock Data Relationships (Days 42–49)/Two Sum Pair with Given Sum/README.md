# 💡 Two Sum - Pair with Given Sum

---

## 📝 Problem Statement

You are given an array `arr[]` of positive integers and an integer `target`. Your task is to determine whether there exist two distinct indices \( i \) and \( j \) such that \( $\text{arr[i]}$ + $\text{arr[j]}$ = $\text{target}$ \).

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{arr.size}$ $\leq$ 10^5 \)
- \( 1 $\leq$ $\text{arr[i]}$ $\leq 10^5$ \)
- \( 1 $\leq$ $\text{target}$ $\leq$ 2 $\times$ $10^5$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    boolean twoSum(int arr[], int target);
}
```

### Parameters

- **`arr[]`**: An array of positive integers.
- **`target`**: The target sum to find.

### Returns

- A boolean value:
  - `true` if a pair with the given sum exists.
  - `false` otherwise.

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. The array \( arr[] \) of \( n \) positive integers.
3. An integer \( $\text{target}$ \), the required sum.

---

## 📤 Output Format

- Return `true` if a pair with the sum exists; otherwise, return `false`.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [1, 4, 45, 6, 10, 8], target = 16
```

**Output**:

```plaintext
true
```

**Explanation**:

- The pair \( (6, 10) \) adds up to \( 16 \).

---

### Example 2

**Input**:

```plaintext
arr = [1, 2, 4, 3, 6], target = 11
```

**Output**:

```plaintext
false
```

**Explanation**:

- No pair in the array sums up to \( 11 \).

---

## 💡 Approach

### Optimized Two-Pointer/HashMap Approach

Instead of brute-forcing all pairs (\( $O(n^2)$ \)), we use a more efficient **HashMap-based solution**:

### Steps:

1. **Iterate through the Array**:

   - For each element \( x \), compute \( $\text{complement}$ = $\text{target}$ - x \).
   - Check if the complement exists in a HashMap.

2. **HashMap Storage**:

   - Use a HashMap to store elements as keys and their indices as values.
   - This allows \( O(1) \) lookup for complements.

3. **Check for Distinct Indices**:
   - Ensure the indices are distinct when verifying pairs.

---

### Time Complexity

- **Single Pass**: \( O(n) \).
- **Space Complexity**: \( O(n) \): For storing elements in the HashMap.

---

## 🖥️ Solution

### Java Implementation

Here’s the full implementation with user input:

```java

class Solution {

    // Function to determine if a pair with the given sum exists
    public boolean twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                return true; // Pair found
            }

            map.put(arr[i], i);
        }

        return false; // No pair found
    }
}
```

---

## 🔍 Example Walkthrough

### Example 1

#### Input:

```plaintext
Enter the size of the array: 6
Enter the elements of the array:
1 4 45 6 10 8
Enter the target sum: 16
```

#### Execution Steps:

1. **Iteration 1**: \( x = 1, $\text{complement}$ = 15 \).
   - \( 15 \) is not in the map. Add \( 1 \).
2. **Iteration 2**: \( x = 4, $\text{complement}$ = 12 \).
   - \( 12 \) is not in the map. Add \( 4 \).
3. **Iteration 3**: \( x = 45, $\text{complement}$ = -29 \).
   - \( -29 \) is not in the map. Add \( 45 \).
4. **Iteration 4**: \( x = 6, $\text{complement}$ = 10 \).
   - \( 10 \) is not in the map. Add \( 6 \).
5. **Iteration 5**: \( x = 10, $\text{complement}$ = 6 \).
   - \( 6 \) is in the map. Return `true`.

#### Output:

```plaintext
true
```

---

### Example 2

#### Input:

```plaintext
Enter the size of the array: 5
Enter the elements of the array:
1 2 4 3 6
Enter the target sum: 11
```

#### Execution Steps:

1. Iterate through the array, computing complements: \( 10, 9, 7, 8, 5 \).
2. No complement exists in the map.

#### Output:

```plaintext
false
```

---

## ✨ Key Takeaways

- **HashMap-based Two-Sum** provides an efficient solution for \( O(n) \) time complexity.
- Handles large input sizes (\( n $\leq$ $10^5$ \)) comfortably.
- **Interactive Input/Output** allows testing with real-world cases.

**Happy Coding!** 🚀
