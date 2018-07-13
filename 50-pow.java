class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / pow(x, -n);
        }
        return pow(x, n);
    }
    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double half = pow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
// Time: log(n)
// Space: log(n)