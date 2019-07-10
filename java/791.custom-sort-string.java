class Solution {
    public String customSortString(String S, String T) {
        if (S == null || T == null || S.length() == 0) {
           return T; 
        }
     
        int[] map = new int[26];
        for (int i = 0; i < T.length(); i++) {
            map[T.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int j = 0; j < S.length(); j++) {
            int position = S.charAt(j) - 'a';
            for (int i = 0; i < map[position]; i++) {
         
                sb.append(S.charAt(j));
            }
            map[position] = 0;
        }
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        
        return sb.toString();
    }
}