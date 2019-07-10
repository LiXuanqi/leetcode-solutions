class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        dfs(num, 0, "", 0, target, 0, result);
        return result;
    }
    private void dfs(String num, int index, String temp, int val, int target, int pre, List<String> result) {
        if (index >= num.length()) {
            if (val == target) {
                result.add(temp);
            }
            return;
        }
        if (num.charAt(index) == '0') {
            if (index == 0) {
                dfs(num, index + 1, temp + "0", 0, target, 0, result);
            } else {
                dfs(num, index + 1, temp + "+" + num.charAt(index), val, target, 0, result);
                dfs(num, index + 1, temp + "-" + num.charAt(index), val, target, 0, result);
                dfs(num, index + 1, temp + "*" + num.charAt(index), val - pre, target, 0, result);
            }
        } else {
            // read number.
            for (int i = index; i < num.length(); i++) {
                long lnum = Long.parseLong(num.substring(index, i + 1));
                if (lnum > Integer.MAX_VALUE) {
                    break;
                }
                int n = (int) lnum;
                if (index == 0) {
                    dfs(num, i + 1, temp + n, n, target, n, result);
                } else {
                    dfs(num, i + 1, temp + "+" + n, val + n, target, n, result);
                    dfs(num, i + 1, temp + "-" + n, val - n, target, -n, result);
                    dfs(num, i + 1, temp + "*" + n, val - pre + pre * n, target, pre * n, result);
                }
            }
        }
    }
}