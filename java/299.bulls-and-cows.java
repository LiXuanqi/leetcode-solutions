class Solution {
  public String getHint(String secret, String guess) {
      if (secret == null || guess == null) {
          return null;
      }
      if (secret.length() == 0) {
          return null;
      }
      int bull = 0;
      int cow = 0;
      int[] map = new int[10];
      for (int i = 0; i < secret.length(); i++) {
          map[secret.charAt(i) - '0']++;
          if (secret.charAt(i) == guess.charAt(i)) {
              bull++;
          }
      }
      for (int i = 0; i < guess.length(); i++) {
          int index = guess.charAt(i) - '0';
          if (map[index] > 0) {
              cow++;
              map[index]--;
          }
      }  
      return bull + "A" + (cow - bull) + "B";
  }
}