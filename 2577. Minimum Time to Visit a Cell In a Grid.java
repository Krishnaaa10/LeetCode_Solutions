import java.util.PriorityQueue;

class Solution {
    public int minimumTime(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        if (Math.min(grid[0][1], grid[1][0]) > 1) {
            return -1;
        }
        int[][] minTimeToReach = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                minTimeToReach[i][j] = Integer.MAX_VALUE;
            }
        }
        minTimeToReach[0][0] = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        priorityQueue.offer(new int[]{0, 0, 0});
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentTime = current[0], currentRow = current[1], currentCol = current[2];
            if (currentRow == rows - 1 && currentCol == cols - 1) {
                return currentTime;
            }
            if (currentTime != minTimeToReach[currentRow][currentCol]) {
                continue;
            }
            for (int[] direction : directions) {
                int newRow = currentRow + direction[0], newCol = currentCol + direction[1];
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols) {
                    continue;
                }
                int newTime = Math.max(currentTime + 1, grid[newRow][newCol] + 1 - (grid[newRow][newCol] - currentTime) % 2);
                if (newTime >= minTimeToReach[newRow][newCol]) {
                    continue;
                }
                minTimeToReach[newRow][newCol] = newTime;
                priorityQueue.offer(new int[]{newTime, newRow, newCol});
            }
        }
        return -1;
    }
}