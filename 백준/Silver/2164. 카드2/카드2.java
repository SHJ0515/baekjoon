import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> queue = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            queue.addLast(i);
        }


        while (queue.size() != 1) {
            queue.pollFirst();
            if (queue.size() != 1) {
                Integer i = queue.pollFirst();
                queue.addLast(i);
            }
        }

        System.out.println(queue.peek());

        bw.flush();
        bw.close();
    }
}