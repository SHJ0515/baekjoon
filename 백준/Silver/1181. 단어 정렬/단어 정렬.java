
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        Map<Integer, List<String>> wordMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            //문자열 길이가 key로 있는 경우 -> 해당 value 리스트에 해당 string이 있다면 pass, 없다면 리스트에 넣기
            if (wordMap.containsKey(s.length())) {
                List<String> targetList = wordMap.get(s.length());
                if (!targetList.contains(s)) {
                    targetList.add(s);
                }
            }
            //문자열 길이가 key로 없는 경우 -> map에 새로 key value 삽입
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                wordMap.put(s.length(), list);
            }
        }

        for (List<String> value : wordMap.values()) {
            value.sort(Comparator.naturalOrder());
            for (String s : value) {
                System.out.println(s);
            }
        }

    }
}
