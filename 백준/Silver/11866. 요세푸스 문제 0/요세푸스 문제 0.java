
import java.io.*;
import java.util.*;


public class Main {

    public static List<Integer> josephus(int n, int k) {
        List<Integer> origin = new ArrayList<>();
        List<Integer> josephus = new ArrayList<>();

        int index = 0;  // index 는 0 ~ n, k를 더해서 n이 넘어가면 %n
        for (int i = 1; i <= n; i++) {
            origin.add(i);
        }
        
        while (!origin.isEmpty()) {
            index = (index + k - 1) % origin.size();
            josephus.add(origin.get(index));
            origin.remove(index);
        }

        return josephus;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens;

        tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);

        List<Integer> lists = josephus(n, k);
        
        String result = "<" + lists.toString().replace("[", "")
                .replace("]", "") + ">";
        System.out.println(result);

        br.close(); // BufferedReader 닫기
        //bw.flush();
        //bw.close();
    }
}
