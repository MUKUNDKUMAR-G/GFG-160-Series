import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static List<Integer> majorityElementII(int[] arr) {
        int n = arr.length;
        // Step 1: Find candidates
        int candidate1 = -1, candidate2 = -1, count1 = 0, count2 = 0;
        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify candidates
        count1 = count2 = 0;
        for (int num : arr) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        // Step 3: Collect results
        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        // Step 4: Sort results
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        List<Integer> result = majorityElementII(arr);
        System.out.println("Majority elements: " + result);
    }
}
