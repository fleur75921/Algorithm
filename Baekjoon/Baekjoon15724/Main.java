import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] pSum = new int[N+1][M+1];
        for(int i=1;i<=N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1;j<=M;j++) {
        		pSum[i][j] = pSum[i][j-1] + Integer.parseInt(st.nextToken());
        	}
        	for(int j=1;j<=M;j++) {
        		pSum[i][j] += pSum[i-1][j];
        	}
        }
        int K = Integer.parseInt(br.readLine());
        int x1, y1, x2, y2;
        for(int i=0;i<K;i++) {
        	st = new StringTokenizer(br.readLine());
        	x1 = Integer.parseInt(st.nextToken());
        	y1 = Integer.parseInt(st.nextToken());
        	x2 = Integer.parseInt(st.nextToken());
        	y2 = Integer.parseInt(st.nextToken());
        	sb.append(pSum[x2][y2] - pSum[x2][y1-1] - pSum[x1-1][y2] + pSum[x1-1][y1-1] +"\n");
        }
        System.out.print(sb);
        br.close();
    }
}
