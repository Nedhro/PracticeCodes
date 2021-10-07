public class FirstUniqueChar {

  public int firstUniqChar(String s) {
    int uniqueIndex = -1;

    if (s.length() > 0) {

      char[] chars = new char[s.length()];
      int[] counts = new int[s.length()];
      int[] firstIndices = new int[s.length()];
      int lastIndex = 0;

      for (int i = 0; i < s.length(); i++) {
        boolean found = false;
        int j = 0;

        while (j < s.length() && !found) {
          if (s.charAt(i) == chars[j]) {
            counts[j]++;
            found = true;
          }

          j++;
        }

        if (!found) {
          chars[lastIndex] = s.charAt(i);
          counts[lastIndex] = 1;
          firstIndices[lastIndex] = i;
          lastIndex++;
        }

      }

      for (int i = 0; i <= lastIndex; i++) {
        if (counts[i] == 1) {

          uniqueIndex = firstIndices[i];
          break;
        }
      }
    }

    return uniqueIndex;

  }
}
