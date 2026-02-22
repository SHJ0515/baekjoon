import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] nge = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<int[]> stack = new Stack<>();    //int[] {idx, num}

        for (int i = 0; i < n; i++) {
            int idx = i;
            int num = Integer.parseInt(st.nextToken());

            //스택의 top 보다 큰 수를 만나면 스택의 top의 nge는 현재 num
            while (!stack.empty() && stack.peek()[1] < num) {
                nge[stack.peek()[0]] = num;
                stack.pop();
            }

            stack.push(new int[]{idx, num});
        }

        // 스택에 수가 남아있다면 이 수들은 nge를 안가짐 
        for (int[] ints : stack) {
            nge[ints[0]] = -1;
        }

        for (int i1 : nge) {
            sb.append(i1 + " ");
        }
        System.out.println(sb);

        bw.flush();
        bw.close();
    }
}