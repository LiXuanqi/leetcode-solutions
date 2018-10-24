class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonPrefix = findCommonPrefix(commonPrefix, strs[i]);
        }
        return commonPrefix;
    }
    private String findCommonPrefix(String str1, String str2) {
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length() && str1.charAt(i) == str2.charAt(j)) {
            count++;
            i++;
            j++;
        }
        return str1.substring(0, count);
    }
}