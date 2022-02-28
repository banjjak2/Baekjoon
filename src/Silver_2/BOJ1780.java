package Silver_2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780 {
    static int N = 0;
    static int[][] matrix = null;
    static int countOfPositive = 0;
    static int countOfNegative = 0;
    static int countOfZero = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        StringTokenizer st = null;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0, 0, N);

        StringBuilder sb = new StringBuilder();
        sb.append(countOfNegative).append('\n');
        sb.append(countOfZero).append('\n');
        sb.append(countOfPositive).append('\n');
        System.out.println(sb);
    }

    private static void recursive(int x, int y, int n) {
        if (checkMatrix(x, y, n)) {
            if (matrix[y][x] == 1) countOfPositive++;
            else if (matrix[y][x] == 0) countOfZero++;
            else if (matrix[y][x] == -1) countOfNegative++;
            return;
        }

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                recursive(x + (n/3) * j, y + (n/3) * i, n/3);
            }
        }
    }

    private static boolean checkMatrix(int x, int y, int n) {
        int tmpData = matrix[y][x];
        for(int i=y; i<n + y; i++) {
            for (int j=x; j<n + x; j++) {
                if (tmpData != matrix[i][j]) return false;
            }
        }

        return true;
    }
}
