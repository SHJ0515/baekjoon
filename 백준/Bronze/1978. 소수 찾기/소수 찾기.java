import java.io.*;
import java.util.*;


public class Main {

    public static int isDecimal(int x) {
        int cnt = 0;

        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                cnt++;
            }
        }

        if (cnt != 2) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] tokens = br.readLine().split(" ");

        int cnt = 0;

        for (int i = 0; i < tokens.length; i++) {
            int tmp = Integer.parseInt(tokens[i]);

            if (tmp != 1) {
                cnt += isDecimal(tmp);
            }
        }

        System.out.println(cnt);

        br.close(); // BufferedReader 닫기
        //bw.flush();
        //bw.close();
    }
}