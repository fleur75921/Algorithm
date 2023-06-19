import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
	
	static int lcd(int a, int b) {
		return a * b / gcd(a, b);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int M, N, x, y;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		boolean isFound;
		int cur;
		int nx, ny;
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			isFound = false;
			if(x >= y) {
				cur = x;
				ny = cur % N;
				if(ny == 0) {
					ny = N;
				}
				if(ny == y) {
					isFound = true;
					sb.append(x+"\n");
				}
				if(!isFound) {
					while(cur <= lcd(Math.max(M, N), Math.min(M, N))) {
						cur += M;
						ny = cur % N;
						if(ny == 0) {
							ny = N;
						}
						if(ny == y) {
							sb.append(cur+"\n");
							isFound = true;
							break;
						}
					}
				}
			} else {
				cur = y;
				nx = cur % M;
				if(nx == 0) {
					nx = M;
				}
				if(nx == x) {
					isFound = true;
					sb.append(y+"\n");
				}
				if(!isFound) {
					while(cur <= lcd(Math.max(M, N), Math.min(M, N))) {
						cur += N;
						nx = cur % M;
						if(nx == 0) {
							nx = M;
						}
						if(nx == x) {
							sb.append(cur+"\n");
							isFound = true;
							break;
						}
					}
				}
			}
			if(!isFound) {
				sb.append("-1\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
