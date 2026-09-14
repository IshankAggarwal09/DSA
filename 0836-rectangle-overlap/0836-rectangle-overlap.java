class Solution {
    public boolean isRectangleOverlap(int[] rect1, int[] rect2) {
        final int rect1x1 = rect1[0];
        final int rect1y1 = rect1[1];
        final int rect1x2 = rect1[2];
        final int rect1y2 = rect1[3];
        final int rect2x1 = rect2[0];
        final int rect2y1 = rect2[1];
        final int rect2x2 = rect2[2];
        final int rect2y2 = rect2[3];
        return !(
            rect1x2 <= rect2x1 ||
            rect1x1 >= rect2x2 ||
            rect1y2 <= rect2y1 ||
            rect1y1 >= rect2y2
        );
    }
}