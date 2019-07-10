class Solution {
    public String nearestPalindromic(String n) {
        if (n == null || n.length() == 0) {
            return "";
        }
        long[] candidates = new long[5];
        candidates[0] = getAllZeros(n.length() + 1);
        candidates[4] = getAllNines(n.length() - 1);
        // 0 1 2 3 4 5
        String half = n.substring(0, (n.length() + 1) / 2);
        long halfNum = Long.parseLong(half);
        // If there is a tie, return the smaller one as answer.
        candidates[1] = getMirror(halfNum + 1, n.length());
        candidates[2] = getMirror(halfNum, n.length());
        candidates[3] = getMirror(halfNum - 1, n.length());
        return getAbsMin(candidates, Long.parseLong(n));
    }
    private String getAbsMin(long[] candidates, long num) {
        long min = Long.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < candidates.length; i++) {
            long abs = Math.abs(candidates[i] - num);
            if (abs <= min && abs != 0) {
                min = abs;
                ans = i;
            }
        }
        return String.valueOf(candidates[ans]);
    }
    private long getMirror(long halfNum, int length) {
        String half = String.valueOf(halfNum);
        String reverseStr = new StringBuilder(half).reverse().toString();
        String result = "";
        if (length % 2 == 0) {
            result = half + reverseStr;
        } else {
            result = half + reverseStr.substring(1);
        }
        return Long.parseLong(result);
    }
    private long getAllZeros(int size) {
        char[] input = new char[size];
        Arrays.fill(input, '0');
        input[0] = '1';
        input[input.length - 1] = '1';
        return Long.parseLong(new String(input));
    }
    private long getAllNines(int size) {
        if (size <= 0) {
            return Long.MAX_VALUE;
        }
        char[] input = new char[size];
        Arrays.fill(input, '9');
        return Long.parseLong(new String(input));
    }
}