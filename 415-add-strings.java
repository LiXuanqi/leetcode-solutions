class Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null && num2 == null) {
            return null;
        }
        if (num1 == null) {
            return num2;
        }
        if (num2 == null) {
            return num1;
        }
        StringBuilder result = new StringBuilder();
        int pointer1 = num1.length() - 1;
        int pointer2 = num2.length() - 1;
        int count = 0;
        while (pointer1 >= 0 && pointer2 >= 0) {
            int sum = num1.charAt(pointer1) - '0' + num2.charAt(pointer2) - '0' + count;
            count = sum / 10;
            sum %= 10;
            result.append(Integer.toString(sum));
            pointer1--;
            pointer2--;
        }
        while (pointer1 >= 0) {
            int sum = num1.charAt(pointer1) - '0' + count;
            count = sum / 10;
            sum %= 10;
            result.append(Integer.toString(sum));
            pointer1--;
        }
        while (pointer2 >= 0) {
            int sum = num2.charAt(pointer2) - '0' + count;
            count = sum / 10;
            sum %= 10;
            result.append(Integer.toString(sum));
            pointer2--;
        }
        if (count != 0) {
           result.append(count); 
        }
        return result.reverse().toString();
    }

}