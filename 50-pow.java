class Solution {
    public double myPow(double x, int n) {
        if (x == 0 && n == 0) {
            return 0;
        }
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
        double power = pow(x, n / 2);
        if (n % 2 == 0) {
            return power * power;
        }
        return x * power * power;
    }
}

// Time: log(n)
// Space: log(n)