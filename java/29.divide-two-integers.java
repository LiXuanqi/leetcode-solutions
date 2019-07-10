class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        
        long lans = ldivide(ldividend, ldivisor);
        if (lans >= Integer.MAX_VALUE) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) lans * sign;
    }
    
    private long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) {
            return 0;
        }
        long multiple = 1;
        long sum = ldivisor; 
        while ((sum + sum) < ldividend) {
            sum += sum;
            multiple += multiple;
        }
        
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}