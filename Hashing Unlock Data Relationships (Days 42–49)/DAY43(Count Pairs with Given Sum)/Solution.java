import java.util.HashMap;

class Solution {
    public int countPairs(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int complement = target - num;

            // If complement exists in the map, add its frequency to the count
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5};
        int target = 6;

        Solution solution = new Solution();
        int result = solution.countPairs(arr, target);

        System.out.println("Number of pairs: " + result);
    }
}
