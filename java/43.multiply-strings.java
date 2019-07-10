class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return null;
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n = num1.length();
        int m = num2.length();
        int[] result = new int[n + m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int product = (num1.charAt(num1.length() - 1 - i) - '0') * (num2.charAt(num2.length() - 1 - j) - '0');
                int pos1 = i + j;
                int pos2 = i + j + 1;
                product += result[pos1];
                result[pos1] = product % 10;
                result[pos2] += product / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean print = false;
        for (int i = result.length - 1; i >= 0 ; i--) {
            if (result[i] != 0) {
                print = true;
            }
            if (print) {
                sb.append(result[i]);
            }
        }
        return sb.toString();
    }
}