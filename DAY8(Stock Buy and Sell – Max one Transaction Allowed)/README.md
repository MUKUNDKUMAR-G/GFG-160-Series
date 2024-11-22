# Stock Buy and Sell – Max one Transaction Allowed📈

## 📜Problem Statement

Given an array prices[] of length n, representing the prices of the stocks on different days. The task is to find the maximum profit possible by buying and selling the stocks on different days when at most one transaction is allowed. Here one transaction means 1 buy + 1 Sell. If it is not possible to make a profit then return 0.

---

## Function Description

**Function Name:** maximumProfit

**Parameters:**

int[] prices: Array of stock prices.

**Returns:**

int: Maximum profit achievable.

---

### **Input Format**

- A single array prices[] representing stock prices on different days.

---

### **Output Format**

- An integer indicating the maximum profit.

---

## 📊 Examples

### Example 1

#### Input:

```
prices[] = [7, 10, 1, 3, 6, 9, 2]

```

**Output:**

```java
8
```

### Explanation:

Buy at day 2 (price = 1) and sell at day 5 (price = 9). Profit: 9 - 1 = 8.

### Example 2

#### Input:

```
prices[] = [7, 6, 4, 3, 1]

```

**Output:**

```java
0
```

### Explanation:

Prices are decreasing, so no profitable transaction is possible.

### Example 3

#### Input:

```
prices[] = [1, 3, 6, 9, 11]

```

**Output:**

```java
10
```

### Explanation:

Buy at day 1 (price = 1) and sell at day 5 (price = 11). Profit: 11 - 1 = 10.

## 🧠 Approach and Solution

1. Initialize lowPrice to Integer.MAX_VALUE and maxProfit to 0.
2. Traverse the array:
   - Update lowPrice to the minimum of lowPrice and the current price.
   - Calculate the potential profit as prices[i] - lowPrice.
   - Update maxProfit if the potential profit is higher.
3. Return maxProfit after the loop ends.

---

### Constraints:

```
1 <= prices.size() <= 10^5
0 <= prices[i] <= 10^4
```

# Time Complexity

- Time Complexity: O(n), We only traverse the array once where n is the number of days (prices array length).
- Space Complexity: O(1), We only use a few variables (No additional data structures are used).

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
