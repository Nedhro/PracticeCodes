public class RotateArray {

  public static void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  public static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  /*When k is negative, it rotates to the left. Space is O(1) and time is O(n)*/
  static void rotateIfKNegative(int[] num, int k) {
    int n = num.length;
    k = k % n;
    if (k < 0)
      k += n;
    int[] result = new int[n];
    System.arraycopy(num, 0, result, k, n - k);
    System.arraycopy(num, n - k, result, 0, k);
    System.arraycopy(result, 0, num, 0, n);
  }

  /*if wants to leftRotate*/
  public void leftRotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
    reverse(nums, 0, nums.length - 1);
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    rotate(nums, k);
    for (int i : nums)
      System.out.println(i);
  }
}

/*
* ArrayUtil class is used to provide following utilities in primitive array
* 1. swap array elements
* 2. reverse array between startIndex and endIndex
* 3. leftRotate array by shift

*
* Algorithm for array rotation by shift-

If we have to reverse array by shift value then take mod(%) with array length so that shift will become smaller than array length.
Reverse array between index 0 and shift-1
Reverse array between index shift and length-1.
Reverse complete array between index 0 and length-1.
Space Complexity: In-place Algorithm, No extra space needed so O(1).

Time Complexity : Array reversal of size k take O(k/2) i.e swapping k/2 pairs of elements.

Array Reversal time- O(k) for k size array.

Total time in Rotation-

O(1) ..........for step 1
O(shift) ......for step 2
O(n - shift) ...for step 3
O(n) ...........for step 4
Total Time for array Rotation: O(1) + O(shift) + O(n-shift) + O(n) = O(n)
* */
class Solution {

  public static void main(String[] args) {
    int k = 3;
    int[] a = {1, 2, 3, 4, 5, 6, 7};

    ArrayUtil.leftRotate(a, k);

    for (int i : a) {
      System.out.println(i);
    }
  }
}

class ArrayUtil {

  public static boolean checkIndexOutOfRange(int[] array, int index) {
    return index < 0 || index > array.length;
  }

  public static void swap(int[] array, int i, int j) {
    if (checkIndexOutOfRange(array, i) || checkIndexOutOfRange(array, j))
      return;
    int t = array[i];
    array[i] = array[j];
    array[j] = t;
  }

  public static void reverse(int[] array, int startIndex, int endIndex) {
    if (checkIndexOutOfRange(array, startIndex) || checkIndexOutOfRange(array, endIndex))
      return;
    while (startIndex < endIndex) {
      swap(array, startIndex, endIndex);
      startIndex++;
      endIndex--;
    }
  }

  public static void reverse(int[] array) {
    reverse(array, 0, array.length - 1);
  }

  public static void leftRotate(int[] array, int shift) {
    int arrayLength = array.length;
    if (shift >= arrayLength)
      shift %= arrayLength;
    reverse(array, 0, shift - 1);
    reverse(array, shift, arrayLength - 1);
    reverse(array);
  }
}
