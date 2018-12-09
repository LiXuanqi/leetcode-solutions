class Solution {
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }
        int[] count = new int[26];
        int maxLength = 1;
        for (int i = 0; i < p.length(); i++) {
            if (i != 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || p.charAt(i - 1) - p.charAt(i) == 25)) {
                maxLength++;
            } else {
                maxLength = 1;
            }
            count[p.charAt(i) - 'a'] = Math.max(count[p.charAt(i) - 'a'], maxLength);
        }
        int ans = 0;
        for (int num : count) {
            // System.out.println(num);
            ans += num;
        }
        return ans;
    }
}