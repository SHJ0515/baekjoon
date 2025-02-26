import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int count = Integer.parseInt(br.readLine());
            int walk = 0;
            String[] line = br.readLine().split(" ");
            int[] times = new int[line.length];

            for (int j = 0; j < line.length; j++) {
                times[j] = Integer.parseInt(line[j]);
            }

            // 무조건 산책 완료
            if (times[times.length - 1] <= 1200 || times[0] >= 240) {
                System.out.println("YES");
                continue;
            }

            if (times[0] >= 120) {
                walk += 1;
            }

            if (times[times.length - 1] <= 1320) {
                walk += 1;
            }

            for (int j = 0; j < line.length - 1; j++) {
                if (times[j + 1] - times[j] >= 240) {
                    walk += 2;
                }
                else if (times[j + 1] - times[j] >= 120) {
                    walk += 1;
                }
            }

            if (walk >= 2) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }

        br.close(); // BufferedReader 닫기
        bw.flush();
        bw.close();
    }
}