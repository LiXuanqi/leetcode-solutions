class Solution {
  public int arrangeCoins(int n) {
      if (n == 0 || n == 1) {
          return n;
      }
      int start = 0;
      int end = n;
      while (start + 1 < end) {
          int mid = start + (end - start) / 2;
          System.out.println(sum(mid));
          System.out.println(mid);

          if (sum(mid) == n) {
              return mid;
          } else if (sum(mid) < n) {
              start = mid;
          } else {
              end = mid;
          }
      }     
      if (n < sum(start)) {
          return start - 1;
      }
      if (n >= sum(start) && n < sum(end)) {
          return start;
      }
      return end;
  }
  private long sum(long n) {
      long sum = (1 + n) * n / 2;
      return sum;
  }
}

// sum() => overflow => 32-bit-signed => long.
// math