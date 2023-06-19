import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dr = {-1, 1, 0, 0, 0, 0};
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	
	static class Point {
		int r;
		int c;
		int z;
		
		Point(int r, int c, int z) {
			this.r = r;
			this.c = c;
			this.z = z;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][][] box = new int[N][M][H];
		int blank = 0, input, time = -1, size, nr, nc, nz;
		ArrayList<Point> ones = new ArrayList<>();
		Point cur;
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<M;k++) {
					input = Integer.parseInt(st.nextToken());
					box[j][k][i] = input;
					if(input == -1) {
						blank++;
					}
					if(input == 1) {
						ones.add(new Point(j, k, i));
					}
				}
			}
		}
		int cnt = ones.size();
		LinkedList<Point> queue = new LinkedList<>();
		for(int i=0;i<ones.size();i++) {
			queue.offer(ones.get(i));
		}
		while(!queue.isEmpty()) {
			size = queue.size();
			time++;
			for(int i=0;i<size;i++) {
				cur = queue.poll();
				for(int j=0;j<6;j++) {
					nr = cur.r + dr[j];
					nc = cur.c + dc[j];
					nz = cur.z + dz[j];
					if(nr >= 0 && nc >= 0 && nz >= 0 && nr < N && nc < M && nz < H && box[nr][nc][nz] == 0) {
						cnt++;
						box[nr][nc][nz] = 1;
						queue.offer(new Point(nr, nc, nz));
					}
				}
			}
		}
		if(N*M*H - blank != cnt) {
			System.out.println(-1);
		} else {
			System.out.println(time);
		}
		br.close();
	}
}
