import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] strings = br.readLine().split("");
            boolean b = checkVPS(strings);

            if (b) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }

        br.close();
        bw.close();
    }

    private static boolean checkVPS(String[] strs) {
        Deque<String> stack = new ArrayDeque<>();

        for (String str : strs) {
            if (str.equals("(")) {
                stack.push(str);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}