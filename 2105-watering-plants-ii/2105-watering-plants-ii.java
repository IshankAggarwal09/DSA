class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int aliceSide = 0;
        int bobSide = n-1;
        int count = 0;
        int tempA = capacityA;
        int tempB = capacityB;
        while (aliceSide < bobSide) {
            if (tempA < plants[aliceSide]) {
                tempA = capacityA;
                count++;
            }
            tempA = tempA - plants[aliceSide];
            aliceSide++;
            if (tempB < plants[bobSide]) {
                tempB = capacityB;
                count++;
            }
            tempB = tempB - plants[bobSide];
            bobSide--;
        }
        if (aliceSide == bobSide) {
            if (Math.max(tempA, tempB) < plants[aliceSide]) {
                count++;
            }
        }
        return count;
    }
}