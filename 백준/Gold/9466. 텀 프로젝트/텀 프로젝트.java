import java.util.*;
import java.io.*;

public class Main {

    static int n, count;
    static int[] pick;
    static boolean[] visited;
    static boolean[] finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            pick = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                pick[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    dfs(j);
                }
            }
            System.out.println(n - count);
        }
    }

    public static void dfs(int current) {
        visited[current] = true;
        int next = pick[current];

        if (!visited[next]) {
            dfs(next);
        }
        else if (!finished[next]) {
            for (int i = next; i != current; i = pick[i]) {
                count++;
            }
            count++;
        }
        finished[current] = true;
    }

}