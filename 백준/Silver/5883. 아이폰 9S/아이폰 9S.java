
import java.io.*;
import java.util.*;

public class Main {

    public static int findMax(int max, List<Integer> list, Integer setNum) {
        int count = 0;

        while (list.remove(Integer.valueOf(setNum))) {
        }

        int tmpMax = 1;
        int currentMax = 1;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                currentMax++;
            }
            else {
                tmpMax = Math.max(tmpMax,currentMax);
                currentMax = 1;
            }
        }

        tmpMax = Math.max(tmpMax,currentMax);
        return Math.max(tmpMax,max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int max = 0;

        Set<Integer> sets = new HashSet<>();
        List<Integer> lists = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            sets.add(tmp);
            lists.add(tmp);
        }

        for (Integer set : sets) {
            List<Integer> tmpList = new ArrayList<>(lists);
            max = findMax(max, tmpList, set);
        }

        System.out.println(max);

        br.close(); // BufferedReader 닫기
        //bw.flush();
        //bw.close();
    }
}