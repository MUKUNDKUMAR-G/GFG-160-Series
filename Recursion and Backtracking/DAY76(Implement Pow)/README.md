# **📜 Implement Power Function using Recursion 🔥**

## **📝 Problem Statement**

Implement a function `power(b, e)`, which calculates **b raised to the power of e** (`b^e`) **without using built-in functions** like `Math.pow()`.

---

## **🔹 Example Scenarios**

### ✅ **Example 1**

**Input:**

```sh
b = 3.00000, e = 5
```

**Output:**

```sh
243.00000
```

**Explanation:**  
\[
3^5 = 3 × 3 × 3 × 3 × 3 = 243
\]

### ✅ **Example 2**

**Input:**

```sh
b = 0.55000, e = 3
```

**Output:**

```sh
0.16638
```

**Explanation:**  
\[
0.55^3 = 0.55 × 0.55 × 0.55 = 0.166375
\]

### ✅ **Example 3**

**Input:**

```sh
b = -0.67000, e = -7
```

**Output:**

```sh
-16.49971
```

**Explanation:**  
\[
(-0.67)^{-7} = \frac{1}{(-0.67)^7} = -16.49971
\]

---

## **📌 Constraints**

✔ `-100.0 < b < 100.0`  
✔ `-10^9 ≤ e ≤ 10^9`  
✔ Either `b ≠ 0` or `e > 0`.  
✔ `-10^4 ≤ b^e ≤ 10^4`

---

## **⚙️ Function Description**

```java
class Solution {
    double power(double b, int e) {
        // Code here
    }
}
```

- **Parameters:**
  - `b`: Base (double)
  - `e`: Exponent (integer)
- **Returns:**
  - A `double` representing `b^e`

---

## **💡 Approach**

### **🔴 Brute Force Approach (Iterative)**

💡 **Idea**: Multiply `b` by itself `e` times.

#### **🔍 Why Not Use This?**

- **Inefficient** for large `e` (`O(e)` time complexity).
- **Fails** for negative exponents directly.

---

## **✅ Optimized Approach: Recursive Exponentiation (Divide & Conquer) 🚀**

### **💡 Intuition:**

Instead of multiplying `b` by itself `e` times, we **reduce the problem by half** at each step:

- If `e` is **even**:  
  \[
  b^e = (b^{e/2}) \times (b^{e/2})
  \]
- If `e` is **odd**:  
  \[
  b^e = b \times (b^{(e-1)/2}) \times (b^{(e-1)/2})
  \]
- If `e` is **negative**:  
  \[
  b^e = \frac{1}{b^{-e}}
  \]

🔹 **Key Insight:** We use **recursion** to break the problem into **smaller subproblems** until we reach `e = 0` (base case).

---

## **⏳ Time & Space Complexity Analysis**

- **Time Complexity:**
  - `O(log e)`, because we divide `e` by 2 in each recursive call.
- **Space Complexity:**
  - `O(log e)`, due to recursive call stack usage.

---

## **🚀 Recursive Java Solution (Without Built-in Functions)**

```java
class Solution {
    double power(double b, int e) {
        // Base case: anything raised to power 0 is 1
        if (e == 0) return 1.0;

        // Handle negative exponent
        if (e < 0) {
            b = 1 / b;
            e = -e; // Convert e to positive for easier calculation
        }

        // Recursively calculate half power
        double halfPower = power(b, e / 2);

        // If exponent is even: multiply halfPower by itself
        if (e % 2 == 0) {
            return halfPower * halfPower;
        }
        // If exponent is odd: multiply halfPower by itself and one more b
        else {
            return halfPower * halfPower * b;
        }
    }
}
```

---

## **🧪 Example Walkthrough**

Let's break down `power(2, 10)`:

1. `power(2, 10) → power(2, 5) → power(2, 2) → power(2, 1) → power(2, 0) = 1`
2. `power(2, 1) = 2 × 1 = 2`
3. `power(2, 2) = 2 × 2 = 4`
4. `power(2, 5) = 2 × 4 × 4 = 32`
5. `power(2, 10) = 32 × 32 = 1024`

✅ **Final Output: 1024**

---

## **🎯 Why This Approach?**

✔ **Faster** than brute force (`O(log e)` instead of `O(e)`).  
✔ **Handles negative exponents** correctly.  
✔ **Efficient in memory & computation.**

---

## **🔥 Alternative: Iterative Approach (Optimized)**

Instead of recursion, we can **use bitwise operations** to optimize further:

```java
class Solution {
    double power(double b, int e) {
        if (e == 0) return 1.0;

        if (e < 0) {
            b = 1 / b;
            e = -e;
        }

        double result = 1.0;
        while (e > 0) {
            if ((e & 1) == 1) { // If e is odd
                result *= b;
            }
            b *= b; // Square the base
            e >>= 1; // Divide exponent by 2
        }
        return result;
    }
}
```

🔹 **Time Complexity: `O(log e)`**  
🔹 **Space Complexity: `O(1)`** (No recursion stack!)

---

## **🚀 Summary**

| Approach                                   | Time Complexity | Space Complexity | Handles Negatives?        |
| ------------------------------------------ | --------------- | ---------------- | ------------------------- |
| **Brute Force (Iterative Multiplication)** | `O(e)`          | `O(1)`           | ❌ No (fails for `e < 0`) |
| **Recursive (Divide & Conquer)**           | `O(log e)`      | `O(log e)`       | ✅ Yes                    |
| **Iterative (Bitwise Optimization)**       | `O(log e)`      | `O(1)`           | ✅ Yes                    |

✅ **Best Approach**: **Iterative (Bitwise Optimization) → `O(log e)` with `O(1)` space!** 🚀

---

## **🎯 Conclusion**

We implemented `power(b, e)` using:  
✔ **Recursive Approach** (Divide & Conquer) 🌀  
✔ **Iterative Approach** (Bitwise Optimization) ⚡  
✔ **Handled Negative Exponents** properly! 🚀

💡 **Now you can calculate powers efficiently! 🔥**

🚀 **What do you think? Would you like additional optimizations?** 😃
