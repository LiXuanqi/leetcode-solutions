class Solution {
  public int mySqrt(int x) {
      if (x == 0 || x == 1) {
          return x;
      }
      int start = 0;
      int end = x;
      while (start + 1 < end) {
          int mid = start + (end - start) / 2;
          double quotient = (double) x / mid;
          System.out.println(quotient);
          System.out.println(mid);
          if (quotient == mid) {
              return mid;
          } else if (quotient < mid) {
              end = mid;
          } else {
              start = mid;
          }
      }        
      if (x / end >= end) {
          return end;
      }  
      return start;
  }
}

// quotient precision => 9.9999999999999 => 10 => float => double