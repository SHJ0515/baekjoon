
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> card = new HashMap<>();

        String[] tokens = br.readLine().split(" ");

        for (String token : tokens) {
            int num = Integer.parseInt(token);

            if (card.containsKey(num)){
                int count = card.get(num) + 1;
                card.replace(num, count);
            }
            else {
                card.put(num, 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        String[] targets = br.readLine().split(" ");

        for (String target : targets) {
            int num = Integer.parseInt(target);
            sb.append(card.getOrDefault(num, 0) + " ");
        }

        sb.append("\n");

        System.out.println(sb);

        br.close();
        bw.close();
    }
}