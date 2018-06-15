class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || haystack == null || haystack.length() < needle.length()) {
            return -1;
        }
        int m = needle.length();
        if (m == 0 && haystack != null) {
            return 0;
        }
        
        int mod = 1000000;
        
        int targetCode = 0;
        for (int i = 0; i < m; ++i) {
            targetCode = (targetCode * 33 + needle.charAt(i)) % mod;
        }
        
        //33^m
        int m33 = 1;
        // why m - 1 !!!
        for (int i = 0; i < m - 1; ++i) {
            m33 = m33 * 33 % mod;
        }
        
        int n = haystack.length();
        int hashCode = 0;
        for (int i = 0; i < n; ++i) {
            // abcd - a
            if (i >= m) {
                hashCode = hashCode - m33 * haystack.charAt(i - m) % mod;
            }
            
            if (hashCode < 0) {
                hashCode += mod;
            }
            
            hashCode = (hashCode * 33 + haystack.charAt(i)) % mod;
            
            if (i >= m - 1 && hashCode == targetCode) {
                if (needle.equals(haystack.substring(i - m + 1, i + 1))) {
                    return i - m + 1;
                }
            }
        }     
        return -1;      
    }
}