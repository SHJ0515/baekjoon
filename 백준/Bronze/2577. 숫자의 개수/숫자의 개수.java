import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //StringTokenizer st = new StringTokenizer(br.readLine());

        int[] count = new int[10]; // 0~9 횟수

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int num = a * b * c;

        while (num > 0){
            int last = num % 10;
            count[last]++;
            num = num / 10;
        }

        for (int i : count) {
            System.out.println(i);
        }

        bw.flush();
        bw.close();
    }
}