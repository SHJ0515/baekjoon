import java.util.*;
import java.io.*;

public class Main {

    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        for (int i = 0; i < 100001; i++) {
            visited[i] = -1;
        }
        findPath(n, k);

        br.close();
    }

    public static void findPath(int n, int k) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{n, 0});
        visited[n] = 0;

        //0초 만에 이동 가능 지점
        int tmp = n;
        while (tmp <= 50000 && tmp != 0) {
            tmp *= 2;
            queue.add(new int[]{tmp, 0});
            visited[tmp] = 0;
        }

        int[] nextWalk = new int[]{-1, 1};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int location = poll[0];
            int time = poll[1];

            if (location == k) {
                System.out.println(time);
                return;
            }

            tmp = location;
            while (tmp <= 50000 && tmp != 0) {
                tmp *= 2;
                if (visited[tmp] == -1) {
                    queue.add(new int[]{tmp, time});
                    visited[tmp] = time;
                }
            }
            for (int i = 0; i < 2; i++) {
                int nextLocation = location + nextWalk[i];
                if (nextLocation >= 0 && nextLocation < 100001) {
                    if (visited[nextLocation] == -1) {
                        queue.add(new int[]{nextLocation, time + 1});
                        visited[nextLocation] = time + 1;
                    }
                }
            }
        }
    }
}