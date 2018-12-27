class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> level = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (i - 1 >= 0 && j - 1 >= 0 && j < ans.get(i - 1).size()) {
                    int left = ans.get(i - 1).get(j - 1);
                    int right = ans.get(i - 1).get(j);
                    level.add(left + right);
                } else {
                    level.add(1);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}