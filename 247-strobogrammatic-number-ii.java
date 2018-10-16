class Solution {
    public List<String> findStrobogrammatic(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return dfs(n, n);
    }
    private List<String> dfs(int n, int m) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(new String[] {""}));
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList(new String[] {"0", "1", "8"}));
        }
        List<String> list = dfs(n - 2, m);
        List<String> result = new ArrayList<>();
      
        for (int i = 0; i < list.size(); i++) {
            // not add '0' at head
            if (n != m) {
                result.add("0" + list.get(i) + "0");
            }
            result.add("1" + list.get(i) + "1");
            result.add("6" + list.get(i) + "9");
            result.add("8" + list.get(i) + "8");
            result.add("9" + list.get(i) + "6");      
        }
        return result;
      
    } 
}