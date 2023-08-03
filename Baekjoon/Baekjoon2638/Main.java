import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	
	static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	static int N, M;
	static int now, prev;
	static int cheeseCnt;
	
	static void getAir(int r, int c) {
		int nr, nc;
		for(int i=0;i<4;i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
				continue;
			}
			if(map[nr][nc] != 1 && map[nr][nc] != now) {
				map[nr][nc] = now;
				getAir(nr, nc);
			}
		}
	}
	
	static boolean check(Point p) {
		int cnt = 0, nr, nc;
		for(int i=0;i<4;i++) {
			nr = p.r + dr[i];
			nc = p.c + dc[i];
			if(map[nr][nc] == now) {
				cnt++;
				if(cnt >= 2) {
					map[p.r][p.c] = -1;
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		now = 2;
		prev = 3;
		cheeseCnt = 0;
		ArrayList<Point> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					list.add(new Point(i, j));
					cheeseCnt++;
				}
			}
		}
		int res = 0;
		while(cheeseCnt != 0) {
			getAir(0, 0);
			int idx = 0;
			int size = list.size();
			for(int i=0;i<size;i++) {
				if(check(list.get(idx))) {
					list.remove(idx);
					cheeseCnt--;
				} else {
					idx++;
				}
			}
			now = now == 2 ? 3 : 2;
			prev = now == 2 ? 3 : 2;
			res++;
		}
		System.out.println(res);
		br.close();
	}
}
