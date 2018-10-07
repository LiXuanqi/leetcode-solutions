class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            n--;
            int mod = n % 26;
            sb.append(intToChar(mod));
            n = n / 26;
        }
        return sb.reverse().toString();
    }
    private char intToChar(int num) {
        return (char) (num + 'A');
    }
}