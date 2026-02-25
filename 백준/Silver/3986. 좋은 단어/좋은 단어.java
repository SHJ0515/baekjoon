import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {

            String s = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            boolean isGood = true;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (stack.isEmpty()){
                    stack.push(c);
                }
                else if (stack.peek() == c) {
                    stack.pop();
                }
                else if (stack.peek() != c) {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()){
                cnt++;
            }
        }

        System.out.println(cnt);

        bw.flush();
        bw.close();
    }
}