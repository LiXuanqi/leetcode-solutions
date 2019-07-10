class Solution {
    String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(toMorseCode(word));
        }
        return set.size();
    }
    private String toMorseCode(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            sb.append(codes[word.charAt(i) - 'a']);
        }
        return sb.toString();
    }
}