public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0)
      return "";

    String prefix = strs[0];
    for (String s : strs) {
      if (s.length() < prefix.length())
        prefix = s;
    }
    int i = 0;
    while (i < prefix.length()) {
      for (String s : strs) {
        if (s.charAt(i) != prefix.charAt(i))
          return prefix.substring(0, i);
      }
      i++;
    }
    return prefix;
  }
}
