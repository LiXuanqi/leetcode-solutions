class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        if (numRows <= 0) {
            return results;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            if (i == 0) {
                row.add(1);
                results.add(row);
                continue;
            }
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    List<Integer> lastRow = results.get(i - 1);
                    row.add(lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            results.add(row);
        }
        return results;
    }
}