import java.util.*;

class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();

        // Iterate through the array and fix one element
        for (int i = 0; i < arr.length; i++) {
            // Create a map to store indices of elements
            Map<Integer, List<Integer>> map = new HashMap();

            // Iterate through the remaining elements to find pairs
            for (int k = i + 1; k < arr.length; k++) {
                int target = -(arr[i] + arr[k]);

                // If target exists in the map, add triplet
                if (map.containsKey(target)) {
                    for (int j : map.get(target)) {
                        ans.add(Arrays.asList(i, j, k));
                    }
                }

                // Store the current element and its index in the map
                map.computeIfAbsent(arr[k], key -> new ArrayList<>()).add(k);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Input the array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Find and print all triplets
        Solution solution = new Solution();
        List<List<Integer>> triplets = solution.findTriplets(arr);

        System.out.println("Triplets with zero sum:");
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }

        scanner.close();
    }
}
