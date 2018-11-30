class Solution {
    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0 || K <= 0) {
            return "";
        }
        int i = S.length() - 1;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            if (S.charAt(i) == '-') {
                i--;
                continue;
            }
            if (count == K) {
                sb.append('-');
                count = 0;
                continue;
            }
            sb.append(Character.toUpperCase(S.charAt(i)));
            i--;
            count++;
        }
        return sb.reverse().toString();
    }
}