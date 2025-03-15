
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arrCount = new int[10]; // 0~9 나온 횟수 count
        int num = 1;

        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(br.readLine());
            num = num * n;
        }

        while (num != 0){
            int tmp = num % 10;
            num = num / 10;
            arrCount[tmp]++;
        }

        for (int i : arrCount) {
            System.out.println(i);
        }

        br.close(); // BufferedReader 닫기
        //bw.flush();
        //bw.close();
    }
}
