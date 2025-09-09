package array;

import java.util.Scanner;

public class Array2D03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean[][] paper = new boolean[100][100];

        int n = sc.nextInt(); // 색종이 수

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(); // 왼쪽부터 x
            int y = sc.nextInt(); // 아래쪽부터 y

            // 색종이 영역은 10x10
            for (int row = x; row < x + 10; row++) {
                for (int col = y; col < y + 10; col++) {
                    paper[row][col] = true; // 색종이 붙은 부분 표시
                }
            }
        }

        // 색종이로 덮인 영역 넓이 계산
        int area = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j]) {
                    area++;
                }
            }
        }

        System.out.println(area); // 최종 출력: 색종이로 덮인 넓이
    }
}
