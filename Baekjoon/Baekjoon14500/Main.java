import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int[][] map;
	
	static int max, N, M;
	
	static boolean[][] inner;
	
	static void dfs(int n, int sum, int r, int c) {
		if(n == 4) {
			if(sum > max) {
				max = sum;
			}
			return;
		}
		int nr, nc;
		for(int i=0;i<4;i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(nr>=0 && nc>=0 && nr<N && nc<M && !inner[nr][nc]) {
				inner[nr][nc] = true;
				dfs(n+1, sum+map[nr][nc], nr, nc);
				inner[nr][nc] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		inner = new boolean[N][M];
		max = Integer.MIN_VALUE;
		int sum, nr, nc;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				inner[i][j] = true;
				dfs(1, map[i][j], i, j);
				inner[i][j] = false;
				for(int k=0;k<4;k++) {
					sum = map[i][j];
					for(int l=0;l<4;l++) {
						if(l == k) {
							continue;
						}
						nr = i + dr[l];
						nc = j + dc[l];
						if(nr>=0 && nc>=0 && nr<N && nc<M) {
							sum += map[nr][nc]; 
						}
					}
					if(sum > max) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
		br.close();
	}
}
