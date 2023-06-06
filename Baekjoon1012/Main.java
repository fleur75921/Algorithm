import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static void dfs(int[][] map, int r, int c, int N, int M) {
		map[r][c] = 0;
		int nr, nc;
		for(int i=0;i<4;i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 1) {
				dfs(map, nr, nc, N, M);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			int sum = 0;
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			int r, c;
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				c = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j] != 0) {
						dfs(map, i, j, N, M);
						sum++;
					}
				}
			}
			sb.append(sum+"\n");
		}
		System.out.print(sb);
		br.close();
	}
}
