import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		Point cur = null;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'I') {
					cur = new Point(i, j);
				}
			}
		}
		LinkedList<Point> q = new LinkedList<>();
		q.offer(cur);
		map[cur.r][cur.c] = 'X';
		int nr, nc, cnt = 0;
		while(!q.isEmpty()) {
			cur = q.poll();
			for (int i = 0; i < 4; i++) {
				nr = cur.r + dr[i];
				nc = cur.c + dc[i];
				if(nr>=0 && nc>=0 && nr<N && nc<M && map[nr][nc] != 'X') {
					if(map[nr][nc] == 'P') {
						cnt++;
					}
					map[nr][nc] = 'X';
					q.offer(new Point(nr, nc));
				}
			}
		}
		System.out.println(cnt == 0 ? "TT" : cnt);
		br.close();
	}
}
