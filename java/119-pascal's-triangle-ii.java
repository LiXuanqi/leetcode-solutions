class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>(); 
        if (rowIndex == 0) {
            ans.add(1);
            return ans;
        }
        List<Integer> lastRow = getRow(rowIndex - 1);
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0 || i == rowIndex) {
                ans.add(1);
            } else {
                ans.add(lastRow.get(i - 1) + lastRow.get(i));
            }
        }
        return ans;
    }
}