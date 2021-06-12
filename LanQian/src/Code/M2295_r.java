package Code;

import java.util.LinkedList;
import java.util.Scanner;
 
/**
 * Hello world!
 */
 
public class M2295_r {
 
    static boolean move(
    		byte[][] maze, int[][] status, int n, int k, LinkedList<Integer[]> queue, int x, int y,int step, int energy, boolean has_energy) {
        do {
            if ('#' == maze[y][x]) {
                break;
            } else if ('%' == maze[y][x]) {
                energy = k;
                maze[y][x] = '#';
            } else if ('X' == maze[y][x]) {
                if (!has_energy)
                    break;
            } else if ('.' == maze[y][x]) {
            }
            if (energy > 0) {
                if (step < status[y][x])
                    status[y][x] = step;
                queue.add(new Integer[] { x, y, step, energy });
            } else {
                if (step < status[y][x]) {
                    status[y][x] = step;
                    queue.add(new Integer[] { x, y, step, energy });
                }
            }
            if (x == n - 1 && y == n - 1) {
                return true;
            }
        } while (false);
        return false;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N x N {min, {min, energy}}
        byte[][] maze;
        int[][] status;
        int n = sc.nextInt();
        int k = sc.nextInt();
        status = new int[n][n];
        maze = new byte[n][n];
        sc.nextLine();
        for (int i = 0; i < n; ++i) {
            String line = sc.nextLine();
            char[] l = line.toCharArray();
            for (int j = 0; j < l.length; ++j) {
                maze[i][j] = (byte) l[j];
 
                status[i][j] = Integer.MAX_VALUE;
 
            }
        }
 
        LinkedList<Integer[]> queue = new LinkedList<Integer[]>();
        status[0][0] = 0;
        queue.add(new Integer[] { 0, 0, 0, '%' == maze[0][0] ? k : 0 });
        int curr_step = 0, n2 = n * n;
        while (curr_step < n2 && !queue.isEmpty()) {
            Integer[] curr = queue.remove();
            int x, y, step = curr[2] + 1, energy = curr[3] - 1;
            x = curr[0];
            y = curr[1];
            boolean has_energy = energy >= 0;
            if (energy < 0)
                energy = 0;
 
            curr_step = step;
 
            // Move up;
            x = curr[0];
            y = curr[1] - 1;
            if (y >= 0) {
                if (move(maze, status, n, k, queue, x, y, step, energy, has_energy)) {
                    System.out.println(step);
                    return;
                }
            }
            // Move right;
            x = curr[0] + 1;
            y = curr[1];
            if (x < n) {
                if (move(maze, status, n, k, queue, x, y, step, energy, has_energy)) {
                    System.out.println(step);
                    return;
                }
            }
            // Move down;
            x = curr[0];
            y = curr[1] + 1;
            if (y < n) {
                if (move(maze, status, n, k, queue, x, y, step, energy, has_energy)) {
                    System.out.println(step);
                    return;
                }
            }
            // Move left;
            x = curr[0] - 1;
            y = curr[1];
            if (x >= 0) {
                if (move(maze, status, n, k, queue, x, y, step, energy, has_energy)) {
                    System.out.println(step);
                    return;
                }
            }
 
        }
        System.out.println(-1);
        return;
    }
}