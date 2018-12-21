class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null || list1.length == 0 || list2.length == 0) {
            return null;
        }
        int minIndexSum = Integer.MAX_VALUE;
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int sum = i + map.get(list2[i]);
                if (sum < minIndexSum) {
                    minIndexSum = sum;
                    ans = new ArrayList<>();
                    ans.add(list2[i]);
                } else if (sum == minIndexSum) {
                    ans.add(list2[i]);
                }
            }
        }

        return ans.stream().toArray(String[]::new);
    }
}