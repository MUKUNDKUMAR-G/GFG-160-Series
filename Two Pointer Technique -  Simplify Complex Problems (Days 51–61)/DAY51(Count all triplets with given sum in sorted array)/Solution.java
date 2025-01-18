import java.util.Scanner;

class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum == target) {
                    if (arr[j] == arr[k]) {
                        int totalPairs = k - j + 1;
                        count += (totalPairs * (totalPairs - 1)) / 2;
                        break;
                    } else {
                        int leftCount = 1, rightCount = 1;

                        while (j + 1 < k && arr[j] == arr[j + 1]) {
                            j++;
                            leftCount++;
                        }

                        while (k - 1 > j && arr[k] == arr[k - 1]) {
                            k--;
                            rightCount++;
                        }

                        count += leftCount * rightCount;
                        j++;
                        k--;
                    }
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        Solution solution = new Solution();
        int result = solution.countTriplets(arr, target);
        System.out.println("Number of triplets with sum " + target + ": " + result);

        scanner.close();
    }
}