class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int count = 0;
        for (int m=1; m<=12; m++) {
            for (int d=1; d<=days[m-1]; d++) {
                String today = String.format("%02d-%02d", m, d);
                boolean alice = arriveAlice.compareTo(today) <= 0 && today.compareTo(leaveAlice) <= 0;
                boolean bob = arriveBob.compareTo(today) <= 0 && today.compareTo(leaveBob) <= 0;
                if (alice && bob) {
                    count++;
                }
            }
        }
        return count;
    }
}