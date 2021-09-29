import java.util.HashSet;

public class ContainsDuplicate {

  public static boolean containsDuplicate(int[] nums) {
    if (nums == null || nums.length == 0)
      return false;
    HashSet<Integer> set = new HashSet<>();
    for (int i : nums) {
      if (!set.add(i))
        return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6, 7};
    containsDuplicate(a);
  }

}
