class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null) {
            return false;
        }
        if (num.length() == 0) {
            return true;
        }
        Set<String> set = new HashSet<>();
        set.add("00");
        set.add("11");
        set.add("88");
        set.add("69");
        set.add("96");
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            if (!set.contains(num.charAt(left) + "" + num.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
   
}