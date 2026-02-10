import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 인원 수, 방 최대인원
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[2][6];  // (0,0) ~ (0,5)은 여학생방, (1,0) ~ (1,5)는 남학생 방

        //필요한 방의 개수
        int room = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stringTokenizer.nextToken());  // 남 : 0, 여 : 1
            int y = Integer.parseInt(stringTokenizer.nextToken()) - 1;

            arr[s][y]++;

            if (arr[s][y] == k){
                room++;
                arr[s][y] = 0;
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if (arr[i][j] != 0){
                    room++;
                }
            }
        }

        System.out.println(room);

        bw.flush();
        bw.close();
    }
}
/*
여러 학년 같은장소로 수학여행시 1~6학년 학생들의 방배정
남학생과 여학생 방 따로, 한 방에는 같은 학년만, 한 방에 한명만 배정도 가능

한 방의 최대인원수 K, 조건에 맞게 모든 학생 배정을 위한 방의 최소 개수 구하기

N = 총 인원 수, K = 한 방의 최대인원수
N줄에 걸쳐 학생의 성별 S와 학년 Y 주어짐 (S : 여학생 = 0, 남학생 = 1, Y : 1 ~ 6)

2차원 배열 [2][6] 생성
[성별][학년] 에 맞게 ++, 만약 k명이 차면 0으로 만들고 room + 1
다 하고 나서 [2][6] 순회하며 0이 아니면 room + 1 
 */