class Solution {
    public boolean canAliceWin(int n) {
        int stones = 10;
        boolean isAliceTurn = true;
        while (n >= stones) {
            n -= stones;
            stones--;
            isAliceTurn = !isAliceTurn;
        }
        return !isAliceTurn;
    }
}