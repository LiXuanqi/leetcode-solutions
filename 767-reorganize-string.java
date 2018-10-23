class Solution {
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }   
        int[] count = new int[26];
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a']++;
        }
        PriorityQueue<Character> heap = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return count[c1 - 'a'] >= count[c2 - 'a'] ? -1 : 1;
            }
        });
        for (char i = 'a'; i <= 'z'; i++) {
            if (count[i - 'a'] > 0) {
                heap.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        char prev = ' ';
        while (!heap.isEmpty()) {
            char one = heap.poll();
            if (one == prev) {
                if (heap.isEmpty()) {
                    return "";
                }
                char two = heap.poll();
                
                count[two - 'a']--;
                sb.append(two);
                heap.offer(one);
                if (count[two - 'a'] > 0) {
                    heap.offer(two);
                }
                prev = two;
     
            } else {
                sb.append(one);
                count[one - 'a']--;
                if (count[one - 'a'] > 0) {
                    heap.offer(one);
                }
                prev = one;
            }
  
        }
        return sb.toString();
    }
}