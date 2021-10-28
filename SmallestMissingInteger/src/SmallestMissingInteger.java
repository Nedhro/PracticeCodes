import java.util.Arrays;

public class SmallestMissingInteger {

  public int solution(int[] arr) {
    int smallestInt = 1;

    if (arr.length == 0)
      return smallestInt;

    Arrays.sort(arr);

    if (arr[0] > 1)
      return smallestInt;
    if (arr[arr.length - 1] <= 0)
      return smallestInt;

    for (int j : arr) {
      if (j == smallestInt)
        smallestInt++;
    }

    return smallestInt;
  }
}
