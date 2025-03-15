
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        String ab = a + b;
        
        int AB = Integer.parseInt(ab);
        int aa = Integer.parseInt(a);
        int bb = Integer.parseInt(b);
        int cc = Integer.parseInt(c);

        System.out.println(aa + bb - cc);
        System.out.println(AB - cc);

        br.close(); // BufferedReader 닫기
        //bw.flush();
        //bw.close();
    }
}