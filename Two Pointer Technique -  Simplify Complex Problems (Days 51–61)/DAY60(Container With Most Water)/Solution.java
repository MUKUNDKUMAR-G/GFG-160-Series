class Solution {
    public int maxWater(int[] arr) {
        int n = arr.length;

        int left = 0;
        int right = n - 1;

        int ans = 0;

        while (left < right) {
            int tempWater = Math.min(arr[left], arr[right]) * (right - left);

            ans = Math.max(ans, tempWater);

            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the heights of the lines:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        int result = solution.maxWater(arr);
        System.out.println("Maximum water that can be contained: " + result);

        scanner.close();
    }
}