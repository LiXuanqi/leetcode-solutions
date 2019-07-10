class Solution {
    public String toGoatLatin(String S) {
        if (S == null || S.length() == 0) {
            return S;
        }
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e'); 
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        String[] words = S.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder sb = new StringBuilder();
            // vowel
            if (vowels.contains(Character.toLowerCase(word.charAt(0)))) {
                sb.append(word);
                sb.append("ma");
            } else {
                sb.append(word.substring(1));
                sb.append(word.charAt(0));
                sb.append("ma");
            }
            // add 'a' at tail.
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            result.append(sb.toString());
            result.append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}