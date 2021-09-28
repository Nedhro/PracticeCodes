public class Solution {

  // Function to remove duplicate elements
  // This function returns new size of modified
  // array.
  static int removeDuplicateMethod1(int[] arr, int n)
  {
    // Return, if array is empty
    // or contains a single element
    if (n==0 || n==1)
      return n;

    int[] temp = new int[n];

    // Start traversing elements
    int j = 0;
    for (int i=0; i<n-1; i++)
      // If current element is not equal
      // to next element then store that
      // current element
      if (arr[i] != arr[i+1])
        temp[j++] = arr[i];

    // Store the last element as whether
    // it is unique or repeated, it hasn't
    // stored previously
    temp[j++] = arr[n-1];

    // Modify original array
    int i=0;
    while (i<j) {
      arr[i] = temp[i];
      i++;
    }

    return j;
  }
  // Function to remove duplicate elements
  // This function returns new size of modified
  // array.
  static int removeDuplicateMethod2(int[] arr, int n)
  {
    if (n == 0 || n == 1)
      return n;

    // To store index of next unique element
    int j = 0;

    // Doing same as done in Method 1
    // Just maintaining another updated index i.e. j
    for (int i = 0; i < n-1; i++)
      if (arr[i] != arr[i+1])
        arr[j++] = arr[i];

    arr[j++] = arr[n-1];

    return j;
  }

  public static void main (String[] args)
  {
    int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5};
    int n = arr.length;

    int m1 = removeDuplicateMethod1(arr, n);
//    int m2 = removeDuplicateMethod1(arr, n);

    // Print updated array
    System.out.println("Method 1: ");
    for (int i=0; i<m1; i++)
      System.out.print(arr[i]+" ");
    // Print updated array
    System.out.println();
   /* System.out.println("Method 2: ");
    for (int i=0; i<m2; i++)
      System.out.print(arr[i]+" ");*/
  }
}
