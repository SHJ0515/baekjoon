import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }
            else {
                stack.push(num);
            }
        }

        int count = 0;

        for (Integer i : stack) {
            count = count+ i;
        }
        System.out.println(count);

        bw.flush();
        bw.close();
    }
}