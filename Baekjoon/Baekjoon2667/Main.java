import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static boolean[][] map;
	static int cnt;
	
	static void dfs(int r, int c, int N) {
		map[r][c] = false;
		cnt++;
		int nr, nc;
		for(int i=0;i<4;i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
                if(map[nr][nc])
				    dfs(nr, nc, N);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str;
		map = new boolean[N][N];
		for(int i=0;i<N;i++) {
			str = br.readLine();
			for(int j=0;j<N;j++) {
				if(str.charAt(j) == '1') {
					map[i][j] = true;
				}
			}
			
		}
		int area_cnt = 0;
		ArrayList<Integer> house_cnt = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]) {
					area_cnt++;
					cnt = 0;
					dfs(i, j, N);
					house_cnt.add(cnt);
				}
			}
		}
		house_cnt.sort(null);
		System.out.println(area_cnt);
		for(int i=0;i<house_cnt.size();i++) {
			System.out.println(house_cnt.get(i));
		}
		br.close();
	}
}
