class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
      int left = 0;
      int right = letters.length - 1;
      while (left + 1 < right) {
          int mid = left + (right - left) / 2;
          if (letters[mid] == target) {
              left = mid;
          } else if (letters[mid] < target) {
              left = mid;
          } else {
              right = mid;
          }
      }
      if (letters[left] > target) {
          return letters[left];
      }
      if (letters[right] > target) {
          return letters[right];
      }
      return letters[0];
  }
}
// [1, 3, 3, 3, 3], 3
// [3, 3, 3]
// [3, 3]