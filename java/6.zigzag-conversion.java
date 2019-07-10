class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        boolean direction = true;
        int line = 0;
        for (int i = 0; i < s.length(); i++) {
            if (direction) {
                list.get(line++).append(s.charAt(i));
                if (line >= numRows - 1) {
                    direction = !direction;
                }
            } else {
                list.get(line--).append(s.charAt(i));
                if (line <= 0) {
                    direction = !direction;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder item : list) {
            sb.append(item.toString());
        }
        return sb.toString();
    }
}