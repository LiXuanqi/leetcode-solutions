class Solution {
    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null) {
            return false;
        }
        if (S.length() == 0 && T.length() == 0) {
            return true;
        }
        if (S.length() == 0) {
            return false;
        }
        if (T.length() == 0) {
            return false;  
        }
        int pointerS = S.length() - 1;
        int pointerT = T.length() - 1;
        int backTimeS = 0;
        int backTimeT = 0;

        while (pointerS >= 0 || pointerT >= 0) {
            while (pointerS >= 0) {
                if (S.charAt(pointerS) == '#') {
                    pointerS--;
                    backTimeS++;
                } else if (backTimeS > 0) {
                    pointerS--;
                    backTimeS--;
                } else {
                    break;
                }
            }
            while (pointerT >= 0) {
                if (T.charAt(pointerT) == '#') {
                    pointerT--;
                    backTimeT++;
                } else if (backTimeT > 0) {
                    pointerT--;
                    backTimeT--;
                } else {
                    break;
                }
            }
            // compare 
            if (pointerT >= 0 && pointerS >= 0 && S.charAt(pointerS) != T.charAt(pointerT)) {
                return false;
            }
            if ((pointerT >= 0) != (pointerS >= 0)) {
                return false;
            }
            pointerS--;
            pointerT--;
        }
   
        return true;
       
    }
}