import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static class Point {
		int r;
		int c;
		int k;
		
		public Point(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		boolean[][] map = new boolean[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				if(st.nextToken().equals("1")) {
					map[i][j] = true;
				}
			}
		}
		LinkedList<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0, N));
		Point p;
		int white = 0;
		int blue = 0;
		loop:
		while(!q.isEmpty()) {
			p = q.poll();
			boolean color = map[p.r][p.c];
			for(int i=p.r;i<p.r+p.k;i++) {
				for(int j=p.c;j<p.c+p.k;j++) {
					if(color != map[i][j]) {
						q.offer(new Point(p.r, p.c, p.k/2));
						q.offer(new Point(p.r+p.k/2, p.c, p.k/2));
						q.offer(new Point(p.r, p.c+p.k/2, p.k/2));
						q.offer(new Point(p.r+p.k/2, p.c+p.k/2, p.k/2));
						continue loop;
					}
				}
			}
			if(color) {
				blue++;
			} else {
				white++;
			}
		}
		System.out.println(white);
		System.out.println(blue);
		br.close();
	}
}
