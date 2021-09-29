import java.util.Arrays;

public class MoveZeros {

  // Function to move all zeros present in the array to the end
  public static void reorder(int[] A) {
    // `k` stores the index of the next available position
    int k = 0;

    // do for each element
    for (int i : A) {
      // if the current element is non-zero, put the element at the
      // next free position in the array
      if (i != 0) {
        A[k++] = i;
      }
    }

    // move all 0's to the end of the array (remaining indices)
    for (int i = k; i < A.length; i++) {
      A[i] = 0;
    }
  }

  /* another solution*/
  public static void moveZeroes(int[] arr) {
    int count = 0;  // Count of non-zero elements
    int n = arr.length;
    // Traverse the array. If element encountered is
    // non-zero, then replace the element at index 'count'
    // with this element
    for (int i = 0; i < n; i++) {
      if (arr[i] != 0)
        arr[count++] = arr[i]; // here count is
    }
    // incremented

    // Now all non-zero elements have been shifted to
    // front and 'count' is set as index of first 0.
    // Make all elements 0 from count to end.
    while (count < n) {
      arr[count++] = 0;
    }

  }

  public static void main(String[] args) {
    int[] A = {6, 0, 8, 2, 3, 0, 4, 0, 1};

    reorder(A);
    System.out.println(Arrays.toString(A));

    int[] arr = {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
    moveZeroes(arr);
    System.out.println("Array after pushing zeros to the back: ");
    for (int j : arr)
      System.out.print(j + " ");
  }
}
