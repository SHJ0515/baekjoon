import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        Deque<Integer> stack = new ArrayDeque<>();
        boolean flag = true;

        // '(' = -1, '[' = -2
        for (int i = 0; i < s.length(); i++) {
            if (!flag) {
                break;
            }
            char c = s.charAt(i);

            if (c == '(' || c == '[') {
                stack.addFirst(c == '(' ? -1 : -2);
            }
            else if (c == ')') {
                int tmp = 0;
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                }
                while (true) {
                    Integer i1 = stack.pollFirst();
                    if (i1 == null) {
                        flag = false;
                        break;
                    }
                    else if (i1 == -1) {
                        if (tmp == 0) {
                            stack.addFirst(2);
                            break;
                        }
                        else {
                            tmp = tmp * 2;
                            stack.addFirst(tmp);
                            break;
                        }
                    }
                    else if (i1 == -2) {
                        flag = false;
                        break;
                    }
                    else {
                        tmp += i1;
                    }
                }
            }
            else if (c == ']') {
                int tmp = 0;
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                }

                while (true) {
                    Integer i1 = stack.pollFirst();
                    if (i1 == null) {
                        flag = false;
                        break;
                    }
                    else if (i1 == -2) {
                        if (tmp == 0) {
                            stack.addFirst(3);
                            break;
                        }
                        else {
                            tmp = tmp * 3;
                            stack.addFirst(tmp);
                            break;
                        }
                    }
                    else if (i1 == -1) {
                        flag = false;
                        break;
                    }
                    else {
                        tmp += i1;
                    }
                }
            }
        }

        for (Integer i : stack) {
            if (i == -1 || i == -2){
                flag = false;
                break;
            }
        }

        if (flag){
            int tmp = 0;
            for (Integer i : stack) {
                tmp += i;
            }
            System.out.println(tmp);
        }
        else {
            System.out.println(0);
        }

        bw.flush();
        bw.close();
    }
}
