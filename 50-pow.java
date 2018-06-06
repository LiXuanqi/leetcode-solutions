class Solution {
  public double myPow(double x, int n) {
      if (n >= 0) {
          return pow(x, n);
      } else {
          return 1 / pow(x, Math.abs(n));
      }
  }
  private double pow(double x, int n) {
      if (n == 0) {
          return 1;
      }
      double half = pow(x, n / 2);
      if (n % 2 == 0) {
          return half * half;
      } else {
          return half * half * x;
      }
  }
}