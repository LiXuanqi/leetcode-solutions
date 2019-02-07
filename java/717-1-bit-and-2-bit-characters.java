class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) {
            return false;
        }
        Set<String> set = new HashSet<>();
        set.add("10");
        set.add("11");
        set.add("0");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bits.length - 1; i++) {
            sb.append(bits[i]);
        }
        return canMatch(sb.toString(), 0, set);
    }
    private boolean canMatch(String str, int start, Set<String> set) {
        if (start >= str.length()) {
            return true;
        }
        boolean result = false;
        if (set.contains(str.substring(start, start + 1)) && canMatch(str, start + 1, set)) {
            result = true;
        }
        if (start < str.length() - 1 && set.contains(str.substring(start, start + 2)) && canMatch(str, start + 2, set)) {
            result = true;
        }
        return result;
    }
}