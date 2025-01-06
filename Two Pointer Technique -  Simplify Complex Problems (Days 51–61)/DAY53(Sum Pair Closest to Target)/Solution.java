import java.util.*;

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        if (arr.length < 2) {
            return new ArrayList<>();
        }
        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;
        int closestDiff = Integer.MAX_VALUE;
        int maxAbsDiff = Integer.MIN_VALUE;
        int a = -1, b = -1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int diff = Math.abs(target - sum);
            if (diff < closestDiff || (diff == closestDiff && (arr[right] - arr[left] > maxAbsDiff))) {
                closestDiff = diff;
                maxAbsDiff = arr[right] - arr[left];
                a = arr[left];
                b = arr[right];
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return a == -1 ? new ArrayList<>() : Arrays.asList(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        if (n < 2) {
            System.out.println("Array must have at least 2 elements.");
            System.out.println("Closest pair: []");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        Solution solution = new Solution();
        List<Integer> result = solution.sumClosest(arr, target);
        System.out.println("Closest pair: " + result);

        scanner.close();
    }
}
