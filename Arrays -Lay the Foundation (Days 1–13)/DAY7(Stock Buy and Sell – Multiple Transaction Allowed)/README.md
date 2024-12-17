# Stock Buy and Sell – Multiple Transaction Allowed📈

## 📜Problem Statement

The cost of stock on each day is given in an array price[]. Each day you may decide to either buy or sell the stock at price[i], you can even buy and sell the stock on the same day. Find the maximum profit that you can get.

**Note**: A stock can only be sold if it has been bought previously and multiple stocks cannot be held on any given day.

---

## Function Description

**Function Name:**

```
public int maximumProfit(int[] prices);
```

**Input:**

An integer array prices[] where prices[i] represents the stock price on day i.

**Output:**
Return the maximum profit you can make.

---

### **Input Format**

- An array of integers prices[].

---

### **Output Format**

- the maximum profit

---

## 📊 Examples

### Example 1

#### Input:

```
prices[] = [100, 180, 260, 310, 40, 535, 695]

```

**Output:**

```java
865
```

### Explanation:

![Explanation](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/702074/Web/Other/blobid0_1732166520.png)

Buy the stock on day 0 and sell it on day 3 => 310 – 100 = 210. Buy the stock on day 4 and sell it on day 6 => 695 – 40 = 655. Maximum Profit = 210 + 655 = 865.

---

## 🧠 Approach and Solution

- We need to maximize the profit by buying and selling at the right times. In this case, we can add to our profit whenever the price of the stock increases from one day to the next.

- We can simply calculate the profit by checking if the stock price on a day is higher than the previous day. If it is, we add the difference to the total profit.

Algo :

1. Traverse the array starting from the second day.
2. If the price on the current day is greater than the price on the previous day, add the difference (current day price - previous day price) to the total profit.
3. Continue this for every day in the array.

By repeating this process, we accumulate all the profits we can make by making multiple transactions.

---

### Constraints:

```
1 <= prices.size() <= 10^5
0 <= prices[i] <= 10^4
```

# Time Complexity

- Time Complexity: O(n), We only traverse the array once where n is the number of days (prices array length).
- Space Complexity: O(1), We only use a few variables (no extra space required).

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
