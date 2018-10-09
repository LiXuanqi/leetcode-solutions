class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || abbr == null) {
            return false;
        }
        return isValidWordAbbr(word, 0, abbr, 0);
    }
    private boolean isValidWordAbbr(String word, int wordStart, String abbr, int abbrStart) {
        if (wordStart == word.length() && abbrStart == abbr.length()) {
            return true;
        }
        if (wordStart >= word.length() || abbrStart >= abbr.length()) {
            return false;
        }
     
        if (!Character.isDigit(abbr.charAt(abbrStart))) {
            if (word.charAt(wordStart) != abbr.charAt(abbrStart)) {
                return false;
            }
            return isValidWordAbbr(word, wordStart + 1, abbr, abbrStart + 1);
        } else {
            int numberOfDigits = getNumberOfDigits(abbr, abbrStart);
            // System.out.println(numberOfDigits);
  
            if (numberOfDigits == 0) {
                return false;
            }
            
            return isValidWordAbbr(word, wordStart + numberOfDigits, abbr, abbrStart + Integer.toString(numberOfDigits).length());
        }
    }
    private int getNumberOfDigits(String abbr, int index) {
        int count = 0;
        int start = index;
        while (start < abbr.length() && Character.isDigit(abbr.charAt(start))) {
            count++;
            start++;
        }
        return Integer.parseInt(abbr.substring(index, index + count));
    }
}