import java.io.*;
import java.util.*;

public class Main {

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            points.add(new Point(x, y));
        }

        points.sort(Comparator.comparingInt((Point p) -> p.x)
                .thenComparingInt(p -> p.y));

        for (Point point : points) {
            bw.write(point.x + " " + point.y + "\n");
        }

        br.close();
        bw.close();
    }
}

