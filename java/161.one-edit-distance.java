class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        int sLength = s.length();
        int tLength = t.length();
        if (Math.abs(sLength - tLength) > 1) {
            return false;
        }
        return delete(s, t) || delete(t, s) || replace(s, t);   
    }
    private boolean delete(String s, String t) {
        if (s.length() >= t.length()) {
            return false;
        }
        int slow = 0;
        int fast = 0;
        boolean flag = false;
        while (fast < t.length() && slow < s.length()) {
            if (s.charAt(slow) != t.charAt(fast)) {
                if (flag) {
                    return false;
                }
                fast++;
                flag = true;
            } else {
                fast++;
                slow++;
            }
        }
        return true;
    }
    private boolean replace(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (flag) {
                    return false;
                } else {
                    flag = true;
                }
            }
        }
        return flag;
    }
}