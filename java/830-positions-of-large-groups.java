class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int anchor = 0;
        for (int i = 0; i < S.length(); i++) {
            if (i == S.length() - 1 || S.charAt(i + 1) != S.charAt(anchor)) {
                if (i - anchor + 1 >= 3) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(anchor);
                    pair.add(i);
                    ans.add(pair);
                }
                anchor = i + 1;
            }
        }
        return ans;
    }
}