class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack();
        Stack<String> strs = new Stack();
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // read number.
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                nums.push(num);
            } else if (c == '[') {
                strs.push(str);
                str = "";
            } else if (c == ']') {
                int time = nums.pop();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < time; j++) {
                    sb.append(str);
                }
                str = strs.pop() + sb.toString();
            } else {
                str = str + c;
            }
        }
        return str;
    }
}