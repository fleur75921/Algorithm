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
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int input, nr, nc, size, cnt = 0;
		LinkedList<Point> q = new LinkedList<>();
		Point cur;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				input = Integer.parseInt(st.nextToken());
				if(input == 2) {
					q.offer(new Point(i, j));
					map[i][j] = 0;
				} else {
					map[i][j] = -1 * input;
				}
			}
		}
		while(!q.isEmpty()) {
			size = q.size();
			cnt++;
			for(int k=0;k<size;k++) {
				cur = q.poll();
				for(int i=0;i<4;i++) {
					nr = cur.r + dr[i];
					nc = cur.c + dc[i];
					if(nr>=0 && nc>=0 && nr<n && nc<m && map[nr][nc] == -1) {
						q.offer(new Point(nr, nc));
						map[nr][nc] = cnt;
					}
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
