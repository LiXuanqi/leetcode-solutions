class Solution {
    public String longestCommonPrefix(String[] strs) {
       if (strs == null || strs.length == 0) {
           return "";
       }
        String commonPrefix = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (!strs[i].startsWith(commonPrefix)) {
                commonPrefix = commonPrefix.substring(0, commonPrefix.length() - 1);
            }
            i++;
        }
        return commonPrefix;
    }
}