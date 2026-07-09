class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length;
        int n = trainers.length;
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (players[i] > trainers[j]) {
                j++;
            }
            else {
                count++;
                i++;
                j++;
            }
        }
        return count;
    }
}