class Solution {
    public int solution(int n, int w, int num) {
        int height = (n + w - 1) / w;
        int[][] boxes = new int[height][w];

        int boxNumber = 1;
        boolean leftToRight = true;

        for (int row = 0; row < height && boxNumber <= n; row++) {
            if (leftToRight) {
                for (int col = 0; col < w && boxNumber <= n; col++) {
                    boxes[row][col] = boxNumber++;
                }
            } else {
                for (int col = w - 1; col >= 0 && boxNumber <= n; col--) {
                    boxes[row][col] = boxNumber++;
                }
            }

            leftToRight = !leftToRight;
        }

        return countBoxesToRemove(boxes, num);
    }

    private int countBoxesToRemove(int[][] boxes, int num) {
        int height = boxes.length;
        int width = boxes[0].length;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (boxes[row][col] == num) {
                    return countAbove(boxes, row, col);
                }
            }
        }

        return 0;
    }

    private int countAbove(int[][] boxes, int startRow, int col) {
        int count = 0;

        for (int row = startRow; row < boxes.length; row++) {
            if (boxes[row][col] != 0) {
                count++;
            }
        }

        return count;
    }
}