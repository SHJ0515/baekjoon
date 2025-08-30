
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        Map<Integer, Set<String>> wordMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int len = s.length();

            // key에 len 이 없으면 새로운 TreeSet 생성, 있으면 기존거 가져오기.
            // TreeSet 은 넣을때부터 중복제거 및 사전순 정렬 해줌. 
            wordMap.computeIfAbsent(len, k -> new TreeSet<>()).add(s);
        }

        for (Set<String> value : wordMap.values()) {
            for (String s : value) {
                System.out.println(s);
            }
        }
    }
}
