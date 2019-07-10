/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if (buf == null || buf.length == 0 || n < 0) {
            return -1;
        }
        boolean eof = false;
        char[] temp = new char[4];
        int total = 0;
        while (!eof && total < n) {
            int count = read4(temp);
            
            eof = count < 4;
            
            count = Math.min(count, n - total);
            
            for (int i = 0; i < count; i++) {
                buf[total++] = temp[i];
            } 
        }
        return total;
    }
}