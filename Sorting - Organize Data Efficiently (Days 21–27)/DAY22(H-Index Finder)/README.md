# H-Index Finder 📚

This project provides an efficient solution to compute the H-index for a researcher based on their citation data. The H-index is a widely-used metric to measure research impact, representing the largest number 𝐻 such that a researcher has at least 𝐻 papers with at least 𝐻 citations.

## 📝Problem Statement

Given an array citations[] where citations[i] represents the number of citations a researcher received for their 𝑖^𝑡ℎ paper, determine the H-index.

Note : H-Index is the largest value such that the researcher has at least H papers that have been cited at least H times.

---

🔒 Constraints:

```
- 1≤citations.size()≤10^6
- 0 ≤citations[𝑖] ≤ 10^6
```

---

## 📜 Function Description

**Function**:

```java
public static int hIndex(int[] citations);

Parameters:

citations: An integer array containing the citation counts for each paper.

Returns:

int: The H-index value, representing the researcher's impact.
```

---

### **📥 Input Format**

- A single array of integers, 𝑐𝑖𝑡𝑎𝑡𝑖𝑜𝑛𝑠[], where each element represents the citation count of a paper.

### ** 📤Output Format**

- An integer representing the H-index of the researcher.

---

## 🧩 Examples

### Example 1

#### Input:

```
citations = [3, 0, 5, 3, 0]
```

**Output:**

```java
3
```

### Explanation:

- There are at least 3 papers (with citation counts 3, 5, and 3) that have been cited at least 3 times.

### Example 2

#### Input:

```
citations = [5, 1, 2, 4, 1]
```

**Output:**

```java
2
```

### Explanation:

There are 3 papers (with citation counts 5, 2, and 4) that have been cited at least 2 times, but not 3 papers with at least 3 citations.

---

## 💡 Approach

```
The H-index calculation involves these steps:

    1. Sort the array in descending order: This helps align citation counts with their rank.
    2. Iterate through the sorted array:
        - At each position i, calculate H = n−i, where n is the total number of papers.
        - Check if citations[i]≥H. If true, H is the valid H-index.
    3. Return H once found; otherwise, return 0.
```

#### Optimized Bucket Sort Approach (Optional for Large Datasets)

Use bucket sort for 𝑂(𝑛) complexity, handling large citation values efficiently.

💡 Key Insights

```
1. Bucket Boundaries:

- If a paper has more than 𝑛 citations, it only contributes to the H-Index as 𝑛.
- Therefore, we can limit our buckets to size n+1 (from 0 to n).
- Any citation count greater than n is grouped into the last bucket.

2.  Count Papers in Buckets:

    - Use an array (buckets) where buckets[i] represents the number of papers with i citations.

3.  Accumulate from the End:

    - Starting from the highest bucket, calculate the cumulative number of papers.
    - The H-Index is the largest H such that the cumulative count of papers is at least𝐻.


🛠️ Algorithm

1. Initialize Buckets: Create an array of size n+1.
2. Populate Buckets: Iterate through the citations array and update the corresponding bucket. For citations > n, increment the last bucket.
3. Compute H-Index: Traverse the buckets from the end, maintaining a cumulative count of papers. The H-index is found when the cumulative count ≥ H.

```

---

# Time Complexity

Sorting Approach:

Time: O(nlogn), due to sorting the array.
Space: O(1), as sorting is done in place.

Bucket Sort Approach:

Time: O(n).
Space: O(n), for the buckets.

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
