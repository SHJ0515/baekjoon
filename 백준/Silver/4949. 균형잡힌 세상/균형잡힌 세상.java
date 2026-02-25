import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            Deque<Character> stack = new ArrayDeque<>();
            String s = br.readLine();
            boolean isBalanced = true;

            if (s.equals(".")) {
                break;
            }

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '.') {
                    break;
                }

                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                    continue;
                }
                else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                    else {
                        isBalanced = false;
                        break;
                    }
                }
                else if (c == '}') {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    }
                    else {
                        isBalanced = false;
                        break;
                    }
                }
                else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    }
                    else {
                        isBalanced = false;
                        break;
                    }
                }
            }

            if (!stack.isEmpty()) {
                isBalanced = false;
            }

            if (isBalanced){
                sb.append("yes").append('\n');
            }
            else {
                sb.append("no").append('\n');
            }
        }

        System.out.println(sb);

        bw.flush();
        bw.close();
    }
}