import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        String[] tokens;

        int n = Integer.parseInt(br.readLine()); // 한 줄 입력 후 정수 변환
        tokens = br.readLine().split(" ");

        int[] arr = new int[tokens.length];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
            arr[i] = arr[i] - (n - i);
        }

        int max = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println(max);

        br.close(); // BufferedReader 닫기
    }
}
