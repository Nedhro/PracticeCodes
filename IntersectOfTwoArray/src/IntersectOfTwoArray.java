import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class IntersectOfTwoArray {

  public int[] intersect(int[] nums1, int[] nums2) {
    // Create a HashMap for one Array and compare the existance with the other array
    HashMap<Integer, Integer> duplicateMap = new HashMap<>();
    // int maximum = (nums1.length > nums2.length) ? nums2.length : nums1.length;
    List<Integer> result = new ArrayList<>();
    int appears;

    // Store the shorter array into the map may be slightly better but neglectable
    for (int j : nums1) {
      if (duplicateMap.containsKey(j)) {
        // THis value appears one more times
        duplicateMap.replace(j, duplicateMap.get(j) + 1);
      } else {
        // This value appears one time
        duplicateMap.put(j, 1);
      }
    }

    // 2. Check with the other array to check for the duplicates
    for (int j : nums2) {
      if (duplicateMap.containsKey(j) && duplicateMap.get(j) > 0) {
        appears = duplicateMap.get(j);
        if (appears > 0) {
          // Add the duplicate to the result array
          result.add(j);
          // Update duplicateMap as one duplicate is been recorded
          duplicateMap.replace(j, appears - 1);
        }

      }
    }
    return result.stream().mapToInt(i -> i).toArray();
  }

  /*intersection of two array*/
  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<>();
    for (Integer n : nums1) set1.add(n);
    HashSet<Integer> set2 = new HashSet<>();
    for (Integer n : nums2) set2.add(n);

    set1.retainAll(set2);

    int [] output = new int[set1.size()];
    int idx = 0;
    for (int s : set1) output[idx++] = s;
    return output;
  }
}
