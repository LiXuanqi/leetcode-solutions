class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0) {
            return true;
        }
        if (magazine == null || magazine.length() == 0) {
            return false;
        }
        int[] map = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            map[index] += 1;
        }
        for (int j = 0; j < ransomNote.length(); j++) {
            int targetIndex = ransomNote.charAt(j) - 'a';
            if (map[targetIndex] <= 0) {
                return false;
            }
            map[targetIndex] -= 1;
        }
        return true;
    }
}

// Time = O(m+n);
// Space = O(26) = O(1);