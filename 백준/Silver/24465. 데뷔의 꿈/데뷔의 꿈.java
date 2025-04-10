import java.io.*;
import java.util.*;


public class Main {

    public static enum Zodiac {
        AQUARIUS(1, 20, 2, 18),
        PISCES(2, 19, 3, 20),
        ARIES(3, 21, 4, 19),
        TAURUS(4, 20, 5, 20),
        GEMINI(5, 21, 6, 21),
        CANCER(6, 22, 7, 22),
        LEO(7, 23, 8, 22),
        VIRGO(8, 23, 9, 22),
        LIBRA(9, 23, 10, 22),
        SCORPIO(10, 23, 11, 22),
        SAGITTARIUS(11, 23, 12, 21),
        CAPRICORN(12, 22, 1, 19);


        private final int startMonth;
        private final int startDay;
        private final int endMonth;
        private final int endDay;

        Zodiac(int startMonth, int startDay, int endMonth, int endDay) {
            this.startMonth = startMonth;
            this.startDay = startDay;
            this.endMonth = endMonth;
            this.endDay = endDay;
        }

        public static Zodiac getZodiac(int month, int day) {
            for (Zodiac zodiac : Zodiac.values()) {
                if (zodiac.isInRange(month, day)) {
                    return zodiac;
                }
            }
            throw new IllegalArgumentException("Invalid date: " + month + "/" + day);
        }

        private boolean isInRange(int month, int day) {
            if (month > this.startMonth && month < this.endMonth) {
                return true;
            }
            if (month == this.startMonth && day >= this.startDay) {
                return true;
            }
            if (month == this.endMonth && day <= this.endDay) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens;

        String[] inputZodiacs = {"AQUARIUS", "PISCES", "ARIES", "TAURUS", "GEMINI",
                "CANCER", "LEO", "VIRGO", "LIBRA", "SCORPIO", "SAGITTARIUS", "CAPRICORN"};

        Map<String, Integer> counts = new HashMap<>();
        for (String zodiac : inputZodiacs) {
            counts.put(zodiac, 0);
        }

        //기존 멤버 별자리
        for (int i = 0; i < 7; i++) {
            tokens = br.readLine().split(" ");
            String zodiac = String.valueOf(Zodiac.getZodiac(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));

            counts.put(zodiac, counts.get(zodiac) + 1);
        }

        int n = Integer.parseInt(br.readLine());
        List<String> pass = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String birth = br.readLine();
            tokens = birth.split(" ");
            String zodiac = String.valueOf(Zodiac.getZodiac(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])));

            if (counts.get(zodiac) == 0){
                pass.add(birth);
            }
        }

        pass.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] date1 = o1.split(" ");
                String[] date2 = o2.split(" ");
                int month1 = Integer.parseInt(date1[0]);
                int day1 = Integer.parseInt(date1[1]);
                int month2 = Integer.parseInt(date2[0]);
                int day2 = Integer.parseInt(date2[1]);

                if (month1 != month2) {
                    return month1 - month2;
                }

                return day1 - day2;
            }
        });

        if (pass.isEmpty()){
            System.out.println("ALL FAILED");
        }
        else {
            for (String s : pass) {
                System.out.println(s);
            }
        }

        br.close(); // BufferedReader 닫기
        //bw.flush();
        //bw.close();
    }
}