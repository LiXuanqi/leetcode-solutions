class Solution {
    public String addBinary(String a, String b) {
        if (a == null && b == null) {
            return null;
        }
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        int pointerA = a.length() - 1;
        int pointerB = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (pointerA >= 0 && pointerB >= 0) {
            int sum = a.charAt(pointerA) - '0' + b.charAt(pointerB) - '0' + count;
            count = sum / 2;
            sum = sum % 2;
            sb.insert(0, sum);
            pointerA--;
            pointerB--;
        }
        while (pointerA >= 0) {
            int sum = a.charAt(pointerA) - '0' + count;
            count = sum / 2;
            sum = sum % 2;
            sb.insert(0, sum);
            pointerA--;
        }
        while (pointerB >= 0) {
            int sum = b.charAt(pointerB) - '0' + count;
            count = sum / 2;
            sum = sum % 2;
            sb.insert(0, sum);
            pointerB--;
        }
        if (count != 0) {
            sb.insert(0, count);
        }
        return sb.toString();
    }
}