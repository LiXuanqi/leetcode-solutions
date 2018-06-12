class Solution {
  public boolean isPerfectSquare(int num) {
      int start = 0;
      int end = num;
      while (start + 1 < end) {
          int mid = start + (end - start) / 2;
          float quotient = (float) num / mid;
          if (quotient == mid) {
              return true;
          } else if (quotient > mid) {
              start = mid;
          } else {
              end = mid;
          }
      }
      if (start * start == num) {
          return true;
      }
      if (end * end == num) {
          return true;
      }
      return false;
  }
}

// 808201
// [0, 808201] 404100 
// => overflow => / => float