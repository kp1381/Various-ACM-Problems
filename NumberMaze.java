import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
/*
 * Problem Description: http://uva.onlinejudge.org/external/9/929.pdf
 * Author: Konstantin Petrov
 */
public class NumberMaze {
 
    static class Thing implements Comparable<Thing> {
        int x;
        int y;
        int total;
        public Thing(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.total = t; 
        }
        @Override
        public int compareTo(Thing o) {
            return this.total - o.total;
        }
 
    }
 
    static int m;
    static int n;
    static int[][] maze = new int[1000][1000];
    static int[] moveX = { 0, 0, 1, -1 };
    static int[] moveY = { 1, -1, 0, 0 };
    static int[][] sum = new int[1000][1000];
     
     
    static boolean isValid(int i, int j){
        return i >=0 && i < n && j >=0 && j < m;
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCases = Integer.parseInt(br.readLine());
        String[] temp1;
 
        for (int i = 0; i < numCases; i++) {
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                temp1 = br.readLine().split(" ");
                for (int k = 0; k < m; k++){
                    maze[j][k] = Integer.parseInt(temp1[k]);
                    sum[j][k] = 1000000000;
                }
            }
            PriorityQueue<Thing> queue = new PriorityQueue<Thing>();
            Thing first = new Thing(0, 0, maze[0][0]);
            queue.add(first);
            sum[0][0] = maze[0][0];
             
            while (!queue.isEmpty()) {
                Thing curr = queue.poll();
                if (curr.x == n - 1 && curr.y == m - 1)
                    System.out.println(curr.total);
                else if(curr.total == sum[curr.x][curr.y])
                for (int j = 0; j < 4; j++) {
                    int x = curr.x + moveX[j];
                    int y = curr.y + moveY[j];
                    if(isValid(x, y) && (curr.total + maze[x][y]) < sum[x][y]){
                        Thing newEl = new Thing(x, y, curr.total + maze[x][y]);
                        sum[x][y] = newEl.total;
                        queue.add(newEl);
                    }
                }
            }
        }
    }
}