class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>();
        for (String word : banned) {
            ban.add(word.toLowerCase());
        }
        Map<String, Integer> map = new HashMap<>();
        String[] words = splitWord(paragraph);
        int maxTime = 0;
        String maxWord = "";
        for (String word : words) {
            String w = word.toLowerCase();
            if (ban.contains(w)) {
                continue;
            }
            map.put(w, map.getOrDefault(w, 0) + 1);
            int num = map.get(w);
            if (num > maxTime) {
                maxWord = w;
                maxTime = num;
            }
        }
        return maxWord;
    }
    private String[] splitWord(String str) {
        int left = 0;
        int right = 0;
        List<String> list = new ArrayList<>();
        while (right < str.length()) {
            // find letter
            while (left < str.length() && !Character.isLetter(str.charAt(left))) {
                left++;
            }
            while (right < str.length() && Character.isLetter(str.charAt(right))) {
                right++;
            }
            if (left < right) {
                list.add(str.substring(left, right).toLowerCase());
                System.out.println(str.substring(left, right).toLowerCase());
            }
            right++;
            left = right; 
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
            // System.out.println(ans[i]);
        }
        return ans;
        
    }
}