
public class SingleNumber {

  public static int singleNumber(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    int res = nums[0];
    for (int i = 1; i < nums.length; i++) {
      res = res ^ nums[i];
    }
    return res;
  }

  public static void main(String[] args) {
    int[] ar = {2, 3, 5, 4, 5, 3, 4};
    System.out.println("Element occurring once is " +
        singleNumber(ar) + " ");
  }

}
