import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point implements Comparable<Point> {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Point o) {
			if(this.r == o.r) {
				return this.c-o.c;
			} else {
				return this.r-o.r;
			}
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	
	static int N, curR, curC, curS, curCnt;
	
	static int bfs() {
		LinkedList<Point> q = new LinkedList<>();
		PriorityQueue<Point> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[N][N];
		q.offer(new Point(curR, curC));
		Point cur;
		int res = 0;
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			time++;
			for(int i=0;i<size;i++) {
				cur = q.poll();
				for(int j=0;j<4;j++) {
					int nr = cur.r + dr[j];
					int nc = cur.c + dc[j];
					if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || map[nr][nc] > curS) {
						continue;
					}
					visited[nr][nc] = true;
					q.offer(new Point(nr, nc));
					if(map[nr][nc] > 0 && map[nr][nc] < curS) {
						pq.offer(new Point(nr, nc));
					}
				}
			}
			if(!pq.isEmpty()) {
				cur = pq.poll();
				curCnt++;
				if(curCnt == curS) {
					curS++;
					curCnt = 0;
				}
				curR = cur.r;
				curC = cur.c;
				res = time;
				map[cur.r][cur.c] = 0;
				break;
			}
		}
		if(res == 0) {
			return -1;
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					curR = i;
					curC = j;
					map[i][j] = 0;
				}
			}
		}
        int ans = 0;
        int tmp;
        curS = 2;
        curCnt = 0;
        while(true) {
        	tmp = bfs();
        	if(tmp == -1) {
        		break;
        	}
        	ans += tmp;
        }
        System.out.println(ans);
        br.close();
    }
}
