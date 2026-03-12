package main.java;
import java.util.LinkedList;
import java.util.Queue;

class NodeCell {
    int row;
    int col;

    NodeCell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class BFSGrid {

    // BFS function
    public static boolean bfs(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // If start or end is blocked
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return false;
        }

        boolean[][] visited = new boolean[n][m];

        Queue<NodeCell> queue = new LinkedList<>();
        queue.add(new NodeCell(0, 0));
        visited[0][0] = true;

        // 4 directions: up, down, left, right
        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            NodeCell current = queue.poll();

            // If destination reached
            if (current.row == n - 1 && current.col == m - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {

                int newRow = current.row + rowDir[i];
                int newCol = current.col + colDir[i];

                if (isValid(grid, newRow, newCol, visited)) {
                    visited[newRow][newCol] = true;
                    queue.add(new NodeCell(newRow, newCol));
                }
            }
        }

        return false; // No path found
    }

    private static boolean isValid(int[][] grid, int row, int col, boolean[][] visited) {
        return row >= 0 &&
               col >= 0 &&
               row < grid.length &&
               col < grid[0].length &&
               grid[row][col] == 0 &&
               !visited[row][col];
    }

    public static void main(String[] args) {

        int[][] grid = {
            {0, 0, 1},
            {0, 0, 0},
            {1, 0, 0}
        };

        System.out.println(bfs(grid));
    }
}