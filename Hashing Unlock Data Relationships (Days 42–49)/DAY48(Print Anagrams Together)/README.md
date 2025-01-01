# 🌟 Print Anagrams Together

---

## 💡 Problem Statement

You are given an array of strings `arr[]`. The task is to group all strings that are anagrams of each other.

- **Anagram**: Two strings are anagrams if they contain the same characters with the same frequency, irrespective of the order.

The groups should be created in the **order of their first appearance** in the array.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{arr.size()}$ $\leq$ 100 \)
- \( 1 $\leq$ $\text{arr[i].size()}$ $\leq$ 10 \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr);
}
```

### Parameters

- **`arr[]`**: An array of strings of size \( n \).

### Returns

- A list of lists where each inner list contains all anagrams grouped together.

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. \( n \) strings in the array \( arr[] \).

---

## 📤 Output Format

- A list of lists where each inner list contains all anagrams grouped together.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = ["act", "god", "cat", "dog", "tac"]
```

**Output**:

```plaintext
[["act", "cat", "tac"], ["god", "dog"]]
```

**Explanation**:

- Group 1: \( $\text{"act", "cat", "tac"}$ \) are anagrams.
- Group 2: \( $\text{"god", "dog"}$ \) are anagrams.

---

### Example 2

**Input**:

```plaintext
arr = ["no", "on", "is"]
```

**Output**:

```plaintext
[["is"], ["no", "on"]]
```

**Explanation**:

- Group 1: \( $\text{"is"}$ \) is a single word.
- Group 2: \( $\text{"no", "on"}$ \) are anagrams.

---

### Example 3

**Input**:

```plaintext
arr = ["listen", "silent", "enlist", "abc", "cab", "bac", "rat", "tar", "art"]
```

**Output**:

```plaintext
[["abc", "cab", "bac"], ["listen", "silent", "enlist"], ["rat", "tar", "art"]]
```

**Explanation**:

- Group 1: \( $\text{"abc", "cab", "bac"}$ \).
- Group 2: \( $\text{"listen", "silent", "enlist"}$ \).
- Group 3: \( $\text{"rat", "tar", "art"}$ \).

---

## 💡 Approach

### Optimized HashMap-Based Solution

1. **Sorting as Key**:

   - For each string in the array, sort its characters.
   - Use the sorted string as the key in a HashMap.

2. **Group Anagrams**:

   - Add the original string to the list corresponding to its sorted version in the HashMap.

3. **Extract Results**:

   - The values of the HashMap will give the required groups of anagrams.

4. **Maintain Original Order**:
   - Use a LinkedHashMap to preserve the order of insertion for the first appearance of groups.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- Sorting Each String: \( $O(k \log k)$ \), where \( k \) is the average length of the strings.
- Total Sorting: \( O(n $\cdot$ k $\log$ k) \).
- HashMap Operations: \( O(n $\cdot$ k) \).
- **Overall**: \( O(n $\cdot$ k $\log$ k) \).

### Space Complexity

- \( O(n $\cdot$ k) \): For storing strings in the HashMap and result list.

---

## 🖥️ Solution

### Java Implementation

```java
import java.util.*;

class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        Map<String, ArrayList<String>> map = new LinkedHashMap<>();

        for (String str : arr) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
act
god
cat
dog
tac
```

### Execution Steps:

1. **Sorting Strings as Keys**:

   - \( $\text{"act"}$ $\to$ "act" \).
   - \( $\text{"god"}$ $\to$ "dgo" \).
   - \( $\text{"cat"}$ $\to$ "act" \).
   - \( $\text{"dog"}$ $\to$ "dgo" \).
   - \( $\text{"tac"}$ $\to$ "act" \).

2. **Group by Sorted Keys**:

   - \( "act" $\to$ ["act", "cat", "tac"] \).
   - \( "dgo" $\to$ ["god", "dog"] \).

3. **Result**:
   ```plaintext
   [["act", "cat", "tac"], ["god", "dog"]]
   ```

### Output:

```plaintext
Grouped Anagrams:
[act, cat, tac]
[dog, god]
```

---

## ✨ Key Takeaways

- **HashMap Optimization**: Using a sorted version of strings as keys groups anagrams efficiently.
- **Lexicographic Sorting**: The driver code sorts each group before printing.
- **Scalable**: Handles up to 100 strings of length 10 with ease.

**Happy Coding!** 🚀
