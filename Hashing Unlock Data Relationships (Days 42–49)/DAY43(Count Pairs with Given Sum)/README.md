# 🌟 Count Pairs with Given Sum

---

## 💡 Problem Statement

You are given an array `arr[]` and an integer `target`. Your task is to count the number of **distinct pairs** in the array whose sum is equal to `target`.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{arr.size}$ $\leq$ $10^5$ \)
- \( $-10^4$ $\leq$ $\text{arr[i]}$ $\leq$ $10^4$ \)
- \( 1 $\leq$ $\text{target}$ $\leq 10^4$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    int countPairs(int arr[], int target);
}
```

### Parameters

- **`arr[]`**: An array of integers.
- **`target`**: The target sum to find.

### Returns

- An integer representing the count of pairs whose sum is equal to `target`.

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. The array \( arr[] \) of \( n \) integers.
3. An integer \( $\text{target}$ \), the required sum.

---

## 📤 Output Format

- Return the count of pairs whose sum is equal to `target`.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [1, 5, 7, -1, 5], target = 6
```

**Output**:

```plaintext
3
```

**Explanation**:  
The pairs are \( (1, 5), (7, -1), (1, 5) \).

---

### Example 2

**Input**:

```plaintext
arr = [1, 1, 1, 1], target = 2
```

**Output**:

```plaintext
6
```

**Explanation**:  
The pairs are \( (1, 1), (1, 1), (1, 1), (1, 1), (1, 1), (1, 1) \).

---

### Example 3

**Input**:

```plaintext
arr = [10, 12, 10, 15, -1], target = 125
```

**Output**:

```plaintext
0
```

**Explanation**:  
No pairs have a sum equal to \( 125 \).

---

## 💡 Approach

### Optimized Approach: HashMap-Based

Instead of brute-forcing all pairs (\( $O(n^2)$ \)), we can use a **HashMap** to track the counts of elements and find the number of valid pairs efficiently.

### Steps:

1. **Initialize a HashMap**:

   - Key: The elements of the array.
   - Value: The frequency of each element.

2. **Iterate Through the Array**:

   - For each element \( x \):
     - Compute \( $\text{complement}$ = $\text{target}$ - x \).
     - If the complement exists in the map, it means pairs can be formed.
     - Add the frequency of the complement to the count of pairs.

3. **Avoid Double Counting**:
   - When counting pairs, reduce the count of the current element in the map after processing.

---

### Time Complexity

- **Single Pass**: \( O(n) \) to iterate through the array and update the map.

### Space Complexity

- \( O(n) \): For storing elements and their frequencies in the HashMap.

---

## 🖥️ Solution

### Java Implementation

```java
import java.util.HashMap;

class Solution {
    public int countPairs(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // Iterate through the array
        for (int num : arr) {
            int complement = target - num;

            // If complement exists in the map, add its frequency to the count
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }

            // Update the frequency of the current number in the map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}
```

---

## 🔍 Example Walkthrough

### Example 1

#### Input:

```plaintext
arr = [1, 5, 7, -1, 5], target = 6
```

#### Execution Steps:

1. Initialize `map` and `count = 0`.
2. Iterate through the array:

   - \( x = 1, $\text{complement}$ = 5 \). Add \( 5 \) to the map.
   - \( x = 5, $\text{complement}$ = 1 \). Pair found. Increment count to \( 1 \).
   - \( x = 7, $\text{complement}$ = -1 \). Add \( 7 \) to the map.
   - \( x = -1, $\text{complement}$ = 7 \). Pair found. Increment count to \( 2 \).
   - \( x = 5, $\text{complement}$ = 1 \). Pair found. Increment count to \( 3 \).

#### Output:

```plaintext
3
```

---

### Example 2

#### Input:

```plaintext
arr = [1, 1, 1, 1], target = 2
```

#### Execution Steps:

1. Initialize `map` and `count = 0`.
2. Iterate through the array:

   - \( x = 1, $\text{complement}$ = 1 \). Add \( 1 \) to the map.
   - \( x = 1, $\text{complement}$ = 1 \). Pair found. Increment count to \( 1 \).
   - \( x = 1, $\text{complement}$ = 1 \). Pair found. Increment count to \( 3 \).
   - \( x = 1, $\text{complement}$ = 1 \). Pair found. Increment count to \( 6 \).

#### Output:

```plaintext
6
```

---

### Example 3

#### Input:

```plaintext
arr = [10, 12, 10, 15, -1], target = 125
```

#### Execution Steps:

1. Initialize `map` and `count = 0`.
2. Iterate through the array:

   - No complements exist in the map for the given target.

#### Output:

```plaintext
0
```

---

## ✨ Key Takeaways

- **Efficient Counting**: HashMap-based approach reduces time complexity to \( O(n) \).
- **Handles Negative Numbers**: Works seamlessly for negative elements in the array.
- **Scalability**: Supports large arrays up to \( $10^5$ \) in size.

**Happy Coding!** 🚀
