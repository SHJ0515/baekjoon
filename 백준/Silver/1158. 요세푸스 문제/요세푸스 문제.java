import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        List<Integer> list = new ArrayList<>();

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.add(i + 1);
        }

        while (!deque.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                Integer tmp = deque.pollFirst();
                deque.addLast(tmp);
            }
            Integer i = deque.pollFirst();
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append('>');

        System.out.println(sb);

        bw.flush();
        bw.close();
    }
}