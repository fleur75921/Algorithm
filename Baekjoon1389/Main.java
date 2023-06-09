import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] dist = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				dist[i][j] = 10000;
			}
		}
		int A, B;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken())-1;
			B = Integer.parseInt(st.nextToken())-1;
			dist[A][B] = 1;
			dist[B][A] = 1;
		}
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i != j) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int tmp;
		int result = 0;
		for(int i=0;i<N;i++) {
			tmp = 0;
			for(int j=0;j<N;j++) {
				if(i != j) {
					tmp += dist[i][j];
				}
			}
			if(tmp < min) {
				min = tmp;
				result = i+1;
			}
		}
		System.out.println(result);
		br.close();
	}
}
