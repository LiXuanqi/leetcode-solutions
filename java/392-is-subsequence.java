class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        int i = 0;
        int j = 0;
        // System.out.println("in");
        while (i < s.length() && j < t.length()) {
            char target = s.charAt(i);
            while (j < t.length() && t.charAt(j) != target) {
                j++;
            }
            if (j < t.length() && t.charAt(j) == target) {
                i++;
                j++;
            }
         
        }
        // System.out.println(i);
        if (i == s.length()) {
            return true;
        }
        return false;
    }
}