class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < (s.length() - 1) && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                result = result - map.get(s.charAt(i));
            } else {
                result = result + map.get(s.charAt(i));
            }
        }
        return result;
    }
}