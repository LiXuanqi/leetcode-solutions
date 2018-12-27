class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        // int[] => String[]
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = "" + nums[i];
        }
        Arrays.sort(strs, (str1, str2) -> {
            // "30" and "3"
            return (str2 + str1).compareTo(str1 + str2);
        });
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        
        String ans = sb.toString();
        // "ans = 000"
        int i = 0;
        while (i < ans.length() - 1 && ans.charAt(i) == '0') {
            i++;
        }
        return ans.substring(i);
    }
}