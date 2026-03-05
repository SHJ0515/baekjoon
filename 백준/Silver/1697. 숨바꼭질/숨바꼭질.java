import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int[] visited = new int[100001];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{n, 0});     //위치, 시간
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if (poll[0] == k){
                System.out.println(poll[1]);
                break;
            }

            int[] nextMove = new int[]{poll[0] - 1, poll[0] + 1, poll[0] * 2};
            for (int i = 0; i < 3; i++) {
                if (nextMove[i] >= 0 && nextMove[i] <= 100000) {
                    if (visited[nextMove[i]] == 0) {
                        visited[nextMove[i]] = 1;
                        queue.add(new int[]{nextMove[i],poll[1] + 1});
                    }
                }
            }
        }
    }
}