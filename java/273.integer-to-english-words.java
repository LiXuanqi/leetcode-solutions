class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] UNITS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) {
           return "Zero"; 
        }
        String word = "";
        int count = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                word = sayNumber(num % 1000) + UNITS[count] + " " + word;
            }
            // System.out.println(word);
            count++;
            num /= 1000;
        }
        return word.trim();
    }
    private String sayNumber(int num) {
        if (num == 0) {
            return "";
        }
        if (num < 20) {
            return LESS_THAN_20[num] + " ";
        }
        if (num < 100) {
            return TENS[num / 10] +  " " + sayNumber(num % 10);
        }
        return LESS_THAN_20[num / 100] + " Hundred " + sayNumber(num % 100);
    }
}

// Input: 1,234,567,891
// Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"