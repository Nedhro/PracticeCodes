import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

  // Time complexity: O(n)
  private static int[] findTwoSum(int[] nums, int target) {
    Map<Integer, Integer> numMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (numMap.containsKey(complement)) {
        return new int[] { numMap.get(complement), i };
      } else {
        numMap.put(nums[i], i);
      }
    }
    return new int[] {};
  }

  // Time complexity: O(n^2)
  private static int[] findTwoSum_BruteForce(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] { i, j };
        }
      }
    }
    return new int[] {};
  }

  // Time complexity: O(n*log(n))
  private static int[] findTwoSum_Sorting(int[] nums, int target) {
    Arrays.sort(nums);
    int left = 0;
    int right = nums.length - 1;
    while(left < right) {
      if(nums[left] + nums[right] == target) {
        return new int[] {nums[left], nums[right]};
      } else if (nums[left] + nums[right] < target) {
        left++;
      } else {
        right--;
      }
    }
    return new int[] {};
  }


  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    int n = keyboard.nextInt();
    int[] nums = new int[n];

    for(int i = 0; i < n; i++) {
      nums[i] = keyboard.nextInt();
    }
    int target = keyboard.nextInt();

    keyboard.close();

    int[] indices = findTwoSum_BruteForce(nums, target);

    if (indices.length == 2) {
      System.out.println(indices[0] + " " + indices[1]);
    } else {
      System.out.println("No solution found!");
    }
  }
}
