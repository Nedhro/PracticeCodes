public class PlusOne {
  public static int[] plusOne(int[] digits) {
    int l = digits.length;

    //initializing carry with the number we want to add for first time.
    int carry = 1;

    for (int i=l-1; i>=0; i--) {
      digits[i] = digits[i] + carry;

      carry = digits[i]/10;
      digits[i] = digits[i]%10;
    }

    // copy result to another array
    int targetSize = carry == 1 ? l+1 : l;
    int[] res = new int[targetSize];

    int i=0;
    if (carry == 1) {
      res[0] = carry;
      i = 1;
    }
    for (; i<targetSize; i++) {
      res[i] = digits[i-carry];
    }
    return res;
  }

  public static void main(String[] args) {
    int[] l = new int[0];
    plusOne(l);
  }
}
