class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            ans = findCommon(ans, strs[i]);
        }
        return ans;
    }
    private String findCommon(String str1, String str2) {
        int i = 0;
        while (i < str1.length() && i < str2.length()) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            i++;
        }
        return str1.substring(0, i);
    }
}