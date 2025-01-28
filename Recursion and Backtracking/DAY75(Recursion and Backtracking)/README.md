# **📜 Permutations of a String using Recursion & Backtracking 🚀**

## **📝 Problem Statement**

Given a string `s`, generate and return an array of all **unique permutations** of the string. The order of output does not matter. If the input string contains duplicate characters, ensure that the generated permutations are unique.

### **🔹 Example Scenarios**

#### ✅ Example 1

**Input:**

```
s = "ABC"
```

**Output:**

```
["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
```

**Explanation:**  
There are `3! = 6` unique permutations for the string "ABC".

#### ✅ Example 2

**Input:**

```
s = "ABSG"
```

**Output:**

```
["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB",
 "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA",
 "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA",
 "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"]
```

**Explanation:**  
For a string of length `4`, there are `4! = 24` unique permutations.

#### ✅ Example 3

**Input:**

```
s = "AAA"
```

**Output:**

```
["AAA"]
```

**Explanation:**  
Since all characters are identical, only one unique permutation exists.

---

## **📌 Constraints**

✔ `1 ≤ s.size() ≤ 9`  
✔ `s` contains only **uppercase English alphabets (A-Z)**

---

## **⚙️ Function Description**

```java
public ArrayList<String> findPermutation(String s)
```

- **Parameters:** A string `s`.
- **Returns:** A list of all **unique** permutations.

---

## **📥 Input Format**

A single string `s`.

## **📤 Output Format**

A list of strings representing all unique permutations of `s`.

---

## **💡 Approach**

### **🔴 Brute Force Approach** (Not Efficient 🚫)

1️⃣ Generate all possible permutations using `next_permutation()` (if using STL).  
2️⃣ Store all permutations in a **list** and use `Set` to remove duplicates.

#### ❌ Why is it inefficient?

- **Extra Space**: We store **all** permutations, including duplicates, and remove them later.
- **Sorting Required**: To remove duplicates, we need additional sorting operations.
- **Time Complexity**: **O(n! × n)** due to unnecessary storage and removal operations.

---

### **✅ Optimized Approach: Recursion + Backtracking**

💡 **Intuition:**  
Instead of generating **all** permutations first and filtering later, we generate **only unique permutations** using **recursive swapping** and **backtracking**.

#### **Steps**

1️⃣ Convert the string into a **character array** to facilitate swapping.  
2️⃣ Use a **recursive function** to swap characters at different positions.  
3️⃣ Use a **HashSet** to avoid duplicate swaps at the same recursive depth.  
4️⃣ Perform **backtracking** to restore the original string after recursive calls.

#### **🔷 Algorithm**

- Fix each character one by one and recursively generate permutations for the remaining string.
- Swap the character back (**backtracking**) after recursion to restore the original state.
- Avoid duplicate swaps at the same level using a **HashSet**.

---

## **🕒 Time & Space Complexity**

| Approach                                 | Time Complexity | Space Complexity                       |
| ---------------------------------------- | --------------- | -------------------------------------- |
| **Brute Force**                          | `O(n! × n)`     | `O(n!)` (for storing all permutations) |
| **Optimized (Recursion + Backtracking)** | `O(n!)`         | `O(n)` (for recursive stack)           |

🚀 **Best Case:** **O(n!)** is the most optimal since there are `n!` unique permutations in the worst case.

---

## **💻 Java Solution (Efficient 🚀)**

```java
import java.util.*;

class Solution {
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);  // Ensure lexicographical order
        backtrack(arr, 0, result);
        return result;
    }

    private void backtrack(char[] arr, int index, ArrayList<String> result) {
        if (index == arr.length - 1) {
            result.add(new String(arr));
            return;
        }

        HashSet<Character> swapped = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (swapped.contains(arr[i])) continue;  // Avoid duplicate swaps at the same depth
            swapped.add(arr[i]);

            swap(arr, index, i);      // Swap to fix one character
            backtrack(arr, index + 1, result); // Recurse for next index
            swap(arr, index, i);      // Backtrack (undo swap)
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
```

---

## **🔎 Example Walkthrough**

### **🔹 Input:**

```sh
s = "ABC"
```

### **🛠 Recursive Tree Structure**

![Tree Structure](https://www.geeksforgeeks.org/wp-content/uploads/NewPermutation.gif)

### **📤 Output:**

```sh
["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
```

---

## **🔥 Why This Approach?**

| Approach                     | Advantages                                            | Disadvantages                         |
| ---------------------------- | ----------------------------------------------------- | ------------------------------------- |
| **Brute Force**              | Simple to implement                                   | Slow due to extra storage and sorting |
| **Recursion + Backtracking** | ✅ Efficient, ✅ No extra space, ✅ Avoids duplicates | Requires understanding recursion      |

🚀 **This approach is optimal** since it ensures **O(n!)** complexity while **avoiding unnecessary storage and sorting**.

---

## **📌 Summary**

🔹 **Recursive Backtracking** ensures all unique permutations are generated efficiently.  
🔹 **O(n!) complexity** is the best we can achieve due to factorial growth of permutations.  
🔹 **Backtracking & HashSet** help avoid duplicate calculations.  
🔹 **Swap & Restore** method ensures correctness of recursion.

---

## **👥 Contributors**

- **Your Name** – [GitHub Profile](https://github.com/mukundkumar-g)

## **📜 License**

This project is licensed under the **MIT License**.

---

**🚀 Keep Coding & Keep Exploring! 🔥**
