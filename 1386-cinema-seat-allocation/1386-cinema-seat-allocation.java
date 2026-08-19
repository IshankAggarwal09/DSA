class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, boolean[]> map = new HashMap<>();
        for (int[] pos : reservedSeats) {
            if (!map.containsKey(pos[0])) {
                map.put(pos[0], new boolean[11]);
            }
            map.get(pos[0])[pos[1]] = true;
        }
        int count = 2 * (n-map.size());
        for (int i : map.keySet()){
            boolean[] row = map.get(i);
            if(!row[2] && !row[3] && !row[4] && !row[5]) {
                if(!row[6] && !row[7] && !row[8] && !row[9]) {
                    count += 2;
                }
                else {
                    count++;
                }
            } 
            else if(!row[4] && !row[5] && !row[6] && !row[7]) {
                count++;
            }
            else if(!row[6] && !row[7] && !row[8] && !row[9]) {
                count++;
            }
        }
        return count;
    }
}