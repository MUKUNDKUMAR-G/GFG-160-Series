# 🔍 Word Search - Find a Word in a Grid

## 📜 Problem Statement

You are given a **2D grid** `mat[][]` of size **n × m**, filled with **English alphabets**, and a target **word**.  
Your task is to determine whether the **word exists** in the grid.

✅ The word can be **constructed** by using adjacent letters in the grid.  
✅ **Allowed directions**: **Horizontal (left/right)** or **Vertical (up/down)**.  
❌ **A cell cannot be reused** in the same word path.

---

## 📌 Constraints

- **1 ≤ n, m ≤ 6**
- **1 ≤ L ≤ 15** _(Length of the word)_
- The **grid** and **word** consist of **only uppercase and lowercase English letters**.

---

## 📥 Input Format

1. A **2D matrix** of size **n × m** containing uppercase and lowercase letters.
2. A **string** representing the target word.

### **Example Input**

```plaintext
mat = [
  ['T', 'E', 'E'],
  ['S', 'G', 'K'],
  ['T', 'E', 'L']
]
word = "GEEK"
```

---

## 📤 Output Format

Return **true** if the word exists in the grid, otherwise **false**.

### **Example Output**

```plaintext
true
```

---

## 📝 **Examples & Explanations**

### **Example 1**

#### 🔹 **Input:**

```plaintext
mat = [['T', 'E', 'E'],
       ['S', 'G', 'K'],
       ['T', 'E', 'L']]
word = "GEEK"
```

#### ✅ **Output:**

```plaintext
true
```

#### 🧐 **Explanation:**

The word "GEEK" can be formed by moving in the grid as shown below:

![Example 1 - Explanation](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/886266/Web/Other/blobid4_1737981964.png)

---

### **Example 2**

#### 🔹 **Input:**

```plaintext
mat = [['T', 'E', 'U'],
       ['S', 'G', 'K'],
       ['T', 'E', 'L']]
word = "GEEK"
```

#### ❌ **Output:**

```plaintext
false
```

#### 🧐 **Explanation:**

There is no valid way to form "GEEK" in the given grid.

## ![Example 2 - Explanation](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/886266/Web/Other/blobid5_1737981964.png)

## 🚀 **Approach**

### 🔹 **1. Brute Force (Backtracking)**

#### 🔍 **Idea:**

- Start from every cell and try to **form the word** recursively.
- If we **move in any direction**, ensure **letters match**.
- If we **find the word completely**, return **true**.
- If the path fails, **backtrack** and try another direction.

#### ❌ **Why Brute Force Fails?**

- **Explores every cell** as a starting point.
- **Tries all 4 directions** at each step.
- **Leads to repeated computation** of the same states.  
  ⏳ **Time Complexity:** **O(n _ m _ 4^L)** (Exponential)  
  🔻 **Fails for larger grids due to time constraints.**

---

### 🔹 **2. Optimized Approach (Backtracking + Pruning)**

✅ **Better Pruning:**

- Start from **each cell** that matches the **first letter**.
- Use **DFS** (**Depth-First Search**) with **backtracking**.
- Mark **visited cells** to avoid reusing them.

#### 🔹 **Steps:**

1. **Find all occurrences** of `word[0]` in the grid.
2. **Perform DFS** from each valid starting point.
3. **Check in all 4 directions** (Up, Down, Left, Right).
4. **Use backtracking**:
   - **Mark cell as visited** (`#` or `null`).
   - **Explore further**.
   - **Undo changes if the path fails**.

⏳ **Time Complexity:** **O(n _ m _ 4^L)** (Better pruning)  
🛠️ **Space Complexity:** **O(L)** (Recursion depth for DFS)

---

## ✅ **Optimized Backtracking Solution (Java)**

```java
class Solution {
    // Directions: [Right, Left, Down, Up]
    private static final int[] dX = {0, 0, 1, -1};
    private static final int[] dY = {1, -1, 0, 0};

    static public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(mat, word, 0, i, j, n, m)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] mat, String word, int index, int x, int y, int n, int m) {
        if (index == word.length()) return true;

        if (x < 0 || x >= n || y < 0 || y >= m || mat[x][y] != word.charAt(index)) {
            return false;
        }

        char temp = mat[x][y];
        mat[x][y] = '#';

        for (int d = 0; d < 4; d++) {
            int newX = x + dX[d];
            int newY = y + dY[d];
            if (dfs(mat, word, index + 1, newX, newY, n, m)) {
                return true;
            }
        }

        mat[x][y] = temp;
        return false;
    }
}
```

---

## 🎯 **Example Walkthrough**

Let's trace `"GEEK"` in the following matrix:

```
T  E  E
S  G  K
T  E  L
```

### **Step-by-Step Execution:**

1️⃣ Start at `G` (`mat[1][1]`), move to `E` → `E` → `K`.  
2️⃣ Word `"GEEK"` is **found!** ✅

---

## 🕒 **Time & Space Complexity**

| Complexity                     | Value                                        |
| ------------------------------ | -------------------------------------------- |
| **Worst Case Time Complexity** | **O(n _ m _ 4^L)** (Exponential, but pruned) |
| **Best Case Complexity**       | **O(n \* m)** (If the word is found early)   |
| **Space Complexity**           | **O(L)** (Recursion stack for DFS)           |

---

## 🎉 **Key Takeaways**

✅ **Backtracking + DFS** efficiently explores valid paths.  
✅ **Pruning unnecessary paths** speeds up execution.  
✅ **Marking visited cells (`#`) prevents cycles.**  
✅ **Time complexity is significantly reduced** from brute force.

🔹 **Try running the program with different test cases! 🚀**
