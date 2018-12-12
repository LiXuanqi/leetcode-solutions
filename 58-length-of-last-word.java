class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int i = s.length() - 1;
        int ans = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
            ans++;
        }
        return ans;
    }
}