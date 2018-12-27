class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String ans = null;
        for (String str : strs) {
            ans = findCommon(ans, str);
        }
        return ans;
    }
    private String findCommon(String str1, String str2) {
        if (str1 == null) {
            return str2;
        }
        int i = 0;
        while (i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i)) {
            i++;
        }
        return str1.substring(0, i);
    }
}