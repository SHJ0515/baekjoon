import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int x = Integer.parseInt(split[1]);

        String[] split1 = br.readLine().split(" ");

        for (String s : split1) {
            int num = Integer.parseInt(s);
            if (num < x){
                sb.append(num+ " ");
            }
        }
        System.out.println(sb);
        
        bw.flush();
        bw.close();
    }
}