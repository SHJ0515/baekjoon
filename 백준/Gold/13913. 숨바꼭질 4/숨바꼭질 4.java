import java.util.*;
import java.io.*;

public class Main {

    static int[] visited = new int[100001];
    static int[] before = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        findPath(n, k);

        br.close();
    }

    public static void findPath(int n, int k) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{n, 0});
        visited[n] = 1;
        before[n] = n;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if (poll[0] == k) {
                System.out.println(poll[1]);

                int tmp = poll[0];

                Deque<Integer> deque = new ArrayDeque<>();
                while (tmp != n) {
                    deque.addFirst(tmp);
                    tmp = before[tmp];
                }
                deque.addFirst(n);
                while (!deque.isEmpty()) {
                    Integer i = deque.pollFirst();
                    System.out.print(i + " ");
                }
                return;
            }

            int[] nextMove = new int[]{poll[0] - 1, poll[0] + 1, poll[0] * 2};
            for (int i = 0; i < 3; i++) {
                int next = nextMove[i];
                if (next >= 0 && next < 100001) {
                    if (visited[next] == 0) {
                        queue.add(new int[]{next, poll[1] + 1});
                        visited[next] = 1;
                        before[next] = poll[0];
                    }
                }
            }
        }
    }
}