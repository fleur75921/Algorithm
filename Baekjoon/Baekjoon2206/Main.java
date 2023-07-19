import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	
	static class Dozer {
		int r;
		int c;
		boolean used;
		
		public Dozer(int r, int c, boolean used) {
			this.r = r;
			this.c = c;
			this.used = used;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		String str;
		for(int i=0;i<N;i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		LinkedList<Dozer> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		boolean[][] visited2 = new boolean[N][M];
		Dozer cur;
		q.offer(new Dozer(0, 0, false));
		visited[0][0] = true;
		int nr, nc, size, cnt = 0;
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		boolean found = false;
		loop:
		while(!q.isEmpty()) {
			size = q.size();
			cnt++;
			for(int t=0;t<size;t++) {
				cur = q.poll();
				if(cur.r == N-1 && cur.c == M-1) {
					found = true;
					break loop;
				}
				for(int i=0;i<4;i++) {
					nr = cur.r + dr[i];
					nc = cur.c + dc[i];
					if(nr<0 || nc<0 || nr>=N || nc>=M || visited[nr][nc]) {
						continue;
					}
					if(visited2[nr][nc] && cur.used) {
						continue;
					}
					if(map[nr][nc] == 1 && !cur.used) {
						q.offer(new Dozer(nr, nc, true));
					}
					if(map[nr][nc] == 0) {
						if(cur.used) {
							visited2[nr][nc] = true;
						} else {
							visited[nr][nc] = true;
							visited2[nr][nc] = true;
						}
						q.offer(new Dozer(nr, nc, cur.used));
					}
				}
			}
		}
		System.out.println(found ? cnt : -1);
		br.close();
	}
}
