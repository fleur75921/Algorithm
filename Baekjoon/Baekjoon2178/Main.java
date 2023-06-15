import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Point {
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[N][M];
		String str;
		for(int i=0;i<N;i++) {
			str = br.readLine();
			for(int j=0;j<M;j++) {
				if(str.charAt(j) == '1') {
					map[i][j] = true;
				}
			}
		}
		int cnt = 0;
		LinkedList<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0));
		map[0][0] = false;
		int nr, nc, size;
		loop:
		while(!q.isEmpty()) {
			size = q.size();
			cnt++;
			for(int k=0;k<size;k++) {
				Point cur = q.poll();
				if(cur.r == N-1 && cur.c == M-1) {
					break loop;
				}
				for(int i=0;i<4;i++) {
					nr = cur.r + dr[i];
					nc = cur.c + dc[i];
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
						continue;
					}
					if(map[nr][nc]) {
						map[nr][nc] = false;
						q.offer(new Point(nr, nc));
					}
				}
			}
		}
		System.out.println(cnt);
		br.close();
	}
}
