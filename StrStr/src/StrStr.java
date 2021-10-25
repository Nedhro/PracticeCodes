public class StrStr {

  public int strStr(String haystack, String needle) {
    if (needle.isEmpty()) {
      return 0;
    }
    int m = haystack.length();
    int n = needle.length();
    // Recurse from 0 to m - n, inclusive
    // Since from m-n+1 to m-1, there are only m-1-(m-n+1)+1 = n-1 characters
    // Not enough to form a needle
    for (int i = 0; i <= m - n; i++) {
      for (int j = 0; j < n; j++) { // Compare each char with needle from the beginning
        if (haystack.charAt(i + j) != needle.charAt(j)) {
          break;
        }
        if (j == n - 1) { // Found all n characters
          return i;
        }
      }
    }
    return -1; // Not found
  }
}
