import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of intervals: ");
        int n = sc.nextInt();
        
        int[][] arr = new int[n][2];
        
        System.out.println("Enter the intervals (start and end values):");
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt(); // Start of interval
            arr[i][1] = sc.nextInt(); // End of interval
        }
        
        Solution solution = new Solution();
        List<int[]> mergedIntervals = solution.mergeOverlap(arr);
        
        System.out.println("Merged Intervals:");
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
        
        sc.close();
    }
    
    public List<int[]> mergeOverlap(int[][] arr) {
        if (arr.length == 0) return new ArrayList<>();
        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        merged.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            int[] last = merged.get(merged.size() - 1);
            int[] current = arr[i];
            
            if (last[1] >= current[0]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                merged.add(current);
            }
        }
        
        return merged;
    }
}
